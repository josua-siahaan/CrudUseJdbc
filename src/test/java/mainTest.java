import org.example.Student;
import org.example.StudentDAO;
import org.junit.Test;

import static org.junit.Assert.*;

public class mainTest {
    private Student student = new Student("Siahaan", "Josua@Gmail", 17, "Kelas 2", 2);
    public StudentDAO studentDAO= new StudentDAO();

    @Test
    public void testCreateStudents(){
        studentDAO.addStudent(student);
        assertNotNull(student);
        assertEquals("Siahaan", student.getName());
        assertEquals("Josua@gmail", student.getEmail());
    }
    @Test
    public void testReadStudents(){
        studentDAO.getAllStudents();
        assertNotNull(studentDAO.getAllStudents());
    }
    @Test
    public void testDeleteStudents(){
        studentDAO.deleteStudent(1);
        assertNull(studentDAO.searchById(1));
    }
    @Test
    public void testUpdateStudents(){
        studentDAO.updateStudentById(1, "Siahaan", "Josua@Gmail", 17, "Kelas 2", 2);
        assertEquals(1, student.getId());
        assertEquals("Siahaan", student.getName());
        assertEquals("Josua@gmail.com", student.getEmail());
        assertEquals(17, student.getAge());
        assertEquals("Informatika", student.getMajor());
        assertEquals(3, student.getGpa());
    }

    @Test
    public void SearchByNameOrMajor(){
        studentDAO.searchByNameOrMajor("Siahaan", "Informatika");
        assertNotNull(studentDAO.searchByNameOrMajor("Siahaan", "Informatika"));
    }
}
