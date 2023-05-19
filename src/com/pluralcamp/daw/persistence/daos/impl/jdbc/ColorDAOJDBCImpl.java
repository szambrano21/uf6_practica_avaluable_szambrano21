package com.pluralcamp.daw.persistence.daos.impl.jdbc;

import com.pluralcamp.daw.entities.core.Color;


import com.pluralcamp.daw.persistence.daos.contracts.ColorDAO;
import com.pluralcamp.daw.persistence.exceptions.DAOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDAOJDBCImpl implements ColorDAO {
	
    @Override
    public Color getColorById(long id) throws DAOException {

        //Objectes que calen:
        //1er objecte - Connexio, via DriverManager de JDBC
        //2n objecte - Obrir un canal de Consulta - PraparedStatement
        //2.1 - Enviar la consulta SQL
        //3er objecte - Obrir un canal de Lectura, un cursor - ResultSet
//    	Connection connection = null;
    	//PreparedStatement sentSQL = null;
    	//ResultSet reader = null;
    	Color color = null;
    	
    	/*
    	 * 
    	 * 
    	 * 
    	 * 
    	 * */
    	
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris","sara","admin");
        	PreparedStatement sentSQL = connection.prepareStatement("SELECT id, name, red, green, blue FROM calendar.colors WHERE id = ?");
			) {
    		//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris","root","admin");
    		sentSQL.setLong(1, id); 
    		//sentSQL.executeQuery();
    		try(ResultSet reader = sentSQL.executeQuery();){
        		if(reader.next()) {
        			color = new Color(reader.getString("name"),reader.getInt("red"), reader.getInt("green"), reader.getInt("blue"));
        			color.setId(reader.getLong("id"));
        		}
    		}
    		
    		
    	} catch (SQLException ex) {
    		//Loger
    		throw new DAOException(ex);
    	}
    	
        return color;
    }
    
    
    
    @Override
    public List<Color> getColors() throws DAOException {
    	//dame todas las filas de la tabla colores
    	List<Color> colors = new ArrayList<>();
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris","sara","admin");
            PreparedStatement sentSQL = connection.prepareStatement("SELECT id, name, red, green, blue FROM calendar.colors");
    		ResultSet reader = sentSQL.executeQuery()	) {
        		
    		
        		while (reader.next()) {
        			var color = new Color(reader.getString("name"),reader.getInt("red"), reader.getInt("green"), reader.getInt("blue"));
        			color.setId(reader.getLong("id"));
        			colors.add(color);
        		}

        	} catch (SQLException ex) {
        		//Loger
        		throw new DAOException(ex);
        	}
        	
            return colors;
        }

    @Override
    public List<Color> getColors(int offset, int count) throws DAOException {
        
    	throw new UnsupportedOperationException("Not supported yet.");
    	
    }

    @Override
    public List<Color> getColors(String searchTerm) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet"); 
    }

    @Override
    public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
        return null;
    }
    
    
}

   
/*
 *  

 * 
 * 
 * Connection connection = null;
    	PreparedStatement sql = null;
    	Result reader = null;
    	Color color = null;
    	
    	try {
    		connection = DriverManager.getConnection("conection");
    		sql = connection.prepareStatement("SELECT id, name,red,green,blue FROM colors ")
    		sql.setLong(1, id);
    		
    		if(reader.next()) {
    			color = new Color(reader.getString("name"),reader.getInt("red"), reader.getInt("green"),  )
    			color.setId(reader.getLong("id"));
    		}
    		
    	} catch (SQLException ex) {
    		throw new DAOException(ex);
    	}
    	finally {
    		try {
    			if(reader != null) reader.close();
    			if(sql != null) sql.close();
    			if(connection != null) connection.close();
    		} catch(SQLException ex) {
    			throw new DAOException(ex);
    		}
    	}
    	
        return color;
    }

    @Override
    public List<Color> getColors() throws DAOException {
    	List<Color> colors = new ArrayList<>();
    	try (Connection connection = JDBCUtils.openConnection();
    		PreparedStatement sql = connection.prepareStatement("SELECT id, name,red,green, ");
    		ResultSet reader = sql.executeQuery()){
    		
    			while(reader.next()) {
    				colors.add(JDBCUtils.getColor(reader));
    			}
    	} catch (SQLException | IOException ex) {
    		throw new DAOException (ex);
    	}
    	
        return colors;
    }

    @Override
    public List<Color> getColors(int offset, int count) throws DAOException {
        
    	throw new UnsupportedOperationException("Not supported yet.");
    	
    }

    @Override
    public List<Color> getColors(String searchTerm) throws DAOException {
        return null;
    }

    @Override
    public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
        return null;
    }
}
 * 
 * 
 */
