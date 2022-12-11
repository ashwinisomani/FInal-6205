
//Solution - 3
public class MinimumNumberOfParentheses {
    public static void main(String[] args) {
        MinimumNumberOfParentheses removeMinimal = new MinimumNumberOfParentheses();
        String input1 = "lee(t(c)o)de)";
        System.out.println("input1 = "+ input1);
        String output1 = removeMinimal.minimumRemovalToMakeValid(input1);
        System.out.println("output1 = "+output1);
        String input2 ="a)b(c)d";
        System.out.println("input2 = "+ input2);
        String output2 = removeMinimal.minimumRemovalToMakeValid(input2);
        System.out.println("output2 = "+output2);
        String input3 ="))((";
        System.out.println("input3 = "+ input3);
        String output3 = removeMinimal.minimumRemovalToMakeValid(input3);
        System.out.println("output3 = "+output3);
        if(output3.isEmpty()) System.out.println(output3 +"is an empty String");

    }
    public StringBuilder minimumRemoval(CharSequence s , char open , char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if (c == open) {
                balance++;
            }

            if (c == close) {
                if(balance == 0) continue;
                balance--;
            }

            sb.append(c);
        }
        return sb;
    }

    public String minimumRemovalToMakeValid(String s){
        StringBuilder result = minimumRemoval(s, '(' , ')');
        result = minimumRemoval(result.reverse(), ')' , '(');
        return result.reverse().toString();
    }

}


//Time Complexity = O(n)
//Space Complexity = O(n)




