package com.anastasija.MyBudgetApi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Account> accounts;
}
