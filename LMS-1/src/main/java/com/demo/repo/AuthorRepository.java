package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
