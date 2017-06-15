package eus.agenda.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloGrupo extends Conectar{
	
	public ModeloGrupo(){
		super();
	}
	
	public ArrayList<Grupo> select(){
		
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		
		try {
			Statement st = this.cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM grupos");
			
			while(rs.next()){
				Grupo grupo = new Grupo();
				grupo.setId(rs.getInt("id"));
				grupo.setNombre(rs.getString("nombre"));
				grupo.setNum_musicos(rs.getInt("num_musicos"));
				
				grupos.add(grupo);
				
			}
						
			return grupos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupos;	
		
	}

}
