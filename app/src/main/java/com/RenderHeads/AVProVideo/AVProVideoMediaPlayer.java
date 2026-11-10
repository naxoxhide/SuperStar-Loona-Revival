package com.RenderHeads.AVProVideo;

import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AVProVideoMediaPlayer extends AVProVideoPlayer implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    private MediaExtractor m_MediaExtractor;
    private MediaPlayer m_MediaPlayer;
    private MediaPlayer.TrackInfo[] m_aTrackInfo;
    protected String m_VideoPath;

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public double GetCurrentAbsoluteTimestamp() {
        return 0.0d;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetFocusEnabled(boolean z) {
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetFocusProps(float f, float f2) {
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetFocusRotation(float f, float f2, float f3, float f4) {
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetHeadRotation(float f, float f2, float f3, float f4) {
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetPositionTrackingEnabled(boolean z) {
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void UpdateVideoMetadata() {
    }

    public AVProVideoMediaPlayer(int i, boolean z, Random random) {
        super(i, z, random);
        this.m_aTrackInfo = null;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected boolean InitialisePlayer(boolean z, int i, boolean z2) {
        this.m_MediaPlayer = new MediaPlayer();
        this.m_aTrackInfo = null;
        return true;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void CloseVideoOnPlayer() {
        MediaExtractor mediaExtractor;
        if (this.m_VideoState >= 3) {
            _pause();
            _stop();
        }
        if (Build.VERSION.SDK_INT > 15 && (mediaExtractor = this.m_MediaExtractor) != null) {
            mediaExtractor.release();
            this.m_MediaExtractor = null;
        }
        this.m_aTrackInfo = null;
        MediaPlayer mediaPlayer = this.m_MediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.m_VideoState = 0;
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void DeinitializeVideoPlayer() {
        MediaPlayer mediaPlayer = this.m_MediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(null);
            this.m_MediaPlayer.stop();
            this.m_MediaPlayer.reset();
            this.m_MediaPlayer.release();
            this.m_MediaPlayer = null;
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean IsPlaying() {
        return this.m_VideoState == 5;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean IsPaused() {
        return this.m_VideoState == 7;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean IsSeeking() {
        return this.m_VideoState == 2 || this.m_VideoState == 4;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean IsFinished() {
        return this.m_VideoState == 8;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean CanPlay() {
        return this.m_VideoState == 6 || this.m_VideoState == 7 || this.m_VideoState == 5 || this.m_VideoState == 8;
    }

    private static Map<String, String> GetJsonAsMap(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't parse json:" + str, e);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected boolean OpenVideoFromFileInternal(String str, long j, String str2, int i) {
        String strSubstring = str;
        this.m_aTrackInfo = null;
        boolean z = false;
        if (this.m_MediaPlayer != null) {
            try {
                String lowerCase = str.toLowerCase();
                if (lowerCase.startsWith("http://") || lowerCase.startsWith("https://") || lowerCase.startsWith("rtmp://") || lowerCase.startsWith("rtsp://")) {
                    if (str2 != null && !str2.isEmpty()) {
                        this.m_MediaPlayer.setDataSource(this.m_Context, Uri.parse(str), GetJsonAsMap(str2));
                    } else {
                        this.m_MediaPlayer.setDataSource(strSubstring);
                    }
                    this.m_bIsStream = true;
                } else {
                    if (strSubstring.startsWith("file:/")) {
                        strSubstring = strSubstring.substring(6);
                    }
                    String str3 = strSubstring;
                    this.m_VideoPath = str3;
                    try {
                        AssetFileDescriptor assetFileDescriptorOpenFd = this.m_Context.getAssets().openFd(str3.substring(str3.lastIndexOf("/assets/") + 8));
                        if (assetFileDescriptorOpenFd != null) {
                            this.m_MediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset() + j, assetFileDescriptorOpenFd.getLength() - j);
                            if (Build.VERSION.SDK_INT > 15) {
                                MediaExtractor mediaExtractor = new MediaExtractor();
                                this.m_MediaExtractor = mediaExtractor;
                                try {
                                    mediaExtractor.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset() + j, assetFileDescriptorOpenFd.getLength() - j);
                                } catch (IOException unused2) {
                                    this.m_MediaExtractor.release();
                                    this.m_MediaExtractor = null;
                                }
                            }
                        }
                    } catch (Exception unusedAssets) {
                        try {
                            if (j == 0) {
                                this.m_MediaPlayer.setDataSource(str3);
                            } else {
                                FileInputStream fis = new FileInputStream(str3);
                                FileDescriptor fd = fis.getFD();
                                this.m_MediaPlayer.setDataSource(fd, j, fis.getChannel().size() - j);
                            }
                            if (Build.VERSION.SDK_INT > 15) {
                                MediaExtractor mediaExtractor2 = new MediaExtractor();
                                this.m_MediaExtractor = mediaExtractor2;
                                try {
                                    mediaExtractor2.setDataSource(str3);
                                } catch (IOException unusedMediaExt) {
                                    this.m_MediaExtractor.release();
                                    this.m_MediaExtractor = null;
                                }
                            }
                        } catch (Exception unusedFile) {
                            Uri uri = Uri.parse("file:/" + str3);
                            this.m_MediaPlayer.setDataSource(this.m_Context, uri);
                            if (Build.VERSION.SDK_INT > 15) {
                                MediaExtractor mediaExtractor4 = new MediaExtractor();
                                this.m_MediaExtractor = mediaExtractor4;
                                try {
                                    mediaExtractor4.setDataSource(this.m_Context, uri, (Map<String, String>) null);
                                } catch (IOException unusedUri) {
                                    this.m_MediaExtractor.release();
                                    this.m_MediaExtractor = null;
                                }
                            }
                        }
                    }
                }
                z = true;
            } catch (Exception e) {
                new StringBuilder("Failed to open video file: ").append(e);
            }
            if (z) {
                this.m_MediaPlayer.setOnPreparedListener(this);
                this.m_MediaPlayer.setOnVideoSizeChangedListener(this);
                this.m_MediaPlayer.setOnErrorListener(this);
                this.m_MediaPlayer.setOnCompletionListener(this);
                this.m_MediaPlayer.setOnBufferingUpdateListener(this);
                this.m_MediaPlayer.setOnInfoListener(this);
                this.m_MediaPlayer.setLooping(this.m_bLooping);
                this.m_VideoState = 2;
                this.m_bIsBuffering = true;
                this.m_MediaPlayer.prepareAsync();
            } else {
                this.m_iLastError = 100;
            }
        }
        return z;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetLooping(boolean z) {
        this.m_bLooping = z;
        if (this.m_MediaPlayer != null && this.m_VideoState >= 3) {
            UpdateLooping();
        } else {
            AddVideoCommandInt(VideoCommand_SetLooping, 0);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public long GetCurrentTimeMs() {
        if (this.m_MediaPlayer == null || this.m_VideoState < 3 || this.m_VideoState > 8) {
            return 0L;
        }
        long currentPosition = this.m_MediaPlayer.getCurrentPosition();
        return (currentPosition <= this.m_DurationMs || this.m_DurationMs <= 0) ? currentPosition : this.m_DurationMs;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetPlaybackRate(float f) {
        if (Build.VERSION.SDK_INT <= 22 || this.m_MediaPlayer == null || this.m_VideoState < 3) {
            return;
        }
        PlaybackParams playbackParams = new PlaybackParams();
        if (f < 0.01f) {
            f = 0.01f;
        }
        playbackParams.setSpeed(f);
        this.m_MediaPlayer.setPlaybackParams(playbackParams);
        this.m_fPlaybackRate = f;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetAudioTrack(int i) {
        if (Build.VERSION.SDK_INT <= 15 || this.m_MediaPlayer == null || i >= this.m_iNumberAudioTracks || i == this.m_iCurrentAudioTrackIndex) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (MediaPlayer.TrackInfo trackInfo : this.m_aTrackInfo) {
            if (trackInfo != null && trackInfo.getTrackType() == 2) {
                if (i2 == i) {
                    this.m_MediaPlayer.selectTrack(i3);
                    this.m_iCurrentAudioTrackIndex = i;
                    return;
                }
                i2++;
            }
            i3++;
        }
    }

    private void ResetPlaybackFrameRate() {
        this.m_DisplayRate_FrameRate = 0.0f;
        this.m_DisplayRate_NumberFrames = 0L;
        this.m_DisplayRate_LastSystemTimeMS = System.nanoTime();
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _play() {
        MediaPlayer mediaPlayer = this.m_MediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        ResetPlaybackFrameRate();
        this.m_VideoState = 5;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _pause() {
        if (this.m_VideoState <= 4 || this.m_VideoState == 6 || this.m_VideoState == 8) {
            return;
        }
        MediaPlayer mediaPlayer = this.m_MediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        ResetPlaybackFrameRate();
        this.m_VideoState = 7;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _stop() {
        if (this.m_VideoState <= 4 || this.m_VideoState >= 6) {
            return;
        }
        MediaPlayer mediaPlayer = this.m_MediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        ResetPlaybackFrameRate();
        this.m_VideoState = 6;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _seek(int i) {
        if (this.m_MediaPlayer != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.m_MediaPlayer.seekTo(i, 3);
            } else {
                this.m_MediaPlayer.seekTo(i);
            }
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _seekFast(int i) {
        if (this.m_MediaPlayer != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.m_MediaPlayer.seekTo(i, 0);
            } else {
                this.m_MediaPlayer.seekTo(i);
            }
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void UpdateAudioVolumes() {
        float f;
        float f2 = 0.0f;
        if (this.m_AudioMuted) {
            f = 0.0f;
        } else {
            float fMax = Math.max(Math.min(Math.abs(this.m_AudioPan - 1.0f), 1.0f), 0.0f);
            float fMax2 = Math.max(Math.min(this.m_AudioPan + 1.0f, 1.0f), 0.0f);
            float f3 = this.m_AudioVolume * fMax;
            float f4 = fMax2 * this.m_AudioVolume;
            if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            f = f4 <= 1.0f ? f4 : 1.0f;
            f2 = f3;
        }
        MediaPlayer mediaPlayer = this.m_MediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void UpdateLooping() {
        MediaPlayer mediaPlayer = this.m_MediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(this.m_bLooping);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void BindSurfaceToPlayer() {
        if (this.m_MediaPlayer != null) {
            Surface surface = new Surface(this.m_SurfaceTexture);
            this.m_MediaPlayer.setSurface(surface);
            surface.release();
        }
    }

    private void setMediaPlayerDataSourceFromZip(String str, String str2, long j) throws Throwable {
        throw new IOException("OBB expansion not supported");
    }

    public void onRenderersError(Exception exc) {
        new StringBuilder("ERROR - onRenderersError: ").append(exc);
    }

    private void UpdateGetDuration() {
        MediaPlayer mediaPlayer = this.m_MediaPlayer;
        if (mediaPlayer != null) {
            this.m_DurationMs = mediaPlayer.getDuration();
        }
        new StringBuilder("Video duration is: ").append(this.m_DurationMs).append("ms");
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public float[] GetSeekableTimeRange() {
        return new float[]{0.0f, 0.0f};
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaFormat format;
        this.m_VideoState = 3;
        this.m_bIsBuffering = false;
        UpdateGetDuration();
        if (this.m_bIsStream) {
            this.m_iNumberAudioTracks = 1;
            this.m_bSourceHasAudio = true;
        }
        if (this.m_MediaPlayer != null && Build.VERSION.SDK_INT > 15) {
            try {
                MediaPlayer.TrackInfo[] trackInfo = this.m_MediaPlayer.getTrackInfo();
                this.m_aTrackInfo = trackInfo;
                if (trackInfo != null) {
                    new StringBuilder("Source has ").append(this.m_aTrackInfo.length).append(" tracks");
                    if (this.m_aTrackInfo.length > 0) {
                        this.m_iNumberAudioTracks = 0;
                        int i = 0;
                        for (MediaPlayer.TrackInfo trackInfo2 : this.m_aTrackInfo) {
                            if (trackInfo2 != null) {
                                int trackType = trackInfo2.getTrackType();
                                if (trackType == 1) {
                                    this.m_bSourceHasVideo = true;
                                    if (this.m_fSourceVideoFrameRate == 0.0f && Build.VERSION.SDK_INT >= 19 && (format = trackInfo2.getFormat()) != null) {
                                        this.m_fSourceVideoFrameRate = format.getInteger("frame-rate");
                                    }
                                    if (Build.VERSION.SDK_INT > 15 && this.m_MediaExtractor != null) {
                                        if (this.m_fSourceVideoFrameRate == 0.0f) {
                                            this.m_fSourceVideoFrameRate = this.m_MediaExtractor.getTrackFormat(i).getInteger("frame-rate");
                                            new StringBuilder("Source video frame rate: ").append(this.m_fSourceVideoFrameRate);
                                        }
                                        this.m_MediaExtractor.release();
                                        this.m_MediaExtractor = null;
                                    }
                                } else if (trackType == 2) {
                                    this.m_iNumberAudioTracks++;
                                } else if (trackType == 3) {
                                    this.m_bSourceHasTimedText = true;
                                } else if (trackType == 4) {
                                    this.m_bSourceHasSubtitles = true;
                                }
                            }
                            i++;
                        }
                        if (this.m_iNumberAudioTracks > 0) {
                            SetAudioTrack(0);
                            this.m_bSourceHasAudio = true;
                        }
                        new StringBuilder("Number of audio tracks in source: ").append(this.m_iNumberAudioTracks);
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (this.m_bIsStream || this.m_iNumberAudioTracks > 0 || (this.m_bVideo_RenderSurfaceCreated.get() && !this.m_bVideo_DestroyRenderSurface.get() && !this.m_bVideo_CreateRenderSurface.get())) {
            this.m_bVideo_AcceptCommands.set(true);
            if (this.m_VideoState != 5 && this.m_VideoState != 4) {
                this.m_VideoState = 6;
            }
        }
        if ((!this.m_bIsStream || this.m_Width > 0) && this.m_bShowPosterFrame) {
            _seek(0);
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.m_Width == i && this.m_Height == i2) {
            return;
        }
        new StringBuilder("onVideoSizeChanged : New size: ").append(i).append(" x ").append(i2);
        this.m_Width = i;
        this.m_Height = i2;
        this.m_bSourceHasVideo = true;
        this.m_bVideo_CreateRenderSurface.set(true);
        this.m_bVideo_DestroyRenderSurface.set(true);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        new StringBuilder("onError what(").append(i).append("), extra(").append(i2).append(")");
        if (this.m_bLooping && this.m_VideoPath != null) {
            try {
                if (this.m_MediaPlayer != null) {
                    this.m_MediaPlayer.reset();
                    this.m_MediaPlayer.setDataSource(this.m_VideoPath);
                    this.m_MediaPlayer.setOnPreparedListener(this);
                    this.m_MediaPlayer.setOnVideoSizeChangedListener(this);
                    this.m_MediaPlayer.setOnErrorListener(this);
                    this.m_MediaPlayer.setOnCompletionListener(this);
                    this.m_MediaPlayer.setOnBufferingUpdateListener(this);
                    this.m_MediaPlayer.setOnInfoListener(this);
                    this.m_MediaPlayer.setLooping(true);
                    this.m_VideoState = 2;
                    this.m_bIsBuffering = true;
                    this.m_MediaPlayer.prepareAsync();
                    return true;
                }
            } catch (Exception e) {}
        }
        int i3 = this.m_VideoState;
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            this.m_iLastError = 100;
            return true;
        }
        if (i3 != 5) {
            return false;
        }
        this.m_iLastError = 200;
        return true;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.m_bLooping) {
            try {
                if (this.m_MediaPlayer != null) {
                    this.m_MediaPlayer.seekTo(0);
                    this.m_MediaPlayer.start();
                }
            } catch (Exception e) {}
            return;
        }
        if (this.m_VideoState < 3 || this.m_VideoState >= 8) {
            return;
        }
        this.m_VideoState = 8;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public float GetBufferingProgressPercent() {
        return this.m_fBufferingProgressPercent;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.m_fBufferingProgressPercent = i;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 701) {
            this.m_bIsBuffering = true;
        } else if (i == 702) {
            this.m_bIsBuffering = false;
        }
        return false;
    }
}
