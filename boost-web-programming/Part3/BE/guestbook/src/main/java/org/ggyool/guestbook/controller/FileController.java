package org.ggyool.guestbook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/uploadform")
	public String uploadform() {
		return "uploadform";
	}
	
	@PostMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		
		logger.info("파일이름 {}",file.getOriginalFilename());
		logger.info("파일크기 {}",file.getSize());
		
		try {
			file.transferTo(new File("/tmp/" + file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		/*
		try (
			FileOutputStream fos = new FileOutputStream("/tmp/" + file.getOriginalFilename());
			InputStream is = file.getInputStream();
		){
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while((readCount=is.read(buffer)) != -1) {
				fos.write(buffer,0,readCount);
			}
		}
		catch(Exception ex){
			throw new RuntimeException("file save error");
		}	*/
		return "uploadok";
	}
	
	@GetMapping("download")
	public void download(HttpServletResponse response) {
		// 파일 정보를 직접 입력했지만, db에서 가져왔다고 가정.
		String fileName = "test_image.png";
		String saveFileName = "/tmp/test_image.png";
		String contentType = "image/png";
		int fileLength = 202403;
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", "" + fileLength);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
		
        try(
        	FileInputStream fis = new FileInputStream(saveFileName);
        	OutputStream out = response.getOutputStream();
        ){
        	int readCount = 0;
        	byte[] buffer = new byte[1024];
        	while((readCount=fis.read(buffer))!=-1) {
        		out.write(buffer,0,readCount);
        	}
        }
        catch(Exception ex){
        	throw new RuntimeException("file Save Error");
        }
	}
	
	
	
}
