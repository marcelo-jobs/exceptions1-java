package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	//FORMATANDO DATE PARA DIA/MES/ANO
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	//ATRIBUTOS
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//CONSTRUTOR
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
   //GETTERS e SETTERS 
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	//MÉTODOS
	
	public long duration() 
	{
		long difference1 = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(difference1, TimeUnit.MILLISECONDS);
	}
	
	//
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "ERROR: A atualização da reserva tem que ser para uma data futura";
		} else if (!checkOut.after(checkIn)) 
			{
			return "ERROR: A data do Check-out tem que ser depois da data do Check-In";
			} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;	
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " +
	           roomNumber +
	           ", Check-in :" +
	           sdf.format(getCheckIn()) +
	           ", Check-out : " +
	           sdf.format(getCheckOut()) +
	           ", " +
	           duration() +
	           " nights";
	}
	
	
}

