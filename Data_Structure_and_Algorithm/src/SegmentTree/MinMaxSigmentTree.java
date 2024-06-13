package SegmentTree;

import com.sun.source.tree.BreakTree;

public class MinMaxSigmentTree {
    static int tree[];
    public static void init(int n){
        tree = new int[n*2];
    }
    public static void buildST(int arr[], int i, int si, int sj){
        if (si==sj){
            tree[i] = arr[si];
            return;
        }
        int mid = (si+sj)/2;
        buildST(arr,2*i+1,si, mid);
        buildST(arr,2*i+2,mid+1,sj);
        tree[i] = Math.max(tree[2*i+1],tree[2*i+2]);

    }
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj){
        if (qi>sj || qj<si){
            return Integer.MIN_VALUE;
        } else if (si>=qi && sj<=qj) {
            return tree[i];
        } else {
            int mid = (si+sj)/2;
            int leftAns = getMaxUtil(2*i+1,si,mid,qi,qj);
            int rightAns = getMaxUtil(2*i+2,mid+1,sj,qi,qj);
            return Math.max(leftAns,rightAns);
        }
    }
    public static int getMax(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaxUtil(0,0,n-1,qi,qj);
    }
    public static int updateUtil(int i, int si, int sj, int idx, int newVal){
        if (idx<si || idx>sj){
            return Integer.MIN_VALUE;
        }
        if (si == sj){
            tree[i] = newVal;
        }
        if (si != sj){
            tree[i] = Math.max(tree[i], newVal);
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        }
        return tree[0];
    }
    public static int update(int arr[], int idx, int newVal){
        int n = arr.length;
        arr[idx] = newVal;

        return updateUtil(0,0,n-1,idx,newVal);
    }
    public static void main(String args[]){
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildST(arr,0,0,n-1);

//        for (int i=0; i<tree.length; i++){
//            System.out.print(tree[i]+" ");
//        }
//        System.out.println();

        System.out.println(getMax(arr,2,5));
        System.out.println(update(arr,2,20));
    }
}
