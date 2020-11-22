package com.assignment2.gallery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public final class Exhibition {

    @Id
    private UUID exhId;

    private String name;
    private boolean open;
    private int price;

    public Exhibition(String name, boolean open, int price) {
        exhId = UUID.randomUUID();
        this.name = name;
        this.open = open;
        this.price = price;
    }

}
