package com.ramjava.cloudvendor.repository;

import com.ramjava.cloudvendor.model.CloudVendor;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


//import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // DataJpaTest is using embedded db
class CloudVendorRepositoryTest {
    // given - when - then
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;
    // Initialization
    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1", "Amazon", "USA", "xxxxx");
        cloudVendorRepository.save(cloudVendor);
    }
    @AfterEach
    void tearDown() {
        // Clear off all resources
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // Test case SUCCESS
    @Test
    void testFindByVendorName_Found() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }

      // Test case FAILURE
    @Test
    void testFindByVendorName_NotFound() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("GoogleCloudProvider");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }
}