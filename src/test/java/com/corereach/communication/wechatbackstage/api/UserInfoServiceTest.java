package com.corereach.communication.wechatbackstage.api;

import com.corereach.communication.wechatbackstage.WechatBackstageApplicationTests;
import com.corereach.communication.wechatbackstage.api.domain.FrontUserInfoVO;
import com.corereach.communication.wechatbackstage.api.domain.UserInfoVO;
import com.corereach.communication.wechatbackstage.utils.Md5Util;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2020/1/14 9:54
 * @Version V1.0
 **/
public class UserInfoServiceTest extends WechatBackstageApplicationTests {

    @Resource
    private UserInfoService userInfoService;

    @Test
    public void insertUserTest() {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUsername("123");
        userInfoVO.setPassword("234");
        userInfoVO.setCid("xjasgfa");
        FrontUserInfoVO frontUserInfoVO = userInfoService.insertUser(userInfoVO);
        System.out.println(frontUserInfoVO);
    }

    @Test
    public void checkPasswordTest() {
        FrontUserInfoVO frontUserInfoVO = userInfoService.checkPassword("123", Md5Util.getMd5Str("234"));
        System.out.println(frontUserInfoVO);
    }

}
