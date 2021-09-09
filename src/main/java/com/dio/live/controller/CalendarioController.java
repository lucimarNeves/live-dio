package com.dio.live.controller;


import java.util.List;
import java.util.NoSuchElementException;

import com.dio.live.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;


@RestController
@RequestMapping("/calendario")
public class CalendarioController {

	@Autowired
	CalendarioService calendarioService;

	@Autowired
	CalendarioRepository calendarioRepository;

	@PostMapping(value="/salvarCalendario")
	public Calendario createCalendario(@RequestBody Calendario calendario) {
		return calendarioService.save(calendario);
	}
	
	@GetMapping(value="/listarItensCalendario")
	public List<Calendario> getCalendarioList(){
		return calendarioService.findAll();
	}
	
	@GetMapping(value="/buscarPorIdCalendario/{idCalendario}")
	public ResponseEntity<Calendario> getCalendarioById(@PathVariable("idCalendario") Long idCalendario) throws Exception{
		return ResponseEntity.ok(calendarioService.getById(idCalendario).orElseThrow(()
				-> new NoSuchElementException("Item calendário não encontrado")));
	}
	
	@PutMapping(value="/alterarCalendario")
	public Calendario updateCalendario(@RequestBody Calendario calendario) {
		return calendarioService.updateCalendario(calendario);
	}
	
	@DeleteMapping("deletarItemCalendario/{idCalendario}")
    public ResponseEntity deleteByID(@PathVariable("idCalendario") Long idCalendario) throws Exception {
       try {
    	   calendarioService.delete(idCalendario);
       }catch (Exception e){
        throw new ResponseStatusException(
           HttpStatus.NOT_FOUND, "Actor Not Found",e);
        }
        return (ResponseEntity<Calendario>) ResponseEntity.ok();

    }
	

}
