/**
 * 
 */
package com.aepan.sysmgr.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aepan.sysmgr.service.HttpCallService;

/**
 * 分布式 单节点运行
 * @author lanker
 * 2016年2月24日下午3:34:22
 */
@Component("FlowCountTask")
public class FlowCountTask {
	@Autowired
	private HttpCallService httpCallService;
	@Scheduled(fixedRateString="300000",initialDelayString="10000")
	public void run(){
		httpCallService.countUsedFlow();
	}
}
