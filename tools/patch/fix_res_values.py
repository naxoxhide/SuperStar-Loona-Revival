import os
import glob
import re

RES_DIR = "app/src/main/res"

REPLACEMENTS = [
    # layout dimensions
    (r'<item name="android:layout_width">-1</item>', '<item name="android:layout_width">match_parent</item>'),
    (r'<item name="android:layout_width">-2</item>', '<item name="android:layout_width">wrap_content</item>'),
    (r'<item name="android:layout_height">-1</item>', '<item name="android:layout_height">match_parent</item>'),
    (r'<item name="android:layout_height">-2</item>', '<item name="android:layout_height">wrap_content</item>'),
    (r'<item name="android:width">-1</item>', '<item name="android:width">match_parent</item>'),
    (r'<item name="android:width">-2</item>', '<item name="android:width">wrap_content</item>'),
    (r'<item name="android:height">-1</item>', '<item name="android:height">match_parent</item>'),
    (r'<item name="android:height">-2</item>', '<item name="android:height">wrap_content</item>'),
    
    # gravity flags
    (r'<item name="android:gravity">0x0*11</item>', '<item name="android:gravity">center</item>'),
    (r'<item name="android:gravity">0x0*10</item>', '<item name="android:gravity">center_vertical</item>'),
    (r'<item name="android:gravity">0x0*1</item>', '<item name="android:gravity">center_horizontal</item>'),
    (r'<item name="android:gravity">0x0*3</item>', '<item name="android:gravity">left</item>'),
    (r'<item name="android:gravity">0x0*5</item>', '<item name="android:gravity">right</item>'),
    (r'<item name="android:gravity">0x0*30</item>', '<item name="android:gravity">top</item>'),
    (r'<item name="android:gravity">0x0*50</item>', '<item name="android:gravity">bottom</item>'),
    (r'<item name="android:gravity">0x0*51</item>', '<item name="android:gravity">bottom|center_horizontal</item>'),
    (r'<item name="android:gravity">0x0*0</item>', '<item name="android:gravity">top|left</item>'),
    (r'<item name="android:gravity">0x800013</item>', '<item name="android:gravity">start|center_vertical</item>'),
    (r'<item name="android:gravity">0x800003</item>', '<item name="android:gravity">start</item>'),
    (r'<item name="android:gravity">0x800005</item>', '<item name="android:gravity">end</item>'),
    (r'<item name="android:gravity">0x800015</item>', '<item name="android:gravity">end|center_vertical</item>'),
    
    # layout_gravity flags
    (r'<item name="android:layout_gravity">0x0*11</item>', '<item name="android:layout_gravity">center</item>'),
    (r'<item name="android:layout_gravity">0x0*10</item>', '<item name="android:layout_gravity">center_vertical</item>'),
    (r'<item name="android:layout_gravity">0x0*1</item>', '<item name="android:layout_gravity">center_horizontal</item>'),
    (r'<item name="android:layout_gravity">0x0*51</item>', '<item name="android:layout_gravity">bottom|center_horizontal</item>'),
    (r'<item name="android:layout_gravity">0x0*50</item>', '<item name="android:layout_gravity">bottom</item>'),
    (r'<item name="android:layout_gravity">0x0*0</item>', '<item name="android:layout_gravity">top|left</item>'),
    (r'<item name="android:layout_gravity">0x0*3</item>', '<item name="android:layout_gravity">left</item>'),
    (r'<item name="android:layout_gravity">0x0*5</item>', '<item name="android:layout_gravity">right</item>'),
    (r'<item name="android:layout_gravity">0x800013</item>', '<item name="android:layout_gravity">start|center_vertical</item>'),
    (r'<item name="android:layout_gravity">0x800003</item>', '<item name="android:layout_gravity">start</item>'),
    (r'<item name="android:layout_gravity">0x800005</item>', '<item name="android:layout_gravity">end</item>'),
    (r'<item name="android:layout_gravity">0x800015</item>', '<item name="android:layout_gravity">end|center_vertical</item>'),

    # windowSoftInputMode flags
    (r'<item name="android:windowSoftInputMode">0x0*20</item>', '<item name="android:windowSoftInputMode">adjustResize</item>'),
    (r'<item name="android:windowSoftInputMode">0x0*10</item>', '<item name="android:windowSoftInputMode">adjustPan</item>'),
    (r'<item name="android:windowSoftInputMode">0x0*0</item>', '<item name="android:windowSoftInputMode">stateUnspecified</item>'),
    (r'<item name="android:windowSoftInputMode">0x0*2</item>', '<item name="android:windowSoftInputMode">stateHidden</item>'),
    (r'<item name="android:windowSoftInputMode">0x0*4</item>', '<item name="android:windowSoftInputMode">stateAlwaysHidden</item>'),
    (r'<item name="android:windowSoftInputMode">0x0*30</item>', '<item name="android:windowSoftInputMode">adjustNothing</item>'),
    (r'<item name="android:windowSoftInputMode">0x0*22</item>', '<item name="android:windowSoftInputMode">stateHidden|adjustResize</item>'),

    # orientation
    (r'<item name="android:orientation">0</item>', '<item name="android:orientation">horizontal</item>'),
    (r'<item name="android:orientation">1</item>', '<item name="android:orientation">vertical</item>'),

    # textAlignment
    (r'<item name="android:textAlignment">0</item>', '<item name="android:textAlignment">inherit</item>'),
    (r'<item name="android:textAlignment">1</item>', '<item name="android:textAlignment">gravity</item>'),
    (r'<item name="android:textAlignment">2</item>', '<item name="android:textAlignment">textStart</item>'),
    (r'<item name="android:textAlignment">3</item>', '<item name="android:textAlignment">textEnd</item>'),
    (r'<item name="android:textAlignment">4</item>', '<item name="android:textAlignment">center</item>'),
    (r'<item name="android:textAlignment">5</item>', '<item name="android:textAlignment">viewStart</item>'),
    (r'<item name="android:textAlignment">6</item>', '<item name="android:textAlignment">viewEnd</item>'),

    # textStyle
    (r'<item name="android:textStyle">0x0*0</item>', '<item name="android:textStyle">normal</item>'),
    (r'<item name="android:textStyle">0x0*1</item>', '<item name="android:textStyle">bold</item>'),
    (r'<item name="android:textStyle">0x0*2</item>', '<item name="android:textStyle">italic</item>'),

    # scaleType
    (r'<item name="android:scaleType">0</item>', '<item name="android:scaleType">matrix</item>'),
    (r'<item name="android:scaleType">1</item>', '<item name="android:scaleType">fitXY</item>'),
    (r'<item name="android:scaleType">2</item>', '<item name="android:scaleType">fitStart</item>'),
    (r'<item name="android:scaleType">3</item>', '<item name="android:scaleType">fitCenter</item>'),
    (r'<item name="android:scaleType">4</item>', '<item name="android:scaleType">fitEnd</item>'),
    (r'<item name="android:scaleType">5</item>', '<item name="android:scaleType">center</item>'),
    (r'<item name="android:scaleType">6</item>', '<item name="android:scaleType">centerCrop</item>'),
    (r'<item name="android:scaleType">7</item>', '<item name="android:scaleType">centerInside</item>'),

    # breakStrategy
    (r'<item name="android:breakStrategy">0</item>', '<item name="android:breakStrategy">simple</item>'),
    (r'<item name="android:breakStrategy">1</item>', '<item name="android:breakStrategy">high_quality</item>'),
    (r'<item name="android:breakStrategy">2</item>', '<item name="android:breakStrategy">balanced</item>'),

    # hyphenationFrequency
    (r'<item name="android:hyphenationFrequency">0</item>', '<item name="android:hyphenationFrequency">none</item>'),
    (r'<item name="android:hyphenationFrequency">1</item>', '<item name="android:hyphenationFrequency">normal</item>'),
    (r'<item name="android:hyphenationFrequency">2</item>', '<item name="android:hyphenationFrequency">full</item>'),

    # ellipsize
    (r'<item name="android:ellipsize">1</item>', '<item name="android:ellipsize">start</item>'),
    (r'<item name="android:ellipsize">2</item>', '<item name="android:ellipsize">middle</item>'),
    (r'<item name="android:ellipsize">3</item>', '<item name="android:ellipsize">end</item>'),
    (r'<item name="android:ellipsize">4</item>', '<item name="android:ellipsize">marquee</item>'),

    # typeface
    (r'<item name="android:typeface">0</item>', '<item name="android:typeface">normal</item>'),
    (r'<item name="android:typeface">1</item>', '<item name="android:typeface">sans</item>'),
    (r'<item name="android:typeface">2</item>', '<item name="android:typeface">serif</item>'),
    (r'<item name="android:typeface">3</item>', '<item name="android:typeface">monospace</item>'),

    # visibility
    (r'<item name="android:visibility">0</item>', '<item name="android:visibility">visible</item>'),
    (r'<item name="android:visibility">1</item>', '<item name="android:visibility">invisible</item>'),
    (r'<item name="android:visibility">2</item>', '<item name="android:visibility">gone</item>'),

    # windowLayoutInDisplayCutoutMode
    (r'<item name="android:windowLayoutInDisplayCutoutMode">0</item>', '<item name="android:windowLayoutInDisplayCutoutMode">default</item>'),
    (r'<item name="android:windowLayoutInDisplayCutoutMode">1</item>', '<item name="android:windowLayoutInDisplayCutoutMode">shortEdges</item>'),
    (r'<item name="android:windowLayoutInDisplayCutoutMode">2</item>', '<item name="android:windowLayoutInDisplayCutoutMode">never</item>'),
]

def fix_xml_file(filepath):
    with open(filepath, 'r', encoding='utf-8', errors='ignore') as f:
        content = f.read()

    orig_content = content
    for pattern, replacement in REPLACEMENTS:
        content = re.sub(pattern, replacement, content)

    if content != orig_content:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(content)
        return True
    return False

def main():
    xml_files = glob.glob(f"{RES_DIR}/**/*.xml", recursive=True)
    modified = 0
    for xml_path in xml_files:
        if fix_xml_file(xml_path):
            print(f"[+] Fixed style attributes in: {xml_path}")
            modified += 1
    print(f"Done! Modified {modified} XML resource files.")

if __name__ == '__main__':
    main()
