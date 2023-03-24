package Student_Project_management;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String gender;
    float stadywage;
    float hours;

    Student() {
    }

    Student(int id, String name, String gender, float stadywage, float hours) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.stadywage = stadywage;
        this.hours = hours;
    }

    float findStudent() {
        return hours * stadywage;
    }

    void outputInformation() {
        System.out.println("---------------------------------");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Gender :" + gender);
        System.out.println("Salary : " + findStudent() + "$");
    }

    void inputInformation(Scanner input) {
        boolean isIDValid = false;
        do {
            String strId;
            System.out.println("Enter ID : ");
            try {
                strId = input.next();
                id = Integer.parseInt(strId);
                isIDValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid ID format!! (Integer only! )");
            }
        } while (!isIDValid);

        System.out.println("Enter Name : ");
        input.nextLine();
        name = input.nextLine();
        System.out.println("Enter Gender : ");
        gender = input.nextLine();
        System.out.println("Enter hours : ");
        hours = input.nextFloat();
        System.out.println("Enter StudyWage : ");
        stadywage = input.nextFloat();

    }

}

public class Main {
    static void pressEnterKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ========================Press Enter to continue========================");
        scanner.nextLine();
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("--------------- Student System ------------------");
            System.out.println("1. Insert new Student ");
            System.out.println("2. Update Student information ");
            System.out.println("3. Remove Student profile");
            System.out.println("4. Select Student profile");
            System.out.println("5. Show Student information ");
            System.out.println("6. Exit");

            String strOption;
            System.out.print(">>> Choose option from 1 - 5 : ");
            strOption = input.nextLine();
            try {
                option = Integer.parseInt(strOption);
            } catch (Exception ex) {
                option = 0;
                System.out.println("Invalid Input !!!");
            }


            switch (option) {
                case 1:
                    System.out.println("------------- Add New Student------------- ");
                    Student newStudent = new Student();
                    newStudent.inputInformation(input);
                    students.add(newStudent);
                    System.out.println("Successfully added.....!");
                    input.nextLine();
                    break;
                case 2 :
                    System.out.println("Update Informatioin");
                    System.out.println("Enter ID for Update :");
                    int IdUpdate = input.nextInt();
                    boolean ischeck=false;
                    if (students.size()>0){
                        for (Student student:students){
                            if (student.id == IdUpdate){
                                System.out.println("Enter the new ID :");
                                student.id=input.nextInt();
                                System.out.println("Enter the new Name :");input.nextLine();
                                student.name = input.nextLine();
                                System.out.println("Enter the new Gender :");
                                student.gender= input.nextLine();
                                System.out.println("Enter the new studyWage :");
                                student.stadywage = input.nextInt();
                                System.out.println("Enter the new Hours :");
                                student.hours = input.nextInt();
                                ischeck=true;
                            }
                        }
                    }
                    if (!ischeck){
                        System.out.println("Data not font for Update!!");
                    }
                    break;
                case 3 :
                    System.out.println("Remove Student by Id ");
                    System.out.println("Enter ID Student for remove :");
                    int idremove = input.nextInt();
                    System.out.println(idremove);
                    boolean isFount =false;

                    for (int i = 0; i<students.size();i++){
                        if (students.get(i).id==idremove){
                            students.remove(i);
                            isFount=true;
                        }
                    }
                    if (!isFount){
                        System.out.println("ID id not fount!!");
                    }
                    break;

                case 4 :
                    int searchOption;
                    System.out.println("************ Search Student***********");
                    System.out.println("1. Search By ID ");
                    System.out.println("2. Search By Name ");
                    System.out.println("3. Exit....");

                    System.out.print("Choose option 1 - 3 : ");
                    searchOption = input.nextInt();
                    switch(searchOption){
                        case 1 :
                            int searchID;
                            boolean isStudentExist = false;
                            System.out.println("*********** Search By ID *********** ");
                            System.out.println("Enter ID to search : ");
                            searchID = input.nextInt();

                            for(int i = 0; i < students.size(); i++){
                                if(searchID== students.get(i).id){
                                    // worker exist
                                    isStudentExist = true;
                                    students.get(i).outputInformation();
                                }
                            }
                            if(!isStudentExist){
                                System.out.println("Student with ID = "+searchID+" doesn't exist !!!");
                            }
                            pressEnterKey();
                            break;
                        case 2 :
                            boolean isUserExist = false;
                            System.out.println("*********** Search By Name *********** ");
                            String searchName ;
                            System.out.println("Enter name to search : ");input.nextLine();
                            searchName = input.nextLine();

                            for(int i =0; i < students.size(); i++){
                                if(searchName.equals(students.get(i).name)){
                                    // user exist
                                    isUserExist = true;
                                    students.get(i).outputInformation();
                                }
                            }
                            if(!isUserExist) {
                                System.out.println("Worker with ID = " + searchName + " doesn't exist !!!");
                            }
                    }
                    input.nextLine();
                    break;
                case 5:
                    System.out.println("------------- Show Student information ------------- ");
                    for (int i = 0; i < students.size(); i++) {
                        students.get(i).outputInformation();
                    }
                    break;

                case 6:
                    System.out.println("Exit the program...!!");
                    break;
//                default:
//                    System.out.println("Wrong option !! ");  break;
            }
        } while (option != 6);

    }
}
