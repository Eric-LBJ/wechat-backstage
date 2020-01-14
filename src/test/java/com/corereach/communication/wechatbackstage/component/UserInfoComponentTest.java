package com.corereach.communication.wechatbackstage.component;

import com.corereach.communication.wechatbackstage.WechatBackstageApplicationTests;
import com.corereach.communication.wechatbackstage.comm.ChatCode;
import com.corereach.communication.wechatbackstage.comm.Constants;
import com.corereach.communication.wechatbackstage.component.domain.UserInfoDTO;
import com.corereach.communication.wechatbackstage.dao.UserInfoMapper;
import com.corereach.communication.wechatbackstage.dao.domain.UserInfo;
import com.corereach.communication.wechatbackstage.utils.ConvertUtil;
import com.corereach.communication.wechatbackstage.utils.Md5Util;
import com.icode.rich.exception.AiException;
import org.junit.Test;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/23 14:59
 * @Version V1.0
 **/
@Component
public class UserInfoComponentTest extends WechatBackstageApplicationTests {

    @Autowired
    private UserInfoComponent userInfoComponent;

    @Test
    public void insertUser() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUsername("123");
        userInfoDTO.setPassword("234");
        userInfoDTO.setCid("xjasgfa");
        UserInfoDTO userInfoDTO1 = userInfoComponent.insertUser(userInfoDTO);
        System.out.println(userInfoDTO1);
    }
}
