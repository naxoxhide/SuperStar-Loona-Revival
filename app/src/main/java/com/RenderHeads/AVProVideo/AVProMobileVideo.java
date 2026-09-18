package com.RenderHeads.AVProVideo;

import android.content.Context;

public class AVProMobileVideo {
    public static final int MEDIAPLAYER = 1;
    public static final int EXOPLAYER = 2;
    private static AVProMobileVideo s_Interface = null;

    public AVProMobileVideo() {
        s_Interface = this;
    }

    public static void Deinitialise() {
        s_Interface = null;
    }

    public void SetContext(Context context) {}
    public String GetPluginVersion() { return "1.10.1"; }
    public Object CreatePlayer(int i, boolean z, boolean z2, int i2, boolean z3) {
        return null;
    }
    public void DestroyPlayer(int i) {}
    public static void RenderPlayer(int i) {}
    public static void WaitForNewFramePlayer(int i) {}
    public static void RendererSetupPlayer(int i, int i2) {}
    public static void RendererDestroyPlayers() {}
    public static int _GetWidth(int i) { return 0; }
    public static int _GetHeight(int i) { return 0; }
    public static int _GetTextureHandle(int i) { return 0; }
    public static long _GetDuration(int i) { return 0L; }
    public static int _GetLastErrorCode(int i) { return 0; }
    public static int _GetFrameCount(int i) { return 0; }
    public static float _GetVideoDisplayRate(int i) { return 0.0f; }
    public static boolean _CanPlay(int i) { return false; }
    public static void RendererReset(int i) {}
}
