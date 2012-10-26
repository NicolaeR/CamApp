package com.santander.maps;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class HelloItemOverlay extends ItemizedOverlay {
	
	Context mContext;
	
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();

	public HelloItemOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}

	public HelloItemOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		mContext = context;
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.add(overlay);
		populate();
	}
	
	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mOverlays.get(index);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		
		return true;
	}
	@Override
	protected OverlayItem createItem(int i) {
		return mOverlays.get(i);

	}

	@Override
	public int size() {
		return mOverlays.size();
	}

}
