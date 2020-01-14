package com.corereach.communication.wechatbackstage.dao;

import com.corereach.communication.wechatbackstage.WechatBackstageApplicationTests;
import com.corereach.communication.wechatbackstage.component.domain.UserInfoDTO;
import com.corereach.communication.wechatbackstage.dao.domain.UserInfo;
import com.corereach.communication.wechatbackstage.utils.ConvertUtil;
import com.corereach.communication.wechatbackstage.utils.Md5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2020/1/14 10:24
 * @Version V1.0
 **/
public class UserInfoMapperTest extends WechatBackstageApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void insertUser() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUsername("123");
        userInfoDTO.setPassword("234");
        userInfoDTO.setCid("xjasgfa");
        String id = "1";
        userInfoDTO.setNickName(userInfoDTO.getUsername());
        userInfoDTO.setFaceImage("");
        userInfoDTO.setFaceImageBig("");
        userInfoDTO.setPassword(Md5Util.getMd5Str(userInfoDTO.getPassword()));
        userInfoDTO.setQrcode("");
        userInfoDTO.setId(id);
        userInfoDTO.setIsDeleted(0L);
        int insert = userInfoMapper.insert(ConvertUtil.convertDomain(UserInfo.class, userInfoDTO));
//        if (userInfoMapper.insert(ConvertUtil.convertDomain(UserInfo.class, userInfoDTO)) <= 0){
//            throw new AiException(Constants.isGlobal, ChatCode.USER_REGISTER_FAILURE);
//        }
//        return userInfoDTO;
        System.out.println(insert);
    }
}
