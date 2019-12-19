package com.corereach.communication.wechatbackstage.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/19 13:59
 * @Version V1.0
 **/
public class ConvertUtil {

    /**
     * 基本对象转换
     *
     * @param targetClazz
     * @param initObject
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object convertDomain(Class targetClazz, Object initObject) throws IllegalAccessException, InstantiationException {
        Object targetObject = targetClazz.newInstance();
        if (!ObjectUtils.isEmpty(initObject)) {
            BeanUtils.copyProperties(initObject, targetObject);
        }
        return targetObject;
    }

}
