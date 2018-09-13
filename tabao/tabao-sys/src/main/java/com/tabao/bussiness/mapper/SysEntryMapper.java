package com.tabao.bussiness.mapper;

import java.util.List;

import com.tabao.bussiness.model.SysEntry;
import com.tabao.core.base.dao.BaseDao;

public interface SysEntryMapper extends BaseDao<SysEntry> {
    
	List<SysEntry> selectByDicCode(String dicCode);
}