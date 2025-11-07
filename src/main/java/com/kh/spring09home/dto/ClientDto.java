package com.kh.spring09home.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ClientDto {
  private String clientId;
  private String clientPassword;
  private String clientNickname;
  private String clientGrade;
  private Timestamp clientJoin;
  private int clientPoint;
}