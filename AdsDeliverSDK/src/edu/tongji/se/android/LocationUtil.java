package edu.tongji.se.android;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class LocationUtil {

	private static final String TAG = "AdsDeliverSDK";

	static LocationManager locationManager;  
	
	public static void getLocation(Context context, LocationListener listener) {
		
        String serviceName = Context.LOCATION_SERVICE;  
        locationManager = (LocationManager) context.getSystemService(serviceName);  
        Criteria criteria = new Criteria();  
        
        
        // 通过GPS获取
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        
        
        criteria.setAltitudeRequired(false);  
        criteria.setBearingRequired(false);  
        criteria.setCostAllowed(false);  
        criteria.setPowerRequirement(Criteria.POWER_LOW);  
        String provider = locationManager.getBestProvider(criteria, true);  
        Location location = locationManager  
                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);  
		
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 6000, 10,     
        		listener);
        
	}
	
	
	
	private final static LocationListener locationListener = new LocationListener() {     
        public void onLocationChanged(Location location) {     
       	 logLocation(location);     
        }     
        public void onProviderDisabled(String provider){  
            Log.i(TAG, "Provider now is disabled..");  
        }     
        public void onProviderEnabled(String provider){  
            Log.i(TAG, "Provider now is enabled..");  
        }     
        public void onStatusChanged(String provider, int status, Bundle extras){ }     
	 };     
	 
	 private static void logLocation(Location location) {
		 String latLng;      
        if (location != null) {    
        double lat = location.getLatitude();     
        double lng = location.getLongitude();  
          
        latLng = "Latitude:" + lat + "  Longitude:" + lng;     
        } else {     
        latLng = "Can't access your location";   
        }  
        Log.i(TAG, "The location has changed..");  
        Log.i(TAG, "Your Location:" +latLng);  
	 }
	 
	 
}
