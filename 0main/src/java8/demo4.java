package java8;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class demo4 {
    public static void main(String[] args) {

        String[] paths = {"C:\\MyWorkSpace\\baseProject"};
//        String[] paths = {"C:\\workSpace\\space-server"};


        List<String> pathList = new ArrayList<>();
        List<String> list = Arrays.asList(paths);
        List<String> allFileList = new ArrayList<>();
        list.forEach(e -> {
            returnAllDirectory(e, pathList, getDirectory());
            allFileList.addAll(pathList);
            pathList.forEach(directory ->{
//                System.out.println(directory);
                List<String> list2 = returnAssignFile(directory, getAssignSuffixFile(".java"));
                allFileList.addAll(list2);
//                list2.forEach(System.out::println);
            });
            allFileList.forEach(System.out::println);
            List<String> allFileList2 = allFileList.stream().sorted().collect(Collectors.toList());
            System.out.println("=====================================");
            allFileList2.forEach(System.out::println);
        });

    }

    static void returnAllDirectory(String path, List<String> pathList, FileFilter filter) {
        File file = new File(path);
        File[] files = file.listFiles(filter);
        if (files.length != 0) {
            for (File file1 : files) {
                pathList.add(file1.getPath());
                returnAllDirectory(file1.getPath(), pathList, filter);
            }
        }
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
