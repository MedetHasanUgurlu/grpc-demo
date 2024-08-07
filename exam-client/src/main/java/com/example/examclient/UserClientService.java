package com.example.examclient;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import tr.com.medet.user.GetUserRequest;
import tr.com.medet.user.UserServiceGrpc;

@Service
public class UserClientService {

    @GrpcClient("userService")
    UserServiceGrpc.UserServiceBlockingStub blockingStub;

    public String getName() {
        final var request = GetUserRequest.newBuilder().setId("76").build();
        final var response = blockingStub.getUser(request);
        return response.getName();
    }
}
