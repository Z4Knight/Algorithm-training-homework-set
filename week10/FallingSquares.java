class Solution {
    SegmentTree root = new SegmentTree(0, 0);

    //记下最终子线段
    List<SegmentTree> list;

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result = new ArrayList<>();
        //记下最大值
        int max = 0;
        for (int[] p : positions) {
            //线段的起点终点
            int start = p[0], end = p[0] + p[1];
            list = new ArrayList<>();
            //当前线程加上后的高度最大值
            int tmpMax = build(root, start, end, p[1], false);
            //更新当前线段的分段的高谨防
            list.forEach(it -> it.height = tmpMax);
            //记下结果
            max = Math.max(max, tmpMax);
            result.add(max);
        }
        return result;
    }

    //分别表示当前节点，起点，终点，高度和是否是子线段
    public int build(SegmentTree node, int start, int end, int height, boolean inner) {
        //当前的基线，当是子线段时高度需要加上基线，否则为0
        int base = 0;
        //放在当前节点的子线段下
        if (inner) {
            //子线段为空，那么直接放进去即可
            if (node.inner == null) {
                node.inner = new SegmentTree(start, end);
                node.inner.height = node.height + height;
                //将节点记下以便更新最终值
                list.add(node.inner);
                return node.inner.height;
            }
            //基线高度为父线段高度
            base = node.height;
            //指向子节点
            node = node.inner;
        }
        while (true) {
            //起点大于当前的终点
            if (start >= node.end) {
                //如果右边为空，那么放在右边，同时记下节点以便更新最大值
                if (node.right == null) {
                    node.right = new SegmentTree(start, end);
                    node.right.height = height + base;
                    list.add(node.right);
                    return node.right.height;
                } else {
                    //指向当前的右节点
                    node = node.right;
                }
            } else if (end <= node.start) {
                //同理
                if (node.left == null) {
                    node.left = new SegmentTree(start, end);
                    node.left.height = height + base;
                    list.add(node.left);
                    return node.left.height;
                } else {
                    node = node.left;
                }
            } else {
                int max;
                //当前线段与原来的有重合，那么可以分成四种情况，取最大值返回即可
                if (start < node.start) {
                    if (end < node.end) {
                        int n1 = build(node, start, node.start, height, false), n2 = build(node, node.start, end, height, true);
                        max = Math.max(n1, n2);
                    } else {
                        int n1 = build(node, start, node.start, height, false), n2 = build(node, node.start, node.end, height, true),
                                n3 = build(node, node.end, end, height, false);
                        max = Math.max(n1, Math.max(n2, n3));
                    }
                } else {
                    if (end < node.end) {
                        max = build(node, start, end, height, true);
                    } else {
                        int n1 = build(node, start, node.end, height, true), n2 = build(node, node.end, end, height, false);
                        max = Math.max(n1, n2);
                    }
                }
                return max;
            }
        }
    }

    class SegmentTree {
        //线段的起点，终点和高度
        int start, end, height;
        //左右子节点和中间重叠部分
        SegmentTree left, right, inner;

        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
