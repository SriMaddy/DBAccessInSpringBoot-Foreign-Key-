package com.example.dbaccess.datasource.mysql.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dbaccess.datasource.mysql.domain.Author;

@Repository
public interface BookDetailRepo extends CrudRepository<Author, Long> {

}
