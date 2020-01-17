package com.corereach.communication.wechatbackstage.controller;

import com.corereach.communication.wechatbackstage.api.UserInfoService;
import com.corereach.communication.wechatbackstage.api.domain.bo.UserInfoBO;
import com.corereach.communication.wechatbackstage.api.domain.vo.FrontUserInfoVO;
import com.corereach.communication.wechatbackstage.api.domain.vo.UserInfoVO;
import com.icode.rich.comm.AiResult;
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
    public AiResult<UserInfoVO> updateUserInfo(@RequestBody UserInfoBO user){
        return userInfoService.updateUserInfo(user);
    }

    @PostMapping("/searchUser")
    public AiResult<UserInfoVO> searchUser(String myUserId, String friendUsername) {
        return null;
    }

}
