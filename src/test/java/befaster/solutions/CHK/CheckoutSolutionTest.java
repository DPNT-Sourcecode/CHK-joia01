package befaster.solutions.CHK;

import org.junit.Assert;
import org.junit.Test;

public class CheckoutSolutionTest {

    @Test
    public void test1()
    {
        Assert.assertEquals(525, (long)(new CheckoutSolution().checkout("AABCDBAAEEAAAAA")));
    }

    @Test
    public void test2()
    {
        Assert.assertEquals(80, (long)(new CheckoutSolution().checkout("EE")));
    }

    @Test
    public void test3()
    {
        Assert.assertEquals(80, (long)(new CheckoutSolution().checkout("EEB")));
    }

    @Test
    public void test4()
    {
        Assert.assertEquals(120, (long)(new CheckoutSolution().checkout("EEEB")));
    }

    @Test
    public void test5()
    {
        Assert.assertEquals(140, (long)(new CheckoutSolution().checkout("EEEBFF")));
    }

    @Test
    public void test6()
    {
        Assert.assertEquals(140, (long)(new CheckoutSolution().checkout("EEEBFFF")));
    }

    @Test
    public void test7()
    {
        Assert.assertEquals(60, (long)(new CheckoutSolution().checkout("FFFFFFFF")));
    }

    @Test
    public void test8()
    {
        Assert.assertEquals(10, (long)(new CheckoutSolution().checkout("F")));
    }

    @Test
    public void test9()
    {
        Assert.assertEquals(20, (long) (new CheckoutSolution().checkout("FF")));
    }

    @Test
    public void test10()
    {
        Assert.assertEquals(165, (long)(new CheckoutSolution().checkout("ABCDEF")));
    }

    @Test
    public void test11()
    {
        Assert.assertEquals(20, (long)(new CheckoutSolution().checkout("G")));
    }

    @Test
    public void test12()
    {
        Assert.assertEquals(152, (long)(new CheckoutSolution().checkout("STXYZSTXYZ")));
    }
}
