package com.tabao.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabao.bussiness.mapper.SysDicMapper;
import com.tabao.bussiness.mapper.SysEntryMapper;
import com.tabao.bussiness.model.SysDic;
import com.tabao.bussiness.model.SysEntry;
import com.tabao.bussiness.service.SysDicService;
import com.tabao.core.base.model.ResultMap;
import com.tabao.core.base.service.impl.BaseServiceImpl;

@Service
public class SysDicServiceImpl extends BaseServiceImpl<SysDic, SysDicMapper> implements SysDicService {
	@Autowired
	private SysEntryMapper sysEntryMapper;
	
	@Override
	public ResultMap logicDelete(Object dicCode) {
		List<SysEntry> entryList = sysEntryMapper.selectByDicCode((String)dicCode);
		if(entryList != null && !entryList.isEmpty()) {
			return ResultMap.error("该字典已有条目，请先删除该字典下的所有条目!");
		}	
		return super.logicDelete(dicCode);
	}
	
	
}
