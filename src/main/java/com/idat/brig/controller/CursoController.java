package com.idat.brig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.brig.dto.CursoDTORequest;
import com.idat.brig.dto.CursoDTOResponse;
import com.idat.brig.servicio.CursoServic;


@RestController
@RequestMapping("/curso/v3")
public class CursoController {
	
	@Autowired
	private CursoServic servicio;
	
	@RequestMapping(path= "/listar", method= RequestMethod.GET)
	public ResponseEntity< List<CursoDTOResponse>> listarCurso(){
		
		return new ResponseEntity<List<CursoDTOResponse>>(servicio.listarCurso(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path= "/guardar", method= RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody CursoDTORequest curso){
		servicio.guardarCurso(curso);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path= "/listar{id}", method= RequestMethod.GET)
	public ResponseEntity<CursoDTOResponse> listarPorId(@PathVariable Integer id) {
		
		CursoDTOResponse c= servicio.obtenerCursoId(id);
			
			if(c !=null)
				return new ResponseEntity<CursoDTOResponse>(c, HttpStatus.OK);
			
			return new ResponseEntity<CursoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path= "/editar/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody CursoDTORequest curso){
		
		CursoDTOResponse c= servicio.obtenerCursoId(curso.getIdCursoDTO());
		
		if(c !=null) {
			servicio.editarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@RequestMapping(path= "/eliminar/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@RequestBody Integer id){
		
		CursoDTOResponse c= servicio.obtenerCursoId(id);
		
		if(c !=null) {
			servicio.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}

}
