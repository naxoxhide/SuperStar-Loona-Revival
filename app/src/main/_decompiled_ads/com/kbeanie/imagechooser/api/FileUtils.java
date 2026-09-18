package com.kbeanie.imagechooser.api;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    public static String getDirectory(String str) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getFileExtension(String str) {
        try {
            return str.substring(str.lastIndexOf(".") + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
