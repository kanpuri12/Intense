package com.intense.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intense.dto.GenericResponse;
import com.intense.dto.UserProfileDto;
import com.intense.exception.ResourceNotFoundException;
import com.intense.exception.UnknownException;
import com.intense.service.UserProfileService;

@RestController
public class UserProfileController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserProfileService userProfileService;

	@PostMapping("/userProfile/add")
	@Transactional
	public GenericResponse addUserProfile(@Valid @RequestBody UserProfileDto userProfileDto) {
		GenericResponse genericResponse = new GenericResponse();

		try {
			genericResponse = userProfileService.saveUserProfile(userProfileDto);

		} catch (Exception e) {
			if (e instanceof ResourceNotFoundException) {
				throw new ResourceNotFoundException(e.getMessage());
			} else {
				throw new UnknownException(e.getMessage());
			}
		}
		return genericResponse;

	}
}
