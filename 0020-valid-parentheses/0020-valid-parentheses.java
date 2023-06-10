class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){ //it means for an opening bracket it does not have any closing bracket
                    return false;
                }
                
                char c = st.pop();
                if((s.charAt(i) == ')' && c == '(') || (s.charAt(i) == '}' && c == '{') || (s.charAt(i) == ']' && c == '[')){
                    continue;
            }
                else{
                    return false;
                }
        }
    }
        return st.isEmpty();
}
}