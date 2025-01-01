package com.aurora.emby.common.utils;


import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {


    public static boolean isNull(String string) {

        return null == string || string.isEmpty()||string.trim().equals("");
    }


    public static boolean isNotNull(String string) {

        return !isNull(string);
    }

    public static boolean isNUllList(List objectList) {
        return null == objectList || objectList.isEmpty();
    }


    public static boolean isNotNullList(List objectList) {

        return !isNUllList(objectList);
    }


    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    public static boolean isValidFile(String filename, String filetype) {
        if (!filetype.contains("image")) {
            return false;
        } else {
            String extensionName = "(.jpg||.jpeg|.png)$";
            int index = filename.lastIndexOf(46);
            String suffix = filename.substring(index, filename.length());
            Pattern r = Pattern.compile(extensionName, 2);
            Matcher m = r.matcher(suffix);
            return m.matches();
        }
    }

}
