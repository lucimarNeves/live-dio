package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.BancoHorasRepository;
import com.dio.live.service.BancoHoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {

    @Autowired
    BancoHorasRepository bancoHorasRepository;

    @Autowired
    BancoHoraService bancoHoraService;

    @PostMapping(value = "/salvarBancoHoras")
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHoraService.saveBancoHoras(bancoHoras);
    }

    @GetMapping(value = "/listarBancoHoras")
    public List<BancoHoras> getBancoHorasList() {
        return bancoHoraService.findAll();
    }

    @GetMapping(value = "/buscarPorId/{idBancoHoras}")
    public ResponseEntity<BancoHoras> getBancoHoraById(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        return ResponseEntity.ok(bancoHoraService.getById(idBancoHoras).orElseThrow(()
                -> new NoSuchElementException("Banco Horas não encontrado")));
    }

    @PutMapping(value = "AlterarBancoHoras")
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHoraService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping(value = "deletar/{idBancoHoras}")
    public ResponseEntity deleteByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        try {
            bancoHoraService.deleteItemBancoHoras(idBancoHoras);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found", e);
        }
        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();

    }
}
