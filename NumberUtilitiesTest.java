import org.junit.Assert;
import org.junit.Test;

public class NumberUtilitiesTest {

	@Test
	public void testIsPrimeNumber() {
		// Assert.assertTrue(NumberUtilities.isPrimeNumber(1));
		Assert.assertTrue(NumberUtilities.isPrimeNumber(2));
		Assert.assertFalse(NumberUtilities.isPrimeNumber(10));
		Assert.assertTrue(NumberUtilities.isPrimeNumber(15649));
	}

	@Test
	public void testIsEvenNumber() {
		Assert.assertTrue(NumberUtilities.isEvenNumber(0));
		Assert.assertTrue(NumberUtilities.isEvenNumber(2));
		Assert.assertFalse(NumberUtilities.isEvenNumber(1));
		Assert.assertTrue(NumberUtilities.isEvenNumber(1564));
	}

	@Test
	public void testIsOddNumber() {
		Assert.assertTrue(NumberUtilities.isOddNumber(1));
		Assert.assertTrue(NumberUtilities.isOddNumber(9));
		Assert.assertFalse(NumberUtilities.isOddNumber(2));
		Assert.assertFalse(NumberUtilities.isOddNumber(1564));
	}

	@Test
	public void testisNumberPalindrome() {
		Assert.assertTrue(NumberUtilities.isNumberPalindrome(1));
		Assert.assertTrue(NumberUtilities.isNumberPalindrome(11));
		Assert.assertTrue(NumberUtilities.isNumberPalindrome(121));
		Assert.assertTrue(NumberUtilities.isNumberPalindrome(13231));
		Assert.assertFalse(NumberUtilities.isNumberPalindrome(132831));
	}
}
