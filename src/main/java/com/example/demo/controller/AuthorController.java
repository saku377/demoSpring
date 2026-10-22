package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin(origins = "*")
public class AuthorController {

	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@GetMapping
	public List<Author> findAll() {
		return authorService.findAll();
	}

	@PostMapping
	public ResponseEntity<Author> create(@RequestBody Author author) {
		Author created = authorService.create(author);
		return ResponseEntity.created(URI.create("/api/authors/" + created.getId())).body(created);
	}
}
