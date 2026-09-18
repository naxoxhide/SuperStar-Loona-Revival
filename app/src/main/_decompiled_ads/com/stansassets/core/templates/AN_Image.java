package com.stansassets.core.templates;

import android.net.Uri;
import com.stansassets.core.utility.AN_HashStorage;
import com.stansassets.core.utility.AN_ImageWrapper;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Image {
    private int m_hasCode;
    private String m_imageBase64;
    private String m_name;

    public AN_Image(String str) {
        AN_Image aN_Image = (AN_Image) AN_UnityBridge.fromJson(str, AN_Image.class);
        this.m_name = aN_Image.m_name;
        this.m_imageBase64 = aN_Image.m_imageBase64;
        this.m_hasCode = aN_Image.m_hasCode;
    }

    public Uri getUri() {
        int i = this.m_hasCode;
        if (i != 0 && AN_HashStorage.get(i) != null) {
            return (Uri) AN_HashStorage.get(this.m_hasCode);
        }
        Uri uriGetImageUri = AN_ImageWrapper.GetImageUri(this.m_imageBase64);
        AN_HashStorage.put(this.m_hasCode, uriGetImageUri);
        return uriGetImageUri;
    }
}
