package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class MessageToAdministration {
    private String login;
    private String message;
}
