package com.example.demo.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GitClient {
        private Long id;
        private String login;
        private String name;
        private String type;
        @JsonProperty("avatar_url")
        private String avatarUrl;
        @JsonProperty("created_at")
        private LocalDate creationDate;
        @JsonProperty("public_gists")
        private int numberOfFollowers;
        @JsonProperty("public_repos")
        private int numberOfRepos;
        private int calculation;


        public int getCalculation() {
            if (this.numberOfFollowers > 0) {
                calculation = 6 / this.numberOfFollowers * ( 2 + this.numberOfRepos);
            } else {
                return 0;
            }
            return calculation;
        }

}
