public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 9, 10, 3, 1, 5, 2};
        int[] sortArr = Sort.quick(arr, 0, arr.length - 1);
        for (int x : sortArr) {
            System.out.println(x);
        }
    }
}

class Sort {
    // 인접한 원소 끼리 자리 바꾸기
    public static int[] bubble(int[] arr) {
        int len = arr.length;
        while (len > 0) {
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            len--;
        }
        return arr;
    }

    // 최솟값, 혹은 최댓값 찾아 맨앞으로 넣기
    public static int[] select(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    idx = j;
                }
            }
            if (i != idx) {
                arr[idx] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }

    // 자신앞에 있는 원소들과 비교해 적절한 곳에 넣기
    public static int[] insert(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    // 피벗 값을 기준으로 왼, 오 스왑
    // 최적 NlogN, 최악 N^2
    public static int[] quick(int[] arr, int s, int e) {
        if (s >= e) {
            return arr;
        }

        int l = s + 1;
        int r = e;

        while (l <= r) {
            while (l <= e && arr[l] <= arr[s]) {
                l++;
            }

            while (r > s && arr[r] >= arr[s]) {
                r--;
            }

            if (l > r) {
                int temp = arr[s];
                arr[s] = arr[r];
                arr[r] = temp;
                break;
            } else {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        quick(arr, s, r - 1);
        quick(arr, r + 1, e);

        return arr;
    }

}