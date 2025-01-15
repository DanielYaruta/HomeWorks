package Java_ClassesObjectsFirstProgram.Java5HW;

public class LetterCount {
    public static void main(String[] args) {

        String inputText = "Введите текст";

        int result = countLetterE(inputText);
        System.out.println("Количество буквы 'е': " + result);
    }

        public static int countLetterE(String text) {
            int letterCount = 0;

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (ch == 'е' || ch == 'Е') {
                    letterCount++;
                }
            }
            return letterCount;
        }
    }
