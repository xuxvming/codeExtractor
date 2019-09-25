package com.xxm.codeExtractor.controller;


import com.xxm.codeExtractor.FileExtractor.FileExtratcor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getFile")
public class FileController{

    @Autowired
    FileExtratcor extratcor;

    @RequestMapping(value = "/code/{extractCode}",method = RequestMethod.GET)
    public void getFile(@PathVariable("extractCode") boolean extractCode) {
        extratcor.Extract(extractCode);
    }
}
