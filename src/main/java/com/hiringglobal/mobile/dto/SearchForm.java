package com.hiringglobal.mobile.dto;

public class SearchForm {
    private String keyword;

    public SearchForm(String keyword) {
        this.keyword = keyword;
    }

    public SearchForm(){}

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
