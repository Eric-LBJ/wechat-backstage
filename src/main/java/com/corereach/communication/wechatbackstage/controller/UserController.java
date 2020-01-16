package com.corereach.communication.wechatbackstage.controller;

import com.corereach.communication.wechatbackstage.api.UserInfoService;
import com.corereach.communication.wechatbackstage.api.domain.bo.UserInfoBO;
import com.corereach.communication.wechatbackstage.api.domain.vo.FrontUserInfoVO;
import com.corereach.communication.wechatbackstage.api.domain.vo.UserInfoVO;
import com.corereach.communication.wechatbackstage.comm.ChatCode;
import com.corereach.communication.wechatbackstage.comm.Constants;
import com.corereach.communication.wechatbackstage.utils.FastDFSClient;
import com.corereach.communication.wechatbackstage.utils.FileUtils;
import com.icode.rich.comm.AiCodes;
import com.icode.rich.comm.AiResult;
import com.icode.rich.exception.AiException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/19 11:24
 * @Version V1.0
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private FastDFSClient fastDfsClient;

    @PostMapping("/registerOrLogin")
    public AiResult<FrontUserInfoVO> registerOrLogin(@RequestBody UserInfoVO user) {
        /**
         * 判断用户名密码不能为空
         */
        if (ObjectUtils.isEmpty(user) || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            throw new AiException(Constants.isGlobal, ChatCode.USERNAME_PASSWORD_CAN_NOT_BE_NULL);
        }

        /**
         * 判断用户是否存在，存在则登录，不存在则注册
         */
        FrontUserInfoVO frontUserInfoVO;
        if (userInfoService.usernameIsExist(user.getUsername())) {
            /**
             * 登录流程
             */
            frontUserInfoVO = userInfoService.checkPassword(user.getUsername(), user.getPassword());
            if (ObjectUtils.isEmpty(frontUserInfoVO) || StringUtils.isEmpty(frontUserInfoVO.getUsername())) {
                throw new AiException(Constants.isGlobal, ChatCode.USERNAME_OR_PASSWORD_ERROR);
            }
        } else {
            /**
             * 注册流程
             */
            frontUserInfoVO = userInfoService.insertUser(user);
            System.out.println(frontUserInfoVO.toString());
        }
        return new AiResult<>(Constants.isGlobal, frontUserInfoVO);
    }

    @PostMapping("/fileUpload")
    public AiResult<UserInfoVO> fileUpload(@RequestBody UserInfoBO user) throws Exception {
        /**获取前端传来的base64字符串转换成文件上传*/
        String base64Data = user.getFaceData();
        String userFaceImagePath = Constants.IMG_FILE_BASE_PATH + user.getUserId() + Constants.IMG_FILE_SUFFIX;
        FileUtils.base64ToFile(userFaceImagePath, base64Data);

        /**上传文件到fastDFS*/
        MultipartFile faceImageFile = FileUtils.fileToMultipart(userFaceImagePath);
        String url = !ObjectUtils.isEmpty(faceImageFile) ? fastDfsClient.uploadBase64(faceImageFile) : Constants.DEFAULT_STRING_VALUE;
        System.out.println(url);

        /**获取缩略图的url*/
        String[] arr = url.split(Constants.SPILT_BASE);
        String thumpImgUrl = arr[0] + Constants.THUMP + arr[1];

        /**更新用户头像*/
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId(user.getUserId());
        userInfoVO.setFaceImage(thumpImgUrl);
        userInfoVO.setFaceImageBig(url);
        UserInfoVO result = userInfoService.updateUserInfo(userInfoVO);
        /**未更新成功，抛出异常*/
        if (ObjectUtils.isEmpty(result) || StringUtils.isEmpty(result.getId())) {
            throw new AiException(Constants.isGlobal, AiCodes.SYSTEM_ERROR.getCode(), "upLoad Failure", "头像上传失败");
        }

        return new AiResult<>(Constants.isGlobal, result);
    }

}
