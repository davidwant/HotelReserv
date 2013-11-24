package cn.com.davidwang.hotelreserv;

import java.util.List;

public interface IHotelReservManager {
	
	abstract boolean GetInput();
	abstract boolean GetCheapestHotel();
	abstract boolean OutputResult();
	
	abstract boolean OutputError(String msg);
	
	abstract boolean Output(String msg);
	abstract void OutputHints();
	
	abstract List<String> GetInputStringContainer();
	
	abstract boolean TranslateInput(String input);
	
	
}
