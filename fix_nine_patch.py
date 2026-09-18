import os
import subprocess
import glob
from PIL import Image

AAPT2 = "/opt/homebrew/share/android-commandlinetools/build-tools/34.0.0/aapt2"
RES_DIR = "app/src/main/res"

def test_compile(filepath):
    cmd = [AAPT2, "compile", filepath, "-o", "/tmp/aapt_test/"]
    os.makedirs("/tmp/aapt_test", exist_ok=True)
    res = subprocess.run(cmd, capture_output=True, text=True)
    return res.returncode == 0

def fix_9patch(filepath):
    # Try adding a valid 1px 9-patch border (black on corners/center)
    try:
        im = Image.open(filepath).convert("RGBA")
        w, h = im.size
        # Create a new image of size (w+2, h+2) transparent
        new_im = Image.new("RGBA", (w + 2, h + 2), (0, 0, 0, 0))
        new_im.paste(im, (1, 1))
        
        # Put black pixels for stretch area (top and left) and padding (bottom and right)
        # Black pixel = (0, 0, 0, 255)
        black = (0, 0, 0, 255)
        
        # Top border stretch (center pixel)
        for x in range(1, w + 1):
            new_im.putpixel((x, 0), black)
            
        # Left border stretch (center pixel)
        for y in range(1, h + 1):
            new_im.putpixel((0, y), black)
            
        # Bottom border padding
        for x in range(1, w + 1):
            new_im.putpixel((x, h + 1), black)
            
        # Right border padding
        for y in range(1, h + 1):
            new_im.putpixel((w + 1, y), black)
            
        new_im.save(filepath, "PNG")
        if test_compile(filepath):
            return True
            
        # If still failing, create minimal 1px border
        new_im = Image.new("RGBA", (w, h), (0, 0, 0, 0))
        # Clear borders
        pix = im.load()
        # Ensure outer border is transparent or black
        for x in range(w):
            for y in range(h):
                if x == 0 or x == w - 1 or y == 0 or y == h - 1:
                    pass
        im.save(filepath, "PNG")
        return test_compile(filepath)
    except Exception as e:
        print(f"Error processing {filepath}: {e}")
        return False

def main():
    nine_patches = glob.glob(f"{RES_DIR}/**/*.9.png", recursive=True)
    print(f"Checking {len(nine_patches)} 9-patch files...")
    
    fixed_count = 0
    failed_count = 0
    
    for np_path in nine_patches:
        if not test_compile(np_path):
            print(f"[-] Compiling failed: {np_path}. Attempting fix...")
            # Try to fix
            # First try converting to standard 9-patch with border
            try:
                im = Image.open(np_path).convert("RGBA")
                w, h = im.size
                # If image is missing border or has bad border, wrap it with 1px border
                new_im = Image.new("RGBA", (w + 2, h + 2), (0, 0, 0, 0))
                new_im.paste(im, (1, 1))
                black = (0, 0, 0, 255)
                # stretch markers
                new_im.putpixel((w // 2 + 1, 0), black)
                new_im.putpixel((0, h // 2 + 1), black)
                new_im.putpixel((w // 2 + 1, h + 1), black)
                new_im.putpixel((w + 1, h // 2 + 1), black)
                new_im.save(np_path, "PNG")
                
                if test_compile(np_path):
                    print(f"[+] Fixed: {np_path}")
                    fixed_count += 1
                else:
                    # Try solid stretch border
                    for x in range(1, w + 1):
                        new_im.putpixel((x, 0), black)
                        new_im.putpixel((x, h + 1), black)
                    for y in range(1, h + 1):
                        new_im.putpixel((0, y), black)
                        new_im.putpixel((w + 1, y), black)
                    new_im.save(np_path, "PNG")
                    if test_compile(np_path):
                        print(f"[+] Fixed with full border: {np_path}")
                        fixed_count += 1
                    else:
                        print(f"[!] Could not fix: {np_path}")
                        failed_count += 1
            except Exception as e:
                print(f"[!] Exception on {np_path}: {e}")
                failed_count += 1
                
    print(f"\nDone! Fixed: {fixed_count}, Failed: {failed_count}")

if __name__ == '__main__':
    main()
