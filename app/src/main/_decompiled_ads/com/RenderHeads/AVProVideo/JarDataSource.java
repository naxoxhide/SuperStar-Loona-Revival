package com.RenderHeads.AVProVideo;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class JarDataSource implements DataSource {
    private static final String[] extensions = {"obb!/", "apk!/"};
    private long m_FileOffset;
    private String m_Path;
    private Uri m_Uri;
    private InputStream m_File = null;
    private ZipFile m_ZipFile = null;

    public void addTransferListener(TransferListener transferListener) {
    }

    public JarDataSource(String str, long j) {
        this.m_Path = str;
        this.m_FileOffset = j;
        this.m_Uri = Uri.parse(str);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        InputStream inputStream = this.m_File;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        ZipFile zipFile = this.m_ZipFile;
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e2) {
                System.err.println(e2.getMessage());
            }
        }
        this.m_ZipFile = null;
        this.m_File = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.m_Uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws AssetDataSource.AssetDataSourceException {
        if (this.m_Uri == null) {
            return 0L;
        }
        int i = 0;
        while (true) {
            String[] strArr = extensions;
            if (i >= strArr.length) {
                return 0L;
            }
            String str = strArr[i];
            int iLastIndexOf = this.m_Path.lastIndexOf(str);
            if (iLastIndexOf >= 0) {
                String strSubstring = this.m_Path.substring(11, (str.length() + iLastIndexOf) - 2);
                String strSubstring2 = this.m_Path.substring(iLastIndexOf + str.length());
                try {
                    ZipFile zipFile = new ZipFile(strSubstring);
                    this.m_ZipFile = zipFile;
                    ZipEntry entry = zipFile.getEntry(strSubstring2);
                    if (entry == null) {
                        throw new AssetDataSource.AssetDataSourceException(new IOException("Unable to locate file " + strSubstring2 + " in zip " + strSubstring));
                    }
                    this.m_File = this.m_ZipFile.getInputStream(entry);
                    long size = entry.getSize() - this.m_FileOffset;
                    long j = dataSpec.position + this.m_FileOffset;
                    if (this.m_File.skip(j) < j) {
                        throw new AssetDataSource.AssetDataSourceException(new IOException("End of file reached"));
                    }
                    if (this.m_File != null) {
                        return dataSpec.length == -1 ? size : dataSpec.length;
                    }
                } catch (IOException e) {
                    throw new AssetDataSource.AssetDataSourceException(e);
                }
            }
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStream = this.m_File;
        if (inputStream == null) {
            return 0;
        }
        return this.m_File.read(bArr, i, Math.min(i2, inputStream.available()));
    }
}
