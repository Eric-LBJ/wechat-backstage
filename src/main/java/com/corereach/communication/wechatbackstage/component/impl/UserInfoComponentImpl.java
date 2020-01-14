package com.corereach.communication.wechatbackstage.component.impl;

import com.corereach.communication.wechatbackstage.comm.ChatCode;
import com.corereach.communication.wechatbackstage.comm.Constants;
import com.corereach.communication.wechatbackstage.component.UserInfoComponent;
import com.corereach.communication.wechatbackstage.component.domain.UserInfoDTO;
import com.corereach.communication.wechatbackstage.dao.UserInfoMapper;
import com.corereach.communication.wechatbackstage.dao.domain.UserInfo;
import com.corereach.communication.wechatbackstage.utils.ConvertUtil;
import com.corereach.communication.wechatbackstage.utils.Md5Util;
import com.icode.rich.exception.AiException;
import org.n3r.idworker.Sid;
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
public class UserInfoComponentImpl implements UserInfoComponent {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private Sid sid;

    @Override
    public UserInfoDTO getUserInfoByUserName(String username) {
        UserInfo info = new UserInfo();
        info.setUsername(username);
        return ConvertUtil.convertDomain(UserInfoDTO.class,
                Optional.ofNullable(userInfoMapper.selectOne(info)).orElse(new UserInfo()));
    }

    @Override
    public Boolean usernameIsExist(String username) {
        UserInfo info = new UserInfo();
        info.setUsername(username);
        UserInfo userInfo = userInfoMapper.selectOne(info);
        return !ObjectUtils.isEmpty(userInfo) && !StringUtils.isEmpty(userInfo.getUsername());
    }

    @Override
    public UserInfoDTO checkPassword(String username, String password) {
        Example userExample = new Example(UserInfo.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", Md5Util.getMd5Str(password));
        return ConvertUtil.convertDomain(UserInfoDTO.class,
                Optional.ofNullable(userInfoMapper.selectOneByExample(userExample)).orElse(new UserInfo()));
    }

    @Override
    public UserInfoDTO insertUser(UserInfoDTO userInfoDTO) {
        String id = sid.nextShort();
        userInfoDTO.setNickName(userInfoDTO.getUsername());
        userInfoDTO.setFaceImage("");
        userInfoDTO.setFaceImageBig("");
        userInfoDTO.setPassword(Md5Util.getMd5Str(userInfoDTO.getPassword()));
        userInfoDTO.setQrcode("");
        userInfoDTO.setId(id);
        userInfoDTO.setIsDeleted(0L);
        if (userInfoMapper.insert(ConvertUtil.convertDomain(UserInfo.class, userInfoDTO)) <= 0){
            throw new AiException(Constants.isGlobal, ChatCode.USER_REGISTER_FAILURE);
        }
        return userInfoDTO;
    }
}
