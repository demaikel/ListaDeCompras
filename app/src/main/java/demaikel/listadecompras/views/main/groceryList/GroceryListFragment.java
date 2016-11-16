package demaikel.listadecompras.views.main.groceryList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import demaikel.listadecompras.R;
import demaikel.listadecompras.adapters.GroceriesAdapters;
import demaikel.listadecompras.models.Grocery;
import demaikel.listadecompras.views.details.DetailsActivity;

/**
 * Created by Michael on 10-11-2016.
 */

public class GroceryListFragment extends Fragment implements GroceryListListener {

    public static final String GROCERY_ID = "GROCERY_ID";

    private GroceriesAdapters groceriesAdapters;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public GroceryListFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grocery_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.groceryRv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        groceriesAdapters = new GroceriesAdapters(this);

        recyclerView.setAdapter(groceriesAdapters);

        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view;
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        groceriesAdapters.reset();
                        refreshLayout.setRefreshing(false);
                    }
                }, 800);

            }
        });

    }

    public void addGrocery (Grocery grocery){
        groceriesAdapters.add(grocery);
    }

    @Override
    public void click(long id) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(GROCERY_ID, id);
        startActivity(intent);
    }

    public void search(String name) {
        groceriesAdapters.search(name);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.others) {
            groceriesAdapters.reset();
            return true;
        } else if (id == R.id.drinks) {
            groceriesAdapters.drinks();
            return true;
        } else if (id == R.id.meat_and_fish) {
            groceriesAdapters.meat_and_fish();
            return true;
        } else if (id == R.id.cereals_and_pasta) {
            groceriesAdapters.cereals_and_pasta();
            return true;
        } else if (id == R.id.frozen_foods) {
            groceriesAdapters.frozen_foods();
            return true;
        } else if (id == R.id.sweets) {
           groceriesAdapters.sweets();
            return true;
        } else if (id == R.id.fruits_and_vegetables) {
            groceriesAdapters.fruits_and_vegetables();
            return true;
        } else if (id == R.id.dairy_products) {
            groceriesAdapters.dairy_products();
            return true;
        } else if (id == R.id.cleaning) {
            groceriesAdapters.cleaning();
            return true;
        } else if (id == R.id.pet) {
           groceriesAdapters.pet();
            return true;
        } else if (id == R.id.bread_and_pastry) {
            groceriesAdapters.bread_and_pastry();
            return true;
        } else if (id == R.id.others) {
            groceriesAdapters.others();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}

