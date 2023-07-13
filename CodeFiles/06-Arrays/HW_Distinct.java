public class HW_Distinct 
{

    public static boolean distinct_element(int nums[])
    {
        int n = nums.length;

        for(int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++) 
            {
                if(nums[i] == nums[j])
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) 
    {
        int nums[] = {1,2,3,4};
        int nums1[] = {1,2,3,1};
        int nums2[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(distinct_element(nums));
        System.out.println(distinct_element(nums1));
        System.out.println(distinct_element(nums2));
    }   
}
