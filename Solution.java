class Solution {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if(target >= nums[0] && target <= nums[left - 1]){
            return binSearch(nums, 0, left, target);
        }
        return binSearch(nums, left, nums.length, target);
    }

    public static int binSearch(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(search(new int[]{3,1}, 3));
    }
}
