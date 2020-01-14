package com.corereach.communication.wechatbackstage.controller;

import com.corereach.communication.wechatbackstage.api.UserInfoService;
import com.corereach.communication.wechatbackstage.api.domain.FrontUserInfoVO;
import com.corereach.communication.wechatbackstage.api.domain.UserInfoVO;
import com.corereach.communication.wechatbackstage.comm.ChatCode;
import com.corereach.communication.wechatbackstage.comm.Constants;
import com.icode.rich.comm.AiResult;
import com.icode.rich.exception.AiException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/registerOrLogin")
    public AiResult<FrontUserInfoVO> registerOrLogin(@RequestBody UserInfoVO user) {
        /*
         * 判断用户名密码不能为空
         */
        if (ObjectUtils.isEmpty(user) || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            throw new AiException(Constants.isGlobal, ChatCode.USERNAME_PASSWORD_CAN_NOT_BE_NULL);
        }

        /*
         * 判断用户是否存在，存在则登录，不存在则注册
         */
        FrontUserInfoVO frontUserInfoVO;
        if (userInfoService.usernameIsExist(user.getUsername())) {
            /*
             * 登录流程
             */
            frontUserInfoVO = userInfoService.checkPassword(user.getUsername(), user.getPassword());
            if (ObjectUtils.isEmpty(frontUserInfoVO) || StringUtils.isEmpty(frontUserInfoVO.getUsername())) {
                throw new AiException(Constants.isGlobal, ChatCode.USERNAME_OR_PASSWORD_ERROR);
            }
        } else {
            /*
             * 注册流程
             */
            frontUserInfoVO = userInfoService.insertUser(user);
            System.out.println(frontUserInfoVO.toString());
        }
        return new AiResult<>(Constants.isGlobal, frontUserInfoVO);
    }

}
