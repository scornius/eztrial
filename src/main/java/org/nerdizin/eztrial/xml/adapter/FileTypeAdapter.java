package org.nerdizin.eztrial.xml.adapter;

import org.nerdizin.eztrial.xml.odm.FileType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class FileTypeAdapter extends XmlAdapter<String, FileType> {

    @Override
    public FileType unmarshal(final String code) throws Exception {
        return FileType.fromCode(code);
    }

    @Override
    public String marshal(FileType fileType) throws Exception {
        return fileType.getCode();
    }
}
