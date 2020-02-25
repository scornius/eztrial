package org.nerdizin.eztrial.web.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.repositories.admin.LocationRepository;
import org.nerdizin.eztrial.web.converter.LocationConverter;
import org.nerdizin.eztrial.web.model.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/location")
public class LocationController {

	private final static Log log = LogFactory.getLog(LocationController.class);

	private final LocationRepository locationRepository;
	private final LocationConverter locationConverter = new LocationConverter();

	@Autowired
	public LocationController(final LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@GetMapping("/listLocations")
	public String listLocations(final Model model) {

		final Pagination pagination = new Pagination();
		pagination.setPage(0);
		pagination.setRows(100);

		final Page<Location> page = locationRepository.findAll(
				PageRequest.of(pagination.getPage(),
						pagination.getRows(),
						pagination.getSortDirection(),
						"oid"));

		model.addAttribute("locations",
				page.stream().map(locationConverter::convertToUiModel).collect(Collectors.toList()));
		return "admin/locations.html";
	}
}
