package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.util.Xml;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private static final String TAG = "MpdParser";
    private final String contentId;
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    protected void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
    }

    public DashManifestParser() {
        this(null);
    }

    public DashManifestParser(String str) {
        this.contentId = str;
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() != 2 || !"MPD".equals(xmlPullParserNewPullParser.getName())) {
                throw new ParserException("inputStream does not contain a valid media presentation description");
            }
            return parseMediaPresentationDescription(xmlPullParserNewPullParser, uri.toString());
        } catch (XmlPullParserException e) {
            throw new ParserException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0083  */
    protected DashManifest parseMediaPresentationDescription(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        UtcTimingElement utcTiming;
        long dateTime = parseDateTime(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long duration = parseDuration(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long duration2 = parseDuration(xmlPullParser, "minBufferTime", -9223372036854775807L);
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        boolean z = attributeValue != null && "dynamic".equals(attributeValue);
        long duration3 = z ? parseDuration(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long duration4 = z ? parseDuration(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long duration5 = z ? parseDuration(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long dateTime2 = parseDateTime(xmlPullParser, "publishTime", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        long j = z ? -9223372036854775807L : 0L;
        Uri uri = null;
        boolean z3 = false;
        String baseUrl = str;
        UtcTimingElement utcTimingElement = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (z3) {
                    utcTiming = utcTimingElement;
                    baseUrl = baseUrl;
                    j = j;
                } else {
                    baseUrl = parseBaseUrl(xmlPullParser, baseUrl);
                    utcTiming = utcTimingElement;
                    z3 = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "UTCTiming")) {
                utcTiming = parseUtcTiming(xmlPullParser);
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, HttpHeaders.LOCATION)) {
                    uri = Uri.parse(xmlPullParser.nextText());
                } else if (!XmlPullParserUtil.isStartTag(xmlPullParser, "Period") || z2) {
                    utcTiming = utcTimingElement;
                    baseUrl = baseUrl;
                    j = j;
                } else {
                    Pair<Period, Long> period = parsePeriod(xmlPullParser, baseUrl, j);
                    String str2 = baseUrl;
                    Period period2 = (Period) period.first;
                    long j2 = j;
                    if (period2.startMs != -9223372036854775807L) {
                        long jLongValue = ((Long) period.second).longValue();
                        long j3 = jLongValue == -9223372036854775807L ? -9223372036854775807L : period2.startMs + jLongValue;
                        arrayList.add(period2);
                        j = j3;
                        baseUrl = str2;
                    } else {
                        if (!z) {
                            throw new ParserException("Unable to determine start of period " + arrayList.size());
                        }
                        utcTiming = utcTimingElement;
                        baseUrl = str2;
                        j = j2;
                        z2 = true;
                    }
                }
                utcTiming = utcTimingElement;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "MPD")) {
                if (duration == -9223372036854775807L) {
                    if (j != -9223372036854775807L) {
                        duration = j;
                    } else if (!z) {
                        throw new ParserException("Unable to determine duration of static manifest.");
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new ParserException("No periods found.");
                }
                return buildMediaPresentationDescription(dateTime, duration, duration2, z, duration3, duration4, duration5, dateTime2, utcTiming, uri, arrayList);
            }
            utcTimingElement = utcTiming;
        }
    }

    protected DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        return new DashManifest(j, j2, j3, z, j4, j5, j6, j7, utcTimingElement, uri, list);
    }

    protected UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    protected UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    protected Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long duration = parseDuration(xmlPullParser, "start", j);
        long duration2 = parseDuration(xmlPullParser, "duration", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        SegmentBase segmentTemplate = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z) {
                    str = parseBaseUrl(xmlPullParser, str);
                    z = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "AdaptationSet")) {
                arrayList.add(parseAdaptationSet(xmlPullParser, str, segmentTemplate));
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "EventStream")) {
                arrayList2.add(parseEventStream(xmlPullParser));
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                segmentTemplate = parseSegmentBase(xmlPullParser, null);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                segmentTemplate = parseSegmentList(xmlPullParser, null);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                segmentTemplate = parseSegmentTemplate(xmlPullParser, null);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Period"));
        return Pair.create(buildPeriod(attributeValue, duration, arrayList, arrayList2), Long.valueOf(duration2));
    }

    protected Period buildPeriod(String str, long j, List<AdaptationSet> list, List<EventStream> list2) {
        return new Period(str, j, list, list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected AdaptationSet parseAdaptationSet(XmlPullParser xmlPullParser, String str, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        String str2;
        String baseUrl;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        String str3;
        String str4;
        XmlPullParser xmlPullParser2;
        int i;
        ArrayList arrayList5;
        SegmentBase segmentTemplate;
        int iCheckContentTypeConsistency;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        int i2 = parseInt(xmlPullParser3, "id", -1);
        int contentType = parseContentType(xmlPullParser);
        String str5 = null;
        String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
        int i3 = parseInt(xmlPullParser3, "width", -1);
        int i4 = parseInt(xmlPullParser3, "height", -1);
        float frameRate = parseFrameRate(xmlPullParser3, -1.0f);
        int i5 = parseInt(xmlPullParser3, "audioSamplingRate", -1);
        String str6 = "lang";
        String attributeValue3 = xmlPullParser3.getAttributeValue(null, "lang");
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        String str7 = str;
        SegmentBase segmentBase2 = segmentBase;
        int i6 = contentType;
        int audioChannelConfiguration = -1;
        String strCheckLanguageConsistency = attributeValue3;
        String str8 = null;
        boolean z = false;
        int role = 0;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser3, "BaseURL")) {
                if (!z) {
                    z = true;
                    baseUrl = parseBaseUrl(xmlPullParser3, str7);
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    str3 = str6;
                    str4 = str5;
                    xmlPullParser2 = xmlPullParser3;
                    iCheckContentTypeConsistency = i6;
                }
                str2 = strCheckLanguageConsistency;
                i = i6;
                baseUrl = str7;
                arrayList = arrayList10;
                arrayList2 = arrayList9;
                arrayList3 = arrayList8;
                arrayList5 = arrayList7;
                arrayList4 = arrayList6;
                str3 = str6;
                str4 = str5;
                xmlPullParser2 = xmlPullParser3;
                iCheckContentTypeConsistency = i;
                strCheckLanguageConsistency = str2;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> contentProtection = parseContentProtection(xmlPullParser);
                    if (contentProtection.first != null) {
                        str8 = (String) contentProtection.first;
                    }
                    if (contentProtection.second != null) {
                        arrayList6.add(contentProtection.second);
                    }
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentComponent")) {
                    strCheckLanguageConsistency = checkLanguageConsistency(strCheckLanguageConsistency, xmlPullParser3.getAttributeValue(str5, str6));
                    baseUrl = str7;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    str3 = str6;
                    str4 = str5;
                    iCheckContentTypeConsistency = checkContentTypeConsistency(i6, parseContentType(xmlPullParser));
                    xmlPullParser2 = xmlPullParser3;
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Role")) {
                    role |= parseRole(xmlPullParser);
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "AudioChannelConfiguration")) {
                    audioChannelConfiguration = parseAudioChannelConfiguration(xmlPullParser);
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Accessibility")) {
                        arrayList8.add(parseDescriptor(xmlPullParser3, "Accessibility"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "SupplementalProperty")) {
                        arrayList9.add(parseDescriptor(xmlPullParser3, "SupplementalProperty"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Representation")) {
                        String str9 = strCheckLanguageConsistency;
                        baseUrl = str7;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        arrayList4 = arrayList6;
                        str3 = str6;
                        str4 = str5;
                        RepresentationInfo representation = parseRepresentation(xmlPullParser, str7, attributeValue, attributeValue2, i3, i4, frameRate, audioChannelConfiguration, i5, str9, role, arrayList3, segmentBase2);
                        int iCheckContentTypeConsistency2 = checkContentTypeConsistency(i6, getContentType(representation.format));
                        arrayList = arrayList10;
                        arrayList.add(representation);
                        iCheckContentTypeConsistency = iCheckContentTypeConsistency2;
                        strCheckLanguageConsistency = str9;
                        arrayList5 = arrayList7;
                        xmlPullParser2 = xmlPullParser;
                    } else {
                        str2 = strCheckLanguageConsistency;
                        baseUrl = str7;
                        arrayList = arrayList10;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        ArrayList arrayList11 = arrayList7;
                        arrayList4 = arrayList6;
                        str3 = str6;
                        str4 = str5;
                        xmlPullParser2 = xmlPullParser;
                        i = i6;
                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                            segmentTemplate = parseSegmentBase(xmlPullParser2, (SegmentBase.SingleSegmentBase) segmentBase2);
                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                            segmentTemplate = parseSegmentList(xmlPullParser2, (SegmentBase.SegmentList) segmentBase2);
                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                            segmentTemplate = parseSegmentTemplate(xmlPullParser2, (SegmentBase.SegmentTemplate) segmentBase2);
                        } else {
                            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "InbandEventStream")) {
                                arrayList5 = arrayList11;
                                arrayList5.add(parseDescriptor(xmlPullParser2, "InbandEventStream"));
                            } else {
                                arrayList5 = arrayList11;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                                    parseAdaptationSetChild(xmlPullParser);
                                }
                            }
                            iCheckContentTypeConsistency = i;
                            strCheckLanguageConsistency = str2;
                        }
                        segmentBase2 = segmentTemplate;
                        iCheckContentTypeConsistency = i;
                        strCheckLanguageConsistency = str2;
                        arrayList5 = arrayList11;
                    }
                    str2 = strCheckLanguageConsistency;
                    i = i6;
                    baseUrl = str7;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    str3 = str6;
                    str4 = str5;
                    xmlPullParser2 = xmlPullParser3;
                    iCheckContentTypeConsistency = i;
                    strCheckLanguageConsistency = str2;
                }
                baseUrl = str7;
                arrayList = arrayList10;
                arrayList2 = arrayList9;
                arrayList3 = arrayList8;
                arrayList5 = arrayList7;
                arrayList4 = arrayList6;
                str3 = str6;
                str4 = str5;
                xmlPullParser2 = xmlPullParser3;
                iCheckContentTypeConsistency = i6;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                break;
            }
            xmlPullParser3 = xmlPullParser2;
            arrayList7 = arrayList5;
            i6 = iCheckContentTypeConsistency;
            arrayList9 = arrayList2;
            arrayList8 = arrayList3;
            arrayList6 = arrayList4;
            str6 = str3;
            str5 = str4;
            arrayList10 = arrayList;
            str7 = baseUrl;
        }
        ArrayList arrayList12 = new ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList12.add(buildRepresentation((RepresentationInfo) arrayList.get(i7), this.contentId, str8, arrayList4, arrayList5));
        }
        return buildAdaptationSet(i2, iCheckContentTypeConsistency, arrayList12, arrayList3, arrayList2);
    }

    protected AdaptationSet buildAdaptationSet(int i, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3) {
        return new AdaptationSet(i, i2, list, list2, list3);
    }

    protected int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    protected int getContentType(Format format) {
        String str = format.sampleMimeType;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (MimeTypes.isVideo(str)) {
            return 2;
        }
        if (MimeTypes.isAudio(str)) {
            return 1;
        }
        return mimeTypeIsRawText(str) ? 3 : -1;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0086  */
    /* JADX WARN: Code duplicated, block: B:68:0x0115  */
    /* JADX WARN: Code duplicated, block: B:71:0x0122 A[LOOP:1: B:37:0x008b->B:71:0x0122, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.UUID] */
    protected Pair<String, DrmInitData.SchemeData> parseContentProtection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue;
        byte[] bArrBuildPsshAtom;
        byte[] bArr;
        Object obj;
        UUID uuid;
        byte[] bArr2;
        ?? r6;
        ?? r5;
        ?? r9;
        ?? r10;
        boolean z;
        ?? attributeValue2;
        ?? r7;
        UUID uuid2;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue3 != null) {
            String lowerInvariant = Util.toLowerInvariant(attributeValue3);
            lowerInvariant.hashCode();
            switch (lowerInvariant) {
                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95":
                    uuid2 = C.PLAYREADY_UUID;
                    attributeValue = null;
                    bArrBuildPsshAtom = null;
                    bArr = null;
                    obj = uuid2;
                    break;
                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed":
                    uuid2 = C.WIDEVINE_UUID;
                    attributeValue = null;
                    bArrBuildPsshAtom = null;
                    bArr = null;
                    obj = uuid2;
                    break;
                case "urn:mpeg:dash:mp4protection:2011":
                    attributeValue = xmlPullParser.getAttributeValue(null, "value");
                    String attributeValueIgnorePrefix = XmlPullParserUtil.getAttributeValueIgnorePrefix(xmlPullParser, "default_KID");
                    if (!TextUtils.isEmpty(attributeValueIgnorePrefix) && !"00000000-0000-0000-0000-000000000000".equals(attributeValueIgnorePrefix)) {
                        String[] strArrSplit = attributeValueIgnorePrefix.split("\\s+");
                        UUID[] uuidArr = new UUID[strArrSplit.length];
                        for (int i = 0; i < strArrSplit.length; i++) {
                            uuidArr[i] = UUID.fromString(strArrSplit[i]);
                        }
                        bArrBuildPsshAtom = PsshAtomUtil.buildPsshAtom(C.COMMON_PSSH_UUID, uuidArr, null);
                        bArr = null;
                        obj = C.COMMON_PSSH_UUID;
                        break;
                    } else {
                        bArrBuildPsshAtom = null;
                        byte[] bArr3 = bArrBuildPsshAtom;
                        bArr = bArr3;
                        obj = bArr3;
                        break;
                    }
                    break;
                default:
                    attributeValue = null;
                    bArrBuildPsshAtom = null;
                    byte[] bArr4 = bArrBuildPsshAtom;
                    bArr = bArr4;
                    obj = bArr4;
                    break;
            }
        } else {
            attributeValue = null;
            bArrBuildPsshAtom = null;
            byte[] bArr5 = bArrBuildPsshAtom;
            bArr = bArr5;
            obj = bArr5;
        }
        boolean z2 = false;
        ?? r8 = obj;
        ?? r11 = bArr;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
                r7 = r8;
                attributeValue2 = xmlPullParser.getAttributeValue(null, "licenseUrl");
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "widevine:license")) {
                String attributeValue4 = xmlPullParser.getAttributeValue(null, "robustness_level");
                if (attributeValue4 == null || !attributeValue4.startsWith("HW")) {
                    r7 = r8;
                    attributeValue2 = r11;
                    r7 = r8;
                    attributeValue2 = r11;
                    z2 = false;
                    r7 = r8;
                    attributeValue2 = r11;
                } else {
                    r7 = r8;
                    attributeValue2 = r11;
                    z2 = true;
                    r7 = r8;
                    attributeValue2 = r11;
                }
            } else {
                if (bArrBuildPsshAtom == null) {
                    if (XmlPullParserUtil.isStartTagIgnorePrefix(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                        bArrBuildPsshAtom = Base64.decode(xmlPullParser.getText(), 0);
                        uuid = PsshAtomUtil.parseUuid(bArrBuildPsshAtom);
                        if (uuid == null) {
                            r7 = uuid;
                            attributeValue2 = r11;
                            Log.w(TAG, "Skipping malformed cenc:pssh data");
                            bArr2 = null;
                            r5 = uuid;
                            r6 = r11;
                        }
                    } else {
                        boolean zEquals = C.PLAYREADY_UUID.equals(r8);
                        r7 = r8;
                        attributeValue2 = r11;
                        if (zEquals && XmlPullParserUtil.isStartTag(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                            r7 = r8;
                            attributeValue2 = r11;
                            r7 = r8;
                            attributeValue2 = r11;
                            bArrBuildPsshAtom = PsshAtomUtil.buildPsshAtom(C.PLAYREADY_UUID, Base64.decode(xmlPullParser.getText(), 0));
                            r7 = r8;
                            attributeValue2 = r11;
                        }
                    }
                }
                r9 = r5;
                r10 = r6;
                z = z2;
                if (XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection")) {
                    return Pair.create(attributeValue, r9 != 0 ? new DrmInitData.SchemeData(r9, r10, "video/mp4", bArr2, z) : null);
                }
                r8 = r9;
                r11 = r10;
                bArrBuildPsshAtom = bArr2;
                z2 = z;
            }
            r7 = r8;
            attributeValue2 = r11;
            r7 = r8;
            attributeValue2 = r11;
            r7 = r8;
            attributeValue2 = r11;
            r7 = uuid;
            attributeValue2 = r11;
            bArr2 = bArrBuildPsshAtom;
            r5 = r7;
            r6 = attributeValue2;
            r9 = r5;
            r10 = r6;
            z = z2;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection")) {
                return Pair.create(attributeValue, r9 != 0 ? new DrmInitData.SchemeData(r9, r10, "video/mp4", bArr2, z) : null);
            }
            r8 = r9;
            r11 = r10;
            bArrBuildPsshAtom = bArr2;
            z2 = z;
        }
    }

    protected int parseRole(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", null);
        String string2 = parseString(xmlPullParser, "value", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Role"));
        return ("urn:mpeg:dash:role:2011".equals(string) && "main".equals(string2)) ? 1 : 0;
    }

    protected RepresentationInfo parseRepresentation(XmlPullParser xmlPullParser, String str, String str2, String str3, int i, int i2, float f, int i3, int i4, String str4, int i5, List<Descriptor> list, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        String str5;
        SegmentBase segmentTemplate;
        String baseUrl;
        SegmentBase segmentBase2;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int i6 = parseInt(xmlPullParser, "bandwidth", -1);
        String string = parseString(xmlPullParser, "mimeType", str2);
        String string2 = parseString(xmlPullParser, "codecs", str3);
        int i7 = parseInt(xmlPullParser, "width", i);
        int i8 = parseInt(xmlPullParser, "height", i2);
        float frameRate = parseFrameRate(xmlPullParser, f);
        int i9 = parseInt(xmlPullParser, "audioSamplingRate", i4);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        SegmentBase segmentBase3 = segmentBase;
        String str6 = null;
        boolean z = false;
        String str7 = str;
        int audioChannelConfiguration = i3;
        while (true) {
            xmlPullParser.next();
            int i10 = audioChannelConfiguration;
            if (!XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "AudioChannelConfiguration")) {
                    audioChannelConfiguration = parseAudioChannelConfiguration(xmlPullParser);
                    str6 = str6;
                    baseUrl = str7;
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                        segmentTemplate = parseSegmentBase(xmlPullParser, (SegmentBase.SingleSegmentBase) segmentBase3);
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                        segmentTemplate = parseSegmentList(xmlPullParser, (SegmentBase.SegmentList) segmentBase3);
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                        segmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) segmentBase3);
                    } else {
                        if (XmlPullParserUtil.isStartTag(xmlPullParser, "ContentProtection")) {
                            Pair<String, DrmInitData.SchemeData> contentProtection = parseContentProtection(xmlPullParser);
                            str5 = str7;
                            if (contentProtection.first != null) {
                                str6 = (String) contentProtection.first;
                            }
                            if (contentProtection.second != null) {
                                arrayList.add(contentProtection.second);
                            }
                        } else {
                            str5 = str7;
                            if (XmlPullParserUtil.isStartTag(xmlPullParser, "InbandEventStream")) {
                                arrayList2.add(parseDescriptor(xmlPullParser, "InbandEventStream"));
                            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SupplementalProperty")) {
                                arrayList3.add(parseDescriptor(xmlPullParser, "SupplementalProperty"));
                            }
                        }
                        audioChannelConfiguration = i10;
                        str6 = str6;
                        baseUrl = str5;
                    }
                    baseUrl = str7;
                    z = z;
                    segmentBase2 = segmentTemplate;
                    audioChannelConfiguration = i10;
                }
                segmentBase2 = segmentBase3;
            } else if (z) {
                str5 = str7;
                audioChannelConfiguration = i10;
                str6 = str6;
                baseUrl = str5;
                segmentBase2 = segmentBase3;
            } else {
                segmentBase2 = segmentBase3;
                baseUrl = parseBaseUrl(xmlPullParser, str7);
                z = true;
                audioChannelConfiguration = i10;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                break;
            }
            segmentBase3 = segmentBase2;
            z = z;
            str7 = baseUrl;
            str6 = str6;
        }
        return new RepresentationInfo(buildFormat(attributeValue, string, i7, i8, frameRate, audioChannelConfiguration, i9, i6, str4, i5, list, string2, arrayList3), baseUrl, segmentBase2 != null ? segmentBase2 : new SegmentBase.SingleSegmentBase(), str6, arrayList, arrayList2, -1L);
    }

    protected Format buildFormat(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, int i6, List<Descriptor> list, String str4, List<Descriptor> list2) {
        String str5;
        int cea708AccessibilityChannel;
        String sampleMimeType = getSampleMimeType(str2, str4);
        if (sampleMimeType != null) {
            if ("audio/eac3".equals(sampleMimeType)) {
                sampleMimeType = parseEac3SupplementalProperties(list2);
            }
            str5 = sampleMimeType;
            if (MimeTypes.isVideo(str5)) {
                return Format.createVideoContainerFormat(str, str2, str5, str4, i5, i, i2, f, null, i6);
            }
            if (MimeTypes.isAudio(str5)) {
                return Format.createAudioContainerFormat(str, str2, str5, str4, i5, i3, i4, null, i6, str3);
            }
            if (mimeTypeIsRawText(str5)) {
                if ("application/cea-608".equals(str5)) {
                    cea708AccessibilityChannel = parseCea608AccessibilityChannel(list);
                } else {
                    cea708AccessibilityChannel = "application/cea-708".equals(str5) ? parseCea708AccessibilityChannel(list) : -1;
                }
                return Format.createTextContainerFormat(str, str2, str5, str4, i5, i6, str3, cea708AccessibilityChannel);
            }
        } else {
            str5 = sampleMimeType;
        }
        return Format.createContainerFormat(str, str2, str5, str4, i5, i6, str3);
    }

    protected Representation buildRepresentation(RepresentationInfo representationInfo, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        Format formatCopyWithDrmInitData = representationInfo.format;
        if (representationInfo.drmSchemeType != null) {
            str2 = representationInfo.drmSchemeType;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            filterRedundantIncompleteSchemeDatas(arrayList3);
            formatCopyWithDrmInitData = formatCopyWithDrmInitData.copyWithDrmInitData(new DrmInitData(str2, arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return Representation.newInstance(str, representationInfo.revisionId, formatCopyWithDrmInitData, representationInfo.baseUrl, representationInfo.segmentBase, arrayList4);
    }

    protected SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long j3 = parseLong(xmlPullParser, "timescale", singleSegmentBase != null ? singleSegmentBase.timescale : 1L);
        long j4 = parseLong(xmlPullParser, "presentationTimeOffset", singleSegmentBase != null ? singleSegmentBase.presentationTimeOffset : 0L);
        long j5 = singleSegmentBase != null ? singleSegmentBase.indexStart : 0L;
        long j6 = singleSegmentBase != null ? singleSegmentBase.indexLength : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            long j7 = Long.parseLong(strArrSplit[0]);
            j = (Long.parseLong(strArrSplit[1]) - j7) + 1;
            j2 = j7;
        } else {
            j = j6;
            j2 = j5;
        }
        RangedUri initialization = singleSegmentBase != null ? singleSegmentBase.initialization : null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentBase"));
        return buildSingleSegmentBase(initialization, j3, j4, j2, j);
    }

    protected SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j, j2, j3, j4);
    }

    protected SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList) throws XmlPullParserException, IOException {
        long j = parseLong(xmlPullParser, "timescale", segmentList != null ? segmentList.timescale : 1L);
        long j2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentList != null ? segmentList.presentationTimeOffset : 0L);
        long j3 = parseLong(xmlPullParser, "duration", segmentList != null ? segmentList.duration : -9223372036854775807L);
        long j4 = parseLong(xmlPullParser, "startNumber", segmentList != null ? segmentList.startNumber : 1L);
        List<RangedUri> arrayList = null;
        RangedUri initialization = null;
        List<SegmentBase.SegmentTimelineElement> segmentTimeline = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(parseSegmentUrl(xmlPullParser));
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentList"));
        if (segmentList != null) {
            if (initialization == null) {
                initialization = segmentList.initialization;
            }
            if (segmentTimeline == null) {
                segmentTimeline = segmentList.segmentTimeline;
            }
            if (arrayList == null) {
                arrayList = segmentList.mediaSegments;
            }
        }
        return buildSegmentList(initialization, j, j2, j4, j3, segmentTimeline, arrayList);
    }

    protected SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentBase.SegmentTimelineElement> list, List<RangedUri> list2) {
        return new SegmentBase.SegmentList(rangedUri, j, j2, j3, j4, list, list2);
    }

    protected SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate) throws XmlPullParserException, IOException {
        long j = parseLong(xmlPullParser, "timescale", segmentTemplate != null ? segmentTemplate.timescale : 1L);
        long j2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentTemplate != null ? segmentTemplate.presentationTimeOffset : 0L);
        long j3 = parseLong(xmlPullParser, "duration", segmentTemplate != null ? segmentTemplate.duration : -9223372036854775807L);
        long j4 = parseLong(xmlPullParser, "startNumber", segmentTemplate != null ? segmentTemplate.startNumber : 1L);
        RangedUri initialization = null;
        UrlTemplate urlTemplate = parseUrlTemplate(xmlPullParser, ShareConstants.WEB_DIALOG_PARAM_MEDIA, segmentTemplate != null ? segmentTemplate.mediaTemplate : null);
        UrlTemplate urlTemplate2 = parseUrlTemplate(xmlPullParser, "initialization", segmentTemplate != null ? segmentTemplate.initializationTemplate : null);
        List<SegmentBase.SegmentTimelineElement> segmentTimeline = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTemplate"));
        if (segmentTemplate != null) {
            if (initialization == null) {
                initialization = segmentTemplate.initialization;
            }
            if (segmentTimeline == null) {
                segmentTimeline = segmentTemplate.segmentTimeline;
            }
        }
        return buildSegmentTemplate(initialization, j, j2, j4, j3, segmentTimeline, urlTemplate2, urlTemplate);
    }

    protected SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentBase.SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
        return new SegmentBase.SegmentTemplate(rangedUri, j, j2, j3, j4, list, urlTemplate, urlTemplate2);
    }

    protected EventStream parseEventStream(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", "");
        String string2 = parseString(xmlPullParser, "value", "");
        long j = parseLong(xmlPullParser, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Event")) {
                arrayList.add(parseEvent(xmlPullParser, string, string2, j, byteArrayOutputStream));
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            EventMessage eventMessage = (EventMessage) arrayList.get(i);
            jArr[i] = eventMessage.presentationTimeUs;
            eventMessageArr[i] = eventMessage;
        }
        return buildEventStream(string, string2, j, jArr, eventMessageArr);
    }

    protected EventStream buildEventStream(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j, jArr, eventMessageArr);
    }

    protected EventMessage parseEvent(XmlPullParser xmlPullParser, String str, String str2, long j, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        long j2 = parseLong(xmlPullParser, "id", 0L);
        long j3 = parseLong(xmlPullParser, "duration", -9223372036854775807L);
        long j4 = parseLong(xmlPullParser, "presentationTime", 0L);
        return buildEvent(str, str2, j2, Util.scaleLargeTimestamp(j3, 1000L, j), parseEventObject(xmlPullParser, byteArrayOutputStream), Util.scaleLargeTimestamp(j4, 1000000L, j));
    }

    protected byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(byteArrayOutputStream, null);
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, false);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        xmlSerializerNewSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    protected EventMessage buildEvent(String str, String str2, long j, long j2, byte[] bArr, long j3) {
        return new EventMessage(str, str2, j2, j, bArr, j3);
    }

    protected List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "S")) {
                j = parseLong(xmlPullParser, "t", j);
                long j2 = parseLong(xmlPullParser, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, -9223372036854775807L);
                int i = parseInt(xmlPullParser, CampaignEx.JSON_KEY_AD_R, 0) + 1;
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(buildSegmentTimelineElement(j, j2));
                    j += j2;
                }
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    protected SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        return new SegmentBase.SegmentTimelineElement(j, j2);
    }

    protected UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? UrlTemplate.compile(attributeValue) : urlTemplate;
    }

    protected RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    protected RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, ShareConstants.WEB_DIALOG_PARAM_MEDIA, "mediaRange");
    }

    protected RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
            }
            return buildRangedUri(attributeValue, j, j2);
        }
        j = 0;
        j2 = -1;
        return buildRangedUri(attributeValue, j, j2);
    }

    protected RangedUri buildRangedUri(String str, long j, long j2) {
        return new RangedUri(str, j, j2);
    }

    protected int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", null);
        int dolbyChannelConfiguration = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(string)) {
            dolbyChannelConfiguration = parseInt(xmlPullParser, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(string)) {
            dolbyChannelConfiguration = parseDolbyChannelConfiguration(xmlPullParser);
        }
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return dolbyChannelConfiguration;
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                }
            }
        }
    }

    private static String getSampleMimeType(String str, String str2) {
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.getAudioMediaMimeType(str2);
        }
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.getVideoMediaMimeType(str2);
        }
        if (mimeTypeIsRawText(str)) {
            return str;
        }
        if ("application/mp4".equals(str)) {
            if ("stpp".equals(str2)) {
                return "application/ttml+xml";
            }
            if ("wvtt".equals(str2)) {
                return "application/x-mp4-vtt";
            }
        } else if ("application/x-rawcc".equals(str) && str2 != null) {
            if (str2.contains("cea708")) {
                return "application/cea-708";
            }
            if (str2.contains("eia608") || str2.contains("cea608")) {
                return "application/cea-608";
            }
        }
        return null;
    }

    private static boolean mimeTypeIsRawText(String str) {
        return MimeTypes.isText(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    private static String checkLanguageConsistency(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.checkState(str.equals(str2));
        return str;
    }

    private static int checkContentTypeConsistency(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        Assertions.checkState(i == i2);
        return i;
    }

    protected static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", "");
        String string2 = parseString(xmlPullParser, "value", null);
        String string3 = parseString(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new Descriptor(string, string2, string3);
    }

    protected static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w(TAG, "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w(TAG, "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static String parseEac3SupplementalProperties(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(descriptor.schemeIdUri) && "ec+3".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float parseFrameRate(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int i = Integer.parseInt(matcher.group(1));
        String strGroup = matcher.group(2);
        return !TextUtils.isEmpty(strGroup) ? i / Integer.parseInt(strGroup) : i;
    }

    protected static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Util.parseXsDuration(attributeValue);
    }

    protected static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Util.parseXsDateTime(attributeValue);
    }

    protected static String parseBaseUrl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return UriUtil.resolve(str, xmlPullParser.getText());
    }

    protected static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    protected static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    protected static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    protected static int parseDolbyChannelConfiguration(XmlPullParser xmlPullParser) {
        String lowerInvariant = Util.toLowerInvariant(xmlPullParser.getAttributeValue(null, "value"));
        if (lowerInvariant == null) {
            return -1;
        }
        lowerInvariant.hashCode();
        switch (lowerInvariant) {
            case "4000":
                return 1;
            case "a000":
                return 2;
            case "f801":
                return 6;
            case "fa01":
                return 8;
            default:
                return -1;
        }
    }

    protected static final class RepresentationInfo {
        public final String baseUrl;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format, String str, SegmentBase segmentBase, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, long j) {
            this.format = format;
            this.baseUrl = str;
            this.segmentBase = segmentBase;
            this.drmSchemeType = str2;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.revisionId = j;
        }
    }
}
