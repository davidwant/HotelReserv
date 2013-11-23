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

	HotelReservDate GetInputDates();

	List<String> GetInputDatesType();

	String GetCustomerType();

}