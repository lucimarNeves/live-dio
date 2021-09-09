package com.dio.live.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.live.model.BancoHoras;

public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long> {

}
