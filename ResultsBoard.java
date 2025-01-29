package JavaCoreCollection.Java4;

import java.util.*;
import java.util.stream.Collectors;

public class ResultsBoard {

    private TreeMap<Double, List<Student>> studentScores;

    public ResultsBoard() {
        studentScores = new TreeMap<>(Collections.reverseOrder());
    }

    public void addStudent(String name, Double score) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The student's name cannot be blank!");
        }
        if (score == null || score < 0 || score > 5) {
            throw new IllegalArgumentException("The score should be between 0 and 5!");
        }

        studentScores.computeIfAbsent(score, k -> new ArrayList<>()).add(new Student(name, score));
    }

    public List<Student> getTop3() {
        return studentScores.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .sorted(Comparator.comparing(Student::score, Comparator.reverseOrder())
                        .thenComparing(Student::name))
                .limit(3)
                .collect(Collectors.toList());
    }

    public void printTop3() {
        List<Student> top = getTop3();
        if (top.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }

        System.out.println("Top 3 students:");
        for (int i = 0; i < top.size(); i++) {
            System.out.println((i + 1) + ". " + top.get(i));
        }
    }

    public static void main(String[] args) {

        ResultsBoard board = new ResultsBoard();

        board.addStudent("Anna Karenina", 4.2);
        board.addStudent("Sonya Marmeladova", 3.8);
        board.addStudent("Natasha Rostova", 4.7);
        board.addStudent("Grigory Pechorin", 4.5);
        board.addStudent("Tatiana Larina", 4.9);
        board.addStudent("Eugene Onegin", 4.7);

        board.printTop3();
    }

    record Student(String name, Double score) implements Comparable<Student> {
        @Override
        public int compareTo(Student other) {
            int scoreComparison = other.score.compareTo(this.score);
            if (scoreComparison != 0) {
                return scoreComparison;
            }
            return this.name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return name + " - " + score;
        }
    }
}