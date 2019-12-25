package com.corereach.communication.wechatbackstage.comm;

import com.icode.rich.comm.AiCode;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/23 13:40
 * @Version V1.0
 **/
public class ChatCode {

    /**
     * user : 500100-500399
     */
    public static final AiCode USERNAME_PASSWORD_CAN_NOT_BE_NULL = new AiCode(500100, "username or password can not be null", "用户名或密码不能为空");
    public static final AiCode USERNAME_OR_PASSWORD_ERROR = new AiCode(500101, "username or password error", "用户名或密码错误");
    public static final AiCode USER_REGISTER_FAILURE = new AiCode(500102, "user register failure", "用户注册失败");

}
