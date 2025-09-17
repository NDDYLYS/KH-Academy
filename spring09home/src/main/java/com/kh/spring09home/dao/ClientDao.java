package com.kh.spring09home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.ClientDto;
import com.kh.spring09home.mapper.ClientMapper;

@Repository
public class ClientDao {
  @Autowired
  private ClientMapper clientMapper;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void insert(ClientDto clientDto) {
    String sql = "insert into client(client_id, client_password, client_nickname, client_grade) values (?, ?, ?, ?)";
    Object[] params = {
      clientDto.getClientId(), clientDto.getClientPassword(),
      clientDto.getClientNickname(), clientDto.getClientGrade()
    };
    jdbcTemplate.update(sql, params);
  }
  public ClientDto selectOne(String clientId) {
    String sql = "select * from client where client_id = ?";
    Object[] params = {clientId};
    List<ClientDto> list = jdbcTemplate.query(sql, clientMapper, params);
    return list.isEmpty() ? null : list.get(0);
  }
  
  	public List<ClientDto> selectList() {
	    String sql = "select * from client order by client_id asc";
	    return jdbcTemplate.query(sql, clientMapper);
	  }
}