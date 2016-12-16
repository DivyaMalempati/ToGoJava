import java.util.Scanner;

public class NumberUtilities {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int counter;
		do {
			int number;
			Range range;
			EnhancedArray eArray;
			System.out.println("Enter the number to perform an action : \n"
					+ " 1. isEven() \n" + " 2. isOdd() \n"
					+ " 3. isPrimeNumber() \n" + " 4. nPrimeNumbers \n"
					+ " 5. nEvenNumbers() \n" + " 6. nOddNumbers() \n"
					+ " 7. isPalindrome() \n" + " 8. nNumbersPalindrome() \n"
					+ " 9. decimalToBinary() \n" + " 0. To Exit ");
			counter = scanner.nextInt();
			switch (counter) {
			case 1:
				number = captureANumber(scanner);
				if (isEvenNumber(number)) {
					System.out.println(number + " is Even.");
				} else {
					System.out.println(number + " is not Even");
				}
				break;
			case 2:
				number = captureANumber(scanner);
				if (isOddNumber(number)) {
					System.out.println(number + " is Odd.");
				} else {
					System.out.println(number + " is not Odd");
				}
				break;
			case 3:
				number = captureANumber(scanner);
				if (isPrimeNumber(number)) {
					System.out.println(number + " is Prime.");
				} else {
					System.out.println(number + " is not Prime");
				}
				break;
			case 4:
				range = captureARange(scanner);
				System.out.println("Prime Numbers from " + range.getStart()
						+ " to " + range.getEnd());
				eArray = nPrimeNumbers(range.getStart(), range.getEnd());
				eArray.printArray();
				break;
			case 5:
				range = captureARange(scanner);
				System.out.println("Even Numbers from " + range.getStart()
						+ " to " + range.getEnd());
				nEvenNumbers(range.getStart(), range.getEnd());
				break;
			case 6:
				range = captureARange(scanner);
				System.out.println("Odd Numbers from " + range.getStart()
						+ " to " + range.getEnd());
				nOddNumbers(range.getStart(), range.getEnd());
				break;
			case 7:
				number = captureANumber(scanner);
				if (isNumberPalindrome(number)) {
					System.out.println(number + "is Palindrome");
				} else {
					System.out.println(number + "is not Palindrome");
				}
				break;
			case 8:
				range = captureARange(scanner);
				System.out.println("Palindrome from " + range.getStart()
						+ " to " + range.getEnd());
				nPalindromeNumbers(range.getStart(), range.getEnd());
				break;
			case 9:
				number = captureANumber(scanner);
				eArray = decimalToBinary(number);
				eArray.printArray();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Not a valid Input");
				break;
			}
		} while (counter != 0);
		scanner.close();
	}

	private static int captureANumber(Scanner scanner) {
		System.out.println("Enter a number :");
		int start = scanner.nextInt();
		return start;
	}

	public static Range captureARange(Scanner scanner) {
		return new Range(captureANumber(scanner), captureANumber(scanner));
	}

	public static boolean isEvenNumber(int number) {
		return number % 2 == 0;
	}

	public static boolean isOddNumber(int number) {
		return (number % 2 != 0);
	}

	public static boolean isPrimeNumber(int number) {
		boolean isPrime = true;
		if (number == 1 || number == 2) {
			isPrime = true;
		} else {
			for (int i = 2; i < Math.sqrt(number) + 1; i++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		return isPrime;
	}

	public static void nEvenNumbers(int startNumber, int endNumber) {
		for (int i = startNumber; i <= endNumber; i++) {
			if (isEvenNumber(i)) {
				System.out.println(i);
			}
		}
	}

	public static void nOddNumbers(int startNumber, int endNumber) {
		for (int i = startNumber; i <= endNumber; i++) {
			if (isOddNumber(i)) {
				System.out.println(i);
			}
		}
	}

	public static EnhancedArray nPrimeNumbers(int startNumber, int endNumber) {
		EnhancedArray eArray = new EnhancedArray(endNumber);
		for (int i = startNumber; i <= endNumber; i++) {
			if (isPrimeNumber(i)) {
				eArray.arrayAdd(i);
			}
		}
		// System.out.println(eArray.getUsedSize());
		return eArray;
	}

	public static boolean isNumberPalindrome(int number) {
		int temp = number, reverse = 0;
		while (temp != 0) {
			reverse *= 10;
			reverse += temp % 10;
			temp /= 10;
		}
		return number == reverse;
	}

	public static void nPalindromeNumbers(int startNumber, int endNumber) {
		for (int i = startNumber; i <= endNumber; i++) {
			if (isNumberPalindrome(i)) {
				System.out.println(i);
			}
		}
	}

	public static EnhancedArray decimalToBinary(int number) {
		EnhancedArray eArray = new EnhancedArray(number);
		while (number != 0) {
			eArray.arrayAdd(number % 2);
			number = number / 2;
		}
		eArray.reverse();
		return eArray;
	}
}

class Range {
	private int start, end;

	public Range(int start, int end) {
		if (start > end) {
			int temp;
			temp = start;
			start = end;
			end = temp;
		}
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
}

class EnhancedArray {
	private int[] numberArray;
	private int usedSize;

	public EnhancedArray(int maxsize) {
		this.usedSize = 0;
		this.numberArray = new int[maxsize];
	}

	private int getUsedSize() {
		return usedSize;
	}

	private int[] getNumberArray() {
		return numberArray;
	}

	public boolean arrayAdd(int toBeAdded) {
		if (usedSize < numberArray.length) {
			numberArray[usedSize] = toBeAdded;
			usedSize++;
			return true;
		}
		return false;
	}

	public void printArray() {
		for (int i = 0; i < usedSize; i++) {
			System.out.println(numberArray[i]);
		}
	}

	public void reverse() {
		int i = 0, j = usedSize-1;
		while (numberArray[i] < numberArray[j]) {
			int temp = 0;
			temp = numberArray[i];
			numberArray[i] = numberArray[j];
			numberArray[j] = temp;
			i++;
			j--;
		}
	}
}