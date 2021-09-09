package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipoData")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @Autowired
    TipoDataRepository tipoDataRepository;

    @PostMapping(value = "salvarTipoData")
    public TipoData createTipoData(@RequestBody TipoData tipoData) {
        return tipoDataService.save(tipoData);
    }

    @GetMapping(value = "/listarTipoData")
    public List<TipoData> getTipoDataList(){
        return tipoDataService.findAll();
    }

    @GetMapping(value = "buscarPorId/{idTipoData}")
    public ResponseEntity<TipoData> getTipoDataById(@PathVariable("idTipoData") Long idTipoData) throws Exception{
        return ResponseEntity.ok(tipoDataService.getById(idTipoData).orElseThrow(()
                -> new NoSuchElementException("tipo data não encontrada")));

    }

    @PutMapping(value = "/alterarTipoData")
    public TipoData updateTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.updateTipoData(tipoData);
    }

    @DeleteMapping(value = "deletar/{idTipoData}")
    public ResponseEntity deleteByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
        try {
            tipoDataService.deleteTipoData(idTipoData);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found",e);
        }
        return (ResponseEntity<TipoData>) ResponseEntity.ok();

    }


}
