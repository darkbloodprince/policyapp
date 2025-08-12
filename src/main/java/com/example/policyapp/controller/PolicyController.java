package com.example.policyapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.policyapp.entity.Policy;
import com.example.policyapp.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    // CREATE a new policy
    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }

    // READ all policies
    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    // READ policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
        Optional<Policy> policy = policyService.getPolicyById(id);
        return policy.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE policy
    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @RequestBody Policy updatedPolicy) {
        Optional<Policy> existingPolicy = policyService.getPolicyById(id);
        if (existingPolicy.isPresent()) {
            Policy policy = existingPolicy.get();
            policy.setPolicyNumber(updatedPolicy.getPolicyNumber());
            policy.setPolicyHolderName(updatedPolicy.getPolicyHolderName());
            policy.setCoverageAmount(updatedPolicy.getCoverageAmount());
            policy.setPremium(updatedPolicy.getPremium());
            return ResponseEntity.ok(policyService.savePolicy(policy));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE policy
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}