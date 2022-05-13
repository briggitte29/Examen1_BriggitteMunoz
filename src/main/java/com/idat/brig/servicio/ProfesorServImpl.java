package com.idat.brig.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.brig.dto.ProfesorDTORequest;
import com.idat.brig.dto.ProfesorDTOResponse;
import com.idat.brig.models.Profesor;
import com.idat.brig.repository.ProfesorRepository;

@Service
public class ProfesorServImpl implements ProfesorServic {
	
	@Autowired
	public ProfesorRepository repositorio;

	@Override
	public void guardarProfesor(ProfesorDTORequest profesor) {
		Profesor pr= new Profesor();
		pr.setProfesor(profesor.getProfesorDTO());
		pr.setIdProfesor(profesor.getIdProfesorDTO());
		
		repositorio.save(pr);
	}
	
	@Override
	public void editarProfesor(ProfesorDTORequest profesor) {
		Profesor pr= new Profesor();
		pr.setProfesor(profesor.getProfesorDTO());
		pr.setIdProfesor(profesor.getIdProfesorDTO());
		
		repositorio.saveAndFlush(pr);		
	}

	@Override
	public void eliminarProfesor(Integer id) {
		repositorio.deleteById(id);			
	}

	@Override
	public List<ProfesorDTOResponse> listarProfesor() {
		List<ProfesorDTOResponse> lista= new ArrayList<ProfesorDTOResponse>();
		ProfesorDTOResponse pr= null;
		
		for(Profesor profesor: repositorio.findAll()) {
			pr.setProfesorDTO(profesor.getProfesor());
			pr.setIdProfesorDTO(profesor.getIdProfesor());
			
			lista.add(pr);
			
		}
		return lista;
	}

	@Override
	public ProfesorDTOResponse obtenerProfesorId(Integer id) {
		Profesor profesor= repositorio.findById(id).orElse(null);
		ProfesorDTOResponse pr= new ProfesorDTOResponse();
		
		pr.setProfesorDTO(profesor.getProfesor());
		pr.setIdProfesorDTO(profesor.getIdProfesor());
		return pr;
	}

}
