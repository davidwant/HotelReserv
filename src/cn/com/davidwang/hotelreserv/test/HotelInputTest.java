package cn.com.davidwang.hotelreserv.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.com.davidwang.hotelreserv.hotel.HotelEnums;
import cn.com.davidwang.hotelreserv.input.HotelInput;
import cn.com.davidwang.hotelreserv.input.HotelReservDate;
import cn.com.davidwang.hotelreserv.input.IHotelInput;

public class HotelInputTest {

	@Test
	public void testGetInputDates() {
		IHotelInput inputObj = new HotelInput();

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

		inputObj.SetInputDates(reservDates1);
		assertEquals(reservDates1, inputObj.GetInputDates());
	}

	@Test
	public void testGetInputDatesType() {
		IHotelInput inputObj = new HotelInput();

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

		HotelReservDate reservDates2 = new HotelReservDate(
				HotelEnums.REGULAR_CUSTOMER, datesList2);

		inputObj.SetInputDates(reservDates2);
		
		assertEquals(true , inputObj.GetInputDatesType().get(0).equalsIgnoreCase(HotelEnums.WEEKDAYS));
		assertEquals(true , inputObj.GetInputDatesType().get(1).equalsIgnoreCase(HotelEnums.WEEKENDS));
		assertEquals(true , inputObj.GetInputDatesType().get(2).equalsIgnoreCase(HotelEnums.WEEKENDS));
	}

	@Test
	public void testGetCustomerType() {
		IHotelInput inputObj = new HotelInput();

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

		HotelReservDate reservDates3 = new HotelReservDate(
				HotelEnums.REWARDS_CUSTOMER, datesList3);
		inputObj.SetInputDates(reservDates3);
		
		assertEquals(true ,  inputObj.GetCustomerType().equalsIgnoreCase(HotelEnums.REWARDS_CUSTOMER));
	}

}
