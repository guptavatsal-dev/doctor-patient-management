package com.ducat.hospmntsystem.repository;
import com.ducat.hospmntsystem.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
    }
