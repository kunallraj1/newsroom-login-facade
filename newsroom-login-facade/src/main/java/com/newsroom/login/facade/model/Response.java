package com.newsroom.login.facade.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class Response<T> {

	@JsonProperty("success")
	private boolean success;
	@JsonProperty("data")
	private T data;
	
}
