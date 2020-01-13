package com.corereach.communication.wechatbackstage.dao;

import com.corereach.communication.wechatbackstage.dao.domain.ChatMsgInfo;
import com.corereach.communication.wechatbackstage.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : ga.zhang
 */
@Mapper
public interface ChatMsgInfoMapper extends MyMapper<ChatMsgInfo> {
}