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
    public static final AiCode USERNAME_PASSWORD_CAN_NOT_BE_NULL = new AiCode(500100, "The username or password can not be null", "用户名或密码不能为空");
    public static final AiCode USERNAME_OR_PASSWORD_ERROR = new AiCode(500101, "The username or password error", "用户名或密码错误");
    public static final AiCode USER_REGISTER_FAILURE = new AiCode(500102, "The user register failure", "用户注册失败");
    public static final AiCode USER_NOT_EXIST = new AiCode(500103, "The user does not exist, can not update", "用户信息不存在，不能进行修改操作");
    public static final AiCode FACE_IMAGE_UPLOAD_FAILURE = new AiCode(500104, "The user face image upload failure", "用户头像上传失败");
    public static final AiCode USER_INFO_UPDATE_FAILURE = new AiCode(500105, "The user info update failure", "用户信息修改失败");

}
