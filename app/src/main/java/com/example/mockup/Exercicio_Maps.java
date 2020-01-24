package com.example.mockup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Exercicio_Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final String[] LOCATION_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private static final int INITIAL_REQUEST=1337;
    private static final int LOCATION_REQUEST=INITIAL_REQUEST+3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio__maps);
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

        // Add a marker in Sydney and move the camera
        LatLng gramado = new LatLng(-29.375519, -50.870934);
        LatLng porto_alegre = new LatLng(-30.034518, -51.190199 );
        LatLng torres = new LatLng(-29.338279, -49.728216);
        LatLng caxias = new LatLng(-29.165434, -51.143817 );
        LatLng centro = new LatLng(-29.468223, -50.527955 );

        mMap.addMarker(new MarkerOptions().position(gramado).title("Gramado").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.pin)));

        mMap.addMarker(new MarkerOptions().position(porto_alegre).title("Porto Alegre").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.pin)));

        mMap.addMarker(new MarkerOptions().position(torres).title("Torres").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.pin)));

        mMap.addMarker(new MarkerOptions().position(caxias).title("Caxias do Sul").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.pin)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(gramado));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(torres));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(porto_alegre));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caxias));


        //setar o zoom do mapa
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(centro, 8.0f));
        //mostra controles de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //verifica se é permitido ao aplicativo pegar a localização atual do dispositivo
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            //caso ainda não tenha sido dada a permissão, solicitar a permissão
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(LOCATION_PERMS, LOCATION_REQUEST);
            }
        }

        //adiciona rota
        mMap.addPolyline(new PolylineOptions()
                .add(caxias, porto_alegre, gramado, torres, caxias)
                .width(10)
                .color(Color.RED));

        mMap.addCircle(
                new CircleOptions()
                        .center(centro)
                        .radius(100580.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70,150,50,50))
        );

    }
}
