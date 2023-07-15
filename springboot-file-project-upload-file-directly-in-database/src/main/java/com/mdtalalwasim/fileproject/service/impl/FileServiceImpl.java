/*
 * package com.mdtalalwasim.fileproject.service.impl;
 * 
 * import com.mdtalalwasim.fileproject.service.FileService;
 * 
 * public class FileServiceImpl implements FileService{
 * 
 * }
 */

package com.mdtalalwasim.fileproject.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mdtalalwasim.fileproject.entity.File;
import com.mdtalalwasim.fileproject.repository.FileRepository;
import com.mdtalalwasim.fileproject.service.FileService;
import com.mdtalalwasim.fileproject.utils.FileUtils;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileRepository filerepository;

	@Override
	public String uploadFile(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		File fileData = filerepository.save(File.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.fileData(FileUtils.compressImageFile(file.getBytes())).build());
		
		if(fileData!= null) {
				return "file uploaded successfully "+file.getOriginalFilename();
		}
		return null;
	}

	@Override
	public byte[] downloadFile(String fileName) {
		// TODO Auto-generated method stub
		
		
	Optional<File> dbImageData = filerepository.findByName(fileName);
	
	//got the file, now decompress it.
	byte[] decompressImageFile = FileUtils.decompressImageFile(dbImageData.get().getFileData());
	
	return decompressImageFile;
		
	}

	

}
