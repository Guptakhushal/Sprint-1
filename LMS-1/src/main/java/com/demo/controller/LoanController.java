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

import com.demo.entity.Loan;
import com.demo.repo.LoanRepository;

@RestController
@RequestMapping("/loan")

public class LoanController {

	

		@Autowired
		private LoanRepository repo;
		
		@GetMapping
		public List<Loan> getAllLoan(){
			return repo.findAll();
			
		}
		@GetMapping("{id}")
		public Loan getLoanById(@PathVariable int id) {
			return repo.findById(id).orElse(null);
		}

		@PostMapping
		public Loan createLoan(@RequestBody Loan loan) {
			return repo.save(loan);
		}
		
		@PutMapping("/{id}")
		public Loan updateLoan(@PathVariable int id, @RequestBody Loan updateLoan) {
		    updateLoan.setId(id);
		    return repo.save(updateLoan);
		}

		@DeleteMapping("/{id}")
		public void deleteLoan(@PathVariable int id) {
		    repo.deleteById(id);
		}
}
