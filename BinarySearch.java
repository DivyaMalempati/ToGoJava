import java.util.List;

class BinarySearch {
    static boolean binarySearch(int numberToBeSearched, List<Integer> sortedArray) {
        // System.out.println("Searching " + numberToBeSearched + " in: " +
        // sortedArray);
        if (sortedArray.isEmpty()) {
            return false;
        }
        int startIndex = 0;
        Integer startValue = sortedArray.get(startIndex);
        if (sortedArray.size() == 1) {
            return startValue == numberToBeSearched;
        }

        int endIndex = sortedArray.size() - 1;
        Integer endValue = sortedArray.get(endIndex);
        if ((startValue == numberToBeSearched) || (endValue == numberToBeSearched)) {
            return true;
        } else if (sortedArray.size() == 2) {
            return false;
        }

        int midIndex = sortedArray.size() / 2;
        Integer midValue = sortedArray.get(midIndex);
        if (numberToBeSearched == midValue) {
            return true;
        }
        if ((numberToBeSearched < startValue) || (numberToBeSearched > endValue)) {
            return false;
        } else if ((numberToBeSearched > startValue) && (numberToBeSearched < midValue)) {
            return binarySearch(numberToBeSearched, sortedArray.subList(startIndex + 1, midIndex));
        }
        return binarySearch(numberToBeSearched, sortedArray.subList(midIndex + 1, endIndex));
    }

}