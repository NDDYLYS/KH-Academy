package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09home.dao.ClientDao;
import com.kh.spring09home.dto.ClientDto;

@Controller
@RequestMapping("/client")
public class ClientController {
  @Autowired
  private ClientDao clientDao;

  @GetMapping("/add")
  public String add() {
    return "/WEB-INF/views/client/add.jsp";
  }
  @PostMapping("/add")
  public String add(@ModelAttribute ClientDto clientDto) {
    clientDao.insert(clientDto);
    return "redirect:add";
  }
  
  @RequestMapping("/list")
  public String list(Model model) {
    List<ClientDto> clientList = clientDao.selectList();
    model.addAttribute("clientList", clientList);
    return "/WEB-INF/views/client/list.jsp";
  }
}