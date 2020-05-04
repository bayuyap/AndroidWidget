package id.sch.smktelkom_mlg.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText Nama;
    EditText TTL;
    Button bOK;
    TextView hasil;
    EditText Tanggal;
    EditText tempat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Nama = (EditText) findViewById(R.id.editTextnama);
        TTL =(EditText) findViewById(R.id.editTexttl);
        bOK =(Button) findViewById(R.id.buttonOK);
        hasil =(TextView) findViewById(R.id.textViewHasil);
        Tanggal=(EditText) findViewById(R.id.tanggal);
        tempat=(EditText) findViewById(R.id.tempatlahir);
        bOK.setOnClickListener(new View.OnClickListener()
        {
        @Override
            public void onClick(View view)
        {
                doProcess();

        }

        });
    }

    private void doProcess() {
        if(isValid()){
        String nama = Nama.getText().toString();
        String Tempat = tempat.getText().toString();
        String tanggal = Tanggal.getText().toString();
        int tahun =Integer.parseInt(TTL.getText().toString());
        int usia = 2018 - tahun;
        hasil.setText(nama + " Berusia "+usia+" Tahun " + " Lahir Pada Tanggal "+tanggal+" Di "+Tempat);
    }
}

    private boolean isValid() {
        boolean valid=true;

        String nama = Nama.getText().toString();
        String Tempat = tempat.getText().toString();
        String tanggal = Tanggal.getText().toString();
        String tahun = TTL.getText().toString();

        if(nama.isEmpty()){
            Nama.setError(" Nama Belum Diisi ");
            valid= false;
        }
        else if(nama.length()<3){
            Nama.setError(" Nama Minimal Harus 3 Karakter ");
            valid = false;
        }
        else{
            Nama.setError(null);
        }
        if(Tempat.isEmpty()){
            tempat.setError(" Tempat Lahir Belum Diisi");
            valid =false;
        }
        else if(Tempat.length()<3){
            tempat.setError(" Tempat Lahir Minimal Harus 3 Karakter ");
            valid = false;
        }
        else{
            tempat.setError(null);
        }
        if(tahun.isEmpty()){
            TTL.setError(" Tempat Lahir Belum Diisi");
            valid =false;
        }
        else if(tahun.length()<3){
            TTL.setError(" Tempat Lahir Minimal Harus 3 Karakter ");
            valid = false;
        }
        else{
            TTL.setError(null);
        }
        if(tanggal.isEmpty()){
            Tanggal.setError(" Tempat Lahir Belum Diisi");
            valid =false;
        }
        else if(tanggal.length()<3){
            Tanggal.setError(" Tempat Lahir Minimal Harus 3 Karakter ");
            valid = false;
        }
        else{
            Tanggal.setError(null);
        }
        return valid;
    }
}
