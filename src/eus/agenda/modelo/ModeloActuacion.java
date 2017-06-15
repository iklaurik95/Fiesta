package eus.agenda.modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloActuacion extends Conectar{
	
	public ModeloActuacion(){
		super();
	}
	
	public ArrayList<Actuacion> selectPorPueblo (String pueblo){
		
		ArrayList<Actuacion> actuaciones = new ArrayList<Actuacion>();
		
		try {
			Statement st = this.cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT act.* FROM actuaciones act,fiestas fiest WHERE act.id_fiesta=fiest.id AND fiest.pueblo='" + pueblo + "'");
			while (rs.next()){
				Actuacion actuacion = new Actuacion();
				actuacion.setId_grupo(rs.getInt("id_grupo"));
				actuacion.setPrecio(rs.getInt("precio"));
				
				actuaciones.add(actuacion);
			}
			
			return actuaciones;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actuaciones;
		
	}
	
	public boolean comprobar(int idPuebloFiesta, int idGrupo){
		
		try {
			
			PreparedStatement pst = this.cn.prepareStatement("SELECT * FROM actuaciones WHERE id_fiesta=? AND id_grupo=?");
			pst.setInt(1, idPuebloFiesta);
			pst.setInt(2, idGrupo);
			
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
	
	public void update (int precio, int idPuebloFiesta, int idGrupo ){
		
		try {
			
			PreparedStatement pst = this.cn.prepareStatement("UPDATE actuaciones SET precio=? WHERE id_fiesta=? AND id_grupo=?");
			pst.setInt(1, precio);
			pst.setInt(2, idPuebloFiesta);
			pst.setInt(3, idGrupo);
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		

}

