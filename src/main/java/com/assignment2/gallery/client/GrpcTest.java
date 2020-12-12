package com.assignment2.gallery.client;

import com.gallery.exhibition.ExhibitionRequest;
import com.gallery.exhibition.ExhibitionServiceGrpc;
import com.gallery.visitor.VisitorRequest;
import com.gallery.visitor.VisitorServiceGrpc;
import com.gallery.worker.Position;
import com.gallery.worker.WorkerRequest;
import com.gallery.worker.WorkerServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcTest {
    private final String url = "127.0.0.1";
    private final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 57810).usePlaintext().build();
    ExhibitionServiceGrpc.ExhibitionServiceBlockingStub exhibitionStub = ExhibitionServiceGrpc.newBlockingStub(channel);
    VisitorServiceGrpc.VisitorServiceBlockingStub visitorStub = VisitorServiceGrpc.newBlockingStub(channel);
    WorkerServiceGrpc.WorkerServiceBlockingStub workerStub = WorkerServiceGrpc.newBlockingStub(channel);

    public void test() {
        addVisitor("Jacob", 300, 17);
        addVisitor("Mia", 4300, 56);
        addVisitor("Alex", 2100, 43);
        addVisitor("Jack", 600, 34);

        addWorker("Yeva", "Koldovska", 800, Position.OWNER);
        addWorker("Emily", "Brooks", 200, Position.TICKETSELLER);
        addWorker("James", "Smith", 300, Position.MANAGER);
        addWorker("Jordan", "Cooper", 200, Position.TICKETSELLER);
    }

    private void addVisitor(String name, double balance, int age) {
        VisitorRequest visitor = VisitorRequest.newBuilder().
                setName(name).
                setMoney(balance).
                setAge(age).
                build();
        visitorStub.add(visitor);
    }

    private void addWorker(String name, String surname, int salary, Position position) {
        WorkerRequest worker = WorkerRequest.newBuilder().
                setName(name).
                setSurname(surname).
                setSalary(salary).
                setPosition(position).
                build();
        workerStub.add(worker);
    }
}
