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

import com.idat.brig.dto.MallaCuDTORequest;
import com.idat.brig.dto.MallaCuDTOResponse;
import com.idat.brig.servicio.MallaCuServic;


@RestController
@RequestMapping("/mallacurri/v2")
public class MallaCuController {

	
	@Autowired
	private MallaCuServic servicio;
	
	@RequestMapping(path= "/listar", method= RequestMethod.GET)
	public ResponseEntity< List<MallaCuDTOResponse>> listarMallaCu(){
		
		return new ResponseEntity<List<MallaCuDTOResponse>>(servicio.listarMallaCu(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path= "/guardar", method= RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCuDTORequest malla){
		servicio.guardarMallaCu(malla);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path= "/listar{id}", method= RequestMethod.GET)
	public ResponseEntity<MallaCuDTOResponse> listarPorId(@PathVariable Integer id) {
		
		MallaCuDTOResponse m= servicio.obtenerMallaCuId(id);
			
			if(m !=null)
				return new ResponseEntity<MallaCuDTOResponse>(m, HttpStatus.OK);
			
			return new ResponseEntity<MallaCuDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path= "/editar/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody MallaCuDTORequest malla){
		
		MallaCuDTOResponse m= servicio.obtenerMallaCuId(malla.getIdMallaDTO());
		
		if(m !=null) {
			servicio.editarMallaCu(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@RequestMapping(path= "/eliminar/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@RequestBody Integer id){
		
		MallaCuDTOResponse m= servicio.obtenerMallaCuId(id);
		
		if(m !=null) {
			servicio.eliminarMallaCu(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
}
