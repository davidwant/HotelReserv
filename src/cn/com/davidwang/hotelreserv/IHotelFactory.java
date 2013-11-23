/**
 * 
 */
package cn.com.davidwang.hotelreserv;

import cn.com.davidwang.hotelreserv.input.IHotelInput;
import cn.com.davidwang.hotelreserv.output.IHotelOutput;
import cn.com.davidwang.hotelreserv.service.IFindHotel;

/**
 * @author DavidWang
 *
 */
public interface IHotelFactory {
	
	abstract IHotelInput GetHotelInputObj();
	abstract IHotelOutput GetHotelOutputObj();
	
	abstract IFindHotel GetHotelFinderObj();
	
}
