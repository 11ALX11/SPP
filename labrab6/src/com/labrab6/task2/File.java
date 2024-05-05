package com.labrab6.task2;

import com.labrab6.task3.Visitor;

@SuppressWarnings("FieldMayBeFinal")
public
class File implements FileSystemComponent
{
    protected String name;
    protected int size;

    public File(String name, int size)
    {
        this.name = name;
        this.size = size;
    }

    public String getName()
    {
        return name;
    }

    public int getSize()
    {
        return size;
    }

    @Override
    public void displayInfo(String indent)
    {
        System.out.println(indent + "File: " + name + ", Size: " + size + " bytes");
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visitFile(this);
    }
}
