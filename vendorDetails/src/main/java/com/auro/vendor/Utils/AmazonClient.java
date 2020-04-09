package com.auro.vendor.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.auro.vendor.custom.exception.BusinessException;
import com.auro.vendor.dao.VendorInfoDao;
import com.auro.vendor.model.VendorInfo;

@Service
public class AmazonClient {

	@Autowired
	private VendorInfoDao vendorInfoDao;

	private AmazonS3 s3client;

	@Value("${endpointUrl}")
	private String endpointUrl;
	@Value("${bucketName}")
	private String bucketName;
	@Value("${accessKey}")
	private String accessKey;
	@Value("${secretKey}")
	private String secretKey;

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	private void uploadFileTos3bucket(String fileName, File file) {
		s3client.putObject(
				new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public String uploadFile(int vendorId, MultipartFile multipartFile) {
		VendorInfo vendorInfo = vendorInfoDao.findByVendorId(vendorId);
		if (!Objects.nonNull(vendorInfo)) {
			throw new BusinessException("Vendor details not fount to  upload profile photo");
		}
		String dirStructure = "/" + vendorInfo.getVendorId() + "_Vendor/";
		String fileUrl = "";
		try {
			File file = convertMultiPartToFile(multipartFile);
			String fileName = generateFileName(multipartFile);
			fileUrl = endpointUrl + "/" + bucketName + "/" + dirStructure + fileName;
			uploadFileTos3bucket(fileName, file);
			file.delete();
			vendorInfo.setPhoto(fileUrl);
			vendorInfoDao.save(vendorInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}

	public String deleteFileFromS3Bucket(String fileUrl) {
		String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
		s3client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
		return "Successfully deleted";
	}
}
