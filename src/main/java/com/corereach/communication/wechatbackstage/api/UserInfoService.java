package com.corereach.communication.wechatbackstage.api;

import com.corereach.communication.wechatbackstage.api.domain.UserInfoVO;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/23 14:55
 * @Version V1.0
 **/
public interface UserInfoService {

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return
     */
    UserInfoVO getUserInfoByUserName(String username);

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return
     */
    Boolean isUsernameExist(String username);

    /**
     * 用户登录时，校验用户名和密码
     *
     * @param username
     * @param password
     * @return
     */
    UserInfoVO checkPassword(String username, String password);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    UserInfoVO insertUser(UserInfoVO user);
}
