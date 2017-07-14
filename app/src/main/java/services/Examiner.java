package services;

import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by GABRIEL on 7/10/2017.
 */

public class Examiner
{
    private int mTotalMark;
    private ArrayList<String> mAnswers;

    public Examiner()
    {
        mTotalMark = 0;
        mAnswers = new ArrayList<>();
        setAnswers();
    }

    /** Returns the total mark obtained */
    public int getTotalMark()
    {
        return mTotalMark;
    }

    /** Seeds the {@code mAnswers} {@link ArrayList}*/
    private void setAnswers()
    {
        mAnswers.add("qpr");
        mAnswers.add("1996");
        mAnswers.add("michael owen");
        mAnswers.add("paul pogba");
        mAnswers.add("gareth bale");
    }

    /** Marks question with radio button options
     * @param selectedOption the option chosen by the user
     */
    public void evaluateRadioOption(@Nullable String selectedOption, @Nullable ArrayList<String> selectedOptions)
    {
        if (selectedOption != null && selectedOption.compareToIgnoreCase(mAnswers.get(0)) == 0)
            mTotalMark++;
        if (selectedOption != null && selectedOption.compareToIgnoreCase(mAnswers.get(2)) == 0)
            mTotalMark++;
        if (selectedOptions != null)
        {
            for (String option : selectedOptions)
            {
                if (option.compareToIgnoreCase(mAnswers.get(3)) == 0)
                    mTotalMark++;
                if (option.compareToIgnoreCase(mAnswers.get(4)) == 0)
                    mTotalMark++;
            }
        }
    }

    /** Marks the second question
     * @param answer the answer provided by the user
     */
    public void evaluateTextAnswer(String answer)
    {
        if (answer.equals(mAnswers.get(1)))
            mTotalMark++;
    }

    /*public void evaluateCheckedOption(ArrayList<String> selectedOptions)
    {

    }*/
}
