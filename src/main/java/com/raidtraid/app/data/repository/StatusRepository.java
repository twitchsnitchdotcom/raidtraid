package com.raidtraid.app.data.repository;


import com.raidtraid.app.data.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
