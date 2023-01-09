package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Entries;

@Repository
public interface ApplicationRepository extends  JpaRepository<Entries, String>{

}
