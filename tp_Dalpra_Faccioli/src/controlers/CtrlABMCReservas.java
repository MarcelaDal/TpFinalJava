package controlers;

import java.util.ArrayList;

import data.DataElementos;
import data.DataPersona;
import data.DataReserva;
import data.DataTipoElementos;
import entity.Elemento;
import entity.Reserva;
import entity.TipoElementos;

public class CtrlABMCReservas {
	
	private DataPersona dataPersona;
	private DataReserva dataReserva;
	private DataElementos dataElementos;
	private DataTipoElementos dataTipoEle;
	
	
	public CtrlABMCReservas(){
		dataPersona = new DataPersona();
		dataReserva = new DataReserva();
		dataElementos = new DataElementos();
		dataTipoEle = new DataTipoElementos();
		
	}
	
	public void add(Reserva r) throws Exception{
		dataReserva.add(r);
	}
	
	public void delete(Reserva r)throws Exception{
		dataReserva.remove(r);
	}
	
	/*public void update(Elemento ele)throws Exception{
		dataElementos.update(ele);
	}*/
	
	/*public Elemento getByNombre(Elemento el) throws Exception{
		return this.dataElementos.getByNombre(el);
	}*/
	
	/*public Elemento getByNombre(String nombre)throws Exception{
		Elemento ele=new Elemento();
		ele.setNombre(nombre);
		return getByNombre(ele);
	}*/
	
		
	public ArrayList<Reserva> getAll()throws Exception{
		return dataReserva.getAll();
	}
	
	public ArrayList<TipoElementos> getTipoElementos() throws Exception{
		return dataTipoEle.getAll();
	}
	public ArrayList<Elemento> getElementos() throws Exception{
		return dataElementos.getAll();
	}
}