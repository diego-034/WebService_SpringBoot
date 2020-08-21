package com.spring.boot.apirest.aprendiz.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.apirest.aprendiz.entity.Aprendiz;
import com.spring.boot.apirest.aprendiz.services.IAprendizService;

@RestController
@RequestMapping("/api")
public class AprendizRestController {
	
	@Autowired
	private IAprendizService aprendizService;
	
	@GetMapping("/aprendices")
	public List<Aprendiz> index(){
		return aprendizService.findAll();
	}
	
	@PostMapping("/aprendices")
	@ResponseStatus(HttpStatus.CREATED)
	public Aprendiz create(@RequestBody Aprendiz aprendiz) {
		return aprendizService.save(aprendiz);
	}
	
	@PostMapping("/aprendices/{id}")
	public Aprendiz show(@PathVariable Long id) {
		return aprendizService.findById(id);
	}
	
	@DeleteMapping("/aprendices/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		aprendizService.delete(id);
	}
	
	@PutMapping("/aprendices/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Aprendiz update(@PathVariable Long id, @RequestBody Aprendiz aprendiz) {
		Aprendiz aprendizActual = aprendizService.findById(id);
		aprendizActual.setNombre(aprendiz.getNombre());
		aprendizActual.setApellido(aprendiz.getApellido());
		return aprendizService.save(aprendizActual);
	}
}
