package id.sch.smktelkom_mlg.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import id.sch.smktelkom_mlg.project2.adapter.KotaAdapter;

public class Main5Activity extends AppCompatActivity {

    Spinner sprov,skota;
    TextView tvHasil;
    String[][] arkota ={{"Jakarta Barat", "Jakarta Timur", "Jakarta Utara", "Jakarta Selatan", "Jakarta Pusat"},
            {"Surabaya","Malang","Jombang"},{"Bandung","Cirebon","Bekasi"},{"Yogya"},{"Samarinda","Balikpapan","Bontang"}};
    ArrayList<String> listKota = new ArrayList<>();
    KotaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        adapter = new KotaAdapter(this,listKota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skota.setAdapter(adapter);
        sprov =(Spinner) findViewById(R.id.prov);
        tvHasil = (TextView) findViewById(R.id.hasil);

        sprov.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                listKota.clear();
                listKota.addAll(Arrays.asList(arkota[pos]));
                adapter.setMprovinsi((String)sprov.getItemAtPosition(pos));
                adapter.notifyDataSetChanged();
                skota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        findViewById(R.id.oce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }
    private void doClick(){

        StringBuilder builder = new StringBuilder();
        builder.append("Wilayah Provinsi");
        builder.append(sprov.getSelectedItem().toString());
        builder.append("Kota");
        builder.append(skota.getSelectedItem().toString());
        builder.append("\n\n\n");

        builder.append("Kota Yang tidak dipilih adalah : \n\n");

        String [] arprovinsi = getResources().getStringArray(R.array.provinsi);
        int pprov = sprov.getSelectedItemPosition();
        int pkota = skota.getSelectedItemPosition();


        for (int i = 0; i < arprovinsi.length; i++ ){
            builder.append(arprovinsi[i]).append(":\n");
            for(int j = 0; j < arkota[i].length; j++){
                if(!(i==pprov && j==pkota)){
                    builder.append("\t").append(arkota[i][j]).append("\n");
                }
                builder.append("\n");
            }
        }
        tvHasil.setText(builder);
    }
}
