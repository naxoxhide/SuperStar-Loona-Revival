import os
import sys
import io
import tarfile
import subprocess
import time

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.abspath(os.path.join(SCRIPT_DIR, "../.."))
SOURCE_BASE = os.path.join(PROJECT_ROOT, "app/src/files/asiudgasg/asodhsg")
TARGET_DEVICE_DIR = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/asodhsg"

DIRS_TO_SYNC = [
    "wadceg",
    "sdhgauwehdnu",
    "aoeiwhslc",
    "aweoijs",
    "vhydigygvd",
    "agewfcbxhaa",
    "foewghkc",
    "xcvzbnsdosi",
]

def main():
    start_time = time.time()
    print("=== Card Asset Deployment to Emulator ===")
    
    # Check adb connection
    res = subprocess.run(["adb", "get-state"], capture_output=True, text=True)
    if "device" not in res.stdout:
        print("Error: adb device not found.")
        sys.exit(1)
        
    print(f"Ensuring target directory exists: {TARGET_DEVICE_DIR}")
    subprocess.run(["adb", "shell", "mkdir", "-p", TARGET_DEVICE_DIR], check=True)

    # Spawn adb tar process
    print("Starting streaming tar process to device...")
    proc = subprocess.Popen(
        ["adb", "shell", "tar", "-xf", "-", "-C", TARGET_DEVICE_DIR],
        stdin=subprocess.PIPE
    )

    count = 0
    total_bytes = 0

    with tarfile.open(fileobj=proc.stdin, mode="w|") as tar:
        for folder in DIRS_TO_SYNC:
            src_folder = os.path.join(SOURCE_BASE, folder)
            if not os.path.exists(src_folder):
                print(f"Warning: {src_folder} does not exist, skipping.")
                continue
                
            print(f"Processing folder: {folder}...")
            for root, dirs, files in os.walk(src_folder):
                rel_root = os.path.relpath(root, SOURCE_BASE)
                for file in files:
                    if file.startswith(".") or file == ".DS_Store":
                        continue
                        
                    full_path = os.path.join(root, file)
                    rel_path = os.path.join(rel_root, file)
                    
                    # Normalize names: ensure .i.bytes is primary, .i.bytes.png is symlink
                    if file.endswith(".i.bytes.png"):
                        base_name = file[:-4] # strip .png -> .i.bytes
                        primary_rel = os.path.join(rel_root, base_name)
                        symlink_rel = rel_path
                    elif file.endswith(".i.bytes"):
                        primary_rel = rel_path
                        symlink_rel = rel_path + ".png"
                    else:
                        primary_rel = rel_path
                        symlink_rel = None

                    # Add primary file
                    with open(full_path, "rb") as f:
                        data = f.read()
                    
                    info = tarfile.TarInfo(name=primary_rel)
                    info.size = len(data)
                    info.mtime = int(time.time())
                    info.mode = 0o644
                    tar.addfile(info, io.BytesIO(data))
                    
                    total_bytes += len(data)
                    count += 1
                    
                    # Add symlink
                    if symlink_rel:
                        sym_info = tarfile.TarInfo(name=symlink_rel)
                        sym_info.type = tarfile.SYMTYPE
                        sym_info.linkname = os.path.basename(primary_rel)
                        sym_info.mtime = int(time.time())
                        tar.addfile(sym_info)

    proc.stdin.close()
    proc.wait()

    if proc.returncode != 0:
        print(f"Error during tar extraction on device. Return code: {proc.returncode}")
        sys.exit(proc.returncode)

    elapsed = time.time() - start_time
    print(f"Successfully deployed {count} asset files ({total_bytes / (1024*1024):.2f} MB) in {elapsed:.2f} seconds!")

if __name__ == "__main__":
    main()
