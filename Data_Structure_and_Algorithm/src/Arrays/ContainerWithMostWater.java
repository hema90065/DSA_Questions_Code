package Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int area = 0;

        while (l < r)
        {
            // Calculating the max area
            area = Math.max(area,
                    Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r])
                l += 1;

            else
                r -= 1;
        }
        return area;
    }
    public static void main(String args[]){
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
