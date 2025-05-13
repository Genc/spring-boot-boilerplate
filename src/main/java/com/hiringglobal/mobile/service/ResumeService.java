package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Applicant;
import com.hiringglobal.mobile.model.CV;
import com.hiringglobal.mobile.model.Resume;
import com.hiringglobal.mobile.repository.CVRepository;
import com.hiringglobal.mobile.repository.ResumesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class ResumeService {
	@Autowired
    private FirebaseStorageService firebaseStorageService;
    
	@Autowired
	private ResumesRepository resumesRepository;
    
	@Autowired
	private CVRepository cvRepository;

    public void uploadResumeAndSaveLink(MultipartFile file, Integer userId) throws IOException {
        String fileLink = firebaseStorageService.uploadFile(file);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // Tìm resume hiện tại của người dùng dựa vào userId
        Resume resume = resumesRepository.findByApplicantUserId(userId);

        CV cv= new CV();
        cv.setLinkCv(fileLink);
        cv.setName(fileName);
        cv.setResume(resume);

        if (resume != null) {
            resume.getCvList().add(cv);
        } else {
            // Nếu resume chưa tồn tại, tạo mới resume
            resume = new Resume();
            resume.setStatus(true);
            resume.setCvList(new ArrayList<>());
            // Đặt thông tin người dùng vào resume
            Applicant applicant = new Applicant();
            applicant.setId(userId);
            resume.setApplicant(applicant);

            resume.getCvList().add(cv);

        }

        // Lưu resume vào cơ sở dữ liệu
        resumesRepository.save(resume);
    }
    public Resume getResumeByUserId(Integer userId) {
        // Lấy thông tin resume của người dùng dựa vào userId
        return resumesRepository.findByApplicantUserId(userId);
    }

    public String getLinkCVFileName(String cvLink) {
        int lastSlashIndex = cvLink.lastIndexOf('/');
        int questionMarkIndex = cvLink.indexOf('?');

        if (lastSlashIndex != -1 && questionMarkIndex != -1 && lastSlashIndex < questionMarkIndex) {
            return cvLink.substring(lastSlashIndex + 1, questionMarkIndex);
        }

        return null;
    }

    public void deleteCVById(Integer cvId) throws IOException {
        CV cv = cvRepository.findById(cvId).orElse(null);
        if (cv != null) {
            String fileName = getLinkCVFileName(cv.getLinkCv());
            if (fileName != null) {
                firebaseStorageService.deleteByName(fileName);
            }
            cvRepository.deleteById(cvId);
        }
    }

}