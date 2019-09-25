package com.xxm.codeExtractor.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractFilePojo {

    private String codeDir;

    private final List<String> content;
    public abstract File toFile();

    public AbstractFilePojo(String[] arr){
        this.content = new ArrayList(Arrays.asList(arr));
    }

    public List<String> getContent(){
        return this.content;
    }

    public String getCodeDir() {
        return codeDir;
    }

    public void setCodeDir(String codeDir){
        this.codeDir = codeDir;
    }

}
