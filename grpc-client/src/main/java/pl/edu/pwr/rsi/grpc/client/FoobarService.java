package pl.edu.pwr.rsi.grpc.client;

import pl.edu.pwr.rsi.grpc.interfaces.lib.HelloRequest;
import pl.edu.pwr.rsi.grpc.interfaces.lib.MyServiceGrpc.MyServiceBlockingStub;

import net.devh.boot.grpc.client.inject.GrpcClient;

import org.springframework.stereotype.Service;

@Service
public class FoobarService {

    @GrpcClient("myService")
    private MyServiceBlockingStub myServiceStub;

    public String receiveGreeting(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return myServiceStub.sayHello(request).getMessage();
    }

}
