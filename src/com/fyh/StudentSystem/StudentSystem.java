package com.fyh.StudentSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentSystem {
    public static void startStudentSystem() {
        ArrayList<Student> list = new ArrayList<>();
       Scanner sc = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("----------欢迎来到学生管理系统----------");
            System.out.println("1添加学生");
            System.out.println("2删除学生");
            System.out.println("3查找学生");
            System.out.println("4修改学生");
            System.out.println("5退出");
            System.out.println("请输入您的操作：");
            String choice = sc.next();

            switch (choice) {
                case "1":
                    addStudent(list);
                    break;
                case "2":
                    deleteStudent(list);
                    break;
                case "3":
                    findStudent(list);
                    break;
                case "4":
                    updateStudent(list);
                    break;
                case "5":
                    System.out.println("退出");
                    break loop;
                default:
                    System.out.println("没有这个选项");
                    break;
            }
        }
    }

    public static void addStudent(ArrayList<Student> list) {
        System.out.println("添加学生");
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生的id");
            int id = sc.nextInt();
            boolean flag = containsStudent(list, id);
            if (flag) {
                System.out.println("当前id已存在，请重新输入");
            } else {
                student.setId(id);

                break;
            }
        }


        System.out.println("请输入学生的姓名");
        String name = sc.next();
        student.setName(name);
        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        student.setAge(age);
        list.add(student);
        System.out.println("添加成功");
    }


    public static void deleteStudent(ArrayList<Student> list) {
        System.out.println("输入要删除的学生的id");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int index = getIndex(list, id);
        if (index >= 0) {
            list.remove(index);
        } else {
            System.out.println("学生不存在");
        }

    }

    public static void updateStudent(ArrayList<Student> list) {
        System.out.println("请输入要修改的学生id");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int index = getIndex(list, id);
        if (index >= 0) {
            System.out.println("请输入要修改的学生的姓名");
            String name = sc.next();
            Student student = list.get(index);
            student.setName(name);
            System.out.println("请输入要修改的学生的id");
            int id1 = sc.nextInt();
            student.setId(id1);
            System.out.println("请输入要修改的学生的年龄");
            int age = sc.nextInt();
            student.setAge(age);
            System.out.println("修改成功");

        } else {
            System.out.println("要修改的学生不存在");
        }
    }

    public static void findStudent(ArrayList<Student> list) {

        System.out.println("id\t\t姓名\t年龄");

        if (list.size() == 0) {
            System.out.println("当前无学生信息");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Student s1 = list.get(i);
            System.out.println(s1.getId() + "\t\t" + s1.getName() + "\t\t\t" + s1.getAge());
        }
    }

    public static boolean containsStudent(ArrayList<Student> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            Student s1 = list.get(i);
            if (s1.getId() == id) {
                return true;
            }

        }
        return false;
    }

    public static int getIndex(ArrayList<Student> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            Student s1 = list.get(i);
            if (s1.getId() == id) {
                return i;
            }
        }
        return -1;
    }




}





