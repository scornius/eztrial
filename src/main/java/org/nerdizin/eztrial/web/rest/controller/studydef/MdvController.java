package org.nerdizin.eztrial.web.rest.controller.studydef;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.nerdizin.eztrial.repositories.MetaDataVersionRepository;
import org.nerdizin.eztrial.web.rest.controller.util.PagingParameters;
import org.nerdizin.eztrial.web.rest.converter.MetaDataVersionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MdvController {

	private final static Log log = LogFactory.getLog(MdvController.class);

	private final MetaDataVersionRepository metaDataVersionRepository;
	private static final MetaDataVersionConverter metaDataVersionConverter =
			new MetaDataVersionConverter();

	@Autowired
	public MdvController(final MetaDataVersionRepository metaDataVersionRepository) {
		this.metaDataVersionRepository = metaDataVersionRepository;
	}

	@GetMapping("/mdvs")
	public List<org.nerdizin.eztrial.web.rest.model.MetaDataVersion> getMdvs(
			final PagingParameters pagingParameters) {

		final Page<MetaDataVersion> page = metaDataVersionRepository.findAll(
				PageRequest.of(pagingParameters.getPage(),
						pagingParameters.getSize(),
						pagingParameters.getSortDirection(),
						pagingParameters.getProperties()));
		log.info("totalElements: " + page.getTotalElements());
		log.info("totalPages: " + page.getTotalPages());

		return page.stream().map(metaDataVersionConverter::convertToUiModel).collect(Collectors.toList());
	}
}
