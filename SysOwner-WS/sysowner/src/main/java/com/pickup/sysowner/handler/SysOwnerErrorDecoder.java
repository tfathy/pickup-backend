package com.pickup.sysowner.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class SysOwnerErrorDecoder implements ErrorDecoder {

	private Environment env;

	@Autowired
	public SysOwnerErrorDecoder(Environment e) {
		this.env = e;
	}

	@Override
	public Exception decode(String methodKey, Response response) {

		switch (response.status()) {
		case 400:
			return new ResponseStatusException(HttpStatus.valueOf(response.status()),
					this.env.getProperty("sysowner.exception.400") + " " + methodKey);
		case 404:
			return new ResponseStatusException(HttpStatus.valueOf(response.status()),
					this.env.getProperty("sysowner.exception.404") + " " + methodKey);

		case 500:

			return new ResponseStatusException(HttpStatus.valueOf(response.status()),
					this.env.getProperty("sysowner.exception.500") + " " + methodKey);

		default:
			return new Exception(response.reason());

		}
		
	}

}
