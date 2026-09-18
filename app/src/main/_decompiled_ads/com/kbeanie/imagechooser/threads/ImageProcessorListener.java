package com.kbeanie.imagechooser.threads;

import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ChosenImages;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageProcessorListener {
    void onError(String str);

    void onProcessedImage(ChosenImage chosenImage);

    void onProcessedImages(ChosenImages chosenImages);
}
