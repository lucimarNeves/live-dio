package com.dio.live.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.live.model.Ocorrencia;



public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

}
