package befaster.solutions.CHK;

import org.junit.Assert;
import org.junit.Test;

public class CheckoutSolutionTest {

    @Test
    public void test()
    {
        Assert.assertEquals(new CheckoutSolution().checkout("AABCDBAAEEAAAAA"), 525);
        Assert.assertEquals(new CheckoutSolution().checkout("EE"), 80);
        Assert.assertEquals(new CheckoutSolution().checkout("EEB"), 80);
        Assert.assertEquals(new CheckoutSolution().checkout("EEEB"), 120);
    }
}
