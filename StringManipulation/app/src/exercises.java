import java.util.Arrays;
import java.util.HashMap;

public class exercises {
    public void vowels(String string) {
        var vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (char ch : string.toCharArray()) {
            if(vowel.contains(ch)){
                count++;
            }
        }
        System.out.println(count);
    }

    public void reverse(String string) {
        String result = "";
        for (int i = string.length() - 1; i >=0; i--) {
            result = result + string.toCharArray()[i];
        }
        System.out.println(result);
    }

    public void reverseWord(String string) {
        
        int index = 0;
        string = string + " ";
        for (char ch : string.toCharArray()) {
            if(ch == ' '){
                index++;
            }
        }
        int start = 0;
        String[] strArr = new String[index];
        String insertString = "";
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ' '){
                insertString = string.substring(start, i);
                strArr[(index--) - 1] = insertString;
                start = i + 1;
            }
        }

        String result = "";
        for (String string2 : strArr) {
            index++;
            if(index == strArr.length){
                result = result + string2;
            }else{
                result = result + string2 + " ";
            }
            System.out.println(index);
        }
        System.out.println(result);
    }

    // check rotation with circular linked lists
    public boolean checkRotation(String string1, String string2) {
        for (char ch : string1.toCharArray()) {
            insert(ch);
        }
        var current = first;
        Node temp;
        while(true){
            if(current.ch == string2.charAt(0)){
                temp = current;
                break;
            }
            current = current.next;
        }
        for (char ch : string2.toCharArray()) {
            if(ch != temp.ch){
                return false;
            }
            temp = temp.next;
        }
        if(string1.length() != string2.length()){
            return false;
        }
        return true;
    }

    private Node first;
    private Node last;
    private class Node{
        char ch;
        Node next;

        public Node(char ch) {
            this.ch = ch;
        }
    }
    public void insert(char ch) {
        Node node = new Node(ch);
        if(first == null){
            first = last = node;
        }else{
            last.next = node;
            last = last.next;
        }
        last.next = first;
    }

    public String removeDuplicate(String string) {
        String result = "";
        for (char ch : string.toCharArray()) {
            if(!result.contains(String.valueOf(ch))){
                result = result + ch;
            }
        }
        return result;
    }
    public String removeSpace(String string) {
        String result = "";
        for (int i = 0; i< string.length() - 1; i++) {
            if(string.charAt(i) == ' ' && string.charAt(i + 1) == ' '){
                
            }else{
                result = result + string.charAt(i);
            }
        }
        if(string.charAt(string.length() - 1) != ' '){
            result = result + string.charAt(string.length() - 1);
        }
        return result;
    }

    // most repeated char with hash map
    public char mostRepeatedChar(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        String result = "";
        for (char ch : string.toCharArray()) {
            if(result.contains(String.valueOf(ch))){
                if(map.get(ch) != null){
                    map.put(ch, map.get(ch) + 1);
                }else{
                    map.put(ch, 1);
                }
            }
            result = result + ch;
        }
        int max = 0;
        char r = ' ';
        for (char count : map.keySet()) {
            if(map.get(count) > max){
                max = map.get(count);
                r = count;
            }
        }
        return r;
    }

    public String capitalize(String string) {
        string = removeSpace(string);
        String result = String.valueOf(string.charAt(0));
        for (int i = 1; i<string.length(); i++) {
            if(string.charAt(i - 1) == ' '){
                result +=String.valueOf(string.charAt(i)).toUpperCase();
            }else{
                result += string.charAt(i);
            }
        }

        return result;
    }

    public boolean anagram(String string, String string2) {
        if(string.length() != string2.length()){
            return false;
        }
        String result = "";
        for (char ch : string.toCharArray()) {
            for (char c : string2.toCharArray()) {
                if(ch == c){
                    result += ch;
                }
            }
        }
        
        return result.matches(string);
    }

    public boolean palindrome(String string) {
        int middle = string.length() % 2;
        int end = string.length() - 1;
        String left = "";
        String right = "";
        if(middle == 0){
            middle = string.length() / 2;
            for (int i = 0; i < string.length(); i++) {
                if(i < middle){
                    left += string.charAt(i);
                }else{
                    right += string.charAt(end--);
                }
            }
        }else{
            middle = string.length() / 2;
            for (int i = 0; i < string.length(); i++) {
                if(i > middle){
                    right += string.charAt(end--);
                }if(i < middle){
                    left += string.charAt(i);
                }
            }
        }
        return left.matches(right);
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length() &&
                (str1 + str1).contains(str2));
    }
}
