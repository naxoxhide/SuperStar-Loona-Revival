package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface HlsPlaylistTracker {

    public interface PlaylistEventListener {
        void onPlaylistChanged();

        boolean onPlaylistError(HlsMasterPlaylist.HlsUrl hlsUrl, boolean z);
    }

    public interface PrimaryPlaylistListener {
        void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist);
    }

    void addListener(PlaylistEventListener playlistEventListener);

    long getInitialStartTimeUs();

    HlsMasterPlaylist getMasterPlaylist();

    HlsMediaPlaylist getPlaylistSnapshot(HlsMasterPlaylist.HlsUrl hlsUrl);

    boolean isLive();

    boolean isSnapshotValid(HlsMasterPlaylist.HlsUrl hlsUrl);

    void maybeThrowPlaylistRefreshError(HlsMasterPlaylist.HlsUrl hlsUrl) throws IOException;

    void maybeThrowPrimaryPlaylistRefreshError() throws IOException;

    void refreshPlaylist(HlsMasterPlaylist.HlsUrl hlsUrl);

    void removeListener(PlaylistEventListener playlistEventListener);

    void start(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, PrimaryPlaylistListener primaryPlaylistListener);

    void stop();

    public static final class PlaylistStuckException extends IOException {
        public final String url;

        public PlaylistStuckException(String str) {
            this.url = str;
        }
    }

    public static final class PlaylistResetException extends IOException {
        public final String url;

        public PlaylistResetException(String str) {
            this.url = str;
        }
    }
}
