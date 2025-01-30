
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamHW {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(61, 404, 13, 24, 502, 61, 75, 86, 24, 99);
        List<String> words = Arrays.asList("mitsubishi", "Audi", "Mercedes-Benz", "Citroen", "Porsche", "Mazda");

        System.out.println("Unique elements: " + removeDuplicates(numbers));
        System.out.println("Number of words beginning with 'm': " + countWords(words, w -> w.toLowerCase().startsWith("m")));
        System.out.println("Second largest element: " + findSecondLargest(numbers).orElseThrow(() -> new RuntimeException("No second largest element!")));
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static long countWords(List<String> words, Predicate<String> condition) {
        return words.stream()
                .filter(condition)
                .count();
    }

    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }
}
