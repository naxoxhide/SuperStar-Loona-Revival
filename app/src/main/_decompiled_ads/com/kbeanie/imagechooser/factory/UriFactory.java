package com.kbeanie.imagechooser.factory;

import android.util.Log;
import com.kbeanie.imagechooser.api.FileUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class UriFactory {
    static String TAG = "UriFactory";
    private static UriFactory instance;
    private String filePathOriginal;

    private UriFactory() {
    }

    public void setFilePathOriginal(String str) {
        Log.d(TAG, "File path set. Is: " + str);
        this.filePathOriginal = str;
    }

    public String getFilePathOriginal(String str, String str2) {
        if (this.filePathOriginal != null) {
            Log.d(TAG, "File path set. We return: " + this.filePathOriginal);
            return this.filePathOriginal;
        }
        return FileUtils.getDirectory(str) + File.separator + DateFactory.getInstance().getTimeInMillis() + "." + str2;
    }

    public void reset() {
        Log.d(TAG, "We reset capture URI");
        this.filePathOriginal = null;
    }

    public static UriFactory getInstance() {
        if (instance == null) {
            instance = new UriFactory();
        }
        return instance;
    }
}
