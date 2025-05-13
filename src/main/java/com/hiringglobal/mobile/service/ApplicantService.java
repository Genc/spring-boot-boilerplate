package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Applicant;

import com.hiringglobal.mobile.model.Resume;
import com.hiringglobal.mobile.dto.ApplicantResume;
import com.hiringglobal.mobile.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;



@Service
public class ApplicantService implements IApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;



    @Override
    public ApplicantResume getApplicantProfile(Integer userId) {
        Applicant applicant = applicantRepository.findByUserId(userId).orElse(null);
        if (applicant != null) {
            // Tạo đối tượng ApplicantResume và thiết lập thông tin từ Applicant
            ApplicantResume applicantResume = new ApplicantResume();
            applicantResume.setAvatar(applicant.getAvatar());
            applicantResume.setAge(applicant.getAge());
            applicantResume.setCategory(applicant.getCategory());
            applicantResume.setEmail(applicant.getEmail());
            applicantResume.setFullname(applicant.getFullname());
            applicantResume.setGender(applicant.getGender());
            applicantResume.setId(applicant.getId());
            // Lấy thông tin từ đối tượng Resume của Applicant (nếu có) và thiết lập vào ApplicantResume
            Resume resume = applicant.getResume();
            if (resume != null) {
                applicantResume.setStatus(resume.getStatus());
                applicantResume.setPhone(resume.getPhone());
                applicantResume.setDescription(resume.getDescription());
                applicantResume.setAddress(resume.getAddress());
                applicantResume.setUniversity(resume.getUniversity());
                applicantResume.setWebsite(resume.getWebsite());
            }


            return applicantResume;
        } else {
            return null;
        }
    }

    @Override
    public void updateApplicantProfile(Integer userId, ApplicantResume updatedApplicantResume) throws IOException {
        Applicant applicant = applicantRepository.findByUserId(userId).orElse(null);
        if (applicant != null) {
            // Cập nhật thông tin hồ sơ ứng viên từ ApplicantResume
            applicant.setFullname(updatedApplicantResume.getFullname());
//            applicant.setAvatar(updatedApplicantResume.getAvatar());
//            applicant.setEmail(updatedApplicantResume.getEmail());
            applicant.setCategory(updatedApplicantResume.getCategory());
            applicant.setAge(updatedApplicantResume.getAge());
            applicant.setGender(updatedApplicantResume.getGender());

            // Lấy thông tin Resume từ Applicant (nếu có) hoặc tạo mới nếu chưa có
            Resume resume = applicant.getResume();
            if (resume == null) {
                resume = new Resume();
                resume.setApplicant(applicant); // Liên kết Resume với Applicant
                applicant.setResume(resume); // Liên kết Applicant với Resume
            }


            // Cập nhật thông tin liên quan đến Resume từ ApplicantResume
            resume.setStatus(updatedApplicantResume.getStatus());
            resume.setPhone(updatedApplicantResume.getPhone());
            resume.setDescription(updatedApplicantResume.getDescription());
            resume.setAddress(updatedApplicantResume.getAddress());
            resume.setUniversity(updatedApplicantResume.getUniversity());
            resume.setWebsite(updatedApplicantResume.getWebsite());

            // Lưu đối tượng Applicant vào bảng applicants
            applicantRepository.save(applicant);
        }
    }

    public String uploadAvatar(Integer userId, MultipartFile avatarFile) throws IOException {
        // Kiểm tra xem có tồn tại người dùng với userId đã cho không
        Applicant applicant = applicantRepository.findByUserId(userId).orElse(null);
        if (applicant == null) {
            throw new IllegalArgumentException("Không tìm thấy người dùng với userId: " + userId);
        }

        // Upload ảnh avatar lên Firebase và lấy link ảnh trả về
        String avatarLink = firebaseStorageService.uploadImg(avatarFile);

        // Cập nhật trường avatar trong đối tượng Applicant
        applicant.setAvatar(avatarLink);

        // Lưu thông tin đã cập nhật vào cơ sở dữ liệu
        applicantRepository.save(applicant);

        // Trả về link ảnh đã upload
        return avatarLink;
    }

}
