package com.igaworks.adpopcorn.a.f;

import android.content.Context;
import com.igaworks.adpopcorn.cores.common.h;
import com.igaworks.adpopcorn.cores.model.APClientRewardItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String l;
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1490b;
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private long h = 0;
    private String i;
    private StackTraceElement[] j;
    private Context k;

    public c(Context context, String str) {
        this.k = context;
        this.a = "[" + str + "]";
        this.i = "HTTP Response = " + this.a;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.j = stackTrace;
        h.a(context, "[REWARD]", stackTrace, this.i, 2);
    }

    public List<APClientRewardItem> a() {
        try {
            JSONArray jSONArray = new JSONArray(this.a);
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < jSONArray.length(); i++) {
                jSONObject = jSONArray.getJSONObject(i);
            }
            this.f1490b = jSONObject.getBoolean("Result");
            this.c = jSONObject.getInt("ResultCode");
            this.d = jSONObject.getString("ResultMsg");
            this.e = jSONObject.getString("ClientVerify");
            this.f = jSONObject.getString("Signed");
            this.g = jSONObject.getString("USN");
            if (jSONObject.has("Quantity")) {
                this.h = jSONObject.getLong("Quantity");
            }
            if (!this.f1490b || !this.e.equals(l)) {
                this.i = "Result" + String.valueOf(this.f1490b);
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                this.j = stackTrace;
                h.a(this.k, "[REWARD]", stackTrace, this.i, 2);
                String str = "Error Code = " + String.valueOf(100);
                this.i = str;
                h.a(this.k, "[REWARD]", this.j, str, 2);
                return null;
            }
            this.i = "Result = " + String.valueOf(this.f1490b);
            StackTraceElement[] stackTrace2 = new Throwable().getStackTrace();
            this.j = stackTrace2;
            h.a(this.k, "[REWARD]", stackTrace2, this.i, 2);
            int i2 = this.c;
            if (i2 == 1) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("RewardInfos");
                ArrayList arrayList = new ArrayList(jSONArray2.length());
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    if (jSONObject2.has("Quantity")) {
                        this.h = jSONObject2.getLong("Quantity");
                    }
                    arrayList.add(new com.igaworks.adpopcorn.a.h.b.a(this.k, jSONObject2.getString("CampaignKey"), jSONObject2.getString("CampaignName"), jSONObject2.getString("ItemName"), jSONObject2.getString("RTID"), this.e, this.h));
                }
                this.i = "Result Code = " + String.valueOf(1);
                StackTraceElement[] stackTrace3 = new Throwable().getStackTrace();
                this.j = stackTrace3;
                h.a(this.k, "[REWARD]", stackTrace3, this.i, 2);
                return arrayList;
            }
            if (i2 == 100 || i2 == 1000 || i2 == 1100 || i2 == 5000) {
                this.i = "Error Code = " + String.valueOf(this.c);
                StackTraceElement[] stackTrace4 = new Throwable().getStackTrace();
                this.j = stackTrace4;
                h.a(this.k, "[REWARD]", stackTrace4, this.i, 2);
                return null;
            }
            this.i = "Undefined Error Code";
            StackTraceElement[] stackTrace5 = new Throwable().getStackTrace();
            this.j = stackTrace5;
            h.a(this.k, "[REWARD]", stackTrace5, this.i, 2);
            String str2 = "Error Code = " + String.valueOf(100);
            this.i = str2;
            h.a(this.k, "[REWARD]", this.j, str2, 2);
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            this.i = "JSONException";
            StackTraceElement[] stackTrace6 = new Throwable().getStackTrace();
            this.j = stackTrace6;
            h.a(this.k, "[REWARD]", stackTrace6, this.i, 0);
            throw e;
        }
    }

    public String b() {
        this.i = "mMessage = " + this.d;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.j = stackTrace;
        h.a(this.k, "[REWARD]", stackTrace, this.i, 2);
        return this.d;
    }

    public String c() {
        this.i = "mClientVerify = " + this.e;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.j = stackTrace;
        h.a(this.k, "[REWARD]", stackTrace, this.i, 2);
        return this.e;
    }

    public boolean d() {
        this.i = "mResult = " + String.valueOf(this.f1490b);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.j = stackTrace;
        h.a(this.k, "[REWARD]", stackTrace, this.i, 2);
        return this.f1490b;
    }

    public int e() {
        this.i = "mResultCode = " + String.valueOf(this.c);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.j = stackTrace;
        h.a(this.k, "[REWARD]", stackTrace, this.i, 2);
        return this.c;
    }

    public String f() {
        this.i = "mSigned = " + this.f;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.j = stackTrace;
        h.a(this.k, "[REWARD]", stackTrace, this.i, 2);
        return this.f;
    }

    public String g() {
        this.i = "mUSN = " + this.g;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        this.j = stackTrace;
        h.a(this.k, "[REWARD]", stackTrace, this.i, 2);
        return this.g;
    }
}
