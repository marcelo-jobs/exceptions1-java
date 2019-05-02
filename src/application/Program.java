package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
        
		//
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Check-in Date( dd/MM/yyyy ) :");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out Date( dd/MM/yyyy ) :");
		Date checkOut = sdf.parse(sc.next());
		
		//Testando inconsistência nas Datas
		if (!checkOut.after(checkIn)) {
			System.out.println("ERROR: A data do Check-out tem que ser depois da data do Check-In");
		}else
		   {
			 Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			 System.out.println("Reservation: " + reservation);
			 
			//Reaproveitamento 
			 
			    System.out.println("Update data of reservation: ");
				System.out.print("Room Number: ");
				roomNumber = sc.nextInt();
				
				System.out.print("Check-in Date( dd/MM/yyyy ) :");
				checkIn = sdf.parse(sc.next());
				
				System.out.print("Check-out Date( dd/MM/yyyy ) :");
				checkOut = sdf.parse(sc.next());
				
				String error = reservation.updateDates(checkIn, checkOut);
				if (error != null) {
					 System.out.println("A reserva deu errado: " + error);
					
				} else {
					System.out.println("Reservation: " + reservation);
				}
					
				  	
		   }
		
		sc.close();
	}

}
