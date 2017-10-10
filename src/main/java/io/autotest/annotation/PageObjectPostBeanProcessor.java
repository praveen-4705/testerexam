package io.autotest.annotation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

public class PageObjectPostBeanProcessor implements BeanPostProcessor {
	private final Logger logger = Logger.getLogger(PageObjectPostBeanProcessor.class);
	@Autowired
	private ApplicationContext applicationContext;

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().isAnnotationPresent(PageObject.class)) {
			logger.info("Initialising page :: " + bean.getClass());
			WebDriver driver = applicationContext.getBean(WebDriver.class);
			PageFactory.initElements(driver, bean);
		}
		return bean;
	}
}
