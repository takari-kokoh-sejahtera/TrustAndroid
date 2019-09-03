package com.example.aplikasi2.loginbstk;

import com.example.aplikasi2.Model.BSTKView;
import com.example.aplikasi2.Model.Ms_Customers;
import com.example.aplikasi2.Model.Ms_Vehicles;
import com.example.aplikasi2.Model.Ts_BSTKBefores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("users")
    Call<ResponLogin> MainRequest(
            @Field("User_Name") String User_Name,
            @Field("Password") String Password
    );


    @FormUrlEncoded
    @POST("BSTKBefore")
    Call<ResponLogin> SaveBSTKBefore(
            @Field("Nama_Customer") String Nama_Customer,
            @Field("Nomor_Plat_Kendaraan") String Nomor_Plat_Kendaraan,
            @Field("Automatic_Light_Switch") String Automatic_Light_Switch,
            @Field("Automatic_Light_Switch_Ket") String Automatic_Light_Switch_Ket,
            @Field("Lampu_Kecil") String Lampu_Kecil,
            @Field("Lampu_Kecil_Ket") String Lampu_Kecil_Ket,
            @Field("Lampu_Dekat") String Lampu_Dekat,
            @Field("Lampu_Dekat_Ket") String Lampu_Dekat_Ket,
            @Field("Lampu_Jauh") String Lampu_Jauh,
            @Field("Lampu_Jauh_Ket") String Lampu_Jauh_Ket,
            @Field("Lampu_Kabut_Fog_Lamp") String Lampu_Kabut_Fog_Lamp,
            @Field("Lampu_Kabut_Fog_Lamp_Ket") String Lampu_Kabut_Fog_Lamp_Ket,
            @Field("Lampu_Sign_Depan") String Lampu_Sign_Depan,
            @Field("Lampu_Sign_Depan_Ket") String Lampu_Sign_Depan_Ket,
            @Field("Lampu_Sign_Belakang") String Lampu_Sign_Belakang,
            @Field("Lampu_Sign_Belakang_Ket") String Lampu_Sign_Belakang_Ket,
            @Field("Lampu_Belakang") String Lampu_Belakang,
            @Field("Lampu_Belakang_Ket") String Lampu_Belakang_Ket,
            @Field("Lampu_Rem") String Lampu_Rem,
            @Field("Lampu_Rem_Ket") String Lampu_Rem_Ket,
            @Field("Lampu_Mundur") String Lampu_Mundur,
            @Field("Lampu_Mundur_Ket") String Lampu_Mundur_Ket,
            @Field("Lampu_Dashboard") String Lampu_Dashboard,
            @Field("Lampu_Dashboard_Ket") String Lampu_Dashboard_Ket,
            @Field("Lampu_Plafond_Depan_dan_Belakang") String Lampu_Plafond_Depan_dan_Belakang,
            @Field("Lampu_Plafond_Depan_dan_Belakang_Ket") String Lampu_Plafond_Depan_dan_Belakang_Ket,
            @Field("Klakson") String Klakson,
            @Field("Klakson_Ket") String Klakson_Ket,
            @Field("Antena") String Antena,
            @Field("Antena_Ket") String Antena_Ket,
            @Field("Tape_Radio_CD_DVD_TV_Player") String Tape_Radio_CD_DVD_TV_Player,
            @Field("Tape_Radio_CD_DVD_TV_Player_Ket") String Tape_Radio_CD_DVD_TV_Player_Ket,
            @Field("Remote_Tape_Radio_CD_DVD_TV_Player") String Remote_Tape_Radio_CD_DVD_TV_Player,
            @Field("Remote_Tape_Radio_CD_DVD_TV_Player_Ket") String Remote_Tape_Radio_CD_DVD_TV_Player_Ket,
            @Field("Alarm_Remote_Key") String Alarm_Remote_Key,
            @Field("Alarm_Remote_Key_Ket") String Alarm_Remote_Key_Ket,
            @Field("Central_Lock") String Central_Lock,
            @Field("Central_Lock_Ket") String Central_Lock_Ket,
            @Field("Power_Window") String Power_Window,
            @Field("Power_Window_Ket") String Power_Window_Ket,
            @Field("Switch_Mirror") String Switch_Mirror,
            @Field("Switch_Mirror_Ket") String Switch_Mirror_Ket,
            @Field("Air_Conditioner") String Air_Conditioner,
            @Field("Air_Conditioner_Ket") String Air_Conditioner_Ket,
            @Field("Safety_Belt") String Safety_Belt,
            @Field("Safety_Belt_Ket") String Safety_Belt_Ket,
            @Field("Karpet") String Karpet,
            @Field("Karpet_Ket") String Karpet_Ket,
            @Field("Lighter") String Lighter,
            @Field("Lighter_Ket") String Lighter_Ket,
            @Field("Asbak") String Asbak,
            @Field("Asbak_Ket") String Asbak_Ket,
            @Field("Sarung_Jok") String Sarung_Jok,
            @Field("Sarung_Jok_Ket") String Sarung_Jok_Ket,
            @Field("Sandaran_Kepala") String Sandaran_Kepala,
            @Field("Sandaran_Kepala_Ket") String Sandaran_Kepala_Ket,
            @Field("Spion_Dalam") String Spion_Dalam,
            @Field("Spion_Dalam_Ket") String Spion_Dalam_Ket,
            @Field("Wiper_Blade") String Wiper_Blade,
            @Field("Wiper_Blade_Ket") String Wiper_Blade_Ket,
            @Field("Windshield_Washer") String Windshield_Washer,
            @Field("Windshield_Washer_Ket") String Windshield_Washer_Ket,
            @Field("Talang_Air") String Talang_Air,
            @Field("Talang_Air_Ket") String Talang_Air_Ket,
            @Field("Fender_Lumpur_Depan_dan_Belakang") String Fender_Lumpur_Depan_dan_Belakang,
            @Field("Fender_Lumpur_Depan_dan_Belakang_Ket") String Fender_Lumpur_Depan_dan_Belakang_Ket,
            @Field("Spion_Kiri_Kanan") String Spion_Kiri_Kanan,
            @Field("Spion_Kiri_Kanan_Ket") String Spion_Kiri_Kanan_Ket,
            @Field("Tutup_Bensin") String Tutup_Bensin,
            @Field("Tutup_Bensin_Ket") String Tutup_Bensin_Ket,
            @Field("Emblem_Logo") String Emblem_Logo,
            @Field("Emblem_Logo_Ket") String Emblem_Logo_Ket,
            @Field("Kaca_Mobil_dan_Kaca_Film") String Kaca_Mobil_dan_Kaca_Film,
            @Field("Kaca_Mobil_dan_Kaca_Film_Ket") String Kaca_Mobil_dan_Kaca_Film_Ket,
            @Field("STNK") String STNK,
            @Field("STNK_Ket") String STNK_Ket,
            @Field("Buku_KIR_Stiker_Peneng") String Buku_KIR_Stiker_Peneng,
            @Field("Buku_KIR_Stiker_Peneng_Ket") String Buku_KIR_Stiker_Peneng_Ket,
            @Field("Owners_Manual_Book") String Owners_Manual_Book,
            @Field("Owners_Manual_Book_Ket") String Owners_Manual_Book_Ket,
            @Field("Buku_Service") String Buku_Service,
            @Field("Buku_Service_Ket") String Buku_Service_Ket,
            @Field("Ban_Serep") String Ban_Serep,
            @Field("Ban_Serep_Ket") String Ban_Serep_Ket,
            @Field("Kunci_Roda_Busi_Pas_Tang") String Kunci_Roda_Busi_Pas_Tang,
            @Field("Kunci_Roda_Busi_Pas_Tang_Ket") String Kunci_Roda_Busi_Pas_Tang_Ket,
            @Field("Kunci_Stir") String Kunci_Stir,
            @Field("Kunci_Stir_Ket") String Kunci_Stir_Ket,
            @Field("Dongkrak") String Dongkrak,
            @Field("Dongkrak_Ket") String Dongkrak_Ket,
            @Field("P3K") String P3K,
            @Field("P3K_Ket") String P3K_Ket,
            @Field("Segitiga_Pengaman") String Segitiga_Pengaman,
            @Field("Segitiga_Pengaman_Ket") String Segitiga_Pengaman_Ket,
            @Field("Lap_Kanebo") String Lap_Kanebo,
            @Field("Lap_Kanebo_Ket") String Lap_Kanebo_Ket,
            @Field("Foto_Kendaraan_Tampak_Depan") String Foto_Kendaraan_Tampak_Depan,
            @Field("Foto_Kendaraan_Tampak_Belakang") String Foto_Kendaraan_Tampak_Belakang,
            @Field("Foto_Kendaraan_Tampak_Samping_Kanan") String Foto_Kendaraan_Tampak_Samping_Kanan,
            @Field("Foto_Kendaraan_Tampak_Samping_Kiri") String Foto_Kendaraan_Tampak_Samping_Kiri,
            @Field("apar") String apar,
            @Field("fuel") String fuel,
            @Field("isi_tangki") Integer isi_tangki,
            @Field("isi_tangki_ket") String isi_tangki_ket,
            @Field("km") Integer km,
            @Field("velg_ban") String velg_ban,
            @Field("tutup_dop") String tutup_dop,
            @Field("signature") String signature,
            @Field("signature_image") String signature_image,
            @Field("CreatedBy") Integer CreatedBy
    );


    @FormUrlEncoded
    @POST("BSTKAfter")
    Call<ResponLogin> SaveBSTKAfter(
            @Field("Nomor_Plat_Kendaraan") String Nomor_Plat_Kendaraan,
            @Field("Automatic_Light_Switch") String Automatic_Light_Switch,
            @Field("Automatic_Light_Switch_Ket") String Automatic_Light_Switch_Ket,
            @Field("Lampu_Kecil") String Lampu_Kecil,
            @Field("Lampu_Kecil_Ket") String Lampu_Kecil_Ket,
            @Field("Lampu_Dekat") String Lampu_Dekat,
            @Field("Lampu_Dekat_Ket") String Lampu_Dekat_Ket,
            @Field("Lampu_Jauh") String Lampu_Jauh,
            @Field("Lampu_Jauh_Ket") String Lampu_Jauh_Ket,
            @Field("Lampu_Kabut_Fog_Lamp") String Lampu_Kabut_Fog_Lamp,
            @Field("Lampu_Kabut_Fog_Lamp_Ket") String Lampu_Kabut_Fog_Lamp_Ket,
            @Field("Lampu_Sign_Depan") String Lampu_Sign_Depan,
            @Field("Lampu_Sign_Depan_Ket") String Lampu_Sign_Depan_Ket,
            @Field("Lampu_Sign_Belakang") String Lampu_Sign_Belakang,
            @Field("Lampu_Sign_Belakang_Ket") String Lampu_Sign_Belakang_Ket,
            @Field("Lampu_Belakang") String Lampu_Belakang,
            @Field("Lampu_Belakang_Ket") String Lampu_Belakang_Ket,
            @Field("Lampu_Rem") String Lampu_Rem,
            @Field("Lampu_Rem_Ket") String Lampu_Rem_Ket,
            @Field("Lampu_Mundur") String Lampu_Mundur,
            @Field("Lampu_Mundur_Ket") String Lampu_Mundur_Ket,
            @Field("Lampu_Dashboard") String Lampu_Dashboard,
            @Field("Lampu_Dashboard_Ket") String Lampu_Dashboard_Ket,
            @Field("Lampu_Plafond_Depan_dan_Belakang") String Lampu_Plafond_Depan_dan_Belakang,
            @Field("Lampu_Plafond_Depan_dan_Belakang_Ket") String Lampu_Plafond_Depan_dan_Belakang_Ket,
            @Field("Klakson") String Klakson,
            @Field("Klakson_Ket") String Klakson_Ket,
            @Field("Antena") String Antena,
            @Field("Antena_Ket") String Antena_Ket,
            @Field("Tape_Radio_CD_DVD_TV_Player") String Tape_Radio_CD_DVD_TV_Player,
            @Field("Tape_Radio_CD_DVD_TV_Player_Ket") String Tape_Radio_CD_DVD_TV_Player_Ket,
            @Field("Remote_Tape_Radio_CD_DVD_TV_Player") String Remote_Tape_Radio_CD_DVD_TV_Player,
            @Field("Remote_Tape_Radio_CD_DVD_TV_Player_Ket") String Remote_Tape_Radio_CD_DVD_TV_Player_Ket,
            @Field("Alarm_Remote_Key") String Alarm_Remote_Key,
            @Field("Alarm_Remote_Key_Ket") String Alarm_Remote_Key_Ket,
            @Field("Central_Lock") String Central_Lock,
            @Field("Central_Lock_Ket") String Central_Lock_Ket,
            @Field("Power_Window") String Power_Window,
            @Field("Power_Window_Ket") String Power_Window_Ket,
            @Field("Switch_Mirror") String Switch_Mirror,
            @Field("Switch_Mirror_Ket") String Switch_Mirror_Ket,
            @Field("Air_Conditioner") String Air_Conditioner,
            @Field("Air_Conditioner_Ket") String Air_Conditioner_Ket,
            @Field("Safety_Belt") String Safety_Belt,
            @Field("Safety_Belt_Ket") String Safety_Belt_Ket,
            @Field("Karpet") String Karpet,
            @Field("Karpet_Ket") String Karpet_Ket,
            @Field("Lighter") String Lighter,
            @Field("Lighter_Ket") String Lighter_Ket,
            @Field("Asbak") String Asbak,
            @Field("Asbak_Ket") String Asbak_Ket,
            @Field("Sarung_Jok") String Sarung_Jok,
            @Field("Sarung_Jok_Ket") String Sarung_Jok_Ket,
            @Field("Sandaran_Kepala") String Sandaran_Kepala,
            @Field("Sandaran_Kepala_Ket") String Sandaran_Kepala_Ket,
            @Field("Spion_Dalam") String Spion_Dalam,
            @Field("Spion_Dalam_Ket") String Spion_Dalam_Ket,
            @Field("Wiper_Blade") String Wiper_Blade,
            @Field("Wiper_Blade_Ket") String Wiper_Blade_Ket,
            @Field("Windshield_Washer") String Windshield_Washer,
            @Field("Windshield_Washer_Ket") String Windshield_Washer_Ket,
            @Field("Talang_Air") String Talang_Air,
            @Field("Talang_Air_Ket") String Talang_Air_Ket,
            @Field("Fender_Lumpur_Depan_dan_Belakang") String Fender_Lumpur_Depan_dan_Belakang,
            @Field("Fender_Lumpur_Depan_dan_Belakang_Ket") String Fender_Lumpur_Depan_dan_Belakang_Ket,
            @Field("Spion_Kiri_Kanan") String Spion_Kiri_Kanan,
            @Field("Spion_Kiri_Kanan_Ket") String Spion_Kiri_Kanan_Ket,
            @Field("Tutup_Bensin") String Tutup_Bensin,
            @Field("Tutup_Bensin_Ket") String Tutup_Bensin_Ket,
            @Field("Emblem_Logo") String Emblem_Logo,
            @Field("Emblem_Logo_Ket") String Emblem_Logo_Ket,
            @Field("Kaca_Mobil_dan_Kaca_Film") String Kaca_Mobil_dan_Kaca_Film,
            @Field("Kaca_Mobil_dan_Kaca_Film_Ket") String Kaca_Mobil_dan_Kaca_Film_Ket,
            @Field("STNK") String STNK,
            @Field("STNK_Ket") String STNK_Ket,
            @Field("Buku_KIR_Stiker_Peneng") String Buku_KIR_Stiker_Peneng,
            @Field("Buku_KIR_Stiker_Peneng_Ket") String Buku_KIR_Stiker_Peneng_Ket,
            @Field("Owners_Manual_Book") String Owners_Manual_Book,
            @Field("Owners_Manual_Book_Ket") String Owners_Manual_Book_Ket,
            @Field("Buku_Service") String Buku_Service,
            @Field("Buku_Service_Ket") String Buku_Service_Ket,
            @Field("Ban_Serep") String Ban_Serep,
            @Field("Ban_Serep_Ket") String Ban_Serep_Ket,
            @Field("Kunci_Roda_Busi_Pas_Tang") String Kunci_Roda_Busi_Pas_Tang,
            @Field("Kunci_Roda_Busi_Pas_Tang_Ket") String Kunci_Roda_Busi_Pas_Tang_Ket,
            @Field("Kunci_Stir") String Kunci_Stir,
            @Field("Kunci_Stir_Ket") String Kunci_Stir_Ket,
            @Field("Dongkrak") String Dongkrak,
            @Field("Dongkrak_Ket") String Dongkrak_Ket,
            @Field("P3K") String P3K,
            @Field("P3K_Ket") String P3K_Ket,
            @Field("Segitiga_Pengaman") String Segitiga_Pengaman,
            @Field("Segitiga_Pengaman_Ket") String Segitiga_Pengaman_Ket,
            @Field("Lap_Kanebo") String Lap_Kanebo,
            @Field("Lap_Kanebo_Ket") String Lap_Kanebo_Ket,
            @Field("Foto_Kendaraan_Tampak_Depan") String Foto_Kendaraan_Tampak_Depan,
            @Field("Foto_Kendaraan_Tampak_Belakang") String Foto_Kendaraan_Tampak_Belakang,
            @Field("Foto_Kendaraan_Tampak_Samping_Kanan") String Foto_Kendaraan_Tampak_Samping_Kanan,
            @Field("Foto_Kendaraan_Tampak_Samping_Kiri") String Foto_Kendaraan_Tampak_Samping_Kiri,
            @Field("apar") String apar,
            @Field("fuel") String fuel,
            @Field("isi_tangki") Integer isi_tangki,
            @Field("isi_tangki_ket") String isi_tangki_ket,
            @Field("km") Integer km,
            @Field("velg_ban") String velg_ban,
            @Field("tutup_dop") String tutup_dop,
            @Field("signature") String signature,
            @Field("signature_image") String signature_image,
            @Field("CreatedBy") Integer CreatedBy
    );

    @GET("BSTKBeforeForAfter")
    Call<List<Ts_BSTKBefores>> GetBSTKBeforeForAfter(@Query("id") Integer id);

    @GET("BSTKView")
    Call<List<BSTKView>> GetBSTKView(@Query("id") Integer id);

    @GET("Customer")
    Call<List<Ms_Customers>> GetCustomer();

    @GET("Vehicle")
    Call<List<Ms_Vehicles>> GetVehicle();

    @FormUrlEncoded
    @POST("users")
    Call<Ms_Vehicles> GetPlatNo();

}