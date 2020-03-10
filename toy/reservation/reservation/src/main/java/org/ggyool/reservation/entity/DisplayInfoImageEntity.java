package org.ggyool.reservation.entity;

public class DisplayInfoImageEntity {
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
		return "DisplayInfoImageEntity [id=" + id + ", displayInfoId=" + displayInfoId + ", fileId=" + fileId + "]";
	}
}
