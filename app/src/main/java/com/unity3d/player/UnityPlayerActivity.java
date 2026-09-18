package com.unity3d.player;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class UnityPlayerActivity extends Activity implements IUnityPlayerLifecycleEvents {
    private static boolean sFridaInitialized = false;

    private void initializeFrida() {
        if (sFridaInitialized) return;
        try {
            File targetFile = new File(getFilesDir(), "libscript.js");
            File extFile = new File(getExternalFilesDir(null), "libscript.js");
            InputStream is;
            if (extFile.exists() && extFile.length() > 0) {
                is = new FileInputStream(extFile);
                android.util.Log.i("Frida", "Loading updated libscript.js from: " + extFile.getAbsolutePath());
            } else {
                is = getAssets().open("libscript.js");
            }
            OutputStream os = new FileOutputStream(targetFile);
            byte[] buf = new byte[8192];
            int len;
            while ((len = is.read(buf)) > 0) {
                os.write(buf, 0, len);
            }
            os.close();
            is.close();
            targetFile.setReadable(true, false);
            android.util.Log.i("Frida", "libscript.js successfully extracted to: " + targetFile.getAbsolutePath() + " (" + targetFile.length() + " bytes)");
        } catch (Throwable t) {
            android.util.Log.e("Frida", "Failed to extract libscript.js: " + t.getMessage());
        }

        try {
            System.loadLibrary("frida-gadget");
            sFridaInitialized = true;
            android.util.Log.i("Frida", "libfrida-gadget.so loaded successfully via Java!");
        } catch (Throwable t) {
            android.util.Log.e("Frida", "Failed to load libfrida-gadget: " + t.getMessage());
        }
    }

    protected UnityPlayer mUnityPlayer;

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    protected String updateUnityCommandLineArguments(String cmdLine) {
        return cmdLine;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        initializeFrida();
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        getIntent().putExtra("unity", updateUnityCommandLineArguments(getIntent().getStringExtra("unity")));
        UnityPlayer unityPlayer = new UnityPlayer(this, this);
        this.mUnityPlayer = unityPlayer;
        setContentView(unityPlayer);
        this.mUnityPlayer.requestFocus();
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        this.mUnityPlayer.newIntent(intent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mUnityPlayer.destroy();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (MultiWindowSupport.getAllowResizableWindow(this)) {
            this.mUnityPlayer.pause();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (MultiWindowSupport.getAllowResizableWindow(this)) {
            this.mUnityPlayer.resume();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (MultiWindowSupport.getAllowResizableWindow(this)) {
            return;
        }
        this.mUnityPlayer.pause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (MultiWindowSupport.getAllowResizableWindow(this)) {
            return;
        }
        this.mUnityPlayer.resume();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mUnityPlayer.lowMemory();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == 15) {
            this.mUnityPlayer.lowMemory();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mUnityPlayer.configurationChanged(newConfig);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.mUnityPlayer.windowFocusChanged(hasFocus);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == 2) {
            return this.mUnityPlayer.injectEvent(event);
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return this.mUnityPlayer.injectEvent(event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return this.mUnityPlayer.injectEvent(event);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent event) {
        return this.mUnityPlayer.injectEvent(event);
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent event) {
        return this.mUnityPlayer.injectEvent(event);
    }
}
