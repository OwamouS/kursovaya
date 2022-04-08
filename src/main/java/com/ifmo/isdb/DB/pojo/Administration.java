package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@Entity
@Table(name = "administration")
@Getter
@Setter
public class Administration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "race", nullable = false, length = 30)
    private String race;

}
