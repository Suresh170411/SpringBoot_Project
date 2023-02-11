package com.skilloVilla.service;

import java.util.List;

import com.skilloVilla.exception.BookException;
import com.skilloVilla.exception.UserException;
import com.skilloVilla.model.BookEntity;

public interface BookService {

	BookEntity addBook(BookEntity book);

	BookEntity getBookById(Integer id) throws BookException;

	BookEntity deleteBookById(Integer id) throws BookException;

	List<BookEntity> getBookByAuthor(String author) throws BookException;
	
	String issueBookToUser() throws BookException,UserException;
}
