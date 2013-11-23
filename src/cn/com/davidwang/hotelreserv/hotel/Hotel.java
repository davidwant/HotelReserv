/**
 * 
 */
package cn.com.davidwang.hotelreserv.hotel;

/**
 * @author DavidWang
 * 
 */
public class Hotel implements IHotel {
	private String _HotelNameString; // store hotel name
	private int _RatingString; // store hotel rating

	private class CustomerRates {
		private float _WeekdayRates = 0f;
		private float _WeekendRates = 0f;

		// constructor
		public CustomerRates(float weekdayrate, float weekendrate) {
			this.set_WeekdayRates(weekdayrate);
			this.set_WeekendRates(weekendrate);
		}

		/**
		 * @return the _WeekdayRates
		 */
		public float get_WeekdayRates() {
			return _WeekdayRates;
		}

		/**
		 * @param _WeekdayRates
		 *            the _WeekdayRates to set
		 */
		public void set_WeekdayRates(float _WeekdayRates) {
			this._WeekdayRates = _WeekdayRates;
		}

		/**
		 * @return the _WeekendRates
		 */
		public float get_WeekendRates() {
			return _WeekendRates;
		}

		/**
		 * @param _WeekendRates
		 *            the _WeekendRates to set
		 */
		public void set_WeekendRates(float _WeekendRates) {
			this._WeekendRates = _WeekendRates;
		}
	}

	private class HotelRates {
		private CustomerRates _RegularCustomerRates;
		private CustomerRates _RewardsCustomerRates;

		// constructor

		public HotelRates(CustomerRates regularRates, CustomerRates rewardsRates) {
			set_RegularCustomerRates(regularRates);
			set_RewardsCustomerRates(rewardsRates);
		}

		public HotelRates(float regularWeekdayRate, float regularWeekendRate,
				float rewardsWeekdayRate, float rewardsWeekendRate) {
			set_RegularCustomerRates(new CustomerRates(regularWeekdayRate,
					regularWeekendRate));
			set_RewardsCustomerRates(new CustomerRates(rewardsWeekdayRate,
					rewardsWeekendRate));
		}

		public HotelRates() {
			set_RegularCustomerRates(new CustomerRates(0, 0));
			set_RewardsCustomerRates(new CustomerRates(0, 0));
		}

		/**
		 * @return the _RegularCustomerRates
		 */
		public CustomerRates get_RegularCustomerRates() {
			return _RegularCustomerRates;
		}

		/**
		 * @param _RegularCustomerRates
		 *            the _RegularCustomerRates to set
		 */
		public void set_RegularCustomerRates(CustomerRates _RegularCustomerRates) {
			this._RegularCustomerRates = _RegularCustomerRates;
		}

		/**
		 * @return the _RewardsCustomerRates
		 */
		public CustomerRates get_RewardsCustomerRates() {
			return _RewardsCustomerRates;
		}

		/**
		 * @param _RewardsCustomerRates
		 *            the _RewardsCustomerRates to set
		 */
		public void set_RewardsCustomerRates(CustomerRates _RewardsCustomerRates) {
			this._RewardsCustomerRates = _RewardsCustomerRates;
		}

	}

	private HotelRates _HotelRates;

	private void CheckHotelRatesObject() {
		if (null == _HotelRates) {
			_HotelRates = new HotelRates();
		}
	}

	public Hotel(String hotelName, int rating) {
		this._HotelNameString = hotelName;
		this._RatingString = rating;

		this._HotelRates = new HotelRates();

	}

	@Override
	public String getHotelName() {
		return _HotelNameString;
	}

	@Override
	public int getHotelRating() {
		return _RatingString;
	}

	@Override
	public boolean setHotelInfo(String hotelName, int ratingString) {
		try {
			this._HotelNameString = hotelName;
			this._RatingString = ratingString;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean setRewardsHotelRates(float weekdayRates, float weekendRates) {
		CheckHotelRatesObject();

		_HotelRates.get_RewardsCustomerRates().set_WeekdayRates(weekdayRates);
		_HotelRates.get_RewardsCustomerRates().set_WeekendRates(weekendRates);

		return true;
	}

	@Override
	public boolean setRegularHotelRates(float weekdayRates, float weekendRates) {
		CheckHotelRatesObject();

		_HotelRates.get_RegularCustomerRates().set_WeekdayRates(weekdayRates);
		_HotelRates.get_RegularCustomerRates().set_WeekendRates(weekendRates);

		return true;
	}

	@Override
	public float getRewardsHotelRates(String ratesType) {
		if (null == _HotelRates) {
			return 0f;
		}
		if (HotelEnums.WEEKDAYS == ratesType) {
			return _HotelRates.get_RewardsCustomerRates()._WeekdayRates;
		} else if (HotelEnums.WEEKENDS == ratesType) {
			return _HotelRates.get_RewardsCustomerRates()._WeekendRates;
		} else {
			return 0f;
		}
	}

	@Override
	public float getRegularHotelRates(String ratesType) {
		if (null == _HotelRates) {
			return 0f;
		}
		if (HotelEnums.WEEKDAYS == ratesType) {
			return _HotelRates.get_RegularCustomerRates()._WeekdayRates;
		} else if (HotelEnums.WEEKENDS == ratesType) {
			return _HotelRates.get_RegularCustomerRates()._WeekendRates;
		} else {
			return 0f;
		}
	}

}
