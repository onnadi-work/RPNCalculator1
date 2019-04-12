import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {
    @Test
    public void given2Return2() {
        assertEquals(2, new Calc("2").eval(), 0.001);
    }

    @Test
    public void given4Return4() {
        assertEquals(4, new Calc("4").eval(), 0.001);
    }

    @Test
    public void given4_4_Plus_Return8() {
        assertEquals(8, new Calc("4 4 +").eval(), 0.001);
    }

    @Test
    public void given4_4_4_Plus_Plus_Return12() {
        assertEquals(12, new Calc("4 4 4 + +").eval(), 0.001);
    }

    @Test
    public void given1_2_2_Plus_Plus_Return5() {
        assertEquals(5, new Calc("1 2 2 + +").eval(), 0.001);
    }

    @Test
    public void given4_2_Minus_Return2() {
        assertEquals(2, new Calc("4 2 -").eval(), 0.001);
    }

    @Test
    public void given4_2_Multiply_Return8() {
        assertEquals(8, new Calc("4 2 *").eval(), 0.001);
    }

    @Test
    public void given4_2_Divide_Return2() {
        assertEquals(2, new Calc("4 2 /").eval(), 0.001);
    }

    @Test
    public void given4_SQRT_Return2() {
        assertEquals(2, new Calc("4 SQRT").eval(), 0.001);
    }

    @Test
    public void given2_4_4_SQRT_Plus_MultiplyReturn12() {
        assertEquals(12, new Calc("2 4 4 SQRT + *").eval(), 0.001);
    }
}
