package com.spring.boot.apirest.aprendiz.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.apirest.aprendiz.entity.Aprendiz;
import com.spring.boot.apirest.aprendiz.models.dao.IAprendizDao;

@Service
public class AprendizServiceImpl implements IAprendizService{
	
	@Autowired
	private IAprendizDao aprendizDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Aprendiz> findAll() {
		
		return (List<Aprendiz>) aprendizDao.findAll();
	}

	@Override
	public Aprendiz save(Aprendiz aprendiz) {
		return aprendizDao.save(aprendiz);
	}

	@Override
	public Aprendiz findById(Long id) {
		return aprendizDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		aprendizDao.deleteById(id);
	}
	
}
