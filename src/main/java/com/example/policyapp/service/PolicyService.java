package com.example.policyapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.policyapp.entity.Policy;
import com.example.policyapp.repository.PolicyRepository;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    // Create or Update Policy
    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    // Get all policies
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    // Get policy by ID
    public Optional<Policy> getPolicyById(Long id) {
        return policyRepository.findById(id);
    }

    // Delete policy by ID
    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }
}