package ua.org.ostpc.ittools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@EnableJpaRepositories("ua.org.ostpc.ittools.dao")
@EntityScan("ua.org.ostpc.ittools.entity")
@SpringBootApplication
public class IttoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IttoolsApplication.class, args);
	}

	//Uploading files
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

}

