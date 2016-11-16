package demaikel.listadecompras.models;

import com.orm.SugarRecord;

/**
 * Created by Michael on 08-11-2016.
 */

public class Grocery extends SugarRecord {

    private String name, type, description;
    private boolean done;

    public Grocery() {
    }

    public Grocery(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
