/*
 * package com.mdtalalwasim.fileproject.controller.rest;
 * 
 * public class FileRestController {
 * 
 * }
 */

package com.mdtalalwasim.fileproject.controller.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mdtalalwasim.fileproject.service.FileService;

@RestController
@RequestMapping("/api")
public class FileRestController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/file-upload")
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException{
		String uploadFile = fileService.uploadFile(file);
		
		return ResponseEntity.status(HttpStatus.OK).body(uploadFile);
		
		 
	}
	
	@GetMapping("/file-download/{fileName}")
	public ResponseEntity<?> downloadFile(@PathVariable String fileName){
		byte[] downloadFile = fileService.downloadFile(fileName);
				
		
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(downloadFile);
	}
	
	

}
