package com.corereach.communication.wechatbackstage.api;

import com.corereach.communication.wechatbackstage.api.domain.vo.FrontUserInfoVO;
import com.corereach.communication.wechatbackstage.api.domain.vo.UserInfoVO;

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
     * @param userId 用户编号
     * @return UserInfoVO
     */
    UserInfoVO getUserInfoByUserId(String userId);

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return Boolean
     */
    Boolean usernameIsExist(String username);

    /**
     * 用户登录时，校验用户名和密码
     *
     * @param username 用户名
     * @param password 密码
     * @return UserInfoVO
     */
    FrontUserInfoVO checkPassword(String username, String password);

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return UserInfoVO
     */
    FrontUserInfoVO insertUser(UserInfoVO user);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return Boolean
     */
    UserInfoVO updateUserInfo(UserInfoVO user);
}
