package com.assignment2.gallery;

import com.assignment2.gallery.client.GrpcTest;
import com.gallery.exhibition.ExhibitionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GalleryApplication {

    private final static String url = "localhost";
    private static final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 7081).usePlaintext().build();
    private static final ExhibitionServiceGrpc.ExhibitionServiceBlockingStub stub = ExhibitionServiceGrpc.newBlockingStub(channel);

    public static void main(String[] args) {
        GrpcTest grpcTest = new GrpcTest();
        grpcTest.test();
    }
}
