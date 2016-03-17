package com.aepan.sysmgr.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aepan.sysmgr.service.HttpCallService;

/**
 * 分布式 单节点运行
 * @author Doris
 * 2015年11月2日下午3:18:10
 */
@Component("packageTask")
public class PackageTask {

	@Autowired
	private HttpCallService httpCallService;

	@Scheduled(fixedRateString="7200000",initialDelayString="10000")
	public void run(){
		httpCallService.sendPackageDueTips();
	}
}
