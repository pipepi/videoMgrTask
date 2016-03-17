/**
 * 重新同步类目
 */
package com.aepan.sysmgr.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aepan.sysmgr.service.HttpCallService;

/**
 * 分布式 单节点运行
 * @author lanker
 * 2015年10月23日下午5:12:09
 */
@Component("ReloadCategory")
public class ReloadCategory {

	@Autowired
	private HttpCallService httpCallService;
	@Scheduled(fixedRateString="1800000",initialDelayString="10000")
	public void synchronous(){
		httpCallService.reloadCategory();
	}
}
