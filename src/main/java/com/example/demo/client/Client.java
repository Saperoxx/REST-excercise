package com.example.demo.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {

    private Long id;
    private String login;
    private String name;
    private String type;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("created_at")
    private LocalDate creationDate;
    private int calculation;

    public Client(GitClient gitClient) {
        id = gitClient.getId();
        login = gitClient.getLogin();
        name = gitClient.getName();
        type = gitClient.getType();
        calculation = gitClient.getCalculation();
        avatarUrl = gitClient.getAvatarUrl();
        creationDate = gitClient.getCreationDate();
    }

}
