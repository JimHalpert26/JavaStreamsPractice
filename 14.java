import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.stream.*;

/*
 * Question Link -> https://leetcode.com/problems/longest-common-prefix/
 */



class Solution {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		// Basic Integer Stream
		IntStream.range(1, 10)
            .forEach(System.out::print);
		System.out.println();
        System.out.println();

		// Integer Stream with skip
		IntStream.range(1, 10)
            .skip(5)
            .forEach(x -> System.out.println(x));
        System.out.println();

        // Integer Stream with sum
        System.out.println(IntStream.
            range(1, 5)
            .sum());
        System.out.println();

        // Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
            .sorted()
            .findFirst()
            .ifPresent(System.out::println);
        System.out.println();

        // Stream from Array, sort, filter and then print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", 
                          "Hans", "Shivika", "Sarah"};
        Arrays.stream(names) // same as Stream.of(names)
            .filter(x -> x.startsWith("S"))
            .sorted()
            .forEach(System.out::println);
        System.out.println();

        // Average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
            .map(x -> x * x)
            .average()
            .ifPresent(System.out::println);
        System.out.println();

        // Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", 
                        "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people.stream()
            .map(String::toLowerCase)
            .filter(x -> x.startsWith("a"))
            .forEach(System.out::println);
        System.out.println();

        // stream rows from text file, sort, filter and print
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands.sorted()
            .filter(x -> x.length() > 13)
            .forEach(System.out::println);
        bands.close();
        System.out.println();

        // stream rows from text file and save to List
        List<String> bands2 = Files.lines(Paths.get("bands.txt"))
            .filter(x -> x.contains("jit"))
            .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));
        System.out.println();

        // stream rows from csv file and count
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int)rows1.map(x -> x.split(","))
                            .filter(x -> x.length == 3)
                            .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
        System.out.println();

        // stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
        rows2.map(x -> x.split(","))
            .filter(x -> x.length == 3)
            .filter(x -> Integer.parseInt(x[1]) > 15)
            .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();
        System.out.println();

        // stream rows in CSV file, store fields in a HashMap
        Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                    x -> x[0], 
                    x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key : map.keySet())
            System.out.println(key + " " + map.get(key));
        System.out.println();

        // Reduction - Sum
        double total = Stream.of(7.3, 1.5, 4.8)
                        .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);
        System.out.println();

        // Reduction - Summary Statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                                        .summaryStatistics();
        System.out.println(summary);
	}   
}
