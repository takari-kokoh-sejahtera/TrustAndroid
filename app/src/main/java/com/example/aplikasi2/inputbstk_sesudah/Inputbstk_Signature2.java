package com.example.aplikasi2.inputbstk_sesudah;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasi2.Model.Globals;
import com.example.aplikasi2.R;
import com.example.aplikasi2.homebstk.Fragment_Home;
import com.example.aplikasi2.homebstk.MenuUtama;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Ttd;
import com.example.aplikasi2.inputbstk_sebelum.Model;
import com.example.aplikasi2.loginbstk.ApiClient;
import com.example.aplikasi2.loginbstk.ApiInterface;
import com.example.aplikasi2.loginbstk.ResponLogin;
import com.example.aplikasi2.viewbstk.Fragment_View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inputbstk_Signature2 extends Fragment {
    public Modelbstk model = new Modelbstk();
    ApiInterface apiservice;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputbstk__signature2, container, false);
        context = getActivity();
        ImageView image_signature = (ImageView) view.findViewById(R.id.image_signature);
        TextView text_ttd = (TextView) view.findViewById(R.id.text_ttd);
        Button button_save =(Button) view.findViewById(R.id.button_save);
        Button button_back = (Button) view.findViewById(R.id.button_back);

        byte [] byteArray3 = Base64.decode(model.signature_image.getBytes(), Base64.DEFAULT);
        Bitmap bitmap3 = BitmapFactory.
                decodeByteArray(byteArray3, 0, byteArray3.length);
        image_signature.setImageBitmap(bitmap3);

        text_ttd.setText(model.signature);
        model.signature = text_ttd.getText().toString();

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_toHome();
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                back_fragment();
            }
        });

        return view;
    }
    private void back_toHome(){
        apiservice = ApiClient.getClient().create(ApiInterface.class);

        Globals g = (Globals)getActivity().getApplication();
        model.CreatedBy = g.getUser_ID();
        apiservice.SaveBSTKAfter(model.Nomor_Plat_Kendaraan,model.Automatic_Light_Switch, model.Automatic_Light_Switch_Ket,model.Lampu_Kecil,
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
                model.isi_tangki,model.isi_tangki_ket,model.km,model.velg_ban,model.tutup_dop,model.signature,model.signature_image,model.CreatedBy
        ).enqueue(new Callback<ResponLogin>() {
            @Override
            public void onResponse(Call<ResponLogin> call, Response<ResponLogin> response) {

                String stat = response.body().getStatus();
                if (stat.equals("Success")) {
                    Intent intent = new Intent(context, MenuUtama.class);
                    startActivity(intent);
                    Toast.makeText(context, stat, Toast.LENGTH_SHORT).show();

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
        Fragment_Home fragment = new Fragment_Home();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_fragment(){
        Inputbstk_Signature fragment = new Inputbstk_Signature();
        fragment. model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
