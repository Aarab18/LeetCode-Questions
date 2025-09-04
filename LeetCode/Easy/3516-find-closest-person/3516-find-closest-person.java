class Solution {
    public int findClosest(int x, int y, int z) {
        while(x!=z && y!=z) {
            if(x==z && y==z) {
                return 0;
            }
            else if(x==z) {
                return 1;
            }
            else if(y==z) {
                return 2;
            }
            x=x>z?x-1:x+1;
            y=y>z?y-1:y+1;
        }
        if(x==z && y==z) {
            return 0;
        }
        else if(x==z) {
            return 1;
        }
        else if(y==z) {
            return 2;
        }
        return 0;
    }
}