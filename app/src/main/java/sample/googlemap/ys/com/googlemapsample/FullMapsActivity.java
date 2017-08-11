package sample.googlemap.ys.com.googlemapsample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by ys on 2017. 8. 11..
 */

public class FullMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    class MarkerInfo {
        String cityName;
        LatLng latLng;
        int iconType;

        MarkerInfo(String cityName, LatLng latLng, int iconType) {
            this.cityName = cityName;
            this.latLng = latLng;
            this.iconType = iconType;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public LatLng getLatLng() {
            return latLng;
        }

        public void setLatLng(LatLng latLng) {
            this.latLng = latLng;
        }

        public int getIconType() {
            return iconType;
        }

        public void setIconType(int iconType) {
            this.iconType = iconType;
        }

    }

    private ArrayList<MarkerInfo> alMarkers;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        initMarkers();
    }

    private void initMarkers() {
        alMarkers = new ArrayList<>();

        alMarkers.add(new MarkerInfo("Seoul", new LatLng(37.5650793, 126.9195108), 1));
        alMarkers.add(new MarkerInfo("Seoul2", new LatLng(37.548205, 127.0069293), 1));
        alMarkers.add(new MarkerInfo("Seoul3", new LatLng(37.550110, 127.039674), 2));
        alMarkers.add(new MarkerInfo("Seoul4", new LatLng(37.541672,127.0773103), 3));

        alMarkers.add(new MarkerInfo("Okinawa", new LatLng(25.9613379, 126.0118903), 1));
        alMarkers.add(new MarkerInfo("Greece", new LatLng(38.1245189, 22.2388239), 3));
        alMarkers.add(new MarkerInfo("Beijing", new LatLng(39.9387995,116.2573781), 2));
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
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));


        for(MarkerInfo marker : alMarkers) {

            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.marker1);

            switch (marker.iconType) {
                case 1:
                    bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.marker1);
                    break;
                case 2:
                    bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.marker2);
                    break;
                case 3:
                    bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.marker3);
                    break;
            }

            mMap.addMarker(new MarkerOptions()
                    .position(marker.getLatLng())
                    .title(marker.getCityName())
                    .icon(bitmapDescriptor)
                    .flat(true));

        }

        mMap.setMinZoomPreference(6.0f);
        mMap.setMaxZoomPreference(mMap.getMaxZoomLevel());

        mMap.moveCamera(CameraUpdateFactory.newLatLng(alMarkers.get(0).getLatLng()));
        CameraUpdateFactory.zoomTo(mMap.getMaxZoomLevel());

    }
}
