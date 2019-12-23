package com.corereach.communication.wechatbackstage.comm;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/23 9:38
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
public class CommResult {

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;

    private String ok;

    public static CommResult build(Integer code, String message, Object data) {
        return new CommResult(code, message, data);
    }

    public static CommResult ok(Object data) {
        return new CommResult(data);
    }

    public static CommResult ok() {
        return new CommResult(null);
    }

    public static CommResult errorMsg(String message) {
        return new CommResult(500, message, null);
    }

    public static CommResult errorMap(Object data) {
        return new CommResult(501, "error", data);
    }

    public static CommResult errorTokenMsg(String message) {
        return new CommResult(502, message, null);
    }

    public static CommResult errorException(String message) {
        return new CommResult(555, message, null);
    }

    public CommResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommResult(Object data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.code == 200;
    }

}
