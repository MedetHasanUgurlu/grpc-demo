package com.example.examclient;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import tr.com.medet.user.ExamServiceGrpc;
import tr.com.medet.user.GetExamRequest;
import tr.com.medet.user.GetExamResponse;

import java.util.UUID;

@GrpcService
public class ExamGrpcService extends ExamServiceGrpc.ExamServiceImplBase {
    private final UserClientService userClientService;

    public ExamGrpcService(final UserClientService userClientService) {
        this.userClientService = userClientService;
    }

    @Override
    public void getExamName(final GetExamRequest request, final StreamObserver<GetExamResponse> responseObserver) {
        final var name = userClientService.getName();
        final var s = name + UUID.randomUUID();
        responseObserver.onNext(GetExamResponse.newBuilder().setName(s).build());
        responseObserver.onCompleted();
    }
}
