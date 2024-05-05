package com.labrab6.task2;

import com.labrab6.task3.Visitor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldMayBeFinal")
public
class Directory implements FileSystemComponent
{
    protected String name;
    protected List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name)
    {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component)
    {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component)
    {
        components.remove(component);
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void displayInfo(String indent)
    {
        System.out.println(indent + "Directory: " + name);
        for (FileSystemComponent component : components)
        {
            component.displayInfo(indent + "  ");
        }
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visitDir(this);
    }
}
