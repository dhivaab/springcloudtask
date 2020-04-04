package com.blueocean.springcloudtask;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTask
@EnableBatchProcessing
public class SpringcloudtaskApplication {

	public static void main(String[] args) {
		System.out.println("here is your ouput" + args[0]);
		SpringApplication.run(SpringcloudtaskApplication.class, args);
	}

}
