package com.idat.brig.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.brig.dto.UniversidadDTOResponse;
import com.idat.brig.dto.UniversidadDtoRequest;
import com.idat.brig.models.Universidad;
import com.idat.brig.repository.UniversidadRepository;

@Service
public class UniversidadServImpl implements UniversidadServic{
	
	@Autowired
	public UniversidadRepository repositorio;

	@Override
	public void guardarUniversidad(UniversidadDtoRequest universidad) {
		Universidad u= new Universidad();
		u.setUniversidad(universidad.getUniversidadDTO());
		u.setIdUniversidad(universidad.getIdUniversidadDTO());
		
		repositorio.save(u);		
	}

	@Override
	public void editarUniversidad(UniversidadDtoRequest universidad) {
		Universidad u= new Universidad();
		u.setUniversidad(universidad.getUniversidadDTO());
		u.setIdUniversidad(universidad.getIdUniversidadDTO());
		
		repositorio.saveAndFlush(u);		
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<UniversidadDTOResponse> listarUniversidad() {
		
		List<UniversidadDTOResponse> lista= new ArrayList<UniversidadDTOResponse>();
		UniversidadDTOResponse u= null;
		
		for(Universidad universidad: repositorio.findAll()) {
			u= new UniversidadDTOResponse();
			
			u.setUniversidadDTO(universidad.getUniversidad());
			u.setIdUniversidadDTO(universidad.getIdUniversidad());
			
			lista.add(u);
		}
		
		return lista;
	}

	@Override
	public UniversidadDTOResponse obtenerUniversidadId(Integer id) {
		
		Universidad  universidad= repositorio.findById(id).orElse(null);
		
		UniversidadDTOResponse u= new UniversidadDTOResponse();
		
		u.setUniversidadDTO(universidad.getUniversidad());
		u.setIdUniversidadDTO(universidad.getIdUniversidad());
		
		return u;
	}

}
