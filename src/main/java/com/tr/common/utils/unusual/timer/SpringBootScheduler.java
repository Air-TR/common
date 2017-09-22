package com.tr.common.utils.unusual.timer;
/**
package com.tr.common.utils.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
 */

/**
 * SpringBoot定时器
 * 注: 要在SpringBoot启动类中加入 @EnableScheduling 注解
 * 经测试成功，SpringBoot项目启动后该类方法自动开始执行。
 * 
 * cron表达式在线生成器: http://cron.qqe2.com/
 * 0 0 * * * ? * -- 每个整点执行
 * 
 * @author taorun
 * @date 2017年9月14日 上午10:46:24
 *
 */

/**
@Component
public class SpringBootScheduler {

	public static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

	@Scheduled(cron = "0 0/1 * * * ?") // 每分钟执行一次
	public void statusCheck() {
		logger.info("每分钟执行一次。开始……");
		// statusTask.healthCheck();
		logger.info("每分钟执行一次。结束。");
	}

	@Scheduled(fixedRate = 1000) // 每秒执行一次
	public void testTasks() {
		logger.info("每2秒执行一次。开始……");
		// statusTask.healthCheck();
		logger.info("每2秒执行一次。结束。");
	}
	
}
*/