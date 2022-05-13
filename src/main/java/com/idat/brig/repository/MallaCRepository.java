package com.idat.brig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.brig.models.MallaCurricural;

@Repository
public interface MallaCRepository extends JpaRepository<MallaCurricural, Integer>{

}
