package com.corereach.communication.wechatbackstage.dao;

import com.corereach.communication.wechatbackstage.dao.domain.UserInfo;
import com.corereach.communication.wechatbackstage.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : ga.zhang
 */
@Mapper
public interface UserInfoMapper extends MyMapper<UserInfo> {
}