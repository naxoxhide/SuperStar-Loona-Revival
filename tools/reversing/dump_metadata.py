import struct
import sys
import os

def find_code_registration(elf_path, metadata_path):
    with open(metadata_path, 'rb') as f:
        meta_data = f.read()

    # Read header
    magic, version = struct.unpack('<II', meta_data[:8])
    print(f"[+] Metadata Magic: {hex(magic)}, Version: {version}")

    # Read header fields
    header_fields = struct.unpack('<64I', meta_data[:256])
    string_offset = header_fields[6]
    string_size = header_fields[7]
    methods_offset = header_fields[12]
    methods_size = header_fields[13]
    type_defs_offset = header_fields[40]
    type_defs_size = header_fields[41]

    methods_count = methods_size // 32 # in v27, Il2CppMethodDefinition is 32 bytes or 36 bytes
    print(f"[+] Methods count approx: {methods_count}")

    with open(elf_path, 'rb') as f:
        elf_data = f.read()

    print(f"[+] ELF size: {len(elf_data)} bytes")
    return meta_data, elf_data

if __name__ == '__main__':
    elf = 'app/src/main/lib/arm64-v8a/libil2cpp.so'
    meta = 'app/src/main/assets/bin/Data/Managed/Metadata/global-metadata.dat'
    find_code_registration(elf, meta)
