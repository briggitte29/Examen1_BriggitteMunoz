package com.idat.brig.servicio;

import java.util.List;

import com.idat.brig.dto.MallaCuDTORequest;
import com.idat.brig.dto.MallaCuDTOResponse;



public interface MallaCuServic {
	
	public void guardarMallaCu(MallaCuDTORequest malla);
	public void editarMallaCu(MallaCuDTORequest malla);
	public void eliminarMallaCu(Integer id);
	public List<MallaCuDTOResponse> listarMallaCu();
	public MallaCuDTOResponse obtenerMallaCuId(Integer id);

}
