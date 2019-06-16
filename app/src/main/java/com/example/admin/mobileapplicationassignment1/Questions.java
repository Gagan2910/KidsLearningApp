package com.example.admin.mobileapplicationassignment1;

public class Questions {
    private int questionID;
    private String question;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private int answerNo;
    private String quizName;

    public Questions(int questionID, String question, String option1, String option2, String option3, String option4, int answerNo, String quizName) {
        this.questionID = questionID;
        this.question = question;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        this.answerNo = answerNo;
        this.quizName = quizName;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public int getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(int answerNo) {
        this.answerNo = answerNo;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
}
