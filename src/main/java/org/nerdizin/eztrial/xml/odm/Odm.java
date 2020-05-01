package org.nerdizin.eztrial.xml.odm;

import org.nerdizin.eztrial.xml.adapter.FileTypeAdapter;
import org.nerdizin.eztrial.xml.adapter.LocalDateTimeAdapter;
import org.nerdizin.eztrial.xml.odm.admin.AdminData;
import org.nerdizin.eztrial.xml.odm.study.data.ClinicalData;
import org.nerdizin.eztrial.xml.odm.study.def.Study;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name = "ODM")
public class Odm {

    @XmlAttribute(name = "FileType")
    @XmlJavaTypeAdapter(FileTypeAdapter.class)
    private FileType fileType;

    @XmlAttribute(name = "FileOID")
    private String fileOid;

    @XmlAttribute(name = "CreationDateTime")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime creationDateTime;

    @XmlAttribute(name = "ODMVersion")
	private String odmVersion;

    @XmlElement(name = "Study")
    private Study study;

    @XmlElement(name = "AdminData")
    private AdminData adminData;

    @XmlElement(name = "ClinicalData")
    private ClinicalData clinicalData;


    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getFileOid() {
        return fileOid;
    }

    public void setFileOid(String fileOid) {
        this.fileOid = fileOid;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

	public String getOdmVersion() {
		return odmVersion;
	}

	public void setOdmVersion(final String odmVersion) {
		this.odmVersion = odmVersion;
	}

	public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public AdminData getAdminData() {
        return adminData;
    }

    public void setAdminData(AdminData adminData) {
        this.adminData = adminData;
    }

    public ClinicalData getClinicalData() {
        return clinicalData;
    }

    public void setClinicalData(ClinicalData clinicalData) {
        this.clinicalData = clinicalData;
    }
}
