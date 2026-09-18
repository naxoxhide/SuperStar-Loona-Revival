package com.igaworks.adpopcorn.cores.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static WeakHashMap<String, Bitmap> a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList<String> f1610b = new ArrayList<>();
    public static int c = 1;

    class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            if (file.lastModified() > file2.lastModified()) {
                return 1;
            }
            return file.lastModified() == file2.lastModified() ? 0 : -1;
        }
    }

    public interface b {
        void a(Bitmap bitmap);
    }

    static class c extends ColorDrawable {
        private final WeakReference<f> a;

        public c(f fVar) {
            super(0);
            this.a = new WeakReference<>(fVar);
        }

        public f a() {
            return this.a.get();
        }
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = c;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static Bitmap a(Context context, String str, int i, int i2, boolean z, boolean z2) {
        String next;
        Bitmap bitmap;
        int iA;
        try {
            String strA = a(context, str, false);
            if (strA == null) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (i == 0 || i2 == 0) {
                iA = c;
            } else {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(strA, options);
                options.inJustDecodeBounds = false;
                iA = a(options, i, i2);
            }
            options.inSampleSize = iA;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return z2 ? BitmapFactory.decodeFile(strA, options) : BitmapFactory.decodeFile(strA);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            try {
                Iterator<String> it = a.keySet().iterator();
                if (it != null && it.hasNext() && (bitmap = a.get((next = it.next()))) != null) {
                    bitmap.recycle();
                    a.remove(next);
                }
                System.gc();
                if (z) {
                    return null;
                }
                return a(context, str, i, i2, true, z2);
            } catch (Exception e3) {
                e3.printStackTrace();
                System.gc();
                return null;
            }
        }
    }

    private static f a(ImageView imageView) {
        if (imageView == null) {
            return null;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof c) {
            return ((c) drawable).a();
        }
        return null;
    }

    public static String a(Context context, String str, boolean z) {
        try {
            int i = Build.VERSION.SDK_INT;
            int iCheckSelfPermission = i >= 23 ? context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") : context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName());
            if (i > 19) {
                iCheckSelfPermission = 0;
            }
            if (!(iCheckSelfPermission == 0)) {
                return null;
            }
            File file = z ? new File(context.getCacheDir() + "/igaw/video") : new File(context.getCacheDir() + "/igaw/image");
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                File file2 = new File(file, ".nomedia");
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Exception unused) {
            }
            String strA = a(str);
            if (strA != null && strA.length() > 0) {
                File file3 = new File(file, strA);
                if (file3.exists()) {
                    return file3.getAbsolutePath();
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            return String.format("%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X", Byte.valueOf(bArrDigest[0]), Byte.valueOf(bArrDigest[1]), Byte.valueOf(bArrDigest[2]), Byte.valueOf(bArrDigest[3]), Byte.valueOf(bArrDigest[4]), Byte.valueOf(bArrDigest[5]), Byte.valueOf(bArrDigest[6]), Byte.valueOf(bArrDigest[7]), Byte.valueOf(bArrDigest[8]), Byte.valueOf(bArrDigest[9]), Byte.valueOf(bArrDigest[10]), Byte.valueOf(bArrDigest[11]), Byte.valueOf(bArrDigest[12]), Byte.valueOf(bArrDigest[13]), Byte.valueOf(bArrDigest[14]), Byte.valueOf(bArrDigest[15]));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Context context) {
        try {
            WeakHashMap<String, Bitmap> weakHashMap = a;
            if (weakHashMap != null) {
                for (Object obj : weakHashMap.keySet().toArray()) {
                    String str = (String) obj;
                    if (a.get(str) != null) {
                        a.remove(str);
                    }
                }
                a.clear();
            }
            ArrayList<String> arrayList = f1610b;
            if (arrayList != null) {
                arrayList.clear();
            }
        } catch (Exception unused) {
            WeakHashMap<String, Bitmap> weakHashMap2 = a;
            if (weakHashMap2 != null) {
                weakHashMap2.clear();
            }
            ArrayList<String> arrayList2 = f1610b;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        try {
            File file = new File(context.getCacheDir() + "/igaw/image");
            if (file.exists() && file.listFiles().length > 150) {
                int length = file.listFiles().length;
                h.a(context, "APDownloader", "Delete local image file : " + length, 3);
                File[] fileArrListFiles = file.listFiles();
                Arrays.sort(fileArrListFiles, new a());
                for (File file2 : fileArrListFiles) {
                    if (file2.isFile()) {
                        Calendar.getInstance().setTimeInMillis(file2.lastModified());
                        file2.delete();
                        length--;
                        if (length <= 140) {
                            break;
                        }
                    }
                }
                h.a(context, "APDownloader", "Delete local image file : " + length, 3);
            }
        } catch (Exception unused2) {
        }
    }

    public static void a(Context context, String str) {
        if (a(context, str, true) != null) {
            return;
        }
        h.a(context, "APDownloader", "Video downloading...", 3);
        new f(context, str).start();
    }

    public static void a(Context context, String str, int i, int i2) {
        if (a(context, str, false) != null) {
            return;
        }
        h.a(context, "APDownloader", "Image downloading...", 3);
        f fVar = new f(context, str, null, i, i2, true);
        fVar.a(new c(fVar));
        fVar.start();
    }

    public static void a(Context context, String str, ImageView imageView, int i, int i2, b bVar) {
        boolean z;
        try {
            if (a == null) {
                a = new WeakHashMap<>();
            }
            try {
                if (f1610b == null) {
                    f1610b = new ArrayList<>();
                }
                int iIndexOf = f1610b.indexOf(str);
                if (iIndexOf >= 0) {
                    f1610b.remove(iIndexOf);
                }
                f1610b.add(0, str);
            } catch (Exception unused) {
            }
            Bitmap bitmapA = a.get(str);
            if (bitmapA == null) {
                bitmapA = a(context, str, i, i2, false, true);
                if (bitmapA != null) {
                    a.put(str, bitmapA);
                }
                z = true;
            } else {
                z = false;
            }
            if (bitmapA != null) {
                if (bVar != null) {
                    bVar.a(bitmapA);
                }
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setImageBitmap(bitmapA);
                }
            } else if (a(str, imageView)) {
                if (a.size() > 70) {
                    a.clear();
                }
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setBackgroundColor(0);
                }
                f fVar = new f(context, str, imageView, i, i2, bVar, true);
                fVar.a(new c(fVar));
                fVar.start();
            }
            if (!z || a.size() <= 70) {
                return;
            }
            try {
                int size = f1610b.size() - 1;
                if (a.get(f1610b.get(size)) != null) {
                    a.remove(f1610b.get(size));
                }
                f1610b.remove(size);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception unused2) {
        }
    }

    private static boolean a(String str, ImageView imageView) {
        f fVarA = a(imageView);
        if (fVarA != null) {
            String str2 = fVarA.a;
            if (str2 != null && str2.equals(str)) {
                return false;
            }
            fVarA.a(true);
        }
        return true;
    }

    public static void b(Context context) {
        if (a == null) {
            a = new WeakHashMap<>();
        }
        if (f1610b == null) {
            f1610b = new ArrayList<>();
        }
    }
}
