package com.xxm.codeExtractor.FileReader;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.*;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class FilePojoFactoryTest {

    private FilePojoFactory factory;

    String fileLocaiton = "/Users/xiuxuming/IdeaProjects/codeExtractor/src/test/resources/demo.md";
    String codeLocation = "/Users/xiuxuming/IdeaProjects/codeExtractor/src/main/resources";


    @Before
    public void setup(){
        factory = new FilePojoFactory();

        ReflectionTestUtils.setField(factory,"fileLocation",fileLocaiton);
    }

    @Test
    public void testcreatePojoCode() throws IOException {
        InputStream inputStream = new FileInputStream(new File(fileLocaiton));
        AbstractFilePojo pojo = factory.createPoJo(inputStream,true);
        //System.out.println(pojo.getContent());
        assertTrue(pojo instanceof CodePojo);
        CodePojo pojo1 = (CodePojo) pojo;
        ReflectionTestUtils.setField(pojo1,"codeDir",codeLocation);
        pojo1.toFile();
        assertNotNull(pojo.getContent());
    }

    @Test
    public void testcreatePojoFile() throws IOException {
        InputStream inputStream = new FileInputStream(new File(fileLocaiton));
        AbstractFilePojo pojo = factory.createPoJo(inputStream,false);
        System.out.println(pojo.getContent());
        assertTrue(pojo instanceof FilePojo);
        FilePojo pojo1 = (FilePojo) pojo;
        ReflectionTestUtils.setField(pojo1,"codeDir",codeLocation);
        pojo1.toFile();
        assertNotNull(pojo.getContent());
    }

}
