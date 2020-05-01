package org.nerdizin.eztrial.web.rest.controller.studydef;

import org.nerdizin.eztrial.repositories.study.def.MetaDataVersionRepository;
import org.nerdizin.eztrial.web.converter.MetaDataVersionConverter;
import org.nerdizin.eztrial.web.model.MetaDataVersion;
import org.nerdizin.eztrial.web.model.common.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MdvController {

	private final static Logger log = LoggerFactory.getLogger(MdvController.class);

	private final MetaDataVersionRepository metaDataVersionRepository;
	private static final MetaDataVersionConverter metaDataVersionConverter =
			new MetaDataVersionConverter();

	@Autowired
	public MdvController(final MetaDataVersionRepository metaDataVersionRepository) {
		this.metaDataVersionRepository = metaDataVersionRepository;
	}

	@GetMapping("/mdvs")
	public List<org.nerdizin.eztrial.web.model.MetaDataVersion> getMdvs(
			final Pagination pagination) {

		if (pagination.getSortBy() == null) {
			pagination.setSortBy(new String[]{"oid"});
		}

		final Page<org.nerdizin.eztrial.entities.study.def.MetaDataVersion> page = metaDataVersionRepository.findAll(
				PageRequest.of(pagination.getPage(),
						pagination.getRows(),
						pagination.getSortDirection(),
						pagination.getSortBy()));

		return page.stream().map(metaDataVersionConverter::convertToUiModel).collect(Collectors.toList());
	}

	@PostMapping("/mdvs")
	public MetaDataVersion createMdv(@RequestBody final MetaDataVersion mdv) {

		try {
			final org.nerdizin.eztrial.entities.study.def.MetaDataVersion savedMdv =
					metaDataVersionRepository.save(metaDataVersionConverter.convertToEntity(mdv));
			return metaDataVersionConverter.convertToUiModel(savedMdv);
		} catch (Exception e) {
			log.error("createMdv", e);
			throw new RuntimeException(e);
		}
	}
}
