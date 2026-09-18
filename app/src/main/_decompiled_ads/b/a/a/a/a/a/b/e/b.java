package b.a.a.a.a.a.b.e;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: AndroidMediaPlayer.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends b.a.a.a.a.a.b.e.a {
    private final MediaPlayer i;
    private final a j;
    private b.a.a.a.a.a.b.b.a k;
    private Surface l;
    private final Object m;
    private volatile boolean n;

    /* JADX INFO: compiled from: AndroidMediaPlayer.java */
    private static class a implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener {
        private final WeakReference<b> a;

        public a(b bVar) {
            this.a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                b bVar = this.a.get();
                if (bVar != null) {
                    bVar.a(i);
                }
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                b bVar = this.a.get();
                if (bVar != null) {
                    bVar.j();
                }
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "onError: ", Integer.valueOf(i), Integer.valueOf(i2));
                b bVar = this.a.get();
                return bVar != null && bVar.a(i, i2);
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO", "onInfo: ");
                b bVar = this.a.get();
                return bVar != null && bVar.b(i, i2);
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                b bVar = this.a.get();
                if (bVar != null) {
                    bVar.k();
                }
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                b bVar = this.a.get();
                if (bVar != null) {
                    bVar.l();
                }
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                b bVar = this.a.get();
                if (bVar != null) {
                    bVar.a(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.m = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.i = mediaPlayer;
        }
        a(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.j = new a(this);
        n();
    }

    private void a(MediaPlayer mediaPlayer) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19 || i >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(b.a.a.a.a.a.a.c.a(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable th) {
                try {
                    b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    private void n() {
        this.i.setOnPreparedListener(this.j);
        this.i.setOnBufferingUpdateListener(this.j);
        this.i.setOnCompletionListener(this.j);
        this.i.setOnSeekCompleteListener(this.j);
        this.i.setOnVideoSizeChangedListener(this.j);
        this.i.setOnErrorListener(this.j);
        this.i.setOnInfoListener(this.j);
    }

    private void o() {
        b.a.a.a.a.a.b.b.a aVar;
        if (Build.VERSION.SDK_INT < 23 || (aVar = this.k) == null) {
            return;
        }
        try {
            aVar.close();
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
        }
        this.k = null;
    }

    private void p() {
        try {
            Surface surface = this.l;
            if (surface != null) {
                surface.release();
                this.l = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void b(boolean z) throws Throwable {
        this.i.setLooping(z);
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void c(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void d() throws Throwable {
        this.i.pause();
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void e() throws Throwable {
        this.i.stop();
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void f() throws Throwable {
        this.i.start();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        p();
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void g() {
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public long h() {
        try {
            return this.i.getCurrentPosition();
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void i() throws Throwable {
        try {
            this.i.reset();
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "reset error: ", th);
        }
        o();
        m();
        n();
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void release() throws Throwable {
        synchronized (this.m) {
            if (!this.n) {
                this.i.release();
                this.n = true;
                p();
                o();
                m();
                n();
            }
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public int b() {
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // b.a.a.a.a.a.b.e.c
    public int c() {
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.m) {
            try {
                if (!this.n && surfaceHolder != null && surfaceHolder.getSurface() != null && this.h) {
                    this.i.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void a(Surface surface) {
        p();
        this.l = surface;
        this.i.setSurface(surface);
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void a(b.a.a.a.a.a.a.b bVar) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            this.i.setPlaybackParams(this.i.getPlaybackParams().setSpeed(bVar.a()));
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void a(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(ShareInternalUtility.STAGING_PARAM)) {
            this.i.setDataSource(uri.getPath());
        } else {
            this.i.setDataSource(str);
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        this.i.setDataSource(fileDescriptor);
    }

    @Override // b.a.a.a.a.a.b.e.c
    public synchronized void a(b.a.a.a.a.a.a.f.c cVar) {
        this.k = b.a.a.a.a.a.b.b.a.a(b.a.a.a.a.a.a.c.a(), cVar);
        b.a.a.a.a.a.b.b.c.c.a(cVar);
        this.i.setDataSource(this.k);
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void a(boolean z) throws Throwable {
        this.i.setScreenOnWhilePlaying(z);
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void a(long j, int i) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.i.seekTo((int) j);
            return;
        }
        if (i == 0) {
            this.i.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.i.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.i.seekTo((int) j, 2);
        } else if (i != 3) {
            this.i.seekTo((int) j);
        } else {
            this.i.seekTo((int) j, 3);
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public long a() {
        try {
            return this.i.getDuration();
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }
}
