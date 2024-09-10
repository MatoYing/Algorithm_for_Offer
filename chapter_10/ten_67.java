package chapter_10;

/*
* 421. 数组中两个数的最大异或值
* */
public class ten_67 {

    TrieNode root = new TrieNode();

    /**
     周六不想写。
     在找左边与其异或最大的值时，使用字典树维护左边的数（每个数32位对应字典树的32层）
     从高位开始枚举当前数的每一位：
     若为0，则需找左边所有数中对应位为1的数；（使每一位异或值最大，若未找到，则只能选该位为0的数）
     若为1，则需找左边所有数中对应位为0的数；

     为啥时间复杂度会小于n方
     因为有些同一层，一个为1一个为0，为1的就不用比了。
     */
    public int findMaximumXOR(int[] nums) {
        int ans = Integer.MIN_VALUE;
        // 枚举两个数右边的
        for (int i = 0; i < nums.length; i++) {
            TrieNode curr = root;
            // 在其前面的数中找异或最大值（前面的数用字典树维护）
            for (int j = 0; j < 32; j++) {
                // 从当前元素最高位开始取当前元素每一位
                int bit = (nums[i] >> (31 - j)) & 1;
                if (curr.children[1 - bit] != null) {
                    // 若字典树中存在与 1-bit 节点使得该位异或结果最大
                    curr = curr.children[1 - bit];
                } else if (curr.children[bit] != null) {
                    // 若字典树中不存在与 1-bit 节点，则找 bit 节点
                    curr = curr.children[bit];
                } else {
                    // 字段树无元素，则val设置为nums[i]，使计算结果时nums[i]^val = 0
                    curr.val = nums[i];
                    break;
                }
            }
            ans = Math.max(ans, nums[i] ^ curr.val);
            // 将 nums[i] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            insert(nums[i]);
        }
        return ans;
    }

    public void insert(int value) {
        TrieNode curr = root;
        for (int i = 0; i < 32; i++) {
            int bit = (value >> (31 - i)) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
        curr.val = value;
    }

    class TrieNode {
        // 因为只可能0或1
        TrieNode[] children = new TrieNode[2];
        int val;
    }
}
