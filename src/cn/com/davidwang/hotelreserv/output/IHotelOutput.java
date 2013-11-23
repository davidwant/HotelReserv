/**
 * 
 */
package cn.com.davidwang.hotelreserv.output;

import cn.com.davidwang.hotelreserv.service.IFindHotel;

/**
 * @author DavidWang
 *
 */
public interface IHotelOutput {

	boolean Output(String msg);

	boolean OutputResult();

	void SetHotelFinder(IFindHotel _HotelFinder);

}
