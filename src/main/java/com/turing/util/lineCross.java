package com.turing.util;

import java.util.ArrayList;
import java.util.List;

/**
 *切割字符串的工具
 */
public class lineCross {
    public static void main(String[] args) {
        String[] str = {
                "綦庆(惠)线", "张隆一线",
                "隆綦南（北）线", "江阳东、西线",
                "合海线、合坝线", "铜思一、二线",
                "习桐綦线（綦铁线）"
        };
        String[] str1 = {
                "#179-#182",
                "16-17",
                "#2-#3",
                "#52-#53",
                "#324-#325/#2-#3",
                "30-门架",
                "#2(渝綦#83)-#3(渝綦#82)",
                "#1082-#1084",
                "玉井#15T接-#1",
                "1-3",
                "#48-#50(#46-#48)",
                "116#-119#",
                "#45+1（陈#1）-#46（陈#2）",
                "#3(#46)-#6(#43)",
                "#9-#10(涪龙西10)",
                "东：#76-#77西#98-#99"
        };
//        Map<String, ArrayList<Object>> map = new HashMap<>();
//        for (int i = 0; i < str.length; i++) {
//            if (!map.containsKey("line")) {
//                ArrayList<Object> al = new ArrayList<>();
//                al.add(str[i]);
//                map.put("line", al);
//            } else {
//                map.get("line").add(str[i]);
//            }
//        }
//        List<Map<String, ArrayList<Object>>> list2 = new ArrayList<>();
//        list2.add(map);
//        System.out.println(list2);
//        List<String> listNum = new ArrayList<>();
        List<String> list = null;
        for (String s : str1) {
            list = cutNum(s);
            for (String c : list) {
                System.out.println("c:======>:" + c);
            }
        }

//        for (int i = 0; i < str1.length; i++) {
//            List<String> list = cutNum(str1[0]);
//            for (int j = 0; j < list.size(); j++) {
//                System.out.println("listNum" + i + ":" + list.get(i));
//            }
//        }
//
//        for (int i = 0; i < listNum.size(); i++) {
//            System.out.println("listNum" + i + ":" + listNum.get(i));
//        }
//        for (int i = 0; i < str1.length; i++) {
//            RsNum rsNum = cutNum(str1[i]);
//            System.out.println("rsNum1" + i + ":" + rsNum.num1 + "rsNum2" + i + ":" + rsNum.num2);
//        }


//        //切割线路
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < str.length; i++) {
//            list.add(str[i]);
//        }
//        List<String> list1 = cutString(list);
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println("list1.size" + i + ":" + list1.get(i));
//        }

    }

    public static List<String> cutNum(String params) {
        List<String> list1 = new ArrayList<>();
        RsNum result = new RsNum();
//        for (int i = 0; i < params.length(); i++) {
        String str = params;
        String[] split = str.split("-");
        //存放切割"-"后的数据
        String rs = split[0];
        String rs1 = split[1];
        //区分"-"前后的数据
        String split1 = null;
        String split2 = null;
        //过滤字符串中非数字的部分
        StringBuilder re = new StringBuilder();
        StringBuilder re1 = new StringBuilder();
        //接受过滤后的数字
        String rsNum1 = null;
        String rsNum2 = null;
        //判断是否存在括号
        if (rs.contains("(") || rs.contains("（")) {
            split1 = rs.split("#")[split[0].split("#").length - 2];
        } else if ((rs.split("#").length - 1) > 1) {
            split1 = rs.split("#")[1];
        } else {
            split1 = rs.split("#")[split[0].split("#").length - 1];
        }
        for (int j = 0; j < split1.length(); j++) {
            char c = split1.charAt(j);
            if (c >= '0' && c <= '9' || c == '+') {
                re.append(c);
            }
        }
        //过滤后的数据存放在字符串中
        rsNum1 = re.toString();
//            result.num1 = rsNum1;
        list1.add(rsNum1);
        if (rs1.contains("(") || rs1.contains("（")) {
            split2 = rs1.split("#")[split[1].split("#").length - 2];
        } else if ((rs1.split("#").length - 1) > 1) {
            split2 = rs1.split("#")[1];
        } else {
            split2 = rs1.split("#")[split[1].split("#").length - 1];
        }
        for (int j = 0; j < split2.length(); j++) {
            char c = split2.charAt(j);
            if (c >= '0' && c <= '9' || c == '+') {
                re1.append(c);
            }
        }
        rsNum2 = re1.toString();
//            result.num2 = rsNum2;
        list1.add(rsNum2);
//        }
        return list1;
    }

    public static class RsNum {
        public String num1;
        public String num2;
    }

    public static List<String> cutString(List<String> params) {
        //接受处理后的数据
        List<String> list2 = new ArrayList<>();
        //处理切割后的字符串数组
        String[] split = null;
        String[] split1 = null;
        //拼接线路是否有
        for (int i = 0; i < params.size(); i++) {
            String s = params.get(i);
            if (s.contains("(")) {
                split = s.split("\\(");
            } else if (s.contains("（")) {
                split = s.split("（");
            } else {
                split = s.split("###");
            }
            if (split[0].contains("、")) {
                split1 = split[0].split("、");
                if (split1[0].contains("线")) {
                    list2.add(split1[0]);
                } else {
                    list2.add(split1[0] + "线");
                }
            } else {
                if (split[0].contains("线")) {
                    list2.add(split[0]);
                } else {
                    list2.add(split[0] + "线");
                }
            }

        }
        return list2;
    }
}
