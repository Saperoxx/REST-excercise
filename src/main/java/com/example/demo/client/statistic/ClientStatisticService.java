package com.example.demo.client.statistic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientStatisticService {

    private final ClientStatisticRepository clientStatisticRepository;
    public void updateStatistic(String username) {
        if (clientStatisticRepository.existsById(username)) {
            Optional<ClientStatistic> existingClient = clientStatisticRepository.findById(username);
            int counter = existingClient.get().getCounter();
            clientStatisticRepository.save(new ClientStatistic(username, ++counter));

        } else {
            clientStatisticRepository.save(new ClientStatistic(username, 1));
        }
    }
}
