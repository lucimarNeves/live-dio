package com.dio.live.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.live.model.Empresa;



public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
