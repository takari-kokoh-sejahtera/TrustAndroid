package com.example.aplikasi2.viewbstk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasi2.Model.BSTKView;
import com.example.aplikasi2.Model.Globals;
import com.example.aplikasi2.Model.Ts_BSTKBefores;
import com.example.aplikasi2.R;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Camera2;
import com.example.aplikasi2.inputbstk_sebelum.Model;
import com.example.aplikasi2.loginbstk.ApiClient;
import com.example.aplikasi2.loginbstk.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_View extends Fragment {

    ListView listView;
    int mID[];
    String mTitle[];
    String mDescription[];
    int images[];

    Context context;
    ApiInterface apiservice;
    MyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = this.getActivity();
        Globals g = (Globals) getActivity().getApplication();
        View view = inflater.inflate(R.layout.fragment_fragment__view, container, false);

        listView = (ListView) view.findViewById(R.id.listView);


        apiservice = ApiClient.getClient().create(ApiInterface.class);
        apiservice.GetBSTKView(g.getUser_ID()).enqueue(new Callback<List<BSTKView>>() {
            @Override
            public void onResponse(Call<List<BSTKView>> call, Response<List<BSTKView>> response) {
                List<BSTKView> gabungan = response.body();

                try {
//                  masukin ke adapter
                    Integer i = 0;
                    mID = new int[gabungan.size()];
                    mTitle = new String[gabungan.size()];
                    mDescription = new String[gabungan.size()];
                    images = new int[gabungan.size()];
                    for (BSTKView gabung : gabungan) {
                        mID[i] = gabung.BSTKBefore_ID;
                        mTitle[i] = gabung.Company_Name.toString();
                        mDescription[i] = gabung.license_no.toString() + ";" + gabung.Type.toString();
                        if (gabung.IsCompleted) {
                            images[i] = R.drawable.checked;
                        } else {
                            images[i] = R.drawable.cancel;
                        }
                        i++;
                    }
                    adapter = new MyAdapter(context, mTitle, mDescription, images);
                    listView.setAdapter(adapter);

                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BSTKView>> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtOptionDigit =  view.findViewById(R.id.txtOptionDigit);

                txtOptionDigit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(context, txtOptionDigit);
                        popupMenu.inflate(R.menu.option_menu);
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.mnu_item_edit:
                                        Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show();
                                        break;
                                    case R.id.mnu_item_delete:
                                        try {
                                            Delete_Fragment(mID[position]);
                                            Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show();
                                            break;
                                        }catch (Exception e){
                                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                                            break;
                                        }
                                    default:
                                        break;
                                }

                                return false;
                            }
                        });
                        popupMenu.show();
                    }
                });

                if (position == 0) {
                    Toast.makeText(context, "Facebook Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(context, "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(context, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private void Delete_Fragment(int ID) {
        Fragment_Delete fragment = new Fragment_Delete();
        fragment.BSTKBefore_ID = ID;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.viewbstk_row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        public MyAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.viewbstk_row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}
