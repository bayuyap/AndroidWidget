package id.sch.smktelkom_mlg.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox g,m,t,s,k;
    TextView tvHasil,tvhobi;
    int nhobi;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        g = (CheckBox) findViewById(R.id.gg);
        m = (CheckBox) findViewById(R.id.read);
        t = (CheckBox) findViewById(R.id.tulis);
        s = (CheckBox) findViewById(R.id.turu);
        k = (CheckBox) findViewById(R.id.comic);
        g.setOnCheckedChangeListener(this);
        m.setOnCheckedChangeListener(this);
        t.setOnCheckedChangeListener(this);
        s.setOnCheckedChangeListener(this);
        k.setOnCheckedChangeListener(this);
        tvHasil = (TextView) findViewById(R.id.hasil);
        tvhobi  = (TextView) findViewById(R.id.hobi);
        findViewById(R.id.oce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }private void doClick(){
        String hasil = " Hobi Anda : \n ";
        int startlen = hasil.length();
        if(g.isChecked()) hasil += g.getText()+"\n";
        if(m.isChecked()) hasil += m.getText()+"\n";
        if(t.isChecked()) hasil += t.getText()+"\n";
        if(s.isChecked()) hasil += s.getText()+"\n";
        if(k.isChecked()) hasil += k.getText()+"\n";
        if(hasil.length() == startlen) hasil+="Tidak ada di pilihan";

        tvHasil.setText(hasil);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked) nhobi +=1;
        else nhobi -=1;

        tvhobi.setText("Hobi ("+nhobi+" terpilih)");


    }
}

