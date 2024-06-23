package studentException;


@SuppressWarnings("serial")
public class StudentException extends RuntimeException {
    public StudentException(String id) {
        super("Student with id " + id + " not found");
    }

}
