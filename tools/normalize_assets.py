#!/usr/bin/env python3
import os
import re
import shutil

BASE_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "app", "src", "files"))

def normalize_files():
    print(f"Normalizing files in: {BASE_DIR}")
    
    # 1. First, rename all *.ogg files to strip .ogg
    renamed_files_count = 0
    for root, dirs, files in os.walk(BASE_DIR):
        for f in files:
            if f.endswith(".ogg"):
                old_path = os.path.join(root, f)
                new_filename = f[:-4]  # Remove .ogg
                new_path = os.path.join(root, new_filename)
                
                # If target already exists and is identical/different, handle safely
                if os.path.exists(new_path):
                    os.remove(new_path)
                os.rename(old_path, new_path)
                renamed_files_count += 1
                
    print(f"-> Renamed {renamed_files_count} audio files (stripped .ogg).")

    # 2. Rename directories bottom-up to remove ' (label)' suffixes
    folder_renames = 0
    for root, dirs, files in os.walk(BASE_DIR, topdown=False):
        for d in dirs:
            if re.search(r"\s*\([^)]*\)", d):
                clean_name = re.sub(r"\s*\([^)]*\)", "", d).strip()
                old_dir_path = os.path.join(root, d)
                new_dir_path = os.path.join(root, clean_name)
                
                if old_dir_path == new_dir_path:
                    continue
                
                if os.path.exists(new_dir_path):
                    # Merge contents if destination exists
                    for item in os.listdir(old_dir_path):
                        src_item = os.path.join(old_dir_path, item)
                        dst_item = os.path.join(new_dir_path, item)
                        if os.path.exists(dst_item):
                            if os.path.isdir(dst_item):
                                shutil.rmtree(dst_item)
                            else:
                                os.remove(dst_item)
                        shutil.move(src_item, dst_item)
                    os.rmdir(old_dir_path)
                    print(f"-> Merged directory '{d}' into '{clean_name}'")
                else:
                    os.rename(old_dir_path, new_dir_path)
                    print(f"-> Renamed directory '{d}' -> '{clean_name}'")
                folder_renames += 1
                
    print(f"-> Renamed/cleaned {folder_renames} directories.")

if __name__ == "__main__":
    normalize_files()
