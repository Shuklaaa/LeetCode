class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        
        for (char it : s.toCharArray()){
            if(it == '(' ||  it == '{' || it == '['){
                st.push(it);
            }
            else{
                if(st.isEmpty()){ //it means for an opening bracket it does not have any closing bracket
                    return false;
                }
                
                char c = st.pop();
                if((it == ')' && c == '(') || (it == '}' && c == '{') || (it == ']' && c == '[')){
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