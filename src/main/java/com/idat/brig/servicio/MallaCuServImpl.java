package com.idat.brig.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.brig.dto.MallaCuDTORequest;
import com.idat.brig.dto.MallaCuDTOResponse;
import com.idat.brig.models.MallaCurricural;
import com.idat.brig.repository.MallaCRepository;


@Service
public class MallaCuServImpl implements MallaCuServic{
	
	@Autowired
	public MallaCRepository repositorio;

	@Override
	public void guardarMallaCu(MallaCuDTORequest malla) {
		MallaCurricural m= new MallaCurricural();
		m.setAño(malla.getAñoDTO());
		m.setIdMalla(malla.getIdMallaDTO());
		
		repositorio.save(m);		
	}

	@Override
	public void editarMallaCu(MallaCuDTORequest malla) {
		MallaCurricural m= new MallaCurricural();
		m.setAño(malla.getAñoDTO());
		m.setIdMalla(malla.getIdMallaDTO());
		
		repositorio.saveAndFlush(m);		
	}

	@Override
	public void eliminarMallaCu(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<MallaCuDTOResponse> listarMallaCu() {
		List<MallaCuDTOResponse> lista= new ArrayList<MallaCuDTOResponse>();
		MallaCuDTOResponse m= null;
		
		for(MallaCurricural malla: repositorio.findAll()) {
			m= new MallaCuDTOResponse();
			
			m.setAñoDTO(malla.getAño());
			m.setIdMallaDTO(malla.getIdMalla());
		
			lista.add(m);			
		}
		return lista;
	}

	@Override
	public MallaCuDTOResponse obtenerMallaCuId(Integer id) {
		MallaCurricural malla= repositorio.findById(id).orElse(null);
		MallaCuDTOResponse m= new MallaCuDTOResponse();
		
		m.setAñoDTO(malla.getAño());
		m.setIdMallaDTO(malla.getIdMalla());
		
		return m;
	}

}
