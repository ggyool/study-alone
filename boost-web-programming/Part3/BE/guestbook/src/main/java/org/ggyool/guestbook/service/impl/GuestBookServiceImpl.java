package org.ggyool.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.ggyool.guestbook.dao.GuestBookDao;
import org.ggyool.guestbook.dao.LogDao;
import org.ggyool.guestbook.dto.GuestBook;
import org.ggyool.guestbook.dto.Log;
import org.ggyool.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	

	@Autowired
	GuestBookDao guestBookDao;
	@Autowired
	LogDao logDao;
	
	
	// 읽어드리기만 하는 method 는  @Transactional 을 붙여주면 내부적으로 readonly로 처리하게된다.
	@Override
	@Transactional
	public List<GuestBook> getGuestBooks(Integer start) {
		return guestBookDao.selectAll(start, LIMIT);
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteGuestBook(Long id, String ip) {
		int deleteCount = guestBookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return deleteCount;
	}

	@Override
	@Transactional(readOnly=false)
	public GuestBook addGuestBook(GuestBook guestBook, String ip) {
		guestBook.setRegdate(new Date());
		Long id = guestBookDao.insert(guestBook);
		guestBook.setId(id);
		
		// log insert 에서 에러니도 @Transaction을 넣었기 때문에 guestBook 롤백된다. 
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		return guestBook;
	}

	@Override
	public int getCount() {
		return guestBookDao.selectCount();
	}
	
}
