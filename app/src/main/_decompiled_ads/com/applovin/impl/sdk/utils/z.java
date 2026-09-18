package com.applovin.impl.sdk.utils;

import android.util.Xml;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes.dex */
public class z {
    private long aWA;
    private a aWB;
    private Stack<a> aWy;
    private StringBuilder aWz;
    private final com.applovin.impl.sdk.x logger;

    z(com.applovin.impl.sdk.n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.logger = nVar.BL();
    }

    public static y e(String str, com.applovin.impl.sdk.n nVar) throws SAXException {
        return new z(nVar).dQ(str);
    }

    public y dQ(String str) throws SAXException {
        if (str == null) {
            throw new IllegalArgumentException("Unable to parse. No XML specified.");
        }
        this.aWz = new StringBuilder();
        this.aWy = new Stack<>();
        this.aWB = null;
        Xml.parse(str, new ContentHandler() { // from class: com.applovin.impl.sdk.utils.z.1
            @Override // org.xml.sax.ContentHandler
            public void endPrefixMapping(String str2) {
            }

            @Override // org.xml.sax.ContentHandler
            public void ignorableWhitespace(char[] cArr, int i, int i2) {
            }

            @Override // org.xml.sax.ContentHandler
            public void processingInstruction(String str2, String str3) {
            }

            @Override // org.xml.sax.ContentHandler
            public void setDocumentLocator(Locator locator) {
            }

            @Override // org.xml.sax.ContentHandler
            public void skippedEntity(String str2) {
            }

            @Override // org.xml.sax.ContentHandler
            public void startPrefixMapping(String str2, String str3) {
            }

            @Override // org.xml.sax.ContentHandler
            public void startDocument() {
                com.applovin.impl.sdk.x unused = z.this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    z.this.logger.f("XmlParser", "Begin parsing...");
                }
                z.this.aWA = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            }

            @Override // org.xml.sax.ContentHandler
            public void endDocument() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - z.this.aWA;
                com.applovin.impl.sdk.x unused = z.this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    z.this.logger.f("XmlParser", "Finished parsing in " + seconds + " seconds");
                }
            }

            @Override // org.xml.sax.ContentHandler
            public void startElement(String str2, String str3, String str4, Attributes attributes) throws SAXException {
                try {
                    a aVar = z.this.aWy.isEmpty() ? null : (a) z.this.aWy.peek();
                    a aVar2 = new a(str3, z.this.a(attributes), aVar);
                    if (aVar != null) {
                        aVar.c(aVar2);
                    }
                    z.this.aWy.push(aVar2);
                } catch (Exception e) {
                    com.applovin.impl.sdk.x unused = z.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        z.this.logger.c("XmlParser", "Unable to process element <" + str3 + ">", e);
                    }
                    throw new SAXException("Failed to start element", e);
                }
            }

            @Override // org.xml.sax.ContentHandler
            public void endElement(String str2, String str3, String str4) {
                z zVar = z.this;
                zVar.aWB = (a) zVar.aWy.pop();
                z.this.aWB.dR(z.this.aWz.toString().trim());
                z.this.aWz.setLength(0);
            }

            @Override // org.xml.sax.ContentHandler
            public void characters(char[] cArr, int i, int i2) {
                String strTrim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
                if (StringUtils.isValidString(strTrim)) {
                    z.this.aWz.append(strTrim);
                }
            }
        });
        a aVar = this.aWB;
        if (aVar != null) {
            return aVar;
        }
        throw new SAXException("Unable to parse XML into node");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(Attributes attributes) {
        if (attributes != null) {
            int length = attributes.getLength();
            HashMap map = new HashMap(length);
            for (int i = 0; i < length; i++) {
                map.put(attributes.getQName(i), attributes.getValue(i));
            }
            return map;
        }
        return Collections.emptyMap();
    }

    private static class a extends y {
        a(String str, Map<String, String> map, y yVar) {
            super(str, map, yVar);
        }

        void dR(String str) {
            this.JN = str;
        }

        void c(y yVar) {
            if (yVar == null) {
                throw new IllegalArgumentException("None specified.");
            }
            this.SG.add(yVar);
        }
    }
}
