import java.util.*;

//Solution-1
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        var result = GroupAnagrams.groupAnagrams(strs);
        System.out.println(result.toString());
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s:strs){
            char[] character = s.toCharArray();
            Arrays.sort(character);
            String newString =new String(character);
            if(map.containsKey(newString)){
                List<String> temp = map.get(newString);
                temp.add(s);
                map.put(newString,temp);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(newString,temp);
            }
        }
        for(String s : map.keySet()){
            List<String> tem= map.get(s);
            res.add(tem);
        }
        return res;
    }
}


//Time Complexity = O(nlogn) // because we used Arrays.sort function
//space complexity = O(nlogn) // because we used Arrays.sort function
