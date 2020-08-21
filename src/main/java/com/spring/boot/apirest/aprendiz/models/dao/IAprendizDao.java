package com.spring.boot.apirest.aprendiz.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.apirest.aprendiz.entity.Aprendiz;

public interface IAprendizDao extends CrudRepository<Aprendiz, Long>{
	
}
