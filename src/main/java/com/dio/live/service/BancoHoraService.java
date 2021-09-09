package com.dio.live.service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHoraService {

    @Autowired
    BancoHorasRepository bancoHorasRepository;

    public BancoHoras saveBancoHoras(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> findAll(){
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> getById(Long idBancoHoras){
        return bancoHorasRepository.findById(idBancoHoras);
    }
    public BancoHoras updateBancoHoras(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }
    public void deleteItemBancoHoras(Long idBancoHoras){
        bancoHorasRepository.deleteById(idBancoHoras);
    }
}
