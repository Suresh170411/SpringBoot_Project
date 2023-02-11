package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	private Integer student_id;
	
	private String student_name;
	
	private Integer marks;
	
	@OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
	private Laptop laptop;
}
