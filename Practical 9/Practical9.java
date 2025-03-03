public class Practical9 {

    static double computeIterativeFactorial(long num) {
        long product = 1;
        double totalDuration = 0;
        for (long i = num; i > 0; i--) {
            double startTime = System.nanoTime();
            product *= i;
            double endTime = System.nanoTime();
            totalDuration += (endTime - startTime);
        }
        return totalDuration;
    }

    static long computeRecursiveFactorial(long num) {
        if (num == 0) {
            return 1;
        }
        return num * computeRecursiveFactorial(num - 1);
    }

    static String combineString(String str) {
        return str + (System.nanoTime() % 10);
    }

    static StringBuffer appendToStringBuffer(StringBuffer buffer) {
        return buffer.append(System.nanoTime() % 10);
    }

    static StringBuilder appendToStringBuilder(StringBuilder builder) {
        return builder.append(System.nanoTime() % 10);
    }

    public static void main(String[] args) {
        long iterativeFactorialAvg = 0;
        long recursiveFactorialAvg = 0;
        long stringConcatAvg = 0;
        long stringBufferAvg = 0;
        long stringBuilderAvg = 0;

        int arraySize = Integer.parseInt(args[0]);

        for (int trial = 0; trial < 100; trial++) {
            double iterativeFactorialTime = 0;
            double recursiveFactorialTime = 0;
            long[] values = new long[arraySize];

            for (int i = 0; i < arraySize; i++) {
                values[i] = System.nanoTime() % 10;
            }

            for (int i = 0; i < arraySize; i++) {
                iterativeFactorialTime += computeIterativeFactorial(values[i]);
            }

            for (int i = 0; i < arraySize; i++) {
                double start = System.nanoTime();
                long result = computeRecursiveFactorial(values[i]);
                double end = System.nanoTime();
                recursiveFactorialTime += (end - start);
            }

            iterativeFactorialAvg += iterativeFactorialTime / arraySize;
            recursiveFactorialAvg += recursiveFactorialTime / arraySize;

            String text = "";
            double stringConcatTime = 0;
            for (int i = 0; i < arraySize; i++) {
                double start = System.nanoTime();
                text += (System.nanoTime() % 10);
                double end = System.nanoTime();
                stringConcatTime += (end - start);
            }
            stringConcatAvg += stringConcatTime / arraySize;

            double bufferAppendTime = 0;
            StringBuffer buffer = new StringBuffer("");
            for (int i = 0; i < arraySize; i++) {
                double start = System.nanoTime();
                buffer = appendToStringBuffer(buffer);
                double end = System.nanoTime();
                bufferAppendTime += (end - start);
            }
            stringBufferAvg += bufferAppendTime / arraySize;

            double builderAppendTime = 0;
            StringBuilder builder = new StringBuilder("");
            for (int i = 0; i < arraySize; i++) {
                double start = System.nanoTime();
                builder = appendToStringBuilder(builder);
                double end = System.nanoTime();
                builderAppendTime += (end - start);
            }
            stringBuilderAvg += builderAppendTime / arraySize;
        }

        System.out.println("Average time for iterative factorial: " + iterativeFactorialAvg / 10);
        System.out.println("Average time for recursive factorial: " + recursiveFactorialAvg / 10);
        System.out.println("Average time for string concatenation: " + stringConcatAvg / 10);
        System.out.println("Average time for StringBuffer append: " + stringBufferAvg / 10);
        System.out.println("Average time for StringBuilder append: " + stringBuilderAvg / 10);
    }
}
