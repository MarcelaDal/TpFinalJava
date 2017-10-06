package data;


import util.AppDataException;
import entity.Elemento;
import entity.Persona;
import entity.Reserva;

import java.sql.*;
import java.util.ArrayList;


public class DataReserva{
		
		
	public void add(Reserva r) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into reservas (detalle, estado, id_persona, id_elemento, fecha) values (?,?,?,?,?)",
							
							PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			
			stmt.setString(1, r.getDetalle());
			stmt.setBoolean(2, r.getEstado());
			stmt.setInt(3, r.getPersona().getId());
			stmt.setInt(4, r.getElemento().getId());
			stmt.setDate(5, (Date)r.getFecha());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setId(keyResultSet.getInt(1));
			}
			
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*public Elemento getByNombre(Elemento ele) throws Exception{
		
		Elemento el=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select e.nombre, e.id, id_tipo_elemento, te.nombre from elementos e inner join tipos_elementos te on e.id_tipo_elemento=te.id where e.nombre like ?");
			stmt.setString(1, '%'+ele.getNombre()+'%');
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					el=new Elemento();
					el.setTipo(new TipoElementos());
					el.setId(rs.getInt("e.id"));
					el.setNombre(rs.getString("e.nombre"));
					el.getTipo().setId(rs.getInt("id_tipo_elemento"));
					el.getTipo().setNombre(rs.getString("te.nombre"));
			}
			
		} catch (Exception ex) {
			throw ex;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return el;
	}*/
	
	
	public ArrayList<Reserva> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from reservas r inner join persona p on r.id_persona=p.id inner join elementos e on r.id_elemento=e.id");
			if(rs!=null){
				while(rs.next()){
					Reserva r=new Reserva();
					r.setElemento(new Elemento());
					r.setPersona(new Persona());
					r.setId(rs.getInt("r.id"));
					r.getPersona().setNombre(rs.getString("p.nombre"));
					r.getPersona().setApellido(rs.getString("p.apellido"));
					r.getElemento().setNombre(rs.getString("e.nombre"));
					r.setFecha(rs.getDate("r.fecha"));
					r.setHora(rs.getTime("r.hora"));
					r.setEstado(rs.getBoolean("r.estado"));					
					
					reservas.add(r);
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reservas;
		
	}


	public void remove(Reserva r) throws Exception {
		PreparedStatement stmt=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"update reservas set estado='cancelado' where id=?"
					);
			stmt.setInt(1, r.getId());
			stmt.executeUpdate();
						
			
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update(Reserva r) throws Exception {
		
		PreparedStatement stmt=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"update reservas set estado=0 where id=?"
					);
			stmt.setInt(1, r.getId());
			
			stmt.executeUpdate();
						
			
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public ArrayList<Reserva> getByUsuario(Persona per) throws Exception{
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"select * from reservas r inner join persona p on r.id_persona=p.id inner join elementos e on r.id_elemento= e.id where (p.id=?) and (r.fecha>CURDATE()) and (r.estado=1)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			stmt.setInt(1, per.getId());	
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					Reserva r=new Reserva();
					r.setElemento(new Elemento());
					r.setPersona(new Persona());
					r.setId(rs.getInt("r.id"));
					r.getPersona().setNombre(rs.getString("p.nombre"));
					r.getPersona().setApellido(rs.getString("p.apellido"));
					r.getElemento().setNombre(rs.getString("e.nombre"));
					r.setFecha(rs.getDate("r.fecha"));
					r.setHora(rs.getTime("r.hora"));
					r.setEstado(rs.getBoolean("r.estado"));					
					
					reservas.add(r);
			}
			
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reservas;
		
	}

		
	
}