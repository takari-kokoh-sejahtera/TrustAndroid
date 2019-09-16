package com.example.aplikasi2.viewbstk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Base64;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasi2.R;
import com.example.aplikasi2.homebstk.MenuUtama;
import com.example.aplikasi2.inputbstk_sebelum.Model;
import com.example.aplikasi2.loginbstk.ApiClient;
import com.example.aplikasi2.loginbstk.ApiInterface;
import com.example.aplikasi2.loginbstk.ResponLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Delete extends Fragment {

    public int BSTKBefore_ID;
    Context context;
    Model model;
    ApiInterface apiservice;

    private void enableControl(boolean enabled, LinearLayout layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof LinearLayout) {
                LinearLayout layouts = (LinearLayout) child;
                enableControl(false, layouts);
            }
            child.setEnabled(false);
        }
    }

    //    private void enableControlSub(boolean enabled, View layout){
//        for (int i = 0; i < layout.get(); i++) {
//            View child = layout.getChildAt(i);
//            child.setEnabled(false);
//        }
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //region Declar from Layout
        View view = inflater.inflate(R.layout.fragment_fragment__delete, container, false);
        TextView tvCompany_Name = (TextView) view.findViewById(R.id.txtCustomer);
        TextView tvNoPlat = (TextView) view.findViewById(R.id.txtPlatNo);

        final RadioGroup rg_Automatic_Light_Switch = (RadioGroup) view.findViewById(R.id.rgAutomatic_Light_Switch);
        final RadioButton b_Automatic_Light_Switch = (RadioButton) view.findViewById(R.id.bAutomatic_Light_Switch);
        final RadioButton r_Automatic_Light_Switch = (RadioButton) view.findViewById(R.id.rAutomatic_Light_Switch);
        final RadioButton t_Automatic_Light_Switch = (RadioButton) view.findViewById(R.id.tAutomatic_Light_Switch);
        final EditText te_Automatic_Light_Switch = (EditText) view.findViewById(R.id.teAutomatic_Light_Switch);

        final RadioButton b_Lampu_Kecil = (RadioButton) view.findViewById(R.id.bLampu_Kecil);
        final RadioButton r_Lampu_Kecil = (RadioButton) view.findViewById(R.id.rLampu_Kecil);
        final RadioButton t_Lampu_Kecil = (RadioButton) view.findViewById(R.id.tLampu_Kecil);
        final EditText te_Lampu_Kecil = (EditText) view.findViewById(R.id.teLampu_Kecil);

        final RadioButton b_Lampu_Dekat = (RadioButton) view.findViewById(R.id.bLampu_Dekat);
        final RadioButton r_Lampu_Dekat = (RadioButton) view.findViewById(R.id.rLampu_Dekat);
        final RadioButton t_Lampu_Dekat = (RadioButton) view.findViewById(R.id.tLampu_Dekat);
        final EditText te_Lampu_Dekat = (EditText) view.findViewById(R.id.teLampu_Dekat);

        final RadioButton b_Lampu_Jauh = (RadioButton) view.findViewById(R.id.bLampu_Jauh);
        final RadioButton r_Lampu_Jauh = (RadioButton) view.findViewById(R.id.rLampu_Jauh);
        final RadioButton t_Lampu_Jauh = (RadioButton) view.findViewById(R.id.tLampu_Jauh);
        final EditText te_Lampu_Jauh = (EditText) view.findViewById(R.id.teLampu_Jauh);

        final RadioButton b_Lampu_Kabut_Fog_Lamp = (RadioButton) view.findViewById(R.id.bLampu_Kabut_Fog_Lamp);
        final RadioButton r_Lampu_Kabut_Fog_Lamp = (RadioButton) view.findViewById(R.id.rLampu_Kabut_Fog_Lamp);
        final RadioButton t_Lampu_Kabut_Fog_Lamp = (RadioButton) view.findViewById(R.id.tLampu_Kabut_Fog_Lamp);
        final EditText te_Lampu_Kabut_Fog_Lamp = (EditText) view.findViewById(R.id.teLampu_Kabut_Fog_Lamp);

        final RadioButton b_Lampu_Sign_Depan = (RadioButton) view.findViewById(R.id.bLampu_Sign_Depan);
        final RadioButton r_Lampu_Sign_Depan = (RadioButton) view.findViewById(R.id.rLampu_Sign_Depan);
        final RadioButton t_Lampu_Sign_Depan = (RadioButton) view.findViewById(R.id.tLampu_Sign_Depan);
        final EditText te_Lampu_Sign_Depan = (EditText) view.findViewById(R.id.teLampu_Sign_Depan);

        final RadioButton b_Lampu_Sign_Belakang = (RadioButton) view.findViewById(R.id.bLampu_Sign_Belakang);
        final RadioButton r_Lampu_Sign_Belakang = (RadioButton) view.findViewById(R.id.rLampu_Sign_Belakang);
        final RadioButton t_Lampu_Sign_Belakang = (RadioButton) view.findViewById(R.id.tLampu_Sign_Belakang);
        final EditText te_Lampu_Sign_Belakang = (EditText) view.findViewById(R.id.teLampu_Sign_Belakang);

        final RadioButton b_Lampu_Belakang = (RadioButton) view.findViewById(R.id.bLampu_Belakang);
        final RadioButton r_Lampu_Belakang = (RadioButton) view.findViewById(R.id.rLampu_Belakang);
        final RadioButton t_Lampu_Belakang = (RadioButton) view.findViewById(R.id.tLampu_Belakang);
        final EditText te_Lampu_Belakang = (EditText) view.findViewById(R.id.teLampu_Belakang);

        final RadioButton b_Lampu_Rem = (RadioButton) view.findViewById(R.id.bLampu_Rem);
        final RadioButton r_Lampu_Rem = (RadioButton) view.findViewById(R.id.rLampu_Rem);
        final RadioButton t_Lampu_Rem = (RadioButton) view.findViewById(R.id.tLampu_Rem);
        final EditText te_Lampu_Rem = (EditText) view.findViewById(R.id.teLampu_Rem);

        final RadioButton b_Lampu_Mundur = (RadioButton) view.findViewById(R.id.bLampu_Mundur);
        final RadioButton r_Lampu_Mundur = (RadioButton) view.findViewById(R.id.rLampu_Mundur);
        final RadioButton t_Lampu_Mundur = (RadioButton) view.findViewById(R.id.tLampu_Mundur);
        final EditText te_Lampu_Mundur = (EditText) view.findViewById(R.id.teLampu_Mundur);

        final RadioButton b_Lampu_Dashboard = (RadioButton) view.findViewById(R.id.bLampu_Dashboard);
        final RadioButton r_Lampu_Dashboard = (RadioButton) view.findViewById(R.id.rLampu_Dashboard);
        final RadioButton t_Lampu_Dashboard = (RadioButton) view.findViewById(R.id.tLampu_Dashboard);
        final EditText te_Lampu_Dashboard = (EditText) view.findViewById(R.id.teLampu_Dashboard);

        final RadioButton b_Lampu_Plafond_Depan_dan_Belakang = (RadioButton) view.findViewById(R.id.bLampu_Plafond_Depan_dan_Belakang);
        final RadioButton r_Lampu_Plafond_Depan_dan_Belakang = (RadioButton) view.findViewById(R.id.rLampu_Plafond_Depan_dan_Belakang);
        final RadioButton t_Lampu_Plafond_Depan_dan_Belakang = (RadioButton) view.findViewById(R.id.tLampu_Plafond_Depan_dan_Belakang);
        final EditText te_Lampu_Plafond_Depan_dan_Belakang = (EditText) view.findViewById(R.id.teLampu_Plafond_Depan_dan_Belakang);

        final RadioButton b_Klakson = (RadioButton) view.findViewById(R.id.bKlakson);
        final RadioButton r_Klakson = (RadioButton) view.findViewById(R.id.rKlakson);
        final RadioButton t_Klakson = (RadioButton) view.findViewById(R.id.tKlakson);
        final EditText te_Klakson = (EditText) view.findViewById(R.id.teKlakson);

        final RadioButton b_Antena = (RadioButton) view.findViewById(R.id.bAntena);
        final RadioButton r_Antena = (RadioButton) view.findViewById(R.id.rAntena);
        final RadioButton t_Antena = (RadioButton) view.findViewById(R.id.tAntena);
        final EditText te_Antena = (EditText) view.findViewById(R.id.teAntena);

        final RadioButton b_Tape_Radio_CD_DVD_TV_Player = (RadioButton) view.findViewById(R.id.bTape_Radio_CD_DVD_TV_Player);
        final RadioButton r_Tape_Radio_CD_DVD_TV_Player = (RadioButton) view.findViewById(R.id.rTape_Radio_CD_DVD_TV_Player);
        final RadioButton t_Tape_Radio_CD_DVD_TV_Player = (RadioButton) view.findViewById(R.id.tTape_Radio_CD_DVD_TV_Player);
        final EditText te_Tape_Radio_CD_DVD_TV_Player = (EditText) view.findViewById(R.id.teTape_Radio_CD_DVD_TV_Player);

        final RadioButton b_Remote_Tape_Radio_CD_DVD_TV_Player = (RadioButton) view.findViewById(R.id.bRemote_Tape_Radio_CD_DVD_TV_Player);
        final RadioButton r_Remote_Tape_Radio_CD_DVD_TV_Player = (RadioButton) view.findViewById(R.id.rRemote_Tape_Radio_CD_DVD_TV_Player);
        final RadioButton t_Remote_Tape_Radio_CD_DVD_TV_Player = (RadioButton) view.findViewById(R.id.tRemote_Tape_Radio_CD_DVD_TV_Player);
        final EditText te_Remote_Tape_Radio_CD_DVD_TV_Player = (EditText) view.findViewById(R.id.teRemote_Tape_Radio_CD_DVD_TV_Player);

        final RadioButton b_Alarm_Remote_Key = (RadioButton) view.findViewById(R.id.bAlarm_Remote_Key);
        final RadioButton r_Alarm_Remote_Key = (RadioButton) view.findViewById(R.id.rAlarm_Remote_Key);
        final RadioButton t_Alarm_Remote_Key = (RadioButton) view.findViewById(R.id.tAlarm_Remote_Key);
        final EditText te_Alarm_Remote_Key = (EditText) view.findViewById(R.id.teAlarm_Remote_Key);

        final RadioButton b_Central_Lock = (RadioButton) view.findViewById(R.id.bCentral_Lock);
        final RadioButton r_Central_Lock = (RadioButton) view.findViewById(R.id.rCentral_Lock);
        final RadioButton t_Central_Lock = (RadioButton) view.findViewById(R.id.tCentral_Lock);
        final EditText te_Central_Lock = (EditText) view.findViewById(R.id.teCentral_Lock);

        final RadioButton b_Power_Window = (RadioButton) view.findViewById(R.id.bPower_Window);
        final RadioButton r_Power_Window = (RadioButton) view.findViewById(R.id.rPower_Window);
        final RadioButton t_Power_Window = (RadioButton) view.findViewById(R.id.tPower_Window);
        final EditText te_Power_Window = (EditText) view.findViewById(R.id.tePower_Window);

        final RadioButton b_Switch_Mirror = (RadioButton) view.findViewById(R.id.bSwitch_Mirror);
        final RadioButton r_Switch_Mirror = (RadioButton) view.findViewById(R.id.rSwitch_Mirror);
        final RadioButton t_Switch_Mirror = (RadioButton) view.findViewById(R.id.tSwitch_Mirror);
        final EditText te_Switch_Mirror = (EditText) view.findViewById(R.id.teSwitch_Mirror);

        final RadioButton b_Air_Conditioner = (RadioButton) view.findViewById(R.id.bAir_Conditioner);
        final RadioButton r_Air_Conditioner = (RadioButton) view.findViewById(R.id.rAir_Conditioner);
        final RadioButton t_Air_Conditioner = (RadioButton) view.findViewById(R.id.tAir_Conditioner);
        final EditText te_Air_Conditioner = (EditText) view.findViewById(R.id.teAir_Conditioner);

        final RadioButton b_Safety_Belt = (RadioButton) view.findViewById(R.id.bSafety_Belt);
        final RadioButton r_Safety_Belt = (RadioButton) view.findViewById(R.id.rSafety_Belt);
        final RadioButton t_Safety_Belt = (RadioButton) view.findViewById(R.id.tSafety_Belt);
        final EditText te_Safety_Belt = (EditText) view.findViewById(R.id.teSafety_Belt);

        final RadioButton b_Karpet = (RadioButton) view.findViewById(R.id.bKarpet);
        final RadioButton r_Karpet = (RadioButton) view.findViewById(R.id.rKarpet);
        final RadioButton t_Karpet = (RadioButton) view.findViewById(R.id.tKarpet);
        final EditText te_Karpet = (EditText) view.findViewById(R.id.teKarpet);

        final RadioButton b_Lighter = (RadioButton) view.findViewById(R.id.bLighter);
        final RadioButton r_Lighter = (RadioButton) view.findViewById(R.id.rLighter);
        final RadioButton t_Lighter = (RadioButton) view.findViewById(R.id.tLighter);
        final EditText te_Lighter = (EditText) view.findViewById(R.id.teLighter);

        final RadioButton b_Asbak = (RadioButton) view.findViewById(R.id.bAsbak);
        final RadioButton r_Asbak = (RadioButton) view.findViewById(R.id.rAsbak);
        final RadioButton t_Asbak = (RadioButton) view.findViewById(R.id.tAsbak);
        final EditText te_Asbak = (EditText) view.findViewById(R.id.teAsbak);

        final RadioButton b_Sarung_Jok = (RadioButton) view.findViewById(R.id.bSarung_Jok);
        final RadioButton r_Sarung_Jok = (RadioButton) view.findViewById(R.id.rSarung_Jok);
        final RadioButton t_Sarung_Jok = (RadioButton) view.findViewById(R.id.tSarung_Jok);
        final EditText te_Sarung_Jok = (EditText) view.findViewById(R.id.teSarung_Jok);

        final RadioButton b_Sandaran_Kepala = (RadioButton) view.findViewById(R.id.bSandaran_Kepala);
        final RadioButton r_Sandaran_Kepala = (RadioButton) view.findViewById(R.id.rSandaran_Kepala);
        final RadioButton t_Sandaran_Kepala = (RadioButton) view.findViewById(R.id.tSandaran_Kepala);
        final EditText te_Sandaran_Kepala = (EditText) view.findViewById(R.id.teLampu_Belakang);

        final RadioButton b_Spion_Dalam = (RadioButton) view.findViewById(R.id.bSpion_Dalam);
        final RadioButton r_Spion_Dalam = (RadioButton) view.findViewById(R.id.rSpion_Dalam);
        final RadioButton t_Spion_Dalam = (RadioButton) view.findViewById(R.id.tSpion_Dalam);
        final EditText te_Spion_Dalam = (EditText) view.findViewById(R.id.teSpion_Dalam);

        final RadioButton b_Wiper_Blade = (RadioButton) view.findViewById(R.id.bWiper_Blade);
        final RadioButton r_Wiper_Blade = (RadioButton) view.findViewById(R.id.rWiper_Blade);
        final RadioButton t_Wiper_Blade = (RadioButton) view.findViewById(R.id.tWiper_Blade);
        final EditText te_Wiper_Blade = (EditText) view.findViewById(R.id.teWiper_Blade);

        final RadioButton b_Windshield_Washer = (RadioButton) view.findViewById(R.id.bWindshield_Washer);
        final RadioButton r_Windshield_Washer = (RadioButton) view.findViewById(R.id.rWindshield_Washer);
        final RadioButton t_Windshield_Washer = (RadioButton) view.findViewById(R.id.tWindshield_Washer);
        final EditText te_Windshield_Washer = (EditText) view.findViewById(R.id.teWindshield_Washer);

        final RadioButton b_Talang_Air = (RadioButton) view.findViewById(R.id.bTalang_Air);
        final RadioButton r_Talang_Air = (RadioButton) view.findViewById(R.id.rTalang_Air);
        final RadioButton t_Talang_Air = (RadioButton) view.findViewById(R.id.tTalang_Air);
        final EditText te_Talang_Air = (EditText) view.findViewById(R.id.teTalang_Air);

        final RadioButton b_Fender_Lumpur_Depan_dan_Belakang = (RadioButton) view.findViewById(R.id.bFender_Lumpur_Depan_dan_Belakang);
        final RadioButton r_Fender_Lumpur_Depan_dan_Belakang = (RadioButton) view.findViewById(R.id.rFender_Lumpur_Depan_dan_Belakang);
        final RadioButton t_Fender_Lumpur_Depan_dan_Belakang = (RadioButton) view.findViewById(R.id.tFender_Lumpur_Depan_dan_Belakang);
        final EditText te_Fender_Lumpur_Depan_dan_Belakang = (EditText) view.findViewById(R.id.teFender_Lumpur_Depan_dan_Belakang);

        final RadioButton b_Spion_Kiri_Kanan = (RadioButton) view.findViewById(R.id.bSpion_Kiri_Kanan);
        final RadioButton r_Spion_Kiri_Kanan = (RadioButton) view.findViewById(R.id.rSpion_Kiri_Kanan);
        final RadioButton t_Spion_Kiri_Kanan = (RadioButton) view.findViewById(R.id.tSpion_Kiri_Kanan);
        final EditText te_Spion_Kiri_Kanan = (EditText) view.findViewById(R.id.teSpion_Kiri_Kanan);

        final RadioButton b_Tutup_Bensin = (RadioButton) view.findViewById(R.id.bTutup_Bensin);
        final RadioButton r_Tutup_Bensin = (RadioButton) view.findViewById(R.id.rTutup_Bensin);
        final RadioButton t_Tutup_Bensin = (RadioButton) view.findViewById(R.id.tTutup_Bensin);
        final EditText te_Tutup_Bensin = (EditText) view.findViewById(R.id.teTutup_Bensin);

        final RadioButton b_Emblem_Logo = (RadioButton) view.findViewById(R.id.bEmblem_Logo);
        final RadioButton r_Emblem_Logo = (RadioButton) view.findViewById(R.id.rEmblem_Logo);
        final RadioButton t_Emblem_Logo = (RadioButton) view.findViewById(R.id.tEmblem_Logo);
        final EditText te_Emblem_Logo = (EditText) view.findViewById(R.id.teEmblem_Logo);

        final RadioButton b_Kaca_Mobil_dan_Kaca_Film = (RadioButton) view.findViewById(R.id.bKaca_Mobil_dan_Kaca_Film);
        final RadioButton r_Kaca_Mobil_dan_Kaca_Film = (RadioButton) view.findViewById(R.id.rKaca_Mobil_dan_Kaca_Film);
        final RadioButton t_Kaca_Mobil_dan_Kaca_Film = (RadioButton) view.findViewById(R.id.tKaca_Mobil_dan_Kaca_Film);
        final EditText te_Kaca_Mobil_dan_Kaca_Film = (EditText) view.findViewById(R.id.teKaca_Mobil_dan_Kaca_Film);

        final RadioButton b_STNK = (RadioButton) view.findViewById(R.id.bSTNK);
        final RadioButton r_STNK = (RadioButton) view.findViewById(R.id.rSTNK);
        final RadioButton t_STNK = (RadioButton) view.findViewById(R.id.tSTNK);
        final EditText te_STNK = (EditText) view.findViewById(R.id.teSTNK);

        final RadioButton b_Buku_KIR_Stiker_Peneng = (RadioButton) view.findViewById(R.id.bBuku_KIR_Stiker_Peneng);
        final RadioButton r_Buku_KIR_Stiker_Peneng = (RadioButton) view.findViewById(R.id.rBuku_KIR_Stiker_Peneng);
        final RadioButton t_Buku_KIR_Stiker_Peneng = (RadioButton) view.findViewById(R.id.tBuku_KIR_Stiker_Peneng);
        final EditText te_Buku_KIR_Stiker_Peneng = (EditText) view.findViewById(R.id.teBuku_KIR_Stiker_Peneng);

        final RadioButton b_Owners_Manual_Book = (RadioButton) view.findViewById(R.id.bOwners_Manual_Book);
        final RadioButton r_Owners_Manual_Book = (RadioButton) view.findViewById(R.id.rOwners_Manual_Book);
        final RadioButton t_Owners_Manual_Book = (RadioButton) view.findViewById(R.id.tOwners_Manual_Book);
        final EditText te_Owners_Manual_Book = (EditText) view.findViewById(R.id.teOwners_Manual_Book);

        final RadioButton b_Buku_Service = (RadioButton) view.findViewById(R.id.bBuku_Service);
        final RadioButton r_Buku_Service = (RadioButton) view.findViewById(R.id.rBuku_Service);
        final RadioButton t_Buku_Service = (RadioButton) view.findViewById(R.id.tBuku_Service);
        final EditText te_Buku_Service = (EditText) view.findViewById(R.id.teBuku_Service);

        final RadioButton b_Ban_Serep = (RadioButton) view.findViewById(R.id.bBan_Serep);
        final RadioButton r_Ban_Serep = (RadioButton) view.findViewById(R.id.rBan_Serep);
        final RadioButton t_Ban_Serep = (RadioButton) view.findViewById(R.id.tBan_Serep);
        final EditText te_Ban_Serep = (EditText) view.findViewById(R.id.teBan_Serep);

        final RadioButton b_Kunci_Roda_Busi_Pas_Tang = (RadioButton) view.findViewById(R.id.bKunci_Roda_Busi_Pas_Tang);
        final RadioButton r_Kunci_Roda_Busi_Pas_Tang = (RadioButton) view.findViewById(R.id.rKunci_Roda_Busi_Pas_Tang);
        final RadioButton t_Kunci_Roda_Busi_Pas_Tang = (RadioButton) view.findViewById(R.id.tKunci_Roda_Busi_Pas_Tang);
        final EditText te_Kunci_Roda_Busi_Pas_Tang = (EditText) view.findViewById(R.id.teKunci_Roda_Busi_Pas_Tang);

        final RadioButton b_Kunci_Stir = (RadioButton) view.findViewById(R.id.bKunci_Stir);
        final RadioButton r_Kunci_Stir = (RadioButton) view.findViewById(R.id.rKunci_Stir);
        final RadioButton t_Kunci_Stir = (RadioButton) view.findViewById(R.id.tKunci_Stir);
        final EditText te_Kunci_Stir = (EditText) view.findViewById(R.id.teKunci_Stir);

        final RadioButton b_Dongkrak = (RadioButton) view.findViewById(R.id.bDongkrak);
        final RadioButton r_Dongkrak = (RadioButton) view.findViewById(R.id.rDongkrak);
        final RadioButton t_Dongkrak = (RadioButton) view.findViewById(R.id.tDongkrak);
        final EditText te_Dongkrak = (EditText) view.findViewById(R.id.teDongkrak);

        final RadioButton b_P3K = (RadioButton) view.findViewById(R.id.bP3K);
        final RadioButton r_P3K = (RadioButton) view.findViewById(R.id.rP3K);
        final RadioButton t_P3K = (RadioButton) view.findViewById(R.id.tP3K);
        final EditText te_P3K = (EditText) view.findViewById(R.id.teP3K);

        final RadioButton b_Segitiga_Pengaman = (RadioButton) view.findViewById(R.id.bSegitiga_Pengaman);
        final RadioButton r_Segitiga_Pengaman = (RadioButton) view.findViewById(R.id.rSegitiga_Pengaman);
        final RadioButton t_Segitiga_Pengaman = (RadioButton) view.findViewById(R.id.tSegitiga_Pengaman);
        final EditText te_Segitiga_Pengaman = (EditText) view.findViewById(R.id.teSegitiga_Pengaman);

        final RadioButton b_Lap_Kanebo = (RadioButton) view.findViewById(R.id.bLap_Kanebo);
        final RadioButton r_Lap_Kanebo = (RadioButton) view.findViewById(R.id.rLap_Kanebo);
        final RadioButton t_Lap_Kanebo = (RadioButton) view.findViewById(R.id.tLap_Kanebo);
        final EditText te_Lap_Kanebo = (EditText) view.findViewById(R.id.teLap_Kanebo);

        final Spinner spinner_appar = (Spinner) view.findViewById(R.id.spinner_apar);
        final Spinner spinner_fuel = (Spinner) view.findViewById(R.id.spinner_fuel);
        final Spinner spinner_velg_ban = (Spinner) view.findViewById(R.id.spinner_velg_ban);
        final Spinner spinner_tutup_dop = (Spinner) view.findViewById(R.id.spinner_velg_tutup_dop);
        final SeekBar seekbar_bensin = (SeekBar) view.findViewById(R.id.seekbar_bensin);
        final EditText edittext_km = (EditText) view.findViewById(R.id.textedit_km);
        final TextView text_seekbar = (TextView) view.findViewById(R.id.text_seekbar);

        ImageView imageViewDepan = (ImageView) view.findViewById(R.id.imageviewDepan);
        ImageView imageViewBelakang = (ImageView) view.findViewById(R.id.imageviewBelakang);
        ImageView imageViewKanan = (ImageView) view.findViewById(R.id.imageviewKanan);
        ImageView imageViewKiri = (ImageView) view.findViewById(R.id.imageviewKiri);
        ImageView imageViewSignature = (ImageView) view.findViewById(R.id.imageviewSignature);
        TextView txtsignatureName = (TextView) view.findViewById(R.id.txtSignature);

        Button btnYes = (Button) view.findViewById(R.id.btnYes);
        Button btnNo = (Button) view.findViewById(R.id.btnNo);

        //endregion

//        Bikin Layout jadi disable
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutHeader);
        enableControl(false, layout);
        context = this.getActivity();
        apiservice = ApiClient.getClient().create(ApiInterface.class);

        //get BSTK Before
        apiservice.GetBSTKBefore(BSTKBefore_ID).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                try {
                    model = response.body();
                    tvCompany_Name.setText(model.Nama_Customer == null ? "" : model.Nama_Customer);
                    tvNoPlat.setText(model.Nomor_Plat_Kendaraan == null ? "" : model.Nomor_Plat_Kendaraan);

                    //region Set Checklist
                    if (model.Automatic_Light_Switch == "B") {
                        b_Automatic_Light_Switch.setChecked(true);
                    } else if (model.Automatic_Light_Switch == "R") {
                        r_Automatic_Light_Switch.setChecked(true);
                    } else if (model.Automatic_Light_Switch == "T") {
                        t_Automatic_Light_Switch.setChecked(true);
                    }
                    te_Automatic_Light_Switch.setText(model.Automatic_Light_Switch_Ket == null ? "" : model.Automatic_Light_Switch_Ket);

                    if (model.Lampu_Kecil == "B") {
                        b_Lampu_Kecil.setChecked(true);
                    } else if (model.Lampu_Kecil == "R") {
                        r_Lampu_Kecil.setChecked(true);
                    } else if (model.Lampu_Kecil == "T") {
                        t_Lampu_Kecil.setChecked(true);
                    }
                    te_Lampu_Kecil.setText(model.Lampu_Kecil_Ket == null ? "" : model.Lampu_Kecil_Ket);


                    if (model.Lampu_Dekat == "B") {
                        b_Lampu_Dekat.setChecked(true);
                    } else if (model.Lampu_Dekat == "R") {
                        r_Lampu_Dekat.setChecked(true);
                    } else if (model.Lampu_Dekat == "T") {
                        t_Lampu_Dekat.setChecked(true);
                    }
                    te_Lampu_Dekat.setText(model.Lampu_Dekat_Ket == null ? "" : model.Lampu_Dekat_Ket);

                    if (model.Lampu_Jauh == "B") {
                        b_Lampu_Jauh.setChecked(true);
                    } else if (model.Lampu_Jauh == "R") {
                        r_Lampu_Jauh.setChecked(true);
                    } else if (model.Lampu_Jauh == "T") {
                        t_Lampu_Jauh.setChecked(true);
                    }
                    te_Lampu_Jauh.setText(model.Lampu_Jauh_Ket == null ? "" : model.Lampu_Jauh_Ket);

                    if (model.Lampu_Kabut_Fog_Lamp == "B") {
                        b_Lampu_Kabut_Fog_Lamp.setChecked(true);
                    } else if (model.Lampu_Kabut_Fog_Lamp == "R") {
                        r_Lampu_Kabut_Fog_Lamp.setChecked(true);
                    } else if (model.Lampu_Kabut_Fog_Lamp == "T") {
                        t_Lampu_Kabut_Fog_Lamp.setChecked(true);
                    }
                    te_Lampu_Kabut_Fog_Lamp.setText(model.Lampu_Kabut_Fog_Lamp_Ket == null ? "" : model.Lampu_Kabut_Fog_Lamp_Ket);

                    if (model.Lampu_Sign_Depan == "B") {
                        b_Lampu_Sign_Depan.setChecked(true);
                    } else if (model.Lampu_Sign_Depan == "R") {
                        r_Lampu_Sign_Depan.setChecked(true);
                    } else if (model.Lampu_Sign_Depan == "T") {
                        t_Lampu_Sign_Depan.setChecked(true);
                    }
                    te_Lampu_Sign_Depan.setText(model.Lampu_Sign_Depan_Ket == null ? "" : model.Lampu_Sign_Depan_Ket);

                    if (model.Lampu_Sign_Belakang == "B") {
                        b_Lampu_Sign_Belakang.setChecked(true);
                    } else if (model.Lampu_Sign_Belakang == "R") {
                        r_Lampu_Sign_Belakang.setChecked(true);
                    } else if (model.Lampu_Sign_Belakang == "T") {
                        t_Lampu_Sign_Belakang.setChecked(true);
                    }
                    te_Lampu_Sign_Belakang.setText(model.Lampu_Sign_Belakang_Ket == null ? "" : model.Lampu_Sign_Belakang_Ket);

                    if (model.Lampu_Belakang == "B") {
                        b_Lampu_Belakang.setChecked(true);
                    } else if (model.Lampu_Belakang == "R") {
                        r_Lampu_Belakang.setChecked(true);
                    } else if (model.Lampu_Belakang == "T") {
                        t_Lampu_Belakang.setChecked(true);
                    }
                    te_Lampu_Belakang.setText(model.Lampu_Belakang_Ket == null ? "" : model.Lampu_Belakang_Ket);

                    if (model.Lampu_Rem == "B") {
                        b_Lampu_Rem.setChecked(true);
                    } else if (model.Lampu_Rem == "R") {
                        r_Lampu_Rem.setChecked(true);
                    } else if (model.Lampu_Rem == "T") {
                        t_Lampu_Rem.setChecked(true);
                    }
                    te_Lampu_Rem.setText(model.Lampu_Rem_Ket == null ? "" : model.Lampu_Rem_Ket);

                    if (model.Lampu_Mundur == "B") {
                        b_Lampu_Mundur.setChecked(true);
                    } else if (model.Lampu_Mundur == "R") {
                        r_Lampu_Mundur.setChecked(true);
                    } else if (model.Lampu_Mundur == "T") {
                        t_Lampu_Mundur.setChecked(true);
                    }
                    te_Lampu_Mundur.setText(model.Lampu_Mundur_Ket == null ? "" : model.Lampu_Mundur_Ket);

                    if (model.Lampu_Dashboard == "B") {
                        b_Lampu_Dashboard.setChecked(true);
                    } else if (model.Lampu_Dashboard == "R") {
                        r_Lampu_Dashboard.setChecked(true);
                    } else if (model.Lampu_Dashboard == "T") {
                        t_Lampu_Dashboard.setChecked(true);
                    }
                    te_Lampu_Dashboard.setText(model.Lampu_Dashboard_Ket == null ? "" : model.Lampu_Dashboard_Ket);

                    if (model.Lampu_Plafond_Depan_dan_Belakang == "B") {
                        b_Lampu_Plafond_Depan_dan_Belakang.setChecked(true);
                    } else if (model.Lampu_Plafond_Depan_dan_Belakang == "R") {
                        r_Lampu_Plafond_Depan_dan_Belakang.setChecked(true);
                    } else if (model.Lampu_Plafond_Depan_dan_Belakang == "T") {
                        t_Lampu_Plafond_Depan_dan_Belakang.setChecked(true);
                    }
                    te_Lampu_Plafond_Depan_dan_Belakang.setText(model.Lampu_Plafond_Depan_dan_Belakang_Ket == null ? "" : model.Lampu_Plafond_Depan_dan_Belakang_Ket);

                    if (model.Klakson == "B") {
                        b_Klakson.setChecked(true);
                    } else if (model.Klakson == "R") {
                        r_Klakson.setChecked(true);
                    } else if (model.Klakson == "T") {
                        t_Klakson.setChecked(true);
                    }
                    te_Klakson.setText(model.Klakson_Ket == null ? "" : model.Klakson_Ket);

                    if (model.Antena == "B") {
                        b_Antena.setChecked(true);
                    } else if (model.Antena == "R") {
                        r_Antena.setChecked(true);
                    } else if (model.Antena == "T") {
                        t_Antena.setChecked(true);
                    }
                    te_Antena.setText(model.Antena_Ket == null ? "" : model.Antena_Ket);

                    if (model.Tape_Radio_CD_DVD_TV_Player == "B") {
                        b_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    } else if (model.Tape_Radio_CD_DVD_TV_Player == "R") {
                        r_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    } else if (model.Tape_Radio_CD_DVD_TV_Player == "T") {
                        t_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    }
                    te_Tape_Radio_CD_DVD_TV_Player.setText(model.Tape_Radio_CD_DVD_TV_Player_Ket == null ? "" : model.Tape_Radio_CD_DVD_TV_Player_Ket);

                    if (model.Remote_Tape_Radio_CD_DVD_TV_Player == "B") {
                        b_Remote_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    } else if (model.Remote_Tape_Radio_CD_DVD_TV_Player == "R") {
                        r_Remote_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    } else if (model.Remote_Tape_Radio_CD_DVD_TV_Player == "T") {
                        t_Remote_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    }
                    te_Remote_Tape_Radio_CD_DVD_TV_Player.setText(model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket == null ? "" : model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket);

                    if (model.Alarm_Remote_Key == "B") {
                        b_Alarm_Remote_Key.setChecked(true);
                    } else if (model.Alarm_Remote_Key == "R") {
                        r_Alarm_Remote_Key.setChecked(true);
                    } else if (model.Alarm_Remote_Key == "T") {
                        t_Alarm_Remote_Key.setChecked(true);
                    }
                    te_Alarm_Remote_Key.setText(model.Alarm_Remote_Key_Ket == null ? "" : model.Alarm_Remote_Key_Ket);

                    if (model.Central_Lock == "B") {
                        b_Central_Lock.setChecked(true);
                    } else if (model.Central_Lock == "R") {
                        r_Central_Lock.setChecked(true);
                    } else if (model.Central_Lock == "T") {
                        t_Central_Lock.setChecked(true);
                    }
                    te_Central_Lock.setText(model.Central_Lock_Ket == null ? "" : model.Central_Lock_Ket);

                    if (model.Power_Window == "B") {
                        b_Power_Window.setChecked(true);
                    } else if (model.Power_Window == "R") {
                        r_Power_Window.setChecked(true);
                    } else if (model.Power_Window == "T") {
                        t_Power_Window.setChecked(true);
                    }
                    te_Power_Window.setText(model.Power_Window_Ket == null ? "" : model.Power_Window_Ket);

                    if (model.Switch_Mirror == "B") {
                        b_Switch_Mirror.setChecked(true);
                    } else if (model.Switch_Mirror == "R") {
                        r_Switch_Mirror.setChecked(true);
                    } else if (model.Switch_Mirror == "T") {
                        t_Switch_Mirror.setChecked(true);
                    }
                    te_Switch_Mirror.setText(model.Switch_Mirror_Ket == null ? "" : model.Switch_Mirror_Ket);

                    if (model.Air_Conditioner == "B") {
                        b_Air_Conditioner.setChecked(true);
                    } else if (model.Air_Conditioner == "R") {
                        r_Air_Conditioner.setChecked(true);
                    } else if (model.Air_Conditioner == "T") {
                        t_Air_Conditioner.setChecked(true);
                    }
                    te_Air_Conditioner.setText(model.Air_Conditioner_Ket == null ? "" : model.Air_Conditioner_Ket);

                    if (model.Safety_Belt == "B") {
                        b_Safety_Belt.setChecked(true);
                    } else if (model.Safety_Belt == "R") {
                        r_Safety_Belt.setChecked(true);
                    } else if (model.Safety_Belt == "T") {
                        t_Safety_Belt.setChecked(true);
                    }
                    te_Safety_Belt.setText(model.Safety_Belt_Ket == null ? "" : model.Safety_Belt_Ket);

                    if (model.Karpet == "B") {
                        b_Karpet.setChecked(true);
                    } else if (model.Karpet == "R") {
                        r_Karpet.setChecked(true);
                    } else if (model.Karpet == "T") {
                        t_Karpet.setChecked(true);
                    }
                    te_Karpet.setText(model.Karpet_Ket == null ? "" : model.Karpet_Ket);

                    if (model.Lighter == "B") {
                        b_Lighter.setChecked(true);
                    } else if (model.Lighter == "R") {
                        r_Lighter.setChecked(true);
                    } else if (model.Lighter == "T") {
                        t_Lighter.setChecked(true);
                    }
                    te_Lighter.setText(model.Lighter_Ket == null ? "" : model.Lighter_Ket);

                    if (model.Asbak == "B") {
                        b_Asbak.setChecked(true);
                    } else if (model.Asbak == "R") {
                        r_Asbak.setChecked(true);
                    } else if (model.Asbak == "T") {
                        t_Asbak.setChecked(true);
                    }
                    te_Asbak.setText(model.Asbak_Ket == null ? "" : model.Asbak_Ket);

                    if (model.Sarung_Jok == "B") {
                        b_Sarung_Jok.setChecked(true);
                    } else if (model.Sarung_Jok == "R") {
                        r_Sarung_Jok.setChecked(true);
                    } else if (model.Sarung_Jok == "T") {
                        t_Sarung_Jok.setChecked(true);
                    }
                    te_Sarung_Jok.setText(model.Sarung_Jok_Ket == null ? "" : model.Sarung_Jok_Ket);

                    if (model.Sandaran_Kepala == "B") {
                        b_Sandaran_Kepala.setChecked(true);
                    } else if (model.Sandaran_Kepala == "R") {
                        r_Sandaran_Kepala.setChecked(true);
                    } else if (model.Sandaran_Kepala == "T") {
                        t_Sandaran_Kepala.setChecked(true);
                    }
                    te_Sandaran_Kepala.setText(model.Sandaran_Kepala_Ket == null ? "" : model.Sandaran_Kepala_Ket);

                    if (model.Spion_Dalam == "B") {
                        b_Spion_Dalam.setChecked(true);
                    } else if (model.Spion_Dalam == "R") {
                        r_Spion_Dalam.setChecked(true);
                    } else if (model.Spion_Dalam == "T") {
                        t_Spion_Dalam.setChecked(true);
                    }
                    te_Spion_Dalam.setText(model.Spion_Dalam_Ket == null ? "" : model.Spion_Dalam_Ket);

                    if (model.Wiper_Blade == "B") {
                        b_Wiper_Blade.setChecked(true);
                    } else if (model.Wiper_Blade == "R") {
                        r_Wiper_Blade.setChecked(true);
                    } else if (model.Wiper_Blade == "T") {
                        t_Wiper_Blade.setChecked(true);
                    }
                    te_Wiper_Blade.setText(model.Wiper_Blade_Ket == null ? "" : model.Wiper_Blade_Ket);

                    if (model.Windshield_Washer == "B") {
                        b_Windshield_Washer.setChecked(true);
                    } else if (model.Windshield_Washer == "R") {
                        r_Windshield_Washer.setChecked(true);
                    } else if (model.Windshield_Washer == "T") {
                        t_Windshield_Washer.setChecked(true);
                    }
                    te_Windshield_Washer.setText(model.Windshield_Washer_Ket == null ? "" : model.Windshield_Washer_Ket);

                    if (model.Talang_Air == "B") {
                        b_Talang_Air.setChecked(true);
                    } else if (model.Talang_Air == "R") {
                        r_Talang_Air.setChecked(true);
                    } else if (model.Talang_Air == "T") {
                        t_Talang_Air.setChecked(true);
                    }
                    te_Talang_Air.setText(model.Talang_Air_Ket == null ? "" : model.Talang_Air_Ket);

                    if (model.Fender_Lumpur_Depan_dan_Belakang == "B") {
                        b_Fender_Lumpur_Depan_dan_Belakang.setChecked(true);
                    } else if (model.Fender_Lumpur_Depan_dan_Belakang == "R") {
                        r_Fender_Lumpur_Depan_dan_Belakang.setChecked(true);
                    } else if (model.Fender_Lumpur_Depan_dan_Belakang == "T") {
                        t_Fender_Lumpur_Depan_dan_Belakang.setChecked(true);
                    }
                    te_Fender_Lumpur_Depan_dan_Belakang.setText(model.Fender_Lumpur_Depan_dan_Belakang_Ket == null ? "" : model.Fender_Lumpur_Depan_dan_Belakang_Ket);

                    if (model.Spion_Kiri_Kanan == "B") {
                        b_Spion_Kiri_Kanan.setChecked(true);
                    } else if (model.Spion_Kiri_Kanan == "R") {
                        r_Spion_Kiri_Kanan.setChecked(true);
                    } else if (model.Spion_Kiri_Kanan == "T") {
                        t_Spion_Kiri_Kanan.setChecked(true);
                    }
                    te_Spion_Kiri_Kanan.setText(model.Spion_Kiri_Kanan_Ket == null ? "" : model.Spion_Kiri_Kanan_Ket);

                    if (model.Tutup_Bensin == "B") {
                        b_Tutup_Bensin.setChecked(true);
                    } else if (model.Tutup_Bensin == "R") {
                        r_Tutup_Bensin.setChecked(true);
                    } else if (model.Tutup_Bensin == "T") {
                        t_Tutup_Bensin.setChecked(true);
                    }
                    te_Tutup_Bensin.setText(model.Tutup_Bensin_Ket == null ? "" : model.Tutup_Bensin_Ket);

                    if (model.Emblem_Logo == "B") {
                        b_Emblem_Logo.setChecked(true);
                    } else if (model.Emblem_Logo == "R") {
                        r_Emblem_Logo.setChecked(true);
                    } else if (model.Emblem_Logo == "T") {
                        t_Emblem_Logo.setChecked(true);
                    }
                    te_Emblem_Logo.setText(model.Emblem_Logo_Ket == null ? "" : model.Emblem_Logo_Ket);

                    if (model.Kaca_Mobil_dan_Kaca_Film == "B") {
                        b_Kaca_Mobil_dan_Kaca_Film.setChecked(true);
                    } else if (model.Kaca_Mobil_dan_Kaca_Film == "R") {
                        r_Kaca_Mobil_dan_Kaca_Film.setChecked(true);
                    } else if (model.Kaca_Mobil_dan_Kaca_Film == "T") {
                        t_Kaca_Mobil_dan_Kaca_Film.setChecked(true);
                    }
                    te_Kaca_Mobil_dan_Kaca_Film.setText(model.Kaca_Mobil_dan_Kaca_Film_Ket == null ? "" : model.Kaca_Mobil_dan_Kaca_Film_Ket);

                    if (model.STNK == "B") {
                        b_STNK.setChecked(true);
                    } else if (model.STNK == "R") {
                        r_STNK.setChecked(true);
                    } else if (model.STNK == "T") {
                        t_STNK.setChecked(true);
                    }
                    te_STNK.setText(model.STNK_Ket == null ? "" : model.STNK_Ket);

                    if (model.Buku_KIR_Stiker_Peneng == "B") {
                        b_Buku_KIR_Stiker_Peneng.setChecked(true);
                    } else if (model.Buku_KIR_Stiker_Peneng == "R") {
                        r_Buku_KIR_Stiker_Peneng.setChecked(true);
                    } else if (model.Buku_KIR_Stiker_Peneng == "T") {
                        t_Buku_KIR_Stiker_Peneng.setChecked(true);
                    }
                    te_Buku_KIR_Stiker_Peneng.setText(model.Buku_KIR_Stiker_Peneng_Ket == null ? "" : model.Buku_KIR_Stiker_Peneng_Ket);

                    if (model.Owners_Manual_Book == "B") {
                        b_Owners_Manual_Book.setChecked(true);
                    } else if (model.Owners_Manual_Book == "R") {
                        r_Owners_Manual_Book.setChecked(true);
                    } else if (model.Owners_Manual_Book == "T") {
                        t_Owners_Manual_Book.setChecked(true);
                    }
                    te_Owners_Manual_Book.setText(model.Owners_Manual_Book_Ket == null ? "" : model.Owners_Manual_Book_Ket);

                    if (model.Buku_Service == "B") {
                        b_Buku_Service.setChecked(true);
                    } else if (model.Buku_Service == "R") {
                        r_Buku_Service.setChecked(true);
                    } else if (model.Buku_Service == "T") {
                        t_Buku_Service.setChecked(true);
                    }
                    te_Buku_Service.setText(model.Buku_Service_Ket == null ? "" : model.Buku_Service_Ket);

                    if (model.Ban_Serep == "B") {
                        b_Ban_Serep.setChecked(true);
                    } else if (model.Ban_Serep == "R") {
                        r_Ban_Serep.setChecked(true);
                    } else if (model.Ban_Serep == "T") {
                        t_Ban_Serep.setChecked(true);
                    }
                    te_Ban_Serep.setText(model.Ban_Serep_Ket == null ? "" : model.Ban_Serep_Ket);

                    if (model.Kunci_Roda_Busi_Pas_Tang == "B") {
                        b_Kunci_Roda_Busi_Pas_Tang.setChecked(true);
                    } else if (model.Kunci_Roda_Busi_Pas_Tang == "R") {
                        r_Kunci_Roda_Busi_Pas_Tang.setChecked(true);
                    } else if (model.Kunci_Roda_Busi_Pas_Tang == "T") {
                        t_Kunci_Roda_Busi_Pas_Tang.setChecked(true);
                    }
                    te_Kunci_Roda_Busi_Pas_Tang.setText(model.Kunci_Roda_Busi_Pas_Tang_Ket == null ? "" : model.Kunci_Roda_Busi_Pas_Tang_Ket);

                    if (model.Kunci_Stir == "B") {
                        b_Kunci_Stir.setChecked(true);
                    } else if (model.Kunci_Stir == "R") {
                        r_Kunci_Stir.setChecked(true);
                    } else if (model.Kunci_Stir == "T") {
                        t_Kunci_Stir.setChecked(true);
                    }
                    te_Kunci_Stir.setText(model.Kunci_Stir_Ket == null ? "" : model.Kunci_Stir_Ket);

                    if (model.Dongkrak == "B") {
                        b_Dongkrak.setChecked(true);
                    } else if (model.Dongkrak == "R") {
                        r_Dongkrak.setChecked(true);
                    } else if (model.Dongkrak == "T") {
                        t_Dongkrak.setChecked(true);
                    }
                    te_Dongkrak.setText(model.Dongkrak_Ket == null ? "" : model.Dongkrak_Ket);

                    if (model.P3K == "B") {
                        b_P3K.setChecked(true);
                    } else if (model.P3K == "R") {
                        r_P3K.setChecked(true);
                    } else if (model.P3K == "T") {
                        t_P3K.setChecked(true);
                    }
                    te_P3K.setText(model.P3K_Ket == null ? "" : model.P3K_Ket);

                    if (model.Segitiga_Pengaman == "B") {
                        b_Segitiga_Pengaman.setChecked(true);
                    } else if (model.Segitiga_Pengaman == "R") {
                        r_Segitiga_Pengaman.setChecked(true);
                    } else if (model.Segitiga_Pengaman == "T") {
                        t_Segitiga_Pengaman.setChecked(true);
                    }
                    te_Segitiga_Pengaman.setText(model.Segitiga_Pengaman_Ket == null ? "" : model.Segitiga_Pengaman_Ket);

                    if (model.Lap_Kanebo == "B") {
                        b_Lap_Kanebo.setChecked(true);
                    } else if (model.Lap_Kanebo == "R") {
                        r_Lap_Kanebo.setChecked(true);
                    } else if (model.Lap_Kanebo == "T") {
                        t_Lap_Kanebo.setChecked(true);
                    }
                    te_Lap_Kanebo.setText(model.Lap_Kanebo_Ket == null ? "" : model.Lap_Kanebo_Ket);
                    //endregion

                    //region Set Appar dll
                    final Spinner spinner_appar = (Spinner) view.findViewById(R.id.spinner_apar);
                    final Spinner spinner_fuel = (Spinner) view.findViewById(R.id.spinner_fuel);
                    final Spinner spinner_velg_ban = (Spinner) view.findViewById(R.id.spinner_velg_ban);
                    final Spinner spinner_tutup_dop = (Spinner) view.findViewById(R.id.spinner_velg_tutup_dop);
                    final SeekBar seekbar_bensin = (SeekBar) view.findViewById(R.id.seekbar_bensin);
                    ImageButton button_next = (ImageButton) view.findViewById(R.id.button_next);
                    ImageButton button_back = (ImageButton) view.findViewById(R.id.button_back);
                    final EditText edittext_km = (EditText) view.findViewById(R.id.textedit_km);
                    final TextView text_seekbar = (TextView) view.findViewById(R.id.text_seekbar);

                    ArrayAdapter<CharSequence> adapter_appar = ArrayAdapter.createFromResource(context,
                            R.array.string_apar, android.R.layout.simple_spinner_item);
                    ArrayAdapter<CharSequence> adapter_fuel = ArrayAdapter.createFromResource(context,
                            R.array.string_fuel, android.R.layout.simple_spinner_item);
                    ArrayAdapter<CharSequence> adapter_velg_ban = ArrayAdapter.createFromResource(context,
                            R.array.string_velg_ban, android.R.layout.simple_spinner_item);
                    ArrayAdapter<CharSequence> adapter_tutup_dop = ArrayAdapter.createFromResource(context,
                            R.array.string_tutup_dop, android.R.layout.simple_spinner_item);
                    adapter_appar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    adapter_fuel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    adapter_velg_ban.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    adapter_tutup_dop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_appar.setAdapter(adapter_appar);
                    spinner_fuel.setAdapter(adapter_fuel);
                    spinner_velg_ban.setAdapter(adapter_velg_ban);
                    spinner_tutup_dop.setAdapter(adapter_tutup_dop);
                    seekbar_bensin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            text_seekbar.setText("" + seekbar_bensin.getProgress());
                            if (seekbar_bensin.getProgress() == 0) {
                                text_seekbar.setText("0%");
                            } else if (seekbar_bensin.getProgress() == 1) {
                                text_seekbar.setText("25%");
                            } else if (seekbar_bensin.getProgress() == 2) {
                                text_seekbar.setText("50%");
                            } else if (seekbar_bensin.getProgress() == 3) {
                                text_seekbar.setText("75%");
                            } else if (seekbar_bensin.getProgress() == 4) {
                                text_seekbar.setText("100%");
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });

                    if (model.isi_tangki_ket != null) {
                        seekbar_bensin.setProgress(model.isi_tangki);
                        text_seekbar.setText(model.isi_tangki_ket);
                    }

                    if (model.apar != null) {
                        int spinnerPosition = adapter_appar.getPosition(model.apar);
                        spinner_appar.setSelection(spinnerPosition);
                    }
                    if (model.fuel != null) {
                        int spinnerPosition = adapter_fuel.getPosition(model.fuel);
                        spinner_fuel.setSelection(spinnerPosition);
                    }
                    if (model.velg_ban != null) {
                        int spinnerPosition = adapter_velg_ban.getPosition(model.velg_ban);
                        spinner_velg_ban.setSelection(spinnerPosition);
                    }
                    if (model.tutup_dop != null) {
                        int spinnerPosition = adapter_tutup_dop.getPosition(model.tutup_dop);
                        spinner_tutup_dop.setSelection(spinnerPosition);
                    }
                    if (model.km != null) {
                        edittext_km.setText(model.km);
                    }
                    //endregion

                    if (model.Foto_Kendaraan_Tampak_Depan != null) {
                        byte[] byteArray = Base64.decode(model.Foto_Kendaraan_Tampak_Depan.getBytes(), Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        imageViewDepan.setImageBitmap(bitmap);
                    }
                    if (model.Foto_Kendaraan_Tampak_Belakang != null) {
                        byte[] byteArray = Base64.decode(model.Foto_Kendaraan_Tampak_Belakang.getBytes(), Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        imageViewBelakang.setImageBitmap(bitmap);
                    }
                    if (model.Foto_Kendaraan_Tampak_Samping_Kanan != null) {
                        byte[] byteArray = Base64.decode(model.Foto_Kendaraan_Tampak_Samping_Kanan.getBytes(), Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        imageViewKanan.setImageBitmap(bitmap);
                    }
                    if (model.Foto_Kendaraan_Tampak_Samping_Kiri != null) {
                        byte[] byteArray = Base64.decode(model.Foto_Kendaraan_Tampak_Samping_Kiri.getBytes(), Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        imageViewKiri.setImageBitmap(bitmap);
                    }
                    if (model.signature_image != null) {
                        byte[] byteArray = Base64.decode(model.signature_image.getBytes(), Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        imageViewSignature.setImageBitmap(bitmap);
                    }
                    txtsignatureName.setText(model.signature == null ? "" : model.signature);


                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

//        click yes
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiservice = ApiClient.getClient().create(ApiInterface.class);
                apiservice.BSTKBeforeDelete(BSTKBefore_ID).enqueue(new Callback<ResponLogin>() {
                    @Override
                    public void onResponse(Call<ResponLogin> call, Response<ResponLogin> response) {

                        ResponLogin respon = response.body();
                        if (respon.getStatus().equals("Success")) {
                            Toast.makeText(context, respon.getStatus(), Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(context, MenuUtama.class);
//                            startActivity(intent);
                            bact_toView();
                        } else if (respon.getStatus().equals("Error")) {
                            Toast.makeText(context, respon.getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Error, No Message", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponLogin> call, Throwable t) {
                        //Toast.makeText(MainActivity.this,"Gagal Terhubung ke server", Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bact_toView();
            }
        });

        return view;
    }

    private void bact_toView() {
        Fragment_View fragment = new Fragment_View();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
