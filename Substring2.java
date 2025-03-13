import java.util.*;

public class Substring2 {
    String[] strs;

    public Substring2(String[] strs) {
        this.strs = strs;
    }

    public String find() {
        if(strs.length <= 1) {
            return null;
        }
        
        String shortest = shortestString();
        List<String> list = deleteShortestString(shortest);
        String substring = findFirstSubstring("", list, shortest);
        if(substring.length() <= 1) {
            return null;
        }
        int i = 0;
        while(i < list.size()) {
            if(list.get(i).contains(substring)) {
                list.remove(i);
                //i++;
            } else {

                return findFirstSubstring("", list, substring);
            }
        }
        return substring;
    }

    public String findFirstSubstring(String substring, List<String> list, String shortest) {
        String compareString = list.get(0);
        int i = 0;
        int j = 0;

        while(i < shortest.length()) {
            while(j < compareString.length()) {
                if(shortest.charAt(i) == compareString.charAt(j)) {
                    substring += shortest.charAt(i);
                    if(i < shortest.length()-1) {
                        i++;
                        j++;
                    } else {
                        list.remove(0);
                        return substring;
                    }
                    
                } else {
                    if(substring.length() > 0) {
                        if(substring.length() == 1) {
                            return null;
                        }
                        return substring;
                    } else {
                        j++;
                    }
                }
            }
            j = 0;
            i++;
        }
        list.remove(0);
        return substring;
    }

    public List<String> deleteShortestString(String shortest) {
        List<String> newList = new ArrayList<String>();
        for(int i = 0; i < strs.length; i++) {
            newList.add(strs[i]);
        }
        newList.remove(shortest);
        return newList;
    }

    public String shortestString() {
        String shortest = strs[0];
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].length() < shortest.length()) {
                shortest = strs[i];
            }
        }
        return shortest;
    }
}