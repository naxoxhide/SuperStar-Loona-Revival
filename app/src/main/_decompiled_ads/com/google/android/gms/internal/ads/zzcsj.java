package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcsj extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcsj(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcsj zza(Context context, View view, zzfcr zzfcrVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcsj zzcsjVar = new zzcsj(context);
        if (!zzfcrVar.zzw.isEmpty() && (resources = zzcsjVar.zza.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            zzfcs zzfcsVar = (zzfcs) zzfcrVar.zzw.get(0);
            zzcsjVar.setLayoutParams(new FrameLayout.LayoutParams((int) (zzfcsVar.zza * displayMetrics.density), (int) (zzfcsVar.zzb * displayMetrics.density)));
        }
        zzcsjVar.zzb = view;
        zzcsjVar.addView(view);
        com.google.android.gms.ads.internal.zzt.zzx();
        zzcbt.zzb(zzcsjVar, zzcsjVar);
        com.google.android.gms.ads.internal.zzt.zzx();
        zzcbt.zza(zzcsjVar, zzcsjVar);
        JSONObject jSONObject = zzfcrVar.zzaj;
        RelativeLayout relativeLayout = new RelativeLayout(zzcsjVar.zza);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        if (jSONObjectOptJSONObject != null) {
            zzcsjVar.zzc(jSONObjectOptJSONObject, relativeLayout, 10);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("footer");
        if (jSONObjectOptJSONObject2 != null) {
            zzcsjVar.zzc(jSONObjectOptJSONObject2, relativeLayout, 12);
        }
        zzcsjVar.addView(relativeLayout);
        return zzcsjVar;
    }

    private final int zzb(double d) {
        com.google.android.gms.ads.internal.client.zzay.zzb();
        return zzcam.zzx(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int iZzb = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, iZzb, 0, iZzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY(-iArr[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY(-iArr[1]);
    }
}
