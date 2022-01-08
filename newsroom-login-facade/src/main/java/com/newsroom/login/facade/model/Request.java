package com.newsroom.login.facade.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Request {
	@JsonProperty(value = "mail")
	private String email;
	@JsonProperty(value = "mob")
	private String mob;
	@JsonProperty(value = "password")
	private String password;

}
