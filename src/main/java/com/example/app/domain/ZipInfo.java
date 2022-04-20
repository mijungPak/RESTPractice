package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZipInfo {

	private String message;
	private Result[] results;
	private Integer status;

}
