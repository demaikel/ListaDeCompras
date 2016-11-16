package demaikel.listadecompras.data;

import java.util.ArrayList;
import java.util.List;

import demaikel.listadecompras.models.Grocery;

/**
 * Created by Michael on 10-11-2016.
 */

public class Groceries {

    public List <Grocery> notDone() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "done = 0");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }

    public List <String> names (){
        List<String> names = new ArrayList<>();
        List<Grocery> groceries = notDone();
        if (groceries.size()> 0) {
            for (Grocery grocery : groceries) {
                names.add(grocery.getName());
            }
        }
        return names;
    }

    public  List<Grocery> byName(String name){
        List<Grocery> groceries = new ArrayList<>();
        String query = "done = 0 AND name LIKE " + "'%" + name +"%'";
        List<Grocery> groceryList = Grocery.find(Grocery.class, query);
        if (groceryList != null && groceryList.size() >0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }

    public List <Grocery> drinks() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Bebestibles");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> meat_and_fish() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Carne y Pescado");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> cereals_and_pasta() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Cereales y Pastas");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> frozen_foods() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Congelados");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> sweets() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Dulces");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> fruits_and_vegetables() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Frutas y Verduras");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> dairy_products() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Lacteos");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> cleaning() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Limpieza");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> pet() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Mascota");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> bread_and_pastry() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Panaderia y Pasteleria");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }
    public List <Grocery> others() {
        List<Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "type = ?", "Otros");
        if (groceryList != null && groceryList.size() > 0) {
            groceries.addAll(groceryList);
        }
        return groceries;
    }

}