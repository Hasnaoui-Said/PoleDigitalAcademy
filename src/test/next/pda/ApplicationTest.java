package next.pda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    private Calculator calculator = new Calculator();
    @Test
    void calculatorTestAddMethode(){
        int a = 3;
        int b = 3;
        assertEquals(6, calculator.add(a,b));
        assertNotEquals(7, calculator.add(a,b));
    }
    @Test
    void calculatorTestMultipleMethode(){
        int a = 3;
        int b = 3;
        assertEquals(8, calculator.multiple(a,b));
        assertNotEquals(7, calculator.multiple(a,b));
    }
    class Calculator{
        private int a;
        private int b;

        public void  Calculator(){
        }
        public void  Calculator(int a, int b){
            this.a = a;
            this.b = b;
        }

        public int add(int a, int b) {
            return a + b;
        }

        public int multiple(int a, int b) {
            return a * b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

}