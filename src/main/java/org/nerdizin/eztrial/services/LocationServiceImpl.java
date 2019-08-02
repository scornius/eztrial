package org.nerdizin.eztrial.services;

import org.nerdizin.eztrial.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

	private final LocationRepository locationRepository;

	@Autowired
	public LocationServiceImpl(final LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}


}
