package com.benno.train.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@SpringBootApplication
@ComponentScan("com.benno")
public class GatewayApplication {

	private static final Logger LOG = LoggerFactory.getLogger(GatewayApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GatewayApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("start success!");
		LOG.info("gateway address: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}

}
