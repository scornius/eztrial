package org.nerdizin.eztrial.web.mvc;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.repositories.LocationRepository;
import org.nerdizin.eztrial.web.rest.controller.util.PagingParameters;
import org.nerdizin.eztrial.web.rest.converter.LocationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/locations")
public class LocationController {

	private final LocationRepository locationRepository;
	private final LocationConverter locationConverter = new LocationConverter();

	@Autowired
	public LocationController(final LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@GetMapping("/listLocations")
	public String listLocations(final Model model) {

		final PagingParameters pagingParameters = new PagingParameters();
		pagingParameters.setPage(0);
		pagingParameters.setSize(100);

		final Page<Location> page = locationRepository.findAll(
				PageRequest.of(pagingParameters.getPage(),
						pagingParameters.getSize(),
						pagingParameters.getSortDirection(),
						"oid"));

		model.addAttribute("locations",
				page.stream().map(locationConverter::convertToUiModel).collect(Collectors.toList()));
		return "locations.html";
	}
}
