package cn.com.davidwang.hotelreserv.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.com.davidwang.hotelreserv.IHotelReservManager;
import cn.com.davidwang.hotelreserv.hotel.Hotel;
import cn.com.davidwang.hotelreserv.hotel.HotelEnums;
import cn.com.davidwang.hotelreserv.hotel.IHotel;
import cn.com.davidwang.hotelreserv.input.IHotelInput;
import cn.com.davidwang.hotelreserv.output.IHotelOutput;

public class FindCheapestHotel implements IFindHotel {

	private IHotelInput _HotelInput = null;
	private IHotelOutput _HotelOutput = null;
	private Map<String, IHotel> _HotelMap = null;

	private IHotelReservManager manager = null;

	private String resultString = null;

	@Override
	public void SetInputObj(IHotelInput _HotelInputObj) {
		_HotelInput = _HotelInputObj;
	}

	@Override
	public void SetOutputObj(IHotelOutput _HotelOutputObj) {
		_HotelOutput = _HotelOutputObj;
	}

	@Override
	public boolean GetHotel() {
		List<String> reservDateType = _HotelInput.GetInputDatesType();

		Iterator<Entry<String, IHotel>> iter = _HotelMap.entrySet().iterator();

		float lowestPrice = -1f;
		Hotel cheapestHotel = null;

		while (iter.hasNext()) {
			Entry<String , IHotel> entry = (Entry<String , IHotel>) iter.next();
			Object val = entry.getValue();

			Hotel hotelObj = (Hotel) val;

			float totalCost = 0f;

			for (String dateType : reservDateType) {
				totalCost += (_HotelInput.GetCustomerType()
						.equalsIgnoreCase(HotelEnums.REGULAR_CUSTOMER)) ? hotelObj
						.getRegularHotelRates(dateType) : hotelObj
						.getRewardsHotelRates(dateType);
			}

			if ((totalCost < lowestPrice) || (-1 == lowestPrice)) {
				lowestPrice = totalCost;
				cheapestHotel = hotelObj;
			} else if ((totalCost == lowestPrice)
					&& (hotelObj.getHotelRating() > cheapestHotel
							.getHotelRating())) {
				cheapestHotel = hotelObj;
			}

		}
		setResultString(cheapestHotel.getHotelName());
		return true;
	}

	@Override
	public void SetHotelData(Map<String, IHotel> _HotelsMap) {
		_HotelMap = _HotelsMap;

	}

	@Override
	public void SetManager(IHotelReservManager hotelReservManager) {
		manager = hotelReservManager;

	}

	/**
	 * @return the resultString
	 */
	public String getResultString() {
		return resultString;
	}

	private void setResultString(String resultString) {
		this.resultString = resultString;
	}

}
