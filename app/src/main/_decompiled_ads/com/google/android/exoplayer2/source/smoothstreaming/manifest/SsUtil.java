package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class SsUtil {
    public static Uri fixManifestUri(Uri uri) {
        return Util.toLowerInvariant(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?") ? uri : Uri.withAppendedPath(uri, "Manifest");
    }

    private SsUtil() {
    }
}
