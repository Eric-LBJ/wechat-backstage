package com.corereach.communication.wechatbackstage.controller;

import com.corereach.communication.wechatbackstage.api.UserInfoService;
import com.corereach.communication.wechatbackstage.api.domain.UserInfoVO;
import com.corereach.communication.wechatbackstage.comm.ChatCode;
import com.corereach.communication.wechatbackstage.comm.Constants;
import com.corereach.communication.wechatbackstage.utils.Md5Util;
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
    private AiResult<String> registerOrLogin(@RequestBody UserInfoVO user) {

        /*
         * 判断用户名密码不能为空
         */
        if (ObjectUtils.isEmpty(user) || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            throw new AiException(Constants.isGlobal, ChatCode.USERNAME_PASSWORD_CAN_NOT_BE_NULL);
        }

        /*
         * 判断用户是否存在，存在则登录，不存在则注册
         */
        UserInfoVO userInfoVO;
        if (userInfoService.isUsernameExist(user.getUsername())) {
            /*
             * 登录流程
             */
            userInfoVO = userInfoService.checkPassword(user.getUsername(), Md5Util.getMd5Str(user.getPassword()));
            if (!ObjectUtils.isEmpty(userInfoVO) || !StringUtils.isEmpty(userInfoVO.getUsername())) {
                throw new AiException(Constants.isGlobal, ChatCode.USERNAME_OR_PASSWORD_ERROR);
            }
        } else {
            /*
             * 注册流程
             */
            userInfoVO = userInfoService.insertUser(user);

        }

        return new AiResult<>();
    }

}
