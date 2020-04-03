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

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableTask
@EnableBatchProcessing
public class SpringcloudtaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudtaskApplication.class, args);
	}
	
	/*@Bean
	public GreetingTask greetingtask() {
		return new GreetingTask();
	}
	@Bean
	public GreetingTask1 greetingtask1() {
		return new GreetingTask1();
	}


	public static class GreetingTask implements CommandLineRunner, TaskExecutionListener {

		@Override
		public void run(String... args) throws Exception {
			System.out.println("Hello World");
		}

		@Override
		public void onTaskStartup(TaskExecution taskExecution) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTaskEnd(TaskExecution taskExecution) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
			// TODO Auto-generated method stub
			
		}

	}
	public static class GreetingTask1 implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			System.out.println("Hello World1");
		}

	}
	*/

}
