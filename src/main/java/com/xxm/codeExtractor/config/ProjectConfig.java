package com.xxm.codeExtractor.config;

import com.xxm.codeExtractor.FileExtractor.FileExtratcor;
import com.xxm.codeExtractor.FileReader.AbstractFilePojo;
import com.xxm.codeExtractor.FileReader.FilePojoFactory;
import com.xxm.codeExtractor.FileReader.FileReader;
import com.xxm.codeExtractor.controller.FileController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public FileReader fileReader(){
        return new FileReader();
    }

    @Bean
    public FilePojoFactory filePojoFactory(){
        return new FilePojoFactory();
    }

    @Bean
    public FileExtratcor fileExtratcor(){
        return new FileExtratcor();
    }

    @Bean
    public FileController fileController(){
        return new FileController();
    }


}
