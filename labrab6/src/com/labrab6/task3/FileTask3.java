package com.labrab6.task3;

import com.labrab6.task2.File;

public class FileTask3 extends File implements FileSystemComponentTask3
{
    public FileTask3(String name, int size)
    {
        super(name, size);
    }

    @Override
    public int getSize()
    {
        return size;
    }
}
