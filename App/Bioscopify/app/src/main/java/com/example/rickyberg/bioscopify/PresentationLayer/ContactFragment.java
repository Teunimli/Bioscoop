package com.example.rickyberg.bioscopify.PresentationLayer;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rickyberg.bioscopify.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements OnMapReadyCallback {


    public ContactFragment() {
        // Required empty public constructor
    }

    private Button button;
    View rootView;
    GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        button = (Button) rootView.findViewById(R.id.buttonCall);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0658830782"));

                if (ActivityCompat.checkSelfPermission(rootView.getContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

        initializeMap();

        // Inflate the layout for this fragment
        return rootView;
    }
    private void initializeMap() {
        if (mMap == null) {
            SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            mapFrag.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(new LatLng(51.5851061,4.7971236)).title("Bioscopify"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.5851061,4.7971236),14));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
    }
}
