package com.tnkfactory.ad.pub;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.facebook.internal.security.CertificateUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.pub.a.f1;
import com.tnkfactory.ad.pub.a.g1;
import com.tnkfactory.ad.pub.a.h1;
import com.tnkfactory.ad.pub.a.i1;
import com.tnkfactory.ad.pub.model.EvtTrackUrls;
import com.tnkfactory.ad.pub.model.Vdo_iconsVO;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends SurfaceView implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, SurfaceHolder.Callback {
    public MediaPlayer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioManager f2916b;
    public boolean c;
    public boolean d;
    public boolean e;
    public float f;
    public Object g;
    public int h;
    public int i;
    public int j;
    public String k;
    public d.j l;
    public CountDownTimer m;
    public boolean n;
    public long o;

    public class a extends CountDownTimer {
        public final /* synthetic */ com.tnkfactory.ad.pub.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f2917b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ ImageView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, com.tnkfactory.ad.pub.a aVar, long j2, Context context, ImageView imageView) {
            super(j, 300L);
            this.a = aVar;
            this.f2917b = j2;
            this.c = context;
            this.d = imageView;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            e.this.b();
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            ArrayList<Vdo_iconsVO> arrayList;
            int i;
            int i2;
            EvtTrackUrls evtTrackUrls;
            e eVar = e.this;
            MediaPlayer mediaPlayer = eVar.a;
            if (mediaPlayer != null) {
                eVar.o = mediaPlayer.getCurrentPosition();
                int i3 = (int) (e.this.o / 1000);
                this.a.getClass();
                int i4 = i3 + 0;
                long j2 = this.f2917b;
                if (j2 > 0) {
                    e eVar2 = e.this;
                    if (eVar2.o / 1000 >= j2 && !eVar2.n && (evtTrackUrls = this.a.g0) != null && !evtTrackUrls.progress.isEmpty()) {
                        com.tnkfactory.ad.pub.c.a.a().a(this.a.g0.progress);
                        e.this.n = true;
                    }
                }
                ArrayList<Vdo_iconsVO> arrayList2 = this.a.h0;
                if (arrayList2 == null || arrayList2.size() == 0 || this.a.h0.size() < i4 + 1) {
                    return;
                }
                e eVar3 = e.this;
                Context context = this.c;
                com.tnkfactory.ad.pub.a aVar = this.a;
                ImageView imageView = this.d;
                eVar3.getClass();
                if (imageView == null || (arrayList = aVar.h0) == null || arrayList.get(i4).program.equals("ad") || aVar.h0.get(i4).program.equals("ad_1") || aVar.h0.get(i4).program.equals("ad_2")) {
                    return;
                }
                new Thread(new i1(aVar, i4, imageView)).start();
                int iApplyDimension = !TextUtils.isEmpty(aVar.h0.get(i4).width) ? (int) TypedValue.applyDimension(0, Integer.parseInt(aVar.h0.get(i4).width), context.getResources().getDisplayMetrics()) : -1;
                int iApplyDimension2 = TextUtils.isEmpty(aVar.h0.get(i4).height) ? -1 : (int) TypedValue.applyDimension(0, Integer.parseInt(aVar.h0.get(i4).height), context.getResources().getDisplayMetrics());
                if (iApplyDimension > 0 || iApplyDimension2 > 0) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension2);
                    if (!TextUtils.isEmpty(aVar.h0.get(i4).xPosition)) {
                        String str = aVar.h0.get(i4).xPosition;
                        str.getClass();
                        if (!str.equals("left")) {
                            i2 = str.equals("right") ? 11 : 9;
                        }
                        layoutParams.addRule(i2);
                    }
                    if (!TextUtils.isEmpty(aVar.h0.get(i4).yPosition)) {
                        String str2 = aVar.h0.get(i4).yPosition;
                        str2.getClass();
                        if (!str2.equals(TJAdUnitConstants.String.BOTTOM)) {
                            i = str2.equals("top") ? 10 : 12;
                        }
                        layoutParams.addRule(i);
                    }
                    if (aVar.h0.get(i4).program.equals("skip")) {
                        imageView.setClickable(true);
                    }
                    imageView.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public e(Context context) {
        super(context);
        this.a = null;
        this.f2916b = null;
        this.c = false;
        this.d = false;
        this.e = true;
        this.f = 0.5f;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = 0L;
        c();
    }

    public static long a(String str) {
        long j;
        String str2;
        if (str == null) {
            return 0L;
        }
        String[] strArrSplit = str.split(CertificateUtil.DELIMITER);
        if (strArrSplit.length == 0) {
            return 0L;
        }
        try {
            if (strArrSplit.length == 3) {
                int iIndexOf = strArrSplit[2].indexOf(".");
                if (iIndexOf != -1) {
                    strArrSplit[2] = strArrSplit[2].substring(0, iIndexOf);
                }
                j = ((long) (Integer.parseInt(strArrSplit[0]) * 3600)) + 0 + ((long) (Integer.parseInt(strArrSplit[1]) * 60));
                str2 = strArrSplit[2];
            } else {
                if (strArrSplit.length != 2) {
                    return 0L;
                }
                j = ((long) (Integer.parseInt(strArrSplit[0]) * 60)) + 0;
                str2 = strArrSplit[1];
            }
            return ((long) Integer.parseInt(str2)) + j;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private float getCurrentVolume() {
        return this.f2916b.getStreamVolume(3) / this.f2916b.getStreamMaxVolume(3);
    }

    public final void a() {
        Object obj;
        if (this.d) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26 || (obj = this.g) == null) {
            this.f2916b.abandonAudioFocus(null);
        } else {
            this.f2916b.abandonAudioFocusRequest((AudioFocusRequest) obj);
        }
    }

    public final void a(com.tnkfactory.ad.pub.a aVar, ImageView imageView, Context context) {
        if (aVar == null) {
            return;
        }
        long jA = 0;
        ArrayList<String> arrayList = aVar.g0.offset;
        if (arrayList != null || !arrayList.get(0).isEmpty()) {
            a(aVar.i0);
            EvtTrackUrls evtTrackUrls = aVar.g0;
            if (evtTrackUrls.progress != null && !evtTrackUrls.offset.isEmpty()) {
                jA = a(aVar.g0.offset.get(0));
            }
        }
        b();
        this.m = new a(this.a.getDuration(), aVar, jA, context, imageView).start();
    }

    public final void b() {
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void c() {
        getHolder().addCallback(this);
        this.f2916b = (AudioManager) getContext().getSystemService("audio");
    }

    public final void d() {
        int i;
        if (this.a == null || (i = this.h) == 0 || i == 1) {
            return;
        }
        this.h = 3;
        if (!this.d) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).build();
                this.g = audioFocusRequestBuild;
                this.f2916b.requestAudioFocus(audioFocusRequestBuild);
            } else {
                this.f2916b.requestAudioFocus(null, 3, 1);
            }
        }
        this.a.setOnPreparedListener(new h1());
        this.a.start();
        d.j jVar = this.l;
        if (jVar != null) {
            int duration = this.a.getDuration();
            d.C0533d c0533d = (d.C0533d) jVar;
            d.this.q = true;
            d dVar = d.this;
            dVar.m = false;
            dVar.k = duration;
            dVar.removeCallbacks(dVar.G);
            d dVar2 = d.this;
            dVar2.postDelayed(dVar2.G, 200L);
            ToggleButton toggleButton = d.this.d;
            if (toggleButton != null) {
                toggleButton.setChecked(true);
                d.this.a(700L);
            }
            d dVar3 = d.this;
            d.k kVar = dVar3.t;
            if (kVar != null && !dVar3.w) {
                dVar3.w = true;
                ((b.a) kVar).a(0);
                EvtTrackUrls evtTrackUrls = d.this.C.g0;
                if (evtTrackUrls != null && !evtTrackUrls.start.isEmpty()) {
                    com.tnkfactory.ad.pub.c.a.a().a(d.this.C.g0.start);
                }
            }
            d dVar4 = d.this;
            dVar4.f2912b.setVolumeOn(true ^ dVar4.p);
            d dVar5 = d.this;
            if (dVar5.C.g0 != null) {
                dVar5.setPanelVisible(false);
                d dVar6 = d.this;
                dVar6.f2912b.a(dVar6.C, dVar6.g, c0533d.a);
            }
            ArrayList<Vdo_iconsVO> arrayList = d.this.C.h0;
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            d dVar7 = d.this;
            d.a(dVar7, c0533d.a, dVar7.C, dVar7.f);
        }
    }

    public int getPlayCurrentTime() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return -1;
    }

    public int getPlayTimeLeft() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration() - this.a.getCurrentPosition();
        }
        return -1;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        b();
        a();
        this.h = 5;
        d.j jVar = this.l;
        if (jVar != null) {
            d.C0533d c0533d = (d.C0533d) jVar;
            d.this.q = false;
            d dVar = d.this;
            if (!dVar.l) {
                dVar.r = false;
            }
            d.this.a(-1L);
            TextView textView = d.this.i;
            if (textView != null) {
                textView.setText("");
                EvtTrackUrls evtTrackUrls = d.this.C.g0;
                if (evtTrackUrls != null && !evtTrackUrls.complete.isEmpty()) {
                    com.tnkfactory.ad.pub.c.a.a().a(d.this.C.g0.complete);
                }
            }
            ToggleButton toggleButton = d.this.d;
            if (toggleButton != null) {
                toggleButton.setChecked(false);
                d.this.setPanelVisible(true);
            }
            d dVar2 = d.this;
            d.i iVar = dVar2.s;
            if (iVar != null && !dVar2.l) {
                b.b(((c) iVar).a, dVar2);
            }
            d dVar3 = d.this;
            d.k kVar = dVar3.t;
            if (kVar != null && !dVar3.A) {
                dVar3.A = true;
                ((b.a) kVar).a(100);
            }
        }
        if (!this.c || (mediaPlayer2 = this.a) == null) {
            return;
        }
        mediaPlayer2.start();
        this.a.seekTo(0);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        d.j jVar = this.l;
        if (jVar == null) {
            return false;
        }
        d.C0533d c0533d = (d.C0533d) jVar;
        com.tnkfactory.ad.pub.a aVar = d.this.C;
        if (aVar == null || TextUtils.isEmpty(aVar.j0)) {
            return false;
        }
        if (i != 1 && i != 100) {
            return false;
        }
        d dVar = d.this;
        d.a(dVar, i2, dVar.C.j0);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.h = 2;
        this.a.seekTo(0);
        d.j jVar = this.l;
        if (jVar != null) {
            d dVar = d.this;
            if (dVar.m || dVar.l) {
                dVar.f2912b.d();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.i = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.j = videoHeight;
        if (this.i == 0 || videoHeight == 0) {
            return;
        }
        getHolder().setFixedSize(this.i, this.j);
        requestLayout();
        d.j jVar = this.l;
        if (jVar != null) {
            int i3 = this.i;
            int i4 = this.j;
            d dVar = d.this;
            if (dVar.n) {
                float width = dVar.getWidth();
                float height = dVar.getHeight();
                int paddingRight = dVar.getPaddingRight() + dVar.getPaddingLeft();
                RelativeLayout.LayoutParams layoutParams = dVar.c;
                float f = width - ((paddingRight + layoutParams.leftMargin) + layoutParams.rightMargin);
                int paddingBottom = dVar.getPaddingBottom() + dVar.getPaddingTop();
                RelativeLayout.LayoutParams layoutParams2 = dVar.c;
                float f2 = height - ((paddingBottom + layoutParams2.topMargin) + layoutParams2.bottomMargin);
                float f3 = i3;
                float f4 = i4;
                float f5 = f / f2 > f3 / f4 ? f2 / f4 : f / f3;
                layoutParams2.width = (int) (f3 * f5);
                layoutParams2.height = (int) (f5 * f4);
                dVar.a.setLayoutParams(layoutParams2);
                dVar.a.requestLayout();
            }
        }
    }

    public void setLooping(boolean z) {
        this.c = z;
    }

    public void setMediaPath(String str) {
        this.k = str;
    }

    public void setMute(boolean z) {
        this.d = z;
    }

    public void setVideoPlayListener(d.j jVar) {
        this.l = jVar;
    }

    public void setVolumeOn(boolean z) {
        boolean z2;
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null || this.d || this.e == z) {
            return;
        }
        if (z) {
            float f = this.f;
            mediaPlayer.setVolume(f, f);
            z2 = true;
        } else {
            this.f = getCurrentVolume();
            this.a.setVolume(0.0f, 0.0f);
            z2 = false;
        }
        this.e = z2;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e4 A[EXC_TOP_SPLITTER, PHI: r6
      0x00e4: PHI (r6v10 java.io.FileInputStream) = (r6v9 java.io.FileInputStream), (r6v11 java.io.FileInputStream) binds: [B:41:0x00e2, B:35:0x00c6] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (this) {
            if (this.k != null && this.a == null) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        this.a = mediaPlayer;
                        mediaPlayer.setDisplay(getHolder());
                        this.a.setScreenOnWhilePlaying(true);
                        if (this.d || !this.e) {
                            this.e = false;
                            this.f = 0.0f;
                            this.a.setVolume(0.0f, 0.0f);
                        } else {
                            this.e = true;
                            this.f = getCurrentVolume();
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.a.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build());
                        } else {
                            this.a.setAudioStreamType(3);
                        }
                        this.a.setOnBufferingUpdateListener(new f1(this));
                        this.a.setOnPreparedListener(this);
                        this.a.setOnCompletionListener(this);
                        this.a.setOnVideoSizeChangedListener(this);
                        this.a.setOnErrorListener(this);
                        this.a.setOnBufferingUpdateListener(new g1(this));
                        if (this.k.startsWith("http://") || this.k.startsWith("https://")) {
                            this.a.setDataSource(this.k);
                        } else {
                            fileInputStream = new FileInputStream(this.k);
                            try {
                                this.a.setDataSource(fileInputStream.getFD());
                                fileInputStream2 = fileInputStream;
                            } catch (Exception e) {
                                e = e;
                                fileInputStream2 = fileInputStream;
                                Logger.e("error #2901 : " + e);
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                throw th;
                            }
                        }
                        this.a.prepareAsync();
                        this.h = 1;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                    } catch (Throwable th3) {
                        fileInputStream = fileInputStream2;
                        th = th3;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ClipDrawable clipDrawable;
        if (this.a != null) {
            d.j jVar = this.l;
            if (jVar != null) {
                d.C0533d c0533d = (d.C0533d) jVar;
                d.this.q = false;
                ImageView imageView = d.this.h;
                if (imageView != null && (clipDrawable = (ClipDrawable) imageView.getDrawable()) != null) {
                    clipDrawable.setLevel(0);
                }
                TextView textView = d.this.i;
                if (textView != null) {
                    textView.setText("");
                }
                ToggleButton toggleButton = d.this.d;
                if (toggleButton != null) {
                    toggleButton.setChecked(false);
                    d.this.setPanelVisible(true);
                }
            }
            this.a.reset();
            this.a.release();
            this.a = null;
            b();
        }
        a();
    }
}
