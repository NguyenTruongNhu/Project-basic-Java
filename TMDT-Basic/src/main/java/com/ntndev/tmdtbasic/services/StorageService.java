package com.ntndev.tmdtbasic.services;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    void init();
    void store(MultipartFile file);

}
