package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.core.ServerValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzbd {
    static final long zza = 3600000;
    private static final List<String> zzb = new ArrayList(Arrays.asList(new String[]{"firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", ServerValues.NAME_OP_TIMESTAMP}));
    private static final zzbd zzc = new zzbd();
    private Task<AuthResult> zzd;
    private Task<String> zze;
    private long zzf = 0;

    private zzbd() {
    }

    public static zzbd zza() {
        return zzc;
    }

    private static final void zzf(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String remove : zzb) {
            edit.remove(remove);
        }
        edit.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0080, code lost:
        if (r4.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN") == false) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.firebase.auth.FirebaseAuth r13) {
        /*
            r12 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            com.google.firebase.FirebaseApp r0 = r13.getApp()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "com.google.firebase.auth.internal.ProcessDeathHelper"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "firebaseAppName"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.firebase.FirebaseApp r4 = r13.getApp()
            java.lang.String r4 = r4.getName()
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x0029
            return
        L_0x0029:
            java.lang.String r1 = "verifyAssertionRequest"
            boolean r4 = r0.contains(r1)
            r5 = -1
            java.lang.String r6 = "operation"
            r7 = 0
            java.lang.String r9 = "timestamp"
            r10 = 0
            if (r4 == 0) goto L_0x00ef
            java.lang.String r1 = r0.getString(r1, r3)
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase-auth-api.zzxv> r4 = com.google.android.gms.internal.p001firebaseauthapi.zzxv.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromString(r1, r4)
            com.google.android.gms.internal.firebase-auth-api.zzxv r1 = (com.google.android.gms.internal.p001firebaseauthapi.zzxv) r1
            java.lang.String r4 = r0.getString(r6, r3)
            java.lang.String r6 = "tenantId"
            java.lang.String r6 = r0.getString(r6, r10)
            java.lang.String r11 = "firebaseUserUid"
            java.lang.String r3 = r0.getString(r11, r3)
            long r7 = r0.getLong(r9, r7)
            r12.zzf = r7
            if (r6 == 0) goto L_0x0063
            r13.setTenantId(r6)
            r1.zzd(r6)
        L_0x0063:
            int r6 = r4.hashCode()
            r7 = -98509410(0xfffffffffa20dd9e, float:-2.088156E35)
            r8 = 2
            r9 = 1
            if (r6 == r7) goto L_0x008d
            r7 = 175006864(0xa6e6490, float:1.1478197E-32)
            if (r6 == r7) goto L_0x0083
            r7 = 1450464913(0x56745691, float:6.7163159E13)
            if (r6 == r7) goto L_0x0079
        L_0x0078:
            goto L_0x0097
        L_0x0079:
            java.lang.String r6 = "com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0078
            goto L_0x0098
        L_0x0083:
            java.lang.String r2 = "com.google.firebase.auth.internal.NONGMSCORE_LINK"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0078
            r2 = 1
            goto L_0x0098
        L_0x008d:
            java.lang.String r2 = "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0078
            r2 = 2
            goto L_0x0098
        L_0x0097:
            r2 = -1
        L_0x0098:
            if (r2 == 0) goto L_0x00e1
            if (r2 == r9) goto L_0x00c1
            if (r2 == r8) goto L_0x00a1
            r12.zzd = r10
            goto L_0x00eb
        L_0x00a1:
            com.google.firebase.auth.FirebaseUser r2 = r13.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00be
            com.google.firebase.auth.FirebaseUser r2 = r13.getCurrentUser()
            com.google.firebase.auth.zze r1 = com.google.firebase.auth.zze.zzc(r1)
            com.google.android.gms.tasks.Task r13 = r13.zzi(r2, r1)
            r12.zzd = r13
            goto L_0x00eb
        L_0x00be:
            r12.zzd = r10
            goto L_0x00eb
        L_0x00c1:
            com.google.firebase.auth.FirebaseUser r2 = r13.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00de
            com.google.firebase.auth.FirebaseUser r2 = r13.getCurrentUser()
            com.google.firebase.auth.zze r1 = com.google.firebase.auth.zze.zzc(r1)
            com.google.android.gms.tasks.Task r13 = r13.zzm(r2, r1)
            r12.zzd = r13
            goto L_0x00eb
        L_0x00de:
            r12.zzd = r10
            goto L_0x00eb
        L_0x00e1:
            com.google.firebase.auth.zze r1 = com.google.firebase.auth.zze.zzc(r1)
            com.google.android.gms.tasks.Task r13 = r13.signInWithCredential(r1)
            r12.zzd = r13
        L_0x00eb:
            zzf(r0)
            return
        L_0x00ef:
            java.lang.String r13 = "recaptchaToken"
            boolean r1 = r0.contains(r13)
            if (r1 == 0) goto L_0x012a
            java.lang.String r13 = r0.getString(r13, r3)
            java.lang.String r1 = r0.getString(r6, r3)
            long r3 = r0.getLong(r9, r7)
            r12.zzf = r3
            int r3 = r1.hashCode()
            r4 = -214796028(0xfffffffff3327904, float:-1.4140065E31)
            if (r3 == r4) goto L_0x0110
        L_0x010f:
            goto L_0x011a
        L_0x0110:
            java.lang.String r3 = "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x010f
            goto L_0x011b
        L_0x011a:
            r2 = -1
        L_0x011b:
            if (r2 == 0) goto L_0x0120
            r12.zze = r10
            goto L_0x0126
        L_0x0120:
            com.google.android.gms.tasks.Task r13 = com.google.android.gms.tasks.Tasks.forResult(r13)
            r12.zze = r13
        L_0x0126:
            zzf(r0)
            return
        L_0x012a:
            java.lang.String r13 = "statusCode"
            boolean r1 = r0.contains(r13)
            if (r1 == 0) goto L_0x0157
            r1 = 17062(0x42a6, float:2.3909E-41)
            int r13 = r0.getInt(r13, r1)
            java.lang.String r1 = "statusMessage"
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            r2.<init>(r13, r1)
            long r3 = r0.getLong(r9, r7)
            r12.zzf = r3
            zzf(r0)
            com.google.firebase.FirebaseException r13 = com.google.android.gms.internal.p001firebaseauthapi.zztt.zza(r2)
            com.google.android.gms.tasks.Task r13 = com.google.android.gms.tasks.Tasks.forException(r13)
            r12.zzd = r13
        L_0x0157:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbd.zzb(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final Task<AuthResult> zzc() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zzf < zza) {
            return this.zzd;
        }
        return null;
    }

    public final Task<String> zzd() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zzf < zza) {
            return this.zze;
        }
        return null;
    }

    public final void zze(Context context) {
        Preconditions.checkNotNull(context);
        zzf(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzd = null;
        this.zzf = 0;
    }
}
