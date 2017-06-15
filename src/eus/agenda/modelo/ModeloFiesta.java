package eus.agenda.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloFiesta extends Conectar{
	
	public ModeloFiesta(){
		super();
	}
	
	public ArrayList<Fiesta> select(){
		
		ArrayList<Fiesta> fiestas = new ArrayList<Fiesta>();
		
		try {
			Statement st = this.cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM fiestas");
			
			while(rs.next()){
				Fiesta fiesta = new Fiesta();
				fiesta.setId(rs.getInt("id"));
				fiesta.setPueblo(rs.getString("pueblo"));
				fiesta.setNombre(rs.getString("nombre"));
				fiesta.setMes(rs.getInt("mes"));
				fiestas.add(fiesta);
			}
						
			return fiestas;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fiestas;	
		
	}
	
	public ArrayList<Fiesta> selectPorPueblo (String pueblo){
		
		ArrayList<Fiesta> fiestas = new ArrayList<Fiesta>();
		
		try {
			Statement st = this.cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM fiestas WHERE pueblo='" + pueblo + "'");
			
			while(rs.next()){
				Fiesta fiesta = new Fiesta();
				fiesta.setPueblo(pueblo);
				fiesta.setNombre(rs.getString("nombre"));
				fiesta.setMes(rs.getInt("mes"));
				fiestas.add(fiesta);
			}
						
			return fiestas;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fiestas;	
		
	}
	
	public boolean comprobarPorPueblo(String pueblo){
		
		try {
			
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM fiestas WHERE pueblo=?");
			pst.setString(1, pueblo);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return false;
		
	}


}




