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
        Event event = null;
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris","sara","admin");
        	PreparedStatement sentSQL = connection.prepareStatement("SELECT id, name, date , startTime, endTime, place, description , backgroundColor, textColor, visible, registrationDate FROM calendar.events WHERE id = ?");
        	){
        		sentSQL.setLong(1, id);
        		try (ResultSet reader = sentSQL.executeQuery();){
        			if(reader.next()) {
        				Date date = reader.getDate("date");
        				LocalDate date1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        				
        				Date startTime = reader.getDate("startTime");
        				LocalDate startTime1 = startTime1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        				
            			event = new Event(reader.getString("name"), date1 , startTime1, reader.getTime("endTime"), reader.getString("place"), reader.getString("description"), reader.getLong("backgroundColor"), reader.getLong("textColor"), reader.getBoolean("visible"), reader.getDate("registrationDate") );
            			event.setId(reader.getLong("id"));
            		}
        		}
        } catch (SQLException ex) {
    		//Loger
    		throw new DAOException(ex);
    	}
    	return event;
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
