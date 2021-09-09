package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.Usuario;
import com.dio.live.repository.UsuarioRepository;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping(value = "/salvarUsuario")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping(value = "/listarUsuario")
    public List<Usuario> getUsuarioList(){
        return usuarioService.findAll();
    }

    @GetMapping(value = "buscarPorId/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario") Long idUsuario) throws Exception{
        return ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(()
                -> new NoSuchElementException("usuario não encontrado")));

    }

    @PutMapping(value = "/alterarUsuario")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping(value = "deletar/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        try {
            usuarioService.deleteUsuario(idUsuario);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Not Found",e);
        }
        return (ResponseEntity<Usuario>) ResponseEntity.ok();

    }

}
