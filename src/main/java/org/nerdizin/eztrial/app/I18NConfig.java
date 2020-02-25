package org.nerdizin.eztrial.app;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18NConfig {

	@Bean
	@Primary
	public MessageSource messageSource() {

		final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.addBasenames("classpath:messages/administration",
				"classpath:messages/error",
				"classpath:messages/common");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);

		return messageSource;
	}
}
