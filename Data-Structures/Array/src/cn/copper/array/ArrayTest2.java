package cn.copper.array;

public class ArrayTest2 {

    public static void main(String[] args) {
        Array<Student> student = new Array<Student>();
        student.addLast(new Student("aaa",85));
        student.addLast(new Student("bbb",95));
        student.addLast(new Student("vvv",75));

        Student s = student.get(2);
        System.out.println(s);

        System.out.println(student);
    }
}
