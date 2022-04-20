package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

	private String date;
	private String telop;
	private IconImage image;

}
