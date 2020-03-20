package org.ggyool.reservation.service.impl;

import java.util.Date;

import org.ggyool.reservation.dao.FileInfoDAO;
import org.ggyool.reservation.entity.FileInfoEntity;
import org.ggyool.reservation.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FileInfoServiceImpl implements FileInfoService{

	@Autowired
	FileInfoDAO fileInfoDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public FileInfoEntity addFileInfo(FileInfoEntity fileInfoEntity) {
		Date currentDate = new Date();
		fileInfoEntity.setDeleteFlag(false);
		fileInfoEntity.setCreateDate(currentDate);
		fileInfoEntity.setModifyDate(currentDate);
		Integer id = fileInfoDAO.insert(fileInfoEntity);
		fileInfoEntity.setId(id);
		return fileInfoEntity;
	}

}
