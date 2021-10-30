package com.turing.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrioritySort {

    public static void main(String[] args) {
        String[] strings = {"#70", "#72", "#72+1", "#70+1", "#70+3", "#70+1"};
        List<String> sort = sort(strings);
        for (String st : sort) {
            System.out.println("-------------->:" + st);
        }

    }

    public static List<String> sort(String[] params) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<String>();
        PriorityQueue<strData> pq = new PriorityQueue<>(new Comparator<strData>() {
            @Override
            public int compare(strData o1, strData o2) {
                int num = o1.val1 - o2.val1;
                return num == 0 ? o1.val2 - o2.val2 : num;
            }
        });
        for (int i = 0; i < params.length; i++) {
            String[] split = params[i].split("#");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("")) {
                    continue;
                } else {
//                    list1.add(split[j]);
                    int len = split[j].split("\\+").length;
                    if (len == 1) {
                        pq.offer(new strData(Integer.parseInt(split[j].split("\\+")[0]), 0, params[i]));
                    } else {
                        pq.offer(new strData(Integer.parseInt(split[j].split("\\+")[0]),
                                Integer.parseInt(split[j].split("\\+")[1]),
                                params[i]));
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            String st = pq.poll().str;
            System.out.println("+++++++++++++++++>:" + st);
            list.add(st);
        }
        return list;
    }

    public static class strData {
        private int val1, val2;
        private String str;

        public strData(int val1, int val2, String str) {
            //加号前的数据
            this.val1 = val1;
            //加号后的数据
            this.val2 = val2;
            //原数据
            this.str = str;
        }
    }

}
