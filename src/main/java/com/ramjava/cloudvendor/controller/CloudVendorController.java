package com.ramjava.cloudvendor.controller;

import com.ramjava.cloudvendor.model.CloudVendor;
import com.ramjava.cloudvendor.response.ResponseHandler;
import com.ramjava.cloudvendor.service.CloudVendorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    //CloudVendor cloudVendor;
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    @ApiOperation(value = "Cloud Vendor Id", notes = "Provide Cloud Vendor Details")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        //return cloudVendorService.getCloudVendor(vendorId);
        // Custom Response
        return ResponseHandler.responseBuilder("Requested vendor details are given here", HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails() {
        return cloudVendorService.getAllCloudVendors();
    }
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        //this.cloudVendor = cloudVendor;
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        //this.cloudVendor = cloudVendor;
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        //this.cloudVendor = null;
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}
