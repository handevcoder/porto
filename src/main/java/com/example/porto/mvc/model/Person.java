package com.example.porto.mvc.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_person")
        private UUID id;
        @Column(name = "username")
        private String username;
        @Column(name = "create_at")
        private Date createAt;
        @Column(name = "update_at")
        private Date updateDate;
        @Column(name = "password")
        private String password;
}
