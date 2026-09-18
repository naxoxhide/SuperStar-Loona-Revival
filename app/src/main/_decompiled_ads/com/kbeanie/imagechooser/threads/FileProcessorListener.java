package com.kbeanie.imagechooser.threads;

import com.kbeanie.imagechooser.api.ChosenFile;

/* JADX INFO: loaded from: classes2.dex */
public interface FileProcessorListener {
    void onError(String str);

    void onProcessedFile(ChosenFile chosenFile);
}
