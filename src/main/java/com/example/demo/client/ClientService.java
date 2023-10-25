package com.example.demo.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientStatisticRepository clientStatisticRepository;
    public Client getClient(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/users/" + username;
        GitClient response = restTemplate.getForObject(url, GitClient.class);

        if (clientStatisticRepository.existsById(username)) {
            Optional<ClientStatistic> existingClient = clientStatisticRepository.findById(username);
            int counter = existingClient.get().getCounter();
            counter++;
            clientStatisticRepository.save(new ClientStatistic(username, counter));

        } else {
            clientStatisticRepository.save(new ClientStatistic(username, 1));
        }
        return new Client(response);
    }

}
