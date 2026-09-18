package com.kbeanie.imagechooser.api;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChosenVideos {
    private List<ChosenVideo> videos = new ArrayList();

    public void addVideo(ChosenVideo chosenVideo) {
        this.videos.add(chosenVideo);
    }

    public int size() {
        return this.videos.size();
    }

    public ChosenVideo getImage(int i) {
        return this.videos.get(i);
    }
}
