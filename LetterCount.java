package Java_ClassesObjectsFirstProgram.Java5HW;

public class LetterCount {
    public static void main(String[] args) {

        String inputText = "Введите текст";

        int result = countLetters(inputText);
        System.out.println("Количество букв: " + result);
    }

        public static int countLetters(String text) {
            int count = 0;

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (Character.isLetter(ch)) {
                    count++;
                }
            }
            return count;
        }
    }
