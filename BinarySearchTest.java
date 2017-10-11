import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void objectCreationTest() {
        new BinarySearch();
    }

    @Test
    public void emptyListTest() {
        List<Integer> sortedArray = new ArrayList<>();
        Assert.assertEquals(false, BinarySearch.binarySearch(20, sortedArray));
    }

    @Test
    public void oneElementListTest() {
        List<Integer> sortedArray = new ArrayList<>();
        sortedArray.add(20);
        checkAllExistingElements(sortedArray);
        Assert.assertEquals(false, BinarySearch.binarySearch(30, sortedArray));
    }

    @Test
    public void twoElementListTest() {
        List<Integer> sortedArray = new ArrayList<>();
        sortedArray.add(20);
        sortedArray.add(30);
        checkAllExistingElements(sortedArray);
        Assert.assertEquals(false, BinarySearch.binarySearch(5, sortedArray));
        Assert.assertEquals(false, BinarySearch.binarySearch(40, sortedArray));
    }

    @Test
    public void threeElementListTest() {
        List<Integer> sortedArray = new ArrayList<>();
        sortedArray.add(10);
        sortedArray.add(20);
        sortedArray.add(30);

        checkAllExistingElements(sortedArray);

        Assert.assertEquals(false, BinarySearch.binarySearch(35, sortedArray));
        Assert.assertEquals(false, BinarySearch.binarySearch(5, sortedArray));

        Assert.assertEquals(false, BinarySearch.binarySearch(15, sortedArray));
        Assert.assertEquals(false, BinarySearch.binarySearch(25, sortedArray));
    }

    private void checkAllExistingElements(List<Integer> sortedArray) {
        for (Integer value : sortedArray)
            Assert.assertEquals("Number not found: " + value + " in: " + sortedArray, true,
                    BinarySearch.binarySearch(value, sortedArray));

        sortedArray.forEach(value -> assertValue(sortedArray, value));
    }

    private void assertValue(List<Integer> sortedArray, Integer value) {
        Assert.assertEquals(true, BinarySearch.binarySearch(value, sortedArray));
    }

    @Test
    public void fiveElementListTest() {
        List<Integer> sortedArray = new ArrayList<>();
        sortedArray.add(10);
        sortedArray.add(20);
        sortedArray.add(30);
        sortedArray.add(40);
        sortedArray.add(50);

        checkAllExistingElements(sortedArray);

        Assert.assertEquals(false, BinarySearch.binarySearch(60, sortedArray));
        Assert.assertEquals(false, BinarySearch.binarySearch(5, sortedArray));

        Assert.assertEquals(false, BinarySearch.binarySearch(15, sortedArray));
        Assert.assertEquals(false, BinarySearch.binarySearch(25, sortedArray));
        Assert.assertEquals(false, BinarySearch.binarySearch(35, sortedArray));
        Assert.assertEquals(false, BinarySearch.binarySearch(45, sortedArray));
    }

    @Test
    public void genericTest() {
        int size = (int) (getRandomNumber(101));

        List<Integer> sortedArray = buildSortedList(size);
        checkAllExistingElements(sortedArray);
        long myProgramTime = 0;
        long javaProgramTime = 0;
        for (int i = 0; i < 1000000; i++) {
            int randomNumber = getRandomNumber(1000);

            long currentTime = System.nanoTime();
            boolean listFunctionResult = sortedArray.contains(randomNumber);
            javaProgramTime += System.nanoTime() - currentTime;

            currentTime = System.nanoTime();
            boolean myFunctionResult = BinarySearch.binarySearch(randomNumber, sortedArray);
            myProgramTime += System.nanoTime() - currentTime;
            Assert.assertEquals(listFunctionResult, myFunctionResult);
        }
        System.out.println("My Time is " + myProgramTime / 1000000 + " ms and Java Progeam Time is "
                + javaProgramTime / 1000000 + " ms");
    }

    private static int getRandomNumber(int size) {
        return (int) ((1000 * Math.random()) % size);
    }

    private static List<Integer> buildSortedList(int size) {
        Set<Integer> array = new HashSet<>();
        for (int i = 0; i < size; i++) {
            array.add(getRandomNumber(size));
        }
        List<Integer> arrayList = new ArrayList<>(array);
        Collections.sort(arrayList);
        return arrayList;
    }

}
