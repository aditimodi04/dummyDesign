package ondemand.integrity.designingdummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import ondemand.integrity.designingdummy.countrypicker.CountryPicker;

public class PersonalDetailAct extends AppCompatActivity {

    private Spinner spIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_back);
        spIcon = findViewById(R.id.spIcon);
        CountryAdapter adapter = new CountryAdapter(
                this,
                R.layout.spinner_row,R.id.txtCountryName,
                CountryPicker.COUNTRIES
        );
        adapter.setDropDownViewResource(R.layout.spinner_row);
        spIcon.setAdapter(adapter);
    }
}
