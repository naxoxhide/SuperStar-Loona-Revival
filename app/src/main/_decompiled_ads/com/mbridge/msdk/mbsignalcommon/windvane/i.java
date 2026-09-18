package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: WindVaneSignalCommunication.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements Handler.Callback, c {
    protected Pattern a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f2335b;
    protected Context d;
    protected WindVaneWebView e;
    protected final int c = 1;
    protected Handler f = new Handler(Looper.getMainLooper(), this);

    public i(Context context) {
        this.d = context;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public final void a(WindVaneWebView windVaneWebView) {
        this.e = windVaneWebView;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006c  */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public final void b(String str) {
        a aVarA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str != null) {
            aVarA = com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.e, str);
            if (aVarA != null) {
                aVarA.a = this.e;
            } else {
                Matcher matcher = this.a.matcher(str);
                if (matcher.matches()) {
                    aVarA = new a();
                    int iGroupCount = matcher.groupCount();
                    if (iGroupCount >= 5) {
                        aVarA.f = matcher.group(5);
                    }
                    if (iGroupCount >= 3) {
                        aVarA.d = matcher.group(1);
                        aVarA.g = matcher.group(2);
                        aVarA.e = matcher.group(3);
                        if (com.mbridge.msdk.mbsignalcommon.base.e.k != null && com.mbridge.msdk.mbsignalcommon.base.e.k.containsKey(aVarA.e)) {
                            aVarA.e = com.mbridge.msdk.mbsignalcommon.base.e.k.get(aVarA.e);
                        }
                        aVarA.a = this.e;
                    } else {
                        aVarA = null;
                    }
                } else {
                    aVarA = null;
                }
            }
        } else {
            aVarA = null;
        }
        if (aVarA == null) {
            return;
        }
        Object jsObject = aVarA.a != null ? aVarA.a.getJsObject(aVarA.d) : null;
        if (jsObject == null) {
            return;
        }
        try {
            com.mbridge.msdk.mbsignalcommon.c.a.d dVarA = com.mbridge.msdk.mbsignalcommon.c.a.a(this.d.getClassLoader(), jsObject.getClass().getName()).a(aVarA.e, Object.class, String.class);
            dVarA.a();
            if (jsObject == null || !(jsObject instanceof h)) {
                return;
            }
            aVarA.f2331b = jsObject;
            aVarA.c = dVarA;
            aVarA.f2331b = jsObject;
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = aVarA;
            this.f.sendMessage(messageObtain);
        } catch (com.mbridge.msdk.mbsignalcommon.c.a.b.C0497a e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
            if (message.what == 1) {
                Object obj = aVar.f2331b;
                com.mbridge.msdk.mbsignalcommon.c.a.d dVar = aVar.c;
                Object[] objArr = new Object[2];
                objArr[0] = aVar;
                objArr[1] = TextUtils.isEmpty(aVar.f) ? JsonUtils.EMPTY_JSON : aVar.f;
                dVar.a(obj, objArr);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public final boolean a(String str) {
        if (!j.a(str)) {
            return false;
        }
        this.a = j.b(str);
        this.f2335b = str;
        return true;
    }
}
