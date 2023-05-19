package com.pluralcamp.daw.persistence.daos.impl.jdbc;

import com.pluralcamp.daw.entities.core.Color;
import com.pluralcamp.daw.entities.core.Event;
import com.pluralcamp.daw.persistence.daos.contracts.EventDAO;
import com.pluralcamp.daw.persistence.exceptions.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class EventDAOJDBCImpl implements EventDAO {
    @Override
    public Event getEventById(long id) throws DAOException {
    	return null;
    	
    	/*
        Event event = null;
        
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris","sara","admin");
        	PreparedStatement sentSQL = connection.prepareStatement("SELECT id, name, date , startTime, endTime, place, description , backgroundColor, textColor, visible, registrationDate FROM calendar.events WHERE id = ?");
        	){
        		sentSQL.setLong(1, id);
        		try (ResultSet reader = sentSQL.executeQuery();){
        			if(reader.next()) {
        				
            			event = new Event(reader.getString("name"), reader.getDate("date").toLocalDate() , reader.getDate("startTime").toLocalDate(), reader.getTime("endTime").toLocalTime(), reader.getString("place"), reader.getString("description"), reader.getLong("backgroundColor"), reader.getLong("textColor"), reader.getBoolean("visible"));
            			event.setId(reader.getLong("id"));
            		}
        		}
        } catch (SQLException ex) {
    		//Loger
    		throw new DAOException(ex);
    	}
    	return event;
    	*/
    }

    @Override
    public List<Event> getEvents() throws DAOException {
        return null;
    }

    @Override
    public List<Event> getEvents(int offset, int count) throws DAOException {
        return null;
    }

    @Override
    public List<Event> getEvents(String searchTerm) throws DAOException {
        return null;
    }

    @Override
    public List<Event> getEvents(String searchTerm, int offset, int count) throws DAOException {
        return null;
    }
}
