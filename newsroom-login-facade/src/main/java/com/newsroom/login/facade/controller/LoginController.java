package com.newsroom.login.facade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newsroom.login.facade.NewsroomLoginFacadeApplication;
import com.newsroom.login.facade.enums.ErrorCode;
import com.newsroom.login.facade.exception.LoginException;
import com.newsroom.login.facade.model.Data;
import com.newsroom.login.facade.model.Request;
import com.newsroom.login.facade.model.Response;
import com.newsroom.login.proto.rpc.LoginRequest;
import com.newsroom.login.proto.rpc.LoginResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
public class LoginController {

	@GetMapping("login")
	public Response<Data> fun(@RequestBody Request req) throws LoginException {
		try {
			log.info(req.toString());
			LoginRequest request = LoginRequest.newBuilder().setMailID(req.getEmail()).setMob(req.getMob())
					.setPassword(req.getPassword()).build();

			LoginResponse response = NewsroomLoginFacadeApplication.stub.login(request);

			Data data = Data.builder().userID(response.getData().getUserID()).build();

			Response ret = Response.builder().data(data).success(response.getSuccess()).build();
			log.info(ret.toString());
			return ret;
		} catch (Exception ex) {
			throw new LoginException(ErrorCode.NEWSROOM_ENGINE_DOWN);
		}

	}

}
