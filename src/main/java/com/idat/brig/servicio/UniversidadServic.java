package com.idat.brig.servicio;

import java.util.List;

import com.idat.brig.dto.UniversidadDTOResponse;
import com.idat.brig.dto.UniversidadDtoRequest;



public interface UniversidadServic {
	
	public void guardarUniversidad(UniversidadDtoRequest universidad);
	public void editarUniversidad(UniversidadDtoRequest universidad);
	public void eliminarUniversidad(Integer id);
	public List<UniversidadDTOResponse> listarUniversidad();
	public UniversidadDTOResponse obtenerUniversidadId(Integer id);

}
