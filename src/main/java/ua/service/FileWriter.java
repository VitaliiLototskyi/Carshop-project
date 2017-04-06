package ua.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	public enum Folder{
		CAR
	}
	
	boolean write(Folder folder, MultipartFile file, int id);
}
