package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@Entity
@Table(name = "high_Council_members")
@Getter
@Setter
@IdClass(High_CouncilMemberKey.class)
public class High_CouncilMember {
    @Id
    @Column(name = "high_Council_id", nullable = false)
    private int high_Council_id;

    @Id
    @Column(name = "member_id", nullable = false)
    private int member_id;

    @Column(name = "member_mode")
    private int member_mode;

}
