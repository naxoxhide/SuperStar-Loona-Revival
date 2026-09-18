package com.kbeanie.imagechooser.api;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class BChooserPreferences {
    private static final String FILE = "b_chooser_prefs";
    private static final String FOLDER_NAME = "folder_name";
    private SharedPreferences preferences;

    public BChooserPreferences(Context context) {
        this.preferences = context.getSharedPreferences(FILE, 0);
    }

    public void setFolderName(String str) {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putString(FOLDER_NAME, str);
        editorEdit.commit();
    }

    public String getFolderName() {
        return this.preferences.getString(FOLDER_NAME, "bichooser");
    }
}
