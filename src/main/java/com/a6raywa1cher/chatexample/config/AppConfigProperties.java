package com.a6raywa1cher.chatexample.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "app")
@Validated
@Data
public class AppConfigProperties {
	@NotNull
	private String[] allowedOrigins;
}
