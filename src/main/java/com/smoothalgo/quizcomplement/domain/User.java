package com.smoothalgo.quizcomplement.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String username;
    @JsonIgnore
    @NonNull
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

    @Column(length = 254, unique = true)
    private String email;


    @Column(name = "reset_key", length = 20)
    @JsonIgnore
    private String resetKey;

    @Column(name = "reset_date")
    private Instant resetDate = null;

    @Column(name = "lang_key", length = 6)
    private String langKey;


}
