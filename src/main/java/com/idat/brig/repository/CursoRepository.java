package com.idat.brig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.brig.models.Curso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
