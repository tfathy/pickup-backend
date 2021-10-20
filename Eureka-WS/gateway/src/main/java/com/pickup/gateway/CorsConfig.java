package com.pickup.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class CorsConfig {
	@Bean
	public CorsWebFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("http://localhost");
		config.addAllowedOrigin("http://192.168.8.187:8100");
		config.addAllowedOrigin("http://192.168.42.63:8100");
		config.addAllowedOrigin("capacitor://localhost");
		config.addAllowedOrigin("https://sp.pickup-sa.net");
		config.addAllowedOrigin("https://owner.pickup-sa.net");	
		config.addAllowedOrigin("https://sp.pickup-sa.net");
		config.addAllowedOrigin("https://owner.pickup-sa.net");	
		config.addAllowedOrigin("http://localhost:8100");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		config.addExposedHeader("*");
		config.applyPermitDefaultValues();

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
		source.registerCorsConfiguration("/**", config);

		return new CorsWebFilter(source);
	}
}
