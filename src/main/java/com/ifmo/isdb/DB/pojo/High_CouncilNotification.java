package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@Entity
@Table(name = "high_Council_notifications")
@Getter
@Setter
@IdClass(High_CouncilNotificationKey.class)
public class High_CouncilNotification {
    @Id
    @Column(name = "high_Council_id", nullable = false)
    private int high_Council_id;

    @Id
    @Column(name = "notification_id", nullable = false)
    private int notification_id;

}
