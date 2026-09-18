package com.igaworks.adpopcorn.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static WeakHashMap<String, Bitmap> a = new WeakHashMap<>();

    public static int a(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, str2, context.getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Bitmap a(Context context, String str) {
        if (str != null && !str.equals("")) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = 1;
            try {
                int identifier = context.getResources().getIdentifier(str.contains(".") ? str.substring(0, str.lastIndexOf(".")) : str, "drawable", context.getPackageName());
                if (identifier > 0) {
                    InputStream inputStreamOpenRawResource = context.getResources().openRawResource(identifier);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenRawResource, null, options);
                    if (inputStreamOpenRawResource != null) {
                        try {
                            inputStreamOpenRawResource.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return bitmapDecodeStream;
                }
            } catch (Exception unused) {
            }
            try {
                try {
                    InputStream inputStreamOpen = context.getResources().getAssets().open("igaworks/adpopcorn/res/" + str);
                    Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStreamOpen, null, options);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    return bitmapDecodeStream2;
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                InputStream resourceAsStream = context.getClassLoader().getResourceAsStream("com/igaworks/adpopcorn/res/" + str);
                Bitmap bitmapDecodeStream3 = BitmapFactory.decodeStream(resourceAsStream, null, options);
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return bitmapDecodeStream3;
            }
        }
        return null;
    }

    public static Bitmap a(Context context, String str, ImageView imageView, boolean z) {
        String next;
        Bitmap bitmap;
        Bitmap bitmapA;
        try {
            try {
                WeakHashMap<String, Bitmap> weakHashMap = a;
                if (weakHashMap == null || !weakHashMap.containsKey(str)) {
                    bitmapA = a(context, str);
                    if (bitmapA != null) {
                        try {
                            if (a == null) {
                                a = new WeakHashMap<>();
                            }
                            a.put(str, bitmapA);
                        } catch (Exception unused) {
                        }
                    }
                    return bitmapA;
                }
                bitmapA = a.get(str);
                if (bitmapA != null && imageView != null) {
                    if (z) {
                        imageView.setBackgroundDrawable(new BitmapDrawable(bitmapA));
                    } else {
                        imageView.setImageBitmap(bitmapA);
                    }
                }
                return bitmapA;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                try {
                    Iterator<String> it = a.keySet().iterator();
                    if (it != null && it.hasNext() && (bitmap = a.get((next = it.next()))) != null) {
                        bitmap.recycle();
                        a.remove(next);
                    }
                    a.clear();
                    System.gc();
                    return null;
                } catch (Exception unused2) {
                    System.gc();
                    return null;
                }
            }
        } catch (Exception unused3) {
            return null;
        }
    }

    public static void a() {
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
        } catch (Exception unused) {
            WeakHashMap<String, Bitmap> weakHashMap2 = a;
            if (weakHashMap2 != null) {
                weakHashMap2.clear();
            }
        }
    }
}
