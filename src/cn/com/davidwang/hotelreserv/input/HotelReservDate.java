package cn.com.davidwang.hotelreserv.input;

import java.util.Date;
import java.util.List;

public class HotelReservDate {
	private String reservTypeString = null;
	private List<Date> reservDateList = null;

	public HotelReservDate(String typeString, List<Date> datesList) {
		reservTypeString = typeString;
		reservDateList = datesList;
	}

	public List<Date> GetDatesList() {
		return reservDateList;
	}

	/**
	 * @return the reservTypeString
	 */
	public String getReservTypeString() {
		return reservTypeString;
	}

	/**
	 * @param reservTypeString
	 *            the reservTypeString to set
	 */
	public void setReservTypeString(String reservTypeString) {
		this.reservTypeString = reservTypeString;
	}

}
