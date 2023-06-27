package com.lazypostman.optimizeroute.service;

import com.lazypostman.optimizeroute.model.geocoding.GeocodingLocation;
import com.lazypostman.optimizeroute.model.geocoding.GeocodingResponse;
import com.lazypostman.optimizeroute.model.geocoding.GeocodingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {

    private static final String API_KEY = "AIzaSyAx9PZiui8q41GiFN9Y_daSCyCpVYywQpw";

    public GeocodingLocation getCoordinates(String address) throws Exception {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/geocode/json")
                .queryParam("key",API_KEY)
                .queryParam("address",address)
                .build();
            GeocodingResponse response = new RestTemplate().getForObject(uri.toUriString(), GeocodingResponse.class);
        return  response.getResults()[0].getGeometry().getLocation();

    }

}
