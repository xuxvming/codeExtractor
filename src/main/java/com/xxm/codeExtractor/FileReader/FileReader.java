package com.xxm.codeExtractor.FileReader;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * The type File reader.
 */
public class FileReader {

    /**
     * File reader input stream.
     *
     * @return the input stream
     * @throws IOException the io exception
     */
    public InputStream readFile(String fileLocation) throws IOException {
        File targetFile = new File(fileLocation);
        return FileUtils.openInputStream(targetFile);
    }


}
