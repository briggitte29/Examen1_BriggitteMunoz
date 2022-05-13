package com.idat.brig.servicio;

import java.util.List;

import com.idat.brig.dto.CursoDTORequest;
import com.idat.brig.dto.CursoDTOResponse;



public interface CursoServic {
	
	public void guardarCurso(CursoDTORequest curso);
	public void editarCurso(CursoDTORequest curso);
	public void eliminarCurso(Integer id);
	public List<CursoDTOResponse> listarCurso();
	public CursoDTOResponse obtenerCursoId(Integer id);

}
