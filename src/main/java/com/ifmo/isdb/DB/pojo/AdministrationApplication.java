package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Entity
@Table(name = "administration_applications")
@Getter
@Setter
@IdClass(AdministrationApplicationKey.class)
public class AdministrationApplication {
    @Id
    @Column(name = "administration_id", nullable = false)
    private int administration_id;

    @Id
    @Column(name = "application_id", nullable = false)
    private int application_id;

}
