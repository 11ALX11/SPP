package com.labrab6.task3;

import com.labrab6.task2.Directory;
import com.labrab6.task2.File;

public class Visitor
{
    public void visitFile(File file) {
        System.out.println("File: " + file.getName() + " (Size: " + file.getSize() + " bytes)");
    }

    public void visitDir(Directory directory) {
        System.out.println("Directory: " + directory.getName());
    }
}
