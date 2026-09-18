package com.tnkfactory.ad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.gomfactory.adpie.sdk.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class CloseAdItem {
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterstitialAdItem f2858b;
    public CloseAdListener c;
    public String d;
    public boolean e = false;
    public long f = 0;
    public Handler g = new a(Looper.getMainLooper());
    public c h = new c();
    public d i = new d();

    public static abstract class CloseAdListener {
        public void onCancel() {
        }

        public void onClickAd(AdItem adItem) {
        }

        public abstract void onConfirm();

        public abstract void onError();

        public void onShow(AdItem adItem) {
        }
    }

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            CloseAdItem closeAdItem = CloseAdItem.this;
            if (closeAdItem.e) {
                closeAdItem.c.onError();
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            CloseAdItem closeAdItem = CloseAdItem.this;
            if (closeAdItem.e) {
                closeAdItem.e = false;
                closeAdItem.c.onError();
            }
        }
    }

    public class c extends CloseAdListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ((Activity) CloseAdItem.this.a).finish();
            }
        }

        public class b implements DialogInterface.OnClickListener {
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public c() {
        }

        @Override // com.tnkfactory.ad.CloseAdItem.CloseAdListener
        public final void onConfirm() {
            Context context = CloseAdItem.this.a;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }

        @Override // com.tnkfactory.ad.CloseAdItem.CloseAdListener
        public final void onError() {
            new AlertDialog.Builder(CloseAdItem.this.a).setMessage("앱을 종료하시겠습니까?").setCancelable(false).setNegativeButton(Constants.DEFAULT_DIALOG_FIRST_BUTTON_TEXT, new b()).setPositiveButton(Constants.DEFAULT_DIALOG_THIRD_BUTTON_TEXT, new a()).show();
        }
    }

    public class d extends AdListener {
        public d() {
        }

        @Override // com.tnkfactory.ad.AdListener
        public final String logTag() {
            return super.logTag();
        }

        @Override // com.tnkfactory.ad.AdListener
        public final void onClick(AdItem adItem) {
            super.onClick(adItem);
            CloseAdListener closeAdListener = CloseAdItem.this.c;
            if (closeAdListener != null) {
                closeAdListener.onClickAd(adItem);
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public final void onClose(AdItem adItem, int i) {
            super.onClose(adItem, i);
            if (i == AdListener.CLOSE_SIMPLE) {
                CloseAdItem.this.c.onCancel();
            } else if (i == AdListener.CLOSE_EXIT) {
                CloseAdItem.this.c.onConfirm();
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public final void onError(AdItem adItem, AdError adError) {
            super.onError(adItem, adError);
            CloseAdItem closeAdItem = CloseAdItem.this;
            if (closeAdItem.e) {
                closeAdItem.c.onError();
                CloseAdItem.this.e = false;
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public final void onLoad(AdItem adItem) {
            super.onLoad(adItem);
            if (CloseAdItem.this.e) {
                adItem.show();
                CloseAdItem.this.e = false;
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public final void onShow(AdItem adItem) {
            super.onShow(adItem);
            CloseAdItem closeAdItem = CloseAdItem.this;
            closeAdItem.e = false;
            CloseAdListener closeAdListener = closeAdItem.c;
            if (closeAdListener != null) {
                closeAdListener.onShow(adItem);
            }
            CloseAdItem.this.a();
            CloseAdItem.this.f2858b.load();
        }

        @Override // com.tnkfactory.ad.AdListener
        public final void onVideoCompletion(AdItem adItem, int i) {
            super.onVideoCompletion(adItem, i);
        }
    }

    public CloseAdItem(Context context, String str) {
        this.a = context;
        this.d = str;
        a();
    }

    public final void a() {
        this.f2858b = new InterstitialAdItem(this.a, this.d);
        this.g = new b(Looper.getMainLooper());
        this.f2858b.setListener(this.i);
    }

    public void load() {
        this.f2858b.load();
    }

    public void setListener(CloseAdListener closeAdListener) {
        this.c = closeAdListener;
    }

    public void show() {
        if (this.f > System.currentTimeMillis() - 200) {
            return;
        }
        this.f = System.currentTimeMillis();
        if (this.c == null) {
            this.c = this.h;
        }
        if (this.e) {
            return;
        }
        this.e = false;
        if (this.f2858b.isLoaded()) {
            this.f2858b.show();
        } else {
            this.e = true;
            this.g.sendEmptyMessageDelayed(0, 500L);
        }
    }

    public void show(CloseAdListener closeAdListener) {
        this.c = closeAdListener;
        show();
    }
}
