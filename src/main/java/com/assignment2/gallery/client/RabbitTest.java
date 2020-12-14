package com.assignment2.gallery.client;

import com.assignment2.gallery.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RabbitTest {
    private static final String URL = "http://127.0.0.1:51020";
    private static final HttpHeaders headers = new HttpHeaders();
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public void testClient() {
        headers.setContentType(MediaType.APPLICATION_JSON);

        //add workers
        Worker owner = new Worker("Yeva", "Koldovska",
                800, Position.OWNER);
        Worker ticketSeller = new Worker("Emily", "Brooks",
                200, Position.TICKETSELLER);
        Worker manager = new Worker("James", "Smith",
                300, Position.MANAGER);
        Worker ticketSeller2 = new Worker("Jordan", "Cooper",
                200, Position.TICKETSELLER);

        addEntity("/worker", owner);
        addEntity("/worker", ticketSeller);
        addEntity("/worker", manager);
        addEntity("/worker", ticketSeller2);

        //add visitors
        Visitor jacob = new Visitor("Jacob", 300, 17);
        Visitor mia = new Visitor("Mia", 4300, 56);
        Visitor alex = new Visitor("Alex", 2100, 43);
        Visitor jack = new Visitor("Jack", 600, 34);

        addEntity("/visitor", jacob);
        addEntity("/visitor", mia);
        addEntity("/visitor", alex);
        addEntity("/visitor", jack);
    }

    private void addEntity(String path, Object entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String entityJson = objectMapper.writeValueAsString(entity);
            HttpEntity<String> entityJsonHttp = new HttpEntity<>(entityJson, headers);
            ResponseEntity<Void> response = restTemplate.postForEntity(URL +
                    path + "/mq", entityJsonHttp, Void.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
