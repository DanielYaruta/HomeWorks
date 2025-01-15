package Java_ClassesObjectsFirstProgram.Java5HW;

public class RemoveLettersAndSpaces {
    public static void main(String[] args) {

        String inputText = "Enter your text \uD83D\uDE09";

        String result = removeLettersAndSpaces(inputText);
        System.out.println("Результат: " + result);
    }

    public static String removeLettersAndSpaces(String input) {
        return input.replaceAll("[a-zA-Z\\s]", "");
    }
}
