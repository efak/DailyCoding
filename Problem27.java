import java.util.Stack;

/**
 * Given a string of round, curly, and square open and closing brackets, return
 * whether the brackets are balanced (well-formed).
 * 
 * For example, given the string "([])[]({})", you should return true.
 * 
 * Given the string "([)]" or "((()", you should return false.
 */
 
class Problem27 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        //convert string to char array
        char[] strArray = s.toCharArray();

        for(char c: strArray){
            switch(c){
                case '[':{
                    stack.push(c);
                    break;
                }
                case '(':{
                    stack.push(c);
                    break;
                }
                case '{': {
                    stack.push(c);
                    break;
                }
                case ']':{
                    if( stack.isEmpty()){
                        return false;
                    }
                    
                    if(stack.pop() != '['){
                        return false;
                    }
                    break;
                }
                case ')':{
                    if( stack.isEmpty()){
                        return false;
                    }
                    
                    if(stack.pop() != '('){
                        return false;
                    }
                    break;
                }
                case '}': {
                    if( stack.isEmpty()){
                        return false;
                    }
                    
                    if(stack.pop() != '{'){
                        return false;
                    }
                    break;
                }
            }
        }

        return stack.isEmpty();
        
    }
}
