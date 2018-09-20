package ondemand.integrity.designingdummy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private TextView txtRestroName;
    private TextView txtRatingVal;
    private TextView txtDeliveringStatus;
    private TextView txtViewDeliveringRestro;
    private RecyclerView rvMenuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        initViews();
        setContentData();
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_back);
    }

    private void initViews() {
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("");
        appBarLayout = findViewById(R.id.appBarLayout);
        setToolbar();
        txtRestroName = findViewById(R.id.txtRestroName);
        txtRatingVal = findViewById(R.id.txtRatingVal);
        findViewById(R.id.txtChangeLocation).setOnClickListener(this);
        findViewById(R.id.llLocation).setOnClickListener(this);
        txtDeliveringStatus = findViewById(R.id.txtDeliveringStatus);
        txtViewDeliveringRestro = findViewById(R.id.txtViewDeliveringRestro);
        rvMenuList = findViewById(R.id.rvMenuList);
        rvMenuList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Intent intent = new Intent(this, PersonalDetailAct.class);
        startActivity(intent);
    }

    private void setContentData() {
        appBarLayout.setBackgroundResource(R.drawable.ic_launcher_background);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("Restro Name");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });
        txtRestroName.setText("Restro Name");
        txtRatingVal.setText("3.9");
        rvMenuList.setAdapter(new MenuAdapter(this, setDummyData()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_save:
                break;
            case R.id.action_search:
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llLocation:
            case R.id.txtChangeLocation:
                break;
        }
    }

    private ArrayList<DummyDao> setDummyData() {
        ArrayList<DummyDao> arrayList = new ArrayList<>();
        arrayList.add(setDummyData(50.89, "", true, "Main Course", 40.20, "Paneer Butter Masala", true));
        arrayList.add(setDummyData(70.89, "", true, "Bread", 40.20, "Butter Naan", true));
        arrayList.add(setDummyData(50.89, "", false, "Main Course", 40.20, "Paneer Butter Masala", true));
        arrayList.add(setDummyData(50.89, "", false, "Main Course", 40.20, "Paneer Butter Masala", true));
        arrayList.add(setDummyData(50.89, "", false, "Main Course", 40.20, "Paneer Butter Masala", true));
        arrayList.add(setDummyData(50.89, "", false, "Main Course", 40.20, "Paneer Butter Masala", true));
        arrayList.add(setDummyData(50.89, "", false, "Main Course", 40.20, "Paneer Butter Masala", true));
        arrayList.add(setDummyData(50.89, "", false, "Main Course", 40.20, "Paneer Butter Masala", true));
        arrayList.add(setDummyData(70.89, "", false, "Bread", 40.20, "Butter Naan", true));
        arrayList.add(setDummyData(70.89, "", false, "Bread", 40.20, "Butter Naan", true));
        arrayList.add(setDummyData(70.89, "", false, "Bread", 40.20, "Butter Naan", true));
        arrayList.add(setDummyData(70.89, "", false, "Bread", 40.20, "Butter Naan", true));
        return arrayList;
    }

    private DummyDao setDummyData(double price, String additionalInfo, boolean bestSeller, String categoryName, double discountRate, String dishName, boolean isVeg) {
        DummyDao dao1 = new DummyDao();
        dao1.setActualPrice(price);
        dao1.setAdditionalInfo(additionalInfo);
        dao1.setBestSeller(bestSeller);
        dao1.setCategoryName(categoryName);
        dao1.setDiscountRate(discountRate);
        dao1.setDishName(dishName);
        dao1.setVeg(isVeg);
        return dao1;
    }
}
