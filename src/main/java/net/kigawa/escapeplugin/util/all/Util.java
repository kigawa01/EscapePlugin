package net.kigawa.escapeplugin.util.all;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static String createString(int[] ints) {
        StringBuilder str= new StringBuilder(Integer.toString(ints[0]));
        for (int i=1;i<ints.length;i++){
            str.append(", ").append(ints[i]);
        }
        return str.toString();
    }
    public static<T> List<T> changeListType(List list, Class<T> type){
        List<T> list1=new ArrayList<>();
        for (Object o:list){
            list1.add((T)o);
        }
        return list1;
    }
}
