package cn.com.davidwang.hotelreserv.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.com.davidwang.hotelreserv.IHotelFactory;
import cn.com.davidwang.hotelreserv.hotel.Hotel;
import cn.com.davidwang.hotelreserv.hotel.HotelEnums;
import cn.com.davidwang.hotelreserv.hotel.IHotel;
import cn.com.davidwang.hotelreserv.input.HotelInput;
import cn.com.davidwang.hotelreserv.input.HotelReservDate;
import cn.com.davidwang.hotelreserv.input.IHotelInput;
import cn.com.davidwang.hotelreserv.output.HotelOutput;
import cn.com.davidwang.hotelreserv.output.IHotelOutput;
import cn.com.davidwang.hotelreserv.service.FindCheapestHotel;
import cn.com.davidwang.hotelreserv.service.IFindHotel;

public class FindCheapestHotelTest {

	@Test
	public void testGetHotel() {
		IHotelOutput _HotelOutputObj = new HotelOutput();
		IHotelInput _HotelInputObj = new HotelInput();

		IFindHotel _HotelFinder = new FindCheapestHotel();

		// a list to store all hotels.
		Map<String, IHotel> _HotelsMap = new HashMap<String, IHotel>();

		IHotel lakeWoodHotel = new Hotel("LakeWood", 3);
		lakeWoodHotel.setRegularHotelRates(110f, 90f);
		lakeWoodHotel.setRewardsHotelRates(80f, 80f);
		_HotelsMap.put("LakeWood", lakeWoodHotel);

		IHotel bridgeWoodHotel = new Hotel("BridgeWood", 4);
		bridgeWoodHotel.setRegularHotelRates(160f, 60f);
		bridgeWoodHotel.setRewardsHotelRates(110f, 50f);
		_HotelsMap.put("BridgeWood", bridgeWoodHotel);

		IHotel ridgeWoodHotel = new Hotel("RidgeWood", 5);
		ridgeWoodHotel.setRegularHotelRates(220f, 150f);
		ridgeWoodHotel.setRewardsHotelRates(100f, 40f);
		_HotelsMap.put("RidgeWood", ridgeWoodHotel);

		_HotelFinder.SetInputObj(_HotelInputObj);
		_HotelFinder.SetOutputObj(_HotelOutputObj);
		_HotelFinder.SetHotelData(_HotelsMap);

		_HotelOutputObj.SetHotelFinder(_HotelFinder);

		List<Date> datesList1 = new ArrayList<Date>();
		List<Date> datesList2 = new ArrayList<Date>();
		List<Date> datesList3 = new ArrayList<Date>();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		try {
			datesList1.add(format.parse("16032009"));
			datesList1.add(format.parse("17032009"));
			datesList1.add(format.parse("18032009"));

			datesList2.add(format.parse("20032009"));
			datesList2.add(format.parse("21032009"));
			datesList2.add(format.parse("22032009"));

			datesList3.add(format.parse("26032009"));
			datesList3.add(format.parse("27032009"));
			datesList3.add(format.parse("28032009"));
		} catch (Exception e) {

		}

		HotelReservDate reservDates1 = new HotelReservDate(
				HotelEnums.REGULAR_CUSTOMER, datesList1);
		HotelReservDate reservDates2 = new HotelReservDate(
				HotelEnums.REGULAR_CUSTOMER, datesList2);
		HotelReservDate reservDates3 = new HotelReservDate(
				HotelEnums.REWARDS_CUSTOMER, datesList3);

		_HotelInputObj.SetInputDates(reservDates1);
		_HotelFinder.GetHotel();
		assertEquals(true,
				_HotelFinder.getResultString().equalsIgnoreCase("lakewood"));

		_HotelInputObj.SetInputDates(reservDates2);
		_HotelFinder.GetHotel();
		assertEquals(true,
				_HotelFinder.getResultString().equalsIgnoreCase("bridgewood"));

		_HotelInputObj.SetInputDates(reservDates3);
		_HotelFinder.GetHotel();
		assertEquals(true,
				_HotelFinder.getResultString().equalsIgnoreCase("ridgewood"));

	}

}
