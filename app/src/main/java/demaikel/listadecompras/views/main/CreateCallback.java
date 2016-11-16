package demaikel.listadecompras.views.main;

import demaikel.listadecompras.models.Grocery;

/**
 * Created by Michael on 10-11-2016.
 */

public interface CreateCallback {

    void success(Grocery grocery);

    void fail();

}
