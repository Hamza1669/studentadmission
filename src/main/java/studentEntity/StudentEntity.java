package studentEntity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
@Entity
@Table(name = "StudentAdmission")
public class StudentEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    private String name;
    private String surname;
    private String email;
    private String Mobile_no;
    private String age;
    private String gender;
		
    	
		public String getId() {
		return id;
		}
		public void setId(String id) {
		this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile_no() {
			return Mobile_no;
		}
		public void setMobile_no(String mobile_no) {
			this.Mobile_no = mobile_no;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}		
	
		public StudentEntity() {
			super();
		}
		
		public StudentEntity(String id, String name, String surname, String email, String mobile_no, String age, String gender) {
			super();
			this.id = id;
			this.name = name;
			this.surname = surname;
			this.email = email;
			this.Mobile_no = mobile_no;
			this.age = age;
			this.gender = gender;	
			
		}
}
