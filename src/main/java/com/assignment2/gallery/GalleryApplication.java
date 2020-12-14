package com.assignment2.gallery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.assignment2.gallery.client.RabbitTest;

@SpringBootApplication
public class GalleryApplication {
    public static void main(String[] args) {
        RabbitTest rabbitTest = new RabbitTest();
        rabbitTest.testClient();
    }
}
