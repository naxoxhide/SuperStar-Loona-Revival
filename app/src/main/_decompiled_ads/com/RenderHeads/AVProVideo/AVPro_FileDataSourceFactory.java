package com.RenderHeads.AVProVideo;

import com.google.android.exoplayer2.upstream.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class AVPro_FileDataSourceFactory implements DataSource.Factory {
    private long m_FileOffset;

    public AVPro_FileDataSourceFactory(long j) {
        this.m_FileOffset = j;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public DataSource createDataSource() {
        return new AVPro_FileDataSource(this.m_FileOffset);
    }
}
