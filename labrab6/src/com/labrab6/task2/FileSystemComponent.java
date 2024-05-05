package com.labrab6.task2;

import com.labrab6.task3.Visitor;

public interface FileSystemComponent
{
    default void displayInfo()
    {
        displayInfo("");
    }

    void displayInfo(String indent);

    void accept(Visitor visitor);
}
