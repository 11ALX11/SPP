package com.labrab6.task2;

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

    public List<FileSystemComponent> getComponents()
    {
        return components;
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

}
