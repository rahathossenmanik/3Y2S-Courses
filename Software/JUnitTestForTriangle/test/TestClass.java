package test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import main.MainClass;

class TestClass {
	@Test
	public void main() {
		MainClass test = new MainClass();
		assertEquals("EQUILATERAL", test.triangle(3, 3, 3));
		assertEquals("ISOSCELES", test.triangle(3, 3, 4));
		assertEquals("SCALENE", test.triangle(3, 4, 5));
		assertEquals("NOT A TRIANGLE", test.triangle(3, 4, 7));
		assertEquals("INVALID INPUT", test.triangle(0, 3, 3));
	}
}