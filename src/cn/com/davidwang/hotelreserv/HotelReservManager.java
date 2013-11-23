/**
 * 
 */
package cn.com.davidwang.hotelreserv;

import java.util.HashMap;
import java.util.Map;

import cn.com.davidwang.hotelreserv.hotel.Hotel;
import cn.com.davidwang.hotelreserv.hotel.IHotel;
import cn.com.davidwang.hotelreserv.input.IHotelInput;
import cn.com.davidwang.hotelreserv.output.IHotelOutput;
import cn.com.davidwang.hotelreserv.service.IFindHotel;

/**
 * @author DavidWang
 * 
 */
public class HotelReservManager implements IHotelReservManager {

	private IHotelFactory _HotelFactoryObj;

	private IHotelOutput _HotelOutputObj;
	private IHotelInput _HotelInputObj;

	private IFindHotel _HotelFinder;

	// a list to store all hotels.
	private Map<String, IHotel> _HotelsMap;

	private boolean GenerateReservParts() {
		// create factory
		try {
			_HotelFactoryObj = new HotelFactory();

			// create parts
			_HotelInputObj = _HotelFactoryObj.GetHotelInputObj();
			_HotelOutputObj = _HotelFactoryObj.GetHotelOutputObj();

			_HotelsMap = GenerateHotels();
			_HotelFinder = _HotelFactoryObj.GetHotelFinderObj();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private Map<String, IHotel> GenerateHotels() {
		Map<String, IHotel> hotelsMap = new HashMap<String, IHotel>();

		IHotel lakeWoodHotel = new Hotel("LakeWood", 3);
		lakeWoodHotel.setRegularHotelRates(110f, 90f);
		lakeWoodHotel.setRewardsHotelRates(80f, 80f);
		hotelsMap.put("LakeWood", lakeWoodHotel);

		IHotel bridgeWoodHotel = new Hotel("BridgeWood", 4);
		bridgeWoodHotel.setRegularHotelRates(160f, 60f);
		bridgeWoodHotel.setRewardsHotelRates(110f, 50f);
		hotelsMap.put("BridgeWood", bridgeWoodHotel);

		IHotel ridgeWoodHotel = new Hotel("RidgeWood", 5);
		ridgeWoodHotel.setRegularHotelRates(220f, 150f);
		ridgeWoodHotel.setRewardsHotelRates(100f, 40f);
		hotelsMap.put("RidgeWood", ridgeWoodHotel);

		return hotelsMap;
	}

	private boolean ConnectReservParts() {
		_HotelFinder.SetInputObj(_HotelInputObj);
		_HotelFinder.SetOutputObj(_HotelOutputObj);
		_HotelFinder.SetHotelData(_HotelsMap);

		_HotelInputObj.SetManager(this);
		_HotelFinder.SetManager(this);
		
		_HotelOutputObj.SetHotelFinder(_HotelFinder);

		return true;
	}

	public HotelReservManager() {
		if(GenerateReservParts()){
			ConnectReservParts();
		}
	}

	@Override
	public boolean GetInput() {
		return _HotelInputObj.GetInput();
	}

	@Override
	public boolean GetCheapestHotel() {
		return _HotelFinder.GetHotel();
	}

	@Override
	public boolean OutputResult() {
		return _HotelOutputObj.OutputResult();
	}

	@Override
	public boolean OutputError(String msg) {
		return Output(msg);
	}

	@Override
	public boolean Output(String msg) {
		_HotelOutputObj.Output(msg);
		return true;
	}

}
