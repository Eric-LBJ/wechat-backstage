package com.corereach.communication.wechatbackstage.controller;

import com.corereach.communication.wechatbackstage.api.UserInfoService;
import com.corereach.communication.wechatbackstage.api.domain.bo.UserInfoBO;
import com.corereach.communication.wechatbackstage.api.domain.vo.FrontUserInfoVO;
import com.corereach.communication.wechatbackstage.api.domain.vo.UserInfoVO;
import com.corereach.communication.wechatbackstage.comm.Constants;
import com.icode.rich.comm.AiCodes;
import com.icode.rich.comm.AiResult;
import com.icode.rich.exception.AiException;
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
        return userInfoService.registerOrLogin(user);
    }

    @PostMapping("/updateUserInfo")
    public AiResult<UserInfoVO> updateUserInfo(@RequestBody UserInfoBO user) {
        return userInfoService.updateUserInfo(user);
    }

    @PostMapping("/searchUser")
    public AiResult<FrontUserInfoVO> searchUser(String myUserId, String friendUsername) {
        try {
            return userInfoService.searchUserInfoByUserName(myUserId, friendUsername);
        } catch (AiException e) {
//            LOGGER.error(e.getMessage(), e);
//            throw new AiException(Constants.isGlobal, e.getCode(), e.getMessage(), e.getLocalizedMessage());
            return new AiResult<>(Constants.isGlobal, e.getCode(), e.getMessage(), e.getLocalizedMessage());
        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
            return new AiResult<>(Constants.isGlobal, AiCodes.SYSTEM_ERROR);
        }
    }

}
