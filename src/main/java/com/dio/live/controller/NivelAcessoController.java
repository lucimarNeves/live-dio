package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivel-acesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @Autowired
    NivelAcessoRepository nivelAcessoRepository;

    @PostMapping(value = "/salvarNivelAcesso")
    public NivelAcesso createNiveAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.save(nivelAcesso);
    }

    @GetMapping(value = "/listarNivelAcesso")
    public List<NivelAcesso> getNivelAcessoList(){
        return nivelAcessoService.findAll();
    }

    @GetMapping(value = "buscarPorId/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoById(@PathVariable("idNivelAcesso") Long idNivelAcesso) throws Exception{
        return ResponseEntity.ok(nivelAcessoService.getById(idNivelAcesso).orElseThrow(()
                -> new NoSuchElementException("nivel acesso não encontrado")));

    }

    @PutMapping(value = "/alterarNivelAcesso")
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.updateNivelAcesso(nivelAcesso);
    }

    @DeleteMapping(value = "deletar/{idNivelAcesso}")
    public ResponseEntity deleteByID(@PathVariable("idNivelAcesso") Long idNivelAcesso) throws Exception {
        try {
            nivelAcessoService.deleteNivelAcesso(idNivelAcesso);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found",e);
        }
        return (ResponseEntity<NivelAcesso>) ResponseEntity.ok();

    }
}
