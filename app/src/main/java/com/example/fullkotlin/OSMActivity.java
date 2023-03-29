package com.example.fullkotlin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;

import org.osmdroid.api.IGeoPoint;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;
import org.osmdroid.views.overlay.simplefastpoint.LabelledGeoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OSMActivity extends AppCompatActivity {

    private MapView map = null;

    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    ArrayList<Double> Latitude = new ArrayList<Double>(Arrays.asList(28.619846805765697,28.616662582003524,28.62405736412823,28.616975106635802));
    ArrayList<Double> Longitude = new ArrayList<Double>(Arrays.asList(77.3808249441672, 77.40679880836608,77.3377475561817, 77.3467168634806));

    private MyLocationNewOverlay locationOverlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osmactivity);

        requestPermissionsIfNecessary(new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_NETWORK_STATE, android.Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.INTERNET
        });

        Context ctx = this.getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        map = findViewById(R.id.mapview);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.getController().setZoom(15.0);
        map.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        map.setMultiTouchControls(true);

        //Compas Overlay
        CompassOverlay compassOverlay = new CompassOverlay(this, map);
        compassOverlay.enableCompass();
        map.getOverlays().add(compassOverlay);
        //Rotation
        RotationGestureOverlay mrotation = new RotationGestureOverlay(this, map);
        mrotation.setEnabled(true);
        map.getOverlays().add(mrotation);
        //Scalebar
        final DisplayMetrics metrics = getResources().getDisplayMetrics();
        ScaleBarOverlay mScaleBar = new ScaleBarOverlay(map);
        mScaleBar.setCentred(true);
        //play around with these values to get the Location on Screen in the right placefor your app
        mScaleBar.setScaleBarOffset(metrics.widthPixels / 2, 10);
        map.getOverlays().add(mScaleBar);

        List<IGeoPoint> points = new ArrayList<>();

        for(int i =0 ; i< Latitude.size() ; i++) {
            points.add(new LabelledGeoPoint(Latitude.get(i), Longitude.get(i)
                    , "Point #" + i));        }
        for(int j=0; j < points.size(); j++) {
            Marker startMarker = new Marker(map);
            startMarker.setPosition((GeoPoint) points.get(j));
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
            startMarker.setIcon(getResources().getDrawable(R.drawable.ic_baseline_gps_fixed_24));
            startMarker.setTitle(""+j);
            map.getOverlays().add(startMarker);
            map.getController().setCenter(points.get(j));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            permissionsToRequest.add(permissions[i]);
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void requestPermissionsIfNecessary(String[] permissions) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(permission);
            }
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }
}