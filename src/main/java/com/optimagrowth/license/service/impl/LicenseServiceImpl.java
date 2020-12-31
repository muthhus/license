package com.optimagrowth.license.service.impl;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.service.LicenseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class LicenseServiceImpl implements LicenseService {

    @Override
    public License getLicense(String licenseId, String organisationId) {

        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganisationId(organisationId);
        license.setDescription("Software Product");
        license.setProductName("Ostock");
        license.setLicenseType("full");

        return license;
    }

    @Override
    public String createLicense(License license, String organisationId) {
        String responseMessage = null;
        if (!StringUtils.isEmpty(license)) {
            license.setOrganisationId(organisationId);
            responseMessage = String.format("This is the post and the object is: %s", license.toString());
        }

            return responseMessage;
    }

    @Override
    public String updateLicense(License license, String organisationId) {
        String responseMessage = null;
        if (!StringUtils.isEmpty(license)) {
            license.setOrganisationId(organisationId);
            responseMessage = String.format("This is the put and the object is: %s", license.toString());
        }
        return null;
    }

    @Override
    public String deleteLicense(String licenseId, String organisationId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting license with id %s for the organisation %s", licenseId, organisationId);
        return responseMessage;
    }
}
