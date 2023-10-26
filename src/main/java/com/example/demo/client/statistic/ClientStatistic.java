package com.example.demo.client.statistic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ClientStatistic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientStatistic {
    @Id
    private String name;
    private int counter;

}
