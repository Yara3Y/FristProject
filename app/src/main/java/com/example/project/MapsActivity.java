package com.example.project;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.project.databinding.ActivityMapsBinding;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;


    private LatLng  western = new LatLng(22.853272, 39.495625);
    private LatLng  central = new LatLng(24.218513, 44.674599);
    private LatLng  southern = new LatLng(18.255502, 45.260848);

    private Marker mWestern;
    private Marker mCentral;
    private Marker mSouthern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<Marker> markerList = new ArrayList<>();

        mWestern = mMap.addMarker(new MarkerOptions().position(western).title("Western"));
        mWestern.setTag(0);
        markerList.add(mWestern);

        mCentral = mMap.addMarker(new MarkerOptions().position(central).title("Central"));
        mCentral.setTag(0);
        markerList.add(mCentral);

        mSouthern = mMap.addMarker(new MarkerOptions().position(southern).title("Southern"));
        mSouthern.setTag(0);
        markerList.add(mSouthern);

        mMap.setMapType(googleMap.MAP_TYPE_TERRAIN);
        mMap.setOnMarkerClickListener(this);

        for(Marker m : markerList){
            LatLng latLng = new LatLng(m.getPosition().latitude,m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
        }
    }
    public boolean onMarkerClick(@NonNull Marker marker) {
        String tit = marker.getTitle();
        if (tit.equals("Western")){
            Intent intent = new Intent(this,MuseumPage2.class);
             startActivity(intent);
        }
        if (tit.equals("Central")){
            Intent intent = new Intent(this,Museum_page.class);
            startActivity(intent);
        }
        if (tit.equals("Southern")){
             Intent intent = new Intent(this,MuseumePage3.class);
            startActivity(intent);
        }

        return false;
    }


}