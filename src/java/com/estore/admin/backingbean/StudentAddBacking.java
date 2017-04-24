/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.estore.model.Student;
import com.estore.service.StudentService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author A.M.S.Madhuwanthi
 */
@Named(value = "studentAddBacking")
@ViewScoped
public class StudentAddBacking {

   @EJB
   StudentService studentService;
   
   @Named
    @Produces
    @RequestScoped
   
   Student student = new Student ();

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
   
    /**
     *
     * @return
     */
    public String createStudent()
    {
        studentService.addNewStudent(student);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(student.getFirstName()+" " +student.getLastName()+" Saved Successfully"));
      clear ();
        return null;
       
        
    }
    public void clear()
    {
        student.setFirstName("");
        student.setLastName("");
    }
}
