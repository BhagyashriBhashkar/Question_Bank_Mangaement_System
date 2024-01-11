package question_bank;

public class Question {
    private int que_id ;
    private String que;
    private String opt_I;
    private String opt_II;
    private String opt_III ;
    private String ans;

    public Question() {
    }

    public Question(String que, String opt_I, String opt_II, String opt_III, String ans) {
        this.que_id = que_id;
        this.que = que;
        this.opt_I = opt_I;
        this.opt_II = opt_II;
        this.opt_III = opt_III;
        this.ans = ans;
    }

    public int getQue_id() {
        return que_id;
    }

    public void setQue_id(int que_id) {
        this.que_id = que_id;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getOpt_I() {
        return opt_I;
    }

    public void setOpt_I(String opt_I) {
        this.opt_I = opt_I;
    }

    public String getOpt_II() {
        return opt_II;
    }

    public void setOpt_II(String opt_II) {
        this.opt_II = opt_II;
    }

    public String getOpt_III() {
        return opt_III;
    }

    public void setOpt_III(String opt_III) {
        this.opt_III = opt_III;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

}
