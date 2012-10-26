package com.santander.maps;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapsActivity extends MapActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);

		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources()
				.getDrawable(R.drawable.marcador);
		HelloItemOverlay itemizedoverlay = new HelloItemOverlay(drawable, this);

		//call intent
		   
		
		// santander lisboa
		GeoPoint point = new GeoPoint(38796908 ^ 6, -9162598 ^ 6);
		OverlayItem overlayitem = new OverlayItem(point, "Santander Lisboa",
				"Este banco tem estes departamentos: dep1, dep2 dep3");
		
		

		// adicionar banco
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}