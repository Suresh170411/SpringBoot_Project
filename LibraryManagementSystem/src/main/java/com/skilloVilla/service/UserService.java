package com.skilloVilla.service;

import com.skilloVilla.exception.UserException;
import com.skilloVilla.model.UserEntity;

public interface UserService {
	
	UserEntity registerUser();
	UserEntity getUserById(Integer id) throws UserException;
	UserEntity deleteUser(Integer id) throws UserException;
	UserEntity updateUser(Integer id, UserEntity user) throws UserException;
}
