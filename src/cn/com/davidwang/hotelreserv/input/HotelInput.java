/**
 * 
 */
package cn.com.davidwang.hotelreserv.input;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import cn.com.davidwang.hotelreserv.IHotelReservManager;
import cn.com.davidwang.hotelreserv.hotel.HotelEnums;

/**
 * @author DavidWang
 * 
 */
public class HotelInput implements IHotelInput {

	private HotelReservDate reservDates = null;
	private static IHotelReservManager manager = null;
	
	private List<String> inputStringContainer =null;
	
	//constructor
	public HotelInput(){
		inputStringContainer = new ArrayList<String>();
	}

	private boolean DoTranslateDates(String inputString) {
		List<Date> dateContainer = new ArrayList<Date>();

		String SEP = " ";

		if (inputString == null || inputString.equals("")) {
			return false;
		}
		// inputString = inputString.substring(1);

		String[] text = inputString.split(SEP);
		String customerType = text[0].trim();

		if ((!customerType.substring(0, customerType.length() - 1).equals(
				"Regular"))
				&& (!customerType.substring(0, customerType.length() - 1)
						.equals("Rewards"))) {
			manager.OutputError("[ERROR] Input customer type is not correct!");
			return false;
		}

		for (int i = 1; i < text.length; i++) {
			if (true == IsValidInput(text[i].trim(), dateContainer)) {
			} else {
				dateContainer.clear();
				return false;
			}
		}

		reservDates = new HotelReservDate(customerType.substring(0,
				customerType.length() - 1), dateContainer);
		return true;
	}

	private void ReportError(String errMsg) {
		manager.OutputError(errMsg);

	}

	private boolean IsValidInput(String str, List<Date> dateContainer) {
		Locale.setDefault(Locale.US);
		SimpleDateFormat format = new SimpleDateFormat("ddMMMyyyy");
		Date date;
		try {
			date = format.parse(str.substring(0, 9));
			dateContainer.add(date);
		} catch (Exception e) {
			ReportError("[Input Error] input string " + str
					+ " is not valid date format!");
			return false;
		}

		return true;

	}

	@Override
	public boolean GetInput() {
		boolean ret = false;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String inputStr = br.readLine();
			// ret = DoTranslateDates(inputStr);
			
			inputStringContainer.add(inputStr);
			
			ret = true;

		} catch (Exception e) {
			return false;
		}

		return ret;
	}

	@Override
	public void SetManager(IHotelReservManager mgr) {
		manager = mgr;

	}

	@Override
	public HotelReservDate GetInputDates() {
		return reservDates;

	}

	@Override
	public List<String> GetInputDatesType() {
		List<String> dateTypeList = new ArrayList<String>();
		for (Date date : reservDates.GetDatesList()) {
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(date);
			int w = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1;
			if (1 <= w && 5 >= w) {
				dateTypeList.add(HotelEnums.WEEKDAYS);
			} else if (6 == w || 0 == w) {
				dateTypeList.add(HotelEnums.WEEKENDS);
			} else {
				manager.OutputError("[ERROR] date format is not correct!");
			}

		}
		return dateTypeList;
	}

	@Override
	public String GetCustomerType() {
		return reservDates.getReservTypeString();
	}

	@Override
	public void SetInputDates(HotelReservDate reserv) {
		// for unit test
		this.reservDates = reserv;

	}

	@Override
	public boolean TranslateDate(String inputString) {
		return DoTranslateDates(inputString);
	}

	@Override
	public List<String> GetInputStringContainer() {
		return inputStringContainer;
	}

	@Override
	public IHotelReservManager GetManager() {
		return manager;
	}

}
