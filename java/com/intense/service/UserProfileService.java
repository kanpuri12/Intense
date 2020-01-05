package com.intense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intense.dto.GenericResponse;
import com.intense.dto.UserProfileDto;
import com.intense.model.UserProfile;
import com.intense.repository.UserProfileRepository;
import com.intense.util.StatusCodeConstants;

@Service
public class UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepository;

	public GenericResponse saveUserProfile(UserProfileDto userProfileDto) {
		GenericResponse genericResponse = new GenericResponse();
		UserProfile userProfile = new UserProfile();
		userProfile.setName(userProfileDto.getName());
		userProfile.setGender(userProfileDto.getGender());
		userProfile.setDateofBirth(userProfileDto.getDateofBirth());
		UserProfile save = userProfileRepository.save(userProfile);
		if (save != null) {
			genericResponse.setStatusCode(StatusCodeConstants.SUCCESS);
			genericResponse.setStatusDesc(save.getName() + " has Successfully Registered");
		}
		return genericResponse;

	}
}
