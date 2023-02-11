package com.skilloVilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilloVilla.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
