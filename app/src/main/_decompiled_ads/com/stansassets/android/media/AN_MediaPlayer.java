package com.stansassets.android.media;

import android.media.MediaPlayer;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.templates.SA_Result;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class AN_MediaPlayer {
    private static AN_CallbackJsonHandler m_closeCallback;

    public static void ShowRemoteVideo(String str, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(str);
            mediaPlayer.prepare();
        } catch (IOException e) {
            AN_Logger.LogError("Failed to prepare a video: " + e.getMessage());
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    public static void onVideoClosed() {
        if (m_closeCallback != null) {
            AN_UnityBridge.sendCallback(m_closeCallback, new SA_Result());
            m_closeCallback = null;
        }
    }
}
