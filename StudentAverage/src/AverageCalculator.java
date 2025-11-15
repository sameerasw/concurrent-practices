import java.util.concurrent.Callable;

public class AverageCalculator implements Callable<Double> {
    private Student student;

    public AverageCalculator(Student student) {
        this.student = student;
    }

    @Override
    public Double call() throws Exception {
        int[] marks = student.getMarks();
        int sum = 0;

        if(marks.length == 0){
            return 0.0;
        }

        for (int i = 0; i < marks.length; i++){
            sum += marks[i];
        }

        return (double) sum/marks.length;
    }
}
