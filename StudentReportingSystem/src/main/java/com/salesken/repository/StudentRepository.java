package com.salesken.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.salesken.model.Student;

public interface StudentRepository extends ElasticsearchRepository<Student, Integer>{

}
