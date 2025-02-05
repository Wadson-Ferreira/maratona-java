package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RunTimeExceptionTest01 {
    public static void main(String[] args) {
        // Checked e Uncheked

        Object object = null;
        System.out.println(object.toString());

        int[] nums = {1,2};
        System.out.println(nums[2]);
    }
}
