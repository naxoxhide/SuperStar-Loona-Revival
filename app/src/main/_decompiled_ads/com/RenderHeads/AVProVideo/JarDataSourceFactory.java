package com.RenderHeads.AVProVideo;

import com.google.android.exoplayer2.upstream.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class JarDataSourceFactory implements DataSource.Factory {
    private long m_FileOffset;
    private String m_Path;

    public JarDataSourceFactory(String str, long j) {
        this.m_Path = str;
        this.m_FileOffset = j;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public DataSource createDataSource() {
        return new JarDataSource(this.m_Path, this.m_FileOffset);
    }
}
