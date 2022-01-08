package com.newsroom.login.facade;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.newsroom.login.facade.enums.ErrorCode;
import com.newsroom.login.facade.exception.LoginException;
import com.newsroom.login.proto.rpc.LoginServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class NewsroomLoginFacadeApplication {

	public static ManagedChannel channel;
	public static LoginServiceGrpc.LoginServiceBlockingStub stub;

	public static void main(String[] args) {
		SpringApplication.run(NewsroomLoginFacadeApplication.class, args);
	}

	@PostConstruct
	public void buildChannel() throws LoginException, InterruptedException {

		log.info("Connecting with server....");

		try {
			channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
			stub = LoginServiceGrpc.newBlockingStub(channel);
		} catch (Exception ex) {
			throw new LoginException(ErrorCode.NEWSROOM_ENGINE_FAILURE);
		}
		log.info("Connected with server");

	}

}
