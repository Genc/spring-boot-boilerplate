package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.dto.ApplicantResume;
import java.io.IOException;

public interface IApplicantService {
    ApplicantResume getApplicantProfile(Integer userId);
    void updateApplicantProfile(Integer userId, ApplicantResume updatedApplicantResume) throws IOException;


}
