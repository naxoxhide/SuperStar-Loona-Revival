package com.kbeanie.imagechooser.api;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoChooserListener {
    void onError(String str);

    void onVideoChosen(ChosenVideo chosenVideo);

    void onVideosChosen(ChosenVideos chosenVideos);
}
