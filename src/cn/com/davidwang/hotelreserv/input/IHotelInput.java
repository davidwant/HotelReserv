/**
 * 
 */
package cn.com.davidwang.hotelreserv.input;

import java.util.List;

import cn.com.davidwang.hotelreserv.IHotelReservManager;

/**
 * @author DavidWang
 *
 */
public interface IHotelInput {

	boolean GetInput();
	
	void SetManager(IHotelReservManager mgr);
	
	IHotelReservManager GetManager();

	HotelReservDate GetInputDates();
	
	void SetInputDates(HotelReservDate reserv);

	List<String> GetInputDatesType();

	String GetCustomerType();
	
	boolean TranslateDate(String inputString);
	
	List<String> GetInputStringContainer();

}
