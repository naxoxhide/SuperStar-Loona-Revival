package com.fyber.inneractive.sdk.player.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends MediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public Context a;
    public Handler h;
    public k i;
    public Surface j;
    public SurfaceHolder k;
    public long l;
    public HandlerThread n;
    public Handler o;
    public Runnable p;
    public Runnable q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile com.fyber.inneractive.sdk.player.enums.b f1258b = com.fyber.inneractive.sdk.player.enums.b.Idle;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public int m = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.mediaplayer.a$a, reason: collision with other inner class name */
    public class RunnableC0299a implements Runnable {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1259b;

        public RunnableC0299a(int i, int i2) {
            this.a = i;
            this.f1259b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.i != null) {
                ((com.fyber.inneractive.sdk.player.controller.g) a.this.i).a(new l(String.format(Locale.ENGLISH, "Player Error: %d, %d", Integer.valueOf(this.a), Integer.valueOf(this.f1259b))));
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(a.this);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            IAlog.a("%sCannot wait for video size anymore", a.this.c());
            a aVar = a.this;
            if (aVar.r == 0) {
                IAlog.a("%sCannot wait for video size anymore. duration is still 0 - aborting", aVar.c());
                a aVar2 = a.this;
                aVar2.onError(aVar2, 0, 0);
            } else {
                IAlog.a("%sCannot wait for video size anymore. moving into ready", aVar.c());
                a.this.f = true;
                a.this.d();
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ SurfaceHolder a;

        public d(SurfaceHolder surfaceHolder) {
            this.a = surfaceHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(a.this, this.a);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Surface a;

        public e(Surface surface) {
            this.a = surface;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(a.this, this.a);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(a.this);
            Handler handler = a.this.o;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                a.this.o = null;
            }
            a.this.n = null;
            Looper.myLooper().quit();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.c(a.this);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d(a.this);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            String strC = aVar.c();
            long jCurrentTimeMillis = System.currentTimeMillis();
            aVar.setVolume(0.0f, 0.0f);
            IAlog.d(strC + "timelog: " + CampaignEx.JSON_NATIVE_VIDEO_MUTE + " took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
        }
    }

    public interface k {
    }

    public static class l extends Exception {
        public l(String str) {
            super(str);
        }

        public l(Throwable th, String str) {
            super(str, th);
        }
    }

    public a(Context context, k kVar, Handler handler) {
        this.a = context;
        this.i = kVar;
        this.h = handler;
        setOnPreparedListener(this);
        setOnErrorListener(this);
        setOnSeekCompleteListener(this);
        setOnVideoSizeChangedListener(this);
        super.setOnCompletionListener(this);
        a();
    }

    public static void c(a aVar) {
        String strC = aVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.fyber.inneractive.sdk.player.enums.b bVar = aVar.f1258b;
        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Paused || bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared || bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Start_in_progress) {
            super.start();
            aVar.a(com.fyber.inneractive.sdk.player.enums.b.Playing);
        } else {
            IAlog.a("%s Start called in wrong mState! %s", aVar.c(), bVar);
            if (aVar.f1258b == com.fyber.inneractive.sdk.player.enums.b.Seeking) {
                aVar.c = true;
            }
        }
        IAlog.d(strC + "timelog: start took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
    }

    public static void d(a aVar) {
        String strC = aVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (super.isPlaying()) {
            super.pause();
        } else {
            IAlog.a("%s paused called cannot set to pause, canceled", aVar.c());
        }
        IAlog.d(strC + "timelog: delayed pause took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
    }

    public boolean b() {
        return (this.f1258b == com.fyber.inneractive.sdk.player.enums.b.Idle || this.f1258b == com.fyber.inneractive.sdk.player.enums.b.Preparing) ? false : true;
    }

    public void e() {
        this.d = true;
        if (b()) {
            a(new j());
        } else {
            IAlog.a("%s mute called when player is not ready!", c());
        }
        IAlog.a("%s mute", c());
    }

    public final void f() {
        String strC = c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.fyber.inneractive.sdk.player.enums.b bVar = this.f1258b;
        com.fyber.inneractive.sdk.player.enums.b bVar2 = com.fyber.inneractive.sdk.player.enums.b.Idle;
        if (bVar == bVar2) {
            IAlog.a("%s reset called, but player is already resetted. Do nothing", c());
            return;
        }
        a(bVar2);
        try {
            super.reset();
        } catch (Exception unused) {
        }
        IAlog.d(strC + "timelog: reset took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
    }

    @Override // android.media.MediaPlayer
    public int getCurrentPosition() {
        if (b()) {
            return super.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.media.MediaPlayer
    public int getDuration() {
        return this.r;
    }

    @Override // android.media.MediaPlayer
    public int getVideoHeight() {
        return this.t;
    }

    @Override // android.media.MediaPlayer
    public int getVideoWidth() {
        return this.s;
    }

    @Override // android.media.MediaPlayer
    public boolean isPlaying() {
        return b() && this.f1258b != com.fyber.inneractive.sdk.player.enums.b.Paused && super.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        a(com.fyber.inneractive.sdk.player.enums.b.Completed);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        IAlog.e("%s onError code = %d code2 = %d", c(), Integer.valueOf(i2), Integer.valueOf(i3));
        f();
        this.h.post(new RunnableC0299a(i2, i3));
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        IAlog.a("%s onPrepared %s gotPrepared = %s", c(), this, Boolean.valueOf(this.g));
        IAlog.a("%sMedia prepare time took %d msec", c(), Long.valueOf(System.currentTimeMillis() - this.l));
        if (this.f1258b != com.fyber.inneractive.sdk.player.enums.b.Preparing && this.f1258b != com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            IAlog.e("%s onPrepared: previous error encountered. Aborting", c());
        } else if (this.g) {
            IAlog.a("%s onPrepared called again??? We are already prepared", c());
        } else {
            this.g = true;
            d();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        IAlog.a("%s onSeekComplete called current position = %d", c(), Integer.valueOf(mediaPlayer.getCurrentPosition()));
        if (this.f1258b != com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            IAlog.a("%s onSeekComplete called when Story is not seeking", c());
            return;
        }
        if (this.d) {
            e();
        }
        if (!this.c) {
            IAlog.a("%s onSeekComplete mPlayAfterSeek = false", c());
            a(com.fyber.inneractive.sdk.player.enums.b.Paused);
        } else {
            IAlog.a("%s onSeekComplete mPlayAfterSeek = true", c());
            this.f1258b = com.fyber.inneractive.sdk.player.enums.b.Paused;
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        IAlog.a("%s onVideoSizeChanged %d, %d", c(), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.f) {
            return;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            m.f1343b.removeCallbacks(runnable);
            IAlog.a("%s onVideoSizeChanged cancelling prepared runnable", c());
        }
        this.f = true;
        if (i2 == 0 || i3 == 0) {
            IAlog.e("%s onVideoSizeChanged - Invalid video size!", c());
            onError(this, 0, 0);
        } else {
            IAlog.a("%sMedia got video size time took %d msec", c(), Long.valueOf(System.currentTimeMillis() - this.l));
            this.s = i2;
            this.t = i3;
            d();
        }
    }

    @Override // android.media.MediaPlayer
    public void pause() {
        if (this.f1258b != com.fyber.inneractive.sdk.player.enums.b.Idle && this.f1258b != com.fyber.inneractive.sdk.player.enums.b.Completed) {
            com.fyber.inneractive.sdk.player.enums.b bVar = this.f1258b;
            com.fyber.inneractive.sdk.player.enums.b bVar2 = com.fyber.inneractive.sdk.player.enums.b.Paused;
            if (bVar != bVar2 && this.f1258b != com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                a(bVar2);
                if (b()) {
                    a(new i());
                } else {
                    IAlog.a("%s paused called when player is not ready!", c());
                }
                IAlog.a("%s pause", c());
                return;
            }
        }
        IAlog.a("%s paused called when player is in mState: %s ignoring", c(), this.f1258b);
    }

    @Override // android.media.MediaPlayer
    public void release() {
        if (!this.e) {
            a(new f());
        }
        this.i = null;
        this.q = null;
        this.e = true;
        IAlog.a("%s release called", c());
    }

    @Override // android.media.MediaPlayer
    public void reset() {
        IAlog.a("%s reset called", c());
        Runnable runnable = this.p;
        if (runnable != null) {
            m.f1343b.removeCallbacks(runnable);
        }
        a(new g());
    }

    @Override // android.media.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        IAlog.a("%s setDisplay called", c());
        if (!b()) {
            IAlog.a("%s setDisplay called when player is not ready!", c());
            return;
        }
        SurfaceHolder surfaceHolder2 = this.k;
        if (surfaceHolder2 != null && surfaceHolder2.equals(surfaceHolder)) {
            IAlog.a("%s setDisplay called with existing surface. ignoring!", c());
        } else {
            this.k = surfaceHolder;
            a(new d(surfaceHolder));
        }
    }

    @Override // android.media.MediaPlayer
    public final void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        throw new IllegalAccessError("Please use IAplayerCallbacks to receive completion events");
    }

    @Override // android.media.MediaPlayer
    public void setSurface(Surface surface) {
        IAlog.a("%s setSurface called", c());
        Surface surface2 = this.j;
        if (surface2 != null && surface2.equals(surface)) {
            IAlog.a("%s setSurface called with existing surface. ignoring!", c());
        } else {
            this.j = surface;
            a(new e(surface));
        }
    }

    @Override // android.media.MediaPlayer
    public void start() {
        IAlog.a("%s Start called", c());
        if (!b()) {
            IAlog.a("%s MediaPlayer: Start called when player is not ready! - mState = %s", c(), this.f1258b);
            return;
        }
        if (this.f1258b == com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            this.c = true;
        } else if (isPlaying()) {
            IAlog.a("%s MediaPlayer: Start called when player is already playing. do nothing", c());
        } else {
            a(com.fyber.inneractive.sdk.player.enums.b.Start_in_progress);
            a(new h());
        }
    }

    @Override // android.media.MediaPlayer
    public void stop() {
        String strC = c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (b()) {
            super.stop();
        }
        IAlog.a("%s stop called", c());
        IAlog.d(strC + "timelog: stop took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
    }

    public static void b(a aVar) {
        String strC = aVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        super.release();
        IAlog.d(strC + "timelog: release took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
    }

    public void a(String str) {
        String strC = c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f = false;
        this.g = false;
        if (isPlaying()) {
            IAlog.a("%s loadUri stopping play before refresh", c());
            stop();
        }
        this.l = System.currentTimeMillis();
        f();
        IAlog.a("%s calling setDataSource with %s", c(), str);
        try {
            setDataSource(str);
            IAlog.a("%s setDataSource succeeded, calling prepareAsync", c());
            a(com.fyber.inneractive.sdk.player.enums.b.Preparing);
            try {
                prepareAsync();
            } catch (IllegalStateException e2) {
                IAlog.b("%s prepareAsync failed with illegal mState exception: %s", c(), e2.getMessage());
                this.m++;
                if (this.m < 5) {
                    a(str);
                }
                this.m = 0;
            }
            IAlog.d(strC + "timelog: loadUri took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
        } catch (Exception e3) {
            IAlog.b("%s error setting data source %s", c(), str);
            IAlog.b("%s exception message: %s", c(), e3.getMessage());
        }
    }

    public final void d() {
        if (this.g) {
            if (this.f) {
                IAlog.a("%sMedia load time took %d msec", c(), Long.valueOf(System.currentTimeMillis() - this.l));
                this.r = super.getDuration();
                a(com.fyber.inneractive.sdk.player.enums.b.Prepared);
                if (this.d) {
                    e();
                    return;
                }
                return;
            }
            IAlog.a("%sGot prepared only, waiting for video size", c());
            if (this.p == null) {
                this.p = new c();
            }
            m.f1343b.postDelayed(this.p, 2000L);
        }
    }

    public final String c() {
        return "mp(" + this + "): T:" + Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + ": ";
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("MP-Worker");
        this.n = handlerThread;
        handlerThread.start();
        this.o = new Handler(this.n.getLooper());
        this.q = new b();
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("%s updatePlayerState - %s", c(), bVar);
        if (this.f1258b == bVar) {
            IAlog.a("%s updatePlayerState - mState didn't change!", c());
            return;
        }
        IAlog.a("%s updatePlayerState - changing from %s to %s", c(), this.f1258b, bVar);
        this.f1258b = bVar;
        this.h.post(new com.fyber.inneractive.sdk.player.mediaplayer.b(this, bVar));
    }

    public static void a(a aVar, Surface surface) {
        String strC = aVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        IAlog.a("%s setSurface called with %s", aVar.c(), surface);
        try {
            super.setSurface(surface);
            if (surface == null) {
                IAlog.a("%s setSurface with null! current surface cleared", aVar.c());
            } else {
                IAlog.a("%s setSurface - replacing surface!", aVar.c());
            }
            IAlog.d(strC + "timelog: setSurface took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
        } catch (Exception unused) {
            IAlog.a("%s super.setSurface threw exception!", aVar.c());
        }
    }

    public static void a(a aVar, SurfaceHolder surfaceHolder) {
        String strC = aVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        IAlog.a("%s setDisplay called with %s", aVar.c(), surfaceHolder);
        try {
            super.setDisplay(surfaceHolder);
            if (surfaceHolder == null) {
                IAlog.a("%s setDisplay with null! current display cleared", aVar.c());
            } else {
                IAlog.a("%s setDisplay - replacing surface holder!", aVar.c());
            }
            IAlog.d(strC + "timelog: setDisplayInternal took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
        } catch (Exception unused) {
            IAlog.a("%s super.setDisplay threw exception!", aVar.c());
        }
    }

    public final void a(Runnable runnable) {
        Handler handler;
        Handler handler2;
        HandlerThread handlerThread = this.n;
        if (handlerThread != null && handlerThread.isAlive() && !this.n.isInterrupted() && (handler2 = this.o) != null) {
            handler2.post(runnable);
        }
        if ((this.s == 0 || this.t == 0 || this.r == 0) && (handler = this.o) != null) {
            handler.post(this.q);
        }
    }

    public static void a(a aVar) {
        if (aVar.b()) {
            aVar.s = super.getVideoWidth();
            aVar.t = super.getVideoHeight();
            aVar.r = super.getDuration();
        }
    }
}
