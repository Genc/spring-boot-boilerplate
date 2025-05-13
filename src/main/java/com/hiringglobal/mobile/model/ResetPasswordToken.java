package com.hiringglobal.mobile.model;

import java.util.Calendar;
import java.util.Date;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ResetPasswordToken {
	 private static final int EXPIRATION_MINUTE = 10;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    private String token;

	    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = false, name = "user_id")
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private User user;

	    private Date expiryDate;

	    public ResetPasswordToken(String token, User user) {
	        this.token = token;
	        this.user = user;
	        this.expiryDate=new Date(Calendar.getInstance().getTime().getTime()+ EXPIRATION_MINUTE*60*1000);
	    }

	public ResetPasswordToken() {

	}

	public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Date getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate;
		}

		public static int getExpirationMinute() {
			return EXPIRATION_MINUTE;
		}
	    
	    
}
