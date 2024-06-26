public class Counter {
    public static int charCount(String paragraph){
        return paragraph.replaceAll("[^a-zA-Z0-9]", "").length();
    }
    public static int charCountWithoutSpace(String paragraph){
        int counter = 0;
        for(int i = 0; i < paragraph.length(); i++){
            counter++;
        }
        return counter;
    }
    public static int wordCount(String paragraph){
        String[] words = paragraph.trim().split("\\s+");
        return words.length;
    }
}
