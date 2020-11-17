// Q. 1. Write a JAVA Program to construct the BITS student id (as a single String) from the
// following details read from the user. Also print the bits email id of the student.
// i) Year,
// ii) Discipline (CHEM - A1, EEE-A3, MECH-A4, CS-A7 )
// iii) Assume only PS/TS
// iv) Campus (Pilani P. Hyderabad H, Goa G, Dubai U).
// v) The 3 digit no can a non-zero random no. generated using the class Random
// Input: Year = 2014 Discipline = CS PS/TS = PS Campus = Dubai ( can be 1 of Pilani,
// Hyderabad, Goa, or Dubai)
// Output: 2014A7PS001U f2014001@dubai.bits-pilani.ac.in
// Input: Year = 2014 Discipline = MECH PS/TS = TS Campus = Pilani ( can be 1 of Pilani,
// Hyderabad, Goa, or Dubai)
// Output: 2014AAPS001P f2014001@pilani.bits-pilani.ac.in 2019A7PS0245U
import java.util.Scanner;

import java.util.Arrays;
class BitStudents{
    private String id;
    private String year;
    private String rollNo;
    private String discipline;
    private String email;
    private String campus;
    
    public BitStudents(String id){
        this.id = id;
        this.year = id.substring(0, 4);
        setDiscipline(id.substring(4, 6)) ;
        rollNo = id.substring(8, 12);
        setcampus(id.substring(12));
        email = "f" + year + rollNo + "@" + campus + ".bits-" + campus+ ".ac.in" ;
        




    }
    void setDiscipline(String a){
        if(a.equalsIgnoreCase("A7"))
        discipline = "CS";
        else if(a.equalsIgnoreCase("A4"))
        discipline = "MECH";
        else if(a.equalsIgnoreCase("AA"))
        discipline = "ECE";
        else if(a.equalsIgnoreCase("A9"))
        discipline = "Bio Tech";
        else if(a.equalsIgnoreCase("A1"))
        discipline = "CHEM";
        else if(a.equalsIgnoreCase("A3"))
        discipline = "EEE";


    }
    void setcampus(String a){
        if(a.equalsIgnoreCase("U"))
        campus = "dubai";
        else if(a.equalsIgnoreCase("G"))
        campus = "goa";
        else if(a.equalsIgnoreCase("P"))
        campus = "pilani";
        else if(a.equalsIgnoreCase("H"))
        campus = "hyderabad";
        else
        campus = "dontknow";
    }
    void display(){
        System.out.print("id: " + id + "\n roll no: " + rollNo + " year: " + year+ "  Discipline: " + discipline + "  Campus: " + campus + "  email: " + email +"\n\n");
    }
    public static void main(String args[]){
        String a = "2019A7PS0245U";
        BitStudents b = new BitStudents(a);
        b.display();
    }



}