package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzup  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzup {
    private final int zza;

    public zzup(String str) {
        int i = -1;
        try {
            List<String> zzc = zzae.zzb("[.-]").zzc(str);
            if (zzc.size() == 1) {
                i = Integer.parseInt(str);
            } else if (zzc.size() >= 3) {
                i = (Integer.parseInt(zzc.get(0)) * 1000000) + (Integer.parseInt(zzc.get(1)) * 1000) + Integer.parseInt(zzc.get(2));
            }
        } catch (IllegalArgumentException e) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", new Object[]{str, e}));
            }
        }
        this.zza = i;
    }

    public static zzup zzb() {
        return new zzup(zzc());
    }

    static String zzc() {
        String version = LibraryVersion.getInstance().getVersion("firebase-auth");
        return (TextUtils.isEmpty(version) || version.equals("UNKNOWN")) ? "-1" : version;
    }

    public final String zza() {
        return String.format("X%s", new Object[]{Integer.toString(this.zza)});
    }
}
