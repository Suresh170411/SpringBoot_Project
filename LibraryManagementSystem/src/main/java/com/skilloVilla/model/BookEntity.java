package com.skilloVilla.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer book_id;
	
	private String book_name;
	
	private LocalDateTime issue_date;
	
	@OneToOne()
	private UserEntity user;
}
