package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.Item;
import com.example.app.mapper.ItemMapper;

@RestController
public class ItemRestController {

	@Autowired
	private ItemMapper mapper;

	@GetMapping("/items")
	public List<Item> list() {
		List<Item> items = mapper.findAll();
		return items;
	}

	@GetMapping("/items/{id}")
	public Item show(@PathVariable Integer id) {
		return mapper.findById(id);
	}
}
