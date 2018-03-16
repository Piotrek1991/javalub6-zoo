package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.Animal;


public abstract class Bear implements Animal {

    private int weight;
    private boolean isAlive;
    private DateTime lastMealTime;
    private int mealWeight;
    private int waterWeight;

    public Bear(int weight) {
        this.weight = weight;
        this.isAlive = true;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    public void eat(int mealWeight) {
        this.mealWeight = mealWeight;
    }

    public double drinkWater(int waterWeight)
    {
        double weight = waterWeight*0.75;
        return weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

}
