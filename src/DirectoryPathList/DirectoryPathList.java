package DirectoryPathList;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirectoryPathList {

    public static List<String> getMainDirectoryPathsList(String folder) {

        List<String> directoryPaths = new ArrayList<>();

        try {
            Path directory = Paths.get(folder);
            File[] files = directory.toFile().listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        directoryPaths.add(file.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return directoryPaths;
    }


}
