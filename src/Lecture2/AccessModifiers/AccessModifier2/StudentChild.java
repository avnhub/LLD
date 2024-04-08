package Lecture2.AccessModifiers.AccessModifier2;

import Lecture2.AccessModifiers.AccessModifier1.StudentAM;

public class StudentChild extends StudentAM {
    void age(){
        age=1;// if I am protected it could be used by child class inside package outside package but if not it cannot access outside package.
    }
}
