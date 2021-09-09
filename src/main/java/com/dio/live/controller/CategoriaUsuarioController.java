package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.CategoriaUsuarioRepository;
import com.dio.live.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/categoria-usuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @Autowired
    CategoriaUsuarioRepository categoriaUsuarioRepository;


    @PostMapping(value="salvarCategoriaUsuario")
    public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.save(categoriaUsuario);
    }

    @GetMapping(value ="/listarCategoriaUsuario")
    public List<CategoriaUsuario> getCategoriaUsuarioList(){
        return categoriaUsuarioService.findAll();
    }

    @GetMapping(value="/buscarCategoriaUsuarioPorId/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioById(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception{
        return ResponseEntity.ok(categoriaUsuarioService.getById(idCategoriaUsuario).orElseThrow(()
                -> new NoSuchElementException("jornada não encontrada")));

    }

    @PutMapping(value = "/alterarCategoriaUsuario")
    public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.updateCategoriaUsuario(categoriaUsuario);
    }

    @DeleteMapping(value="deletar/{idCategoriaUsuario}")
    public ResponseEntity deleteByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception {
        try {
            categoriaUsuarioService.deleteCategoriaUsuario(idCategoriaUsuario);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found",e);
        }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();

    }


}
