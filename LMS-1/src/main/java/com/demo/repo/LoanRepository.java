package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
