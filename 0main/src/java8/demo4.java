package java8;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo4 {
    public static void main(String[] args) {

        String[] paths = {"C:\\MyWorkSpace\\baseProject"};
//        String[] paths = {"C:\\workSpace\\space-server"};


        List<String> pathList = new ArrayList<>();
        List<String> list = Arrays.asList(paths);
        list.forEach(e -> {
            List<String> list1 = returnAllDirectory(e, pathList, getDirectory());
            list1.forEach(directory ->{
                System.out.println(directory);
                List<String> list2 = returnAssignFile(directory, getAssignSuffixFile(".java"));
                list2.forEach(System.out::println);
            });
        });

    }

    static List<String> returnAllDirectory(String path, List<String> pathList, FileFilter filter) {
        File file = new File(path);
        File[] files = file.listFiles(filter);
        if (files.length != 0) {
            for (File file1 : files) {
                pathList.add(file1.getPath());
                returnAllDirectory(file1.getPath(), pathList, filter);
            }
        }
        return pathList;
    }

    static List<String> returnAssignFile(String path, FilenameFilter filter) {
        List<String> fileList = new ArrayList<>();
        File file = new File(path);
        String[] list = file.list(filter);
        if (list.length != 0) {
            for (String s : list) {
                fileList.add(file.getPath() + "\\" +s);
            }
        }
        return fileList;
    }

    static FileFilter getDirectory(){
        return dir -> dir.isDirectory();
    }

    static FilenameFilter getAssignSuffixFile(String suffix){
        return (dir, name) -> new File(dir, name).isFile() && name.contains(suffix);
    }

}
