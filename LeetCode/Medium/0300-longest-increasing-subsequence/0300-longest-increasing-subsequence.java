class Solution {
    public static int insert(List<Integer> arr, int num) {
        int index = Collections.binarySearch(arr, num);
        if (index < 0) {
            index = -index - 1;
        }
        return index;
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int index = insert(list, num);
            if (index == list.size()) {
                list.add(num);
            } else {
                list.set(index, num);
            }
        }
        return list.size();
    }
}