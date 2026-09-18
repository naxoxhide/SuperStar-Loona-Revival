package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.util.Log;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.util.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public final HashMap<String, h> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<String> f1208b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.b c;
    public final Cipher d;
    public final SecretKeySpec e;
    public boolean f;
    public o g;

    public i(File file, byte[] bArr) {
        if (bArr != null) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(bArr.length == 16);
            try {
                this.d = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                this.e = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        } else {
            this.d = null;
            this.e = null;
        }
        this.a = new HashMap<>();
        this.f1208b = new SparseArray<>();
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.util.b(new File(file, "cached_content_index.exi"));
    }

    public h a(String str) {
        return this.a.get(str);
    }

    public void b(String str) {
        h hVarRemove = this.a.remove(str);
        if (hVarRemove != null) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(hVarRemove.c.isEmpty());
            this.f1208b.remove(hVarRemove.a);
            this.f = true;
        }
    }

    public void c() throws Throwable {
        DataOutputStream dataOutputStream;
        IOException e;
        Throwable th;
        if (!this.f) {
            return;
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            OutputStream outputStreamB = this.c.b();
            o oVar = this.g;
            if (oVar == null) {
                this.g = new o(outputStreamB);
            } else {
                oVar.a(outputStreamB);
            }
            dataOutputStream = new DataOutputStream(this.g);
            try {
                dataOutputStream.writeInt(1);
                dataOutputStream.writeInt(this.d != null ? 1 : 0);
                if (this.d != null) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.d.init(1, this.e, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(this.g, this.d));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    }
                } else {
                    dataOutputStream2 = dataOutputStream;
                }
                dataOutputStream2.writeInt(this.a.size());
                int iA = 0;
                for (h hVar : this.a.values()) {
                    dataOutputStream2.writeInt(hVar.a);
                    dataOutputStream2.writeUTF(hVar.f1207b);
                    dataOutputStream2.writeLong(hVar.d);
                    iA += hVar.a();
                }
                dataOutputStream2.writeInt(iA);
                com.fyber.inneractive.sdk.player.exoplayer2.util.b bVar = this.c;
                bVar.getClass();
                dataOutputStream2.close();
                bVar.f1227b.delete();
                int i = u.a;
                this.f = false;
            } catch (IOException e4) {
                e = e4;
                try {
                    throw new a.C0298a(e);
                } catch (Throwable th2) {
                    DataOutputStream dataOutputStream3 = dataOutputStream;
                    th = th2;
                    dataOutputStream2 = dataOutputStream3;
                    Throwable th3 = th;
                    dataOutputStream = dataOutputStream2;
                    th = th3;
                    u.a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                u.a(dataOutputStream);
                throw th;
            }
        } catch (IOException e5) {
            dataOutputStream = dataOutputStream2;
            e = e5;
        } catch (Throwable th5) {
            th = th5;
            Throwable th6 = th;
            dataOutputStream = dataOutputStream2;
            th = th6;
            u.a(dataOutputStream);
            throw th;
        }
    }

    public final boolean a() throws Throwable {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.c.a());
                dataInputStream = new DataInputStream(bufferedInputStream);
                try {
                    if (dataInputStream.readInt() != 1) {
                        u.a(dataInputStream);
                        return false;
                    }
                    if ((dataInputStream.readInt() & 1) == 0) {
                        if (this.d != null) {
                            this.f = true;
                        }
                        dataInputStream2 = dataInputStream;
                    } else {
                        if (this.d == null) {
                            u.a(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.d.init(2, this.e, new IvParameterSpec(bArr));
                            dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.d));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    }
                    int i = dataInputStream2.readInt();
                    int iA = 0;
                    for (int i2 = 0; i2 < i; i2++) {
                        h hVar = new h(dataInputStream2.readInt(), dataInputStream2.readUTF(), dataInputStream2.readLong());
                        a(hVar);
                        iA += hVar.a();
                    }
                    if (dataInputStream2.readInt() != iA) {
                        u.a(dataInputStream2);
                        return false;
                    }
                    u.a(dataInputStream2);
                    return true;
                } catch (FileNotFoundException unused) {
                } catch (IOException e3) {
                    e = e3;
                    dataInputStream2 = dataInputStream;
                    Log.e("CachedContentIndex", "Error reading cache content index file.", e);
                    if (dataInputStream2 != null) {
                        u.a(dataInputStream2);
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (dataInputStream != null) {
                        u.a(dataInputStream);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                dataInputStream = dataInputStream2;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
            dataInputStream = null;
        }
        if (dataInputStream != null) {
            u.a(dataInputStream);
        }
        return false;
    }

    public void b() {
        LinkedList linkedList = new LinkedList();
        for (h hVar : this.a.values()) {
            if (hVar.c.isEmpty()) {
                linkedList.add(hVar.f1207b);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b((String) it.next());
        }
    }

    public final void a(h hVar) {
        this.a.put(hVar.f1207b, hVar);
        this.f1208b.put(hVar.a, hVar.f1207b);
    }

    public final h a(String str, long j) {
        SparseArray<String> sparseArray = this.f1208b;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        h hVar = new h(iKeyAt, str, j);
        this.a.put(str, hVar);
        this.f1208b.put(iKeyAt, str);
        this.f = true;
        return hVar;
    }
}
