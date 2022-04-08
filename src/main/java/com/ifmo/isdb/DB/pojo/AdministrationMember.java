package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "administration_members")
@Getter
@Setter
@IdClass(AdministrationMemberKey.class)
public class AdministrationMember {
    @Id
    @Column(name = "administration_id", nullable = false)
    private int administration_id;
    @Id
    @Column(name = "member_id", nullable = false)
    private int member_id;

    @Column(name = "member_mode")
    private int member_mode;

}
