package com.hiringglobal.mobile.dto;

public class DetailRecruiterDTO {


        private Integer id;
        private String fullname;
        private String email;
        private String phone;
        private String name;
        private String contact;
        private String address;
        private String introduction;
        private Integer userId;
        private AccountDTO account;

        private String website;

        public DetailRecruiterDTO() {

        }

        public DetailRecruiterDTO(Integer id, String fullname, String email, String phone, String name, String contact, String address,
                            String introduction, Integer userId, AccountDTO account, String website) {
            this.id = id;
            this.fullname = fullname;
            this.email = email;
            this.phone = phone;
            this.name = name;
            this.contact = contact;
            this.address = address;
            this.introduction = introduction;
            this.userId = userId;
            this.account = account;
            this.website = website;
        }

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

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }


}

