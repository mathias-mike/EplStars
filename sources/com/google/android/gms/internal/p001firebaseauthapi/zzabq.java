package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzabq implements zzabd {
    private final zzabg zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzabq(zzabg zzabg, String str, Object[] objArr) {
        char c;
        this.zza = zzabg;
        this.zzb = str;
        this.zzc = objArr;
        int i = 1;
        try {
            c = str.charAt(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            char[] charArray = str.toCharArray();
            String str2 = new String(charArray);
            try {
                c = str2.charAt(0);
                str = str2;
            } catch (ArrayIndexOutOfBoundsException e2) {
                try {
                    char[] cArr = new char[str2.length()];
                    str2.getChars(0, str2.length(), cArr, 0);
                    String str3 = new String(cArr);
                    try {
                        c = str3.charAt(0);
                        str = str3;
                    } catch (ArrayIndexOutOfBoundsException e3) {
                        e = e3;
                        str2 = str3;
                        throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", new Object[]{str2, Integer.valueOf(charArray.length)}), e);
                    }
                } catch (ArrayIndexOutOfBoundsException e4) {
                    e = e4;
                    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", new Object[]{str2, Integer.valueOf(charArray.length)}), e);
                }
            }
        }
        if (c < 55296) {
            this.zzd = c;
            return;
        }
        char c2 = c & 8191;
        int i2 = 13;
        while (true) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt >= 55296) {
                c2 |= (charAt & 8191) << i2;
                i2 += 13;
                i = i3;
            } else {
                this.zzd = (charAt << i2) | c2;
                return;
            }
        }
    }

    public final boolean zza() {
        return (this.zzd & 2) == 2;
    }

    public final zzabg zzb() {
        return this.zza;
    }

    public final int zzc() {
        return (this.zzd & 1) == 1 ? 1 : 2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
