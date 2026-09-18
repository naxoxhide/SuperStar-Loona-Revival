package com.applovin.impl.sdk.network;

import android.text.TextUtils;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.t;
import com.applovin.impl.sdk.x;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.applovin.impl.sdk.e.d {
    private final f aIh;
    private AtomicBoolean aIi;
    private boolean aIj;
    private final x logger;

    g(f fVar, n nVar) {
        super("PersistentPostbackQueueSaveTask", nVar);
        this.aIi = new AtomicBoolean();
        this.aIj = false;
        this.aIh = fVar;
        this.logger = nVar.BL();
    }

    @Override // java.lang.Runnable
    public void run() {
        J(this.aIh.Ip());
    }

    public List<h> gH(int i) {
        ArrayList arrayList = new ArrayList();
        t tVarCa = this.sdk.Ca();
        if (!tVarCa.c("persistent_postback_cache.json", n.getApplicationContext())) {
            x.H("PersistentPostbackQueueSaveTask", "Postbacks queue file does not exist.");
            return arrayList;
        }
        String strA = tVarCa.a(tVarCa.a("persistent_postback_cache.json", n.getApplicationContext()));
        if (TextUtils.isEmpty(strA)) {
            x.H("PersistentPostbackQueueSaveTask", "Postbacks queue file has no content.");
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONObject(strA).getJSONArray("pb");
            if (x.Fk()) {
                this.logger.f("PersistentPostbackQueueSaveTask", "Deserializing " + jSONArray.length() + " postback(s)...");
            }
            arrayList.ensureCapacity(Math.max(1, jSONArray.length()));
            Integer num = (Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNz);
            for (int i2 = 0; i2 < jSONArray.length() && arrayList.size() < i; i2++) {
                try {
                    h hVar = new h(jSONArray.getJSONObject(i2), this.sdk);
                    if (hVar.Ix() < num.intValue()) {
                        arrayList.add(hVar);
                    } else {
                        x.H("PersistentPostbackQueueSaveTask", "Skipping deserialization because maximum attempt count exceeded for postback: " + hVar);
                    }
                } catch (Throwable th) {
                    x.e("PersistentPostbackQueueSaveTask", "Unable to deserialize postback from json", th);
                    this.sdk.Cq().d("PersistentPostbackQueueSaveTask", "deserializePostback", th);
                }
            }
            if (x.Fk()) {
                this.logger.f("PersistentPostbackQueueSaveTask", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            }
        } catch (Throwable th2) {
            x.e("PersistentPostbackQueueSaveTask", "Failed to load postback queue", th2);
            this.sdk.Cq().d("PersistentPostbackQueueSaveTask", "deserializePostbackQueue", th2);
        }
        this.aIj = arrayList.isEmpty();
        return arrayList;
    }

    private void J(List<h> list) {
        if (!(this.aIj && list.isEmpty()) && this.aIi.compareAndSet(false, true)) {
            JSONArray jSONArray = new JSONArray();
            for (h hVar : list) {
                try {
                    jSONArray.put(hVar.IA());
                } catch (Throwable th) {
                    x.e("PersistentPostbackQueueSaveTask", "Unable to serialize postback to JSON: " + hVar, th);
                    this.sdk.Cq().d("PersistentPostbackQueueSaveTask", "serializePostback", th);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pb", jSONArray);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes("UTF-8"));
                t tVarCa = this.sdk.Ca();
                tVarCa.a((InputStream) byteArrayInputStream, tVarCa.a("persistent_postback_cache.json", n.getApplicationContext()), true);
                if (x.Fk()) {
                    this.logger.f("PersistentPostbackQueueSaveTask", "Exported postback queue to disk.");
                }
            } catch (Throwable th2) {
                x.e("PersistentPostbackQueueSaveTask", "Unable to export postbacks to disk: " + jSONArray, th2);
                this.sdk.Cq().d("PersistentPostbackQueueSaveTask", "serializePostbackQueue", th2);
            }
            this.aIi.set(false);
        }
    }
}
