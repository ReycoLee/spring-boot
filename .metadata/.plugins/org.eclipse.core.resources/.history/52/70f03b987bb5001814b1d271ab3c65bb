package com.tabao.bussiness.controller.sys;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tabao.bussiness.model.SysDic;
import com.tabao.bussiness.service.SysDicService;
import com.tabao.core.base.BaseController;
import com.tabao.core.base.model.ResultMap;

/**
 * 字典controller
 * @author liqiang
 * @date 2018-09-10
 */
@RestController
@CrossOrigin
public class SysDicController extends BaseController<SysDic, SysDicService> {

	/**
	 * 分页查询
	 * @param sysDic
	 * @return
	 */
	@GetMapping("/sysDic/page")
	public ResultMap page(SysDic sysDic) {
		return ResultMap.success(getService().queryPageInfo(sysDic));
	}
	
	/**
	 * 保存单条数据
	 * @param sysDic
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/sysDic/save")
	public ResultMap save() {
		try {
			return this.getService().save(getBodyToBean(SysDic.class));
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMap.error("保存失败");
		}
	}
	
	/**
	 * 修改单条数据
	 * @param sysDic
	 * @return
	 */
	@PutMapping("/sysDic/update")
	public ResultMap update(SysDic sysDic) {
		return this.getService().updateAll(sysDic);
	}
	
	/**
	 * 逻辑删除单条数据
	 * @param id
	 * @return
	 */
	@DeleteMapping("/sysDic/delete")
	public ResultMap delete(String id) {
		return this.getService().logicDelete(id);
	}
}
