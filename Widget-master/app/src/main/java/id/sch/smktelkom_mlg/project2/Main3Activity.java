package id.sch.smktelkom_mlg.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

   // RadioButton BM,bn,bd,bj;
    RadioGroup rgstats;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

     /*   BM= (RadioButton) findViewById(R.id.bm);
        bn= (RadioButton) findViewById(R.id.nikah);
        bd= (RadioButton) findViewById(R.id.dude);
        bj= (RadioButton) findViewById(R.id.BJ);*/
        rgstats = (RadioGroup) findViewById(R.id.rg);
        tvHasil= (TextView) findViewById(R.id.viewhasil);

        rgstats.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i== R.id.bm){
                    findViewById(R.id.JA).setVisibility(View.GONE);
                }
                else{
                    findViewById(R.id.JA).setVisibility(View.VISIBLE);
                }
            }
        });
        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
            private void doClick(){
                String hasil = null;

                if(rgstats.getCheckedRadioButtonId()!=-1){
                    RadioButton rb= (RadioButton) findViewById(rgstats.getCheckedRadioButtonId());
                    hasil=rb.getText().toString();

                    if(rgstats.getCheckedRadioButtonId() !=R.id.bm){
                        EditText etJA = (EditText) findViewById(R.id.jumlah);
                        hasil += "\n Jumlah Anak : " + etJA.getText();
                    }
                }
               /* if(BM.isChecked()){
                    hasil = BM.getText().toString();
                }
                else if(bn.isChecked()){
                    hasil = bn.getText().toString();
                }
                else if(bd.isChecked()){
                    hasil = bd.getText().toString();
                }
                else if(bj.isChecked()){
                    hasil = bj.getText().toString();
                }*/
                if(hasil==null){
                    tvHasil.setText("Belum Memilih");
                }
                else{
                    tvHasil.setText(" Status Anda : "+hasil);
                }

        }});


    }

    }

