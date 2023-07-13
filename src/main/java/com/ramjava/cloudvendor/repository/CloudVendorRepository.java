package com.ramjava.cloudvendor.repository;

import com.ramjava.cloudvendor.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
    // Custom methods not available to JPARepository
    List<CloudVendor> findByVendorName(String vendorName);
}
