package com.kbeanie.imagechooser.api;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChosenImages {
    private List<ChosenImage> images = new ArrayList();

    public void addImage(ChosenImage chosenImage) {
        this.images.add(chosenImage);
    }

    public int size() {
        return this.images.size();
    }

    public ChosenImage getImage(int i) {
        return this.images.get(i);
    }
}
