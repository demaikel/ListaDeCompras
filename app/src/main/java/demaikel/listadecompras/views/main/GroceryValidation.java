package demaikel.listadecompras.views.main;

import demaikel.listadecompras.models.Grocery;

/**
 * Created by Michael on 10-11-2016.
 */

public class GroceryValidation {

    private CreateCallback callback;

    public GroceryValidation(CreateCallback callback) {
        this.callback = callback;
    }

    public void init(String name) {
        if (name.trim().length() > 0) {
            Grocery grocery = new Grocery();
            grocery.setName(name);
            grocery.setDone(false);
            grocery.save();
            callback.success(grocery);
        }else{
            callback.fail();
        }
    }
}
