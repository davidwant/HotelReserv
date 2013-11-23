package cn.com.davidwang.hotelreserv;

public interface IHotelReservManager {
	
	abstract boolean GetInput();
	abstract boolean GetCheapestHotel();
	abstract boolean OutputResult();
	
	abstract boolean OutputError(String msg);
	
	abstract boolean Output(String msg);
	
	
}
