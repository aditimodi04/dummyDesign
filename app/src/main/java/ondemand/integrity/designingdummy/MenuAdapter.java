package ondemand.integrity.designingdummy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<DummyDao> dummyDaos;

    public MenuAdapter(Context context, ArrayList<DummyDao> dummyDaos) {
        this.context = context;
        this.dummyDaos = dummyDaos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        DummyDao dao = new DummyDao();
        myViewHolder.txtDishName.setText(dao.getDishName());
        myViewHolder.txtDishActualPrice.setText(dao.getActualPrice() + "");
    }

    @Override
    public int getItemCount() {
        return dummyDaos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtDishName;
        TextView txtDishCategory, txtDishActualPrice, txtAdditionalInfo, txtItemQty;
        LinearLayout llMinusView, llPlusView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDishName = itemView.findViewById(R.id.txtDishName);
            txtDishCategory = itemView.findViewById(R.id.txtDishCategory);
            txtDishActualPrice = itemView.findViewById(R.id.txtDishActualPrice);
            txtAdditionalInfo = itemView.findViewById(R.id.txtAdditionalInfo);
            llMinusView = itemView.findViewById(R.id.llMinusView);
            llPlusView = itemView.findViewById(R.id.llPlusView);
            txtItemQty = itemView.findViewById(R.id.txtItemQty);
        }
    }
}
