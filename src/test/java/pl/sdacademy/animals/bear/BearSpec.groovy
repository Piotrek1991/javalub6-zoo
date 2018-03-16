package pl.sdacademy.animals.bear

import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)

        when:
        boolean  result = bear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)
        bear.eat()

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should not be alive if it has eaten within more than 10 days"() {

        given:
        def bear = new BlackBear(3);
        bear.eat()


        when:
        def result


    }


    //Po zjedzeniu posiłku o danej masie, jego waga wzrasta o tę samą wartość.
    def "After eat meal with its weight, bear's weight grown about this value"()
    {
        given:
        int mealWeight = 1
        int weight = 3
        Bear bear = new BlackBear(weight)

        when:
        int result = weight + bear.eatMeal(mealWeight)

        then:
        result == 4
    }
//Po wypiciu wody (void drink(double waterWeight)) o danej masie, jego waga wzrasta o 3/4 tej wartości
    def " After drink water with its weight, bear's weight increase about 75% this value"()
    {
        given:
        int waterWeight = 10
        int weight = 40
        Bear bear = new BlackBear(10)

        when:
        double result = weight + bear.drinkWater(waterWeight)

        then:
        result == 47.5
    }


}
