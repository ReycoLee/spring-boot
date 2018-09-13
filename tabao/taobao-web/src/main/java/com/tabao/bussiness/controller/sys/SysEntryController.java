package com.tabao.bussiness.controller.sys;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabao.bussiness.model.SysEntry;
import com.tabao.bussiness.service.SysEntryService;
import com.tabao.core.base.BaseController;
import com.tabao.core.base.model.ResultMap;

/**
 *  条目controller
 * @author liqiang
 * @date 2018-09-11
 */
@RestController("/sysEntry")
public class SysEntryController extends BaseController<SysEntry, SysEntryService> {

	@GetMapping("/page")
	public ResultMap page(SysEntry sysEntry) {
		return ResultMap.success(this.getService().queryPageInfo(sysEntry));
	}

	@PostMapping("/save")
	public ResultMap save(SysEntry sysEntry) {
		return this.getService().save(sysEntry);
	}

	@PutMapping("/update")
	public ResultMap update(SysEntry sysEntry) {
		return this.getService().updateAll(sysEntry);
	}

	@DeleteMapping("/delete")
	public ResultMap delete(String id) {
		return this.getService().logicDelete(id);
	}
}
