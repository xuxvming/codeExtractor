package com.xxm.codeExtractor.FileExtractor;

import com.xxm.codeExtractor.FileReader.AbstractFilePojo;
import com.xxm.codeExtractor.FileReader.FilePojoFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class FileExtratcor {

    @Autowired
    FilePojoFactory factory;

    public void Extract(boolean extractCode){
        factory.setExtractCode(extractCode);
        AbstractFilePojo pojo = factory.createPopJo();
        pojo.toFile();
    }

}
