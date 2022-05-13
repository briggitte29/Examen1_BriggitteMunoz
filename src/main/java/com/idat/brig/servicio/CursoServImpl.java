package com.idat.brig.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.brig.dto.CursoDTORequest;
import com.idat.brig.dto.CursoDTOResponse;
import com.idat.brig.models.Curso;
import com.idat.brig.repository.CursoRepository;

@Service
public class CursoServImpl implements CursoServic {
	
	@Autowired
	private CursoRepository repositorio;

	@Override
	public void guardarCurso(CursoDTORequest curso) {
		Curso c= new Curso();
		c.setCurso(curso.getCursoDTO());
		c.setIdCurso(curso.getIdCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		c.setIdMalla(curso.getIdMallaDTO());
		
		repositorio.save(c);		
	}

	@Override
	public void editarCurso(CursoDTORequest curso) {
		Curso c= new Curso();
		c.setCurso(curso.getCursoDTO());
		c.setIdCurso(curso.getIdCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		c.setIdMalla(curso.getIdMallaDTO());
		
		repositorio.saveAndFlush(c);			
	}

	@Override
	public void eliminarCurso(Integer id) {
		repositorio.deleteById(id);		
	}

	@Override
	public List<CursoDTOResponse> listarCurso() {
		List<CursoDTOResponse> lista= new ArrayList<CursoDTOResponse>();
		CursoDTOResponse c=null;
		
		for(Curso curso: repositorio.findAll()) {
			c= new CursoDTOResponse();
			
			c.setCursoDTO(curso.getCurso());
			c.setIdCursoDTO(curso.getIdCurso());
			c.setDescripcionDTO(curso.getDescripcion());
			c.setIdMallaDTO(c.getIdMallaDTO());
			
			lista.add(c);
		}
		return lista;
	}

	@Override
	public CursoDTOResponse obtenerCursoId(Integer id) {
		Curso curso= repositorio.findById(id).orElse(null);
		CursoDTOResponse c= new CursoDTOResponse();
		
		c.setCursoDTO(curso.getCurso());
		c.setIdCursoDTO(curso.getIdCurso());
		c.setDescripcionDTO(curso.getDescripcion());
		c.setIdMallaDTO(c.getIdMallaDTO());
		
		return c;
	}

}
