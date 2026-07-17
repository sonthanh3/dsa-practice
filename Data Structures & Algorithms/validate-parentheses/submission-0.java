class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.add(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                if(c == ')'){
                    if(st.pop() != '('){
                        return false;
                    }
                }else if (c == '}'){
                    if(st.pop() != '{'){
                        return false;
                    }
                }else{
                    if(st.pop() != '['){
                        return false;
                    }
                }    
            }
        }
        return st.isEmpty();
    }
}