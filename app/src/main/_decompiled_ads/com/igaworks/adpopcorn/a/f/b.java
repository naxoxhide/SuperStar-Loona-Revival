package com.igaworks.adpopcorn.a.f;

import android.content.Context;
import com.igaworks.adpopcorn.cores.common.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1489b;
    private int c;
    private String d;
    private String e;
    private StackTraceElement[] f;
    private Context g;

    public b(Context context, String str) {
        this.g = context;
        this.a = "[" + str + "]";
        this.e = "HTTP Response = " + this.a;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.f = stackTrace;
        h.a(context, "[REWARD]", stackTrace, this.e, 2);
    }

    public int a() throws JSONException {
        try {
            JSONArray jSONArray = new JSONArray(this.a);
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < jSONArray.length(); i++) {
                jSONObject = jSONArray.getJSONObject(i);
            }
            jSONObject.getBoolean("IsTest");
            this.f1489b = jSONObject.getBoolean("Result");
            this.c = jSONObject.getInt("ResultCode");
            this.d = jSONObject.getString("ResultMsg");
            if (!this.f1489b) {
                this.e = "Result" + String.valueOf(this.f1489b);
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                this.f = stackTrace;
                h.a(this.g, "[REWARD]", stackTrace, this.e, 2);
                String str = "Error Code = " + String.valueOf(100);
                this.e = str;
                h.a(this.g, "[REWARD]", this.f, str, 2);
                return 100;
            }
            this.e = "Result = " + String.valueOf(this.f1489b);
            StackTraceElement[] stackTrace2 = new Throwable().getStackTrace();
            this.f = stackTrace2;
            h.a(this.g, "[REWARD]", stackTrace2, this.e, 2);
            int i2 = this.c;
            if (i2 == 1) {
                this.e = "Error Code = " + String.valueOf(1);
                StackTraceElement[] stackTrace3 = new Throwable().getStackTrace();
                this.f = stackTrace3;
                h.a(this.g, "[REWARD]", stackTrace3, this.e, 2);
                return 1;
            }
            if (i2 == 100) {
                this.e = "Error Code = " + String.valueOf(100);
                StackTraceElement[] stackTrace4 = new Throwable().getStackTrace();
                this.f = stackTrace4;
                h.a(this.g, "[REWARD]", stackTrace4, this.e, 2);
                return 100;
            }
            if (i2 == 1000) {
                this.e = "Error Code = " + String.valueOf(1000);
                StackTraceElement[] stackTrace5 = new Throwable().getStackTrace();
                this.f = stackTrace5;
                h.a(this.g, "[REWARD]", stackTrace5, this.e, 2);
                return 1000;
            }
            if (i2 == 1100) {
                this.e = "Error Code = " + String.valueOf(1100);
                StackTraceElement[] stackTrace6 = new Throwable().getStackTrace();
                this.f = stackTrace6;
                h.a(this.g, "[REWARD]", stackTrace6, this.e, 2);
                return 1100;
            }
            if (i2 == 5000) {
                this.e = "Error Code = " + String.valueOf(5000);
                StackTraceElement[] stackTrace7 = new Throwable().getStackTrace();
                this.f = stackTrace7;
                h.a(this.g, "[REWARD]", stackTrace7, this.e, 2);
                return 5000;
            }
            this.e = "Undefined Error Code";
            StackTraceElement[] stackTrace8 = new Throwable().getStackTrace();
            this.f = stackTrace8;
            h.a(this.g, "[REWARD]", stackTrace8, this.e, 2);
            String str2 = "Error Code = " + String.valueOf(100);
            this.e = str2;
            h.a(this.g, "[REWARD]", this.f, str2, 2);
            return 100;
        } catch (JSONException e) {
            e.printStackTrace();
            this.e = "JSONException";
            StackTraceElement[] stackTrace9 = new Throwable().getStackTrace();
            this.f = stackTrace9;
            h.a(this.g, "[REWARD]", stackTrace9, this.e, 0);
            throw e;
        }
    }

    public String b() {
        this.e = "mMessage = " + this.d;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.f = stackTrace;
        h.a(this.g, "[REWARD]", stackTrace, this.e, 2);
        return this.d;
    }

    public boolean c() {
        this.e = "mResult = " + String.valueOf(this.f1489b);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.f = stackTrace;
        h.a(this.g, "[REWARD]", stackTrace, this.e, 2);
        return this.f1489b;
    }

    public int d() {
        this.e = "mResultCode = " + String.valueOf(this.c);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.f = stackTrace;
        h.a(this.g, "[REWARD]", stackTrace, this.e, 2);
        return this.c;
    }
}
