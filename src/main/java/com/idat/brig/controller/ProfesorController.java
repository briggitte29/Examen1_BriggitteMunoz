package com.idat.brig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.brig.dto.ProfesorDTORequest;
import com.idat.brig.dto.ProfesorDTOResponse;
import com.idat.brig.servicio.ProfesorServic;


public class ProfesorController {

	
	@Autowired
	private ProfesorServic servicio;
	
	@RequestMapping(path= "/listar", method= RequestMethod.GET)
	public ResponseEntity< List<ProfesorDTOResponse>> listarProfesor(){
		
		return new ResponseEntity<List<ProfesorDTOResponse>>(servicio.listarProfesor(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path= "/guardar", method= RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProfesorDTORequest profesor){
		servicio.guardarProfesor(profesor);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path= "/listar{id}", method= RequestMethod.GET)
	public ResponseEntity<ProfesorDTOResponse> listarPorId(@PathVariable Integer id) {
		
		ProfesorDTOResponse pr= servicio.obtenerProfesorId(id);
			
			if(pr !=null)
				return new ResponseEntity<ProfesorDTOResponse>(pr, HttpStatus.OK);
			
			return new ResponseEntity<ProfesorDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path= "/editar/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ProfesorDTORequest profesor){
		
		ProfesorDTOResponse pr= servicio.obtenerProfesorId(profesor.getIdProfesorDTO());
		
		if(pr !=null) {
			servicio.editarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@RequestMapping(path= "/eliminar/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@RequestBody Integer id){
		
		ProfesorDTOResponse m= servicio.obtenerProfesorId(id);
		
		if(m !=null) {
			servicio.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
}
