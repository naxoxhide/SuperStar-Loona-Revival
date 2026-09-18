package com.kbeanie.imagechooser.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ChosenMedia {
    public abstract String getMediaHeight();

    public abstract String getMediaWidth();

    protected SoftReference<Bitmap> getBitmap(String str) {
        try {
            return new SoftReference<>(BitmapFactory.decodeStream(new FileInputStream(new File(str))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFileExtension(String str) {
        return FileUtils.getFileExtension(str);
    }

    protected String getWidth(String str) {
        try {
            String attribute = new ExifInterface(str).getAttribute("ImageWidth");
            return attribute.equals("0") ? Integer.toString(getBitmap(str).get().getWidth()) : attribute;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    protected String getHeight(String str) {
        try {
            String attribute = new ExifInterface(str).getAttribute("ImageLength");
            return attribute.equals("0") ? Integer.toString(getBitmap(str).get().getHeight()) : attribute;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
