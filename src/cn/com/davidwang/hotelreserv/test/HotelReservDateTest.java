package cn.com.davidwang.hotelreserv.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.com.davidwang.hotelreserv.input.HotelReservDate;

public class HotelReservDateTest {

	@Test
	public void testHotelReservDate() {
		List<Date> datesList = new ArrayList<Date>();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		try {
			Date date1 = format.parse("01032012");
			Date date2 = format.parse("31122013");
			datesList.add(date1);
			datesList.add(date2);

			HotelReservDate reservDate = new HotelReservDate("Regular",
					datesList);

			assertEquals("Regular", reservDate.getReservTypeString());

			List<Date> datesExpList = datesList;
			assertEquals(datesExpList, reservDate.GetDatesList());
		} catch (Exception e) {

		}
	}

	@Test
	public void testGetDatesList() {
		List<Date> datesList = new ArrayList<Date>();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		try {
			Date date1 = format.parse("01032012");
			Date date2 = format.parse("31122013");
			datesList.add(date1);
			datesList.add(date2);

			HotelReservDate reservDate = new HotelReservDate("Regular",
					datesList);

			List<Date> datesExpList = datesList;
			assertEquals(datesExpList, reservDate.GetDatesList());
		} catch (Exception e) {

		}

	}

	@Test
	public void testGetReservTypeString() {
		List<Date> datesList = new ArrayList<Date>();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		try {
			Date date1 = format.parse("01032012");
			Date date2 = format.parse("31122013");
			datesList.add(date1);
			datesList.add(date2);

			HotelReservDate reservDate = new HotelReservDate("Regular",
					datesList);

			assertEquals("Regular", reservDate.getReservTypeString());
		} catch (Exception e) {

		}

	}

	@Test
	public void testSetReservTypeString() {
		List<Date> datesList = new ArrayList<Date>();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		try {
			Date date1 = format.parse("01032012");
			Date date2 = format.parse("31122013");
			datesList.add(date1);
			datesList.add(date2);

			HotelReservDate reservDate = new HotelReservDate("Regular",
					datesList);

			reservDate.setReservTypeString("Rewards");

			assertEquals("Rewards", reservDate.getReservTypeString());
		} catch (Exception e) {

		}
	}

}
