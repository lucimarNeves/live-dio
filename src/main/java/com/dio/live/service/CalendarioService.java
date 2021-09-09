package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.Calendario;
import com.dio.live.repository.CalendarioRepository;

@Service
public class CalendarioService {
	
	@Autowired
	CalendarioRepository calendarioRepository;
	
	
	public Calendario save(Calendario calendario) {
		return calendarioRepository.save(calendario);
	}
	
	public List<Calendario> findAll(){
		return calendarioRepository.findAll();
	}
	
	public Optional<Calendario>getById(Long idCalendario){
		return calendarioRepository.findById(idCalendario);
	}
	
	public Calendario updateCalendario(Calendario calendario) {
		return calendarioRepository.save(calendario);
	}
	
	public void delete(long idCalendario) {
		calendarioRepository.deleteById(idCalendario);
	}

}
