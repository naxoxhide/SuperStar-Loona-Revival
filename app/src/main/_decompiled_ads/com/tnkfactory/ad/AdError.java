package com.tnkfactory.ad;

/* JADX INFO: loaded from: classes4.dex */
public enum AdError {
    NO_ERROR(0),
    FAIL_NO_AD(-1),
    FAIL_NO_IMAGE(-2),
    FAIL_TIMEOUT(-3),
    FAIL_CANCELED(-4),
    FAIL_SHOW_BEFORE_LOAD(-5),
    FAIL_AD_FRAME(-6),
    FAIL_DUP_LOAD(-7),
    FAIL_DUP_SHOW(-8),
    FAIL_BANNER_HEIGHT_50DP(-21),
    FAIL_BANNER_HEIGHT_100DP(-22),
    FAIL_NO_PLACEMENT_ID(-23),
    FAIL_INCORRECT_PLACEMENT(-24),
    FAIL_SCREEN_ORIENTATION(-25),
    FAIL_INVALID_STATE(-26),
    FAIL_BANNER_ON_PAUSE(-27),
    FAIL_TEST_DEVICE_NOT_REGISTERED(-28),
    FAIL_FINISHED_ACTIVITY(-29),
    FAIL_SYSTEM(-99);

    private final int code;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AdError.values().length];
            a = iArr;
            try {
                iArr[AdError.NO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdError.FAIL_NO_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdError.FAIL_NO_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdError.FAIL_TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdError.FAIL_CANCELED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdError.FAIL_SHOW_BEFORE_LOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AdError.FAIL_AD_FRAME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdError.FAIL_DUP_LOAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdError.FAIL_DUP_SHOW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdError.FAIL_BANNER_HEIGHT_50DP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[AdError.FAIL_BANNER_HEIGHT_100DP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[AdError.FAIL_NO_PLACEMENT_ID.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[AdError.FAIL_INCORRECT_PLACEMENT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[AdError.FAIL_SCREEN_ORIENTATION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[AdError.FAIL_INVALID_STATE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[AdError.FAIL_TEST_DEVICE_NOT_REGISTERED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[AdError.FAIL_FINISHED_ACTIVITY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[AdError.FAIL_SYSTEM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    AdError(int i) {
        this.code = i;
    }

    public String getMessage() {
        switch (a.a[ordinal()]) {
            case 1:
                return "Success.";
            case 2:
                return "No ad available.";
            case 3:
                return "Ad creative not available.";
            case 4:
                return "Ad arrived too late.";
            case 5:
                return "Ad requested too frequently.";
            case 6:
                return "Ad show called before ad is loaded.";
            case 7:
                return "Cannot build ad layout.";
            case 8:
                return "Ad load called while in loading or showing state.";
            case 9:
                return "Ad show called while ad is showing";
            case 10:
                return "Height of banner is too small(<50dp).";
            case 11:
                return "Height of banner is too small(<100dp).";
            case 12:
                return "Placement ID is not specified.";
            case 13:
                return "Publisher Id or Placement Id is not registered.";
            case 14:
                return "Ad orientation is not matched with screen.";
            case 15:
                return "AdItem is not initialized or destroyed.";
            case 16:
                return "Test device not registered.";
            case 17:
                return "Trying to display using finished Activity.";
            case 18:
                return "System error.";
            default:
                return "";
        }
    }

    public int getValue() {
        return this.code;
    }
}
