"""Deploy music, album cover, beatmap (.seq), tutorial, and sync assets to Android."""

import io
import os
import subprocess
import sys
import tarfile
import time

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.abspath(os.path.join(SCRIPT_DIR, "../.."))
SOURCE_ROOT = os.path.join(PROJECT_ROOT, "app/src/files")
TARGET_DEVICE_ROOT = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files"

# Relative directories under app/src/files/ to sync
DIRS_TO_SYNC = [
    ("asiudgasg/asodhsg/woeiurty", True),   # Normalize *.i.bytes.png -> *.i.bytes (+ symlink)
    ("asiudgasg/asodhsg/halwuiefjs", True), # Normalize *.i.bytes.png -> *.i.bytes (+ symlink)
    ("asiudgasg/asodhsg/hcxjx", True),      # Ingame music background images (*.i.bytes)
    ("asiudgasg/aweid", False),             # .seq beatmaps
    ("asiudgasg/dslkjfsdalhh", False),      # .a.bytes audio, previews, voice/sfx
    ("oiuio", False),                       # tutorial audio + chart
    ("ehdhxnm", False),                     # sync audio + chart
]


def detect_adb_serial():
    """Return explicit serial if provided, else prefer 127.0.0.1:5555 when present."""
    if len(sys.argv) > 1:
        return sys.argv[1]
    out = subprocess.run(["adb", "devices"], capture_output=True, text=True).stdout
    if "127.0.0.1:5555\tdevice" in out:
        return "127.0.0.1:5555"
    for line in out.splitlines()[1:]:
        if "\tdevice" in line:
            return line.split()[0]
    return None


def main():
    start_time = time.time()
    serial = detect_adb_serial()
    if not serial:
        print("Error: no connected adb device found.")
        sys.exit(1)

    adb_base = ["adb", "-s", serial]
    print(f"=== Music Asset Deployment to {serial} ===")
    subprocess.run(adb_base + ["shell", "mkdir", "-p", TARGET_DEVICE_ROOT], check=True)

    proc = subprocess.Popen(
        adb_base + ["shell", "tar", "-xf", "-", "-C", TARGET_DEVICE_ROOT],
        stdin=subprocess.PIPE,
    )

    count = 0
    total_bytes = 0
    now = int(time.time())

    with tarfile.open(fileobj=proc.stdin, mode="w|") as tar:
        for rel_dir, normalize_image_ext in DIRS_TO_SYNC:
            src_dir = os.path.join(SOURCE_ROOT, rel_dir)
            if not os.path.exists(src_dir):
                print(f"Warning: {src_dir} does not exist, skipping.")
                continue

            print(f"Streaming {rel_dir}...")
            for root, _dirs, files in os.walk(src_dir):
                rel_root = os.path.relpath(root, SOURCE_ROOT)
                for fname in sorted(files):
                    if fname.startswith(".") or fname == ".DS_Store":
                        continue

                    full_path = os.path.join(root, fname)
                    rel_path = os.path.join(rel_root, fname)

                    symlink_rel = None
                    if normalize_image_ext and fname.endswith(".i.bytes.png"):
                        primary_rel = os.path.join(rel_root, fname[:-4])
                        symlink_rel = rel_path
                    elif normalize_image_ext and fname.endswith(".i.bytes"):
                        primary_rel = rel_path
                        symlink_rel = rel_path + ".png"
                    else:
                        primary_rel = rel_path

                    with open(full_path, "rb") as f:
                        data = f.read()

                    info = tarfile.TarInfo(name=primary_rel)
                    info.size = len(data)
                    info.mtime = now
                    info.mode = 0o644
                    tar.addfile(info, io.BytesIO(data))
                    total_bytes += len(data)
                    count += 1

                    if symlink_rel:
                        sym = tarfile.TarInfo(name=symlink_rel)
                        sym.type = tarfile.SYMTYPE
                        sym.linkname = os.path.basename(primary_rel)
                        sym.mtime = now
                        tar.addfile(sym)

    proc.stdin.close()
    proc.wait()

    if proc.returncode != 0:
        print(f"Error: tar extraction failed with code {proc.returncode}")
        sys.exit(proc.returncode)

    elapsed = time.time() - start_time
    print(f"Deployed {count} files ({total_bytes / (1024 * 1024):.2f} MB) in {elapsed:.2f}s")


if __name__ == "__main__":
    main()
