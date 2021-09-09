package com.dio.live.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.live.repository.BancoHorasRepository;
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

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
	
	
	@Autowired
	JornadaService jornadaService;


	@PostMapping
	public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaService.save(jornadaTrabalho);
	}
	
	@GetMapping("/list")
	public List<JornadaTrabalho> getJornadaList(){
		 return jornadaService.findAll();
	}
	
	@GetMapping("/{idJornada}")
	public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception{
		return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(()
				-> new NoSuchElementException("jornada não encontrada")));
		
	}
	
	@PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
       try {
           jornadaService.deleteJornada(idJornada);
       }catch (Exception e){
        throw new ResponseStatusException(
           HttpStatus.NOT_FOUND, "Actor Not Found",e);
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }
}
