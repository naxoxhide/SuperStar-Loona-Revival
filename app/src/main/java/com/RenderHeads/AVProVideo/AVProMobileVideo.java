package com.RenderHeads.AVProVideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

/* JADX INFO: loaded from: classes.dex */
public class AVProMobileVideo {
    public static final int EXOPLAYER = 2;
    public static final int MEDIAPLAYER = 1;
    private static List<AVProVideoPlayer> _renderFree = new ArrayList();
    private static final ReentrantLock _renderMutex = new ReentrantLock();
    public static final int kUnityGfxRendererOpenGLES20 = 8;
    public static final int kUnityGfxRendererOpenGLES30 = 11;
    private static AVProMobileVideo s_Interface = null;
    private static boolean s_PreviousContextFail = false;
    private static int s_PreviousDeviceIndex = -1;
    private final boolean m_bWatermarked = false;
    private final String PLUGIN_VERSION = "1.10.1";
    private Map<Integer, AVProVideoPlayer> m_Players = new HashMap();
    private Random m_Random = new Random();
    private Context m_Context = null;
    private int m_iOpenGLVersion = -1;

    private static int getMajorVersion(int i) {
        return (i & 0xffff0000) >> 16;
    }

    private static native void nativeInit();

    public String GetPluginVersion() {
        return "1.10.1";
    }

    static {
        System.loadLibrary("AVProLocal");
        nativeInit();
    }

    public AVProMobileVideo() {
        if (s_Interface == null) {
            s_Interface = this;
        }
    }

    public static void Deinitialise() {
        s_Interface = null;
    }

    public void SetContext(Context context) {
        this.m_Context = context;
        int versionFromPackageManager = getVersionFromPackageManager(context);
        int glVersionFromDeviceConfig = getGlVersionFromDeviceConfig(this.m_Context);
        if (versionFromPackageManager >= 3 && glVersionFromDeviceConfig >= 3) {
            this.m_iOpenGLVersion = 3;
        } else {
            if (versionFromPackageManager < 2 || glVersionFromDeviceConfig < 2) {
                return;
            }
            this.m_iOpenGLVersion = 2;
        }
    }

    public AVProVideoPlayer CreatePlayer(int i, boolean z, boolean z2, int i2, boolean z3) {
        if (s_Interface != this) {
            return null;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < 256; i4++) {
            if (!this.m_Players.containsKey(Integer.valueOf(i4))) {
                i3 = i4;
                break;
            }
        }
        if (i3 < 0) {
            return null;
        }
        if (i == 1 || i == 2) {
            AVProVideoMediaPlayer aVProVideoMediaPlayer = new AVProVideoMediaPlayer(i3, false, this.m_Random);
            aVProVideoMediaPlayer.Initialise(this.m_Context, z, z2, i2, z3);
            this.m_Players.put(Integer.valueOf(i3), aVProVideoMediaPlayer);
            return this.m_Players.get(Integer.valueOf(i3));
        }
        return null;
    }

    public void DestroyPlayer(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex = GetAVProClassForPlayerIndex(i);
        if (aVProVideoPlayerGetAVProClassForPlayerIndex != null) {
            aVProVideoPlayerGetAVProClassForPlayerIndex.Deinitialise();
            RemovePlayer(i);
            ReentrantLock reentrantLock = _renderMutex;
            reentrantLock.lock();
            _renderFree.add(aVProVideoPlayerGetAVProClassForPlayerIndex);
            reentrantLock.unlock();
        }
    }

    private void RemovePlayer(int i) {
        if (this.m_Players.containsKey(Integer.valueOf(i))) {
            this.m_Players.remove(Integer.valueOf(i));
        }
    }

    private AVProVideoPlayer GetAVProClassForPlayerIndex(int i) {
        Map<Integer, AVProVideoPlayer> map = this.m_Players;
        if (map != null ? map.containsKey(Integer.valueOf(i)) : false) {
            return this.m_Players.get(Integer.valueOf(i));
        }
        return null;
    }

    public static void RenderPlayer(int i) {
        int i2;
        if (s_Interface == null) {
            return;
        }
        if (((EGL10) EGLContext.getEGL()).eglGetCurrentContext().equals(EGL10.EGL_NO_CONTEXT)) {
            s_PreviousContextFail = true;
            return;
        }
        if (s_PreviousContextFail && (i2 = s_PreviousDeviceIndex) >= 0) {
            RendererReset(i2);
            s_PreviousContextFail = false;
        }
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex = s_Interface.GetAVProClassForPlayerIndex(i);
        if (aVProVideoPlayerGetAVProClassForPlayerIndex != null) {
            aVProVideoPlayerGetAVProClassForPlayerIndex.Render();
        }
    }

    public static void WaitForNewFramePlayer(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return;
        }
        aVProVideoPlayerGetAVProClassForPlayerIndex.WaitForNewFrame();
    }

    public static void RendererSetupPlayer(int i, int i2) {
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null) {
            return;
        }
        s_PreviousDeviceIndex = i2;
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i);
        if (aVProVideoPlayerGetAVProClassForPlayerIndex != null) {
            int i3 = s_Interface.m_iOpenGLVersion;
            if (i2 == 8) {
                i3 = 2;
            } else if (i2 == 11) {
                i3 = 3;
            }
            aVProVideoPlayerGetAVProClassForPlayerIndex.RendererSetup(i3);
        }
    }

    public static void RendererDestroyPlayers() {
        _renderMutex.lock();
        for (int i = 0; i < _renderFree.size(); i++) {
            AVProVideoPlayer aVProVideoPlayer = _renderFree.get(i);
            if (aVProVideoPlayer != null) {
                aVProVideoPlayer.DeinitialiseRender();
            }
        }
        _renderFree.clear();
        _renderMutex.unlock();
    }

    public static int _GetWidth(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return 0;
        }
        return aVProVideoPlayerGetAVProClassForPlayerIndex.GetWidth();
    }

    public static int _GetHeight(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return 0;
        }
        return aVProVideoPlayerGetAVProClassForPlayerIndex.GetHeight();
    }

    public static int _GetTextureHandle(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return 0;
        }
        return aVProVideoPlayerGetAVProClassForPlayerIndex.GetTextureHandle();
    }

    public static long _GetDuration(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return 0L;
        }
        return aVProVideoPlayerGetAVProClassForPlayerIndex.GetDurationMs();
    }

    public static int _GetLastErrorCode(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return 0;
        }
        return aVProVideoPlayerGetAVProClassForPlayerIndex.GetLastErrorCode();
    }

    public static int _GetFrameCount(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return 0;
        }
        return aVProVideoPlayerGetAVProClassForPlayerIndex.GetFrameCount();
    }

    public static float _GetVideoDisplayRate(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return 0.0f;
        }
        return aVProVideoPlayerGetAVProClassForPlayerIndex.GetDisplayRate();
    }

    public static boolean _CanPlay(int i) {
        AVProVideoPlayer aVProVideoPlayerGetAVProClassForPlayerIndex;
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null || (aVProVideoPlayerGetAVProClassForPlayerIndex = aVProMobileVideo.GetAVProClassForPlayerIndex(i)) == null) {
            return false;
        }
        return aVProVideoPlayerGetAVProClassForPlayerIndex.CanPlay();
    }

    public static void RendererReset(int i) {
        AVProMobileVideo aVProMobileVideo = s_Interface;
        if (aVProMobileVideo == null) {
            return;
        }
        Iterator<Map.Entry<Integer, AVProVideoPlayer>> it = aVProMobileVideo.m_Players.entrySet().iterator();
        while (it.hasNext()) {
            RendererSetupPlayer(it.next().getKey().intValue(), i);
        }
    }

    private static int getGlVersionFromDeviceConfig(Context context) {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
            if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
                return 3;
            }
            if (deviceConfigurationInfo.reqGlEsVersion >= 131072) {
                return 2;
            }
        }
        return 1;
    }

    private static int getVersionFromPackageManager(Context context) {
        FeatureInfo[] systemAvailableFeatures;
        if (context != null && (systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures()) != null && systemAvailableFeatures.length > 0) {
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if (featureInfo.name == null) {
                    if (featureInfo.reqGlEsVersion != 0) {
                        return getMajorVersion(featureInfo.reqGlEsVersion);
                    }
                    return 1;
                }
            }
        }
        return 1;
    }
}
