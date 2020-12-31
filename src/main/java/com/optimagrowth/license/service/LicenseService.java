package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;

public interface LicenseService {
    License getLicense(String licenseId, String organisationId);
    String createLicense(License license, String organisationId);
    String updateLicense(License license, String organisationId);
    String deleteLicense(String licenseId, String organisationId);
}
