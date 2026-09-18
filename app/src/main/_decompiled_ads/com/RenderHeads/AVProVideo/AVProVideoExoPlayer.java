package com.RenderHeads.AVProVideo;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoListener;
import com.twobigears.audio360.AudioEngine;
import com.twobigears.audio360.ChannelMap;
import com.twobigears.audio360.EngineInitSettings;
import com.twobigears.audio360.SpatDecoderQueue;
import com.twobigears.audio360.TBQuat;
import com.twobigears.audio360.TBVector;
import com.twobigears.audio360exo2.Audio360Sink;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AVProVideoExoPlayer extends AVProVideoPlayer implements Player.EventListener, MediaSourceEventListener, VideoListener {
    private static ChannelMap[] m_ChannelMap;
    private AdaptiveTrackSelection.Factory m_AdaptiveTrackSelectionFactory;
    private AudioEngine m_AudioEngine;
    private DefaultBandwidthMeter m_BandwidthMeter;
    private EventLogger m_EventLogger;
    private SimpleExoPlayer m_ExoPlayer;
    private int m_ForcedFileFormat;
    private long m_LastAbsoluteTime;
    private Handler m_MainHandler;
    private DataSource.Factory m_MediaDataSourceFactory;
    private MediaSource m_MediaSource;
    private long m_PendingFileOffset;
    private String m_PendingFilePath;
    private AudioSink m_Sink;
    private SpatDecoderQueue m_Spat;
    private Surface m_Surface;
    private Surface m_Surface_ToBeReleased;
    private DefaultTrackSelector m_TrackSelector;
    private String m_UserAgent;
    private boolean m_bDebugLogStateChange;
    private AtomicBoolean m_bSurfaceTextureBound;
    private AtomicBoolean m_bUpdateSurface;
    float[] m_textureTransform;

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj, int i) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    private void initChannelMap() {
        ChannelMap[] channelMapArr = new ChannelMap[27];
        m_ChannelMap = channelMapArr;
        channelMapArr[0] = ChannelMap.TBE_8_2;
        m_ChannelMap[1] = ChannelMap.TBE_8;
        m_ChannelMap[2] = ChannelMap.TBE_6_2;
        m_ChannelMap[3] = ChannelMap.TBE_6;
        m_ChannelMap[4] = ChannelMap.TBE_4_2;
        m_ChannelMap[5] = ChannelMap.TBE_4;
        m_ChannelMap[6] = ChannelMap.TBE_8_PAIR0;
        m_ChannelMap[7] = ChannelMap.TBE_8_PAIR1;
        m_ChannelMap[8] = ChannelMap.TBE_8_PAIR2;
        m_ChannelMap[9] = ChannelMap.TBE_8_PAIR3;
        m_ChannelMap[10] = ChannelMap.TBE_CHANNEL0;
        m_ChannelMap[11] = ChannelMap.TBE_CHANNEL1;
        m_ChannelMap[12] = ChannelMap.TBE_CHANNEL2;
        m_ChannelMap[13] = ChannelMap.TBE_CHANNEL3;
        m_ChannelMap[14] = ChannelMap.TBE_CHANNEL4;
        m_ChannelMap[15] = ChannelMap.TBE_CHANNEL5;
        m_ChannelMap[16] = ChannelMap.TBE_CHANNEL6;
        m_ChannelMap[17] = ChannelMap.TBE_CHANNEL7;
        m_ChannelMap[18] = ChannelMap.HEADLOCKED_STEREO;
        m_ChannelMap[19] = ChannelMap.HEADLOCKED_CHANNEL0;
        m_ChannelMap[20] = ChannelMap.HEADLOCKED_CHANNEL1;
        m_ChannelMap[21] = ChannelMap.AMBIX_4;
        m_ChannelMap[22] = ChannelMap.AMBIX_9;
        m_ChannelMap[23] = ChannelMap.AMBIX_9_2;
        m_ChannelMap[24] = ChannelMap.AMBIX_16;
        m_ChannelMap[25] = ChannelMap.AMBIX_16_2;
        m_ChannelMap[26] = ChannelMap.STEREO;
    }

    public AVProVideoExoPlayer(int i, boolean z, Random random) {
        super(i, z, random);
        this.m_bDebugLogStateChange = false;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.m_bUpdateSurface = atomicBoolean;
        atomicBoolean.set(false);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        this.m_bSurfaceTextureBound = atomicBoolean2;
        atomicBoolean2.set(false);
        if (m_ChannelMap == null) {
            initChannelMap();
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public float GetBufferingProgressPercent() {
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer == null) {
            return 0.0f;
        }
        this.m_fBufferingProgressPercent = simpleExoPlayer.getBufferedPercentage();
        return this.m_fBufferingProgressPercent;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetHeadRotation(float f, float f2, float f3, float f4) {
        AudioEngine audioEngine = this.m_AudioEngine;
        if (audioEngine != null) {
            audioEngine.setListenerRotation(new TBQuat(f, f2, f3, f4));
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public long GetEstimatedBandwidthUsed() {
        DefaultBandwidthMeter defaultBandwidthMeter = this.m_BandwidthMeter;
        if (defaultBandwidthMeter == null) {
            return 0L;
        }
        return defaultBandwidthMeter.getBitrateEstimate();
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetFocusRotation(float f, float f2, float f3, float f4) {
        SpatDecoderQueue spatDecoderQueue = this.m_Spat;
        if (spatDecoderQueue != null) {
            spatDecoderQueue.setFocusOrientationQuat(new TBQuat(f, f2, f3, f4));
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetFocusProps(float f, float f2) {
        SpatDecoderQueue spatDecoderQueue = this.m_Spat;
        if (spatDecoderQueue != null) {
            spatDecoderQueue.setFocusProperties(f, f2);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetPositionTrackingEnabled(boolean z) {
        AudioEngine audioEngine = this.m_AudioEngine;
        if (audioEngine != null) {
            audioEngine.enablePositionalTracking(z, new TBVector(0.0f, 0.0f, 0.0f));
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetFocusEnabled(boolean z) {
        SpatDecoderQueue spatDecoderQueue = this.m_Spat;
        if (spatDecoderQueue != null) {
            spatDecoderQueue.enableFocus(z, true);
        }
    }

    private ChannelMap getChannelMap(int i) {
        if (m_ChannelMap == null) {
            initChannelMap();
        }
        if (i >= 0) {
            ChannelMap[] channelMapArr = m_ChannelMap;
            if (i < channelMapArr.length) {
                return channelMapArr[i];
            }
        }
        return ChannelMap.TBE_8_2;
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        if (this.m_Width == i && this.m_Height == i2) {
            return;
        }
        System.out.println("AVProVideo changing video size " + this.m_Width + "x" + this.m_Height + " to " + i + "x" + i2);
        if (i3 == 90) {
            this.m_textureTransform = new float[]{0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f};
            if (this.m_bDebugLogStateChange) {
                Log.e("AVProVideo", "Texture transform set for 90 degrees");
            }
        } else if (i3 == 180) {
            this.m_textureTransform = new float[]{-1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f};
            if (this.m_bDebugLogStateChange) {
                Log.e("AVProVideo", "Texture transform set for 180 degrees");
            }
        } else if (i3 != 270) {
            if (this.m_bDebugLogStateChange) {
                Log.e("AVProVideo", "NO texture transform set");
            }
        } else {
            this.m_textureTransform = new float[]{0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
            if (this.m_bDebugLogStateChange) {
                Log.e("AVProVideo", "Texture transform set for 270 degrees");
            }
        }
        synchronized (this) {
            this.m_Width = i;
            this.m_Height = i2;
            this.m_bSourceHasVideo = true;
            this.m_bVideo_CreateRenderSurface.set(true);
            this.m_bVideo_DestroyRenderSurface.set(true);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public double GetCurrentAbsoluteTimestamp() {
        long currentPosition;
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer == null || simpleExoPlayer.getPlaybackState() == 1) {
            return 0.0d;
        }
        if (this.m_ExoPlayer.getPlaybackState() == 2) {
            currentPosition = this.m_LastAbsoluteTime;
        } else {
            Timeline currentTimeline = this.m_ExoPlayer.getCurrentTimeline();
            if (currentTimeline == null) {
                System.out.println("[AVProVideoTimestampTest] timeline is null");
                return 0.0d;
            }
            int currentWindowIndex = this.m_ExoPlayer.getCurrentWindowIndex();
            if (currentTimeline.getWindowCount() <= currentWindowIndex) {
                return 0.0d;
            }
            Timeline.Window window = new Timeline.Window();
            currentPosition = window.windowStartTimeMs == -9223372036854775807L ? 0L : currentTimeline.getWindow(currentWindowIndex, window).windowStartTimeMs + this.m_ExoPlayer.getCurrentPosition();
            this.m_LastAbsoluteTime = currentPosition;
        }
        return currentPosition / 1000.0d;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public float[] GetSeekableTimeRange() {
        return CalculateSeekableTimeRangeForPeriod();
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected boolean InitialisePlayer(boolean z, int i, boolean z2) {
        String str;
        if (this.m_Context == null) {
            return false;
        }
        try {
            str = this.m_Context.getPackageManager().getPackageInfo(this.m_Context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "?";
        }
        this.m_UserAgent = "AVProMobileVideo/" + str + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.8.4";
        Activity activity = (Activity) this.m_Context;
        this.m_BandwidthMeter = new DefaultBandwidthMeter();
        this.m_MainHandler = new Handler(activity.getMainLooper());
        this.m_MediaDataSourceFactory = BuildDataSourceFactory(true, null);
        this.m_AdaptiveTrackSelectionFactory = new AdaptiveTrackSelection.Factory(this.m_BandwidthMeter);
        this.m_TrackSelector = new DefaultTrackSelector(this.m_AdaptiveTrackSelectionFactory);
        this.m_EventLogger = new EventLogger(this.m_TrackSelector);
        RenderersFactory customDefaultRenderersFactory = new CustomDefaultRenderersFactory(this.m_Context, null, 1, z2);
        if (z) {
            EngineInitSettings engineInitSettings = new EngineInitSettings();
            engineInitSettings.getAudioSettings().setBufferSize(1024);
            engineInitSettings.getAudioSettings().setSampleRate(48000.0f);
            engineInitSettings.getMemorySettings().setSpatQueueSizePerChannel(8192);
            AudioEngine audioEngineCreate = AudioEngine.create(engineInitSettings, this.m_Context);
            this.m_AudioEngine = audioEngineCreate;
            this.m_Spat = audioEngineCreate.createSpatDecoderQueue();
            this.m_Sink = new Audio360Sink(this.m_Spat, getChannelMap(i), this.m_AudioEngine.getOutputLatencyMs());
            customDefaultRenderersFactory = new OpusRenderersFactory(this.m_Sink, customDefaultRenderersFactory);
        }
        SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(customDefaultRenderersFactory, this.m_TrackSelector);
        this.m_ExoPlayer = simpleExoPlayerNewSimpleInstance;
        simpleExoPlayerNewSimpleInstance.addListener(this);
        this.m_ExoPlayer.addVideoListener(this);
        return true;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void CloseVideoOnPlayer() {
        this.m_LastAbsoluteTime = 0L;
        _stop();
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.clearVideoSurface();
        }
        Surface surface = this.m_Surface;
        if (surface != null) {
            surface.release();
            this.m_Surface = null;
        }
        this.m_bUpdateSurface.set(false);
        this.m_bSurfaceTextureBound.set(false);
        this.m_MediaSource = null;
        this.m_VideoState = 0;
        this.m_PendingFilePath = null;
        this.m_PendingFileOffset = 0L;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void DeinitializeVideoPlayer() {
        this.m_TrackSelector = null;
        this.m_MediaSource = null;
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.clearVideoSurface();
        }
        Surface surface = this.m_Surface;
        if (surface != null) {
            surface.release();
            this.m_Surface = null;
        }
        this.m_bUpdateSurface.set(false);
        this.m_bSurfaceTextureBound.set(false);
        SimpleExoPlayer simpleExoPlayer2 = this.m_ExoPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.stop();
            this.m_ExoPlayer.release();
            this.m_ExoPlayer = null;
        }
        AudioEngine audioEngine = this.m_AudioEngine;
        if (audioEngine != null) {
            if (this.m_Sink != null) {
                this.m_Sink = null;
            }
            audioEngine.destroySpatDecoderQueue(this.m_Spat);
            this.m_AudioEngine.delete();
            this.m_Spat = null;
            this.m_AudioEngine = null;
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean IsPlaying() {
        if (this.m_ExoPlayer == null) {
            return false;
        }
        if (this.m_VideoState == 5) {
            return true;
        }
        if (IsSeeking() && this.m_ExoPlayer.getPlayWhenReady()) {
            return true;
        }
        return this.m_VideoState == 4 && this.m_ExoPlayer.getPlayWhenReady();
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean IsPaused() {
        return this.m_VideoState == 7;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean IsSeeking() {
        return this.m_bIsSeeking;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean IsFinished() {
        return this.m_VideoState == 8;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public boolean CanPlay() {
        return this.m_VideoState == 6 || this.m_VideoState == 7 || this.m_VideoState == 5 || this.m_VideoState == 8;
    }

    private HttpDataSource.Factory BuildHttpDataSourceFactory(boolean z, String str) {
        DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory(this.m_UserAgent, z ? this.m_BandwidthMeter : null, 8000, 8000, true);
        if (str != null && !str.isEmpty()) {
            defaultHttpDataSourceFactory.getDefaultRequestProperties().set(GetJsonAsMap(str));
        }
        return defaultHttpDataSourceFactory;
    }

    private DataSource.Factory BuildDataSourceFactory(boolean z, String str) {
        return new DefaultDataSourceFactory(this.m_Context, z ? this.m_BandwidthMeter : null, BuildHttpDataSourceFactory(z, str));
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void PlayerRendererSetup() {
        String str = this.m_PendingFilePath;
        if (str == null || str.length() <= 0) {
            return;
        }
        OpenVideoFromFileInternal(this.m_PendingFilePath, this.m_PendingFileOffset, "", this.m_ForcedFileFormat);
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void PlayerRenderUpdate() {
        SimpleExoPlayer simpleExoPlayer;
        UpdateVideoMetadata();
        if (this.m_Surface_ToBeReleased != null) {
            this.m_bSurfaceTextureBound.set(false);
            SimpleExoPlayer simpleExoPlayer2 = this.m_ExoPlayer;
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.clearVideoSurface();
            }
            this.m_Surface_ToBeReleased.release();
            this.m_Surface_ToBeReleased = null;
        }
        if (this.m_bUpdateSurface.get()) {
            SimpleExoPlayer simpleExoPlayer3 = this.m_ExoPlayer;
            if (simpleExoPlayer3 != null) {
                simpleExoPlayer3.clearVideoSurface();
            }
            Surface surface = this.m_Surface;
            if (surface != null) {
                surface.release();
                this.m_Surface = null;
            }
            if (this.m_SurfaceTexture != null) {
                if (this.m_Surface == null) {
                    this.m_Surface = new Surface(this.m_SurfaceTexture);
                }
                Surface surface2 = this.m_Surface;
                if (surface2 != null && (simpleExoPlayer = this.m_ExoPlayer) != null) {
                    simpleExoPlayer.setVideoSurface(surface2);
                    this.m_bSurfaceTextureBound.set(true);
                    this.m_bUpdateSurface.set(false);
                }
            }
        }
        String str = this.m_PendingFilePath;
        if (str != null && str.length() > 0) {
            OpenVideoFromFileInternal(this.m_PendingFilePath, this.m_PendingFileOffset, "", this.m_ForcedFileFormat);
        }
        SimpleExoPlayer simpleExoPlayer4 = this.m_ExoPlayer;
        if (simpleExoPlayer4 != null) {
            this.m_fPlaybackRate = simpleExoPlayer4.getPlaybackParameters().speed;
        }
    }

    private float[] CalculateSeekableTimeRangeForPeriod() {
        int currentPeriodIndex;
        int i;
        long j;
        float[] fArr = {0.0f, 0.0f};
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer == null) {
            return fArr;
        }
        Timeline currentTimeline = simpleExoPlayer.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return fArr;
        }
        Timeline.Window window = currentTimeline.getWindow(this.m_ExoPlayer.getCurrentWindowIndex(), new Timeline.Window());
        if (!window.isSeekable || (currentPeriodIndex = this.m_ExoPlayer.getCurrentPeriodIndex()) < (i = window.firstPeriodIndex)) {
            return fArr;
        }
        long j2 = 0;
        for (int i2 = i; i2 < currentPeriodIndex; i2++) {
            Timeline.Period period = currentTimeline.getPeriod(i2, new Timeline.Period());
            j2 += period.durationUs == -9223372036854775807L ? 0L : period.durationUs;
        }
        Timeline.Period period2 = currentTimeline.getPeriod(currentPeriodIndex, new Timeline.Period());
        boolean z = currentPeriodIndex == i;
        long jMin = window.durationUs == -9223372036854775807L ? 0L : window.durationUs - (j2 - (z ? 0L : window.positionInFirstPeriodUs));
        if (period2.durationUs != -9223372036854775807L) {
            j = period2.durationUs;
            if (z) {
                j -= window.positionInFirstPeriodUs;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (period2.durationUs != -9223372036854775807L) {
            jMin = Math.min(jMin, j);
        }
        long j3 = (!z || window.positionInFirstPeriodUs == -9223372036854775807L) ? 0L : window.positionInFirstPeriodUs;
        if (window.windowStartTimeMs != -9223372036854775807L) {
            j3 -= window.windowStartTimeMs * 1000;
        }
        fArr[0] = j3 / 1000.0f;
        fArr[1] = (jMin + j3) / 1000.0f;
        return fArr;
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

    private MediaSource BuildMediaSource(String str, long j, String str2) {
        String strSubstring;
        AssetFileDescriptor assetFileDescriptorOpenFd;
        int iInferContentType;
        Uri uri = Uri.parse(str);
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("jar:") || lowerCase.contains(".zip!") || lowerCase.contains(".obb!")) {
            ExtractorMediaSource extractorMediaSourceCreateMediaSource = null;
            try {
                int iLastIndexOf = str.lastIndexOf("/assets/");
                if (iLastIndexOf != -1 && (assetFileDescriptorOpenFd = this.m_Context.getAssets().openFd((strSubstring = str.substring(iLastIndexOf + 8)))) != null) {
                    assetFileDescriptorOpenFd.close();
                    Uri uri2 = Uri.parse("assets:///" + strSubstring);
                    new StringBuilder("uri = ").append(uri2).append(" | fileOffset = ").append(j);
                    DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
                    defaultExtractorsFactory.setMp4ExtractorFlags(1);
                    extractorMediaSourceCreateMediaSource = new ExtractorMediaSource.Factory(new AVPro_AssetSourceFactory(j, this.m_Context)).setExtractorsFactory(defaultExtractorsFactory).createMediaSource(uri2);
                }
            } catch (Exception unused) {
            }
            if (extractorMediaSourceCreateMediaSource != null) {
                return extractorMediaSourceCreateMediaSource;
            }
            DefaultExtractorsFactory defaultExtractorsFactory2 = new DefaultExtractorsFactory();
            defaultExtractorsFactory2.setMp4ExtractorFlags(1);
            return new ExtractorMediaSource.Factory(new JarDataSourceFactory(str, j)).setExtractorsFactory(defaultExtractorsFactory2).createMediaSource(uri);
        }
        int i = this.m_ForcedFileFormat;
        if (i == 0) {
            iInferContentType = Util.inferContentType(uri);
        } else if (i == 1) {
            iInferContentType = 2;
        } else if (i != 2) {
            iInferContentType = i != 3 ? 3 : 1;
        } else {
            iInferContentType = 0;
        }
        if (iInferContentType == 0) {
            return new DashMediaSource.Factory(new DefaultDashChunkSource.Factory(this.m_MediaDataSourceFactory), BuildHttpDataSourceFactory(true, str2)).createMediaSource(uri);
        }
        if (iInferContentType == 1) {
            return new SsMediaSource.Factory(new DefaultSsChunkSource.Factory(this.m_MediaDataSourceFactory), BuildHttpDataSourceFactory(true, str2)).createMediaSource(uri);
        }
        if (iInferContentType == 2) {
            return new HlsMediaSource.Factory(BuildHttpDataSourceFactory(true, str2)).createMediaSource(uri);
        }
        if (iInferContentType == 3) {
            String scheme = uri.getScheme();
            if (j > 0 && (TextUtils.isEmpty(scheme) || ShareInternalUtility.STAGING_PARAM.equals(scheme))) {
                if (str.startsWith("file:/")) {
                    uri = Uri.parse(str.substring(6));
                }
                DefaultExtractorsFactory defaultExtractorsFactory3 = new DefaultExtractorsFactory();
                defaultExtractorsFactory3.setMp4ExtractorFlags(1);
                return new ExtractorMediaSource.Factory(new AVPro_FileDataSourceFactory(j)).setExtractorsFactory(defaultExtractorsFactory3).createMediaSource(uri);
            }
            if (str.startsWith("file:/")) {
                uri = Uri.parse(str.substring(6));
            }
            DataSource.Factory factoryBuildDataSourceFactory = BuildDataSourceFactory(false, str2);
            DefaultExtractorsFactory defaultExtractorsFactory4 = new DefaultExtractorsFactory();
            defaultExtractorsFactory4.setMp4ExtractorFlags(1);
            return new ExtractorMediaSource.Factory(factoryBuildDataSourceFactory).setExtractorsFactory(defaultExtractorsFactory4).createMediaSource(uri);
        }
        throw new IllegalStateException("Unsupported type: " + iInferContentType);
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected boolean OpenVideoFromFileInternal(String str, long j, String str2, int i) {
        if (this.m_bDebugLogStateChange) {
            StringBuilder sb = new StringBuilder("OpenVideoFromFileInternal | m_ExoPlayer.getPlaybackState() = ");
            SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
            Log.e("AVProVideo", sb.append(simpleExoPlayer != null ? Integer.valueOf(simpleExoPlayer.getPlaybackState()) : null).append(" | m_VideoState = ").append(this.m_VideoState).append(" | m_SurfaceTexture = ").append(this.m_SurfaceTexture).toString());
        }
        this.m_ForcedFileFormat = i;
        if (!this.m_bSurfaceTextureBound.get()) {
            BindSurfaceToPlayer();
        }
        boolean z = true;
        if (this.m_ExoPlayer != null && this.m_VideoState != 2 && this.m_ExoPlayer.getPlaybackState() == 1 && this.m_bSurfaceTextureBound.get()) {
            this.m_ExoPlayer.setPlayWhenReady(false);
            MediaSource mediaSourceBuildMediaSource = BuildMediaSource(str, j, str2);
            this.m_MediaSource = mediaSourceBuildMediaSource;
            if (mediaSourceBuildMediaSource != null) {
                this.m_LastAbsoluteTime = 0L;
                this.m_VideoState = 2;
                this.m_ExoPlayer.prepare(this.m_MediaSource, true, true);
            } else {
                System.out.println("[AVProVideo] error failed to prepare");
                z = false;
            }
            this.m_PendingFilePath = null;
            this.m_PendingFileOffset = 0L;
        } else {
            this.m_PendingFilePath = str;
            this.m_PendingFileOffset = j;
        }
        return z;
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetLooping(boolean z) {
        this.m_bLooping = z;
        if (this.m_ExoPlayer != null && this.m_VideoState >= 3) {
            UpdateLooping();
        } else {
            AddVideoCommandInt(VideoCommand_SetLooping, 0);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public long GetCurrentTimeMs() {
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        return simpleExoPlayer.getCurrentPosition();
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetPlaybackRate(float f) {
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer != null) {
            this.m_ExoPlayer.setPlaybackParameters(new PlaybackParameters(f, simpleExoPlayer.getPlaybackParameters().pitch));
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    public void SetAudioTrack(int i) {
        TrackGroupArray trackGroups;
        if (this.m_ExoPlayer == null || i >= this.m_iNumberAudioTracks || i == this.m_iCurrentAudioTrackIndex) {
            return;
        }
        for (int i2 = 0; i2 < this.m_ExoPlayer.getRendererCount(); i2++) {
            if (this.m_ExoPlayer.getRendererType(i2) == 1) {
                DefaultTrackSelector.ParametersBuilder parametersBuilder = new DefaultTrackSelector.ParametersBuilder();
                parametersBuilder.clearSelectionOverrides(i2);
                parametersBuilder.setRendererDisabled(i2, true);
                this.m_TrackSelector.setParameters(parametersBuilder);
            }
        }
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.m_TrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < currentMappedTrackInfo.getRendererCount(); i4++) {
            if (this.m_ExoPlayer.getRendererType(i4) == 1 && (trackGroups = currentMappedTrackInfo.getTrackGroups(i4)) != null) {
                int i5 = i - i3;
                if (i5 >= trackGroups.length) {
                    i3 += trackGroups.length;
                } else {
                    TrackGroup trackGroup = trackGroups.get(i5);
                    ArrayList arrayList = new ArrayList();
                    for (int i6 = 0; i6 < trackGroup.length; i6++) {
                        if (currentMappedTrackInfo.getTrackSupport(i4, i5, i6) == 4) {
                            arrayList.add(Integer.valueOf(i6));
                        }
                    }
                    if (arrayList.size() != 0) {
                        int[] iArr = new int[arrayList.size()];
                        for (int i7 = 0; i7 < arrayList.size(); i7++) {
                            iArr[i7] = ((Integer) arrayList.get(i7)).intValue();
                        }
                        DefaultTrackSelector.SelectionOverride selectionOverride = new DefaultTrackSelector.SelectionOverride(i5, iArr);
                        DefaultTrackSelector.ParametersBuilder parametersBuilder2 = new DefaultTrackSelector.ParametersBuilder();
                        parametersBuilder2.setSelectionOverride(i4, trackGroups, selectionOverride);
                        parametersBuilder2.setRendererDisabled(i4, false);
                        this.m_TrackSelector.setParameters(parametersBuilder2);
                        this.m_iCurrentAudioTrackIndex = i5;
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _play() {
        if (this.m_bDebugLogStateChange) {
            Log.e("AVProVideo", "_play called");
        }
        if (this.m_ExoPlayer != null) {
            if (this.m_VideoState == 0) {
                this.m_VideoState = 2;
                this.m_ExoPlayer.prepare(this.m_MediaSource, false, false);
            } else {
                this.m_VideoState = 5;
            }
            this.m_ExoPlayer.setPlayWhenReady(true);
            AudioEngine audioEngine = this.m_AudioEngine;
            if (audioEngine != null) {
                audioEngine.start();
            }
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _pause() {
        if (this.m_bDebugLogStateChange) {
            Log.e("AVProVideo", "_pause called : m_VideoState = " + this.m_VideoState);
        }
        if (this.m_ExoPlayer == null || this.m_VideoState == 6 || this.m_VideoState == 8) {
            return;
        }
        this.m_ExoPlayer.setPlayWhenReady(false);
        this.m_VideoState = 7;
        AudioEngine audioEngine = this.m_AudioEngine;
        if (audioEngine != null) {
            audioEngine.suspend();
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _stop() {
        if (this.m_ExoPlayer != null) {
            SpatDecoderQueue spatDecoderQueue = this.m_Spat;
            if (spatDecoderQueue != null) {
                spatDecoderQueue.flushQueue();
                this.m_Spat.setEndOfStream(true);
            }
            if (this.m_AudioEngine != null) {
                AudioSink audioSink = this.m_Sink;
                if (audioSink != null) {
                    audioSink.reset();
                }
                this.m_AudioEngine.suspend();
            }
            if (this.m_VideoState != 6) {
                this.m_ExoPlayer.stop();
            }
            this.m_VideoState = 6;
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _seek(int i) {
        AudioSink audioSink = this.m_Sink;
        if (audioSink != null) {
            audioSink.reset();
        }
        SpatDecoderQueue spatDecoderQueue = this.m_Spat;
        if (spatDecoderQueue != null) {
            spatDecoderQueue.flushQueue();
        }
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setSeekParameters(SeekParameters.EXACT);
            this.m_ExoPlayer.seekTo(i);
            this.m_bIsSeeking = true;
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void _seekFast(int i) {
        AudioSink audioSink = this.m_Sink;
        if (audioSink != null) {
            audioSink.reset();
        }
        SpatDecoderQueue spatDecoderQueue = this.m_Spat;
        if (spatDecoderQueue != null) {
            spatDecoderQueue.flushQueue();
        }
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setSeekParameters(SeekParameters.CLOSEST_SYNC);
            this.m_ExoPlayer.seekTo(i);
            this.m_bIsSeeking = true;
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void UpdateAudioVolumes() {
        if (this.m_ExoPlayer != null) {
            this.m_ExoPlayer.setVolume(this.m_AudioMuted ? 0.0f : this.m_AudioVolume);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void UpdateLooping() {
        SimpleExoPlayer simpleExoPlayer = this.m_ExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setRepeatMode(this.m_bLooping ? 2 : 0);
        }
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void BindSurfaceToPlayer() {
        Surface surface = this.m_Surface;
        if (surface != null) {
            this.m_Surface_ToBeReleased = surface;
            this.m_Surface = null;
        }
        this.m_bUpdateSurface.set(true);
        this.m_bSurfaceTextureBound.set(false);
        if (this.m_bDebugLogStateChange) {
            Log.e("AVProVideo", "BindSurfaceToPlayer called");
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        if (i == 1) {
            if (this.m_bDebugLogStateChange) {
                System.out.println("AVProVideo video state: idle");
            }
            this.m_bIsBuffering = false;
            this.m_VideoState = 0;
            return;
        }
        if (i == 2) {
            if (this.m_bDebugLogStateChange) {
                System.out.println("AVProVideo video state: buffering");
            }
            if (this.m_VideoState != 2) {
                this.m_VideoState = 4;
            }
            this.m_bIsBuffering = true;
            return;
        }
        if (i == 3) {
            if (this.m_bDebugLogStateChange) {
                System.out.println("AVProVideo video state: ready | m_VideoState: " + this.m_VideoState + " | m_bIsBuffering: " + this.m_bIsBuffering);
            }
            this.m_bIsBuffering = false;
            String str = this.m_PendingFilePath;
            if (str != null && str.length() > 0) {
                if (this.m_bDebugLogStateChange) {
                    System.out.println("AVProVideo video state: has pending file path");
                    return;
                }
                return;
            }
            if (this.m_VideoState >= 2) {
                this.m_VideoState = this.m_VideoState != 2 ? this.m_VideoState : 3;
                Format videoFormat = this.m_ExoPlayer.getVideoFormat();
                Format audioFormat = this.m_ExoPlayer.getAudioFormat();
                if (videoFormat == null) {
                    if (audioFormat != null) {
                        float f = audioFormat.frameRate;
                        this.m_fSourceVideoFrameRate = f;
                        this.m_DisplayRate_FrameRate = f;
                        this.m_bSourceHasVideo = false;
                        this.m_bSourceHasAudio = true;
                        this.m_Width = 0;
                        this.m_Height = 0;
                        this.m_DurationMs = this.m_ExoPlayer.getDuration();
                        this.m_VideoState = this.m_ExoPlayer.getPlayWhenReady() ? 5 : 6;
                        this.m_bVideo_AcceptCommands.set(true);
                        return;
                    }
                    return;
                }
                this.m_fSourceVideoFrameRate = videoFormat.frameRate;
                if (this.m_fSourceVideoFrameRate > 0.0f) {
                    this.m_DisplayRate_FrameRate = this.m_fSourceVideoFrameRate;
                }
                this.m_DurationMs = this.m_ExoPlayer.getDuration();
                this.m_bSourceHasVideo = true;
                this.m_bSourceHasAudio = audioFormat != null;
                new StringBuilder("videoFormat.rotationDegrees = ").append(videoFormat.rotationDegrees);
                if (videoFormat.rotationDegrees == 90 || videoFormat.rotationDegrees == 270) {
                    int i2 = videoFormat.height;
                    int i3 = videoFormat.width;
                    if (this.m_Width > 0 && this.m_Height > 0 && ((i2 != this.m_Width || i3 != this.m_Height) && this.m_bVideo_RenderSurfaceCreated.get())) {
                        synchronized (this) {
                            this.m_Width = i2;
                            this.m_Height = i3;
                            this.m_bVideo_DestroyRenderSurface.set(true);
                            this.m_bVideo_CreateRenderSurface.set(true);
                        }
                    }
                }
                this.m_VideoState = this.m_ExoPlayer.getPlayWhenReady() ? 5 : 6;
                this.m_bVideo_AcceptCommands.set(true);
                return;
            }
            return;
        }
        if (i == 4) {
            if (this.m_bDebugLogStateChange) {
                System.out.println("AVProVideo video state: ended");
            }
            this.m_VideoState = 8;
        } else if (this.m_bDebugLogStateChange) {
            System.out.println("AVProVideo video state: " + i);
        }
        this.m_bIsBuffering = false;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
        this.m_bIsSeeking = false;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        System.out.println("AVProVideo error " + exoPlaybackException.getMessage());
        if (this.m_VideoState <= 0 || this.m_VideoState >= 5) {
            return;
        }
        this.m_iLastError = 100;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        DefaultTrackSelector defaultTrackSelector;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        this.m_iNumberAudioTracks = 0;
        if (this.m_ExoPlayer == null || (defaultTrackSelector = this.m_TrackSelector) == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return;
        }
        new StringBuilder("Number of tracks in source: ").append(currentMappedTrackInfo.getRendererCount());
        for (int i = 0; i < currentMappedTrackInfo.getRendererCount(); i++) {
            if (this.m_ExoPlayer.getRendererType(i) == 1) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
                this.m_iNumberAudioTracks += trackGroups != null ? trackGroups.length : 0;
            }
        }
        new StringBuilder("Number of audio tracks in source: ").append(this.m_iNumberAudioTracks);
        if (this.m_iCurrentAudioTrackIndex < 0) {
            this.m_iCurrentAudioTrackIndex = 0;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        new StringBuilder("onLoadError (param version) : error = ").append(iOException);
    }

    @Override // com.RenderHeads.AVProVideo.AVProVideoPlayer
    protected void UpdateVideoMetadata() {
        SimpleExoPlayer simpleExoPlayer;
        Format videoFormat;
        if (this.m_fSourceVideoFrameRate >= 0.0f || (simpleExoPlayer = this.m_ExoPlayer) == null || (videoFormat = simpleExoPlayer.getVideoFormat()) == null) {
            return;
        }
        this.m_fSourceVideoFrameRate = videoFormat.frameRate;
    }
}
