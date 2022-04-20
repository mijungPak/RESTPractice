package com.example.app.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplateBuilder builder = new RestTemplateBuilder();
		return builder.build();
	}

	@Bean
	//参考サイト
	//https://gist.github.com/keiyonekawa0614/628ed396b78497e55bad0508a287e80e
  public RestTemplate zipCodeSearchRestTemplate() {
      RestTemplate restTemplate = new RestTemplate();
      MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
      List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());
      supportedMediaTypes.add(MediaType.TEXT_PLAIN); // text/plainのJacksonの処理対象にくわえる
      messageConverter.setSupportedMediaTypes(supportedMediaTypes);
      restTemplate.setMessageConverters(Collections.singletonList(messageConverter)); // カスタムしたHttpMessageConverterを適用
      return restTemplate;
  }
}
