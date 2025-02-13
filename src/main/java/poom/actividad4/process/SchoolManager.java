package poom.actividad4.process;
import poom.actividad4.models.Student;
import poom.actividad4.models.Subject;
import poom.actividad4.models.Teacher;
import poom.actividad4.models.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SchoolManager {
    public static Map<Course, List<Subject>> CourseMap = new HashMap<>();
    public static Map<Teacher, List<Subject>> TeacherMap = new HashMap<>();
    public static Map<Course, Teacher> CourseTeacherMap = new HashMap<>();
    public static Map<Course, List<Student>> StudentCourseMap =new HashMap<>();
    public static Map<Subject, List<Subject>> SubjectMAp = new HashMap<>();
    public static List<Subject> SubjectList = new ArrayList<>();

    public static void enrollTeacher(Teacher teacher){
        teacherMap.put(teacher, new ArrayList<>());
    }
}
