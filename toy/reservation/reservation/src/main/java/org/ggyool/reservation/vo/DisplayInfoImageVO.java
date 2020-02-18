package org.ggyool.reservation.vo;

import java.util.Date;

public class DisplayInfoImageVO {
	private Integer id;
	private Integer displayInfoId;
	private Integer fileId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(Integer displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "DisplayInfoImageVO [id=" + id + ", displayInfoId=" + displayInfoId + ", fileId=" + fileId + "]";
	}
}
