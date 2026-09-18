package com.RenderHeads.AVProVideo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class AVProVideoPlayer implements SurfaceTexture.OnFrameAvailableListener {
    protected static final int ErrorCode_DecodeFailed = 200;
    protected static final int ErrorCode_LoadFailed = 100;
    protected static final int ErrorCode_None = 0;
    protected static final int Format_Dash = 2;
    protected static final int Format_HLS = 1;
    protected static final int Format_SS = 3;
    protected static final int Format_Unknown = 0;
    protected static int VideoCommand_AudioVolumes = 4;
    protected static int VideoCommand_Pause = 1;
    protected static int VideoCommand_Play = 0;
    protected static int VideoCommand_Seek = 3;
    protected static int VideoCommand_SeekFast = 6;
    protected static int VideoCommand_SetLooping = 5;
    protected static int VideoCommand_Stop = 2;
    protected static final int VideoState_Buffering = 4;
    protected static final int VideoState_Finished = 8;
    protected static final int VideoState_Idle = 0;
    protected static final int VideoState_Opening = 1;
    protected static final int VideoState_Paused = 7;
    protected static final int VideoState_Playing = 5;
    protected static final int VideoState_Prepared = 3;
    protected static final int VideoState_Preparing = 2;
    protected static final int VideoState_Stopped = 6;
    protected static boolean s_bCompressedWatermarkDataGood = false;
    protected final ReentrantLock _mutex = new ReentrantLock();
    protected boolean m_AudioMuted;
    protected float m_AudioPan;
    protected float m_AudioVolume;
    protected Queue<VideoCommand> m_CommandQueue;
    protected Context m_Context;
    protected float m_DisplayRate_FrameRate;
    protected long m_DisplayRate_LastSystemTimeMS;
    protected long m_DisplayRate_NumberFrames;
    protected long m_DurationMs;
    protected int m_ExtractWaitTimeout;
    protected AtomicBoolean m_Extracting;
    protected long m_FrameArrivalThreadID;
    protected int m_FrameCount;
    protected AVProMobileVideo_GlRender m_GlRender_Video;
    protected AVProMobileVideo_GlRender m_GlRender_Watermark;
    protected int m_Height;
    protected Random m_Random;
    protected SurfaceTexture m_SurfaceTexture;
    protected long m_TextureTimeStamp;
    protected int m_VideoState;
    protected Point m_WatermarkPosition;
    protected Runnable m_WatermarkPositionRunnable;
    protected float m_WatermarkScale;
    protected Handler m_WatermarkSizeHandler;
    protected int m_Width;
    protected boolean m_bCanUseGLBindVertexArray;
    protected boolean m_bDeinitialiseFlagged;
    protected boolean m_bDeinitialised;
    protected boolean m_bIsBuffering;
    protected boolean m_bIsSeeking;
    protected boolean m_bIsStream;
    protected boolean m_bLooping;
    protected boolean m_bShowPosterFrame;
    protected boolean m_bSourceHasAudio;
    protected boolean m_bSourceHasSubtitles;
    protected boolean m_bSourceHasTimedText;
    protected boolean m_bSourceHasVideo;
    protected boolean m_bUseFastOesPath;
    protected AtomicBoolean m_bVideo_AcceptCommands;
    protected AtomicBoolean m_bVideo_CreateRenderSurface;
    protected AtomicBoolean m_bVideo_DestroyRenderSurface;
    protected AtomicBoolean m_bVideo_RenderSurfaceCreated;
    protected boolean m_bWatermarkDataGood;
    protected boolean m_bWatermarked;
    protected float m_fBufferingProgressPercent;
    protected float m_fPlaybackRate;
    protected float m_fSourceVideoFrameRate;
    protected int m_iCurrentAudioTrackIndex;
    protected int m_iLastError;
    protected int m_iNumberAudioTracks;
    protected AtomicInteger m_iNumberFramesAvailable;
    protected int m_iOpenGLVersion;
    protected int m_iPlayerIndex;

    protected abstract void BindSurfaceToPlayer();

    public abstract boolean CanPlay();

    protected abstract void CloseVideoOnPlayer();

    protected abstract void DeinitializeVideoPlayer();

    public abstract float GetBufferingProgressPercent();

    public abstract double GetCurrentAbsoluteTimestamp();

    public abstract long GetCurrentTimeMs();

    public long GetEstimatedBandwidthUsed() {
        return 0L;
    }

    public abstract float[] GetSeekableTimeRange();

    protected abstract boolean InitialisePlayer(boolean z, int i, boolean z2);

    public abstract boolean IsFinished();

    public abstract boolean IsPaused();

    public abstract boolean IsPlaying();

    public abstract boolean IsSeeking();

    protected abstract boolean OpenVideoFromFileInternal(String str, long j, String str2, int i);

    protected void PlayerRenderUpdate() {
    }

    protected void PlayerRendererSetup() {
    }

    public abstract void SetAudioTrack(int i);

    public abstract void SetFocusEnabled(boolean z);

    public abstract void SetFocusProps(float f, float f2);

    public abstract void SetFocusRotation(float f, float f2, float f3, float f4);

    public abstract void SetHeadRotation(float f, float f2, float f3, float f4);

    public abstract void SetLooping(boolean z);

    public abstract void SetPlaybackRate(float f);

    public abstract void SetPositionTrackingEnabled(boolean z);

    protected abstract void UpdateAudioVolumes();

    protected abstract void UpdateLooping();

    protected abstract void UpdateVideoMetadata();

    protected abstract void _pause();

    protected abstract void _play();

    protected abstract void _seek(int i);

    protected abstract void _seekFast(int i);

    protected abstract void _stop();

    protected class VideoCommand {
        int _command = -1;
        int _intValue = 0;
        float _floatValue = 0.0f;

        protected VideoCommand() {
        }
    }

    public AVProVideoPlayer(int i, boolean z, Random random) {
        this.m_bWatermarked = z;
        if (z && !AVProMobileWMImage.s_bImagePrepared) {
            s_bCompressedWatermarkDataGood = AVProMobileWMImage.PrepareImage();
        }
        this.m_bWatermarkDataGood = false;
        this.m_iPlayerIndex = i;
        this.m_bUseFastOesPath = false;
        this.m_bShowPosterFrame = false;
        this.m_Width = 0;
        this.m_Height = 0;
        this.m_DurationMs = 0L;
        this.m_bLooping = false;
        this.m_fPlaybackRate = 1.0f;
        this.m_FrameCount = 0;
        this.m_bIsStream = false;
        this.m_bIsBuffering = false;
        this.m_bIsSeeking = false;
        this.m_AudioVolume = 1.0f;
        this.m_AudioPan = 0.0f;
        this.m_AudioMuted = false;
        this.m_fBufferingProgressPercent = 0.0f;
        AtomicInteger atomicInteger = new AtomicInteger();
        this.m_iNumberFramesAvailable = atomicInteger;
        atomicInteger.set(0);
        this.m_TextureTimeStamp = Long.MIN_VALUE;
        this.m_CommandQueue = new LinkedList();
        this.m_VideoState = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.m_bVideo_CreateRenderSurface = atomicBoolean;
        atomicBoolean.set(false);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        this.m_bVideo_DestroyRenderSurface = atomicBoolean2;
        atomicBoolean2.set(false);
        AtomicBoolean atomicBoolean3 = new AtomicBoolean();
        this.m_bVideo_RenderSurfaceCreated = atomicBoolean3;
        atomicBoolean3.set(false);
        AtomicBoolean atomicBoolean4 = new AtomicBoolean();
        this.m_bVideo_AcceptCommands = atomicBoolean4;
        atomicBoolean4.set(false);
        this.m_iCurrentAudioTrackIndex = -1;
        this.m_bSourceHasVideo = false;
        this.m_bSourceHasAudio = false;
        this.m_iNumberAudioTracks = 0;
        this.m_bSourceHasTimedText = false;
        this.m_bSourceHasSubtitles = false;
        this.m_fSourceVideoFrameRate = 0.0f;
        this.m_DisplayRate_FrameRate = 0.0f;
        this.m_DisplayRate_NumberFrames = 0L;
        this.m_DisplayRate_LastSystemTimeMS = System.nanoTime();
        this.m_bDeinitialiseFlagged = false;
        this.m_bDeinitialised = false;
        this.m_iLastError = 0;
        this.m_Extracting = new AtomicBoolean(false);
        this.m_ExtractWaitTimeout = 50;
        this.m_FrameArrivalThreadID = -1L;
        this.m_Random = random != null ? new Random() : random;
    }

    public boolean Initialise(Context context, boolean z, boolean z2, int i, boolean z3) {
        if (this.m_bWatermarked) {
            if (!s_bCompressedWatermarkDataGood) {
                return false;
            }
            boolean zCheckWatermarkData = AVProMobileWMImage.CheckWatermarkData();
            this.m_bWatermarkDataGood = zCheckWatermarkData;
            if (!zCheckWatermarkData) {
                return false;
            }
        }
        this.m_Context = context;
        Activity activity = (Activity) context;
        this.m_WatermarkPosition = new Point();
        if (this.m_bWatermarked) {
            ChangeWatermarkPosition();
            activity.runOnUiThread(new Runnable() { // from class: com.RenderHeads.AVProVideo.AVProVideoPlayer.1
                @Override // java.lang.Runnable
                public final void run() {
                    AVProVideoPlayer.this.m_WatermarkSizeHandler = new Handler();
                    AVProVideoPlayer.this.m_WatermarkPositionRunnable = new Runnable() { // from class: com.RenderHeads.AVProVideo.AVProVideoPlayer.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AVProVideoPlayer.this.ChangeWatermarkPosition();
                            AVProVideoPlayer.this.m_WatermarkSizeHandler.postDelayed(this, AVProVideoPlayer.this.m_Random.nextInt(1000) + 1000);
                        }
                    };
                    AVProVideoPlayer.this.m_WatermarkSizeHandler.postDelayed(AVProVideoPlayer.this.m_WatermarkPositionRunnable, AVProVideoPlayer.this.m_Random.nextInt(2000));
                }
            });
        }
        SetPlayerOptions(z, this.m_bShowPosterFrame);
        return InitialisePlayer(z2, i, z3);
    }

    public boolean StartExtractFrame() {
        if (this.m_FrameArrivalThreadID == Thread.currentThread().getId()) {
            return false;
        }
        if (this.m_Extracting.get()) {
            return true;
        }
        this.m_Extracting.set(true);
        return true;
    }

    public void WaitForExtract() {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= this.m_ExtractWaitTimeout || !this.m_Extracting.get()) {
                break;
            }
            try {
                Thread.sleep(10L);
                i = i2;
            } catch (InterruptedException unused) {
            }
        }
        this.m_Extracting.set(false);
    }

    public void WaitForNewFrame() {
        int i = this.m_FrameCount;
        int i2 = this.m_iNumberFramesAvailable.get();
        int i3 = 0;
        while (i + i2 >= this.m_FrameCount) {
            int i4 = i3 + 1;
            if (i3 >= this.m_ExtractWaitTimeout) {
                break;
            }
            AVProMobileVideo.RenderPlayer(this.m_iPlayerIndex);
            try {
                Thread.sleep(10L);
                i3 = i4;
            } catch (InterruptedException unused) {
            }
        }
        this.m_Extracting.set(false);
    }

    public void SetDeinitialiseFlagged() {
        this.m_bDeinitialiseFlagged = true;
        this.m_bDeinitialised = false;
    }

    public boolean GetDeinitialised() {
        return this.m_bDeinitialised;
    }

    public void CloseVideo() {
        CloseVideoOnPlayer();
        this.m_VideoState = 0;
        this.m_CommandQueue = new LinkedList();
        this.m_bVideo_AcceptCommands.set(false);
        this.m_Width = 0;
        this.m_Height = 0;
        this.m_DurationMs = 0L;
        this.m_fPlaybackRate = 1.0f;
        this.m_iCurrentAudioTrackIndex = -1;
        this.m_bSourceHasVideo = false;
        this.m_bSourceHasAudio = false;
        this.m_iNumberAudioTracks = 0;
        this.m_bSourceHasTimedText = false;
        this.m_bSourceHasSubtitles = false;
        this.m_fSourceVideoFrameRate = 0.0f;
        this.m_TextureTimeStamp = Long.MIN_VALUE;
        this.m_FrameCount = 0;
        this.m_fBufferingProgressPercent = 0.0f;
        if (this.m_bVideo_RenderSurfaceCreated.get()) {
            this.m_bVideo_DestroyRenderSurface.set(true);
        }
        this.m_bVideo_CreateRenderSurface.set(false);
        this.m_iLastError = 0;
    }

    public void Deinitialise() {
        CloseVideo();
        Queue<VideoCommand> queue = this.m_CommandQueue;
        if (queue != null) {
            queue.clear();
            this.m_CommandQueue = null;
        }
        DeinitializeVideoPlayer();
    }

    public void DeinitialiseRender() {
        Runnable runnable;
        AVProMobileVideo_GlRender aVProMobileVideo_GlRender = this.m_GlRender_Video;
        if (aVProMobileVideo_GlRender != null) {
            aVProMobileVideo_GlRender.Destroy();
            this.m_GlRender_Video = null;
        }
        AVProMobileVideo_GlRender aVProMobileVideo_GlRender2 = this.m_GlRender_Watermark;
        if (aVProMobileVideo_GlRender2 != null) {
            aVProMobileVideo_GlRender2.Destroy();
            this.m_GlRender_Watermark = null;
        }
        SurfaceTexture surfaceTexture = this.m_SurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.m_SurfaceTexture.release();
            this.m_SurfaceTexture = null;
        }
        this.m_WatermarkPosition = null;
        Handler handler = this.m_WatermarkSizeHandler;
        if (handler != null && (runnable = this.m_WatermarkPositionRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
        this.m_WatermarkSizeHandler = null;
        this.m_WatermarkPositionRunnable = null;
        this.m_bDeinitialised = true;
    }

    public void RendererSetup(int i) {
        if (this.m_bDeinitialiseFlagged) {
            return;
        }
        this.m_iOpenGLVersion = i;
        this.m_bCanUseGLBindVertexArray = i > 2 && Build.VERSION.SDK_INT >= 18;
        if (this.m_GlRender_Video == null) {
            AVProMobileVideo_GlRender aVProMobileVideo_GlRender = new AVProMobileVideo_GlRender();
            this.m_GlRender_Video = aVProMobileVideo_GlRender;
            aVProMobileVideo_GlRender.Setup(0, 0, null, true, this.m_bCanUseGLBindVertexArray, this.m_bUseFastOesPath);
            CreateAndBindSinkTexture(this.m_GlRender_Video.GetGlTextureHandle(true));
        }
        if (this.m_bWatermarked && this.m_GlRender_Watermark == null) {
            AVProMobileVideo_GlRender aVProMobileVideo_GlRender2 = new AVProMobileVideo_GlRender();
            this.m_GlRender_Watermark = aVProMobileVideo_GlRender2;
            aVProMobileVideo_GlRender2.Setup(254, 141, AVProMobileWMImage.s_aImageData, false, this.m_bCanUseGLBindVertexArray, false);
        }
    }

    public int GetPlayerIndex() {
        return this.m_iPlayerIndex;
    }

    public int GetTextureHandle() {
        AVProMobileVideo_GlRender aVProMobileVideo_GlRender;
        if (this.m_VideoState >= 3 && (aVProMobileVideo_GlRender = this.m_GlRender_Video) != null) {
            return aVProMobileVideo_GlRender.GetGlTextureHandle(false);
        }
        return 0;
    }

    public float[] GetTextureTransform() {
        if (this.m_GlRender_Video == null || this.m_SurfaceTexture == null || !this.m_bVideo_RenderSurfaceCreated.get() || this.m_bVideo_DestroyRenderSurface.get() || !this.m_bUseFastOesPath) {
            return null;
        }
        float[] fArr = new float[16];
        this.m_SurfaceTexture.getTransformMatrix(fArr);
        System.out.println("Matrix " + fArr[0] + "," + fArr[1] + "," + fArr[2] + "," + fArr[3] + " " + fArr[4] + "," + fArr[5] + "," + fArr[6] + "," + fArr[7] + " " + fArr[8] + "," + fArr[9] + "," + fArr[10] + "," + fArr[11] + " " + fArr[12] + "," + fArr[13] + "," + fArr[14] + "," + fArr[15]);
        return new float[]{Math.signum(fArr[0]), Math.signum(fArr[1]), -Math.signum(fArr[4]), -Math.signum(fArr[5]), 0.0f, 0.0f};
    }

    public int GetLastErrorCode() {
        int i = this.m_iLastError;
        this.m_iLastError = 0;
        return i;
    }

    public void SetPlayerOptions(boolean z, boolean z2) {
        if (!this.m_bWatermarked) {
            this.m_bUseFastOesPath = z;
        }
        this.m_bShowPosterFrame = z2;
    }

    public boolean OpenVideoFromFile(String str, long j, String str2, int i) {
        CloseVideo();
        this.m_VideoState = 1;
        this.m_bVideo_CreateRenderSurface.set(false);
        this.m_bVideo_DestroyRenderSurface.set(false);
        this.m_iCurrentAudioTrackIndex = -1;
        this.m_bSourceHasVideo = false;
        this.m_bSourceHasAudio = false;
        this.m_iNumberAudioTracks = 0;
        this.m_bSourceHasTimedText = false;
        this.m_bSourceHasSubtitles = false;
        this.m_fSourceVideoFrameRate = 0.0f;
        this.m_DurationMs = 0L;
        this.m_FrameCount = 0;
        this.m_bIsStream = false;
        this.m_bIsBuffering = false;
        this.m_bIsSeeking = false;
        this.m_fBufferingProgressPercent = 0.0f;
        new StringBuilder("OpenVideoFromFile: m_iNumberFramesAvailable = ").append(this.m_iNumberFramesAvailable.get());
        return OpenVideoFromFileInternal(str, j, str2, i);
    }

    public boolean IsLooping() {
        return this.m_bLooping;
    }

    public int GetFrameCount() {
        return this.m_FrameCount;
    }

    public long GetDurationMs() {
        return this.m_DurationMs;
    }

    public int GetWidth() {
        return this.m_Width;
    }

    public int GetHeight() {
        return this.m_Height;
    }

    public float GetDisplayRate() {
        return this.m_DisplayRate_FrameRate;
    }

    public float GetPlaybackRate() {
        return this.m_fPlaybackRate;
    }

    public boolean HasVideo() {
        return this.m_bSourceHasVideo;
    }

    public boolean HasAudio() {
        return this.m_bSourceHasAudio;
    }

    public boolean HasTimedText() {
        return this.m_bSourceHasTimedText;
    }

    public boolean HasSubtitles() {
        return this.m_bSourceHasSubtitles;
    }

    public boolean IsMuted() {
        return this.m_AudioMuted;
    }

    public float GetVolume() {
        return this.m_AudioVolume;
    }

    public float GetAudioPan() {
        return this.m_AudioPan;
    }

    public void Play() {
        RemoveDuplicateCommand(VideoCommand_Stop);
        RemoveDuplicateCommand(VideoCommand_Play);
        RemoveDuplicateCommand(VideoCommand_Pause);
        AddVideoCommandInt(VideoCommand_Play, 0);
    }

    public void Pause() {
        RemoveDuplicateCommand(VideoCommand_Stop);
        RemoveDuplicateCommand(VideoCommand_Play);
        RemoveDuplicateCommand(VideoCommand_Pause);
        AddVideoCommandInt(VideoCommand_Pause, 0);
    }

    public void Stop() {
        RemoveDuplicateCommand(VideoCommand_Stop);
        RemoveDuplicateCommand(VideoCommand_Play);
        RemoveDuplicateCommand(VideoCommand_Pause);
        AddVideoCommandInt(VideoCommand_Stop, 0);
    }

    public void Seek(int i) {
        RemoveDuplicateCommand(VideoCommand_Seek);
        RemoveDuplicateCommand(VideoCommand_SeekFast);
        AddVideoCommandInt(VideoCommand_Seek, i);
    }

    public void SeekFast(int i) {
        RemoveDuplicateCommand(VideoCommand_Seek);
        RemoveDuplicateCommand(VideoCommand_SeekFast);
        AddVideoCommandInt(VideoCommand_SeekFast, i);
    }

    public int GetCurrentAudioTrackIndex() {
        return this.m_iCurrentAudioTrackIndex;
    }

    public int GetNumberAudioTracks() {
        return this.m_iNumberAudioTracks;
    }

    public boolean IsBuffering() {
        return this.m_bIsBuffering;
    }

    public float GetSourceVideoFrameRate() {
        return this.m_fSourceVideoFrameRate;
    }

    public long GetTextureTimeStamp() {
        return this.m_TextureTimeStamp / 100;
    }

    public void MuteAudio(boolean z) {
        this.m_AudioMuted = z;
        if (this.m_VideoState >= 3) {
            UpdateAudioVolumes();
        } else {
            RemoveDuplicateCommand(VideoCommand_AudioVolumes);
            AddVideoCommandInt(VideoCommand_AudioVolumes, 0);
        }
    }

    public void SetVolume(float f) {
        this.m_AudioVolume = Math.max(Math.min(f, 1.0f), 0.0f);
        if (this.m_VideoState >= 3) {
            UpdateAudioVolumes();
        } else {
            RemoveDuplicateCommand(VideoCommand_AudioVolumes);
            AddVideoCommandInt(VideoCommand_AudioVolumes, 0);
        }
    }

    public void SetAudioPan(float f) {
        this.m_AudioPan = Math.max(Math.min(f, 1.0f), -1.0f);
        if (this.m_VideoState >= 3) {
            UpdateAudioVolumes();
        } else {
            RemoveDuplicateCommand(VideoCommand_AudioVolumes);
            AddVideoCommandInt(VideoCommand_AudioVolumes, 0);
        }
    }

    private void RemoveDuplicateCommand(int i) {
        this._mutex.lock();
        Queue<VideoCommand> queue = this.m_CommandQueue;
        if (queue != null) {
            for (VideoCommand videoCommand : queue) {
                if (videoCommand._command == i) {
                    this.m_CommandQueue.remove(videoCommand);
                    break;
                }
            }
        }
        this._mutex.unlock();
    }

    protected void AddVideoCommandInt(int i, int i2) {
        this._mutex.lock();
        if (this.m_CommandQueue != null) {
            VideoCommand videoCommand = new VideoCommand();
            videoCommand._command = i;
            videoCommand._intValue = i2;
            this.m_CommandQueue.add(videoCommand);
            UpdateCommandQueue();
        }
        this._mutex.unlock();
    }

    private void UpdateCommandQueue() {
        if (!this.m_bVideo_AcceptCommands.get() || this.m_CommandQueue == null) {
            return;
        }
        while (!this.m_CommandQueue.isEmpty()) {
            VideoCommand videoCommandPoll = this.m_CommandQueue.poll();
            if (videoCommandPoll._command == VideoCommand_Play) {
                _play();
            } else if (videoCommandPoll._command == VideoCommand_Pause) {
                _pause();
            } else if (videoCommandPoll._command == VideoCommand_Stop) {
                _stop();
            } else if (videoCommandPoll._command == VideoCommand_Seek) {
                _seek(videoCommandPoll._intValue);
            } else if (videoCommandPoll._command == VideoCommand_SeekFast) {
                _seekFast(videoCommandPoll._intValue);
            } else if (videoCommandPoll._command == VideoCommand_AudioVolumes) {
                UpdateAudioVolumes();
            } else if (videoCommandPoll._command == VideoCommand_SetLooping) {
                UpdateLooping();
            }
        }
    }

    public void Update() {
        PlayerRenderUpdate();
        UpdateCommandQueue();
    }

    public boolean Render() {
        boolean z = false;
        if (this.m_bDeinitialiseFlagged) {
            return false;
        }
        if (!this.m_bWatermarked || (s_bCompressedWatermarkDataGood && this.m_bWatermarkDataGood)) {
            boolean z2 = this.m_bVideo_DestroyRenderSurface.get();
            boolean z3 = this.m_bVideo_CreateRenderSurface.get();
            if (z2) {
                AVProMobileVideo_GlRender aVProMobileVideo_GlRender = this.m_GlRender_Video;
                if (aVProMobileVideo_GlRender != null) {
                    aVProMobileVideo_GlRender.DestroyRenderTarget();
                }
                this.m_bVideo_DestroyRenderSurface.set(false);
                this.m_bVideo_RenderSurfaceCreated.set(false);
            }
            if (z3) {
                AVProMobileVideo_GlRender aVProMobileVideo_GlRender2 = this.m_GlRender_Video;
                if (aVProMobileVideo_GlRender2 != null) {
                    aVProMobileVideo_GlRender2.DestroyRenderTarget();
                    if (!this.m_bUseFastOesPath) {
                        this.m_GlRender_Video.CreateRenderTarget(this.m_Width, this.m_Height);
                    }
                }
                this.m_bVideo_DestroyRenderSurface.set(false);
                this.m_bVideo_CreateRenderSurface.set(false);
                this.m_bVideo_RenderSurfaceCreated.set(true);
                if (!this.m_bIsStream && this.m_VideoState >= 3) {
                    this.m_bVideo_AcceptCommands.set(true);
                    int i = this.m_VideoState;
                    if (i != 5 && i != 4) {
                        this.m_VideoState = 6;
                    }
                }
            }
            synchronized (this) {
                int i2 = this.m_iNumberFramesAvailable.get();
                if (this.m_GlRender_Video != null && this.m_bVideo_RenderSurfaceCreated.get() && i2 > 0 && ((this.m_Width > 0 && this.m_bSourceHasVideo) || this.m_bSourceHasAudio)) {
                    if (this.m_bUseFastOesPath) {
                        this.m_SurfaceTexture.updateTexImage();
                        this.m_TextureTimeStamp = this.m_SurfaceTexture.getTimestamp();
                    } else {
                        this.m_GlRender_Video.StartRender();
                        this.m_TextureTimeStamp = this.m_GlRender_Video.Blit(this.m_SurfaceTexture, null);
                        if (this.m_bWatermarked) {
                            float f = this.m_WatermarkScale;
                            this.m_GlRender_Watermark.Blit(null, new float[]{f, 0.0f, 0.0f, 0.0f, 0.0f, -f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -this.m_WatermarkPosition.x, this.m_WatermarkPosition.y, 0.0f, 1.0f});
                        }
                        this.m_GlRender_Video.EndRender();
                    }
                    this.m_FrameCount += i2;
                    UpdateDisplayFrameRate(i2);
                    this.m_iNumberFramesAvailable.set(0);
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ChangeWatermarkPosition() {
        this.m_WatermarkPosition.x = (int) ((this.m_Random.nextFloat() * 4.0f) + 0.0f);
        this.m_WatermarkPosition.y = (int) ((this.m_Random.nextFloat() * 4.0f) + 1.0f);
        this.m_WatermarkScale = 5.0f;
    }

    private void CreateAndBindSinkTexture(int i) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(i);
        this.m_SurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        BindSurfaceToPlayer();
    }

    private void UpdateDisplayFrameRate(int i) {
        long jNanoTime = System.nanoTime();
        long j = (jNanoTime - this.m_DisplayRate_LastSystemTimeMS) / 1000000;
        long j2 = this.m_DisplayRate_NumberFrames + ((long) i);
        this.m_DisplayRate_NumberFrames = j2;
        if (j >= 500) {
            this.m_DisplayRate_FrameRate = j2 / (j * 0.001f);
            this.m_DisplayRate_NumberFrames = 0L;
            this.m_DisplayRate_LastSystemTimeMS = jNanoTime;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.m_FrameArrivalThreadID = Thread.currentThread().getId();
            this.m_iNumberFramesAvailable.incrementAndGet();
        }
    }
}
