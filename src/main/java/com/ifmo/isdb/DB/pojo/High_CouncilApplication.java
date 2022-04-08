package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@Entity
@Table(name = "high_Council_application")
@IdClass(High_CouncilApplicationKey.class)
@Getter
@Setter
public class High_CouncilApplication {
    @Id
    @Column(name = "high_Council_id")
    private int high_Council_id;

    @Id
    @Column(name = "application_id")
    private int application;

    @Column(name = "application_status", length = 30)
    private String application_status;

}
