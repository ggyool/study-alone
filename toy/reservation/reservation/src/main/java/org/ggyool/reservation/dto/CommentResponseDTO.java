package org.ggyool.reservation.dto;

import java.util.Date;

import org.ggyool.reservation.entity.ReservationUserCommentEntity;

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
	private Integer score;
	public CommentResponseDTO() {
		
	}
	public CommentResponseDTO(ReservationUserCommentEntity reservationUserCommentEntity) {
		this.comment = reservationUserCommentEntity.getComment();
		this.commentId = reservationUserCommentEntity.getId();
		this.createDate = reservationUserCommentEntity.getCreateDate();
		this.modifyDate = reservationUserCommentEntity.getModifyDate();
		this.productId = reservationUserCommentEntity.getProductId();
		this.reservationInfoId = reservationUserCommentEntity.getReservationInfoId();
		this.score = reservationUserCommentEntity.getScore().intValue();
		this.commentImage = null;
	}
	public CommentResponseDTO(ReservationUserCommentEntity reservationUserCommentEntity, CommentImageDTO commentImage) {
		this(reservationUserCommentEntity);
		this.commentImage = commentImage;
	}
	
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
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "CommentResponseDTO [comment=" + comment + ", commentId=" + commentId + ", commentImage=" + commentImage
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", productId=" + productId
				+ ", reservationInfoId=" + reservationInfoId + ", score=" + score + "]";
	}
}
