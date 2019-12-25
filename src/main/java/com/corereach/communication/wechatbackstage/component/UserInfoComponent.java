package com.corereach.communication.wechatbackstage.component;

import com.corereach.communication.wechatbackstage.component.domain.UserInfoDTO;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/23 14:58
 * @Version V1.0
 **/
public interface UserInfoComponent {

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return
     */
    UserInfoDTO getUserInfoByUserName(String username);

    /**
     * 判断用户是否存在
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
    UserInfoDTO checkPassword(String username, String password);

}
