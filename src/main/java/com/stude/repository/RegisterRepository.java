package com.stude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stude.entity.Register;

@Repository
public interface RegisterRepository  extends JpaRepository<Register, Integer>{

}
