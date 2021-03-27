package pl.edu.pwr.rsi.grpc.service;


import pl.edu.pwr.rsi.grpc.interfaces.lib.HelloReply;
import pl.edu.pwr.rsi.grpc.interfaces.lib.HelloRequest;
import pl.edu.pwr.rsi.grpc.interfaces.lib.MyServiceGrpc;

import io.grpc.stub.StreamObserver;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
