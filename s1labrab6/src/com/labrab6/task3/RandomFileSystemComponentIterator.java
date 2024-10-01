package com.labrab6.task3;

import com.labrab6.task2.Directory;
import com.labrab6.task2.FileSystemComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SuppressWarnings("FieldMayBeFinal")
public class RandomFileSystemComponentIterator
{
    private List<FileSystemComponent> components;
    private int currentIndex;

    public RandomFileSystemComponentIterator(FileSystemComponent root)
    {
        components = new ArrayList<>();
        collectComponents(root);
        shuffleComponents();
        currentIndex = 0;
    }

    private void collectComponents(FileSystemComponent component)
    {
        components.add(component);
        if (component instanceof Directory directory)
        {
            for (FileSystemComponent subComponent : directory.getComponents())
            {
                collectComponents(subComponent);
            }
        }
    }

    private void shuffleComponents()
    {
        long seed = System.nanoTime();
        Collections.shuffle(components, new Random(seed));
    }

    public boolean hasNext()
    {
        return currentIndex < components.size();
    }

    public FileSystemComponent next()
    {
        if ( hasNext() )
        {
            FileSystemComponent component = components.get(currentIndex);
            currentIndex++;
            return component;
        }
        throw new IllegalStateException("No more elements");
    }
}
