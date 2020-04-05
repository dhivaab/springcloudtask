package com.blueocean.springcloudtask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration {
	@Value("${monthlyurl}")
	private String monthlyurl;

	public String getMonthlyurl() {
		return monthlyurl;
	}

	public void setMonthlyurl(String monthlyurl) {
		this.monthlyurl = monthlyurl;
	}
}
