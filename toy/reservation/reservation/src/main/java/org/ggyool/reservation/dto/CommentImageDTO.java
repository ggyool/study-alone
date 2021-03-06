package org.ggyool.reservation.dto;

import java.util.Date;

import org.ggyool.reservation.entity.FileInfoEntity;
import org.ggyool.reservation.entity.ReservationUserCommentImageEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentImageDTO {
	private String contentType;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date createDate;
	private Boolean deleteFlag;
	private Integer fileId;
	private String fileName;
	private Integer imageId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modifyDate;
	private Integer reservationInfoId;
	private Integer reservationUserCommentId;
	private String saveFileName;
	CommentImageDTO(){
		
	}
	public CommentImageDTO(ReservationUserCommentImageEntity reservationUserCommentImageEntity, FileInfoEntity fileInfoEntity){
		this.contentType = fileInfoEntity.getContentType();
		this.createDate = fileInfoEntity.getCreateDate();
		this.deleteFlag = fileInfoEntity.getDeleteFlag();
		this.fileId = fileInfoEntity.getId();
		this.fileName = fileInfoEntity.getFileName();
		this.imageId = reservationUserCommentImageEntity.getId();
		this.modifyDate = fileInfoEntity.getModifyDate();
		this.reservationInfoId = reservationUserCommentImageEntity.getReservationInfoId();
		this.reservationUserCommentId = reservationUserCommentImageEntity.getReservationUserCommentId();
		this.saveFileName = fileInfoEntity.getSaveFileName();
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(Integer reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public Integer getReservationUserCommentId() {
		return reservationUserCommentId;
	}
	public void setReservationUserCommentId(Integer reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Override
	public String toString() {
		return "CommentImageDTO [contentType=" + contentType + ", createDate=" + createDate + ", deleteFlag="
				+ deleteFlag + ", fileId=" + fileId + ", fileName=" + fileName + ", imageId=" + imageId
				+ ", modifyDate=" + modifyDate + ", reservationInfoId=" + reservationInfoId
				+ ", reservationUserCommentId=" + reservationUserCommentId + ", saveFileName=" + saveFileName + "]";
	}
}