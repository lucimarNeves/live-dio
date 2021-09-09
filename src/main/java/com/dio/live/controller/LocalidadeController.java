package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;
import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController  {

    @Autowired
    LocalidadeService localidadeService;

    @Autowired
    LocalidadeRepository localidadeRepository;

    @PostMapping(value="/salvarLocalidade")
    public Localidade createLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.save(localidade);
    }

    @GetMapping(value= "/listarLocalidade")
    public List<Localidade> getLocalidadeList(){
        return localidadeService.findAll();
    }

    @GetMapping(value = "buscarPorId/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable("idLocalidade") Long idLocalidade) throws Exception{
        return ResponseEntity.ok(localidadeService.getById(idLocalidade).orElseThrow(()
                -> new NoSuchElementException("localidade não encontrada")));

    }

    @PutMapping(value = "alterarLocalidade")
    public Localidade updateLocalidade(@RequestBody Localidade localidade){
        return localidadeService.updateLocalidade(localidade);
    }

    @DeleteMapping(value = "deletar/{idLocalidade}")
    public ResponseEntity deleteByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        try {
            localidadeService.deleteLocalidade(idLocalidade);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found",e);
        }
        return (ResponseEntity<Localidade>) ResponseEntity.ok();

    }

}
