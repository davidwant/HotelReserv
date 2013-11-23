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
		
		while (true){
			
			hotelReservManager.OutputHints();
			
			hotelReservManager.GetInput();
			
			hotelReservManager.GetCheapestHotel ();
			
			hotelReservManager.OutputResult();
		}
		
		
	}

	

}
