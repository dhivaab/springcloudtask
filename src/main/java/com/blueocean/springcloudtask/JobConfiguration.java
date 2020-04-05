package com.blueocean.springcloudtask;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.blueocean.springcloudtask.config.ApplicationConfiguration;

@Configuration
public class JobConfiguration {

	private static final Log logger = LogFactory.getLog(JobConfiguration.class);

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ApplicationConfiguration appconfig;
	
	@Bean
	public Job job1() {
		return this.jobBuilderFactory.get("job1").start(this.stepBuilderFactory.get("job1step1").tasklet(new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				logger.info("Job1 was run");
				try {
					String url = appconfig.getMonthlyurl();
					
					// Prepare acceptable media type
					List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
					acceptableMediaTypes.add(MediaType.APPLICATION_JSON);

					// Prepare header
					HttpHeaders headers = new HttpHeaders();
					headers.setAccept(acceptableMediaTypes);

					// create http entity
					HttpEntity<String> entity = new HttpEntity<String>(headers);

					RestTemplate restTemplate = new RestTemplate();

					// Send the request as GET with no parameters
					ResponseEntity<byte[]> result = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

					logger.info("log is printed here " + result);

				} catch (HttpStatusCodeException ex) {
					logger.info("Error in this code " + ex.getStatusCode());
					logger.info("Error in this line " + ex.getStatusCode().toString());
				}
				return RepeatStatus.FINISHED;
			}
		}).build()).build();
	}

	@Bean
	public Job job2() {
		return this.jobBuilderFactory.get("job2").start(this.stepBuilderFactory.get("job2step1").tasklet(new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				logger.info("Job2 was run");
				return RepeatStatus.FINISHED;
			}
		}).build()).build();
	}
}