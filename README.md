# GoogleMapSample

## How to use GoogleMap in acitvity

### Dependency
* compile 'com.google.android.gms:play-services-maps:10.2.0'

### Required
```
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />

<meta-data
  android:name="com.google.android.geo.API_KEY"
  android:value="@string/google_maps_key" />
```
* Set GoogleMap api key
  * src/debug/res/values/google_maps_api.xml
  * src/release/res/values/google_maps_api.xml
