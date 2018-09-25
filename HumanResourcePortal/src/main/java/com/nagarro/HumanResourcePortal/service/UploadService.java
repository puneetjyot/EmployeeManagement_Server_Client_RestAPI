package com.nagarro.HumanResourcePortal.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	void uploadList(MultipartFile file);

}
