package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.l.ai;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l extends h {
    public static final Parcelable.Creator<l> CREATOR = new Parcelable.Creator<l>() { // from class: com.applovin.exoplayer2.g.e.l.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dx, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i) {
            return new l[i];
        }
    };
    public final String Jn;
    public final String oc;

    public l(String str, String str2, String str3) {
        super(str);
        this.oc = str2;
        this.Jn = str3;
    }

    l(Parcel parcel) {
        super((String) ai.R(parcel.readString()));
        this.oc = parcel.readString();
        this.Jn = (String) ai.R(parcel.readString());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.applovin.exoplayer2.g.a.InterfaceC0095a
    public void F(ac.a aVar) {
        String str = this.f1do;
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    b2 = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    b2 = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    b2 = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    b2 = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    b2 = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    b2 = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    b2 = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    b2 = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    b2 = 8;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    b2 = 9;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    b2 = 10;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    b2 = 11;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    b2 = 12;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    b2 = 13;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    b2 = 14;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    b2 = 15;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    b2 = 16;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    b2 = 17;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    b2 = 18;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    b2 = 19;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    b2 = 20;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    b2 = 21;
                }
                break;
        }
        try {
            switch (b2) {
                case 0:
                case 10:
                    aVar.c(this.Jn);
                    break;
                case 1:
                case 11:
                    aVar.i(this.Jn);
                    break;
                case 2:
                case 12:
                    aVar.e(Integer.valueOf(Integer.parseInt(this.Jn.substring(2, 4)))).f(Integer.valueOf(Integer.parseInt(this.Jn.substring(0, 2))));
                    break;
                case 3:
                case 17:
                    aVar.b(this.Jn);
                    break;
                case 4:
                case 18:
                    aVar.d(this.Jn);
                    break;
                case 5:
                case 19:
                    aVar.j(this.Jn);
                    break;
                case 6:
                case 20:
                    String[] strArrL = ai.l(this.Jn, RemoteSettings.FORWARD_SLASH_STRING);
                    aVar.a(Integer.valueOf(Integer.parseInt(strArrL[0]))).b(strArrL.length > 1 ? Integer.valueOf(Integer.parseInt(strArrL[1])) : null);
                    break;
                case 7:
                case 16:
                    aVar.a(this.Jn);
                    break;
                case 8:
                case 15:
                    aVar.h(this.Jn);
                    break;
                case 9:
                case 21:
                    aVar.d(Integer.valueOf(Integer.parseInt(this.Jn)));
                    break;
                case 13:
                    List<Integer> listZ = Z(this.Jn);
                    int size = listZ.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                aVar.f(listZ.get(2));
                            }
                        }
                        aVar.e(listZ.get(1));
                    }
                    aVar.d(listZ.get(0));
                    break;
                case 14:
                    List<Integer> listZ2 = Z(this.Jn);
                    int size2 = listZ2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                aVar.i(listZ2.get(2));
                            }
                        }
                        aVar.h(listZ2.get(1));
                    }
                    aVar.g(listZ2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return ai.r(this.f1do, lVar.f1do) && ai.r(this.oc, lVar.oc) && ai.r(this.Jn, lVar.Jn);
    }

    public int hashCode() {
        int iHashCode = (527 + this.f1do.hashCode()) * 31;
        String str = this.oc;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Jn;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.applovin.exoplayer2.g.e.h
    public String toString() {
        return this.f1do + ": description=" + this.oc + ": value=" + this.Jn;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1do);
        parcel.writeString(this.oc);
        parcel.writeString(this.Jn);
    }

    private static List<Integer> Z(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }
}
