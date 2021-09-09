package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping(value ="/salvarEmpresa")
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @GetMapping(value= "/listarEmpresa")
    public List<Empresa> getEmpresaList(){
        return empresaService.findAll();
    }

    @GetMapping(value="buscarPorId/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("idEmpresa") Long idEmpresa) throws Exception{
        return ResponseEntity.ok(empresaService.getById(idEmpresa).orElseThrow(()
                -> new NoSuchElementException("empresa não encontrada")));

    }

    @PutMapping(value="alterarEmpresa/{idEmpresa}")
    public Empresa updateEmpresa(@RequestBody Empresa empresa){
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping(value="deletar/{idEmpresa}")
    public ResponseEntity<Empresa> deleteByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        try {
            empresaService.deleteEmpresa(idEmpresa);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found",e);
        }
        return (ResponseEntity<Empresa>) ResponseEntity.ok();

    }


}
