package befaster.solutions.CHK;

import org.junit.Assert;
import org.junit.Test;

public class CheckoutSolutionTest {

    @Test
    public void test1()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("AABCDBAAEEAAAAA")), 525);
    }

    @Test
    public void test2()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("EE")), 80);
    }

    @Test
    public void test3()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("EEB")), 80);
    }

    @Test
    public void test4()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("EEEB")), 120);
    }

    @Test
    public void test5()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("EEEBFF")), 140);
    }

    @Test
    public void test6()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("EEEBFFF")), 140);
    }

    @Test
    public void test7()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("FFFFFFFF")), 60);
    }

    @Test
    public void test8()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("F")), 10);
    }

    @Test
    public void test9()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("FF")), 20);
    }

    @Test
    public void test10()
    {
        Assert.assertEquals((long)(new CheckoutSolution().checkout("ABCDEF")), 165);
    }
}




