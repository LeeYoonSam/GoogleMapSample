package sample.googlemap.ys.com.googlemapsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ys on 2017. 8. 11..
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<String> menus;

    public MainAdapter(ArrayList<String> menus) {
        this.menus = menus;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tvMenu.setText(menus.get(i));
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMenu;

        public ViewHolder(View view) {
            super(view);

            tvMenu = (TextView)view.findViewById(R.id.tvMenu);
        }
    }
}
