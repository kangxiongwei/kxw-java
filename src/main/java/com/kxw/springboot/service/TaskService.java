package com.kxw.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 测试bean加载
 *
 * @author kangxiongwei
 * @date 2020-04-16 17:15
 */
@Service
public class TaskService implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("初始化bean开始...");
        for (int i = 0; i < 10; i++) {
            LOGGER.info("正在加载数据{}...", i);
            Thread.sleep(1000);
        }
        LOGGER.info("初始化bean结束...");
    }

}
