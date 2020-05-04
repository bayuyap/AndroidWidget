package id.sch.smktelkom_mlg.project2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.project2.R;

/**
 * Created by SMK TELKOM on 1/23/2018.
 */

public class KotaAdapter extends ArrayAdapter<String> {

    String mprovinsi = "";

    public void setMprovinsi(String provinsi) {
        this.mprovinsi = provinsi;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
private View getCustomView(int position, @Nullable View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.rowkota, parent, false);

        TextView tvtitle = (TextView) convertView.findViewById(R.id.title);
        tvtitle.setText(getItem(position).substring(0, 1));
        TextView tvkota = (TextView) convertView.findViewById(R.id.viewkota);
        tvkota.setText(getItem(position));
        TextView tvprov = (TextView) convertView.findViewById(R.id.viewprov);
        tvprov.setText(mprovinsi);

    }
    return convertView;
}
    public KotaAdapter(@NonNull Context context, ArrayList<String> listKota) {

        super(context, R.layout.rowkota, listKota);
    }
}
