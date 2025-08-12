package com.example.policyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.policyapp.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    // We can add custom query methods here later if needed
}
