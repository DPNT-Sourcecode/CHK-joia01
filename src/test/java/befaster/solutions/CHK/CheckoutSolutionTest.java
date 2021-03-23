package befaster.solutions.CHK;

import org.junit.Assert;
import org.junit.Test;

public class CheckoutSolutionTest {

    @Test
    public void test1()
    {
        Assert.assertTrue(new CheckoutSolution().checkout("AABCDBAAEEAAAAA") == 525);
    }

    @Test
    public void test2()
    {
        Assert.assertTrue(new CheckoutSolution().checkout("EE") == 80);
    }

    @Test
    public void test3()
    {
        Assert.assertTrue(new CheckoutSolution().checkout("EEB") == 80);
    }

    @Test
    public void test4()
    {
        Assert.assertTrue(new CheckoutSolution().checkout("EEEB") == 120);
    }
}

