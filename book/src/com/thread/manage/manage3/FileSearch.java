package com.thread.manage.manage3;

import java.io.File;

/**
 * @author elliott
 * 控制线程中断:递归层次的控制线程中断
 */
public class FileSearch implements Runnable{

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s The search has been interrupted",Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException{
        File[] list = file.listFiles();
        if (list != null) {
            for (File file1 : list) {
                if (file1.isDirectory()) {
                    directoryProcess(file1);
                } else {
                    fileProcess(file1);
                }
            }
            if (Thread.interrupted()){
                throw new InterruptedException();
            }
        }
    }

    private void fileProcess(File file) throws InterruptedException{
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n",Thread.currentThread().getName(),file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException("引发线程中断异常");
        }
    }
}
