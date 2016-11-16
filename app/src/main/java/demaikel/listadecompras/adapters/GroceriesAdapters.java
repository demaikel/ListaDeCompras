package demaikel.listadecompras.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import demaikel.listadecompras.R;
import demaikel.listadecompras.data.Groceries;
import demaikel.listadecompras.models.Grocery;
import demaikel.listadecompras.views.main.groceryList.GroceryListListener;
import demaikel.listadecompras.views.main.groceryList.GroceryListFragment;
import demaikel.listadecompras.views.main.groceryList.GroceryListListener;

import static android.R.attr.data;
import static android.R.attr.name;

/**
 * Created by Michael on 10-11-2016.
 */

public class GroceriesAdapters extends RecyclerView.Adapter<GroceriesAdapters.ViewHolder> {


    private List<Grocery> groceries = new Groceries().notDone();
    private GroceryListListener listener;

    public GroceriesAdapters(GroceryListFragment listener) {
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_grocery, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Grocery grocery = groceries.get(position);
        holder.name.setText(grocery.getName());

        CheckBox checkBox = holder.status;
        checkBox.setChecked(grocery.isDone());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        grocery.setDone(true);
                        grocery.save();
                        groceries.remove(position);
                        notifyDataSetChanged();

                    }
                },100);
            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click(grocery.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }

    public void add(Grocery grocery) {
        groceries.add(0, grocery);
        notifyDataSetChanged();
    }

    public void reset() {
        groceries.clear();
        List<Grocery> groceryList = new Groceries().notDone();
        groceries.addAll(groceryList);
        notifyDataSetChanged();
    }

    public void search(String name) {
        List<Grocery> groceryList = new Groceries().byName(name);
        groceries.clear();
        groceries.addAll(groceryList);
        notifyDataSetChanged();

    }

    public void drinks(){
        List<Grocery> drinks  = new Groceries().drinks();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void meat_and_fish(){
        List<Grocery> drinks  = new Groceries().meat_and_fish();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }

    public void cereals_and_pasta(){
        List<Grocery> drinks  = new Groceries().cereals_and_pasta();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void frozen_foods(){
        List<Grocery> drinks  = new Groceries().frozen_foods();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void sweets(){
        List<Grocery> drinks  = new Groceries().sweets();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void fruits_and_vegetables(){
        List<Grocery> drinks  = new Groceries().fruits_and_vegetables();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void dairy_products(){
        List<Grocery> drinks  = new Groceries().dairy_products();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void cleaning(){
        List<Grocery> drinks  = new Groceries().cleaning();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void pet(){
        List<Grocery> drinks  = new Groceries().pet();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void bread_and_pastry(){
        List<Grocery> drinks  = new Groceries().bread_and_pastry();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }
    public void others(){
        List<Grocery> drinks  = new Groceries().others();
        groceries.clear();
        groceries.addAll(drinks);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CheckBox status;

        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameTv);
            status = (CheckBox) view.findViewById(R.id.groceryCb);
        }

    }
}

