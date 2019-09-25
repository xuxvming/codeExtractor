package com.xxm.codeExtractor.FileReader;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.pdf.converter.PdfConverterExtension;
import com.vladsch.flexmark.profiles.pegdown.Extensions;
import com.vladsch.flexmark.profiles.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataHolder;

import java.io.File;

public class FilePojo extends AbstractFilePojo {

    public FilePojo(String[] arr) {
        super(arr);
    }

    static final MutableDataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(
            Extensions.ALL & ~(Extensions.ANCHORLINKS | Extensions.EXTANCHORLINKS_WRAP)
    ).toMutable();

    @Override
    public File toFile() {
        final Parser parser = Parser.builder(OPTIONS).build();
        final HtmlRenderer renderer = HtmlRenderer.builder(OPTIONS).build();
        String line = getContent().toString().replaceAll(",","\n").replace("[","").replace("]","");
        Node document = parser.parse(line);
        String html = renderer.render(document);

        html = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\">\n" +
                "\n" +  // add your stylesheets, scripts styles etc.
                "</head><body>" + html + "\n" +
                "</body></html>";

        PdfConverterExtension.exportToPdf(getCodeDir()+"/demoDoc.pdf", html,"", OPTIONS);

        return null;
    }
}
