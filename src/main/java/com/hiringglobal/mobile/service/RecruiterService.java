package com.hiringglobal.mobile.service;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.hiringglobal.mobile.dto.DetailRecruiterDTO;
import com.hiringglobal.mobile.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hiringglobal.mobile.dto.RecruiterDTO;
import com.hiringglobal.mobile.constants.AuthenticationProvider;
import com.hiringglobal.mobile.exceptions.UserAlreadyExistException;
import com.hiringglobal.mobile.repository.IRecruiterRepository;
import com.hiringglobal.mobile.repository.IVipRecruiterRepository;
import com.hiringglobal.mobile.security.repo.IRoleRepository;
import com.hiringglobal.mobile.security.repo.IUserRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RecruiterService implements IRecruiterService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IRecruiterRepository recruiterRepository;

    @Autowired
    private IVipRecruiterRepository vipRecruiterRepository;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @Override
    public DetailRecruiterDTO getDetailRecruiterDTO(Integer userId) {
        return null;
    }

    @Override
    public DetailRecruiterDTO getRecruiterDTO(Integer userId) {
        return null;
    }

    @Override
    public Recruiter registerRecruiter(RecruiterDTO newUser) throws Exception {
        String username = newUser.getEmail();
        User existingUser = userRepository.findByUsername(username).orElse(null);
        if (existingUser != null) {
            if (existingUser.getEnabled()) {
                throw new UserAlreadyExistException("User already exists, please choose another username");
            } else {
                throw new Exception("Unverified email");
            }

        }
        User user = new User();
        String arr[] = newUser.getFullname().split(" ");
        user.setName(arr[arr.length - 1] + " " + arr[0]);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(newUser.getAccount().getPassword()));
        user.setRoles(Set.of(roleRepository.findByName("ROLE_RECRUITER")));
        user.setAuthProvider(AuthenticationProvider.LOCAL);

        Recruiter newRecruiter = modelMapper.map(newUser, Recruiter.class);
        newRecruiter.setUser(user);
        VipRecruiter vipRecruiter = vipRecruiterRepository.findTop1BySupportedOrderByPricingAsc(true).orElseThrow();

        LocalDateTime now = LocalDateTime.now();
        UpgradedRecruiter newUpgradedRecruiter = new UpgradedRecruiter();
        newUpgradedRecruiter.setStartDate(now);
        newUpgradedRecruiter.setExpired(now.plusDays(vipRecruiter.getDuring()));
        newUpgradedRecruiter.setVipRecruiter(vipRecruiter);

        newRecruiter.setUpgradedRecruiter(newUpgradedRecruiter);
        newRecruiter.setCompany(new Company());
        newRecruiter.getCompany().setLogo("");
        return recruiterRepository.save(newRecruiter);

    }

    @Override
    public DetailRecruiterDTO getRecruiterProfile(Integer userId) {
        Recruiter recruiter = recruiterRepository.findByUserId(userId);
        DetailRecruiterDTO detailRecruiterDTO = new DetailRecruiterDTO();
        if (recruiter != null) {
            detailRecruiterDTO.setFullname(recruiter.getFullname());
            detailRecruiterDTO.setEmail(recruiter.getEmail());
            detailRecruiterDTO.setPhone(recruiter.getPhone());

            if (recruiter.getCompany() != null) {
                detailRecruiterDTO.setName(recruiter.getCompany().getName());
                detailRecruiterDTO.setContact(recruiter.getCompany().getContact());
                detailRecruiterDTO.setIntroduction(recruiter.getCompany().getIntroduction());
                detailRecruiterDTO.setAddress(recruiter.getCompany().getAddress());
                detailRecruiterDTO.setWebsite(recruiter.getCompany().getWebsite());
            }
        }
        return detailRecruiterDTO;
    }

    @Override
    public void updateRecruiterProfile(Integer userId, DetailRecruiterDTO updateRecruiterProfile) {
        Recruiter recruiter = recruiterRepository.findByUserId(userId);
        if (recruiter != null) {
            // Cập nhật thông tin hồ sơ ứng viên từ đối tượng updatedRecruiterProfile
            recruiter.setFullname(updateRecruiterProfile.getFullname());
            recruiter.setEmail(updateRecruiterProfile.getEmail());
            recruiter.setPhone(updateRecruiterProfile.getPhone());

            // Lấy thông tin công ty liên kết với ứng viên (nếu có)
            Company company = recruiter.getCompany();
            if (company == null) {
                company = new Company();
                company.setRecruiter(recruiter);
                recruiter.setCompany(company);
            }

            // Cập nhật thông tin công ty từ đối tượng updatedRecruiterProfile
            company.setName(updateRecruiterProfile.getName());
            company.setContact(updateRecruiterProfile.getContact());
            company.setAddress(updateRecruiterProfile.getAddress());
            company.setIntroduction(updateRecruiterProfile.getIntroduction());
            company.setWebsite(updateRecruiterProfile.getWebsite());

            // Lưu đối tượng Recruiter (kèm theo công ty liên kết) vào CSDL
            recruiterRepository.save(recruiter);
        }

    }

    public String uploadlogo(Integer userId, MultipartFile logoFile) throws IOException {
        // Kiểm tra xem có tồn tại người dùng với userId đã cho không
        Recruiter recruiter = recruiterRepository.findByUserId(userId);
        if (recruiter == null) {
            throw new IllegalArgumentException("Không tìm thấy người dùng với userId: " + userId);
        }

        // Upload ảnh avatar lên Firebase và lấy link ảnh trả về
        String logoLink = firebaseStorageService.companyUploadImg(logoFile);

        // Cập nhật trường avatar trong đối tượng Applicant
        recruiter.getCompany().setLogo(logoLink);

        // Lưu thông tin đã cập nhật vào cơ sở dữ liệu
        recruiterRepository.save(recruiter);

        // Trả về link ảnh đã upload
        return logoLink;
    }
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

	@Override
	public Recruiter findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return recruiterRepository.findByUserId(userId);
	}
    

}