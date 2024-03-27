package com.labrab6.task3;

import com.labrab6.task2.Directory;
import com.labrab6.task2.FileSystemComponent;

public class DirectoryTask3 extends Directory implements FileSystemComponentTask3
{
    public DirectoryTask3(String name)
    {
        super(name);
    }

    @Override
    public int getSize()
    {
        int size = 0;

        for (FileSystemComponent component : components)
        {
            if (component instanceof FileSystemComponentTask3 comp)
            {
                size += comp.getSize();
            }
        }

        return size;
    }

    @Override
    public void displayInfo(String indent)
    {
        System.out.println(indent + "Directory: " + name + ", Size: " + getSize() + " bytes");
        for (FileSystemComponent component : components)
        {
            component.displayInfo(indent + "  ");
        }
    }
}
