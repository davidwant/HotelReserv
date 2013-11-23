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

}
