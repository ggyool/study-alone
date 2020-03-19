package org.ggyool.reservation.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.ggyool.reservation.dao.ReservationInfoDAO;
import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.entity.ReservationInfoEntity;
import org.ggyool.reservation.service.ReservationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService{
	
	@Autowired
	ReservationInfoDAO reservationInfoDAO;  
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ReservationInfoEntity addReservationInfo(ReservationParamDTO reservationParamDTO) {
		try {
			ReservationInfoEntity reservationInfoEntity = new ReservationInfoEntity(reservationParamDTO);
			reservationInfoEntity.setReservationDate(generateReservatioDate(reservationParamDTO.getReservationYearMonthDay()));
			Date currentDate = new Date();
			reservationInfoEntity.setModifyDate(currentDate);
			reservationInfoEntity.setCreateDate(currentDate);
			Integer id = reservationInfoDAO.insert(reservationInfoEntity);
			reservationInfoEntity.setReservationInfoId(id);
			return reservationInfoEntity;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	// 입력 시간으로 부터 1~5일후를 공연일으로 생성
	public Date generateReservatioDate(Date date) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date);
		Integer addSecond = 60*60*24 + (int)(Math.random() * 4*60*60*24);  
		calendar.add(Calendar.SECOND, addSecond);
		date = calendar.getTime();
		return date;
	}

	@Override
	public List<ReservationInfoEntity> getsByEmail(String reservationEmail) {
		return reservationInfoDAO.selectByEmail(reservationEmail);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean cancel(Integer reservationInfoId) {
		return reservationInfoDAO.updateAsCancel(reservationInfoId);
	}

	@Override
	public ReservationInfoEntity getById(Integer reservationInfoId) {
		return reservationInfoDAO.selectById(reservationInfoId);
	}
}




