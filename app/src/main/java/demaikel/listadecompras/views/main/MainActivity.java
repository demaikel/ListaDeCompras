package demaikel.listadecompras.views.main;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import demaikel.listadecompras.views.main.CreateCallback;
import demaikel.listadecompras.R;
import demaikel.listadecompras.models.Grocery;
import demaikel.listadecompras.views.main.GroceryValidation;
import demaikel.listadecompras.views.main.groceryList.GroceryListFragment;
import demaikel.listadecompras.views.main.searhBar.SearchCallback;
import demaikel.listadecompras.views.main.searhBar.SearchFragment;

import static android.R.attr.id;
import static android.R.attr.name;

public class MainActivity extends AppCompatActivity implements CreateCallback, SearchCallback {

    private Dialog dialog;
    private GroceryListFragment groceryListFragment;
    private SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        groceryListFragment = (GroceryListFragment) getSupportFragmentManager().findFragmentById(R.id.groceryListFragment);
        searchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.searchFragmet);

        setDialog();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Limpiar la vista escrita
                EditText groceryInput = (EditText) dialog.findViewById(R.id.groceryEt);
                groceryInput.setText("");
                dialog.show();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(getCurrentFocus(), InputMethodManager.SHOW_FORCED);

            }
        });
    }

    private void setDialog(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_create_grocery);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        final EditText groceryInput = (EditText) dialog.findViewById(R.id.groceryEt);
        ImageButton saveBtn = (ImageButton) dialog.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groceryName = groceryInput.getText().toString();
                createPending(groceryName);
            }
        });

        groceryInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE) {
                    String groceryName = groceryInput.getText().toString();
                    createPending(groceryName);
                    return true;
                }
                return false;
            }
        });

    }

    private void createPending(String name) {
        GroceryValidation groceryValidation = new GroceryValidation((this));
        groceryValidation.init(name);
        dialog.dismiss();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);


    }

    @Override
    public void success(Grocery grocery) {
        groceryListFragment.addGrocery(grocery);
        searchFragment.addSugestion(grocery.getName());

    }

        @Override
    public void fail() {
        Toast.makeText(this, "Escriba su tarea por favor", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void search(String name) {
        groceryListFragment.search(name);

    }
}
