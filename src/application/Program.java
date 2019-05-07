package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.exceptions.DomainException;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args)  {
       
		//Nova solução usando Try e Catch para tratar as exceções
	try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Room Number: ");
			int roomNumber = sc.nextInt();
			
			System.out.print("Check-in Date( dd/MM/yyyy ) :");
			Date checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out Date( dd/MM/yyyy ) :");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		

		    System.out.println("Update data of reservation: ");
			System.out.print("Room Number: ");
			roomNumber = sc.nextInt();
			
			System.out.print("Check-in Date( dd/MM/yyyy ) :");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out Date( dd/MM/yyyy ) :");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			sc.close();
	   }
	   
	    catch(ParseException e) {
	    	System.out.println("Invalid date format");
	    }
	    catch(DomainException e){
	        	 System.out.println("Error: " + e);
	         }
	    catch(RuntimeException e) {
	    	System.out.println("Erro inesperado");
	    }
	
		   
		
		
	}

}
