package org.example;

import java.sql.*;
import java.util.List;

public class StudentDAO {
    public void addStudent(Student student) {
        String sql = "INSERT INTO Students (name, email, age, major, gpa) VALUES (?, ?, ?, ?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getMajor());
            pstmt.setInt(5, student.getGpa());

            pstmt.executeUpdate();
            System.out.println("Student berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT id, name, email, age, major, gpa FROM Students";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                String major = rs.getString("major");
                int gpa = rs.getInt("gpa");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Age: " + age);
                System.out.println("Major: " + major);
                System.out.println("GPA: " + gpa);
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student updateStudentById(int id, String name, String email, int age, String major, int gpa) {
        String sql = "UPDATE products SET name = ?, email = ?, age = ?, major = ?, gpa = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.setString(4, major);
            pstmt.setInt(5, gpa);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Produk berhasil diperbarui.");
            } else {
                System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM Students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student berhasil dihapus.");
            } else {
                System.out.println("Student dengan ID " + studentId + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Student> searchByNameOrMajor(String searchName, String searchMajor) {
        try (Connection conn = DatabaseConnection.getConnection()){
            String sql = "SELECT * FROM Students WHERE name LIKE ? OR major LIKE ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, "%" + searchName + "%");
                pstmt.setString(2, "%" + searchMajor + "%");
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        // Ambil data dari hasil query
                        int id = rs.getInt("id");
                        String email = rs.getString("email");
                        int age = rs.getInt("age");
                        int gpa = rs.getInt("gpa");
                        // Tampilkan data atau lakukan operasi lain sesuai kebutuhan
                        System.out.println("ID: " + id);
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Email : " + email);
                        System.out.println("age: " + age);
                        System.out.println("Major: " + rs.getString("major"));
                        System.out.println("GPA: " + gpa);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student searchById(int idStudent) {
        try (Connection conn = DatabaseConnection.getConnection()){
            String sql = "SELECT * FROM Students WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idStudent);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        // Ambil data dari hasil query
                        int id = rs.getInt("id");
                        String email = rs.getString("email");
                        int age = rs.getInt("age");
                        int gpa = rs.getInt("gpa");
                        // Tampilkan data atau lakukan operasi lain sesuai kebutuhan
                        System.out.println("ID: " + id);
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Email : " + email);
                        System.out.println("age: " + age);
                        System.out.println("Major: " + rs.getString("major"));
                        System.out.println("GPA: " + gpa);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

