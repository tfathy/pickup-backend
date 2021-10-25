package com.customer.pickup.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.customer.pickup.entity.OrderImages;
import com.customer.pickup.entity.shared.UploadFileResponse;
import com.customer.pickup.serviceimpl.OrderImagesService;
import com.customer.pickup.services.FileStorageService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/attachment")
public class ImagesController {
	final Logger logger = LoggerFactory.getLogger(ImagesController.class);
	
	@Autowired
	private OrderImagesService orderImagesService;
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping(value="/order-images", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<OrderImages> saveImages(@RequestBody OrderImages entity){
		OrderImages result = orderImagesService.save(entity);
		if(result==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@ApiOperation(value = "upload a file to the server", notes = "The Api used to upload a file to the server", response = UploadFileResponse.class)
	@PostMapping(value = "/upload", produces = { MediaType.APPLICATION_JSON_VALUE })
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		
		String fileName = fileStorageService.storeFile(file);
	
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/file/download/")
				.path(fileName).toUriString();
		
		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

	@ApiOperation(value = "download a file from the server", notes = "The Api used to download a file from  the server", response = Resource.class)
	@GetMapping(value = "/download/{fileName:.+}", produces = { MediaType.IMAGE_JPEG_VALUE })
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = fileStorageService.loadFileAsResource(fileName);
		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@ApiOperation(value = "upload multiple files to the server", notes = "The Api used to upload multiple files to the server", response = Resource.class)
	@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}
	

}
