package com.corereach.communication.wechatbackstage.comm;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/19 19:28
 * @Version V1.0
 **/
public class Constants {

    /**
     * 国际化
     */
    public static Boolean isGlobal = Boolean.FALSE;
    /**
     * netty服务端口
     */
    public static final Integer SERVER_PORT = 8088;
    /**
     * http请求或响应最大长度
     */
    public static final Integer MAX_CONTENT_LENGTH = 65536;
    /**
     * webSocket路由地址
     */
    public static final String WEB_SOCKET_PATH = "/ws";
    /**
     * 缩略图尾缀
     */
    public static final String THUMP = "_80x80.";
    /**
     * 图片文件放置的本地文件夹
     */
    public static final String IMG_FILE_BASE_PATH = "F:\\";
    /**
     * 图片文件尾缀
     */
    public static final String IMG_FILE_SUFFIX = "userFaceImageBase64.png";
    /**
     * 分割符
     */
    public static final String SPILT_BASE = "\\.";
    /**
     * 默认字符串的值
     */
    public static final String DEFAULT_STRING_VALUE = "";

}
