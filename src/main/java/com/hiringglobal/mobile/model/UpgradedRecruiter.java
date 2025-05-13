package com.hiringglobal.mobile.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "upgraded_recruiters")
public class UpgradedRecruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDateTime expired;
	private LocalDateTime startDate;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "vip_recruiter_id")
	private VipRecruiter vipRecruiter;

	public UpgradedRecruiter() {
	}

	public UpgradedRecruiter(Integer id, LocalDateTime expired, LocalDateTime startDate,
			VipRecruiter vipRecruiter) {
		this.id = id;
		this.expired = expired;
		this.startDate = startDate;
		this.vipRecruiter = vipRecruiter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getExpired() {
		return expired;
	}

	public void setExpired(LocalDateTime expired) {
		this.expired = expired;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public VipRecruiter getVipRecruiter() {
		return vipRecruiter;
	}

	public void setVipRecruiter(VipRecruiter vipRecruiter) {
		this.vipRecruiter = vipRecruiter;
	}

	

}
