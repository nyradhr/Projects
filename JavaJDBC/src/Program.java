import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Program {

    public static final String URL = "jdbc:oracle:thin:BOOTCAMP/bootcamp@localhost:1521/XEPDB1";

    public static void main(String[] args) {
        //Iterable<Classroom> classes = getAllClassrooms();
        //Optional<Classroom> bad = badFindClassroomById("1");
        //System.out.println(bad.get());
        Optional<Classroom> good = findClassroomById("1");
        System.out.println(good.get());
        System.out.println(deleteClassroomById("1"));
        Classroom classroom = new Classroom("0", "Pippo", 100, "Pippo software", true, true, 80, false);
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static Classroom createClassroom(ResultSet rs) throws SQLException {
        String id = rs.getString("ID");
        String name = rs.getString("NAME");
        Integer capacity = rs.getInt("CAPACITY"); //nullable
        String platform = rs.getString("PLATFORM"); //nullable
        Boolean projector = rs.getBoolean("PROJECTOR"); //nullable
        Boolean teacher_pc = rs.getBoolean("TEACHER_PC"); //nullable
        Integer students_pc = rs.getInt("STUDENTS_PC"); //nullable
        boolean is_virtual = rs.getBoolean("IS_VIRTUAL");
        return new Classroom(id, name, capacity, platform, projector, teacher_pc, students_pc, is_virtual);
    }

    public static Iterable<Classroom> getAllClassrooms() {
        String query = "SELECT id, name, capacity, platform, projector, teacher_pc, students_pc, is_virtual FROM CLASSROOM";
        try(
                Connection c = createConnection(); //simple factory idiom
                Statement statement = c.createStatement(); // factory method DP
                ResultSet rs = statement.executeQuery(query); // factory method DP
        ) {
            List<Classroom> classes = new ArrayList<>();
            while(rs.next()) {
                Classroom classroom = createClassroom(rs);
                classes.add(classroom);
            }
            return classes;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //poor readability, sql injection, performance issues (multiple execution plans for similar queries)
    public static Optional<Classroom> badFindClassroomById(String id) {
        String query = "SELECT id, name, capacity, platform, projector, teacher_pc, students_pc, is_virtual " +
                "FROM CLASSROOM WHERE ID = "+id;
        try(
                Connection c = createConnection(); //simple factory idiom
                Statement statement = c.createStatement(); // factory method DP
                ResultSet rs = statement.executeQuery(query); // factory method DP
        ) {
            if(rs.next()) {
                Classroom cl = createClassroom(rs);
                Optional<Classroom> classroom = Optional.of(cl);
                return classroom;
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static Optional<Classroom> findClassroomById(String id) {
        String query = "SELECT id, name, capacity, platform, projector, teacher_pc, students_pc, is_virtual " +
                "FROM CLASSROOM WHERE ID = ?";
        try(
                Connection c = createConnection(); //simple factory idiom
                PreparedStatement statement = c.prepareStatement(query); // factory method DP

        ) {
            statement.setString(1, id);
            try(ResultSet rs = statement.executeQuery();) {
                if(rs.next()) {
                    Classroom cl = createClassroom(rs);
                    Optional<Classroom> classroom = Optional.of(cl);
                    return classroom;
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static boolean deleteClassroomById(String id) {
        String query = "DELETE FROM CLASSROOM WHERE ID = ?";
        try(
                Connection c = createConnection(); //simple factory idiom
                PreparedStatement statement = c.prepareStatement(query); // factory method DP
        ) {
            statement.setString(1, id);
            int rows = statement.executeUpdate();
            if(rows != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void insertClassroom(Classroom classroom) {
        String query = "INSERT INTO CLASSROOM (ID, NAME, CAPACITY, PLATFORM, PROJECTOR, " +
                "TEACHER_PC, STUDENTS_PC, IS_VIRTUAL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String idQuery = "SELECT CLASSROOM_SEQUENCE.NEXTVAL AS ID FROM DUAL";
        try(
                Connection c = createConnection(); //simple factory idiom
                Statement idStatement = c.createStatement(); // factory method DP
                ResultSet idRs = idStatement.executeQuery(idQuery);
                PreparedStatement statement = c.prepareStatement(query);
        ) {
            idRs.next();
            String id = idRs.getString("ID");
            statement.setString(1, classroom.getId());
            statement.setString(2, classroom.getName());
            statement.setInt(3,classroom.getCapacity());
            statement.setString(4,classroom.getPlatform());
            statement.setBoolean(5,classroom.getProjector());
            statement.setBoolean(6,classroom.getTeacher_pc());
            statement.setInt(7,classroom.getStudents_pc());
            statement.setBoolean(8,classroom.isIs_virtual());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static boolean updateClassroom(Classroom classroom) {
        String query = "UPDATE CLASSROOM SET NAME = ?, CAPACITY = ?, PLATFORM = ?, PROJECTOR = ?, TEACHER_PC = ?," +
                " STUDENTS_PC = ?, IS_VIRTUAL = ?";
        try(
                Connection c = createConnection();
                PreparedStatement statement = c.prepareStatement(query);
        ) {
            statement.setString(1, classroom.getName());
            statement.setInt(2,classroom.getCapacity());
            statement.setString(3,classroom.getPlatform());
            statement.setBoolean(4,classroom.getProjector());
            statement.setBoolean(5,classroom.getTeacher_pc());
            statement.setInt(6,classroom.getStudents_pc());
            statement.setBoolean(7,classroom.isIs_virtual());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }


}
