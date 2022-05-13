package com.idat.brig.servicio;

import java.util.List;

import com.idat.brig.dto.ProfesorDTORequest;
import com.idat.brig.dto.ProfesorDTOResponse;



public interface ProfesorServic {
	
	public void guardarProfesor(ProfesorDTORequest profesor);
	public void editarProfesor(ProfesorDTORequest profesor);
	public void eliminarProfesor(Integer id);
	public List<ProfesorDTOResponse> listarProfesor();
	public ProfesorDTOResponse obtenerProfesorId(Integer id);

}
