package com.adxcorp.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.Constants;
import com.adxcorp.ads.mediation.event.AdEventListener;
import com.adxcorp.ads.mediation.nativeads.util.VideoThumbnail;
import com.adxcorp.ads.mediation.util.ClickThroughUtil;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.adxcorp.ads.mediation.util.HttpUtil;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.ads.mediation.videoads.VideoAdData;
import com.adxcorp.util.ADXLogUtil;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class MainAdVideoView extends FrameLayout implements TextureView.SurfaceTextureListener {
    public static final String TAG = "MainAdVideoView";
    private Runnable checkVideoPrepared;
    private boolean isSentComplete;
    private boolean isSentFirst;
    private boolean isSentImpression;
    private boolean isSentSecond;
    private boolean isSentStart;
    private boolean isSentThird;
    private Button mAdButton;
    private AdEventListener mAdEventListener;
    private View mBackgroundView;
    private RelativeLayout mContainer;
    private Context mContext;
    private int mFirstQuartile;
    private boolean mIsAutoPlay;
    private boolean mIsClickableVideo;
    private boolean mIsPrepared;
    private boolean mIsPreparing;
    private boolean mIsReady;
    private boolean mIsVisible;
    private boolean mIsVolumeOn;
    private boolean mIsWebViewLanding;
    private String mLink;
    private MediaPlayer mMediaPlayer;
    private ImageView mPauseImageView;
    private ImageView mPlayImageView;
    private RelativeLayout mPlayStateContainer;
    private ProgressBar mProgressBar;
    private RelativeLayout mReadyStateContainer;
    private ImageView mRestartImageView;
    private int mSecondQuartile;
    private NoSkipSeekBar mSeekbar;
    private SurfaceTexture mSurfaceTexture;
    private TextureView mTextureView;
    private int mThirdQuartile;
    private String mUrl;
    private VideoAdData mVideoAdData;
    private int mVideoCurPosSec;
    private int mVideoDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    private ImageView mVolumeImage;
    private Bitmap mVolumeOffBitmap;
    private Bitmap mVolumeOnBitmap;
    private Runnable videoPlayTrackerRunnable;

    private void adjustAspectRatio(int i, int i2) {
    }

    public MainAdVideoView(Context context) {
        super(context);
        this.videoPlayTrackerRunnable = new Runnable() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MainAdVideoView.this.mMediaPlayer != null && MainAdVideoView.this.mMediaPlayer.isPlaying()) {
                        MainAdVideoView.this.setVisibleContainer(false, true);
                        MainAdVideoView mainAdVideoView = MainAdVideoView.this;
                        mainAdVideoView.mVideoCurPosSec = mainAdVideoView.mMediaPlayer.getCurrentPosition() / 1000;
                        ADXLogUtil.d(MainAdVideoView.TAG, "video current position  : " + MainAdVideoView.this.mVideoCurPosSec);
                        if (MainAdVideoView.this.mVideoCurPosSec > 0 && MainAdVideoView.this.mVideoAdData != null) {
                            if (MainAdVideoView.this.mVideoCurPosSec != MainAdVideoView.this.mFirstQuartile || MainAdVideoView.this.isSentFirst) {
                                if (MainAdVideoView.this.mVideoCurPosSec != MainAdVideoView.this.mSecondQuartile || MainAdVideoView.this.isSentSecond) {
                                    if (MainAdVideoView.this.mVideoCurPosSec == MainAdVideoView.this.mThirdQuartile && !MainAdVideoView.this.isSentThird) {
                                        MainAdVideoView.this.isSentThird = true;
                                        ReportUtil.sendReport("VIDEO_THIRD_QUARTILE", MainAdVideoView.this.mVideoAdData.getTrackingThirdQuartileUrls());
                                    }
                                } else {
                                    MainAdVideoView.this.isSentSecond = true;
                                    ReportUtil.sendReport("VIDEO_MID_POINT", MainAdVideoView.this.mVideoAdData.getTrackingMidpointUrls());
                                }
                            } else {
                                MainAdVideoView.this.isSentFirst = true;
                                ReportUtil.sendReport("VIDEO_FIRST_QUARTILE", MainAdVideoView.this.mVideoAdData.getTrackingFirstQuartileUrls());
                            }
                        }
                        if (MainAdVideoView.this.mSeekbar != null && MainAdVideoView.this.mMediaPlayer != null) {
                            MainAdVideoView.this.mSeekbar.setProgress(MainAdVideoView.this.mMediaPlayer.getCurrentPosition());
                        }
                        MainAdVideoView mainAdVideoView2 = MainAdVideoView.this;
                        mainAdVideoView2.postDelayed(mainAdVideoView2.videoPlayTrackerRunnable, 500L);
                        return;
                    }
                    ADXLogUtil.d(MainAdVideoView.TAG, "::: videoview : " + (MainAdVideoView.this.mMediaPlayer != null ? "isPlaying - " + MainAdVideoView.this.mMediaPlayer.isPlaying() : "null"));
                } catch (Exception e) {
                    ADXLogUtil.e(MainAdVideoView.TAG, e);
                }
            }
        };
        this.checkVideoPrepared = new Runnable() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                if (MainAdVideoView.this.mIsPrepared) {
                    return;
                }
                MainAdVideoView.this.notifyError();
                MainAdVideoView.this.stopVideo();
            }
        };
        this.mContext = context;
        if (this.mTextureView == null) {
            this.mTextureView = new TextureView(this.mContext);
            this.mTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mTextureView.setSurfaceTextureListener(this);
            addView(this.mTextureView, 0);
        }
        initLayout();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        ADXLogUtil.d(TAG, "onSurfaceTextureAvailable");
        this.mSurfaceTexture = surfaceTexture;
        this.mIsReady = true;
        setVisibleContainer(true, false);
        if (getBackground() == null) {
            new VideoThumbnail(this, this.mUrl).execute();
        }
        if (!this.isSentImpression) {
            this.isSentImpression = true;
            ReportUtil.sendReport("VIDEO_IMPRESSION", this.mVideoAdData.getTrackingImpUrls());
        }
        if (this.mIsAutoPlay) {
            startVideo();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        ADXLogUtil.d(TAG, "onSurfaceTextureSizeChanged");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        ADXLogUtil.d(TAG, "onSurfaceTextureDestroyed");
        this.mIsReady = false;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            notifyStopped();
        }
        stopVideo();
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        ADXLogUtil.d(TAG, "onSurfaceTextureUpdated");
    }

    public void pauseVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            ImageView imageView = this.mRestartImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            fadeOutAndHideImage(this.mPauseImageView);
            notifyPaused();
        }
    }

    public void restartVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            removeCallbacks(this.videoPlayTrackerRunnable);
            post(this.videoPlayTrackerRunnable);
            ImageView imageView = this.mPauseImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            fadeOutAndHideImage(this.mRestartImageView);
            notifyStarted();
        }
    }

    public void stopVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        setVisibleContainer(true, false);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ImageView imageView = this.mPauseImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mRestartImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        removeCallbacks(this.checkVideoPrepared);
        removeCallbacks(this.videoPlayTrackerRunnable);
        this.mIsPreparing = false;
    }

    public void startVideo() {
        ADXLogUtil.d(TAG, ":::start::: isReady : " + this.mIsReady + ", isLoading : " + this.mIsPreparing);
        if (!this.mIsReady || this.mIsPreparing) {
            return;
        }
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                stopVideo();
                this.mIsPreparing = true;
                this.mMediaPlayer = createMediaPlayer();
                this.mMediaPlayer.setSurface(new Surface(this.mSurfaceTexture));
                this.mMediaPlayer.setDataSource(this.mUrl);
                this.mMediaPlayer.prepareAsync();
                this.mIsPrepared = false;
                postDelayed(this.checkVideoPrepared, Constants.VIDEO_PLAY_TIMEOUT);
                setVisibleContainer(false, false);
            }
        } catch (Exception e) {
            this.mIsPreparing = false;
            ADXLogUtil.e(TAG, e);
            notifyError();
            stopVideo();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        ADXLogUtil.d(TAG, "onWindowVisibilityChanged(" + i + "): " + (i == 0 ? "VISIBLE" : "INVISIBLE"));
        if (i == 0) {
            if (!this.mIsVisible) {
                initLayout();
            }
            this.mIsVisible = true;
        } else {
            this.mIsVisible = false;
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                notifyStopped();
            }
            stopVideo();
        }
    }

    private MediaPlayer createMediaPlayer() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            if (Build.VERSION.SDK_INT >= 21) {
                mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());
            } else {
                mediaPlayer.setAudioStreamType(3);
            }
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.3
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    ADXLogUtil.d(MainAdVideoView.TAG, "onPrepared");
                    MainAdVideoView.this.mIsPrepared = true;
                    MainAdVideoView.this.mIsPreparing = false;
                    MainAdVideoView mainAdVideoView = MainAdVideoView.this;
                    mainAdVideoView.removeCallbacks(mainAdVideoView.checkVideoPrepared);
                    int videoWidth = mediaPlayer2.getVideoWidth();
                    int videoHeight = mediaPlayer2.getVideoHeight();
                    if (videoWidth <= 0 || videoHeight <= 0) {
                        return;
                    }
                    MainAdVideoView.this.mVideoWidth = videoWidth;
                    MainAdVideoView.this.mVideoHeight = videoHeight;
                    ADXLogUtil.d(MainAdVideoView.TAG, "videoWidth : " + videoWidth + ", videoHeight : " + videoHeight + ", videoProportion : " + (videoWidth / videoHeight));
                    int duration = mediaPlayer2.getDuration();
                    ADXLogUtil.d(MainAdVideoView.TAG, "finalTime : " + duration);
                    long j = duration;
                    ADXLogUtil.d(MainAdVideoView.TAG, String.format("onPrepared - %d:%d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))));
                    MainAdVideoView.this.mVideoDuration = duration / 1000;
                    MainAdVideoView mainAdVideoView2 = MainAdVideoView.this;
                    mainAdVideoView2.mFirstQuartile = mainAdVideoView2.mVideoDuration / 4;
                    MainAdVideoView mainAdVideoView3 = MainAdVideoView.this;
                    mainAdVideoView3.mSecondQuartile = mainAdVideoView3.mVideoDuration / 2;
                    MainAdVideoView mainAdVideoView4 = MainAdVideoView.this;
                    mainAdVideoView4.mThirdQuartile = (mainAdVideoView4.mVideoDuration * 3) / 4;
                    if (MainAdVideoView.this.mSeekbar != null) {
                        MainAdVideoView.this.mSeekbar.setMax(duration);
                    }
                    MainAdVideoView.this.mute();
                    MainAdVideoView.this.mIsVolumeOn = false;
                    MainAdVideoView.this.setVolumeImage();
                    if (MainAdVideoView.this.mVolumeImage != null) {
                        MainAdVideoView.this.mVolumeImage.setImageBitmap(MainAdVideoView.this.mVolumeOffBitmap);
                        MainAdVideoView.this.mVolumeImage.setVisibility(0);
                    }
                    mediaPlayer2.start();
                    MainAdVideoView.this.setVisibleContainer(false, true);
                    MainAdVideoView mainAdVideoView5 = MainAdVideoView.this;
                    mainAdVideoView5.removeCallbacks(mainAdVideoView5.videoPlayTrackerRunnable);
                    MainAdVideoView mainAdVideoView6 = MainAdVideoView.this;
                    mainAdVideoView6.post(mainAdVideoView6.videoPlayTrackerRunnable);
                    MainAdVideoView.this.notifyStarted();
                    if (MainAdVideoView.this.isSentStart) {
                        return;
                    }
                    MainAdVideoView.this.isSentStart = true;
                    ReportUtil.sendReport("VIDEO_START", MainAdVideoView.this.mVideoAdData.getTrackingStartUrls());
                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.4
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                    ADXLogUtil.d(MainAdVideoView.TAG, "onError");
                    MainAdVideoView.this.setVisibleContainer(true, false);
                    MainAdVideoView.this.notifyError();
                    MainAdVideoView.this.stopVideo();
                    return false;
                }
            });
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.5
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                    if (i == 701) {
                        ADXLogUtil.d(MainAdVideoView.TAG, "MediaPlayer Buffering Start");
                        if (MainAdVideoView.this.mProgressBar != null) {
                            MainAdVideoView.this.mProgressBar.setVisibility(0);
                        }
                    } else if (i == 702) {
                        ADXLogUtil.d(MainAdVideoView.TAG, "MediaPlayer Buffering End");
                        if (MainAdVideoView.this.mProgressBar != null) {
                            MainAdVideoView.this.mProgressBar.setVisibility(8);
                        }
                    }
                    return false;
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.6
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    ADXLogUtil.d(MainAdVideoView.TAG, "onCompletion - current position : " + MainAdVideoView.this.mVideoCurPosSec + ", duration : " + MainAdVideoView.this.mVideoDuration);
                    MainAdVideoView.this.setVisibleContainer(true, false);
                    MainAdVideoView.this.notifyCompleted();
                    if (MainAdVideoView.this.isSentComplete) {
                        return;
                    }
                    MainAdVideoView.this.isSentComplete = true;
                    ReportUtil.sendReport("VIDEO_COMPLETE", MainAdVideoView.this.mVideoAdData.getTrackingCompleteUrls());
                }
            });
            return mediaPlayer;
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            return null;
        }
    }

    private void initLayout() {
        try {
            if (this.mContext == null) {
                return;
            }
            TextureView textureView = this.mTextureView;
            if (textureView != null) {
                removeView(textureView);
                this.mTextureView = null;
            }
            if (this.mTextureView == null) {
                TextureView textureView2 = new TextureView(this.mContext);
                this.mTextureView = textureView2;
                textureView2.setOpaque(false);
                this.mTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.mTextureView.setSurfaceTextureListener(this);
                addView(this.mTextureView, 0);
            }
            if (this.mContainer == null) {
                this.mContainer = new RelativeLayout(this.mContext);
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.mContainer);
                setupReadyStateContainer();
                setupPlayStateContainer();
            }
            if (this.mProgressBar == null) {
                this.mProgressBar = new ProgressBar(this.mContext);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.mProgressBar.setLayoutParams(layoutParams);
                try {
                    this.mProgressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
                } catch (Exception unused) {
                }
                addView(this.mProgressBar);
            }
            setVisibleContainer(true, false);
        } catch (Exception unused2) {
        }
    }

    private void setupReadyStateContainer() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mReadyStateContainer = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.mReadyStateContainer.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainAdVideoView.this.startVideo();
            }
        });
        addView(this.mReadyStateContainer);
        setupBackgroundView();
        setupPlayIcon();
    }

    private void setupBackgroundView() {
        try {
            if (this.mBackgroundView == null) {
                this.mBackgroundView = new View(this.mContext);
                this.mBackgroundView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.mBackgroundView.setBackgroundColor(Color.parseColor("#66000000"));
                this.mReadyStateContainer.addView(this.mBackgroundView);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void setupPlayIcon() {
        try {
            if (this.mPlayImageView == null) {
                this.mPlayImageView = new ImageView(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 80), DisplayUtil.dpToPx(this.mContext, 80));
                layoutParams.addRule(13);
                this.mPlayImageView.setLayoutParams(layoutParams);
                try {
                    byte[] bArrDecode = Base64.decode("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", 0);
                    this.mPlayImageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                } catch (Exception e) {
                    ADXLogUtil.e(TAG, e);
                }
                this.mPlayImageView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MainAdVideoView.this.startVideo();
                    }
                });
                this.mReadyStateContainer.addView(this.mPlayImageView);
            }
        } catch (Exception unused) {
        }
    }

    private void setupPlayStateContainer() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mPlayStateContainer = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.mPlayStateContainer.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MainAdVideoView.this.mMediaPlayer != null) {
                    if (MainAdVideoView.this.mMediaPlayer.isPlaying()) {
                        MainAdVideoView.this.pauseVideo();
                    } else {
                        MainAdVideoView.this.restartVideo();
                    }
                }
            }
        });
        addView(this.mPlayStateContainer);
        setupVolumeButton();
        setupPauseIcon();
        setupRestartIcon();
        setupSeekBar();
        setupClickButton();
    }

    private void setupPauseIcon() {
        try {
            if (this.mPauseImageView == null) {
                this.mPauseImageView = new ImageView(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 80), DisplayUtil.dpToPx(this.mContext, 80));
                layoutParams.addRule(13);
                this.mPauseImageView.setLayoutParams(layoutParams);
                try {
                    byte[] bArrDecode = Base64.decode("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", 0);
                    this.mPauseImageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                } catch (Exception e) {
                    ADXLogUtil.e(TAG, e);
                }
                this.mPlayStateContainer.addView(this.mPauseImageView);
            }
            this.mPauseImageView.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    private void setupRestartIcon() {
        try {
            if (this.mRestartImageView == null) {
                this.mRestartImageView = new ImageView(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 80), DisplayUtil.dpToPx(this.mContext, 80));
                layoutParams.addRule(13);
                this.mRestartImageView.setLayoutParams(layoutParams);
                try {
                    byte[] bArrDecode = Base64.decode("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", 0);
                    this.mRestartImageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                } catch (Exception e) {
                    ADXLogUtil.e(TAG, e);
                }
                this.mPlayStateContainer.addView(this.mRestartImageView);
            }
            this.mRestartImageView.setVisibility(8);
        } catch (Exception e2) {
            ADXLogUtil.e(TAG, e2);
        }
    }

    private void setupVolumeButton() {
        try {
            if (this.mVolumeImage == null) {
                ImageView imageView = new ImageView(this.mContext);
                this.mVolumeImage = imageView;
                imageView.setBackgroundColor(Integer.MIN_VALUE);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 24), DisplayUtil.dpToPx(this.mContext, 24));
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                int iDpToPx = DisplayUtil.dpToPx(this.mContext, 14);
                layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
                this.mVolumeImage.setLayoutParams(layoutParams);
                this.mVolumeImage.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MainAdVideoView.this.setVolumeImage();
                        if (MainAdVideoView.this.mIsVolumeOn) {
                            if (MainAdVideoView.this.mute()) {
                                MainAdVideoView.this.mIsVolumeOn = false;
                                MainAdVideoView.this.mVolumeImage.setImageBitmap(MainAdVideoView.this.mVolumeOffBitmap);
                                return;
                            }
                            return;
                        }
                        if (MainAdVideoView.this.unmute()) {
                            MainAdVideoView.this.mIsVolumeOn = true;
                            MainAdVideoView.this.mVolumeImage.setImageBitmap(MainAdVideoView.this.mVolumeOnBitmap);
                        }
                    }
                });
                this.mPlayStateContainer.addView(this.mVolumeImage);
            }
            this.mIsVolumeOn = false;
            setVolumeImage();
            this.mVolumeImage.setImageBitmap(this.mVolumeOffBitmap);
            this.mVolumeImage.setVisibility(8);
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void setupSeekBar() {
        try {
            if (this.mSeekbar == null) {
                this.mSeekbar = new NoSkipSeekBar(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, DisplayUtil.dpToPx(this.mContext, 4));
                layoutParams.addRule(12);
                this.mSeekbar.setLayoutParams(layoutParams);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f}, null, null));
                shapeDrawable.setIntrinsicHeight(0);
                shapeDrawable.setIntrinsicWidth(0);
                this.mSeekbar.setThumb(shapeDrawable);
                this.mSeekbar.getProgressDrawable().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
                if (Build.VERSION.SDK_INT >= 16) {
                    this.mSeekbar.getThumb().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
                }
                this.mPlayStateContainer.addView(this.mSeekbar);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void setupClickButton() {
        try {
            if (this.mAdButton == null) {
                Button button = new Button(this.mContext);
                this.mAdButton = button;
                button.setBackgroundColor(Integer.MIN_VALUE);
                this.mAdButton.setTextColor(-1);
                this.mAdButton.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ClickThroughUtil.isValidClick()) {
                            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                                ADXLogUtil.d(MainAdVideoView.TAG, ":::clickEvent::: " + MainAdVideoView.this.mLink + " -> block");
                                return;
                            }
                            return;
                        }
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(MainAdVideoView.TAG, ":::clickEvent::: " + MainAdVideoView.this.mLink + " -> isWebViewLanding : " + MainAdVideoView.this.mIsWebViewLanding);
                        }
                        if (MainAdVideoView.this.mIsWebViewLanding) {
                            HttpUtil.getFinalURL(MainAdVideoView.this.mLink, new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.11.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    if (message.what != 100) {
                                        return;
                                    }
                                    try {
                                        if (ClickThroughUtil.goToWebView(MainAdVideoView.this.mContext, (String) message.obj)) {
                                            MainAdVideoView.this.notifyClick();
                                            if (MainAdVideoView.this.mVideoAdData != null) {
                                                ReportUtil.sendReport("VIDEO_CLICK", MainAdVideoView.this.mVideoAdData.getTrackingClkUrls());
                                            }
                                        } else if (ClickThroughUtil.goToBrowser(MainAdVideoView.this.mContext, (String) message.obj)) {
                                            MainAdVideoView.this.notifyClick();
                                            if (MainAdVideoView.this.mVideoAdData != null) {
                                                ReportUtil.sendReport("VIDEO_CLICK", MainAdVideoView.this.mVideoAdData.getTrackingClkUrls());
                                            }
                                        }
                                    } catch (Exception e) {
                                        ADXLogUtil.e(MainAdVideoView.TAG, e);
                                    }
                                }
                            });
                        } else if (ClickThroughUtil.goToBrowser(MainAdVideoView.this.mContext, MainAdVideoView.this.mLink)) {
                            MainAdVideoView.this.notifyClick();
                            if (MainAdVideoView.this.mVideoAdData != null) {
                                ReportUtil.sendReport("VIDEO_CLICK", MainAdVideoView.this.mVideoAdData.getTrackingClkUrls());
                            }
                        }
                    }
                });
                this.mAdButton.setTextSize(2, 9.0f);
                this.mAdButton.setMinimumHeight(0);
                this.mAdButton.setMinimumWidth(0);
                this.mAdButton.setMaxEms(10);
                this.mAdButton.setMaxLines(1);
                this.mAdButton.setSingleLine();
                this.mAdButton.setWidth(DisplayUtil.dpToPx(this.mContext, 60));
                this.mAdButton.setHeight(DisplayUtil.dpToPx(this.mContext, 32));
                if (Build.VERSION.SDK_INT >= 14) {
                    this.mAdButton.setAllCaps(false);
                }
                this.mAdButton.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                int iDpToPx = DisplayUtil.dpToPx(this.mContext, 10);
                layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
                this.mAdButton.setLayoutParams(layoutParams);
                this.mAdButton.setVisibility(8);
                this.mPlayStateContainer.addView(this.mAdButton, layoutParams);
            }
            if (this.mIsClickableVideo) {
                Button button2 = this.mAdButton;
                if (button2 != null) {
                    button2.setVisibility(0);
                    VideoAdData videoAdData = this.mVideoAdData;
                    if (videoAdData != null && !TextUtils.isEmpty(videoAdData.getLinkText())) {
                        this.mAdButton.setText(this.mVideoAdData.getLinkText());
                        return;
                    }
                    this.mAdButton.setText("자세히 보기");
                    return;
                }
                return;
            }
            Button button3 = this.mAdButton;
            if (button3 != null) {
                button3.setVisibility(8);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibleContainer(boolean z, boolean z2) {
        if (!z && !z2) {
            ProgressBar progressBar = this.mProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        } else {
            ProgressBar progressBar2 = this.mProgressBar;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
        }
        RelativeLayout relativeLayout = this.mReadyStateContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
        RelativeLayout relativeLayout2 = this.mPlayStateContainer;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(z2 ? 0 : 8);
        }
    }

    public void setVideoAdData(VideoAdData videoAdData, AdEventListener adEventListener) {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "setVideoAdData");
        }
        resetData();
        this.mVideoAdData = videoAdData;
        this.mAdEventListener = adEventListener;
        this.mIsAutoPlay = videoAdData.isAutoPlay();
        this.mUrl = videoAdData.getVideoContent();
        this.mLink = this.mVideoAdData.getLink();
        this.mIsWebViewLanding = this.mVideoAdData.getWebviewLanding() == 1;
        boolean z = !TextUtils.isEmpty(this.mLink);
        this.mIsClickableVideo = z;
        if (z) {
            Button button = this.mAdButton;
            if (button != null) {
                button.setVisibility(0);
                VideoAdData videoAdData2 = this.mVideoAdData;
                if (videoAdData2 == null || TextUtils.isEmpty(videoAdData2.getLinkText())) {
                    this.mAdButton.setText("자세히 보기");
                    return;
                } else {
                    this.mAdButton.setText(this.mVideoAdData.getLinkText());
                    return;
                }
            }
            return;
        }
        Button button2 = this.mAdButton;
        if (button2 != null) {
            button2.setVisibility(8);
        }
    }

    public void setVolumeImage() {
        try {
            if (this.mVolumeOffBitmap == null) {
                byte[] bArrDecode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAQAAAD9CzEMAAAB20lEQVR4Ae3WPYtTQRSH8dFdJIKijW8pfEHMBhsLsbOIgtoLFvkISW8rq34DOwM2IvgNtLwq64paRCyMgp3sptHGTlnziEw4HIazN39IOvOcKpO599fMwE3LFt0ymlS0SML0OKPsS/hp8gXYkgiATbqsoANUALXEugNyI67rQIvtWuIueMAa0NAAT2xTEvfAARV/HPGOoxqQWIsJ7pNLNmcZsGPEJ47EgEY0eO8Bm4uMjHhLQwFKYm26dnhKlHsP8MyIhwJgxDgmgr37eG7ENWJAJ8K9B/lsh3ZFBRLtiLB/39B2ey/ZmerqQEjYwE867vcjcq/rgLrGBcE/wq2dY0LutAAIRG7Trbwk168BdMLuxQ1buU3uiQ5ERLu4F4/t6cvkhgqgE1/t6WPkviuATvxyFy73WwB0wh3LVXI7CqAT++3pE+R+zAdslYTNFXIf5gNauxJ3hGMqlHYlhuR68wIxsTq9FxNORkA86xFgRHwvXpB0ICLSDOKmDsREqiUOsUcHYiLNIJIOxERSCR0wIgCu8g1iQgeMKIDzPMWKCB0wwgEb+CYRoQNGOMC//AEXGIeEDhhRAh/pFF8glQAIA/CKW+wtPnJGHF8M0OdU8B1V2esNWPwsgf8N+AunGBPD8qjlUgAAAABJRU5ErkJggg==", 0);
                this.mVolumeOffBitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            }
            if (this.mVolumeOnBitmap == null) {
                byte[] bArrDecode2 = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAQAAAD9CzEMAAABjklEQVR4Ae2XQSuEQRjHN2qtoj0QDgqx7d6lqFVI6+6EswvOnPdDyGFLLfEVuKjN2nbLRZJ2w0dQtDfi/blMT9O0YfJMLu8zp/n/n31+787Ozjxv4v8ijjjYYoLEz8Oe+A2AOut06wKKCMBEk4IeoAg2QKJESgNQBAtQ4RMJrhn6E0DKYymTlPiwlqojwrc8jj5N0/oWvf4AtzyuRx9n4pX8AW55OvhJzsUtuK5veTrm9NMybsv9X/iWR5wGOStvRvbUhgvwK4940GbByj00fv07wG/Czm2TlXmGyGSMawHc57002o4mAFZE2TXKqS7gWJS8UW50AU+iDBvlWRfwJkrSKO/BAaGWaCTMEpVFmQ/zIy+LsmeUE03AlfXpqtG29QCvZGSelYwxrcPuhbyVWzZ+Teu4rjJl5c3KUbcW4sJJ82Dce7r0r8weLsRd0r/001b5A/22ZY5HcRqkdBuvHEdWd3fHoG7rWCMCiToD4ZrfiH2S4dr3WxZDvYBEVFiVfa8O2GQ06CuUjBgQA74AFyzYmAiHa/QAAAAASUVORK5CYII=", 0);
                this.mVolumeOnBitmap = BitmapFactory.decodeByteArray(bArrDecode2, 0, bArrDecode2.length);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    public boolean mute() {
        return setVolume(0);
    }

    public boolean unmute() {
        return setVolume(100);
    }

    private boolean setVolume(int i) {
        try {
            if (this.mMediaPlayer == null) {
                return false;
            }
            int i2 = 100 - i;
            float fLog = (float) (1.0d - ((i2 > 0 ? Math.log(i2) : 0.0d) / Math.log(100.0d)));
            this.mMediaPlayer.setVolume(fLog, fLog);
            return true;
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            return false;
        }
    }

    private void fadeOutAndHideImage(final ImageView imageView) {
        if (imageView != null) {
            imageView.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            alphaAnimation.setDuration(1000L);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageView imageView2 = imageView;
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                }
            });
            imageView.setAnimation(alphaAnimation);
        }
    }

    private void resetData() {
        this.mUrl = null;
        this.mIsClickableVideo = false;
        this.mLink = null;
        this.mVideoDuration = 0;
        this.mVideoCurPosSec = 0;
        this.mFirstQuartile = 0;
        this.mSecondQuartile = 0;
        this.mThirdQuartile = 0;
        this.isSentStart = false;
        this.isSentComplete = false;
        this.isSentFirst = false;
        this.isSentSecond = false;
        this.isSentThird = false;
        this.mIsPrepared = false;
        this.mIsPreparing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyClick() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStarted() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdStarted();
        }
    }

    private void notifyPaused() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdPaused();
        }
    }

    private void notifyStopped() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdStopped();
        }
    }

    private void notifySkipped() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdSkipped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCompleted() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdCompleted();
        }
    }

    public int getVideoWidth() {
        Drawable background;
        if (this.mVideoWidth == 0 && (background = getBackground()) != null) {
            return background.getIntrinsicWidth();
        }
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        Drawable background;
        if (this.mVideoHeight == 0 && (background = getBackground()) != null) {
            return background.getIntrinsicHeight();
        }
        return this.mVideoHeight;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ADXLogUtil.d(TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ADXLogUtil.d(TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    public class NoSkipSeekBar extends SeekBar {
        @Override // android.widget.AbsSeekBar, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        public NoSkipSeekBar(Context context) {
            super(context);
        }

        public NoSkipSeekBar(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public NoSkipSeekBar(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }
}
