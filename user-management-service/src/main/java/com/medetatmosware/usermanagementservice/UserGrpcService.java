package com.medetatmosware.usermanagementservice;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import tr.com.medet.user.GetUserRequest;
import tr.com.medet.user.GetUserResponse;
import tr.com.medet.user.UserServiceGrpc;

@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUser(final GetUserRequest request, final StreamObserver<GetUserResponse> responseObserver) {
        final var id = request.getId();
        final var idInteger = Integer.valueOf(id);
        final var response = GetUserResponse.newBuilder().setName("Medet").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
