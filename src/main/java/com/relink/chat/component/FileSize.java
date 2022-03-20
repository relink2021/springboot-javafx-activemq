package com.relink.chat.component;

/**
 * 枚举类
 * 文件大小
 */
public enum FileSize {
    B(0, "B"),KB(1,"KB"),MB(2,"MB"),GB(3,"GB");

    private int cnt;
    private String size;

    FileSize(int cnt, String size) {
        this.cnt = cnt;
        this.size = size;
    }

    public static String getValue(int cnt) {
        FileSize[] list = values();
        for (FileSize fileSize : list) {
            if (fileSize.cnt == cnt) {
                return fileSize.size;
            }
        }
        return null;
    }
}
