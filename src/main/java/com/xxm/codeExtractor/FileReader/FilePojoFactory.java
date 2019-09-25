package com.xxm.codeExtractor.FileReader;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.executable.ValidateOnExecution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FilePojoFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilePojoFactory.class);

    @Autowired
    private FileReader FileReader;

    @Value("${filelocation}")
    private String fileLocation;

    @Value("${codeDir}")
    private String codeDir;

    private boolean extractCode = true;


    public AbstractFilePojo createPopJo(){
        return createPoJo(isExtractCode());
    }

    private AbstractFilePojo createPoJo(boolean extractCode){
        InputStream inputStream = null;
        try {
            inputStream = FileReader.readFile(fileLocation);
            return createPoJo(inputStream, extractCode);
        } catch (IOException e) {
            LOGGER.error("FilePojoFactory - Error reading file",e);
            return null;
        }
    }


    protected AbstractFilePojo createPoJo(InputStream inputStream, boolean extractCode) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> lines = new ArrayList<>();
        while (reader.ready()) {
            String line = reader.readLine();
            //could be different combinations
            lines.add(line);
        }
        if (extractCode){
            String[] arr = StringUtils.substringsBetween(lines.toString(),"```","```");
            AbstractFilePojo pojo = new CodePojo(arr);
            pojo.setCodeDir(codeDir);
            return pojo;
        }

        AbstractFilePojo pojo = new FilePojo(lines.toArray(new String[lines.size()]));
        pojo.setCodeDir(codeDir);
        return pojo;
    }

    public boolean isExtractCode() {
        return extractCode;
    }

    public void setExtractCode(boolean extractCode) {
        this.extractCode = extractCode;
    }






}
