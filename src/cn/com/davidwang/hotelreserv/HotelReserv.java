/**
 * 
 */
package cn.com.davidwang.hotelreserv;

/**
 * @author DavidWang
 * 
 */
public class HotelReserv {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		IHotelReservManager hotelReservManager = new HotelReservManager();
		hotelReservManager.OutputHints();

		if (hotelReservManager.GetInput()) {
			int count = (hotelReservManager.GetInputStringContainer().size() - 1);
			int index = 0;
			while (0 != count) {

				String inputString = hotelReservManager
						.GetInputStringContainer().get(index);
				if (hotelReservManager.TranslateInput(inputString)) {
					hotelReservManager.Output(inputString);
					if (hotelReservManager.GetCheapestHotel()) {
						hotelReservManager.OutputResult();
					}
				}
				index++;
				count--;
			}
		}
	}

}
