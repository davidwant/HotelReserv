/**
 * 
 */
package cn.com.davidwang.hotelreserv.service;

import java.util.List;
import java.util.Map;

import cn.com.davidwang.hotelreserv.IHotelReservManager;
import cn.com.davidwang.hotelreserv.hotel.IHotel;
import cn.com.davidwang.hotelreserv.input.IHotelInput;
import cn.com.davidwang.hotelreserv.output.IHotelOutput;

/**
 * @author DavidWang
 *
 */
public interface IFindHotel {

	void SetInputObj(IHotelInput _HotelInputObj);

	void SetOutputObj(IHotelOutput _HotelOutputObj);

	void SetHotelData(Map<String, IHotel> _HotelsMap);

	boolean GetHotel();

	void SetManager(IHotelReservManager hotelReservManager);
	
	String getResultString() ;

}
