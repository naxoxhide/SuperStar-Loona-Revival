package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@2.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaq implements zzf {
    private final Application zza;
    private final zzas zzb;
    private final Executor zzc;

    public zzaq(Application application, zzas zzasVar, Executor executor) {
        this.zza = application;
        this.zzb = zzasVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzf
    public final Executor zza() {
        return this.zzc;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    @Override // com.google.android.gms.internal.consent_sdk.zzf
    public final boolean zzb(String str, JSONObject jSONObject) {
        byte b2;
        int iHashCode = str.hashCode();
        if (iHashCode != 94746189) {
            if (iHashCode == 113399775 && str.equals("write")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
        } else if (str.equals("clear")) {
            b2 = 1;
        } else {
            b2 = -1;
        }
        if (b2 == 0) {
            zzcp zzcpVar = new zzcp(this.zza);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                Log.d("UserMessagingPlatform", "Writing to storage: [" + next + "] " + String.valueOf(objOpt));
                if (zzcpVar.zzc(next, objOpt)) {
                    this.zzb.zzd().add(next);
                } else {
                    Log.d("UserMessagingPlatform", "Failed writing key: ".concat(String.valueOf(next)));
                }
            }
            this.zzb.zzf();
            zzcpVar.zzb();
            return true;
        }
        if (b2 != 1) {
            return false;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(UserMetadata.KEYDATA_FILENAME);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            Log.d("UserMessagingPlatform", "Action[clear]: wrong args.".concat(String.valueOf(jSONObject.toString())));
        } else {
            HashSet hashSet = new HashSet();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (TextUtils.isEmpty(strOptString)) {
                    Log.d("UserMessagingPlatform", "Action[clear]: empty key at index: " + i);
                } else {
                    hashSet.add(strOptString);
                }
            }
            zzcq.zzb(this.zza, hashSet);
        }
        return true;
    }
}
