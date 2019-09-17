package com.example.aplikasi2.viewbstk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasi2.Model.Globals;
import com.example.aplikasi2.R;
import com.example.aplikasi2.homebstk.MenuUtama;
import com.example.aplikasi2.inputbstk_sebelum.Model;
import com.example.aplikasi2.loginbstk.ApiClient;
import com.example.aplikasi2.loginbstk.ApiInterface;
import com.example.aplikasi2.loginbstk.ResponLogin;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Edit extends Fragment {
    public int BSTKBefore_ID;
    Context context;
    Model model;
    ApiInterface apiservice;

    ImageView imageViewDepan;
    ImageView imageViewBelakang;
    ImageView imageViewKanan;
    ImageView imageViewKiri;
    ImageView imageViewSignature;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //region Declar from Layout
        View view = inflater.inflate(R.layout.fragment_fragment__edit, container, false);
        TextView tvCompany_Name = (TextView) view.findViewById(R.id.txtCustomer);
        TextView tvNoPlat = (TextView) view.findViewById(R.id.txtPlatNo);

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

        imageViewDepan = (ImageView) view.findViewById(R.id.imageviewDepan);
        imageViewBelakang = (ImageView) view.findViewById(R.id.imageviewBelakang);
        imageViewKanan = (ImageView) view.findViewById(R.id.imageviewKanan);
        imageViewKiri = (ImageView) view.findViewById(R.id.imageviewKiri);
        imageViewSignature = (ImageView) view.findViewById(R.id.imageviewSignature);
        TextView txtsignatureName = (TextView) view.findViewById(R.id.txtSignature);

        Button btnYes = (Button) view.findViewById(R.id.btnYes);
        Button btnNo = (Button) view.findViewById(R.id.btnNo);

        ImageButton btnKameraDepan = (ImageButton) view.findViewById(R.id.button_camera_depan);
        ImageButton btnKameraBelakang = (ImageButton) view.findViewById(R.id.button_camera_belakang);
        ImageButton btnKameraKanan = (ImageButton) view.findViewById(R.id.button_camera_kanan);
        ImageButton btnKameraKiri = (ImageButton) view.findViewById(R.id.button_camera_kiri);

        //endregion


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
                    if (model.Automatic_Light_Switch.equals("B")) {
                        b_Automatic_Light_Switch.setChecked(true);
                    } else if (model.Automatic_Light_Switch.equals("R")) {
                        r_Automatic_Light_Switch.setChecked(true);
                    } else if (model.Automatic_Light_Switch.equals("T")) {
                        t_Automatic_Light_Switch.setChecked(true);
                    }
                    te_Automatic_Light_Switch.setText(model.Automatic_Light_Switch_Ket == null ? "" : model.Automatic_Light_Switch_Ket);

                    if (model.Lampu_Kecil.equals("B")) {
                        b_Lampu_Kecil.setChecked(true);
                    } else if (model.Lampu_Kecil.equals("R")) {
                        r_Lampu_Kecil.setChecked(true);
                    } else if (model.Lampu_Kecil.equals("T")) {
                        t_Lampu_Kecil.setChecked(true);
                    }
                    te_Lampu_Kecil.setText(model.Lampu_Kecil_Ket == null ? "" : model.Lampu_Kecil_Ket);


                    if (model.Lampu_Dekat.equals("B")) {
                        b_Lampu_Dekat.setChecked(true);
                    } else if (model.Lampu_Dekat.equals("R")) {
                        r_Lampu_Dekat.setChecked(true);
                    } else if (model.Lampu_Dekat.equals("T")) {
                        t_Lampu_Dekat.setChecked(true);
                    }
                    te_Lampu_Dekat.setText(model.Lampu_Dekat_Ket == null ? "" : model.Lampu_Dekat_Ket);

                    if (model.Lampu_Jauh.equals("B")) {
                        b_Lampu_Jauh.setChecked(true);
                    } else if (model.Lampu_Jauh.equals("R")) {
                        r_Lampu_Jauh.setChecked(true);
                    } else if (model.Lampu_Jauh.equals("T")) {
                        t_Lampu_Jauh.setChecked(true);
                    }
                    te_Lampu_Jauh.setText(model.Lampu_Jauh_Ket == null ? "" : model.Lampu_Jauh_Ket);

                    if (model.Lampu_Kabut_Fog_Lamp.equals("B")) {
                        b_Lampu_Kabut_Fog_Lamp.setChecked(true);
                    } else if (model.Lampu_Kabut_Fog_Lamp.equals("R")) {
                        r_Lampu_Kabut_Fog_Lamp.setChecked(true);
                    } else if (model.Lampu_Kabut_Fog_Lamp.equals("T")) {
                        t_Lampu_Kabut_Fog_Lamp.setChecked(true);
                    }
                    te_Lampu_Kabut_Fog_Lamp.setText(model.Lampu_Kabut_Fog_Lamp_Ket == null ? "" : model.Lampu_Kabut_Fog_Lamp_Ket);

                    if (model.Lampu_Sign_Depan.equals("B")) {
                        b_Lampu_Sign_Depan.setChecked(true);
                    } else if (model.Lampu_Sign_Depan.equals("R")) {
                        r_Lampu_Sign_Depan.setChecked(true);
                    } else if (model.Lampu_Sign_Depan.equals("T")) {
                        t_Lampu_Sign_Depan.setChecked(true);
                    }
                    te_Lampu_Sign_Depan.setText(model.Lampu_Sign_Depan_Ket == null ? "" : model.Lampu_Sign_Depan_Ket);

                    if (model.Lampu_Sign_Belakang.equals("B")) {
                        b_Lampu_Sign_Belakang.setChecked(true);
                    } else if (model.Lampu_Sign_Belakang.equals("R")) {
                        r_Lampu_Sign_Belakang.setChecked(true);
                    } else if (model.Lampu_Sign_Belakang.equals("T")) {
                        t_Lampu_Sign_Belakang.setChecked(true);
                    }
                    te_Lampu_Sign_Belakang.setText(model.Lampu_Sign_Belakang_Ket == null ? "" : model.Lampu_Sign_Belakang_Ket);

                    if (model.Lampu_Belakang.equals("B")) {
                        b_Lampu_Belakang.setChecked(true);
                    } else if (model.Lampu_Belakang.equals("R")) {
                        r_Lampu_Belakang.setChecked(true);
                    } else if (model.Lampu_Belakang.equals("T")) {
                        t_Lampu_Belakang.setChecked(true);
                    }
                    te_Lampu_Belakang.setText(model.Lampu_Belakang_Ket == null ? "" : model.Lampu_Belakang_Ket);

                    if (model.Lampu_Rem.equals("B")) {
                        b_Lampu_Rem.setChecked(true);
                    } else if (model.Lampu_Rem.equals("R")) {
                        r_Lampu_Rem.setChecked(true);
                    } else if (model.Lampu_Rem.equals("T")) {
                        t_Lampu_Rem.setChecked(true);
                    }
                    te_Lampu_Rem.setText(model.Lampu_Rem_Ket == null ? "" : model.Lampu_Rem_Ket);

                    if (model.Lampu_Mundur.equals("B")) {
                        b_Lampu_Mundur.setChecked(true);
                    } else if (model.Lampu_Mundur.equals("R")) {
                        r_Lampu_Mundur.setChecked(true);
                    } else if (model.Lampu_Mundur.equals("T")) {
                        t_Lampu_Mundur.setChecked(true);
                    }
                    te_Lampu_Mundur.setText(model.Lampu_Mundur_Ket == null ? "" : model.Lampu_Mundur_Ket);

                    if (model.Lampu_Dashboard.equals("B")) {
                        b_Lampu_Dashboard.setChecked(true);
                    } else if (model.Lampu_Dashboard.equals("R")) {
                        r_Lampu_Dashboard.setChecked(true);
                    } else if (model.Lampu_Dashboard.equals("T")) {
                        t_Lampu_Dashboard.setChecked(true);
                    }
                    te_Lampu_Dashboard.setText(model.Lampu_Dashboard_Ket == null ? "" : model.Lampu_Dashboard_Ket);

                    if (model.Lampu_Plafond_Depan_dan_Belakang.equals("B")) {
                        b_Lampu_Plafond_Depan_dan_Belakang.setChecked(true);
                    } else if (model.Lampu_Plafond_Depan_dan_Belakang.equals("R")) {
                        r_Lampu_Plafond_Depan_dan_Belakang.setChecked(true);
                    } else if (model.Lampu_Plafond_Depan_dan_Belakang.equals("T")) {
                        t_Lampu_Plafond_Depan_dan_Belakang.setChecked(true);
                    }
                    te_Lampu_Plafond_Depan_dan_Belakang.setText(model.Lampu_Plafond_Depan_dan_Belakang_Ket == null ? "" : model.Lampu_Plafond_Depan_dan_Belakang_Ket);

                    if (model.Klakson.equals("B")) {
                        b_Klakson.setChecked(true);
                    } else if (model.Klakson.equals("R")) {
                        r_Klakson.setChecked(true);
                    } else if (model.Klakson.equals("T")) {
                        t_Klakson.setChecked(true);
                    }
                    te_Klakson.setText(model.Klakson_Ket == null ? "" : model.Klakson_Ket);

                    if (model.Antena.equals("B")) {
                        b_Antena.setChecked(true);
                    } else if (model.Antena.equals("R")) {
                        r_Antena.setChecked(true);
                    } else if (model.Antena.equals("T")) {
                        t_Antena.setChecked(true);
                    }
                    te_Antena.setText(model.Antena_Ket == null ? "" : model.Antena_Ket);

                    if (model.Tape_Radio_CD_DVD_TV_Player.equals("B")) {
                        b_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    } else if (model.Tape_Radio_CD_DVD_TV_Player.equals("R")) {
                        r_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    } else if (model.Tape_Radio_CD_DVD_TV_Player.equals("T")) {
                        t_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    }
                    te_Tape_Radio_CD_DVD_TV_Player.setText(model.Tape_Radio_CD_DVD_TV_Player_Ket == null ? "" : model.Tape_Radio_CD_DVD_TV_Player_Ket);

                    if (model.Remote_Tape_Radio_CD_DVD_TV_Player.equals("B")) {
                        b_Remote_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    } else if (model.Remote_Tape_Radio_CD_DVD_TV_Player.equals("R")) {
                        r_Remote_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    } else if (model.Remote_Tape_Radio_CD_DVD_TV_Player.equals("T")) {
                        t_Remote_Tape_Radio_CD_DVD_TV_Player.setChecked(true);
                    }
                    te_Remote_Tape_Radio_CD_DVD_TV_Player.setText(model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket == null ? "" : model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket);

                    if (model.Alarm_Remote_Key.equals("B")) {
                        b_Alarm_Remote_Key.setChecked(true);
                    } else if (model.Alarm_Remote_Key.equals("R")) {
                        r_Alarm_Remote_Key.setChecked(true);
                    } else if (model.Alarm_Remote_Key.equals("T")) {
                        t_Alarm_Remote_Key.setChecked(true);
                    }
                    te_Alarm_Remote_Key.setText(model.Alarm_Remote_Key_Ket == null ? "" : model.Alarm_Remote_Key_Ket);

                    if (model.Central_Lock.equals("B")) {
                        b_Central_Lock.setChecked(true);
                    } else if (model.Central_Lock.equals("R")) {
                        r_Central_Lock.setChecked(true);
                    } else if (model.Central_Lock.equals("T")) {
                        t_Central_Lock.setChecked(true);
                    }
                    te_Central_Lock.setText(model.Central_Lock_Ket == null ? "" : model.Central_Lock_Ket);

                    if (model.Power_Window.equals("B")) {
                        b_Power_Window.setChecked(true);
                    } else if (model.Power_Window.equals("R")) {
                        r_Power_Window.setChecked(true);
                    } else if (model.Power_Window.equals("T")) {
                        t_Power_Window.setChecked(true);
                    }
                    te_Power_Window.setText(model.Power_Window_Ket == null ? "" : model.Power_Window_Ket);

                    if (model.Switch_Mirror.equals("B")) {
                        b_Switch_Mirror.setChecked(true);
                    } else if (model.Switch_Mirror.equals("R")) {
                        r_Switch_Mirror.setChecked(true);
                    } else if (model.Switch_Mirror.equals("T")) {
                        t_Switch_Mirror.setChecked(true);
                    }
                    te_Switch_Mirror.setText(model.Switch_Mirror_Ket == null ? "" : model.Switch_Mirror_Ket);

                    if (model.Air_Conditioner.equals("B")) {
                        b_Air_Conditioner.setChecked(true);
                    } else if (model.Air_Conditioner.equals("R")) {
                        r_Air_Conditioner.setChecked(true);
                    } else if (model.Air_Conditioner.equals("T")) {
                        t_Air_Conditioner.setChecked(true);
                    }
                    te_Air_Conditioner.setText(model.Air_Conditioner_Ket == null ? "" : model.Air_Conditioner_Ket);

                    if (model.Safety_Belt.equals("B")) {
                        b_Safety_Belt.setChecked(true);
                    } else if (model.Safety_Belt.equals("R")) {
                        r_Safety_Belt.setChecked(true);
                    } else if (model.Safety_Belt.equals("T")) {
                        t_Safety_Belt.setChecked(true);
                    }
                    te_Safety_Belt.setText(model.Safety_Belt_Ket == null ? "" : model.Safety_Belt_Ket);

                    if (model.Karpet.equals("B")) {
                        b_Karpet.setChecked(true);
                    } else if (model.Karpet.equals("R")) {
                        r_Karpet.setChecked(true);
                    } else if (model.Karpet.equals("T")) {
                        t_Karpet.setChecked(true);
                    }
                    te_Karpet.setText(model.Karpet_Ket == null ? "" : model.Karpet_Ket);

                    if (model.Lighter.equals("B")) {
                        b_Lighter.setChecked(true);
                    } else if (model.Lighter.equals("R")) {
                        r_Lighter.setChecked(true);
                    } else if (model.Lighter.equals("T")) {
                        t_Lighter.setChecked(true);
                    }
                    te_Lighter.setText(model.Lighter_Ket == null ? "" : model.Lighter_Ket);

                    if (model.Asbak.equals("B")) {
                        b_Asbak.setChecked(true);
                    } else if (model.Asbak.equals("R")) {
                        r_Asbak.setChecked(true);
                    } else if (model.Asbak.equals("T")) {
                        t_Asbak.setChecked(true);
                    }
                    te_Asbak.setText(model.Asbak_Ket == null ? "" : model.Asbak_Ket);

                    if (model.Sarung_Jok.equals("B")) {
                        b_Sarung_Jok.setChecked(true);
                    } else if (model.Sarung_Jok.equals("R")) {
                        r_Sarung_Jok.setChecked(true);
                    } else if (model.Sarung_Jok.equals("T")) {
                        t_Sarung_Jok.setChecked(true);
                    }
                    te_Sarung_Jok.setText(model.Sarung_Jok_Ket == null ? "" : model.Sarung_Jok_Ket);

                    if (model.Sandaran_Kepala.equals("B")) {
                        b_Sandaran_Kepala.setChecked(true);
                    } else if (model.Sandaran_Kepala.equals("R")) {
                        r_Sandaran_Kepala.setChecked(true);
                    } else if (model.Sandaran_Kepala.equals("T")) {
                        t_Sandaran_Kepala.setChecked(true);
                    }
                    te_Sandaran_Kepala.setText(model.Sandaran_Kepala_Ket == null ? "" : model.Sandaran_Kepala_Ket);

                    if (model.Spion_Dalam.equals("B")) {
                        b_Spion_Dalam.setChecked(true);
                    } else if (model.Spion_Dalam.equals("R")) {
                        r_Spion_Dalam.setChecked(true);
                    } else if (model.Spion_Dalam.equals("T")) {
                        t_Spion_Dalam.setChecked(true);
                    }
                    te_Spion_Dalam.setText(model.Spion_Dalam_Ket == null ? "" : model.Spion_Dalam_Ket);

                    if (model.Wiper_Blade.equals("B")) {
                        b_Wiper_Blade.setChecked(true);
                    } else if (model.Wiper_Blade.equals("R")) {
                        r_Wiper_Blade.setChecked(true);
                    } else if (model.Wiper_Blade.equals("T")) {
                        t_Wiper_Blade.setChecked(true);
                    }
                    te_Wiper_Blade.setText(model.Wiper_Blade_Ket == null ? "" : model.Wiper_Blade_Ket);

                    if (model.Windshield_Washer.equals("B")) {
                        b_Windshield_Washer.setChecked(true);
                    } else if (model.Windshield_Washer.equals("R")) {
                        r_Windshield_Washer.setChecked(true);
                    } else if (model.Windshield_Washer.equals("T")) {
                        t_Windshield_Washer.setChecked(true);
                    }
                    te_Windshield_Washer.setText(model.Windshield_Washer_Ket == null ? "" : model.Windshield_Washer_Ket);

                    if (model.Talang_Air.equals("B")) {
                        b_Talang_Air.setChecked(true);
                    } else if (model.Talang_Air.equals("R")) {
                        r_Talang_Air.setChecked(true);
                    } else if (model.Talang_Air.equals("T")) {
                        t_Talang_Air.setChecked(true);
                    }
                    te_Talang_Air.setText(model.Talang_Air_Ket == null ? "" : model.Talang_Air_Ket);

                    if (model.Fender_Lumpur_Depan_dan_Belakang.equals("B")) {
                        b_Fender_Lumpur_Depan_dan_Belakang.setChecked(true);
                    } else if (model.Fender_Lumpur_Depan_dan_Belakang.equals("R")) {
                        r_Fender_Lumpur_Depan_dan_Belakang.setChecked(true);
                    } else if (model.Fender_Lumpur_Depan_dan_Belakang.equals("T")) {
                        t_Fender_Lumpur_Depan_dan_Belakang.setChecked(true);
                    }
                    te_Fender_Lumpur_Depan_dan_Belakang.setText(model.Fender_Lumpur_Depan_dan_Belakang_Ket == null ? "" : model.Fender_Lumpur_Depan_dan_Belakang_Ket);

                    if (model.Spion_Kiri_Kanan.equals("B")) {
                        b_Spion_Kiri_Kanan.setChecked(true);
                    } else if (model.Spion_Kiri_Kanan.equals("R")) {
                        r_Spion_Kiri_Kanan.setChecked(true);
                    } else if (model.Spion_Kiri_Kanan.equals("T")) {
                        t_Spion_Kiri_Kanan.setChecked(true);
                    }
                    te_Spion_Kiri_Kanan.setText(model.Spion_Kiri_Kanan_Ket == null ? "" : model.Spion_Kiri_Kanan_Ket);

                    if (model.Tutup_Bensin.equals("B")) {
                        b_Tutup_Bensin.setChecked(true);
                    } else if (model.Tutup_Bensin.equals("R")) {
                        r_Tutup_Bensin.setChecked(true);
                    } else if (model.Tutup_Bensin.equals("T")) {
                        t_Tutup_Bensin.setChecked(true);
                    }
                    te_Tutup_Bensin.setText(model.Tutup_Bensin_Ket == null ? "" : model.Tutup_Bensin_Ket);

                    if (model.Emblem_Logo.equals("B")) {
                        b_Emblem_Logo.setChecked(true);
                    } else if (model.Emblem_Logo.equals("R")) {
                        r_Emblem_Logo.setChecked(true);
                    } else if (model.Emblem_Logo.equals("T")) {
                        t_Emblem_Logo.setChecked(true);
                    }
                    te_Emblem_Logo.setText(model.Emblem_Logo_Ket == null ? "" : model.Emblem_Logo_Ket);

                    if (model.Kaca_Mobil_dan_Kaca_Film.equals("B")) {
                        b_Kaca_Mobil_dan_Kaca_Film.setChecked(true);
                    } else if (model.Kaca_Mobil_dan_Kaca_Film.equals("R")) {
                        r_Kaca_Mobil_dan_Kaca_Film.setChecked(true);
                    } else if (model.Kaca_Mobil_dan_Kaca_Film.equals("T")) {
                        t_Kaca_Mobil_dan_Kaca_Film.setChecked(true);
                    }
                    te_Kaca_Mobil_dan_Kaca_Film.setText(model.Kaca_Mobil_dan_Kaca_Film_Ket == null ? "" : model.Kaca_Mobil_dan_Kaca_Film_Ket);

                    if (model.STNK.equals("B")) {
                        b_STNK.setChecked(true);
                    } else if (model.STNK.equals("R")) {
                        r_STNK.setChecked(true);
                    } else if (model.STNK.equals("T")) {
                        t_STNK.setChecked(true);
                    }
                    te_STNK.setText(model.STNK_Ket == null ? "" : model.STNK_Ket);

                    if (model.Buku_KIR_Stiker_Peneng.equals("B")) {
                        b_Buku_KIR_Stiker_Peneng.setChecked(true);
                    } else if (model.Buku_KIR_Stiker_Peneng.equals("R")) {
                        r_Buku_KIR_Stiker_Peneng.setChecked(true);
                    } else if (model.Buku_KIR_Stiker_Peneng.equals("T")) {
                        t_Buku_KIR_Stiker_Peneng.setChecked(true);
                    }
                    te_Buku_KIR_Stiker_Peneng.setText(model.Buku_KIR_Stiker_Peneng_Ket == null ? "" : model.Buku_KIR_Stiker_Peneng_Ket);

                    if (model.Owners_Manual_Book.equals("B")) {
                        b_Owners_Manual_Book.setChecked(true);
                    } else if (model.Owners_Manual_Book.equals("R")) {
                        r_Owners_Manual_Book.setChecked(true);
                    } else if (model.Owners_Manual_Book.equals("T")) {
                        t_Owners_Manual_Book.setChecked(true);
                    }
                    te_Owners_Manual_Book.setText(model.Owners_Manual_Book_Ket == null ? "" : model.Owners_Manual_Book_Ket);

                    if (model.Buku_Service.equals("B")) {
                        b_Buku_Service.setChecked(true);
                    } else if (model.Buku_Service.equals("R")) {
                        r_Buku_Service.setChecked(true);
                    } else if (model.Buku_Service.equals("T")) {
                        t_Buku_Service.setChecked(true);
                    }
                    te_Buku_Service.setText(model.Buku_Service_Ket == null ? "" : model.Buku_Service_Ket);

                    if (model.Ban_Serep.equals("B")) {
                        b_Ban_Serep.setChecked(true);
                    } else if (model.Ban_Serep.equals("R")) {
                        r_Ban_Serep.setChecked(true);
                    } else if (model.Ban_Serep.equals("T")) {
                        t_Ban_Serep.setChecked(true);
                    }
                    te_Ban_Serep.setText(model.Ban_Serep_Ket == null ? "" : model.Ban_Serep_Ket);

                    if (model.Kunci_Roda_Busi_Pas_Tang.equals("B")) {
                        b_Kunci_Roda_Busi_Pas_Tang.setChecked(true);
                    } else if (model.Kunci_Roda_Busi_Pas_Tang.equals("R")) {
                        r_Kunci_Roda_Busi_Pas_Tang.setChecked(true);
                    } else if (model.Kunci_Roda_Busi_Pas_Tang.equals("T")) {
                        t_Kunci_Roda_Busi_Pas_Tang.setChecked(true);
                    }
                    te_Kunci_Roda_Busi_Pas_Tang.setText(model.Kunci_Roda_Busi_Pas_Tang_Ket == null ? "" : model.Kunci_Roda_Busi_Pas_Tang_Ket);

                    if (model.Kunci_Stir.equals("B")) {
                        b_Kunci_Stir.setChecked(true);
                    } else if (model.Kunci_Stir.equals("R")) {
                        r_Kunci_Stir.setChecked(true);
                    } else if (model.Kunci_Stir.equals("T")) {
                        t_Kunci_Stir.setChecked(true);
                    }
                    te_Kunci_Stir.setText(model.Kunci_Stir_Ket == null ? "" : model.Kunci_Stir_Ket);

                    if (model.Dongkrak.equals("B")) {
                        b_Dongkrak.setChecked(true);
                    } else if (model.Dongkrak.equals("R")) {
                        r_Dongkrak.setChecked(true);
                    } else if (model.Dongkrak.equals("T")) {
                        t_Dongkrak.setChecked(true);
                    }
                    te_Dongkrak.setText(model.Dongkrak_Ket == null ? "" : model.Dongkrak_Ket);

                    if (model.P3K.equals("B")) {
                        b_P3K.setChecked(true);
                    } else if (model.P3K.equals("R")) {
                        r_P3K.setChecked(true);
                    } else if (model.P3K.equals("T")) {
                        t_P3K.setChecked(true);
                    }
                    te_P3K.setText(model.P3K_Ket == null ? "" : model.P3K_Ket);

                    if (model.Segitiga_Pengaman.equals("B")) {
                        b_Segitiga_Pengaman.setChecked(true);
                    } else if (model.Segitiga_Pengaman.equals("R")) {
                        r_Segitiga_Pengaman.setChecked(true);
                    } else if (model.Segitiga_Pengaman.equals("T")) {
                        t_Segitiga_Pengaman.setChecked(true);
                    }
                    te_Segitiga_Pengaman.setText(model.Segitiga_Pengaman_Ket == null ? "" : model.Segitiga_Pengaman_Ket);

                    if (model.Lap_Kanebo.equals("B")) {
                        b_Lap_Kanebo.setChecked(true);
                    } else if (model.Lap_Kanebo.equals("R")) {
                        r_Lap_Kanebo.setChecked(true);
                    } else if (model.Lap_Kanebo.equals("T")) {
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
                        edittext_km.setText(model.km.toString());
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


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //region Get Checklist
                    if (b_Automatic_Light_Switch.isChecked()) {
                        model.Automatic_Light_Switch = "B";
                    } else if (r_Automatic_Light_Switch.isChecked()) {
                        model.Automatic_Light_Switch = "R";
                    } else if (t_Automatic_Light_Switch.isChecked()) {
                        model.Automatic_Light_Switch = "T";
                    }
                    model.Automatic_Light_Switch_Ket = te_Automatic_Light_Switch.getText().toString();

                    
                    if (b_Lampu_Kecil.isChecked()) {
                        model.Lampu_Kecil = "B";
                    } else if (r_Lampu_Kecil.isChecked()) {
                        model.Lampu_Kecil = "R";
                    } else if (t_Lampu_Kecil.isChecked()) {
                        model.Lampu_Kecil = "T";
                    }
                    model.Lampu_Kecil_Ket = te_Lampu_Kecil.getText().toString();
                    
                    if (b_Lampu_Dekat.isChecked()) {
                        model.Lampu_Dekat = "B";
                    } else if (r_Lampu_Dekat.isChecked()) {
                        model.Lampu_Dekat = "R";
                    } else if (t_Lampu_Dekat.isChecked()) {
                        model.Lampu_Dekat = "T";
                    }
                    model.Lampu_Dekat_Ket = te_Lampu_Dekat.getText().toString();

                    
                    if (b_Lampu_Jauh.isChecked()) {
                        model.Lampu_Jauh = "B";
                    } else if (r_Lampu_Jauh.isChecked()) {
                        model.Lampu_Jauh = "R";
                    } else if (t_Lampu_Jauh.isChecked()) {
                        model.Lampu_Jauh = "T";
                    }
                    model.Lampu_Jauh_Ket = te_Lampu_Jauh.getText().toString();
                    
                    if (b_Lampu_Kabut_Fog_Lamp.isChecked()) {
                        model.Lampu_Kabut_Fog_Lamp = "B";
                    } else if (r_Lampu_Kabut_Fog_Lamp.isChecked()) {
                        model.Lampu_Kabut_Fog_Lamp = "R";
                    } else if (t_Lampu_Kabut_Fog_Lamp.isChecked()) {
                        model.Lampu_Kabut_Fog_Lamp = "T";
                    }
                    model.Lampu_Kabut_Fog_Lamp_Ket = te_Lampu_Kabut_Fog_Lamp.getText().toString();

                    
                    if (b_Lampu_Sign_Depan.isChecked()) {
                        model.Lampu_Sign_Depan = "B";
                    } else if (r_Lampu_Sign_Depan.isChecked()) {
                        model.Lampu_Sign_Depan = "R";
                    } else if (t_Lampu_Sign_Depan.isChecked()) {
                        model.Lampu_Sign_Depan = "T";
                    }
                    model.Lampu_Sign_Depan_Ket = te_Lampu_Sign_Depan.getText().toString();

                    
                    if (b_Lampu_Sign_Belakang.isChecked()) {
                        model.Lampu_Sign_Belakang = "B";
                    } else if (r_Lampu_Sign_Belakang.isChecked()) {
                        model.Lampu_Sign_Belakang = "R";
                    } else if (t_Lampu_Sign_Belakang.isChecked()) {
                        model.Lampu_Sign_Belakang = "T";
                    }
                    model.Lampu_Sign_Belakang_Ket = te_Lampu_Sign_Belakang.getText().toString();
                    
                    if (b_Lampu_Belakang.isChecked()) {
                        model.Lampu_Belakang = "B";
                    } else if (r_Lampu_Belakang.isChecked()) {
                        model.Lampu_Belakang = "R";
                    } else if (t_Lampu_Belakang.isChecked()) {
                        model.Lampu_Belakang = "T";
                    }
                    model.Lampu_Belakang_Ket = te_Lampu_Belakang.getText().toString();
                    
                    if (b_Lampu_Rem.isChecked()) {
                        model.Lampu_Rem = "B";
                    } else if (r_Lampu_Rem.isChecked()) {
                        model.Lampu_Rem = "R";
                    } else if (t_Lampu_Rem.isChecked()) {
                        model.Lampu_Rem = "T";
                    }
                    model.Lampu_Rem_Ket = te_Lampu_Rem.getText().toString();
                    
                    if (b_Lampu_Mundur.isChecked()) {
                        model.Lampu_Mundur = "B";
                    } else if (r_Lampu_Mundur.isChecked()) {
                        model.Lampu_Mundur = "R";
                    } else if (t_Lampu_Mundur.isChecked()) {
                        model.Lampu_Mundur = "T";
                    }
                    model.Lampu_Mundur_Ket = te_Lampu_Mundur.getText().toString();
                    
                    if (b_Lampu_Dashboard.isChecked()) {
                        model.Lampu_Dashboard = "B";
                    } else if (r_Lampu_Dashboard.isChecked()) {
                        model.Lampu_Dashboard = "R";
                    } else if (t_Lampu_Dashboard.isChecked()) {
                        model.Lampu_Dashboard = "T";
                    }
                    model.Lampu_Dashboard_Ket = te_Lampu_Dashboard.getText().toString();
                    
                    if (b_Lampu_Plafond_Depan_dan_Belakang.isChecked()) {
                        model.Lampu_Plafond_Depan_dan_Belakang = "B";
                    } else if (r_Lampu_Plafond_Depan_dan_Belakang.isChecked()) {
                        model.Lampu_Plafond_Depan_dan_Belakang = "R";
                    } else if (t_Lampu_Plafond_Depan_dan_Belakang.isChecked()) {
                        model.Lampu_Plafond_Depan_dan_Belakang = "T";
                    }
                    model.Lampu_Plafond_Depan_dan_Belakang_Ket = te_Lampu_Plafond_Depan_dan_Belakang.getText().toString();
                    
                    if (b_Klakson.isChecked()) {
                        model.Klakson = "B";
                    } else if (r_Klakson.isChecked()) {
                        model.Klakson = "R";
                    } else if (t_Klakson.isChecked()) {
                        model.Klakson = "T";
                    }
                    model.Klakson_Ket = te_Klakson.getText().toString();
                    
                    if (b_Antena.isChecked()) {
                        model.Antena = "B";
                    } else if (r_Antena.isChecked()) {
                        model.Antena = "R";
                    } else if (t_Antena.isChecked()) {
                        model.Antena = "T";
                    }
                    model.Antena_Ket = te_Antena.getText().toString();
                    
                    if (b_Tape_Radio_CD_DVD_TV_Player.isChecked()) {
                        model.Tape_Radio_CD_DVD_TV_Player = "B";
                    } else if (r_Tape_Radio_CD_DVD_TV_Player.isChecked()) {
                        model.Tape_Radio_CD_DVD_TV_Player = "R";
                    } else if (t_Tape_Radio_CD_DVD_TV_Player.isChecked()) {
                        model.Tape_Radio_CD_DVD_TV_Player = "T";
                    }
                    model.Tape_Radio_CD_DVD_TV_Player_Ket = te_Tape_Radio_CD_DVD_TV_Player.getText().toString();
                    
                    if (b_Remote_Tape_Radio_CD_DVD_TV_Player.isChecked()) {
                        model.Remote_Tape_Radio_CD_DVD_TV_Player = "B";
                    } else if (r_Remote_Tape_Radio_CD_DVD_TV_Player.isChecked()) {
                        model.Remote_Tape_Radio_CD_DVD_TV_Player = "R";
                    } else if (t_Remote_Tape_Radio_CD_DVD_TV_Player.isChecked()) {
                        model.Remote_Tape_Radio_CD_DVD_TV_Player = "T";
                    }
                    model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket = te_Remote_Tape_Radio_CD_DVD_TV_Player.getText().toString();
                    
                    if (b_Alarm_Remote_Key.isChecked()) {
                        model.Alarm_Remote_Key = "B";
                    } else if (r_Alarm_Remote_Key.isChecked()) {
                        model.Alarm_Remote_Key = "R";
                    } else if (t_Alarm_Remote_Key.isChecked()) {
                        model.Alarm_Remote_Key = "T";
                    }
                    model.Alarm_Remote_Key_Ket = te_Alarm_Remote_Key.getText().toString();
                    
                    if (b_Central_Lock.isChecked()) {
                        model.Central_Lock = "B";
                    } else if (r_Central_Lock.isChecked()) {
                        model.Central_Lock = "R";
                    } else if (t_Central_Lock.isChecked()) {
                        model.Central_Lock = "T";
                    }
                    model.Central_Lock_Ket = te_Central_Lock.getText().toString();
                    
                    if (b_Power_Window.isChecked()) {
                        model.Power_Window = "B";
                    } else if (r_Power_Window.isChecked()) {
                        model.Power_Window = "R";
                    } else if (t_Power_Window.isChecked()) {
                        model.Power_Window = "T";
                    }
                    model.Power_Window_Ket = te_Power_Window.getText().toString();

                    if (b_Switch_Mirror.isChecked()) {
                        model.Switch_Mirror = "B";
                    } else if (r_Switch_Mirror.isChecked()) {
                        model.Switch_Mirror = "R";
                    } else if (t_Switch_Mirror.isChecked()) {
                        model.Switch_Mirror = "T";
                    }
                    model.Switch_Mirror_Ket = te_Switch_Mirror.getText().toString();
                    
                    if (b_Air_Conditioner.isChecked()) {
                        model.Air_Conditioner = "B";
                    } else if (r_Air_Conditioner.isChecked()) {
                        model.Air_Conditioner = "R";
                    } else if (t_Air_Conditioner.isChecked()) {
                        model.Air_Conditioner = "T";
                    }
                    model.Air_Conditioner_Ket = te_Air_Conditioner.getText().toString();
                    
                    if (b_Safety_Belt.isChecked()) {
                        model.Safety_Belt = "B";
                    } else if (r_Safety_Belt.isChecked()) {
                        model.Safety_Belt = "R";
                    } else if (t_Safety_Belt.isChecked()) {
                        model.Safety_Belt = "T";
                    }
                    model.Safety_Belt_Ket = te_Safety_Belt.getText().toString();
                    
                    if (b_Karpet.isChecked()) {
                        model.Karpet = "B";
                    } else if (r_Karpet.isChecked()) {
                        model.Karpet = "R";
                    } else if (t_Karpet.isChecked()) {
                        model.Karpet = "T";
                    }
                    model.Karpet_Ket = te_Karpet.getText().toString();
                    
                    if (b_Lighter.isChecked()) {
                        model.Lighter = "B";
                    } else if (r_Lighter.isChecked()) {
                        model.Lighter = "R";
                    } else if (t_Lighter.isChecked()) {
                        model.Lighter = "T";
                    }
                    model.Lighter_Ket = te_Lighter.getText().toString();
                    
                    if (b_Asbak.isChecked()) {
                        model.Asbak = "B";
                    } else if (r_Asbak.isChecked()) {
                        model.Asbak = "R";
                    } else if (t_Asbak.isChecked()) {
                        model.Asbak = "T";
                    }
                    model.Asbak_Ket = te_Asbak.getText().toString();
                    
                    if (b_Sarung_Jok.isChecked()) {
                        model.Sarung_Jok = "B";
                    } else if (r_Sarung_Jok.isChecked()) {
                        model.Sarung_Jok = "R";
                    } else if (t_Sarung_Jok.isChecked()) {
                        model.Sarung_Jok = "T";
                    }
                    model.Sarung_Jok_Ket = te_Sarung_Jok.getText().toString();
                    
                    if (b_Sandaran_Kepala.isChecked()) {
                        model.Sandaran_Kepala = "B";
                    } else if (r_Sandaran_Kepala.isChecked()) {
                        model.Sandaran_Kepala = "R";
                    } else if (t_Sandaran_Kepala.isChecked()) {
                        model.Sandaran_Kepala = "T";
                    }
                    model.Sandaran_Kepala_Ket = te_Sandaran_Kepala.getText().toString();
                    
                    if (b_Spion_Dalam.isChecked()) {
                        model.Spion_Dalam = "B";
                    } else if (r_Spion_Dalam.isChecked()) {
                        model.Spion_Dalam = "R";
                    } else if (t_Spion_Dalam.isChecked()) {
                        model.Spion_Dalam = "T";
                    }
                    model.Spion_Dalam_Ket = te_Spion_Dalam.getText().toString();
                    
                    if (b_Wiper_Blade.isChecked()) {
                        model.Wiper_Blade = "B";
                    } else if (r_Wiper_Blade.isChecked()) {
                        model.Wiper_Blade = "R";
                    } else if (t_Wiper_Blade.isChecked()) {
                        model.Wiper_Blade = "T";
                    }
                    model.Wiper_Blade_Ket = te_Wiper_Blade.getText().toString();
                    
                    if (b_Windshield_Washer.isChecked()) {
                        model.Windshield_Washer = "B";
                    } else if (r_Windshield_Washer.isChecked()) {
                        model.Windshield_Washer = "R";
                    } else if (t_Windshield_Washer.isChecked()) {
                        model.Windshield_Washer = "T";
                    }
                    model.Windshield_Washer_Ket = te_Windshield_Washer.getText().toString();
                    
                    if (b_Talang_Air.isChecked()) {
                        model.Talang_Air = "B";
                    } else if (r_Talang_Air.isChecked()) {
                        model.Talang_Air = "R";
                    } else if (t_Talang_Air.isChecked()) {
                        model.Talang_Air = "T";
                    }
                    model.Talang_Air_Ket = te_Talang_Air.getText().toString();
                    
                    if (b_Fender_Lumpur_Depan_dan_Belakang.isChecked()) {
                        model.Fender_Lumpur_Depan_dan_Belakang = "B";
                    } else if (r_Fender_Lumpur_Depan_dan_Belakang.isChecked()) {
                        model.Fender_Lumpur_Depan_dan_Belakang = "R";
                    } else if (t_Fender_Lumpur_Depan_dan_Belakang.isChecked()) {
                        model.Fender_Lumpur_Depan_dan_Belakang = "T";
                    }
                    model.Fender_Lumpur_Depan_dan_Belakang_Ket = te_Fender_Lumpur_Depan_dan_Belakang.getText().toString();
                    
                    if (b_Spion_Kiri_Kanan.isChecked()) {
                        model.Spion_Kiri_Kanan = "B";
                    } else if (r_Spion_Kiri_Kanan.isChecked()) {
                        model.Spion_Kiri_Kanan = "R";
                    } else if (t_Spion_Kiri_Kanan.isChecked()) {
                        model.Spion_Kiri_Kanan = "T";
                    }
                    model.Spion_Kiri_Kanan_Ket = te_Spion_Kiri_Kanan.getText().toString();
                    
                    if (b_Tutup_Bensin.isChecked()) {
                        model.Tutup_Bensin = "B";
                    } else if (r_Tutup_Bensin.isChecked()) {
                        model.Tutup_Bensin = "R";
                    } else if (t_Tutup_Bensin.isChecked()) {
                        model.Tutup_Bensin = "T";
                    }
                    model.Tutup_Bensin_Ket = te_Tutup_Bensin.getText().toString();
                    
                    if (b_Emblem_Logo.isChecked()) {
                        model.Emblem_Logo = "B";
                    } else if (r_Emblem_Logo.isChecked()) {
                        model.Emblem_Logo = "R";
                    } else if (t_Emblem_Logo.isChecked()) {
                        model.Emblem_Logo = "T";
                    }
                    model.Emblem_Logo_Ket = te_Emblem_Logo.getText().toString();

                    if (b_Kaca_Mobil_dan_Kaca_Film.isChecked()) {
                        model.Kaca_Mobil_dan_Kaca_Film = "B";
                    } else if (r_Kaca_Mobil_dan_Kaca_Film.isChecked()) {
                        model.Kaca_Mobil_dan_Kaca_Film = "R";
                    } else if (t_Kaca_Mobil_dan_Kaca_Film.isChecked()) {
                        model.Kaca_Mobil_dan_Kaca_Film = "T";
                    }
                    model.Kaca_Mobil_dan_Kaca_Film_Ket = te_Kaca_Mobil_dan_Kaca_Film.getText().toString();
                    
                    if (b_STNK.isChecked()) {
                        model.STNK = "B";
                    } else if (r_STNK.isChecked()) {
                        model.STNK = "R";
                    } else if (t_STNK.isChecked()) {
                        model.STNK = "T";
                    }
                    model.STNK_Ket = te_STNK.getText().toString();
                    
                    if (b_Buku_KIR_Stiker_Peneng.isChecked()) {
                        model.Buku_KIR_Stiker_Peneng = "B";
                    } else if (r_Buku_KIR_Stiker_Peneng.isChecked()) {
                        model.Buku_KIR_Stiker_Peneng = "R";
                    } else if (t_Buku_KIR_Stiker_Peneng.isChecked()) {
                        model.Buku_KIR_Stiker_Peneng = "T";
                    }
                    model.Buku_KIR_Stiker_Peneng_Ket = te_Buku_KIR_Stiker_Peneng.getText().toString();
                    
                    if (b_Owners_Manual_Book.isChecked()) {
                        model.Owners_Manual_Book = "B";
                    } else if (r_Owners_Manual_Book.isChecked()) {
                        model.Owners_Manual_Book = "R";
                    } else if (t_Owners_Manual_Book.isChecked()) {
                        model.Owners_Manual_Book = "T";
                    }
                    model.Owners_Manual_Book_Ket = te_Owners_Manual_Book.getText().toString();

                    if (b_Buku_Service.isChecked()) {
                        model.Buku_Service = "B";
                    } else if (r_Buku_Service.isChecked()) {
                        model.Buku_Service = "R";
                    } else if (t_Buku_Service.isChecked()) {
                        model.Buku_Service = "T";
                    }
                    model.Buku_Service_Ket = te_Buku_Service.getText().toString();
                    
                    if (b_Ban_Serep.isChecked()) {
                        model.Ban_Serep = "B";
                    } else if (r_Ban_Serep.isChecked()) {
                        model.Ban_Serep = "R";
                    } else if (t_Ban_Serep.isChecked()) {
                        model.Ban_Serep = "T";
                    }
                    model.Ban_Serep_Ket = te_Ban_Serep.getText().toString();

                    if (b_Kunci_Roda_Busi_Pas_Tang.isChecked()) {
                        model.Kunci_Roda_Busi_Pas_Tang = "B";
                    } else if (r_Kunci_Roda_Busi_Pas_Tang.isChecked()) {
                        model.Kunci_Roda_Busi_Pas_Tang = "R";
                    } else if (t_Kunci_Roda_Busi_Pas_Tang.isChecked()) {
                        model.Kunci_Roda_Busi_Pas_Tang = "T";
                    }
                    model.Kunci_Roda_Busi_Pas_Tang_Ket = te_Kunci_Roda_Busi_Pas_Tang.getText().toString();
                    
                    if (b_Kunci_Stir.isChecked()) {
                        model.Kunci_Stir = "B";
                    } else if (r_Kunci_Stir.isChecked()) {
                        model.Kunci_Stir = "R";
                    } else if (t_Kunci_Stir.isChecked()) {
                        model.Kunci_Stir = "T";
                    }
                    model.Kunci_Stir_Ket = te_Kunci_Stir.getText().toString();
                    
                    if (b_Dongkrak.isChecked()) {
                        model.Dongkrak = "B";
                    } else if (r_Dongkrak.isChecked()) {
                        model.Dongkrak = "R";
                    } else if (t_Dongkrak.isChecked()) {
                        model.Dongkrak = "T";
                    }
                    model.Dongkrak_Ket = te_Dongkrak.getText().toString();

                    if (b_P3K.isChecked()) {
                        model.P3K = "B";
                    } else if (r_P3K.isChecked()) {
                        model.P3K = "R";
                    } else if (t_P3K.isChecked()) {
                        model.P3K = "T";
                    }
                    model.P3K_Ket = te_P3K.getText().toString();
                    
                    if (b_Segitiga_Pengaman.isChecked()) {
                        model.Segitiga_Pengaman = "B";
                    } else if (r_Segitiga_Pengaman.isChecked()) {
                        model.Segitiga_Pengaman = "R";
                    } else if (t_Segitiga_Pengaman.isChecked()) {
                        model.Segitiga_Pengaman = "T";
                    }
                    model.Segitiga_Pengaman_Ket = te_Segitiga_Pengaman.getText().toString();

                    if (b_Lap_Kanebo.isChecked()) {
                        model.Lap_Kanebo = "B";
                    } else if (r_Lap_Kanebo.isChecked()) {
                        model.Lap_Kanebo = "R";
                    } else if (t_Lap_Kanebo.isChecked()) {
                        model.Lap_Kanebo = "T";
                    }
                    model.Lap_Kanebo_Ket = te_Lap_Kanebo.getText().toString();

                    //endregion

                    //region get Appar dll
                    model.apar = spinner_appar.getSelectedItem().toString();
                    model.fuel = spinner_fuel.getSelectedItem().toString();
                    model.velg_ban = spinner_velg_ban.getSelectedItem().toString();
                    model.tutup_dop = spinner_tutup_dop.getSelectedItem().toString();
                    if (edittext_km.getText().toString() == ""){
                        model.km = Integer.parseInt(edittext_km.getText().toString());
                    }
                    model.isi_tangki_ket = text_seekbar.getText().toString();
                    model.isi_tangki = seekbar_bensin.getProgress();
                    //endregion

                    //region Camera and Signer
                    model.signature = txtsignatureName.getText().toString();
                    //endregion


                    //region Save Data
                    apiservice = ApiClient.getClient().create(ApiInterface.class);
                    Globals g = (Globals)getActivity().getApplication();
                    model.CreatedBy = g.getUser_ID();
                    apiservice.EditBSTKBefore(model.Nama_Customer,model.Nomor_Plat_Kendaraan,model.Automatic_Light_Switch, model.Automatic_Light_Switch_Ket,model.Lampu_Kecil,
                            model.Lampu_Kecil_Ket, model.Lampu_Dekat, model.Lampu_Dekat_Ket,model.Lampu_Jauh, model.Lampu_Jauh_Ket, model.Lampu_Kabut_Fog_Lamp,
                            model.Lampu_Kabut_Fog_Lamp_Ket, model.Lampu_Sign_Depan,model.Lampu_Sign_Depan_Ket,model.Lampu_Sign_Belakang,model.Lampu_Sign_Belakang_Ket,
                            model.Lampu_Belakang,model.Lampu_Belakang_Ket,model.Lampu_Rem,model.Lampu_Rem_Ket,model.Lampu_Mundur,model.Lampu_Mundur_Ket,
                            model.Lampu_Dashboard,model.Lampu_Dashboard_Ket,model.Lampu_Plafond_Depan_dan_Belakang,model.Lampu_Plafond_Depan_dan_Belakang_Ket,
                            model.Klakson,model.Klakson_Ket,model.Antena,model.Antena_Ket,model.Tape_Radio_CD_DVD_TV_Player,model.Tape_Radio_CD_DVD_TV_Player_Ket,
                            model.Remote_Tape_Radio_CD_DVD_TV_Player,model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket,model.Alarm_Remote_Key,model.Alarm_Remote_Key_Ket,
                            model.Central_Lock,model.Central_Lock_Ket,model.Power_Window,model.Power_Window_Ket,model.Switch_Mirror,model.Switch_Mirror_Ket,
                            model.Air_Conditioner,model.Air_Conditioner_Ket,model.Safety_Belt,model.Safety_Belt_Ket,model.Karpet,model.Karpet_Ket,model.Lighter,
                            model.Lighter_Ket,model.Asbak,model.Asbak_Ket,model.Sarung_Jok,model.Sarung_Jok_Ket,model.Sandaran_Kepala,model.Sandaran_Kepala_Ket,
                            model.Spion_Dalam,model.Spion_Dalam_Ket,model.Wiper_Blade,model.Wiper_Blade_Ket,model.Windshield_Washer,model.Windshield_Washer_Ket,
                            model.Talang_Air,model.Talang_Air_Ket,model.Fender_Lumpur_Depan_dan_Belakang,model.Fender_Lumpur_Depan_dan_Belakang_Ket,model.Spion_Kiri_Kanan,
                            model.Spion_Kiri_Kanan_Ket,model.Tutup_Bensin,model.Tutup_Bensin_Ket,model.Emblem_Logo,model.Emblem_Logo_Ket,model.Kaca_Mobil_dan_Kaca_Film,
                            model.Kaca_Mobil_dan_Kaca_Film_Ket,model.STNK,model.STNK_Ket,model.Buku_KIR_Stiker_Peneng,model.Buku_KIR_Stiker_Peneng_Ket,model.Owners_Manual_Book,
                            model.Owners_Manual_Book_Ket,model.Buku_Service,model.Buku_Service_Ket,model.Ban_Serep,model.Ban_Serep_Ket,model.Kunci_Roda_Busi_Pas_Tang,
                            model.Kunci_Roda_Busi_Pas_Tang_Ket,model.Kunci_Stir,model.Kunci_Stir_Ket,model.Dongkrak,model.Dongkrak_Ket,model.P3K,model.P3K_Ket,model.Segitiga_Pengaman,
                            model.Segitiga_Pengaman_Ket,model.Lap_Kanebo,model.Lap_Kanebo_Ket,model.Foto_Kendaraan_Tampak_Depan,
                            model.Foto_Kendaraan_Tampak_Belakang,model.Foto_Kendaraan_Tampak_Samping_Kanan,model.Foto_Kendaraan_Tampak_Samping_Kiri,model.apar,model.fuel,
                            model.isi_tangki,model.isi_tangki_ket,model.km,model.velg_ban,model.tutup_dop,model.signature,model.signature_image,model.CreatedBy, true,BSTKBefore_ID
                    ).enqueue(new Callback<ResponLogin>() {
                        @Override
                        public void onResponse(Call<ResponLogin> call, Response<ResponLogin> response) {

                            String stat = response.body().getStatus();
                            if (stat.equals("Success")) {
//                                Intent intent = new Intent(context, MenuUtama.class);
//                                startActivity(intent);
                                Toast.makeText(context, stat, Toast.LENGTH_SHORT).show();
                                back_toView();
                            } else if (stat.equals("Error")) {
                                Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponLogin> call, Throwable t) {
                            //Toast.makeText(MainActivity.this,"Gagal Terhubung ke server", Toast.LENGTH_SHORT).show();
                            Toast.makeText(context,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                    //endregion

                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        });
        btnKameraBelakang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });
        btnKameraDepan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 2);
            }
        });
        btnKameraKanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 3);
            }
        });
        btnKameraKiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 4);
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_toView();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                Bitmap bmp2 = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                bmp2.compress(Bitmap.CompressFormat.PNG, 100, stream2);
                byte[] byteArray2 = stream2.toByteArray();
                Bitmap bitmap2 = BitmapFactory.decodeByteArray(byteArray2, 0,
                        byteArray2.length);
                model.Foto_Kendaraan_Tampak_Belakang = Base64.encodeToString(byteArray2, Base64.DEFAULT);
                imageViewBelakang.setImageBitmap(bitmap2);
            }
        }else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                Bitmap bmp2 = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                bmp2.compress(Bitmap.CompressFormat.PNG, 100, stream2);
                byte[] byteArray2 = stream2.toByteArray();
                Bitmap bitmap2 = BitmapFactory.decodeByteArray(byteArray2, 0,
                        byteArray2.length);
                model.Foto_Kendaraan_Tampak_Depan = Base64.encodeToString(byteArray2, Base64.DEFAULT);
                imageViewDepan.setImageBitmap(bitmap2);
            }
        }else if (requestCode == 3) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                Bitmap bmp2 = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                bmp2.compress(Bitmap.CompressFormat.PNG, 100, stream2);
                byte[] byteArray2 = stream2.toByteArray();
                Bitmap bitmap2 = BitmapFactory.decodeByteArray(byteArray2, 0,
                        byteArray2.length);
                model.Foto_Kendaraan_Tampak_Samping_Kanan = Base64.encodeToString(byteArray2, Base64.DEFAULT);
                imageViewKanan.setImageBitmap(bitmap2);
            }
        }else if (requestCode == 4) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                Bitmap bmp2 = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                bmp2.compress(Bitmap.CompressFormat.PNG, 100, stream2);
                byte[] byteArray2 = stream2.toByteArray();
                Bitmap bitmap2 = BitmapFactory.decodeByteArray(byteArray2, 0,
                        byteArray2.length);
                model.Foto_Kendaraan_Tampak_Samping_Kiri = Base64.encodeToString(byteArray2, Base64.DEFAULT);
                imageViewKiri.setImageBitmap(bitmap2);
            }
        }
    }

    private void back_toView() {
        Fragment_View fragment = new Fragment_View();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
