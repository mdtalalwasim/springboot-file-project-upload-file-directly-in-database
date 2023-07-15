/*
 * package com.mdtalalwasim.fileproject.utils;
 * 
 * public class FileUtils {
 * 
 * }
 */

package com.mdtalalwasim.fileproject.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class FileUtils {
	
	//encrypt/compressed image file before storing into DB
	
	public static byte[] compressImageFile(byte[] data) {
		Deflater deflater = new Deflater();
		
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(data);
		deflater.finish();
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(data.length);
		
		byte[] tmp = new byte[4*1024];
		
		while(!deflater.finished()) {
			int size = deflater.deflate(tmp);
			byteArrayOutputStream.write(tmp,0, size);
		}
		
		try {
			byteArrayOutputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return byteArrayOutputStream.toByteArray();
		
		
	}
	
	
	
	//get encrypted file from DB and decrypt/decompress it and showing it to client DB
	
	public static byte[] decompressImageFile(byte[] data) {
		
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(data.length);
		
		byte[] tmp = new byte[4*1024];
		try {
			while(!inflater.finished()) {
				int size = inflater.inflate(tmp);
				byteArrayOutputStream.write(tmp, 0, size);
			}
			
			byteArrayOutputStream.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return byteArrayOutputStream.toByteArray();
	}
	
	

}
