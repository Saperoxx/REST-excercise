package com.example.demo.client;

import com.example.demo.client.statistic.ClientStatistic;
import com.example.demo.client.statistic.ClientStatisticRepository;
import com.example.demo.client.statistic.ClientStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientStatisticService clientStatisticService;
    private final RestTemplate restTemplate;
    @Value("${url.api.github.users}")
    private String githubUrl;
    public Client getClient(String username) {
        clientStatisticService.updateStatistic(username);
        String url = githubUrl + username;

        try {
        GitClient response = restTemplate.getForObject(url, GitClient.class);
            return new Client(response);
        } catch (HttpClientErrorException.NotFound e){
            throw new GitClientNotFoundException("Git User does not exists: " + username);
        }


    }

}
