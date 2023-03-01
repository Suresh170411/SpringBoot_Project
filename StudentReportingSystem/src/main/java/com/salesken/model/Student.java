package com.salesken.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "student")
public class Student {

	@Id
	private Integer roll;
	private String name;
	private String location;
	private Integer marks;
}
