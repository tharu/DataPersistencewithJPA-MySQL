package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repo.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


@SpringBootApplication()
@EntityScan("edu.mum.cs.cs425.studentmgmt.model") 
@ComponentScan("edu.mum.cs.cs425.studentmgmt.*")
public class StudentMgmtApp1Application implements CommandLineRunner{
	
	@Autowired()
	StudentRepository studentRepository;


	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("student-and-transcript");
//	        EntityManager em = emf.createEntityManager();
//	        EntityTransaction transaction = em.getTransaction();

	        try {
//	            transaction.begin();

	            // Create a new Transcript
	            Transcript transcript = new Transcript();
	            transcript.setDegreeTitle("BS Computer Science");

	            // Create a new Student and associate it with the Transcript
	            Student student = new Student(1,"614625","Tharu","Manickavasagar",4.0,LocalDate.of(2016, 7, 6));
	            student.setTranscript(transcript);

	            // Persist the Student (which will cascade to the Transcript)
	          //  em.persist(student);
	            
	            
	            Classroom classroom= new Classroom("MC Laughin","M101");
	            List<Classroom> classroomList=new ArrayList<>();
	            classroomList.add(classroom);
	            student.setClassroomList(classroomList);
	            
	            studentRepository.save(student);

	            //transaction.commit();
	        } catch (Exception e) {
//	            if (transaction != null && transaction.isActive()) {
//	                transaction.rollback();
//	            }
//	            e.printStackTrace();
	        } finally {
//	            em.close();
//	            emf.close();
	        }
	    }		
	

}
