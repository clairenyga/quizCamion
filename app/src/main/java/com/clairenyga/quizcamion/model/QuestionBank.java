package com.clairenyga.quizcamion.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    public int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;
        mNextQuestionIndex = 0;
    }

    public Question getQuestion() {
        // Ensure we loop over the questions
        if (mNextQuestionIndex == mQuestionList.size()) {
            mNextQuestionIndex = 0;
        }

        // Please note the post-incrementation
        return mQuestionList.get(mNextQuestionIndex++);
    }
    public int getNextQuestionIndex(){
        return mNextQuestionIndex;
    }

    public void setNextQuestionIndex(int nextQuestionIndex) {
        mNextQuestionIndex = nextQuestionIndex;
    }
}

