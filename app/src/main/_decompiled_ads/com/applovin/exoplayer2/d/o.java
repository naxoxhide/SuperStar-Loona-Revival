package com.applovin.exoplayer2.d;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class o implements m {
    public static final m.c tq = new m.c() { // from class: com.applovin.exoplayer2.d.-$$Lambda$o$yWQOTWP_9okNCdxXYtSj-3pE3zA
        @Override // com.applovin.exoplayer2.d.m.c
        public final m acquireExoMediaDrm(UUID uuid) {
            return o.d(uuid);
        }
    };
    private final UUID ey;
    private int sp;
    private final MediaDrm tr;

    @Override // com.applovin.exoplayer2.d.m
    public int hN() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ m d(UUID uuid) {
        try {
            return b(uuid);
        } catch (t unused) {
            com.applovin.exoplayer2.l.q.i("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new k();
        }
    }

    public static o b(UUID uuid) throws t {
        try {
            return new o(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new t(1, e);
        } catch (Exception e2) {
            throw new t(2, e2);
        }
    }

    private o(UUID uuid) throws UnsupportedSchemeException {
        com.applovin.exoplayer2.l.a.checkNotNull(uuid);
        com.applovin.exoplayer2.l.a.checkArgument(!com.applovin.exoplayer2.h.ak.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.ey = uuid;
        MediaDrm mediaDrm = new MediaDrm(c(uuid));
        this.tr = mediaDrm;
        this.sp = 1;
        if (com.applovin.exoplayer2.h.am.equals(uuid) && hR()) {
            a(mediaDrm);
        }
    }

    @Override // com.applovin.exoplayer2.d.m
    public void a(final m.b bVar) {
        this.tr.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: com.applovin.exoplayer2.d.-$$Lambda$o$MHIuXbH6Dhv1oHQBcMk4SRHiZrk
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                this.f$0.a(bVar, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(m.b bVar, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        bVar.a(this, bArr, i, i2, bArr2);
    }

    @Override // com.applovin.exoplayer2.d.m
    public byte[] hL() throws MediaDrmException {
        return this.tr.openSession();
    }

    @Override // com.applovin.exoplayer2.d.m
    public void p(byte[] bArr) {
        this.tr.closeSession(bArr);
    }

    @Override // com.applovin.exoplayer2.d.m
    public m.a a(byte[] bArr, List<e.a> list, int i, HashMap<String, String> map) throws NotProvisionedException {
        byte[] bArrA;
        String strA;
        e.a aVarA = null;
        if (list != null) {
            aVarA = a(this.ey, list);
            bArrA = a(this.ey, (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(aVarA.tf));
            strA = a(this.ey, aVarA.eg);
        } else {
            bArrA = null;
            strA = null;
        }
        MediaDrm.KeyRequest keyRequest = this.tr.getKeyRequest(bArr, bArrA, strA, i, map);
        byte[] bArrB = b(this.ey, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && aVarA != null && !TextUtils.isEmpty(aVarA.te)) {
            defaultUrl = aVarA.te;
        }
        return new m.a(bArrB, defaultUrl, ai.acV >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // com.applovin.exoplayer2.d.m
    public byte[] a(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (com.applovin.exoplayer2.h.al.equals(this.ey)) {
            bArr2 = com.applovin.exoplayer2.d.a.m(bArr2);
        }
        return this.tr.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.applovin.exoplayer2.d.m
    public m.d hM() {
        MediaDrm.ProvisionRequest provisionRequest = this.tr.getProvisionRequest();
        return new m.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.applovin.exoplayer2.d.m
    public void q(byte[] bArr) throws DeniedByServerException {
        this.tr.provideProvisionResponse(bArr);
    }

    @Override // com.applovin.exoplayer2.d.m
    public Map<String, String> r(byte[] bArr) {
        return this.tr.queryKeyStatus(bArr);
    }

    @Override // com.applovin.exoplayer2.d.m
    public boolean a(byte[] bArr, String str) {
        if (ai.acV >= 31) {
            return a.a(this.tr, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.ey, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.applovin.exoplayer2.d.m
    public synchronized void release() {
        int i = this.sp - 1;
        this.sp = i;
        if (i == 0) {
            this.tr.release();
        }
    }

    @Override // com.applovin.exoplayer2.d.m
    public void b(byte[] bArr, byte[] bArr2) {
        this.tr.restoreKeys(bArr, bArr2);
    }

    public String C(String str) {
        return this.tr.getPropertyString(str);
    }

    @Override // com.applovin.exoplayer2.d.m
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public n s(byte[] bArr) throws MediaCryptoException {
        return new n(c(this.ey), bArr, ai.acV < 21 && com.applovin.exoplayer2.h.am.equals(this.ey) && "L3".equals(C("securityLevel")));
    }

    private static e.a a(UUID uuid, List<e.a> list) {
        boolean z;
        if (!com.applovin.exoplayer2.h.am.equals(uuid)) {
            return list.get(0);
        }
        if (ai.acV >= 28 && list.size() > 1) {
            e.a aVar = list.get(0);
            int i = 0;
            int length = 0;
            while (true) {
                if (i >= list.size()) {
                    z = true;
                    break;
                }
                e.a aVar2 = list.get(i);
                byte[] bArr = (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(aVar2.tf);
                if (!ai.r(aVar2.eg, aVar.eg) || !ai.r(aVar2.te, aVar.te) || !com.applovin.exoplayer2.e.g.h.w(bArr)) {
                    z = false;
                    break;
                }
                length += bArr.length;
                i++;
            }
            if (z) {
                byte[] bArr2 = new byte[length];
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    byte[] bArr3 = (byte[]) com.applovin.exoplayer2.l.a.checkNotNull(list.get(i3).tf);
                    int length2 = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i2, length2);
                    i2 += length2;
                }
                return aVar.o(bArr2);
            }
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            e.a aVar3 = list.get(i4);
            int iY = com.applovin.exoplayer2.e.g.h.y((byte[]) com.applovin.exoplayer2.l.a.checkNotNull(aVar3.tf));
            if (ai.acV < 23 && iY == 0) {
                return aVar3;
            }
            if (ai.acV >= 23 && iY == 1) {
                return aVar3;
            }
        }
        return list.get(0);
    }

    private static UUID c(UUID uuid) {
        return (ai.acV >= 27 || !com.applovin.exoplayer2.h.al.equals(uuid)) ? uuid : com.applovin.exoplayer2.h.ak;
    }

    private static byte[] a(UUID uuid, byte[] bArr) {
        byte[] bArrA;
        if (com.applovin.exoplayer2.h.an.equals(uuid)) {
            byte[] bArrA2 = com.applovin.exoplayer2.e.g.h.a(bArr, uuid);
            if (bArrA2 != null) {
                bArr = bArrA2;
            }
            bArr = com.applovin.exoplayer2.e.g.h.c(com.applovin.exoplayer2.h.an, u(bArr));
        }
        return (((ai.acV >= 23 || !com.applovin.exoplayer2.h.am.equals(uuid)) && !(com.applovin.exoplayer2.h.an.equals(uuid) && "Amazon".equals(ai.acX) && ("AFTB".equals(ai.acY) || "AFTS".equals(ai.acY) || "AFTM".equals(ai.acY) || "AFTT".equals(ai.acY)))) || (bArrA = com.applovin.exoplayer2.e.g.h.a(bArr, uuid)) == null) ? bArr : bArrA;
    }

    private static String a(UUID uuid, String str) {
        return (ai.acV < 26 && com.applovin.exoplayer2.h.al.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    private static byte[] b(UUID uuid, byte[] bArr) {
        return com.applovin.exoplayer2.h.al.equals(uuid) ? com.applovin.exoplayer2.d.a.l(bArr) : bArr;
    }

    private static void a(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static boolean hR() {
        return "ASUS_Z00AD".equals(ai.acY);
    }

    private static byte[] u(byte[] bArr) {
        y yVar = new y(bArr);
        int iPy = yVar.py();
        short sPs = yVar.ps();
        short sPs2 = yVar.ps();
        if (sPs != 1 || sPs2 != 1) {
            com.applovin.exoplayer2.l.q.g("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        String strB = yVar.b(yVar.ps(), Charsets.UTF_16LE);
        if (strB.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strB.indexOf("</DATA>");
        if (iIndexOf == -1) {
            com.applovin.exoplayer2.l.q.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strB.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strB.substring(iIndexOf);
        int i = iPy + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putShort(sPs);
        byteBufferAllocate.putShort(sPs2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(Charsets.UTF_16LE));
        return byteBufferAllocate.array();
    }

    private static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }
}
