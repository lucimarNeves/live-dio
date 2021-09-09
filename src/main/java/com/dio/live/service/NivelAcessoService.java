package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    @Autowired
    NivelAcessoRepository nivelAcessoRepository;

    public NivelAcesso save(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public List<NivelAcesso> findAll() {
        return nivelAcessoRepository.findAll();
    }

    public Optional<NivelAcesso> getById(Long idNivelAvesso) {

        return nivelAcessoRepository.findById(idNivelAvesso);
    }

    public NivelAcesso updateNivelAcesso(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public void deleteNivelAcesso(Long idNivelAcesso) {

        nivelAcessoRepository.deleteById(idNivelAcesso);
    }
}
