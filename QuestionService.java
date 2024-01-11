package  question_bank;

import java.util.List;

public interface QuestionService {
    int addQuestion(Question newQuestion);
    int removeQuestion(int que_id);
    List<Question> getAllQuestion();

}