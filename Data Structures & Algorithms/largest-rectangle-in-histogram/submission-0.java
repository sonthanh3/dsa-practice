class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++){
            int h;
            if(i == heights.length) h = 0;
            else h = heights[i];
        
            while(!st.isEmpty() && h < heights[st.peek()]){
                int height = heights[st.pop()];
                int w;

                if(st.isEmpty()) w = i;
                else w = i - st.peek() - 1;

                maxArea = Math.max(maxArea, height * w);
            }
            st.push(i);    
        }   
        return maxArea;
    }
}
