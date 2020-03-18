package org.ggyool.reservation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.ggyool.reservation.dto.DisplayInfoImageDTO;
import org.ggyool.reservation.dto.ProductImageDTO;
import org.ggyool.reservation.service.CommentImageService;
import org.ggyool.reservation.service.DisplayInfoImageService;
import org.ggyool.reservation.service.ProductImageService;
import org.ggyool.reservation.vo.CommentImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="download")
public class FileController {
	
	@Autowired
	CommentImageService commentImageService;
	@Autowired
	ProductImageService ProductImageService;
	@Autowired
	DisplayInfoImageService displayInfoImageService;
	
	@GetMapping("/comment-image/{commentImageId}")
	public void commentImageDownload(@PathVariable("commentImageId") Integer commentImageId,
			HttpServletResponse response) {
		CommentImageVO commentImageVO = commentImageService.getById(commentImageId);
		String fileName = commentImageVO.getFileName();
		String saveFileName = "/tmp/" + commentImageVO.getSaveFileName();
		String contentType = commentImageVO.getContentType();
		File file = new File(saveFileName);
		int fileLength = (int)file.length();
		
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
        		out.write(buffer, 0, readCount);
        	}
        }catch(Exception ex) {
        	throw new RuntimeException("File Save Error");
        }
	}
	
	@GetMapping("/product-thumbnail-image/{productId}")
	public void productThumbnailImageDownload(@PathVariable("productId") Integer productId,
			HttpServletResponse response) {
		ProductImageDTO productImageDTO = ProductImageService.getThumbnailImage(productId);
		String fileName = productImageDTO.getFileName();
		String saveFileName = "/tmp/" + productImageDTO.getSaveFileName();
		String contentType = productImageDTO.getContentType();
		File file = new File(saveFileName);
		int fileLength = (int)file.length();
		
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
        		out.write(buffer, 0, readCount);
        	}
        }catch(Exception ex) {
        	throw new RuntimeException("File Save Error");
        }
	}
	
	@GetMapping("/product-image/{productImageId}")
	public void productImageDownload(@PathVariable("productImageId") Integer productImageId,
			HttpServletResponse response) {
		ProductImageDTO productImageDTO = ProductImageService.get(productImageId);
		String fileName = productImageDTO.getFileName();
		String saveFileName = "/tmp/" + productImageDTO.getSaveFileName();
		String contentType = productImageDTO.getContentType();
		File file = new File(saveFileName);
		int fileLength = (int)file.length();
		
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
        		out.write(buffer, 0, readCount);
        	}
        }catch(Exception ex) {
        	throw new RuntimeException("File Save Error");
        }
	}
	
	@GetMapping("/display-image/{displayInfoId}")
	public void displayImageDownload(@PathVariable("displayInfoId") Integer displayInfoId,
			HttpServletResponse response) {
		DisplayInfoImageDTO displayInfoImageDTO = displayInfoImageService.getImage(displayInfoId);
		String fileName = displayInfoImageDTO.getFileName();
		String saveFileName = "/tmp/" + displayInfoImageDTO.getSaveFileName();
		String contentType = displayInfoImageDTO.getContentType();
		File file = new File(saveFileName);
		int fileLength = (int)file.length();
		
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
        		out.write(buffer, 0, readCount);
        	}
        }catch(Exception ex) {
        	throw new RuntimeException("File Save Error");
        }
	}
	
}
