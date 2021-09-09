package com.dio.live.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.live.model.Calendario;


public interface CalendarioRepository extends JpaRepository<Calendario, Long> {

}
