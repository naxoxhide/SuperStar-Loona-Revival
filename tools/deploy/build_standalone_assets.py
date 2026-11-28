#!/usr/bin/env python3
"""Build a trimmed standalone asset bundle containing only actively used game files.

Packages active external assets from ``app/src/files/``, ``app/src/main/assets/data/``,
and ``app/src/main/assets/player_profile.json`` into
``app/src/standalone/assets/standalone_files.zip`` for physical-device APK installs.

Image assets ending in ``.i.bytes.png`` inside ``asiudgasg/asodhsg/`` are normalized
once to canonical ``.i.bytes`` paths (avoiding duplicate storage and POSIX symlinks,
which Android's emulated ``/sdcard/Android/data`` filesystem forbids).
"""

import argparse
import hashlib
import os
import shutil
import subprocess
import sys
import zipfile

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.abspath(os.path.join(SCRIPT_DIR, "../.."))
FILES_ROOT = os.path.join(PROJECT_ROOT, "app/src/files")
MAIN_ASSETS_ROOT = os.path.join(PROJECT_ROOT, "app/src/main/assets")
STANDALONE_ASSETS_DIR = os.path.join(PROJECT_ROOT, "app/src/standalone/assets")
OUT_ZIP = os.path.join(STANDALONE_ASSETS_DIR, "standalone_files.zip")
OUT_VERSION = os.path.join(STANDALONE_ASSETS_DIR, "standalone_pack_version.txt")

# Active directories inside app/src/files/asiudgasg/asodhsg/
# Each tuple: (subdir_name, filename_prefix_filter_or_None)
ACTIVE_ASODHSG_DIRS = [
    ("wadceg", None),        # Card portraits (_l, _s)
    ("sdhgauwehdnu", None),  # EmptyCard placeholders (_l, _s)
    ("weoihxd", None),       # Lobby wallpapers (_l, _s)
    ("aoeiwhslc", None),     # Card frames, stars, tier overlays (uhex/)
    ("hcxjx", None),         # In-game song backgrounds
    ("kswoks", None),        # Title screen backgrounds (bg0..bg7)
    ("halwuiefjs", None),    # User profile avatars
    ("bhfbfhbf", None),      # Collection & UI reward item icons
    ("foewghkc", None),      # Large group emblems
    ("woeiurty", None),      # Song album covers
    ("aweoijs", None),       # Small group logos/emblems
    ("agewfcbxhaa", None),   # Theme name logos
    ("uhg", None),           # Prism card overlays
    ("vhydigygvd", None),    # Card artist name text images
    ("xcvzbnsdosi", ("22001", "22002", "22003")),  # Only Chuu active extra profile icons
]

# Complete active directories relative to app/src/files/
ACTIVE_FILES_DIRS = [
    ("asiudgasg/aweid", False),         # Beatmaps (.seq)
    ("asiudgasg/dslkjfsdalhh", False),  # Music, previews, voice audio (.a.bytes)
    ("asiudgasg/sdisgkdc", False),      # Decrypted .json & native .bin/.ver tables
    ("oiuio", False),                   # Tutorial audio & chart
    ("ehdhxnm", False),                 # Touch sync audio & chart
]

ACTIVE_ROOT_FILES = [
    ("asiudgasg/background_main.png", "asiudgasg/background_main.png"),
    ("asiudgasg/loona_loading_logo.png", "asiudgasg/loona_loading_logo.png"),
    ("asiudgasg/pedestal_watermark.png", "asiudgasg/pedestal_watermark.png"),
]

COMPRESSED_EXTENSIONS = {".png", ".jpg", ".jpeg", ".webp", ".webm", ".ogg", ".mp3", ".mp4"}


def should_skip_filename(fname: str) -> bool:
    """Skip macOS metadata, hidden files, and stray Finder duplicate '(1)' artifacts."""
    if fname.startswith(".") or fname == ".DS_Store":
        return True
    if "(1)" in fname:
        return True
    return False


def choose_compression(arcname: str, src_path: str) -> int:
    """Store already-compressed binary/image assets; deflate JSON/bin/seq/text tables."""
    ext = os.path.splitext(arcname)[1].lower()
    if ext in COMPRESSED_EXTENSIONS:
        return zipfile.ZIP_STORED
    # .i.bytes files are PNG/image payloads already; deflate text/table/chart/audio containers
    if arcname.endswith(".i.bytes"):
        return zipfile.ZIP_STORED
    return zipfile.ZIP_DEFLATED


def collect_entries():
    """Return sorted deduplicated mapping of arcname -> (src_path, compress_type)."""
    entries = {}

    def add_entry(src_path: str, arcname: str):
        if not os.path.isfile(src_path):
            raise FileNotFoundError(f"Missing expected source file: {src_path}")
        entries[arcname] = (src_path, choose_compression(arcname, src_path))

    for src_rel, dst_rel in ACTIVE_ROOT_FILES:
        add_entry(os.path.join(FILES_ROOT, src_rel), dst_rel)

    # Also include 00_common_LoadingIcon.png under asiudgasg/ for native path compatibility
    loading_icon = os.path.join(MAIN_ASSETS_ROOT, "00_common_LoadingIcon.png")
    if os.path.isfile(loading_icon):
        add_entry(loading_icon, "asiudgasg/00_common_LoadingIcon.png")

    for rel_dir, _ in ACTIVE_FILES_DIRS:
        base_dir = os.path.join(FILES_ROOT, rel_dir)
        if not os.path.isdir(base_dir):
            continue
        for root, _dirs, files in os.walk(base_dir):
            for fname in sorted(files):
                if should_skip_filename(fname):
                    continue
                src_path = os.path.join(root, fname)
                arcname = os.path.relpath(src_path, FILES_ROOT).replace(os.sep, "/")
                add_entry(src_path, arcname)

    for subdir, prefix_filter in ACTIVE_ASODHSG_DIRS:
        base_dir = os.path.join(FILES_ROOT, "asiudgasg/asodhsg", subdir)
        if not os.path.isdir(base_dir):
            continue
        for root, _dirs, files in os.walk(base_dir):
            for fname in sorted(files):
                if should_skip_filename(fname):
                    continue
                if prefix_filter and not fname.startswith(prefix_filter):
                    continue
                src_path = os.path.join(root, fname)
                rel_in_files = os.path.relpath(src_path, FILES_ROOT).replace(os.sep, "/")
                if rel_in_files.endswith(".i.bytes.png"):
                    rel_in_files = rel_in_files[:-4]
                # Prefer native .i.bytes if both .i.bytes and .i.bytes.png exist, otherwise .png normalized
                if rel_in_files in entries and not fname.endswith(".i.bytes"):
                    continue
                add_entry(src_path, rel_in_files)

    # Include assets/data/*.json -> files/data/*.json (used directly by libscript.js)
    data_dir = os.path.join(MAIN_ASSETS_ROOT, "data")
    if os.path.isdir(data_dir):
        for fname in sorted(os.listdir(data_dir)):
            if should_skip_filename(fname):
                continue
            src_path = os.path.join(data_dir, fname)
            if os.path.isfile(src_path):
                add_entry(src_path, f"data/{fname}")

    # Include default player_profile.json (extractor will preserve any existing user save)
    profile_path = os.path.join(MAIN_ASSETS_ROOT, "player_profile.json")
    if os.path.isfile(profile_path):
        add_entry(profile_path, "player_profile.json")

    return dict(sorted(entries.items()))


def compute_manifest_digest(entries) -> str:
    """Compute a deterministic digest from included paths and file sizes/mtimes."""
    h = hashlib.sha256()
    for arcname, (src_path, comp) in entries.items():
        st = os.stat(src_path)
        h.update(f"{arcname}:{st.st_size}:{int(st.st_mtime)}:{comp}\n".encode("utf-8"))
    return h.hexdigest()[:16]


def find_android_build_tool(tool_name: str) -> str:
    """Locate zipalign/apksigner from local.properties sdk.dir or PATH."""
    local_props = os.path.join(PROJECT_ROOT, "local.properties")
    sdk_dir = None
    if os.path.isfile(local_props):
        with open(local_props, "r", encoding="utf-8") as f:
            for line in f:
                if line.startswith("sdk.dir="):
                    sdk_dir = line.split("=", 1)[1].strip()
                    break
    if sdk_dir:
        bt_dir = os.path.join(sdk_dir, "build-tools")
        if os.path.isdir(bt_dir):
            for ver in sorted(os.listdir(bt_dir), reverse=True):
                cand = os.path.join(bt_dir, ver, tool_name)
                if os.path.isfile(cand):
                    return cand
    found = shutil.which(tool_name)
    if not found:
        raise FileNotFoundError(f"Could not find Android build tool: {tool_name}")
    return found


def package_standalone_apk_from_dev(keep_zip: bool = False):
    """Assemble and debug-sign app-standalone-debug.apk from app-dev-debug.apk cleanly."""
    dev_apk = os.path.join(PROJECT_ROOT, "app/build/outputs/apk/dev/debug/app-dev-debug.apk")
    if not os.path.isfile(dev_apk):
        raise FileNotFoundError(f"Dev APK not found: {dev_apk}. Run 'gradle assembleDevDebug' first.")
    if not os.path.isfile(OUT_ZIP) or not os.path.isfile(OUT_VERSION):
        raise FileNotFoundError("Missing standalone_files.zip; run without --skip-zip first.")

    out_dir = os.path.join(PROJECT_ROOT, "app/build/outputs/apk/standalone/debug")
    os.makedirs(out_dir, exist_ok=True)
    unaligned_apk = os.path.join(out_dir, "app-standalone-debug-unaligned.apk")
    final_apk = os.path.join(out_dir, "app-standalone-debug.apk")

    zipalign = find_android_build_tool("zipalign")
    apksigner = find_android_build_tool("apksigner")
    keystore = os.path.expanduser("~/.android/debug.keystore")

    print(f"Injecting standalone assets into {unaligned_apk}...")
    with zipfile.ZipFile(dev_apk, "r") as src_zf, zipfile.ZipFile(unaligned_apk, "w") as dst_zf:
        for info in src_zf.infolist():
            if info.filename.startswith("META-INF/"):
                continue
            if info.filename in ("assets/standalone_files.zip", "assets/standalone_pack_version.txt"):
                continue
            payload = src_zf.read(info.filename)
            new_info = zipfile.ZipInfo(filename=info.filename, date_time=info.date_time)
            new_info.compress_type = info.compress_type
            new_info.external_attr = info.external_attr
            dst_zf.writestr(new_info, payload)
        dst_zf.write(OUT_ZIP, arcname="assets/standalone_files.zip", compress_type=zipfile.ZIP_STORED)
        dst_zf.write(OUT_VERSION, arcname="assets/standalone_pack_version.txt", compress_type=zipfile.ZIP_DEFLATED)

    if not keep_zip and os.path.isfile(OUT_ZIP):
        os.remove(OUT_ZIP)
        print(f"Removed intermediate zip to conserve disk space: {OUT_ZIP}")

    print("Running zipalign -f -p 4...")
    subprocess.run([zipalign, "-f", "-p", "4", unaligned_apk, final_apk], check=True)
    os.remove(unaligned_apk)

    print("Signing APK with debug keystore...")
    subprocess.run([
        apksigner, "sign",
        "--ks", keystore,
        "--ks-pass", "pass:android",
        "--ks-key-alias", "androiddebugkey",
        "--key-pass", "pass:android",
        final_apk,
    ], check=True)
    print(f"Built signed standalone APK: {final_apk} ({os.path.getsize(final_apk) / (1024 * 1024):.2f} MB)")


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--dry-run", action="store_true", help="Print stats without writing output files.")
    parser.add_argument("--package-apk", action="store_true", help="Package app-standalone-debug.apk from app-dev-debug.apk.")
    parser.add_argument("--skip-zip", action="store_true", help="Reuse existing standalone_files.zip when packaging APK.")
    parser.add_argument("--keep-zip", action="store_true", help="Keep standalone_files.zip after packaging APK.")
    args = parser.parse_args()

    if not args.skip_zip:
        entries = collect_entries()
        raw_bytes = sum(os.path.getsize(src) for src, _ in entries.values())
        digest = compute_manifest_digest(entries)

        print(f"Collected {len(entries)} active files ({raw_bytes / (1024 * 1024):.2f} MB uncompressed), digest={digest}")
        if args.dry_run:
            return

        os.makedirs(STANDALONE_ASSETS_DIR, exist_ok=True)
        tmp_zip = OUT_ZIP + ".tmp"
        with zipfile.ZipFile(tmp_zip, "w", compresslevel=6) as zf:
            for arcname, (src_path, comp) in entries.items():
                zf.write(src_path, arcname=arcname, compress_type=comp)
        os.replace(tmp_zip, OUT_ZIP)

        with open(OUT_VERSION, "w", encoding="utf-8") as vf:
            vf.write(digest + "\n")

        zip_mb = os.path.getsize(OUT_ZIP) / (1024 * 1024)
        print(f"Wrote {OUT_ZIP} ({zip_mb:.2f} MB) and version marker {OUT_VERSION}")

    if args.package_apk and not args.dry_run:
        package_standalone_apk_from_dev(keep_zip=args.keep_zip)


if __name__ == "__main__":
    main()
