package com.tnkfactory.ad.pub.b;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tnkfactory.ad.pub.a.u;
import com.tnkfactory.ad.pub.a.x0;
import com.tnkfactory.framework.crypto.DecryptInputStream;
import com.tnkfactory.framework.crypto.EncryptOutputStream;
import com.tnkfactory.framework.crypto.EncryptUtils;
import com.tnkfactory.framework.crypto.RC4Cryptor;
import com.tnkfactory.framework.vo.ValueObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class o {
    public static final byte[] c = EncryptUtils.toHexBytes("3339306d3f2d336a666c73");
    public f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.tnkfactory.ad.pub.a.g f2910b;

    public o(f fVar, com.tnkfactory.ad.pub.a.g gVar) {
        this.a = fVar;
        this.f2910b = gVar;
    }

    public final Object a(String str, String str2, String str3, Object[] objArr) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setDoOutput(true);
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new x0());
            }
            RC4Cryptor rC4Cryptor = new RC4Cryptor(c);
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(new EncryptOutputStream(httpURLConnection.getOutputStream(), rC4Cryptor.init()));
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            map.put("p", 1);
            map.put("t", str2);
            map.put(InneractiveMediationDefs.GENDER_MALE, str3);
            map.put("a", this.a.a);
            map.put(InneractiveMediationDefs.GENDER_FEMALE, this.a.c);
            map.put("v", this.a.f2906b);
            map.put("s", this.a.d);
            map.put(CampaignEx.JSON_KEY_AD_K, "7.21.7");
            ValueObject valueObjectA = this.a.a();
            com.tnkfactory.ad.pub.a.g gVar = this.f2910b;
            if (gVar != null) {
                gVar.getClass();
                valueObjectA.set(u.a("c47105a9e85c85"), gVar.a);
                valueObjectA.set(u.a("d66a0895ec6e8572e37a"), gVar.f2867b);
                if (gVar.c != null) {
                    valueObjectA.set(u.a("c36015a9ed50856a"), gVar.c);
                }
            }
            arrayList.add(valueObjectA);
            if (objArr != null) {
                for (Object obj : objArr) {
                    arrayList.add(obj);
                }
            }
            n nVar = new n(deflaterOutputStream);
            nVar.writeShort(3);
            Set setKeySet = map.keySet();
            String[] strArr = (String[]) setKeySet.toArray(new String[setKeySet.size()]);
            int length = strArr.length;
            nVar.writeShort(length);
            for (int i = 0; i < length; i++) {
                nVar.writeUTF(strArr[i]);
                nVar.writeObject(map.get(strArr[i]));
            }
            int size = arrayList.size();
            nVar.writeShort(size);
            for (int i2 = 0; i2 < size; i2++) {
                nVar.writeObject(arrayList.get(i2));
            }
            deflaterOutputStream.close();
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new DecryptInputStream(httpURLConnection.getInputStream(), rC4Cryptor.init()));
            HashMap map2 = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            m mVar = new m(inflaterInputStream);
            int unsignedShort = mVar.readUnsignedShort();
            if (unsignedShort != 3) {
                throw new IOException("Version mismatched. " + unsignedShort);
            }
            int unsignedShort2 = mVar.readUnsignedShort();
            for (int i3 = 0; i3 < unsignedShort2; i3++) {
                map2.put(mVar.readUTF(), mVar.readObject());
            }
            int unsignedShort3 = mVar.readUnsignedShort();
            for (int i4 = 0; i4 < unsignedShort3; i4++) {
                arrayList2.add(mVar.readObject());
            }
            inflaterInputStream.close();
            Object obj2 = map2.get("p");
            if (((obj2 != null && (obj2 instanceof Number)) ? ((Number) obj2).intValue() : 0) == 11) {
                throw new l(String.valueOf(arrayList2.size() > 0 ? arrayList2.get(0) : null));
            }
            Object obj3 = arrayList2.size() > 0 ? arrayList2.get(0) : null;
            httpURLConnection.disconnect();
            return obj3;
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
