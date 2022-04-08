package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@ToString
@Entity
@Table(name = "passenger_applications")
@Getter
@Setter
@IdClass(PassengerApplicationKey.class)
public class PassengerApplication {
    @Id
    private int passenger_id;
    @Id
    private int application_id;
}
