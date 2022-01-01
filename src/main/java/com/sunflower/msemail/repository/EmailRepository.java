package com.sunflower.msemail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunflower.msemail.entity.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>{

}
