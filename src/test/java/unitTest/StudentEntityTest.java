package unitTest;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import studentEntity.StudentEntity;

public class StudentEntityTest {

	@Test
	public void testStudent() {

		StudentEntity student = new StudentEntity();

		student.setName("Hamad");
		student.setSurname("Ali");
		student.setEmail("hamad.ali@example.com");
		student.setMobile_no("1234567890");
		student.setAge("20");
		student.setGender("Male");
		assertEquals("expected Hamad correct", "Hamad", student.getName());
	}
}
