package com.kbeanie.imagechooser.threads;

import com.kbeanie.imagechooser.api.ChosenVideo;
import com.kbeanie.imagechooser.api.ChosenVideos;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoProcessorListener {
    void onError(String str);

    void onProcessedVideo(ChosenVideo chosenVideo);

    void onProcessedVideos(ChosenVideos chosenVideos);
}
