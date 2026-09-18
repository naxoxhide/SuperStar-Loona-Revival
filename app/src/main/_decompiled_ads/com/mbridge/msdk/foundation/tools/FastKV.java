package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.UShort;

/* JADX INFO: loaded from: classes4.dex */
public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private int dataEnd;
    private final Map<String, a> encoderMap;
    private m fastBuffer;
    private int invalidBytes;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;
    private static final int[] TYPE_SIZE = {0, 1, 4, 4, 8, 8};
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private final b logger = n.a;
    private final Map<String, com.mbridge.msdk.foundation.tools.c.b> data = new HashMap();
    private final ArrayList<c> invalids = new ArrayList<>();
    private boolean autoCommit = true;
    private final Executor executor = new p();

    public interface a<T> {
        T a(byte[] bArr, int i, int i2);

        String a();

        byte[] a(T t);
    }

    public interface b {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    private long shiftCheckSum(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    static {
        int iB = am.b();
        PAGE_SIZE = iB;
        int iMax = Math.max(iB << 1, 16384);
        DOUBLE_LIMIT = iMax;
        TRUNCATE_THRESHOLD = iMax << 1;
    }

    FastKV(String str, String str2, a[] aVarArr, int i) {
        this.path = str;
        this.name = str2;
        this.writingMode = i;
        HashMap map = new HashMap();
        map.put("StringSet", aj.a);
        if (aVarArr != null && aVarArr.length > 0) {
            for (a aVar : aVarArr) {
                String strA = aVar.a();
                if (map.containsKey(strA)) {
                    error("duplicate encoder tag:" + strA);
                } else {
                    map.put(strA, aVar);
                }
            }
        }
        this.encoderMap = map;
        loadData();
    }

    private synchronized void loadData() {
        long jNanoTime = System.nanoTime();
        if (!loadFromCFile() && this.writingMode == 0) {
            loadFromABFile();
        }
        if (this.fastBuffer == null) {
            this.fastBuffer = new m(PAGE_SIZE);
        }
        if (this.logger != null) {
            info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x010b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0193  */
    private void loadFromABFile() {
        boolean z;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (am.a(file) && am.a(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                this.aChannel = randomAccessFile.getChannel();
                this.bChannel = randomAccessFile2.getChannel();
                try {
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : PAGE_SIZE);
                    this.aBuffer = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    this.bBuffer = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                    this.fastBuffer = new m(this.aBuffer.capacity());
                    if (length == 0 && length2 == 0) {
                        this.dataEnd = 12;
                        return;
                    }
                    int i = this.aBuffer.getInt();
                    long j = this.aBuffer.getLong();
                    int i2 = this.bBuffer.getInt();
                    long j2 = this.bBuffer.getLong();
                    boolean z2 = true;
                    if (i < 0 || i > length - 12) {
                        z = false;
                    } else {
                        this.dataEnd = i + 12;
                        this.aBuffer.rewind();
                        this.aBuffer.get(this.fastBuffer.a, 0, this.dataEnd);
                        if (j == this.fastBuffer.b(12, i) && parseData() == 0) {
                            this.checksum = j;
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        if (length == length2 && isABFileEqual()) {
                            return;
                        }
                        warning(new Exception("B file error"));
                        copyBuffer(this.aBuffer, this.bBuffer, this.dataEnd);
                        return;
                    }
                    if (i2 < 0 || i2 > length2 - 12) {
                        z2 = false;
                    } else {
                        this.data.clear();
                        clearInvalid();
                        this.dataEnd = i2 + 12;
                        if (this.fastBuffer.a.length != this.bBuffer.capacity()) {
                            this.fastBuffer = new m(this.bBuffer.capacity());
                        }
                        this.bBuffer.rewind();
                        this.bBuffer.get(this.fastBuffer.a, 0, this.dataEnd);
                        if (j2 == this.fastBuffer.b(12, i2) && parseData() == 0) {
                            warning(new Exception("A file error"));
                            copyBuffer(this.bBuffer, this.aBuffer, this.dataEnd);
                            this.checksum = j2;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        return;
                    }
                    error(BOTH_FILES_ERROR);
                    resetData();
                    return;
                } catch (IOException e) {
                    error(e);
                    toBlockingMode();
                    tryBlockingIO(file, file2);
                    return;
                }
            }
            error(new Exception(OPEN_FILE_FAILED));
            toBlockingMode();
        } catch (Exception e2) {
            error(e2);
            clearData();
            toBlockingMode();
        }
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e) {
            warning(e);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e2) {
            warning(e2);
        }
        clearData();
    }

    private boolean isABFileEqual() {
        m mVar = new m(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(mVar.a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.a;
        byte[] bArr2 = mVar.a;
        for (int i = 0; i < this.dataEnd; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean loadFromCFile() {
        File file = new File(this.path, this.name + C_SUFFIX);
        File file2 = new File(this.path, this.name + TEMP_SUFFIX);
        boolean z = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (loadWithBlockingIO(file)) {
                    if (this.writingMode == 0) {
                        if (writeToABFile(this.fastBuffer)) {
                            info("recover from c file");
                            try {
                                deleteCFiles();
                                return true;
                            } catch (Exception e) {
                                e = e;
                                error(e);
                                return z;
                            }
                        }
                        this.writingMode = 1;
                    }
                } else {
                    clearData();
                    deleteCFiles();
                }
            } else if (this.writingMode != 0) {
                File file3 = new File(this.path, this.name + A_SUFFIX);
                File file4 = new File(this.path, this.name + B_SUFFIX);
                if (file3.exists() && file4.exists()) {
                    tryBlockingIO(file3, file4);
                }
            }
            return false;
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        m mVar;
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i);
            m mVar2 = this.fastBuffer;
            if (mVar2 != null && mVar2.a.length == newCapacity) {
                mVar = this.fastBuffer;
                mVar.f2218b = 0;
            } else {
                m mVar3 = new m(new byte[newCapacity]);
                this.fastBuffer = mVar3;
                mVar = mVar3;
            }
            am.a(file, mVar.a, i);
            int iC = mVar.c();
            long jD = mVar.d();
            this.dataEnd = iC + 12;
            if (iC >= 0 && iC <= i - 12 && jD == mVar.b(12, iC) && parseData() == 0) {
                this.checksum = jD;
                return true;
            }
        }
        return false;
    }

    private boolean writeToABFile(m mVar) {
        int length = mVar.a.length;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (!am.a(file) || !am.a(file2)) {
                throw new Exception(OPEN_FILE_FAILED);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j = length;
            randomAccessFile.setLength(j);
            randomAccessFile2.setLength(j);
            this.aChannel = randomAccessFile.getChannel();
            this.bChannel = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.aBuffer = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.bBuffer = map2;
            map2.order(ByteOrder.LITTLE_ENDIAN);
            this.aBuffer.put(mVar.a, 0, this.dataEnd);
            this.bBuffer.put(mVar.a, 0, this.dataEnd);
            return true;
        } catch (Exception e) {
            error(e);
            return false;
        }
    }

    private void checkValueSize(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bBuffer ? this.bChannel : this.aChannel).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e) {
                error(e);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private int parseData() {
        Object objB;
        m mVar = this.fastBuffer;
        mVar.f2218b = 12;
        while (true) {
            try {
                if (mVar.f2218b < this.dataEnd) {
                    int i = mVar.f2218b;
                    byte bA = mVar.a();
                    byte b2 = (byte) (bA & 63);
                    if (b2 < 1 || b2 > 8) {
                        throw new Exception(PARSE_DATA_FAILED);
                    }
                    int iA = mVar.a() & 255;
                    if (bA < 0) {
                        mVar.f2218b += iA;
                        int iB = b2 <= 5 ? TYPE_SIZE[b2] : mVar.b() & UShort.MAX_VALUE;
                        this.fastBuffer.f2218b += iB;
                        countInvalid(i, this.fastBuffer.f2218b);
                    } else {
                        String strB = mVar.b(iA);
                        int i2 = mVar.f2218b;
                        if (b2 > 5) {
                            int iB2 = mVar.b() & UShort.MAX_VALUE;
                            boolean z = (bA & SignedBytes.MAX_POWER_OF_TWO) != 0;
                            checkValueSize(iB2, z);
                            if (b2 == 6) {
                                this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.i(i, i2 + 2, mVar.b(iB2), iB2, z));
                            } else if (b2 == 7) {
                                if (z) {
                                    objB = mVar.b(iB2);
                                } else {
                                    objB = new byte[iB2];
                                    System.arraycopy(mVar.a, mVar.f2218b, objB, 0, iB2);
                                    mVar.f2218b += iB2;
                                }
                                this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.a(i, i2 + 2, objB, iB2, z));
                            } else if (z) {
                                this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.h(i, i2 + 2, mVar.b(iB2), iB2, true));
                            } else {
                                int iA2 = mVar.a() & 255;
                                String strB2 = mVar.b(iA2);
                                a aVar = this.encoderMap.get(strB2);
                                int i3 = iB2 - (iA2 + 1);
                                if (i3 < 0) {
                                    throw new Exception(PARSE_DATA_FAILED);
                                }
                                if (aVar != null) {
                                    try {
                                        Object objA = aVar.a(mVar.a, mVar.f2218b, i3);
                                        if (objA != null) {
                                            this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.h(i, i2 + 2, objA, iB2, false));
                                        }
                                    } catch (Exception e) {
                                        error(e);
                                    }
                                } else {
                                    error("object with tag: " + strB2 + " without encoder");
                                }
                                mVar.f2218b += i3;
                            }
                        } else if (b2 == 1) {
                            this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.C0489c(i2, mVar.a() == 1));
                        } else if (b2 == 2) {
                            this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.f(i2, mVar.c()));
                        } else if (b2 == 3) {
                            this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.e(i2, Float.intBitsToFloat(mVar.c())));
                        } else if (b2 == 4) {
                            this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.g(i2, mVar.d()));
                        } else {
                            this.data.put(strB, new com.mbridge.msdk.foundation.tools.c.d(i2, Double.longBitsToDouble(mVar.d())));
                        }
                    }
                } else {
                    if (mVar.f2218b == this.dataEnd) {
                        return 0;
                    }
                    warning(new Exception(PARSE_DATA_FAILED));
                    return -1;
                }
            } catch (Exception e2) {
                warning(e2);
                return -1;
            }
        }
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public synchronized boolean getBoolean(String str, boolean z) {
        com.mbridge.msdk.foundation.tools.c.C0489c c0489c = (com.mbridge.msdk.foundation.tools.c.C0489c) this.data.get(str);
        if (c0489c != null) {
            z = c0489c.f2207b;
        }
        return z;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized int getInt(String str, int i) {
        com.mbridge.msdk.foundation.tools.c.f fVar = (com.mbridge.msdk.foundation.tools.c.f) this.data.get(str);
        if (fVar != null) {
            i = fVar.f2210b;
        }
        return i;
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public synchronized float getFloat(String str, float f) {
        com.mbridge.msdk.foundation.tools.c.e eVar = (com.mbridge.msdk.foundation.tools.c.e) this.data.get(str);
        if (eVar != null) {
            f = eVar.f2209b;
        }
        return f;
    }

    public synchronized long getLong(String str) {
        com.mbridge.msdk.foundation.tools.c.g gVar;
        gVar = (com.mbridge.msdk.foundation.tools.c.g) this.data.get(str);
        return gVar == null ? 0L : gVar.f2211b;
    }

    public synchronized long getLong(String str, long j) {
        com.mbridge.msdk.foundation.tools.c.g gVar = (com.mbridge.msdk.foundation.tools.c.g) this.data.get(str);
        if (gVar != null) {
            j = gVar.f2211b;
        }
        return j;
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public synchronized double getDouble(String str, double d) {
        com.mbridge.msdk.foundation.tools.c.d dVar = (com.mbridge.msdk.foundation.tools.c.d) this.data.get(str);
        if (dVar != null) {
            d = dVar.f2208b;
        }
        return d;
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public synchronized String getString(String str, String str2) {
        com.mbridge.msdk.foundation.tools.c.i iVar = (com.mbridge.msdk.foundation.tools.c.i) this.data.get(str);
        if (iVar != null) {
            return iVar.e ? getStringFromFile(iVar) : (String) iVar.f2212b;
        }
        return str2;
    }

    private String getStringFromFile(com.mbridge.msdk.foundation.tools.c.i iVar) {
        try {
            byte[] bArrB = am.b(new File(this.path + this.name, (String) iVar.f2212b));
            if (bArrB != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return bArrB.length == 0 ? "" : new String(bArrB, StandardCharsets.UTF_8);
                }
                return bArrB.length == 0 ? "" : new String(bArrB);
            }
        } catch (Exception e) {
            error(e);
        }
        return "";
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    public synchronized byte[] getArray(String str, byte[] bArr) {
        com.mbridge.msdk.foundation.tools.c.a aVar = (com.mbridge.msdk.foundation.tools.c.a) this.data.get(str);
        if (aVar != null) {
            return aVar.e ? getArrayFromFile(aVar) : (byte[]) aVar.f2212b;
        }
        return bArr;
    }

    private byte[] getArrayFromFile(com.mbridge.msdk.foundation.tools.c.a aVar) {
        try {
            byte[] bArrB = am.b(new File(this.path + this.name, (String) aVar.f2212b));
            return bArrB != null ? bArrB : EMPTY_ARRAY;
        } catch (Exception e) {
            error(e);
            return EMPTY_ARRAY;
        }
    }

    public synchronized <T> T getObject(String str) {
        com.mbridge.msdk.foundation.tools.c.h hVar = (com.mbridge.msdk.foundation.tools.c.h) this.data.get(str);
        if (hVar != null) {
            return hVar.e ? (T) getObjectFromFile(hVar) : (T) hVar.f2212b;
        }
        return null;
    }

    private Object getObjectFromFile(com.mbridge.msdk.foundation.tools.c.h hVar) {
        String str;
        try {
            byte[] bArrB = am.b(new File(this.path + this.name, (String) hVar.f2212b));
            if (bArrB != null) {
                int i = bArrB[0] & 255;
                if (Build.VERSION.SDK_INT >= 19) {
                    str = new String(bArrB, 1, i, StandardCharsets.UTF_8);
                } else {
                    str = new String(bArrB, 1, i);
                }
                a aVar = this.encoderMap.get(str);
                if (aVar != null) {
                    int i2 = i + 1;
                    return aVar.a(bArrB, i2, bArrB.length - i2);
                }
                warning(new Exception("No encoder for tag:" + str));
                return null;
            }
            warning(new Exception("Read object data failed"));
            return null;
        } catch (Exception e) {
            error(e);
            return null;
        }
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public synchronized void putBoolean(String str, boolean z) {
        checkKey(str);
        com.mbridge.msdk.foundation.tools.c.C0489c c0489c = (com.mbridge.msdk.foundation.tools.c.C0489c) this.data.get(str);
        if (c0489c == null) {
            wrapHeader(str, (byte) 1);
            int i = this.fastBuffer.f2218b;
            this.fastBuffer.a((byte) (z ? 1 : 0));
            updateChange();
            this.data.put(str, new com.mbridge.msdk.foundation.tools.c.C0489c(i, z));
            checkIfCommit();
        } else if (c0489c.f2207b != z) {
            c0489c.f2207b = z;
            updateBoolean((byte) (z ? 1 : 0), c0489c.a);
            checkIfCommit();
        }
    }

    public synchronized void putInt(String str, int i) {
        checkKey(str);
        com.mbridge.msdk.foundation.tools.c.f fVar = (com.mbridge.msdk.foundation.tools.c.f) this.data.get(str);
        if (fVar == null) {
            wrapHeader(str, (byte) 2);
            int i2 = this.fastBuffer.f2218b;
            this.fastBuffer.a(i);
            updateChange();
            this.data.put(str, new com.mbridge.msdk.foundation.tools.c.f(i2, i));
            checkIfCommit();
        } else if (fVar.f2210b != i) {
            long j = ((long) (fVar.f2210b ^ i)) & 4294967295L;
            fVar.f2210b = i;
            updateInt32(i, j, fVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putFloat(String str, float f) {
        checkKey(str);
        com.mbridge.msdk.foundation.tools.c.e eVar = (com.mbridge.msdk.foundation.tools.c.e) this.data.get(str);
        if (eVar == null) {
            wrapHeader(str, (byte) 3);
            int i = this.fastBuffer.f2218b;
            this.fastBuffer.a(Float.floatToRawIntBits(f));
            updateChange();
            this.data.put(str, new com.mbridge.msdk.foundation.tools.c.e(i, f));
            checkIfCommit();
        } else if (eVar.f2209b != f) {
            int iFloatToRawIntBits = Float.floatToRawIntBits(f);
            long jFloatToRawIntBits = ((long) (Float.floatToRawIntBits(eVar.f2209b) ^ iFloatToRawIntBits)) & 4294967295L;
            eVar.f2209b = f;
            updateInt32(iFloatToRawIntBits, jFloatToRawIntBits, eVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putLong(String str, long j) {
        checkKey(str);
        com.mbridge.msdk.foundation.tools.c.g gVar = (com.mbridge.msdk.foundation.tools.c.g) this.data.get(str);
        if (gVar == null) {
            wrapHeader(str, (byte) 4);
            int i = this.fastBuffer.f2218b;
            this.fastBuffer.a(j);
            updateChange();
            this.data.put(str, new com.mbridge.msdk.foundation.tools.c.g(i, j));
            checkIfCommit();
        } else if (gVar.f2211b != j) {
            long j2 = j ^ gVar.f2211b;
            gVar.f2211b = j;
            updateInt64(j, j2, gVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putDouble(String str, double d) {
        checkKey(str);
        com.mbridge.msdk.foundation.tools.c.d dVar = (com.mbridge.msdk.foundation.tools.c.d) this.data.get(str);
        if (dVar == null) {
            wrapHeader(str, (byte) 5);
            int i = this.fastBuffer.f2218b;
            this.fastBuffer.a(Double.doubleToRawLongBits(d));
            updateChange();
            this.data.put(str, new com.mbridge.msdk.foundation.tools.c.d(i, d));
            checkIfCommit();
        } else if (dVar.f2208b != d) {
            long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
            long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.f2208b) ^ jDoubleToRawLongBits;
            dVar.f2208b = d;
            updateInt64(jDoubleToRawLongBits, jDoubleToRawLongBits2, dVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putString(String str, String str2) {
        byte[] bytes;
        checkKey(str);
        if (str2 == null) {
            remove(str);
        } else {
            com.mbridge.msdk.foundation.tools.c.i iVar = (com.mbridge.msdk.foundation.tools.c.i) this.data.get(str);
            if (str2.length() * 3 < 2048) {
                fastPutString(str, str2, iVar);
            } else {
                if (Build.VERSION.SDK_INT >= 19) {
                    bytes = str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8);
                } else {
                    bytes = str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes();
                }
                addOrUpdate(str, str2, bytes, iVar, (byte) 6);
            }
        }
    }

    public synchronized void putArray(String str, byte[] bArr) {
        checkKey(str);
        if (bArr == null) {
            remove(str);
        } else {
            addOrUpdate(str, bArr, bArr, (com.mbridge.msdk.foundation.tools.c.a) this.data.get(str), (byte) 7);
        }
    }

    public synchronized <T> void putObject(String str, T t, a<T> aVar) {
        checkKey(str);
        if (aVar == null) {
            throw new IllegalArgumentException("Encoder is null");
        }
        String strA = aVar.a();
        if (strA == null || strA.isEmpty() || strA.length() > 50) {
            throw new IllegalArgumentException("Invalid encoder tag:" + strA);
        }
        if (!this.encoderMap.containsKey(strA)) {
            throw new IllegalArgumentException("Encoder hasn't been registered");
        }
        if (t == null) {
            remove(str);
            return;
        }
        byte[] bArrA = null;
        try {
            bArrA = aVar.a(t);
        } catch (Exception e) {
            error(e);
        }
        if (bArrA == null) {
            remove(str);
            return;
        }
        int iB = m.b(strA);
        m mVar = new m(iB + 1 + bArrA.length);
        mVar.a((byte) iB);
        mVar.a(strA);
        mVar.a(bArrA);
        addOrUpdate(str, t, mVar.a, (com.mbridge.msdk.foundation.tools.c.h) this.data.get(str), (byte) 8);
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        try {
            if (set == null) {
                remove(str);
            } else {
                putObject(str, set, aj.a);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void remove(String str) {
        com.mbridge.msdk.foundation.tools.c.b bVar = this.data.get(str);
        if (bVar != null) {
            this.data.remove(str);
            byte bA = bVar.a();
            String str2 = null;
            if (bA <= 5) {
                remove(bA, bVar.a - (m.b(str) + 2), bVar.a + TYPE_SIZE[bA]);
            } else {
                com.mbridge.msdk.foundation.tools.c.j jVar = (com.mbridge.msdk.foundation.tools.c.j) bVar;
                remove(bA, jVar.c, jVar.a + jVar.d);
                if (jVar.e) {
                    str2 = (String) jVar.f2212b;
                }
            }
            byte b2 = (byte) (bA | (-128));
            if (this.writingMode == 0) {
                this.aBuffer.putLong(4, this.checksum);
                this.aBuffer.put(this.removeStart, b2);
                this.bBuffer.putLong(4, this.checksum);
                this.bBuffer.put(this.removeStart, b2);
            } else {
                this.fastBuffer.a(4, this.checksum);
            }
            this.removeStart = 0;
            if (str2 != null) {
                am.c(new File(this.path + this.name, str2));
            }
            checkGC();
            checkIfCommit();
        }
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, com.mbridge.msdk.foundation.tools.c.b> entry : this.data.entrySet()) {
            String key = entry.getKey();
            com.mbridge.msdk.foundation.tools.c.b value = entry.getValue();
            Object obj = null;
            switch (value.a()) {
                case 1:
                    objValueOf = Boolean.valueOf(((com.mbridge.msdk.foundation.tools.c.C0489c) value).f2207b);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((com.mbridge.msdk.foundation.tools.c.f) value).f2210b);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((com.mbridge.msdk.foundation.tools.c.e) value).f2209b);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((com.mbridge.msdk.foundation.tools.c.g) value).f2211b);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((com.mbridge.msdk.foundation.tools.c.d) value).f2208b);
                    break;
                case 6:
                    com.mbridge.msdk.foundation.tools.c.i iVar = (com.mbridge.msdk.foundation.tools.c.i) value;
                    objValueOf = iVar.e ? getStringFromFile(iVar) : iVar.f2212b;
                    break;
                case 7:
                    com.mbridge.msdk.foundation.tools.c.a aVar = (com.mbridge.msdk.foundation.tools.c.a) value;
                    objValueOf = aVar.e ? getArrayFromFile(aVar) : aVar.f2212b;
                    break;
                case 8:
                    com.mbridge.msdk.foundation.tools.c.h hVar = (com.mbridge.msdk.foundation.tools.c.h) value;
                    objValueOf = hVar.e ? getObjectFromFile(hVar) : ((com.mbridge.msdk.foundation.tools.c.h) value).f2212b;
                    break;
                default:
                    continue;
                    map.put(key, obj);
                    break;
            }
            obj = objValueOf;
            map.put(key, obj);
        }
        return map;
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, null);
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, a> map2) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    putArray(key, (byte[]) value);
                } else if (map2 != null) {
                    a aVar = map2.get(value.getClass());
                    if (aVar != null) {
                        putObject(key, value, aVar);
                    } else {
                        warning(new Exception("missing encoder for type:" + value.getClass()));
                    }
                } else {
                    warning(new Exception("missing encoders"));
                }
            }
        }
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    private void checkIfCommit() {
        if (this.writingMode == 0 || !this.autoCommit) {
            return;
        }
        commitToCFile();
    }

    private boolean commitToCFile() {
        int i = this.writingMode;
        if (i == 1) {
            this.executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.FastKV.1
                @Override // java.lang.Runnable
                public final void run() {
                    FastKV.this.writeToCFile();
                }
            });
        } else if (i == 2) {
            return writeToCFile();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            File file = new File(this.path, this.name + TEMP_SUFFIX);
            if (am.a(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.dataEnd);
                randomAccessFile.write(this.fastBuffer.a, 0, this.dataEnd);
                randomAccessFile.close();
                File file2 = new File(this.path, this.name + C_SUFFIX);
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    warning(new Exception("rename failed"));
                }
            }
        } catch (Exception e) {
            error(e);
        }
        return false;
    }

    private void deleteCFiles() {
        try {
            am.c(new File(this.path, this.name + C_SUFFIX));
            am.c(new File(this.path, this.name + TEMP_SUFFIX));
        } catch (Exception e) {
            error(e);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        am.a(this.aChannel);
        am.a(this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        am.c(new File(this.path + this.name));
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int iCapacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (iCapacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            fileChannel.truncate(i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0L;
        clearInvalid();
        this.data.clear();
        m mVar = this.fastBuffer;
        if (mVar == null || mVar.a.length != PAGE_SIZE) {
            this.fastBuffer = new m(PAGE_SIZE);
        } else {
            this.fastBuffer.a(0, 0);
            this.fastBuffer.a(4, 0L);
        }
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void checkKeySize(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void wrapHeader(String str, byte b2) {
        wrapHeader(str, b2, TYPE_SIZE[b2]);
    }

    private void wrapHeader(String str, byte b2, int i) {
        int iB = m.b(str);
        checkKeySize(iB);
        this.updateSize = iB + 2 + i;
        preparePutBytes();
        this.fastBuffer.a(b2);
        putKey(str, iB);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.b(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.a(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i = this.removeStart;
        if (i != 0) {
            mappedByteBuffer.put(i, this.fastBuffer.a[this.removeStart]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.a, this.updateStart, this.updateSize);
        }
    }

    private int bytesThreshold() {
        int i = this.dataEnd;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void ensureSize(int i) {
        int length = this.fastBuffer.a.length;
        int i2 = this.dataEnd + i;
        if (i2 >= length) {
            int i3 = this.invalidBytes;
            if (i3 > i && i3 > bytesThreshold()) {
                gc(i);
                return;
            }
            int newCapacity = getNewCapacity(length, i2);
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.a = bArr;
            if (this.writingMode == 0) {
                try {
                    long j = newCapacity;
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aBuffer = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.bBuffer = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                } catch (IOException e) {
                    error(new Exception(MAP_FAILED, e));
                    this.fastBuffer.a(0, this.dataEnd - 12);
                    this.fastBuffer.a(4, this.checksum);
                    toBlockingMode();
                }
            }
        }
    }

    private void updateBoolean(byte b2, int i) {
        long jShiftCheckSum = this.checksum ^ shiftCheckSum(1L, i);
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.put(i, b2);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i, b2);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.a[i] = b2;
    }

    private void updateInt32(int i, long j, int i2) {
        long jShiftCheckSum = shiftCheckSum(j, i2) ^ this.checksum;
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.putInt(i2, i);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i2, i);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.a(i2, i);
    }

    private void updateInt64(long j, long j2, int i) {
        long jShiftCheckSum = shiftCheckSum(j2, i) ^ this.checksum;
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.putLong(i, j);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i, j);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.a(i, j);
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.b(i, length);
        this.fastBuffer.f2218b = i;
        this.fastBuffer.a(bArr);
        long jB = this.checksum ^ this.fastBuffer.b(i, length);
        this.checksum = jB;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i);
            this.aBuffer.put(bArr);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i);
            this.bBuffer.put(bArr);
            return;
        }
        this.fastBuffer.a(4, jB);
    }

    private void preparePutBytes() {
        ensureSize(this.updateSize);
        int i = this.dataEnd;
        this.updateStart = i;
        this.dataEnd = this.updateSize + i;
        this.fastBuffer.f2218b = i;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i) {
        this.fastBuffer.a((byte) i);
        if (i == str.length()) {
            str.getBytes(0, i, this.fastBuffer.a, this.fastBuffer.f2218b);
            this.fastBuffer.f2218b += i;
            return;
        }
        this.fastBuffer.a(str);
    }

    private void putStringValue(String str, int i) {
        this.fastBuffer.a((short) i);
        if (i == str.length()) {
            str.getBytes(0, i, this.fastBuffer.a, this.fastBuffer.f2218b);
        } else {
            this.fastBuffer.a(str);
        }
    }

    private void fastPutString(String str, String str2, com.mbridge.msdk.foundation.tools.c.i iVar) {
        int iB = m.b(str2);
        if (iVar == null) {
            int iB2 = m.b(str);
            checkKeySize(iB2);
            int i = iB2 + 4;
            this.updateSize = i + iB;
            preparePutBytes();
            this.fastBuffer.a((byte) 6);
            putKey(str, iB2);
            putStringValue(str2, iB);
            Map<String, com.mbridge.msdk.foundation.tools.c.b> map = this.data;
            int i2 = this.updateStart;
            map.put(str, new com.mbridge.msdk.foundation.tools.c.i(i2, i2 + i, str2, iB, false));
            updateChange();
        } else {
            String str3 = null;
            int i3 = iVar.a - iVar.c;
            boolean z = true;
            if (iVar.d == iB) {
                this.checksum ^= this.fastBuffer.b(iVar.a, iVar.d);
                if (iB == str2.length()) {
                    str2.getBytes(0, iB, this.fastBuffer.a, iVar.a);
                } else {
                    this.fastBuffer.f2218b = iVar.a;
                    this.fastBuffer.a(str2);
                }
                this.updateStart = iVar.a;
                this.updateSize = iB;
                z = false;
            } else {
                this.updateSize = i3 + iB;
                preparePutBytes();
                this.fastBuffer.a((byte) 6);
                int i4 = i3 - 3;
                System.arraycopy(this.fastBuffer.a, iVar.c + 1, this.fastBuffer.a, this.fastBuffer.f2218b, i4);
                this.fastBuffer.f2218b += i4;
                putStringValue(str2, iB);
                remove((byte) 6, iVar.c, iVar.a + iVar.d);
                str3 = iVar.e ? (String) iVar.f2212b : null;
                iVar.e = false;
                iVar.c = this.updateStart;
                iVar.a = this.updateStart + i3;
                iVar.d = iB;
            }
            iVar.f2212b = str2;
            updateChange();
            if (z) {
                checkGC();
            }
            if (str3 != null) {
                am.c(new File(this.path + this.name, str3));
            }
        }
        checkIfCommit();
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, com.mbridge.msdk.foundation.tools.c.j jVar, byte b2) {
        if (jVar == null) {
            addObject(str, obj, bArr, b2);
        } else if (jVar.e || jVar.d != bArr.length) {
            updateObject(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.a, bArr);
            jVar.f2212b = obj;
        }
        checkIfCommit();
    }

    private void addObject(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        com.mbridge.msdk.foundation.tools.c.b hVar;
        int iSaveArray = saveArray(str, bArr, b2);
        if (iSaveArray != 0) {
            String str2 = this.tempExternalName;
            boolean z = str2 != null;
            if (z) {
                this.tempExternalName = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b2 == 6) {
                hVar = new com.mbridge.msdk.foundation.tools.c.i(this.updateStart, iSaveArray, (String) obj2, length, z);
            } else if (b2 == 7) {
                hVar = new com.mbridge.msdk.foundation.tools.c.a(this.updateStart, iSaveArray, obj2, length, z);
            } else {
                hVar = new com.mbridge.msdk.foundation.tools.c.h(this.updateStart, iSaveArray, obj2, length, z);
            }
            this.data.put(str, hVar);
            updateChange();
        }
    }

    private void updateObject(String str, Object obj, byte[] bArr, com.mbridge.msdk.foundation.tools.c.j jVar) {
        int iSaveArray = saveArray(str, bArr, jVar.a());
        if (iSaveArray != 0) {
            String str2 = jVar.e ? (String) jVar.f2212b : null;
            remove(jVar.a(), jVar.c, jVar.a + jVar.d);
            boolean z = this.tempExternalName != null;
            jVar.c = this.updateStart;
            jVar.a = iSaveArray;
            jVar.e = z;
            if (z) {
                jVar.f2212b = this.tempExternalName;
                jVar.d = 32;
                this.tempExternalName = null;
            } else {
                jVar.f2212b = obj;
                jVar.d = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                am.c(new File(this.path + this.name, str2));
            }
        }
    }

    private int saveArray(String str, byte[] bArr, byte b2) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String strA = am.a();
        if (am.a(new File(this.path + this.name, strA), bArr)) {
            this.tempExternalName = strA;
            byte[] bArr2 = new byte[32];
            strA.getBytes(0, 32, bArr2, 0);
            return wrapArray(str, bArr2, (byte) (b2 | SignedBytes.MAX_POWER_OF_TWO));
        }
        error("save large value failed");
        return 0;
    }

    private int wrapArray(String str, byte[] bArr, byte b2) {
        wrapHeader(str, b2, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        int i = this.fastBuffer.f2218b;
        this.fastBuffer.a(bArr);
        return i;
    }

    private void remove(byte b2, int i, int i2) {
        countInvalid(i, i2);
        byte b3 = (byte) (b2 | (-128));
        this.checksum ^= (((long) (this.fastBuffer.a[i] ^ b3)) & 255) << ((i & 7) << 3);
        this.fastBuffer.a[i] = b3;
        this.removeStart = i;
    }

    private void checkGC() {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        gc(0);
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        c cVar = this.invalids.get(size);
        while (size > 0) {
            size--;
            c cVar2 = this.invalids.get(size);
            if (cVar.a == cVar2.f2194b) {
                cVar2.f2194b = cVar.f2194b;
                this.invalids.remove(size + 1);
            }
            cVar = cVar2;
        }
    }

    void gc(int i) {
        Collections.sort(this.invalids);
        mergeInvalids();
        c cVar = this.invalids.get(0);
        int i2 = cVar.a;
        int i3 = this.dataEnd;
        int i4 = i3 - this.invalidBytes;
        int i5 = i4 - 12;
        int i6 = i4 - i2;
        int i7 = i3 - i2;
        boolean z = i5 < i7 + i6;
        if (!z) {
            this.checksum ^= this.fastBuffer.b(i2, i7);
        }
        int size = this.invalids.size();
        int i8 = size - 1;
        int i9 = this.dataEnd - this.invalids.get(i8).f2194b;
        int[] iArr = new int[(i9 > 0 ? size : i8) << 1];
        int i10 = cVar.a;
        int i11 = cVar.f2194b;
        int i12 = 1;
        while (i12 < size) {
            c cVar2 = this.invalids.get(i12);
            int i13 = cVar2.a - i11;
            int i14 = size;
            System.arraycopy(this.fastBuffer.a, i11, this.fastBuffer.a, i10, i13);
            int i15 = (i12 - 1) << 1;
            iArr[i15] = i11;
            iArr[i15 + 1] = i11 - i10;
            i10 += i13;
            i11 = cVar2.f2194b;
            i12++;
            size = i14;
        }
        if (i9 > 0) {
            System.arraycopy(this.fastBuffer.a, i11, this.fastBuffer.a, i10, i9);
            int i16 = i8 << 1;
            iArr[i16] = i11;
            iArr[i16 + 1] = i11 - i10;
        }
        clearInvalid();
        if (z) {
            this.checksum = this.fastBuffer.b(12, i5);
        } else {
            this.checksum ^= this.fastBuffer.b(i2, i6);
        }
        this.dataEnd = i4;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i2);
            this.aBuffer.put(this.fastBuffer.a, i2, i6);
            this.aBuffer.putInt(0, i5);
            this.bBuffer.putInt(0, i5);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i2);
            this.bBuffer.put(this.fastBuffer.a, i2, i6);
        } else {
            this.fastBuffer.a(0, i5);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i2, iArr);
        int i17 = i4 + i;
        if (this.fastBuffer.a.length - i17 > TRUNCATE_THRESHOLD) {
            truncate(i17);
        }
        info(GC_FINISH);
    }

    private void updateOffset(int i, int[] iArr) {
        for (com.mbridge.msdk.foundation.tools.c.b bVar : this.data.values()) {
            if (bVar.a > i) {
                int i2 = bVar.a;
                int i3 = 0;
                int length = (iArr.length >> 1) - 1;
                while (i3 <= length) {
                    int i4 = (i3 + length) >>> 1;
                    int i5 = iArr[i4 << 1];
                    if (i5 >= i2) {
                        if (i5 <= i2) {
                            length = i4;
                            break;
                        }
                        length = i4 - 1;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                int i6 = iArr[(length << 1) + 1];
                bVar.a -= i6;
                if (bVar.a() >= 6) {
                    ((com.mbridge.msdk.foundation.tools.c.j) bVar).c -= i6;
                }
            }
        }
    }

    private void truncate(int i) {
        int i2 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i2, i + i2);
        if (newCapacity >= this.fastBuffer.a.length) {
            return;
        }
        byte[] bArr = new byte[newCapacity];
        System.arraycopy(this.fastBuffer.a, 0, bArr, 0, this.dataEnd);
        this.fastBuffer.a = bArr;
        if (this.writingMode == 0) {
            try {
                long j = newCapacity;
                this.aChannel.truncate(j);
                MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aBuffer = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                this.bChannel.truncate(j);
                MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bBuffer = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
            } catch (IOException e) {
                error(new Exception(MAP_FAILED, e));
                toBlockingMode();
            }
        }
        info(TRUNCATE_FINISH);
    }

    private int getNewCapacity(int i, int i2) {
        if (i2 > DATA_SIZE_LIMIT) {
            throw new IllegalStateException("data size out of limit");
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = DOUBLE_LIMIT;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private void countInvalid(int i, int i2) {
        this.invalidBytes += i2 - i;
        this.invalids.add(new c(i, i2));
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private static class c implements Comparable<c> {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2194b;

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(c cVar) {
            return this.a - cVar.a;
        }

        c(int i, int i2) {
            this.a = i;
            this.f2194b = i2;
        }
    }

    private void error(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, new Exception(str));
        }
    }

    private void error(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, exc);
        }
    }

    private void warning(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, exc);
        }
    }

    private void info(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, str);
        }
    }

    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private a[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            this.path = str.endsWith(RemoteSettings.FORWARD_SLASH_STRING) ? str : str + '/';
            this.name = str2;
        }

        public Builder encoder(a[] aVarArr) {
            this.encoders = aVarArr;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public FastKV build() {
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV = map.get(str);
            if (fastKV == null) {
                synchronized (Builder.class) {
                    fastKV = map.get(str);
                    if (fastKV == null) {
                        fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                        map.put(str, fastKV);
                    }
                }
            }
            return fastKV;
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }
}
