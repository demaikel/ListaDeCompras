package demaikel.listadecompras.views.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demaikel.listadecompras.R;
import demaikel.listadecompras.models.Grocery;
import demaikel.listadecompras.views.main.groceryList.GroceryListFragment;

import static android.R.attr.type;
import static android.support.v7.widget.AppCompatDrawableManager.get;
import static demaikel.listadecompras.R.id.groceryCb;
import static demaikel.listadecompras.R.id.others;
import static demaikel.listadecompras.R.id.typeSp;

public class DetailsActivity extends AppCompatActivity {

    private Grocery grocery;
    private EditText descriptionInput;
    private Spinner spinner;
    private ArrayList<String> types;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long groceryId = getIntent().getLongExtra(GroceryListFragment.GROCERY_ID, 0);

        grocery = Grocery.findById(Grocery.class, groceryId);

        getSupportActionBar().setTitle(grocery.getName());

        descriptionInput = (EditText) findViewById(R.id.descriptionEt);

        spinner = (Spinner) findViewById(R.id.typeSp);
        types = new ArrayList<>();
        types.add("Seleccione una opción");
        types.add("Bebestibles");
        types.add("Carne y Pescado");
        types.add("Cereales y Pastas");
        types.add("Congelados");
        types.add("Dulces");
        types.add("Frutas y Verduras");
        types.add("Lacteos");
        types.add("Limpieza");
        types.add("Mascota");
        types.add("Panaderia y Pasteleria");
        types.add("Otros");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, types);
        spinner.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        descriptionInput.setText(grocery.getDescription());
        String type = grocery.getType();
        if (type != null){
            for (int i = 0; i < types.size(); i++) {
                if (type.equals(types.get(i))){
                    spinner.setSelection(i);
                }
            }
        }
        grocery.save();
    }

    @Override
    protected void onPause() {
        String description = descriptionInput.getText().toString();
        grocery.setDescription(description);
        if (spinner.getSelectedItemPosition() != 0) {
            String type = spinner.getSelectedItem().toString();
            grocery.setType(type);
        }

        grocery.save();
        super.onPause();


    }
}
