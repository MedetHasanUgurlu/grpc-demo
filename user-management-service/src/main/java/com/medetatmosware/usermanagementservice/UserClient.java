package com.medetatmosware.usermanagementservice;

import net.devh.boot.grpc.client.inject.GrpcClient;
import tr.com.medet.user.GetUserResponse;
import tr.com.medet.user.UserServiceGrpc;

public class UserClient implements UserAdapter{

    // Client inject
    @GrpcClient("examService")
    UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public void saveParticipant(){

    }

    @Override
    public String getFromClient() {
        final var response = userServiceBlockingStub.getUser(null);
        final var name = response.getName();
        System.out.println(name);
        return name;
    }
}
