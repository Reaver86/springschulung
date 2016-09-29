package io.crowdcode.speedbay.auction.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static io.crowdcode.speedbay.common.AnsiColor.blue;

/**
 * Created by SU00079 on 29.09.2016.
 */
@Slf4j
@Configuration
@Import(BusinessLogicConfiguration.class)
public class LogBeanPostProcessorConfiguration implements BeanPostProcessor {

    @Bean
    public static LogBeanPostProcessorConfiguration logBeanPostProcessorConfiguration() {
        return new LogBeanPostProcessorConfiguration();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info(blue(beanName));
        return bean;
    }
}
