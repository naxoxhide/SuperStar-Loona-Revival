#!/usr/bin/env python3
"""
Dalcomsoft Asset Data Decryption & Encryption CLI Tool
Decrypts and Encrypts `.bin` asset files from SuperStar LOONA / Dalcomsoft games.

Usage:
  # Decrypt single file to JSON
  python tools/decrypt_dalcom.py decrypt path/to/msd.bin -o path/to/msd.json

  # Decrypt an entire directory of .bin files
  python tools/decrypt_dalcom.py batch-decrypt path/to/sdisgkdc/

  # Encrypt JSON back to .bin
  python tools/decrypt_dalcom.py encrypt path/to/msd.json -o path/to/msd.bin
"""

import sys
import os
import argparse
import gzip
import base64
import json
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad

DEFAULT_KEY = b"WnFKN1v_gUcgmUVZnjjjGXGwk557zBSO"

def decrypt_data(raw_bytes: bytes, key: bytes = DEFAULT_KEY) -> str:
    """
    Decrypts a Dalcomsoft .bin file into a plaintext UTF-8 string (JSON).
    Handles both GZip-compressed Base64 and uncompressed Base64 streams.
    """
    # Step 1: Check if input is GZip compressed (RFC 1952 header: 0x1F, 0x8B)
    if len(raw_bytes) >= 2 and raw_bytes[0] == 0x1F and raw_bytes[1] == 0x8B:
        b64_text = gzip.decompress(raw_bytes)
    else:
        b64_text = raw_bytes

    # Step 2: Base64 decode to get raw AES ciphertext
    ciphertext = base64.b64decode(b64_text)

    # Step 3: AES-256-ECB Decryption with PKCS7 unpadding
    cipher = AES.new(key, AES.MODE_ECB)
    decrypted_bytes = cipher.decrypt(ciphertext)
    unpadded_bytes = unpad(decrypted_bytes, AES.block_size)

    return unpadded_bytes.decode("utf-8")

def encrypt_data(text: str, key: bytes = DEFAULT_KEY, use_gzip: bool = True) -> bytes:
    """
    Encrypts a plaintext JSON string into a Dalcomsoft .bin format.
    """
    # Step 1: AES-256-ECB Encryption with PKCS7 padding
    cipher = AES.new(key, AES.MODE_ECB)
    padded_data = pad(text.encode("utf-8"), AES.block_size)
    ciphertext = cipher.encrypt(padded_data)

    # Step 2: Base64 encode
    b64_text = base64.b64encode(ciphertext)

    # Step 3: GZip compress
    if use_gzip:
        return gzip.compress(b64_text)
    return b64_text

def main():
    parser = argparse.ArgumentParser(description="Dalcomsoft Asset Data Decryption/Encryption CLI")
    subparsers = parser.add_subparsers(dest="command", required=True)

    # Decrypt command
    p_dec = subparsers.add_parser("decrypt", help="Decrypt a single .bin file to JSON")
    p_dec.add_argument("input", help="Path to .bin file")
    p_dec.add_argument("-o", "--output", help="Path to output .json file (defaults to same name)")

    # Batch decrypt command
    p_batch = subparsers.add_parser("batch-decrypt", help="Batch decrypt all .bin files in a directory")
    p_batch.add_argument("directory", help="Directory containing .bin files")

    # Encrypt command
    p_enc = subparsers.add_parser("encrypt", help="Encrypt a JSON file to .bin")
    p_enc.add_argument("input", help="Path to .json file")
    p_enc.add_argument("-o", "--output", help="Path to output .bin file")
    p_enc.add_argument("--no-gzip", action="store_true", help="Do not GZip compress the output")

    args = parser.parse_args()

    if args.command == "decrypt":
        in_path = args.input
        out_path = args.output or in_path.rsplit(".", 1)[0] + ".json"
        with open(in_path, "rb") as f:
            raw = f.read()
        decrypted_text = decrypt_data(raw)
        try:
            parsed = json.loads(decrypted_text)
            with open(out_path, "w", encoding="utf-8") as f:
                json.dump(parsed, f, indent=2, ensure_ascii=False)
        except Exception:
            with open(out_path, "w", encoding="utf-8") as f:
                f.write(decrypted_text)
        print(f"✅ Decrypted {in_path} -> {out_path}")

    elif args.command == "batch-decrypt":
        target_dir = args.directory
        count = 0
        for root, _, files in os.walk(target_dir):
            for file in files:
                if file.endswith(".bin"):
                    in_path = os.path.join(root, file)
                    out_path = in_path.rsplit(".", 1)[0] + ".json"
                    try:
                        with open(in_path, "rb") as f:
                            raw = f.read()
                        decrypted_text = decrypt_data(raw)
                        parsed = json.loads(decrypted_text)
                        with open(out_path, "w", encoding="utf-8") as f:
                            json.dump(parsed, f, indent=2, ensure_ascii=False)
                        count += 1
                        print(f"✅ Decrypted: {file} -> {os.path.basename(out_path)}")
                    except Exception as e:
                        print(f"❌ Failed: {file} ({e})")
        print(f"🎉 Completed batch decryption of {count} files in {target_dir}")

    elif args.command == "encrypt":
        in_path = args.input
        out_path = args.output or in_path.rsplit(".", 1)[0] + ".bin"
        with open(in_path, "r", encoding="utf-8") as f:
            text = f.read()
        try:
            parsed = json.loads(text)
            text = json.dumps(parsed, separators=(",", ":"), ensure_ascii=False)
        except Exception:
            pass
        encrypted_bytes = encrypt_data(text, use_gzip=not args.no_gzip)
        with open(out_path, "wb") as f:
            f.write(encrypted_bytes)
        print(f"✅ Encrypted {in_path} -> {out_path} ({len(encrypted_bytes)} bytes)")

if __name__ == "__main__":
    main()
