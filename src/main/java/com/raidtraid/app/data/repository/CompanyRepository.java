package com.raidtraid.app.data.repository;


import com.raidtraid.app.data.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
