package com.tabao.core.base.dao;

import com.tabao.core.base.model.BaseModel;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * @author liqiang
 * @date 2018-09-07
 * @param <T>
 */
public interface BaseDao<T extends BaseModel> extends Mapper<T>, MySqlMapper<T> {

}
