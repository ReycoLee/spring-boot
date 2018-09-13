package com.tabao.bussiness.service.impl;

import org.springframework.stereotype.Service;

import com.tabao.bussiness.mapper.DemoMapper;
import com.tabao.bussiness.model.Demo;
import com.tabao.bussiness.service.DemoService;
import com.tabao.core.base.service.impl.BaseServiceImpl;

@Service
public class DemoServiceImpl extends BaseServiceImpl<Demo, DemoMapper> implements DemoService {

}
