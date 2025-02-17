package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        System.out.println("Selamat datang di daftar siswa");
        Scanner scanner = new Scanner(System.in);
        String pilihLagi;
        while (true){
            try {
                System.out.println("Selamat datang di daftar siswa");
                System.out.println("1. Create Student");
                System.out.println("2. Read All Student");
                System.out.println("3. Update Student By Id");
                System.out.println("4. Delete Student By Id");
                System.out.println("5. Find Student By Id");
                System.out.println("5. Find Student By Name Or By Major");
                System.out.println("0. Exit\n");
                System.out.print("Masukkan pilihan Anda : ");
                int pilihan = scanner.nextInt();
                switch (pilihan){
                    case 1:
                        System.out.print("Masukkan nama student : ");
                        String nameIn = scanner.nextLine();
                        System.out.print("Masukkan nama email : ");
                        String emailIn = scanner.nextLine();
                        System.out.print("Masukkan Age student : ");
                        int ageIn = scanner.nextInt();
                        System.out.print("Masukkan Major student : ");
                        String majorIn = scanner.nextLine();
                        System.out.print("Masukkan GPA student : ");
                        int gpaIn = scanner.nextInt();
                        Student student = new Student(nameIn, emailIn, ageIn, majorIn, gpaIn);
                        studentDAO.addStudent(student);
                        break;
                    case 2:
                        studentDAO.getAllStudents();
                        break;
                    case 3:
                        System.out.print("Masukkan id student : ");
                        int idChange = scanner.nextInt();
                        System.out.print("Masukkan nama student : ");
                        String nameChange = scanner.nextLine();
                        System.out.print("Masukkan nama email : ");
                        String emailChange = scanner.nextLine();
                        System.out.print("Masukkan Age student : ");
                        int ageChange = scanner.nextInt();
                        System.out.print("Masukkan Major student : ");
                        String majorChange = scanner.nextLine();
                        System.out.print("Masukkan GPA student : ");
                        int gpaChange = scanner.nextInt();
                        studentDAO.updateStudentById(idChange, nameChange, emailChange, ageChange, majorChange, gpaChange);
                        break;
                    case 4:
                        System.out.println("Masukkan id Student yang ingin di hapus !");
                        int idDelete = scanner.nextInt();
                        studentDAO.deleteStudent(idDelete);
                        break;
                    case 5:
                        System.out.print("Masukkan nama student yang ingin dicari : ");
                        String nameSearch = scanner.nextLine();
                        System.out.print("Masukkan major student yang ingin dicari : ");
                        String majorSearch = scanner.nextLine();
                        studentDAO.searchByNameOrMajor(nameSearch, majorSearch);
                    case 0:
                        return;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                        return;
                }
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Apakah ingin pilih lagi (y/n) : ");
                pilihLagi = scanner1.nextLine().toLowerCase();
                if (!pilihLagi.equalsIgnoreCase("y")){
                    System.out.println("Terimkasih!, Program berhenti");
                    scanner.close();
                    return;
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }
}