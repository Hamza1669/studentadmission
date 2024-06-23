package com.student_admission.studentadmission;

import org.springframework.boot.SpringApplication;

public class TestStudentadmissionApplication {

	public static void main(String[] args) {
		SpringApplication.from(StudentadmissionApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
