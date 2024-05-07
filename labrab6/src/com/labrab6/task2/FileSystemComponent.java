package com.labrab6.task2;

public interface FileSystemComponent
{
    default void displayInfo()
    {
        displayInfo("");
    }

    void displayInfo(String indent);

}
