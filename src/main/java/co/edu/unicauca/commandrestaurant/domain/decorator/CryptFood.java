package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.unicauca.commandRestaurant.infra.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 * @author Whalen Stiven Caicedo
 * @author Juan David Muñoz Pasquel
 */
public class CryptFood extends Food {

    private Food myDecoratedFood;
    
    public CryptFood(int id, String name, FoodTypeEnum type){
        try{
            String nombreEncriptado= Utilities.encriptar(name);
            myDecoratedFood = new Food(id, nombreEncriptado, type);
        }catch(Exception ex){
            Logger.getLogger(CryptFood.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    @Override
    public void setName(String name) {
        myDecoratedFood.setName(name.toUpperCase());
    }

    @Override
    public String getName() {
        return myDecoratedFood.getName();
    }

    /**
     *
     * @return Id del plato
     */
    @Override
    public int getId() {
        return myDecoratedFood.getId();
    }

    @Override
    public void setId(int id) {
        myDecoratedFood.setId(id);
    }

    @Override
    public FoodTypeEnum getType() {
        return myDecoratedFood.getType();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        myDecoratedFood.setType(type);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + myDecoratedFood.getId() + ", name=" + myDecoratedFood.getName() + ", type=" + myDecoratedFood.getType() + '}';
    }

}
