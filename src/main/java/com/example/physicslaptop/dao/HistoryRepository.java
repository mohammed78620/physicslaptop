package com.example.physicslaptop.dao;

import com.example.physicslaptop.domain.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HistoryRepository extends JpaRepository<LoginHistory, String> {

}

