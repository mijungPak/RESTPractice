package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.Member;
import com.example.app.mapper.MemberMapper;

@RestController
public class MemberRestController {

	@Autowired
	private MemberMapper mapper;

	@GetMapping("/members")
	public List<Member> list() {
		List<Member> members = mapper.findAll();
		return members;
	}

	@GetMapping("/members/{id}")
	public Member show(@PathVariable Integer id) {
		return mapper.findById(id);
	}
}
