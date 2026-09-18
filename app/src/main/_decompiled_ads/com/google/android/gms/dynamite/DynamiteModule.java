package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy zza = new zzl();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public interface VersionPolicy {

        /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0200 A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TRY_ENTER, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0209 A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x0212 A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x021d  */
    /* JADX WARN: Code duplicated, block: B:153:0x02b9 A[Catch: all -> 0x0302, TryCatch #1 {all -> 0x0302, blocks: (B:5:0x002b, B:9:0x0075, B:14:0x007d, B:17:0x0083, B:28:0x00a5, B:124:0x0238, B:125:0x0243, B:137:0x0259, B:139:0x0277, B:141:0x0288, B:151:0x02b0, B:152:0x02b8, B:128:0x0247, B:131:0x024b, B:132:0x0253, B:153:0x02b9, B:154:0x02d0, B:155:0x02d1, B:156:0x0301), top: B:171:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:169:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0083 A[Catch: all -> 0x0302, TRY_LEAVE, TryCatch #1 {all -> 0x0302, blocks: (B:5:0x002b, B:9:0x0075, B:14:0x007d, B:17:0x0083, B:28:0x00a5, B:124:0x0238, B:125:0x0243, B:137:0x0259, B:139:0x0277, B:141:0x0288, B:151:0x02b0, B:152:0x02b8, B:128:0x0247, B:131:0x024b, B:132:0x0253, B:153:0x02b9, B:154:0x02d0, B:155:0x02d1, B:156:0x0301), top: B:171:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x008d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0091  */
    /* JADX WARN: Code duplicated, block: B:24:0x009c  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ae A[Catch: all -> 0x022a, TryCatch #7 {all -> 0x022a, blocks: (B:30:0x00a8, B:32:0x00ae, B:33:0x00b0), top: B:179:0x00a8 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b3 A[Catch: all -> 0x0235, LoadingException -> 0x0244, RemoteException -> 0x0248, TRY_ENTER, TryCatch #11 {RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235, blocks: (B:29:0x00a7, B:35:0x00b3, B:37:0x00ba, B:38:0x00d8, B:42:0x00de, B:44:0x00e6, B:46:0x00ea, B:47:0x00f5), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ba A[Catch: all -> 0x0235, LoadingException -> 0x0244, RemoteException -> 0x0248, TryCatch #11 {RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235, blocks: (B:29:0x00a7, B:35:0x00b3, B:37:0x00ba, B:38:0x00d8, B:42:0x00de, B:44:0x00e6, B:46:0x00ea, B:47:0x00f5), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00de A[Catch: all -> 0x0235, LoadingException -> 0x0244, RemoteException -> 0x0248, TRY_ENTER, TryCatch #11 {RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235, blocks: (B:29:0x00a7, B:35:0x00b3, B:37:0x00ba, B:38:0x00d8, B:42:0x00de, B:44:0x00e6, B:46:0x00ea, B:47:0x00f5), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0157 A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0169 A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x018f A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0196 A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x019e A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01ad A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x01b8 A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01c8 A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01dd A[Catch: all -> 0x022f, LoadingException -> 0x0231, RemoteException -> 0x0233, TRY_LEAVE, TryCatch #12 {RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f, blocks: (B:55:0x0104, B:57:0x010a, B:59:0x0131, B:61:0x0139, B:62:0x0140, B:63:0x0148, B:58:0x011e, B:66:0x014b, B:67:0x014c, B:68:0x0156, B:69:0x0157, B:70:0x0161, B:74:0x0166, B:77:0x0169, B:79:0x018f, B:81:0x0196, B:83:0x019e, B:89:0x01d7, B:91:0x01dd, B:101:0x0200, B:102:0x0208, B:84:0x01ad, B:85:0x01b5, B:87:0x01b8, B:88:0x01c8, B:103:0x0209, B:104:0x0211, B:105:0x0212, B:106:0x021c, B:115:0x022e), top: B:174:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:95:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:98:0x01f9  */
    /* JADX WARN: Instruction removed from duplicated block: B:153:0x02b9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x00ba, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x0169, please report this as an issue */
    @ResultIgnorabilityUnspecified
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        int i;
        int i2;
        Boolean bool;
        zzq zzqVarZzg;
        int iZze;
        IObjectWrapper iObjectWrapperZzh;
        Object objUnwrap;
        DynamiteModule dynamiteModule;
        zzn zznVar;
        Cursor cursor;
        zzr zzrVar;
        zzn zznVar2;
        Boolean boolValueOf;
        IObjectWrapper iObjectWrapperZze;
        Cursor cursor2;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new LoadingException("null application Context", null);
        }
        ThreadLocal threadLocal = zzg;
        zzn zznVar3 = (zzn) threadLocal.get();
        zzn zznVar4 = new zzn(null);
        threadLocal.set(zznVar4);
        ThreadLocal threadLocal2 = zzh;
        long jLongValue = ((Long) threadLocal2.get()).longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectionResultSelectModule = versionPolicy.selectModule(context, str, zzi);
            Log.i("DynamiteModule", "Considering local module " + str + CertificateUtil.DELIMITER + selectionResultSelectModule.localVersion + " and remote module " + str + CertificateUtil.DELIMITER + selectionResultSelectModule.remoteVersion);
            int i3 = selectionResultSelectModule.selection;
            if (i3 != 0) {
                if (i3 != -1) {
                    if (i3 == 1 || selectionResultSelectModule.remoteVersion != 0) {
                        if (i3 == -1) {
                            DynamiteModule dynamiteModuleZzc = zzc(applicationContext, str);
                            if (jLongValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(jLongValue));
                            }
                            cursor2 = zznVar4.zza;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            threadLocal.set(zznVar3);
                            return dynamiteModuleZzc;
                        }
                        if (i3 == 1) {
                            throw new LoadingException("VersionPolicy returned invalid code:" + i3, null);
                        }
                        try {
                            try {
                                i2 = selectionResultSelectModule.remoteVersion;
                                try {
                                    try {
                                        try {
                                            synchronized (DynamiteModule.class) {
                                                try {
                                                    if (zzf(context)) {
                                                        throw new LoadingException("Remote loading disabled", null);
                                                    }
                                                    bool = zzb;
                                                    if (bool != null) {
                                                        throw new LoadingException("Failed to determine which loading route to use.", null);
                                                    }
                                                    if (bool.booleanValue()) {
                                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i2);
                                                        synchronized (DynamiteModule.class) {
                                                            try {
                                                                zzrVar = zzl;
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                while (true) {
                                                                    try {
                                                                        throw th;
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (zzrVar != null) {
                                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                                        }
                                                        zznVar2 = (zzn) threadLocal.get();
                                                        if (zznVar2 != null || zznVar2.zza == null) {
                                                            throw new LoadingException("No result cursor", null);
                                                        }
                                                        Context applicationContext2 = context.getApplicationContext();
                                                        Cursor cursor3 = zznVar2.zza;
                                                        ObjectWrapper.wrap(null);
                                                        synchronized (DynamiteModule.class) {
                                                            boolValueOf = Boolean.valueOf(zze >= 2);
                                                        }
                                                        if (boolValueOf.booleanValue()) {
                                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                            iObjectWrapperZze = zzrVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i2, ObjectWrapper.wrap(cursor3));
                                                        } else {
                                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                            iObjectWrapperZze = zzrVar.zze(ObjectWrapper.wrap(applicationContext2), str, i2, ObjectWrapper.wrap(cursor3));
                                                        }
                                                        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapperZze);
                                                        if (context2 == null) {
                                                            throw new LoadingException("Failed to get module context", null);
                                                        }
                                                        dynamiteModule = new DynamiteModule(context2);
                                                    } else {
                                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i2);
                                                        zzqVarZzg = zzg(context);
                                                        if (zzqVarZzg != null) {
                                                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                                        }
                                                        iZze = zzqVarZzg.zze();
                                                        if (iZze >= 3) {
                                                            zznVar = (zzn) threadLocal.get();
                                                            if (zznVar != null) {
                                                                throw new LoadingException("No cached result cursor holder", null);
                                                            }
                                                            iObjectWrapperZzh = zzqVarZzg.zzi(ObjectWrapper.wrap(context), str, i2, ObjectWrapper.wrap(zznVar.zza));
                                                        } else if (iZze == 2) {
                                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                            iObjectWrapperZzh = zzqVarZzg.zzj(ObjectWrapper.wrap(context), str, i2);
                                                        } else {
                                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                            iObjectWrapperZzh = zzqVarZzg.zzh(ObjectWrapper.wrap(context), str, i2);
                                                        }
                                                        objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                                        if (objUnwrap != null) {
                                                            throw new LoadingException("Failed to load remote module.", null);
                                                        }
                                                        dynamiteModule = new DynamiteModule((Context) objUnwrap);
                                                    }
                                                    if (jLongValue == 0) {
                                                        threadLocal2.remove();
                                                    } else {
                                                        threadLocal2.set(Long.valueOf(jLongValue));
                                                    }
                                                    cursor = zznVar4.zza;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    threadLocal.set(zznVar3);
                                                    return dynamiteModule;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    throw th;
                                                }
                                            }
                                        } catch (RemoteException e) {
                                            e = e;
                                            throw new LoadingException("Failed to load remote module.", e, null);
                                        } catch (LoadingException e2) {
                                            throw e2;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            CrashUtils.addDynamiteErrorToDropBox(context, th);
                                            throw new LoadingException("Failed to load remote module.", th, null);
                                        }
                                    } catch (RemoteException e3) {
                                        e = e3;
                                        throw new LoadingException("Failed to load remote module.", e, null);
                                    } catch (LoadingException e4) {
                                        throw e4;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        CrashUtils.addDynamiteErrorToDropBox(context, th);
                                        throw new LoadingException("Failed to load remote module.", th, null);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } catch (LoadingException e5) {
                                e = e5;
                                Log.w("DynamiteModule", "Failed to load remote module: " + e.getMessage());
                                i = selectionResultSelectModule.localVersion;
                                if (i != 0) {
                                }
                                throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                            }
                        } catch (LoadingException e6) {
                            e = e6;
                            Log.w("DynamiteModule", "Failed to load remote module: " + e.getMessage());
                            i = selectionResultSelectModule.localVersion;
                            if (i != 0 || versionPolicy.selectModule(context, str, new zzo(i, 0)).selection != -1) {
                                throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                            }
                            DynamiteModule dynamiteModuleZzc2 = zzc(applicationContext, str);
                            if (jLongValue == 0) {
                                zzh.remove();
                            } else {
                                zzh.set(Long.valueOf(jLongValue));
                            }
                            Cursor cursor4 = zznVar4.zza;
                            if (cursor4 != null) {
                                cursor4.close();
                            }
                            zzg.set(zznVar3);
                            return dynamiteModuleZzc2;
                        }
                    }
                } else if (selectionResultSelectModule.localVersion != 0) {
                    i3 = -1;
                    if (i3 == 1) {
                    }
                    if (i3 == -1) {
                        DynamiteModule dynamiteModuleZzc3 = zzc(applicationContext, str);
                        if (jLongValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(jLongValue));
                        }
                        cursor2 = zznVar4.zza;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        threadLocal.set(zznVar3);
                        return dynamiteModuleZzc3;
                    }
                    if (i3 == 1) {
                        throw new LoadingException("VersionPolicy returned invalid code:" + i3, null);
                    }
                    i2 = selectionResultSelectModule.remoteVersion;
                    synchronized (DynamiteModule.class) {
                        if (zzf(context)) {
                            throw new LoadingException("Remote loading disabled", null);
                        }
                        bool = zzb;
                        if (bool != null) {
                            throw new LoadingException("Failed to determine which loading route to use.", null);
                        }
                        if (bool.booleanValue()) {
                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i2);
                            synchronized (DynamiteModule.class) {
                                zzrVar = zzl;
                                if (zzrVar != null) {
                                    throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                }
                                zznVar2 = (zzn) threadLocal.get();
                                if (zznVar2 != null) {
                                }
                                throw new LoadingException("No result cursor", null);
                            }
                        }
                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i2);
                        zzqVarZzg = zzg(context);
                        if (zzqVarZzg != null) {
                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                        }
                        iZze = zzqVarZzg.zze();
                        if (iZze >= 3) {
                            zznVar = (zzn) threadLocal.get();
                            if (zznVar != null) {
                                throw new LoadingException("No cached result cursor holder", null);
                            }
                            iObjectWrapperZzh = zzqVarZzg.zzi(ObjectWrapper.wrap(context), str, i2, ObjectWrapper.wrap(zznVar.zza));
                        } else if (iZze == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                            iObjectWrapperZzh = zzqVarZzg.zzj(ObjectWrapper.wrap(context), str, i2);
                        } else {
                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                            iObjectWrapperZzh = zzqVarZzg.zzh(ObjectWrapper.wrap(context), str, i2);
                        }
                        objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                        if (objUnwrap != null) {
                            throw new LoadingException("Failed to load remote module.", null);
                        }
                        dynamiteModule = new DynamiteModule((Context) objUnwrap);
                        if (jLongValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(jLongValue));
                        }
                        cursor = zznVar4.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(zznVar3);
                        return dynamiteModule;
                    }
                }
            }
            throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectionResultSelectModule.localVersion + " and remote version is " + selectionResultSelectModule.remoteVersion + ".", null);
        } catch (Throwable th7) {
            if (jLongValue == 0) {
                zzh.remove();
            } else {
                zzh.set(Long.valueOf(jLongValue));
            }
            Cursor cursor5 = zznVar4.zza;
            if (cursor5 != null) {
                cursor5.close();
            }
            zzg.set(zznVar3);
            throw th7;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:136:0x01b8 */
    /* JADX WARN: Code duplicated, block: B:94:0x0168 A[Catch: all -> 0x01c4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01c4, blocks: (B:3:0x0002, B:61:0x00db, B:63:0x00e1, B:68:0x0102, B:90:0x015a, B:94:0x0168, B:115:0x01bd, B:116:0x01c0, B:110:0x01b5, B:66:0x00e7, B:119:0x01c3, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:59:0x00d8, B:19:0x0046, B:41:0x009a, B:44:0x009d, B:52:0x00b6, B:60:0x00da, B:58:0x00bc), top: B:127:0x0002, inners: #0, #11 }] */
    public static int zza(Context context, String str, boolean z) {
        Throwable th;
        RemoteException e;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                Cursor cursor2 = null;
                int iZzf = 0;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else if (classLoader != null) {
                                try {
                                    zzd(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            } else {
                                if (!zzf(context)) {
                                    return 0;
                                }
                                if (zzd || Boolean.TRUE.equals(null)) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        int iZzb = zzb(context, str, z, true);
                                        String str2 = zzc;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader classLoaderZza = zzb.zza();
                                            if (classLoaderZza == null) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    String str3 = zzc;
                                                    Preconditions.checkNotNull(str3);
                                                    classLoaderZza = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                                } else {
                                                    String str4 = zzc;
                                                    Preconditions.checkNotNull(str4);
                                                    classLoaderZza = new zzc(str4, ClassLoader.getSystemClassLoader());
                                                }
                                            }
                                            zzd(classLoaderZza);
                                            declaredField.set(null, classLoaderZza);
                                            zzb = Boolean.TRUE;
                                            return iZzb;
                                        }
                                        return iZzb;
                                    } catch (LoadingException unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                            zzb = bool;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e2.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return zzb(context, str, z, false);
                    } catch (LoadingException e3) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e3.getMessage());
                        return 0;
                    }
                }
                zzq zzqVarZzg = zzg(context);
                try {
                    if (zzqVarZzg != null) {
                        try {
                            int iZze = zzqVarZzg.zze();
                            if (iZze >= 3) {
                                zzn zznVar = (zzn) zzg.get();
                                if (zznVar == null || (cursor = zznVar.zza) == null) {
                                    Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(zzqVarZzg.zzk(ObjectWrapper.wrap(context), str, z, ((Long) zzh.get()).longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i = cursor3.getInt(0);
                                                cursor2 = (i <= 0 || !zze(cursor3)) ? cursor3 : null;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                iZzf = i;
                                            } else {
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                            }
                                        } catch (RemoteException e4) {
                                            e = e4;
                                            cursor2 = cursor3;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e.getMessage());
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    }
                                } else {
                                    iZzf = cursor.getInt(0);
                                }
                            } else if (iZze == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iZzf = zzqVarZzg.zzg(ObjectWrapper.wrap(context), str, z);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iZzf = zzqVarZzg.zzf(ObjectWrapper.wrap(context), str, z);
                            }
                        } catch (RemoteException e5) {
                            e = e5;
                        }
                    }
                    return iZzf;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            CrashUtils.addDynamiteErrorToDropBox(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00dc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private static int zzb(Context context, String str, boolean z, boolean z2) throws Throwable {
        Throwable th;
        Exception e;
        ?? r0 = 0;
        ?? r1 = 0;
        ?? r2 = 0;
        ?? r3 = 0;
        try {
            try {
                boolean z3 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) zzh.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z4 = false;
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    zzc = cursorQuery.getString(2);
                                    int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        zze = cursorQuery.getInt(columnIndex);
                                    }
                                    int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                    if (columnIndex2 >= 0) {
                                        if (cursorQuery.getInt(columnIndex2) == 0) {
                                            z3 = false;
                                        }
                                        zzd = z3;
                                        z4 = z3;
                                    }
                                }
                                if (zze(cursorQuery)) {
                                    cursorQuery = null;
                                }
                            }
                            if (z2 && z4) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl", r2 == true ? 1 : 0);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (e instanceof LoadingException) {
                            throw e;
                        }
                        throw new LoadingException("V2 version check failed: " + e.getMessage(), e, r1 == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", r3 == true ? 1 : 0);
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            r0 = context;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        zzp zzpVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder);
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zznVar = (zzn) zzg.get();
        if (zznVar == null || zznVar.zza != null) {
            return false;
        }
        zznVar.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals(null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean zBooleanValue = false;
        if (zzf == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                zBooleanValue = true;
            }
            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
            zzf = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
            if (zBooleanValue && providerInfoResolveContentProvider.applicationInfo != null && (providerInfoResolveContentProvider.applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!zBooleanValue) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return zBooleanValue;
    }

    private static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    @ResultIgnorabilityUnspecified
    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, null);
        }
    }
}
