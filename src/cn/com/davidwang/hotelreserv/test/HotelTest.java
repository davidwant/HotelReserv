package cn.com.davidwang.hotelreserv.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.davidwang.hotelreserv.hotel.Hotel;
import cn.com.davidwang.hotelreserv.hotel.HotelEnums;

public class HotelTest {

	@Test
	public void testHotel() {
		Hotel hotelObj = new Hotel("TestHotel", 1);
		assertEquals("TestHotel", hotelObj.getHotelName());
		assertEquals(1, hotelObj.getHotelRating());
		
	}

	@Test
	public void testGetHotelName() {
		Hotel hotelObj = new Hotel("TestHotel1", 1);
		assertEquals("TestHotel1", hotelObj.getHotelName());
	}

	@Test
	public void testGetHotelRating() {
		Hotel hotelObj = new Hotel("TestHotel2", 10);
		assertEquals(10, hotelObj.getHotelRating());
	}

	@Test
	public void testSetHotelInfo() {
		Hotel hotelObj = new Hotel("TestHotel", 1);
		hotelObj.setHotelInfo("TestHotel3", 15);
		assertEquals("TestHotel3", hotelObj.getHotelName());
		assertEquals(15, hotelObj.getHotelRating());
	}

	@Test
	public void testSetRewardsHotelRates() {
		Hotel hotelObj = new Hotel("TestHotel4", 20);
		hotelObj.setRewardsHotelRates(100, 200);
		
		assertEquals(100f, (float)hotelObj.getRewardsHotelRates(HotelEnums.WEEKDAYS), 100f);
		assertEquals(200f, (float)hotelObj.getRewardsHotelRates(HotelEnums.WEEKENDS), 100f);
	}

	@Test
	public void testSetRegularHotelRates() {
		Hotel hotelObj = new Hotel("TestHotel5", 40);
		hotelObj.setRegularHotelRates(150, 250);
		
		assertEquals(150, hotelObj.getRegularHotelRates(HotelEnums.WEEKDAYS) , 150f);
		assertEquals(250, hotelObj.getRegularHotelRates(HotelEnums.WEEKENDS), 250f);
	}

	@Test
	public void testGetRewardsHotelRates() {
		Hotel hotelObj = new Hotel("TestHotel6", 60);
		hotelObj.setRewardsHotelRates(300, 400);
		
		assertEquals(300, hotelObj.getRewardsHotelRates(HotelEnums.WEEKDAYS), 300f);
		assertEquals(400, hotelObj.getRewardsHotelRates(HotelEnums.WEEKENDS), 400f);
	}

	@Test
	public void testGetRegularHotelRates() {
		Hotel hotelObj = new Hotel("TestHotel7", 80);
		hotelObj.setRegularHotelRates(350, 450);
		
		assertEquals(350, hotelObj.getRegularHotelRates(HotelEnums.WEEKDAYS), 350f);
		assertEquals(450, hotelObj.getRegularHotelRates(HotelEnums.WEEKENDS), 450f);
	}

}
