package PdfMerger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfMerger {

    public static void merge(String pdfFinalPath, List<String> sortedPathList) throws DocumentException, IOException {

        if (sortedPathList.size() == 0) {
            System.out.println("The directory is apparently empty or does not have any pdf files.");
            throw new RuntimeException();
        }

        try {

            Document document = new Document();
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(pdfFinalPath));

            document.open();

            for (String path : sortedPathList) {

                PdfReader currentReader = new PdfReader(path);
                for (int j = 1; j <= currentReader.getNumberOfPages(); j++) {
                    PdfImportedPage page = copy.getImportedPage(currentReader, j);
                    copy.addPage(page);
                }
            }

            document.close();

            System.out.println("The merged file was generated successfully!");

        } catch (Exception e) {

            e.printStackTrace();
            throw (e);
        }
    }
}
