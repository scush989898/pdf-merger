import java.io.IOException;
import java.util.List;

import DirectoryFormatter.DirectoryFormatter;
import DirectoryPathList.DirectoryPathList;
import PdfMerger.PdfMerger;
import com.itextpdf.text.DocumentException;


public class Main {
    public static void main(String[] args) throws DocumentException, IOException {

//        remember to organize the files in the folder with sequential numbers so that
//        the final file is generated with the contents in the correct order:
//
//        Example: a folder with 4 files:
//
//        Suggested naming:
//
//        1.pdf
//        2.pdf
//        3.pdf
//        4.pdf

//        but if you don't want to fill it sequentially, just run the program in the
//        folder and it will sort it in the reading order


        //fill in here with the path to the folder containing the files to be merged
        String mainDirectoryPath = "C:\\Users\\user\\folder\\example";

        //fill in here the final path that will be assigned to the generated file

        String pdfFinalPath = "C:\\Users\\user\\folder\\example\\final.pdf";
        //in this example "final.pdf" will be the name of the generated file


        List<String> fullPathsList = DirectoryPathList.getMainDirectoryPathsList(mainDirectoryPath);
        List<String> sortedPathList = DirectoryFormatter.filterAndSortPathList(fullPathsList);
        PdfMerger.merge(pdfFinalPath, sortedPathList);

    }

}