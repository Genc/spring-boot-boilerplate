package com.hiringglobal.mobile.service;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FirebaseStorageService {
    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = generateUniqueFileName(file.getOriginalFilename());
        InputStream inputStream = file.getInputStream();
//        String jsonKeyFilePath = "jobs.json";
//        System.out.println("Path to JSON key file: " + jsonKeyFilePath);
        // Đọc tệp JSON và thiết lập thông tin chứng thực
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("jobs.json"));
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();

        // Lấy dịch vụ lưu trữ
        Storage storage = storageOptions.getService();

        // Thay đổi BUCKET_NAME thành tên thực tế của bucket bạn muốn lưu trữ tệp lên.
        String bucketName = "jobs-d15c5.appspot.com";
        Bucket bucket = storage.get(bucketName);

        // Tạo đối tượng Blob và tải tệp lên bucket
        Blob blob = bucket.create("ApplicantCV"+"/"+fileName, inputStream, file.getContentType());
        return blob.getMediaLink();
    }
    public String uploadImg(MultipartFile file) throws IOException {
        String fileName = generateUniqueFileName(file.getOriginalFilename());
        InputStream inputStream = file.getInputStream();
        // Đọc tệp JSON và thiết lập thông tin chứng thực
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("jobs.json"));
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();

        // Lấy dịch vụ lưu trữ
        Storage storage = storageOptions.getService();

        // Thay đổi BUCKET_NAME thành tên thực tế của bucket bạn muốn lưu trữ tệp lên.
        String bucketName = "jobs-d15c5.appspot.com";
        Bucket bucket = storage.get(bucketName);

        // Tạo đối tượng Blob và tải tệp lên bucket
        Blob blob = bucket.create("ApplicantImages"+"/"+fileName, inputStream, file.getContentType());
        return blob.getMediaLink();
    }


    private String generateUniqueFileName(String originalFileName) {
        String uniqueFileName = UUID.randomUUID().toString();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return uniqueFileName + fileExtension;
    }

    public void deleteByName(String fileName) throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("jobs.json"));
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();

        // Lấy dịch vụ lưu trữ
        Storage storage = storageOptions.getService();

        // Thay đổi BUCKET_NAME thành tên thực tế của bucket bạn muốn lưu trữ tệp lên.
        String bucketName = "jobs-d15c5.appspot.com";
        Bucket bucket = storage.get(bucketName);

        // Tìm kiếm file theo tên trong bucket
        Blob blob = bucket.get(fileName);

        // Nếu file tồn tại, thì xóa nó
        if (blob != null) {
            blob.delete();
            System.out.println("Đã xóa file: " + fileName);
        } else {
            System.out.println("File không tồn tại: " + fileName);
        }
    }
    public String companyUploadImg(MultipartFile file) throws IOException {
        String fileName = generateUniqueFileName(file.getOriginalFilename());
        InputStream inputStream = file.getInputStream();
        // Đọc tệp JSON và thiết lập thông tin chứng thực
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("jobs.json"));
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();

        // Lấy dịch vụ lưu trữ
        Storage storage = storageOptions.getService();

        // Thay đổi BUCKET_NAME thành tên thực tế của bucket bạn muốn lưu trữ tệp lên.
        String bucketName = "jobs-d15c5.appspot.com";
        Bucket bucket = storage.get(bucketName);

        // Tạo đối tượng Blob và tải tệp lên bucket
        Blob blob = bucket.create("CompanyImages"+"/"+fileName, inputStream, file.getContentType());
        return blob.getMediaLink();
    }
}