package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import pl.sdacademy.animals.time.BearClock
import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        int weight = 3
        int mealWeight = 5

        Bear bear = new BlackBear(weight)
        bear.eat(mealWeight)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should not be alive if it has eaten within more than 10 days"() {
        given:
        int mealWeight = 5

        def clock = new TestClock()
        def bear = new BlackBear(3, clock)
        bear.eat(mealWeight) //lastMealDate = 16.03.2018

        when:
        def result = bear.isAlive() //clock.getCurrentTime = 27.03.2018

        then:
        !result
    }

    class TestClock extends BearClock {
        int counter = 0

        @Override
        DateTime getCurrentTime() {
            counter++
            if (counter > 1)
                return DateTime.now().plusDays(11)
            else
                return DateTime.now()
        }
    }
    //Po zjedzeniu posiłku o danej masie, jego waga wzrasta o tę samą wartość.
    def "After eating meal in certain weight, bear's weight increase about this value"() {
        given:
        int weight = 40
        int mealWeight = 5
        Bear bear = new BlackBear(weight)
        bear.eat(mealWeight)

        when:
        def result = bear.getWeight()

        then:
        result == weight + mealWeight
    }

    //Po wypiciu wody (void drink(double waterWeight)) o danej masie, jego waga wzrasta o 3/4 tej wartości.

    def "After drinking water in certain weight, bear's weight increase about this value"() {
        given:
        int weight = 40
        double waterWeight = 10
        Bear bear = new BlackBear(weight)
        bear.drink(waterWeight)

        when:
        def result = weight + waterWeight

        then:
        result == weight + waterWeight
    }

    //Po zrobieniu kupy (void poop()) masa misia spada o 5%

    def "After making a poop bear's weight less 5%"(){

        given:
        int weight = 40
        Bear bear = new BlackBear(weight)
        bear.poop()

        when:
        def result = bear.getWeight()

        then:
        result == weight*0.95
    }



}
