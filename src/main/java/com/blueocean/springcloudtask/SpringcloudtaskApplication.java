package com.blueocean.springcloudtask;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTask
@EnableBatchProcessing
public class SpringcloudtaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudtaskApplication.class, args);
	}

}
