package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzjz implements zzak {
    private static final Collection<Integer> zza = Arrays.asList(new Integer[]{64});
    private static final byte[] zzb = new byte[16];
    private final zzkz zzc;
    private final byte[] zzd;

    public zzjz(byte[] bArr) throws GeneralSecurityException {
        Collection<Integer> collection = zza;
        int length = bArr.length;
        if (collection.contains(Integer.valueOf(length))) {
            int i = length >> 1;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i);
            this.zzd = Arrays.copyOfRange(bArr, i, length);
            this.zzc = new zzkz(copyOfRange);
            return;
        }
        StringBuilder sb = new StringBuilder(59);
        sb.append("invalid key size: ");
        sb.append(length);
        sb.append(" bytes; key must have 64 bytes");
        throw new InvalidKeyException(sb.toString());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        if (length >= 16) {
            Cipher zza2 = zzkn.zza.zza("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr4 = (byte[]) copyOfRange.clone();
            bArr4[8] = (byte) (bArr4[8] & Byte.MAX_VALUE);
            bArr4[12] = (byte) (bArr4[12] & Byte.MAX_VALUE);
            zza2.init(2, new SecretKeySpec(this.zzd, "AES"), new IvParameterSpec(bArr4));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, length);
            byte[] doFinal = zza2.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && zzlf.zza()) {
                doFinal = new byte[0];
            }
            byte[][] bArr5 = {bArr2, doFinal};
            byte[] zza3 = this.zzc.zza(zzb, 16);
            for (char c = 0; c <= 0; c = 1) {
                byte[] bArr6 = bArr5[0];
                if (bArr6 == null) {
                    bArr6 = new byte[0];
                }
                zza3 = zzkb.zze(zzka.zza(zza3), this.zzc.zza(bArr6, 16));
            }
            byte[] bArr7 = bArr5[1];
            int length2 = bArr7.length;
            if (length2 >= 16) {
                int length3 = zza3.length;
                if (length2 >= length3) {
                    int i = length2 - length3;
                    bArr3 = Arrays.copyOf(bArr7, length2);
                    for (int i2 = 0; i2 < zza3.length; i2++) {
                        int i3 = i + i2;
                        bArr3[i3] = (byte) (bArr3[i3] ^ zza3[i2]);
                    }
                } else {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
            } else {
                bArr3 = zzkb.zze(zzka.zzb(bArr7), zzka.zza(zza3));
            }
            if (zzkb.zza(copyOfRange, this.zzc.zza(bArr3, 16))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
