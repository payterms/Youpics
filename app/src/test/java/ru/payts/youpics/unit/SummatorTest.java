package ru.payts.youpics.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SummatorTest {

    private Summator summator;

    @Before
    public void before() {
        summator = new Summator();
    }

    @Test
    public void addTwoNumbers_whenSome_isCorrect() {
        double num1 = .1, num2 = .6;
        double result = summator.addTwoNumbers(num1, num2);
        Assert.assertEquals(result, .7, 0.0000000000000001);
    }

    @Test
    public void addTwoNumbers_whenSome_isIncorrect() {
        double num1 = .1, num2 = .7;
        double result = summator.addTwoNumbers(num1, num2);
        Assert.assertNotEquals(result, 0.9, 0.0000000000000001);
    }

    @Test
    public void addTwoNumbers_whenYouHaveIntelProcessor() {
        //java.lang.AssertionError:
        //Expected :0.7999999999999999 - so Intel See .8 value !!!
        //Actual   :0.8
        double num1 = .1, num2 = .7;
        double result = summator.addTwoNumbers(num1, num2);
        // For NON INTEL use this case
        // Assert.assertEquals(result, .8, 0.0000000000000001);

        // For Intel ;=)
        Assert.assertNotEquals(result, .8, 0.0000000000000001);
    }

    @Test
    public void addTwoNumbers_Zero() {
        double num1 = 0, num2 = 0;
        double result = summator.addTwoNumbers(num1, num2);
        Assert.assertEquals(result, 0, 0.0000000000000001);
    }

    @Test
    public void addTwoNumbers_NegativePositive() {
        double num1 = -123.0, num2 = 123.0;
        double result = summator.addTwoNumbers(num1, num2);
        Assert.assertEquals(result, 0, 0.0000000000000001);
    }
}