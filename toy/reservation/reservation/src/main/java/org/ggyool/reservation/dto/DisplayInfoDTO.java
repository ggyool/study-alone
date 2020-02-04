package org.ggyool.reservation.dto;

import java.util.Date;

import org.springframework.stereotype.Component;


public class DisplayInfoDTO {
	
	private Integer id;
	private Integer productId;
	private String openingHours;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String hompage;
	private String email;
	private Date createDate;
	private Date modifyDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceLot() {
		return placeLot;
	}
	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}
	public String getPlaceStreet() {
		return placeStreet;
	}
	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHompage() {
		return hompage;
	}
	public void setHompage(String hompage) {
		this.hompage = hompage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "DisplayInfoDTO [id=" + id + ", productId=" + productId + ", openingHours=" + openingHours
				+ ", placeName=" + placeName + ", placeLot=" + placeLot + ", placeStreet=" + placeStreet + ", tel="
				+ tel + ", hompage=" + hompage + ", email=" + email + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}
	
	
	
	
}
