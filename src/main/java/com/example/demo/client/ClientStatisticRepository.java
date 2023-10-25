package com.example.demo.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStatisticRepository extends JpaRepository<ClientStatistic, String> {

}
