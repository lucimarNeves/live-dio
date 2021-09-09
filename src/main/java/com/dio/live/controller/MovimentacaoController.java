package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.Movimentacao;
import com.dio.live.repository.MovimentacaoRepository;
import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @PostMapping(value = "salvarMovimentacao")
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.save(movimentacao);
    }

    @GetMapping(value = "/listarMovimentacao")
    public List<Movimentacao> getMovimentacaoList(){
        return movimentacaoService.findAll();
    }

    @GetMapping(value = "buscarPorId/{idMovimentacao}")
    public ResponseEntity<Movimentacao> getMovimentacaoById(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception{
        return ResponseEntity.ok(movimentacaoService.getById(idMovimentacao).orElseThrow(()
                -> new NoSuchElementException("movimentacao não encontrada")));

    }

    @PutMapping(value = "alterarMovimentacao")
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.updateMovimentacao(movimentacao);
    }

    @DeleteMapping(value="deletar/{idMovimentacao}")
    public ResponseEntity deleteByID(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception {
        try {
            movimentacaoService.deleteMovimentacao(idMovimentacao);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found",e);
        }
        return (ResponseEntity<Movimentacao>) ResponseEntity.ok();

    }
}
