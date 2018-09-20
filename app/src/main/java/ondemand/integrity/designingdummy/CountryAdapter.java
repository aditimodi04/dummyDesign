package ondemand.integrity.designingdummy;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.Locale;

import ondemand.integrity.designingdummy.countrypicker.Country;

public class CountryAdapter extends ArrayAdapter<Country> implements SpinnerAdapter {
    private Context context;
    private Country[] values;

    public CountryAdapter(@NonNull Context context, int resource, int txtCountryName, Country[] values) {
        super(context, resource, txtCountryName, values);
        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position, View rowView, @NonNull ViewGroup parent) {
        if (rowView == null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.spinner_row, parent, false);
        }
        TextView textView = (TextView) rowView.findViewById(R.id.txtCountryName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imvCountryFlag);
        Country country = getItem(position);
        textView.setText(country.getCode());
        imageView.setImageResource(country.getFlag());
        return rowView;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Country getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_row, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.txtCountryName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imvCountryFlag);
        Country country = getItem(position);
        textView.setText(country.getCode());
        imageView.setImageResource(country.getFlag());
        return convertView;
    }
}
