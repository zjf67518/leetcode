public class sqrt {
    // 保留7位小数
    public static void main(String[] args) {
        System.out.println(sqrNum(4));
    }

    public static double sqrNum(int n) {
        double left = 1, right = n;
        while (right - left >= 1e-7) {
            double m = (left + right) / 2;
            if (m*m > n) {
                right = m;
            } else {
                left = m;
            }
        }
        return right;
    }
}
