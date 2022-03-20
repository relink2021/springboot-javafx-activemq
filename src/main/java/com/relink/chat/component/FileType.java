package com.relink.chat.component;

import java.io.File;

/**
 * 枚举类
 * 文件图标
 */
public enum FileType {

    TXT("txt", "src/main/resources/icons/txt.png"),
    ACCESS("access", "src/main/resources/icons/access.png"),
    BMP("bmp","src/main/resources/icons/bmp.png"),
    DOCX("docx","src/main/resources/icons/docx.png"),
    DW("dw", "src/main/resources/icons/dw.png"),
    EXCEL("excel", "src/main/resources/icons/excel.png"),
    GIF("gif", "src/main/resources/icons/gif.png"),
    JPEG("jpeg", "src/main/resources/icons/jpeg.png"),
    JPG("jpg", "src/main/resources/icons/jpg.png"),
    MOV("mov", "src/main/resources/icons/mov.png"),
    MP("mp","src/main/resources/icons/mp.png"),
    PAPERS("papers", "src/main/resources/icons/papers.png"),
    PDF("pdf", "src/main/resources/icons/pdf.png"),
    PNG("png", "src/main/resources/icons/png.png"),
    PPT("ppt", "src/main/resources/icons/ppt.png"),
    PPTX("pptx", "src/main/resources/icons/pptx.png"),
    PSD("psd", "src/main/resources/icons/psd.png"),
    RAR("rar", "src/main/resources/icons/rar.png"),
    MARKDOWN("md", "src/main/resources/icons/readme.png"),
    SWF("swf", "src/main/resources/icons/swf.png"),
    VIDEO("video", "src/main/resources/icons/vedio.png"),
    VISIO("visio", "src/main/resources/icons/visio.png"),
    WMV("wmv", "src/main/resources/icons/wmv.png"),
    WORD("word", "src/main/resources/icons/word.png"),
    XLSX("xlsx", "src/main/resources/icons/xlsx.png"),
    ZIP("zip", "src/main/resources/icons/zip.png"),
    EXE("exe", "src/main/resources/icons/exe.png");

    private String file_type;
    private String file_icon;

    FileType(String file_type, String file_icon) {
        this.file_type = file_type;
        this.file_icon = file_icon;
    }

    public static String getValue(String type) {
        FileType[] fileTypes = values();
        for (FileType fileType : fileTypes) {
            if (fileType.file_type.equals(type)) {
                return new File(fileType.file_icon).toURI().toString();
            }
        }
        return null;
    }
}
