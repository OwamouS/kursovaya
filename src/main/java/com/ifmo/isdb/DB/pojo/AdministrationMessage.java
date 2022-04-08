package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
@Service
@Getter
@Setter
@Entity
@Table(name = "administration_messages")
@IdClass(AdministrationMessageKey.class)
public class AdministrationMessage {
    @Id
    @Column(name = "administration_recipient_id", nullable = false)
    private int administration_recipient_id;
    @Id
    @Lob
    @Column(name = "text", nullable = false)
    private String text;
    @Id
    @Column(name = "dispatch_time", nullable = false)
    private LocalDate dispatchTime;

}
