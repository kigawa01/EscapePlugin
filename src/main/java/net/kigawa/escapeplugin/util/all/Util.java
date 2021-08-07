package net.kigawa.escapeplugin.util.all;

public class Util {
    public static String createString(int[] ints) {
        StringBuilder str= new StringBuilder(Integer.toString(ints[0]));
        for (int i=1;i<ints.length;i++){
            str.append(", ").append(ints[i]);
        }
        return str.toString();
    }
    public static boolean checkLength(String[] string,int length){
        return string.length==length;
    }
}
