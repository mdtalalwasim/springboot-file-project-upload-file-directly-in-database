/*
 * package com.mdtalalwasim.fileproject.service;
 * 
 * public interface FileService {
 * 
 * }
 */

package com.mdtalalwasim.fileproject.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	String uploadFile(MultipartFile file) throws IOException;
	
	byte[] downloadFile(String fileName);

}
