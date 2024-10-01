package com.labrab5.task1;

/**
 * Вариант №2
 * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для
 * следующих классов:
 * interface Abiturient ← abstract class Student ← class Student Of Faculty.
 */
public class Main
{
    public static void main(String[] args)
    {
        StudentOfFaculty student1 = new StudentOfFaculty("Student", 18, "Faculty");

        Abiturient[] abiturients = {student1};
        Student[] students = {student1};

        for (Abiturient abiturient : abiturients)
        {
            abiturient.applyForAdmission();
        }

        for (Student student : students)
        {
            student.study();
            student.takeExams();
        }
    }
}
