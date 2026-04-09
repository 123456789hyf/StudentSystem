package com.fyh.StudentSystem;

import java.util.ArrayList;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        System.out.println(getCode());
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
}
