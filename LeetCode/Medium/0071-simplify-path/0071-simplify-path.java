class Solution {
    public static String simplify(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } 
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else {
                stack.push(part);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
    public String simplifyPath(String path) {
        return simplify(path);
    }
}