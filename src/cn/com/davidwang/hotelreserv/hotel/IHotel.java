/**
 * 
 */
package cn.com.davidwang.hotelreserv.hotel;

import java.lang.reflect.Array;

/**
 * @author DavidWang
 * 
 */
public interface IHotel {
	abstract String getHotelName();

	abstract int getHotelRating();

	abstract boolean setHotelInfo(String hotelName, int ratingString);

	abstract boolean setRewardsHotelRates(float weekdayRates, float weekendRates);

	abstract boolean setRegularHotelRates(float weekdayRates, float weekendRates);

	abstract float getRewardsHotelRates(String ratesType);

	abstract float getRegularHotelRates(String ratesType);
}
