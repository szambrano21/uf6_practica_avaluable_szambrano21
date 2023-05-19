package com.pluralcamp.daw.ui.console;

/*imports*/
import com.pluralcamp.daw.entities.core.Color;
import com.pluralcamp.daw.entities.core.Employee;
import com.pluralcamp.daw.entities.core.Event;
import com.pluralcamp.daw.persistence.daos.contracts.ColorDAO;
import com.pluralcamp.daw.persistence.daos.contracts.EventDAO;
import com.pluralcamp.daw.persistence.exceptions.DAOException;



import com.pluralcamp.daw.persistence.daos.impl.jdbc.ColorDAOJDBCImpl;
import com.pluralcamp.daw.persistence.daos.impl.jdbc.EventDAOJDBCImpl;



import java.util.List;

import java.util.Scanner;

import com.pluralcamp.daw.persistence.exceptions.DAOException;

@SuppressWarnings("unused")

public class App {
    public static void main(String[] args) {
        System.out.println("Hello JDBC");
        Scanner stdin = new Scanner (System.in);
        
        ColorDAOJDBCImpl colorDAO = new ColorDAOJDBCImpl();
        EventDAOJDBCImpl eventDAO = new EventDAOJDBCImpl();
        
        try {
        	
        	Color c = colorDA0 .getColorById(5);
        	
        	if(c != null) {
        		System.out.println(c.toString());
        	}
        } catch (DAOException ex){
        	System.out.printf("Error:: %s %n", ex.getMessage());
        }
        
        System.out.printf("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        try {
        	List<Color> colors = colorDAO.getColors();
        	for (Color c : colors){
        		System.out.println(c.toString());
        	}
        } catch (DAOException ex) {
        	System.out.printf("error:: 5s %n", ex.getMessage());
        }
        
        System.out.printf("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        try {
        	Event e = eventDAO.getEventById(5);
        	if (e != null) {
        		System.out.println(e.toString());
        	}
        } catch (DAOException ex) {
        	System.out.printf("error:: 5s %n", ex.getMessage());
        }
        
        System.out.printf("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        try {
        	List<Event> events = eventDAO.getEvents();
        	for (Event e : events) {
        		System.out.println(e.toString());
        	}
        } catch (DAOException ex) {
        	System.out.printf("error:: 5s %n", ex.getMessage());
        }
        
        System.out.printf("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        
    }
}
