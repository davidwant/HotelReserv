/**
 * 
 */
package cn.com.davidwang.hotelreserv.output;

import cn.com.davidwang.hotelreserv.service.IFindHotel;

/**
 * @author DavidWang
 * 
 */
public class HotelOutput implements IHotelOutput {

	private IFindHotel _HotelFinder = null;

	@Override
	public boolean Output(String msg) {
		System.out.println(msg + "\n");
		return false;
	}

	@Override
	public boolean OutputResult() {
		if (null == _HotelFinder) {
			return false;
		}
		System.out.println(_HotelFinder.getResultString() + "\n");
		return true;
	}

	/**
	 * @return the _HotelFinder
	 */
	public IFindHotel get_HotelFinder() {
		return _HotelFinder;
	}

	/**
	 * @param _HotelFinder
	 *            the _HotelFinder to set
	 */
	public void SetHotelFinder(IFindHotel _HotelFinder) {
		this._HotelFinder = _HotelFinder;
	}

	@Override
	public void OutputHints() {
		System.out.println("Usage:");
		System.out.println("	<customer_type>: <date1>, <date2>, <date3>,");
		System.out.println("Tips:");
		System.out.println("	<customer_type>: Values should be Regular or Rewards");
		System.out.println("	<date>: Dates must be formated as ddMMMyyyy(weekdays).");
		System.out.println("	There must be a space between each date and customer_type");
		System.out.println("Example:");
		System.out.println("	Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		
		
	}

}
