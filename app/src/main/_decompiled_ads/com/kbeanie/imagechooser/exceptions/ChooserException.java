package com.kbeanie.imagechooser.exceptions;

import android.content.ActivityNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ChooserException extends Exception {
    public ChooserException(String str) {
        super(str);
    }

    public ChooserException(ActivityNotFoundException activityNotFoundException) {
        super(activityNotFoundException);
    }

    public ChooserException(FileNotFoundException fileNotFoundException) {
        super(fileNotFoundException);
    }

    public ChooserException(IOException iOException) {
        super(iOException);
    }
}
