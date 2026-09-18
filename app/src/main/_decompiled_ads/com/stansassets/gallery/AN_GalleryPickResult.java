package com.stansassets.gallery;

import com.stansassets.core.templates.SA_Result;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class AN_GalleryPickResult extends SA_Result {
    public ArrayList<AN_Meida> m_media;

    public AN_GalleryPickResult() {
        this.m_media = new ArrayList<>();
    }

    public AN_GalleryPickResult(int i, String str) {
        super(i, str);
        this.m_media = new ArrayList<>();
    }

    public void AddImage(AN_Meida aN_Meida) {
        this.m_media.add(aN_Meida);
    }
}
