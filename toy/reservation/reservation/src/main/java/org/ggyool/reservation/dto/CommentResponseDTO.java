package org.ggyool.reservation.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentResponseDTO {
	private String comment;
	private Integer commentId;
	private CommentImageDTO commentImage;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modifyDate;
	private Integer productId;
	private Integer reservationInfoId;
	private Integer Score;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public CommentImageDTO getCommentImage() {
		return commentImage;
	}
	public void setCommentImage(CommentImageDTO commentImage) {
		this.commentImage = commentImage;
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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(Integer reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public Integer getScore() {
		return Score;
	}
	public void setScore(Integer score) {
		Score = score;
	}
	@Override
	public String toString() {
		return "CommentResponseDTO [comment=" + comment + ", commentId=" + commentId + ", commentImage=" + commentImage
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", productId=" + productId
				+ ", reservationInfoId=" + reservationInfoId + ", Score=" + Score + "]";
	} 
}
