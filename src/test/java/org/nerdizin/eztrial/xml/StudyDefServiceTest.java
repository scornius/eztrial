package org.nerdizin.eztrial.xml;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nerdizin.eztrial.services.xml.StudyDefService;
import org.nerdizin.eztrial.services.xml.StudyDefServiceImpl;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.springframework.test.context.junit4.SpringRunner;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;

import java.io.*;

@RunWith(SpringRunner.class)
public class StudyDefServiceTest {

    private static StudyDefService studyDefService;


    @BeforeClass
    public static void init() {
        studyDefService = new StudyDefServiceImpl();
    }

    @Test
    public void testParse() throws Exception {
		final Odm odm = studyDefService.parse(this.getClass().getResourceAsStream("/odm/study1.xml"));
		Assert.assertEquals(odm.getFileOid(), "1");
		studyDefService.serialize(odm, System.out);
	}

	@Test(expected = javax.xml.bind.UnmarshalException.class)
	public void testParseInvalidSchema() throws Exception {
		final Odm odm = studyDefService.parse(this.getClass().getResourceAsStream("/odm/study_invalid_schema.xml"));
		Assert.assertEquals(odm.getFileOid(), "1");
		studyDefService.serialize(odm, System.out);
	}

	@Test
	public void testParseAndSerialize() throws Exception {
    	final InputStream sourceIs = this.getClass().getResourceAsStream("/odm/study1.xml");
		final Odm odm = studyDefService.parse(sourceIs);
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		studyDefService.serialize(odm, bos);

		final Input.Builder source = Input.from(this.getClass().getResourceAsStream("/odm/study1.xml"));
		final Input.Builder target = Input.from(bos.toByteArray());

		final Diff diff = DiffBuilder
				.compare(target)
				.withTest(source)
				.ignoreComments()
				.ignoreWhitespace()
				.build();
		for (final Difference difference : diff.getDifferences()) {
			System.out.println(difference);
		}

		Assert.assertFalse(diff.hasDifferences());
	}

}
