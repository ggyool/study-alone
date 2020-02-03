package org.ggyool.reservation.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDTO {
	private Long id;
	private Long categoryId;
	private String description;
	private String content;
	private String event;
	private Date createDate;
	private Date modifyDate;
	@Autowired
	private DisplayInfoDTO displayInfo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
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
	public DisplayInfoDTO getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(DisplayInfoDTO displayInfo) {
		this.displayInfo = displayInfo;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", categoryId=" + categoryId + ", description=" + description + ", content="
				+ content + ", event=" + event + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", displayInfo=" + displayInfo + "]";
	}
	
	
}
