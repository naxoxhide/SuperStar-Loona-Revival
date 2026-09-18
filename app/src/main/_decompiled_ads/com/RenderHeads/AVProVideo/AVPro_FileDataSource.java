package com.RenderHeads.AVProVideo;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public final class AVPro_FileDataSource implements DataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private final TransferListener<? super AVPro_FileDataSource> listener;
    private long m_FileOffset;
    private boolean opened;
    private Uri uri;

    public AVPro_FileDataSource() {
        this((TransferListener<? super AVPro_FileDataSource>) null);
    }

    public AVPro_FileDataSource(long j) {
        this((TransferListener<? super AVPro_FileDataSource>) null);
        this.m_FileOffset = j;
    }

    public AVPro_FileDataSource(TransferListener<? super AVPro_FileDataSource> transferListener) {
        this.listener = transferListener;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final long open(DataSpec dataSpec) throws FileDataSource.FileDataSourceException {
        try {
            this.uri = dataSpec.uri;
            this.file = new RandomAccessFile(dataSpec.uri.getPath(), CampaignEx.JSON_KEY_AD_R);
            this.file.seek(dataSpec.position + this.m_FileOffset);
            long length = dataSpec.length == -1 ? (this.file.length() - dataSpec.position) - this.m_FileOffset : dataSpec.length;
            this.bytesRemaining = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.opened = true;
            TransferListener<? super AVPro_FileDataSource> transferListener = this.listener;
            if (transferListener != null) {
                transferListener.onTransferStart(this, dataSpec);
            }
            return this.bytesRemaining;
        } catch (IOException e) {
            throw new FileDataSource.FileDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final int read(byte[] bArr, int i, int i2) throws FileDataSource.FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.file.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                this.bytesRemaining -= (long) i3;
                TransferListener<? super AVPro_FileDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onBytesTransferred(this, i3);
                }
            }
            return i3;
        } catch (IOException e) {
            throw new FileDataSource.FileDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void close() throws FileDataSource.FileDataSourceException {
        this.uri = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.file;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.file = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super AVPro_FileDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferEnd(this);
                    }
                }
            } catch (IOException e) {
                throw new FileDataSource.FileDataSourceException(e);
            }
        } catch (Throwable th) {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                TransferListener<? super AVPro_FileDataSource> transferListener2 = this.listener;
                if (transferListener2 != null) {
                    transferListener2.onTransferEnd(this);
                }
            }
            throw th;
        }
    }
}
