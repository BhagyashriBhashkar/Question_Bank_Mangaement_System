package question_bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Question_Implementation implements QuestionService{
    static Connection conn ;
    static {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "tiger";
        try {
            conn = DriverManager.getConnection(url , username , password);
        } catch (SQLException e) {
            System.err.println("CONNECTION UNSUCCESSFUL !! ");
            System.exit(1);
        }
    }
    @Override
    public int addQuestion(Question newQuestion) {
        String insertQuery = "INSERT INTO que_info(que, opt_I , opt_II, opt_III  , ans)" +
                "VALUES (? , ? , ? , ? , ?) ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1 , newQuestion.getQue());
            pstmt.setString(2 , newQuestion.getOpt_I());
            pstmt.setString(3 , newQuestion.getOpt_II());
            pstmt.setString(4 , newQuestion.getOpt_III());
            pstmt.setString(5 , newQuestion.getAns());
            return pstmt.executeUpdate() ;
        } catch (SQLException e) {
            System.err.println("INVALID QUESTION DATA !!");
        }
        return 0 ;
    }
    @Override
    public int removeQuestion(int questionId) {
        String deleteQuery = "DELETE FROM QUE_INFO WHERE QUE_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1 , questionId);
            return  pstmt.executeUpdate() ;
        } catch (SQLException e) {
            System.err.println("INVALID QUESTION ID ");
        }
        return 0;
    }

    @Override
    public List<Question> getAllQuestion() {
        String selectQuery= "select * from que_info" ;
        List<Question> questionList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement() ;
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()){
                Question q = new Question();
                q.setQue_id(rs.getInt(1));
                q.setQue( rs.getString(2));
                q.setOpt_I( rs.getString(3));
                q.setOpt_II( rs.getString(4));
                q.setOpt_III( rs.getString(5));
                q.setAns(rs.getString(6));

                questionList.add(q);
            }
        } catch (SQLException e) {

        }

        return questionList ;


    }
}
