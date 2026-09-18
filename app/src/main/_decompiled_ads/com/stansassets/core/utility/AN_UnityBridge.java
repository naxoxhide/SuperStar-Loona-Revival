package com.stansassets.core.utility;

import android.app.Activity;
import android.os.Handler;
import android.os.StrictMode;
import com.facebook.internal.security.CertificateUtil;
import com.google.gson.Gson;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes4.dex */
public class AN_UnityBridge {
    public static Activity currentActivity;
    private static Gson gson;
    private static Handler unityMainThreadHandler;

    public static void RegisterMessageHandler() {
        AN_Logger.Log("Handler registered");
        if (unityMainThreadHandler == null) {
            unityMainThreadHandler = new Handler();
            currentActivity = UnityPlayer.currentActivity;
        }
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        AN_Logger.Log("StrictMode set");
    }

    private static void RunOnUnityThread(Runnable runnable) {
        Handler handler = unityMainThreadHandler;
        if (handler == null || runnable == null) {
            return;
        }
        try {
            if (handler.getLooper().getThread().isAlive()) {
                unityMainThreadHandler.post(runnable);
            }
        } catch (Exception unused) {
            AN_Logger.LogError("Can't post on a unityMainThreadHandler");
        }
    }

    public static void sendCallback(AN_CallbackJsonHandler aN_CallbackJsonHandler, Object obj) {
        sendCallback(aN_CallbackJsonHandler, obj, false);
    }

    public static void sendCallback(final AN_CallbackJsonHandler aN_CallbackJsonHandler, final Object obj, final boolean z) {
        RunOnUnityThread(new Runnable() { // from class: com.stansassets.core.utility.AN_UnityBridge.1
            @Override // java.lang.Runnable
            public void run() {
                aN_CallbackJsonHandler.onHandleResult(AN_UnityBridge.GetGson().toJson(obj), z);
            }
        });
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) GetGson().fromJson(str, (Class) cls);
    }

    public static String toJson(Object obj) {
        return GetGson().toJson(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Gson GetGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    private static void PrintingStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            AN_Logger.Log("\tat " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")");
        }
    }
}
