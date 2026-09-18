package com.kbeanie.imagechooser.api;

/* JADX INFO: loaded from: classes2.dex */
public interface FileChooserListener {
    void onError(String str);

    void onFileChosen(ChosenFile chosenFile);
}
