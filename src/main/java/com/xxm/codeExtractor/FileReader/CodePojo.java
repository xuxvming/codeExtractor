package com.xxm.codeExtractor.FileReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodePojo extends AbstractFilePojo {



    public CodePojo(String[] arr ){
        super(arr);
    }


    @Override
    public File toFile() {
        String fileName = getCodeDir() +File.separator+"helloworld-v2.java";
        File sourceCode = new File(fileName);
        String codeLine = organiseCode();
        try {
            FileUtils.writeStringToFile(sourceCode,codeLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceCode;
    }

    public String organiseCode(){
        String clazz = extractClass();
        String methods = extactMethods();
        List<String> code = new ArrayList<>();
        code.add(StringUtils.split(clazz,"{")[0]+"{");
        code.add(methods);
        code.add("}");

        String line = code.toString().replace(",","");
        line = line.replace("[","");
        line = line.replace("]","");
        return line;
    }

    private String extractClass(){
        for (String line: getContent()){
            if(line.contains("public class")){
                String l = line.replace(",","");
                return l.trim();
            }
        }
        return "";
    }

    private String extactMethods(){
        StringBuffer sb = new StringBuffer();
        for (String line: getContent()){
            if(!line.contains(" class ")){
                String l = line.replace(",","");
                sb.append(l.trim()+"\n");
            }
        }
        return sb.toString();
    }

}
