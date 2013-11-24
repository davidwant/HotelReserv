/**
 * 
 */
package cn.com.davidwang.hotelreserv;

import cn.com.davidwang.hotelreserv.input.HotelInputFromFile;
import cn.com.davidwang.hotelreserv.input.IHotelInput;
import cn.com.davidwang.hotelreserv.output.HotelOutput;
import cn.com.davidwang.hotelreserv.output.IHotelOutput;
import cn.com.davidwang.hotelreserv.service.FindCheapestHotel;
import cn.com.davidwang.hotelreserv.service.IFindHotel;

/**
 * @author DavidWang
 *
 */
public class HotelFactory implements IHotelFactory {

	@Override
	public IHotelInput GetHotelInputObj() {
		//IHotelInput hotelInputObj = new HotelInput();
		IHotelInput hotelInputObj = new HotelInputFromFile();
		return hotelInputObj;
	}

	@Override
	public IHotelOutput GetHotelOutputObj() {
		IHotelOutput hotelOutputObj = new HotelOutput();
		return hotelOutputObj;
	}

	@Override
	public IFindHotel GetHotelFinderObj() {
		IFindHotel hotelFinderObj = new FindCheapestHotel();
		return hotelFinderObj;
	}
	
}
