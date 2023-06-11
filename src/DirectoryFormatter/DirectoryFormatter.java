package DirectoryFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DirectoryFormatter {

    static int index = 0;

    public static List<String> filterAndSortPathList(List<String> pathList) {

        List<String> directoryPaths = new ArrayList<>();

        for (String path : pathList) {
            if (path.contains(".pdf")) {
                directoryPaths.add(path);
            }
        }

        Collections.sort(directoryPaths, new FilePathComparator());

        return directoryPaths;
    }

    static class FilePathComparator implements Comparator<String> {

        @Override
        public int compare(String path1, String path2) {
            int index1 = getIndexFromFileName(path1);
            int index2 = getIndexFromFileName(path2);

            return Integer.compare(index1, index2);
        }

        private int getIndexFromFileName(String filePath) {

            String fileName = filePath.replaceAll("[^0-9]", "");

            int currentIndex;
            try {
                currentIndex = Integer.parseInt(fileName);
            } catch (Exception e) {
                currentIndex = index++;
            }
            return currentIndex;
        }
    }
}
