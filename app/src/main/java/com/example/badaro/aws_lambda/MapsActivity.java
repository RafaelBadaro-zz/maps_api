package com.example.badaro.aws_lambda;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.amazonaws.mobileconnectors.lambdainvoker.*;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng pucs[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void criarArray(){
            pucs[0] = new LatLng(-19.933209, -43.937179); // praça da liberdade
            pucs[1] = new LatLng(-19.924365, -43.991588);// coreu
            pucs[2] = new LatLng(-19.859570,-43.919052);// são gabriel
            pucs[3] = new LatLng(-19.976627, -44.027777);// barreiro
            pucs[4] = new LatLng(-19.954935, -44.198635);// betim
            pucs[5] = new LatLng(-19.940546, -44.076264);// contagem
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
        criarArray();

        // Add a marker in Sydney and move the camera
        for (int i = 0; i <= pucs.length; i++){
            mMap.addMarker(new MarkerOptions().position(pucs[i]).title("Uma unidade da PUC MINAS"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(pucs[i]));
        }

    }
}
