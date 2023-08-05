package org.pg4200.ex08.partE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PartEMain {
    public static void main(String[] args) {

        ArrayList<Course> courses = new PartETest().generateCourses(5);
        ArrayList<Student> students = new PartETest().generateStudents(100,courses);
        ArrayList<DiplomaProject> projects = new PartETest().generateDiplomaProjs(50, students);

        System.out.println(passingProjects(courses.get(0), projects));
        
    }
    
    public static boolean hasTakenClass(ArrayList<Student> students, Course course){
        for (Student currStudent : students) {
            if (!currStudent.courseList.containsKey(course)) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean hasPassedCourse(ArrayList<Student> students, Course course){
        for (Student currStudent : students) {
            Integer grade = currStudent.courseList.get(course);
            if(grade < 2){
                return false;
            }
        }
        return true;
    }

    static List<String> passingProjects(Course course, ArrayList<DiplomaProject> projects){
        return projects.stream()
                .filter(project -> hasTakenClass(project.authors, course))
                .filter(project -> hasPassedCourse(project.authors, course))
                .map(project -> project.title)
                .distinct()
                .collect(Collectors.toList());

    }
}
