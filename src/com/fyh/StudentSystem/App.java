package com.fyh.StudentSystem;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        loop1:
        while (true) {
            System.out.println("----------欢迎进入学生管理系统登陆页面----------");
            System.out.println("1.登录账号");
            System.out.println("2.注册账号");
            System.out.println("3.忘记密码");
            System.out.println("4.查看已注册用户信息（仅管理员可用）");
            System.out.println("5.退出");
            System.out.println("输入数字选择您要进行的操作");
            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1: {
                    DengLu(users);
                    break;
                }
                case 2:
                    ZhuCe(users);
                    break;
                case 3:
                    forgetPassword(users);
                    break;
                case 4:
                    findUsers(users);
                    break;


                case 5: {

                    System.out.println("4.退出，谢谢使用");
                    System.exit(0);
                }
                default:
                    System.out.println("无效操作");
                    break;
            }
        }
    }

    public static void ZhuCe(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        User u = new User();

        //注册用户名
        while (true) {
            System.out.println("请输入注册的用户名（3-15位之间，只能是数字加字母）：");
            String uname = sc.next();
            boolean flag1 = checkName(uname);
            if (!flag1) {
                System.out.println("用户名格式不合法，重新输入");
                continue;
            }


            boolean flag2 = containsUser(users, uname);
            if (flag2) {
                System.out.println("用户名可用");
                u.setUname(uname);
                break;

            } else {
                System.out.println("用户名已存在，请重新输入");
            }


        }


        //校验密码
        while (true) {
            System.out.println("请输入密码：");
            int password = sc.nextInt();
            System.out.println("请再次输入密码");
            int password1 = sc.nextInt();
            if (password == password1) {
                u.setPassword(password);
                break;
            } else {
                System.out.println("两次密码不一致，请重新输入密码");
            }

        }

        //校验身份证号
        while (true) {
            System.out.println("请输入身份证号：");
            String uid = sc.next();
            boolean flag1 = checkId(uid);
            if (flag1) {
                u.setUid(uid);
                break;
            }

        }
        //校验手机号
        while (true) {
            System.out.println("请输入手机号：");
            String phone = sc.next();
            boolean flag1 = checkPhone(phone);

            if (flag1) {
                u.setPhone(phone);
                break;
            }
        }
        users.add(u);
        System.out.println("注册成功");

    }

    public static void findUsers(ArrayList<User> users) {
        System.out.println("姓名" + "\t" + "身份证号" + "\t\t\t\t\t" + "手机号" + "\t\t\t" + "密码" + "\t\t\t");
        if (users.size() == 0) {
            System.out.println("无注册用户信息");
        }
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);

            System.out.println(user.getUname() + "\t" + user.getUid() + "\t" + user.getPhone() + "\t\t\t" + user.getPassword() + "\t");
        }
    }

    public static boolean containsUser(ArrayList<User> list, String username) {

        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if (u.getUname().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkName(String uname) {
        int len = uname.length();
        if (len < 3 || len > 15) {

            return false;
        }
        int count = 0;
        for (int i = 0; i < uname.length(); i++) {

            if ((uname.charAt(i) <= '9' && uname.charAt(i) >= '0') || uname.charAt(i) >= 'A' && uname.charAt(i) <= 'Z' || uname.charAt(i) >= 'a' && uname.charAt(i) <= 'z') {
                count++;
                break;
            }


        }
        return count > 0;

    }

    public static boolean checkId(String id) {
        if (id.length() != 18) {
            System.out.println("长度为18位，不能以0开头，请重新输入");
            return false;
        }
        if (id.startsWith("0")) {
            System.out.println("长度为18位，不能以0开头，请重新输入");
            return false;
        }
        for (int i = 0; i < id.length() - 1; i++) {
            char ch = id.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                System.out.println("前17位必须是数字，请重新输入");
                return false;
            }
        }
        char endChar = id.charAt(id.length() - 1);
        if ((endChar >= '0' && endChar <= '9') || (endChar == 'X') || (endChar == 'x')) {
            return true;
        }
        System.out.println("最后一位必须是数字或者X和x，请重新输入");
        return false;
    }

    public static boolean checkPhone(String phone) {
        if (phone.length() != 11) {
            System.out.println("手机号码必须为11位");
            return false;
        }
        if (phone.startsWith("0")) {
            System.out.println("首位不能为零");
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            char ch = phone.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                System.out.println("必须都是数字");
                return false;
            }

        }
        return true;
    }

    public static int getIndex(ArrayList<User> users, String uname) {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getUname().equals(uname)) {
                return i;
            }

        }
        return -1;
    }

    public static void forgetPassword(ArrayList<User> users) {


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String uname = sc.next();
        boolean flag = containsUser(users, uname);
        if (flag) {
            System.out.println("该用户不存在");

        } else {
            int index = getIndex(users, uname);
            User u = users.get(index);
            System.out.println("请输入身份证号码：");
            String uid = sc.next();
            System.out.println("请输入手机号码：");
            String phone = sc.next();
            if (Objects.equals(phone, u.getPhone()) && uid.equalsIgnoreCase(u.getUid())) {
                while (true) {
                    System.out.println("请输入修改后的密码：");
                    int password = sc.nextInt();

                    System.out.println("请再次输入修改后的密码：");
                    int password1 = sc.nextInt();
                    if (password == password1) {
                        System.out.println("修改成功");
                        u.setPassword(password);
                        break;
                    } else {
                        System.out.println("密码不一致，请重新输入");
                        continue;
                    }
                }

            } else {
                System.out.println("账号信息不匹配修改失败");

            }
        }


    }

    public static void DengLu(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        String uname;

        System.out.println("请输入用户名：");
        uname = sc.next();
        boolean flag1 = containsUser(users, uname);
        if (flag1) {

            System.out.println("该用户未注册");
            return;
        }


        System.out.println("请输入密码：");
        int password = sc.nextInt();


        while (true) {

            String rightCode = getCode();

            System.out.println("正确的验证码为：" + rightCode);

            System.out.println("请输入验证码：");

            String code = sc.next();


            if (code.equalsIgnoreCase(rightCode)) {
                System.out.println("验证码正确");
                break;
            } else {
                System.out.println("请重新输入");
            }
        }
        User uInFo = new User(uname, password, null, null);
        boolean result = checkUserInfo(users, uInFo);
        if (result) {
            System.out.println("用户名密码正确，登陆成功，欢迎使用学生管理系统：");
            StudentSystem studentSystem = new StudentSystem();
            studentSystem.startStudentSystem();
        } else {
            System.out.println("用户名或密码错误");

        }

    }

    public static String getCode() {
        ArrayList<Character> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 26; i++) {
            list.add((char) (i + 'a'));
            list.add((char) (i + 'A'));


        }
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(list.size());
            char code = list.get(index);
            sb.append(code);


        }
        int num = random.nextInt(10);
        sb.append(num);
        System.out.println(sb);
        int index1 = random.nextInt(4);

        char[] arr = sb.toString().toCharArray();
        char temp = ' ';
        temp = arr[arr.length - 1];
        arr[arr.length - 1] = arr[index1];
        arr[index1] = temp;
        return new String(arr);
    }

    public static boolean checkUserInfo(ArrayList<User> users, User uInFo) {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if ((u.getUid().equals(uInFo.getUid())) || (u.getPassword() == uInFo.getPassword())) {
                return true;
            }
        }
        return false;
    }

}
