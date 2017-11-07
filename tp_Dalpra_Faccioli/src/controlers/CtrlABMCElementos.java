package controlers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.DataTipoElementos;
import data.DataElementos;
import entity.TipoElementos;
import entity.Elemento;

public class CtrlABMCElementos {

	private DataElementos dataElementos;
	private DataTipoElementos dataTipoEle;
	
	
	public CtrlABMCElementos(){
		dataElementos = new DataElementos();
		dataTipoEle = new DataTipoElementos();
	}
	
	public void add(Elemento ele) throws Exception{
		try {
			dataElementos.add(ele);

		} catch (Exception e) {
		 	e.printStackTrace();
		}
	}
	
	public void delete(Elemento ele)throws Exception{
		try {
			dataElementos.remove(ele);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Elemento ele)throws Exception{
		try {
			dataElementos.update(ele);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public Elemento getByNombre(Elemento el){
		try {
			return this.dataElementos.getByNombre(el);
		
		} catch (Exception e) {
			;

			e.printStackTrace();
			return null;
		}

	}
	
	public Elemento getByNombre(String nombre)throws Exception{
		Elemento ele=new Elemento();
		ele.setNombre(nombre);
		return getByNombre(ele);
	}
	
		
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElementos.getAll();
	}
	
	public ArrayList<TipoElementos> getTipoElementos(){		
		try {
			return dataTipoEle.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}