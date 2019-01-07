package io.github.tenghuanhe.calcite.tutorial;

/**
 * Created by tenghuanhe on 17-4-11.
 */
public class Department {
  public static class Student {
    public final int id;
    public final String name;
    public final int supervisorNo;

    public Student(int id, String name, int supervisorNo) {
      this.id = id;
      this.name = name;
      this.supervisorNo = supervisorNo;
    }
  }

  public static class Professor {
    public final int id;
    public final String name;

    public Professor(int id, String name) {
      this.id = id;
      this.name = name;
    }
  }

  public final Student[] students = {
      new Student(1, "alice", 1),
      new Student(2, "bob", 2),
      new Student(3, "tom", 1)
  };

  public final Professor[] professors = {
      new Professor(1, "turing"),
      new Professor(2, "andrew")
  };
}