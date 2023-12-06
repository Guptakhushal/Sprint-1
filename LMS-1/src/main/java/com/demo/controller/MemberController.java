package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Member;
import com.demo.repo.MemberRepository;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberRepository repo;

	@GetMapping
	public List<Member> getAllMember() {
		return repo.findAll();

	}

	@GetMapping("{id}")
	public Member getMemeberById(@PathVariable int id) {
		return repo.findById(id).orElse(null);
	}

	@PostMapping
	public Member createMember(@RequestBody Member member) {
		return repo.save(member);
	}

	@PutMapping("/{id}")
	public Member updateMember(@PathVariable int id, @RequestBody Member updateMember) {
		updateMember.setId(id);
		return repo.save(updateMember);
	}

	@DeleteMapping("/{id}")
	public void deleteMember(@PathVariable int id) {
		repo.deleteById(id);
	}

}
