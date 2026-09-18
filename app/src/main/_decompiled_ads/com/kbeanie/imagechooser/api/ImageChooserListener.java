package com.kbeanie.imagechooser.api;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageChooserListener {
    void onError(String str);

    void onImageChosen(ChosenImage chosenImage);

    void onImagesChosen(ChosenImages chosenImages);
}
