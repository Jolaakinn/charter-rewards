package com.charter.rewards.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.charter.rewards.entity.TransactionEntity;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
    public List<TransactionEntity> findAllByCustomerId(Long customerId,Pageable pageable);

    public List<TransactionEntity> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from,Timestamp to);
}
