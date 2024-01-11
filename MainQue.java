package question_bank;

import java.sql.*;
import java.util.Scanner;
import java.util.List;
public class MainQue{
    static Scanner sc=new Scanner(System.in);
    //static String actualPW;
    static QuestionService service=new Question_Implementation();
    public static void main(String[] args) {

        System.out.println("Enter choice \n1:Add Question\n2:Remove Question\n3:Update Question\n4:Display All Question\n5:Take Test\n exit");
        int a=sc.nextInt();
        if(a<5){
            System.out.println("Enter password");
            String pw=sc.next();
            if(!pw.equals("Kaju@123")){
               System.exit(0);
           }
         /*  try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","tiger");
            String q="select password from mypw";
            Statement stmt= con.createStatement();
                ResultSet set= stmt.executeQuery(q);
               String actualPW= set.getString(1);
                if(!pw.equals(actualPW)){
                    System.exit(0);
                }

        }catch(Exception e){
                System.out.println(e);
            }*/


        }
        switch (a){
            case 1:
               addQuestion();
                break;
            case 2:
                 removeQuestion();
                break;
            case 3:
          // updateQuestion();
                break;
            case 4:
                displayAllQuestion();
                break;
            case 5:
            takeTest();
                break;
            default:
                System.out.println("Invalid Input");}
                main(args);
        }
        static void takeTest(){
        List<Question> questionList=service.getAllQuestion();
        int mark=0;
            System.out.println("Ready for test");
            String ans=sc.nextLine();
            for(Question q:questionList){
                System.out.println("Q"+q.getQue_id()+"."+q.getQue());
                System.out.println("1. "+q.getOpt_I());
                System.out.println("2. "+q.getOpt_II());
                System.out.println("3. "+q.getOpt_III());
                System.out.println("Enter Your Answer....");
                ans=sc.nextLine();
                String actualAns=q.getAns();
                if (ans.equals(actualAns)){
                    mark+=5;
                }
                else{
                    mark-=2;
                }
            }
            System.out.println("\n\n\n----------------------------------");
            System.out.println("UR Total Marks: "+mark);
            System.out.println("----------------------------------------------------");
            System.exit(0);
        }
        static void displayAllQuestion(){
        List <Question>questionList=service.getAllQuestion();
        for(Question q:questionList){
            System.out.println("Q"+ q.getQue_id()+". "+q.getQue() );
            System.out.println("1. "+ q.getOpt_I());
            System.out.println("2. "+ q.getOpt_II());
            System.out.println("3. "+ q.getOpt_III());
            System.out.println("-----> "+ q.getAns());
            System.out.println("\n-------------------------------------\n");
        }
        }
    public static void addQuestion()
    {
        System.out.println("ENTER QUESTION -->");
        String que = sc.nextLine() ;
        que = sc.nextLine() ;
        System.out.println("ENTER OPTION 1 ");
        String opt_I = sc.nextLine() ;
        System.out.println("ENTER OPTION 2 ");
        String opt_II = sc.nextLine() ;
        System.out.println("ENTER OPTION 3 ");
        String opt_III = sc.nextLine() ;
        System.out.println("ENTER ANSWER ");
        String ans = sc.nextLine() ;
        Question newQuestion = new Question(que , opt_I , opt_II , opt_III , ans);
        int n = service.addQuestion(newQuestion);
        System.out.println(n+" RECORD INSERTED !!");
        System.out.println("\n\n");

    }
    public static void removeQuestion()
    {
        System.out.println("ENTER THE QUESTION ID ");
        int que_id = sc.nextInt() ;
        int n = service.removeQuestion(que_id);
        System.out.println(n + "RECORD DELETED ");
        System.out.println("\n\n");
    }
    public static void updateQuestion() throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb");
        System.out.println("Insert question id which you want to update ");
        int id=sc.nextInt();
        String q="update que_info set que=?,opt_I=?,opt_II=?,opt_III=?,ans=? where que_id=?";
        PreparedStatement pstmt = con.prepareStatement(q);
        System.out.println("Insert Question");
        String que=sc.nextLine();
        que=sc.nextLine();
        System.out.println("Insert OptI");
        String optI= sc.nextLine();
        System.out.println("Insert OptII");
        String optII=sc.nextLine();
        System.out.println("Insert OptIII");
        String optIII=sc.nextLine();
        System.out.println("Insert Ans");
        String ans=sc.nextLine();
        pstmt.setString(1,que);
        pstmt.setString(2,optI); pstmt.setString(3,optII); pstmt.setString(4,optIII);
        pstmt.setString(5,ans);
        pstmt.setInt(6,id);
        pstmt.executeUpdate();
    }

}