package com.hiringglobal.mobile.dto;

import com.hiringglobal.mobile.constants.Gender;
import com.hiringglobal.mobile.model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ApplicantResume {
    private Integer id;
    private String fullname;
    private String email;
    private Integer age;
    private Gender gender;
    private Integer userId;
    private AccountDTO account;
    private String imagePath;
    private String phone;
    private String university;
    private String website;
    private String description;
    private String address;
    private String avatar;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public String getAvatar() {
        return avatar;
    }


    public ApplicantResume(Integer id, String avatar,String fullname, String email, Integer age, Gender gender, Integer userId,
                           AccountDTO account, String introduction, String linkCV, Boolean status, Integer numberCV,
                           String imagePath,String majors, String website, String phone,String description, String university,String address) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.userId = userId;
        this.account = account;
        this.introduction = introduction;
        this.linkCV = linkCV;
        this.status = status;
        this.numberCV = numberCV;
        this.imagePath = imagePath;
        this.majors = majors;
        this.website = website;
        this.university = university;
        this.phone = phone;
        this.description = description;
        this.address = address;
        this.avatar = avatar;

    }
    public ApplicantResume() {

    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setLinkCV(String linkCV) {
        this.linkCV = linkCV;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    private String introduction;

    private String linkCV;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Boolean status;

    private Integer numberCV;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public String getLinkCV() {
        return linkCV;
    }

    public Boolean getStatus() {
        return status;
    }

    public Integer getNumberCV() {
        return numberCV;
    }


    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setNumberCV(Integer numberCV) {
        this.numberCV = numberCV;
    }



    private String majors;
    // ... các setter và getter đã tồn tại ...

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }


}
