package com.example.android.recyclerandcardview;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by nitesh on 2/6/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Recycleritem> listItems;
    private Context mContext;

    public MyAdapter(List<Recycleritem> listItems, Context context) {
        this.listItems = listItems;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Recycleritem itemList = listItems.get(position);
        holder.txtTitle.setText(itemList.getTitle());
        holder.txtDescription.setText(itemList.getDescription());
        holder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //display menu

                PopupMenu popupMenu = new PopupMenu(mContext, holder.txtOptionDigit);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch(item.getItemId()){
                            case R.id.menu_item_save:
                                Toast.makeText(mContext, "Saved", Toast.LENGTH_LONG).show();
                                break;

                            case R.id.menu_item_delete:
                                //delete
                                listItems.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(mContext, "Deleted", Toast.LENGTH_LONG).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTitle;
        public TextView txtDescription;
        public TextView txtOptionDigit;
        public ViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtOptionDigit = (TextView) itemView.findViewById(R.id.txtOptionDigit);
        }
    }
}
