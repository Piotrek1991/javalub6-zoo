package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.BearClock;


public abstract class Bear implements Animal {

    private double weight;
    private boolean isAlive;
    private DateTime lastMealTime;
    private BearClock clock;
    private double waterWeight;

    public Bear(int weight) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = new BearClock();
    }

    public Bear(int weight, BearClock clock) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = clock;
    }

    @Override
    public boolean isAlive() {
        return new Duration(lastMealTime, clock.getCurrentTime()).isShorterThan(Duration.standardDays(10));

    }

    public void eat( int mealWeight ) {
        this.lastMealTime = clock.getCurrentTime();
        this.weight += mealWeight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void drink(double waterWeight) {

        this.waterWeight = waterWeight;
        this.weight += waterWeight;
    }

    public void poop()
    {
        this.weight = weight *0.95;
    }

}
