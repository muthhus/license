package com.optimagrowth.license.controller;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/organisation/{oganisationId}/license")
public class LicenseController {

    private LicenseService licenseService;

    @Autowired
    public LicenseController(LicenseService licenseService){
        this.licenseService = licenseService;
    }

    @GetMapping("/")
    public String getWelcome(){
        return "Hello, World!";
    }

    @GetMapping(value = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("organisationId") String organisationId, @PathVariable("licenseId") String licenseId){
        License license = licenseService.getLicense(licenseId, organisationId);
        return ResponseEntity.ok(license);
    }

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable("organisationId") String organisationId, @RequestBody License request){
        return ResponseEntity.ok(licenseService.createLicense(request, organisationId));
    }

    @PutMapping
    public  ResponseEntity<String> updateLicense(@PathVariable("organisationId") String organisationId, @RequestBody License request){
        return ResponseEntity.ok(licenseService.updateLicense(request, organisationId));
    }

    @DeleteMapping(value="/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("organisationId") String organisationId, @PathVariable("licenseId") String licenseId){
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organisationId));
    }
}
