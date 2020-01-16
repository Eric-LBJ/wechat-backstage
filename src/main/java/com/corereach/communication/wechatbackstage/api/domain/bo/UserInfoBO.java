package com.corereach.communication.wechatbackstage.api.domain.bo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : ga.zhang
 */
@Data
@ToString
public class UserInfoBO implements Serializable {

    private static final long serialVersionUID = -2372000114719621133L;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户头像
     */
    private String faceData;

}