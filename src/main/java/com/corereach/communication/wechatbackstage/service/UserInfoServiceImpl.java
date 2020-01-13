package com.corereach.communication.wechatbackstage.service;

import com.corereach.communication.wechatbackstage.api.UserInfoService;
import com.corereach.communication.wechatbackstage.api.domain.UserInfoVO;
import com.corereach.communication.wechatbackstage.component.UserInfoComponent;
import com.corereach.communication.wechatbackstage.component.domain.UserInfoDTO;
import com.corereach.communication.wechatbackstage.utils.ConvertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/23 14:56
 * @Version V1.0
 **/
@Service("userService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoComponent userInfoComponent;

    @Override
    public UserInfoVO getUserInfoByUserName(String username) {
        return ConvertUtil.convertDomain(UserInfoVO.class, userInfoComponent.getUserInfoByUserName(username));
    }

    @Override
    public Boolean isUsernameExist(String username) {
        return userInfoComponent.isUsernameExist(username);
    }

    @Override
    public UserInfoVO checkPassword(String username, String password) {
        return ConvertUtil.convertDomain(UserInfoVO.class, userInfoComponent.checkPassword(username, password));
    }

    @Override
    public UserInfoVO insertUser(UserInfoVO user) {
        return ConvertUtil.convertDomain(UserInfoVO.class,
                userInfoComponent.insertUser(ConvertUtil.convertDomain(UserInfoDTO.class, user)));
    }
}
