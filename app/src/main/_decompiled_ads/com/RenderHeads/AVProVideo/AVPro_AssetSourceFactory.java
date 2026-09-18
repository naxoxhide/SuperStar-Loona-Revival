package com.RenderHeads.AVProVideo;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class AVPro_AssetSourceFactory implements DataSource.Factory {
    private Context m_Context;
    private long m_FileOffset;
    private String m_FilePath;

    public AVPro_AssetSourceFactory(long j, Context context) {
        this.m_FileOffset = j;
        this.m_Context = context;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public DataSource createDataSource() {
        return new AVPro_AssetDataSource(this.m_FileOffset, this.m_Context);
    }
}
