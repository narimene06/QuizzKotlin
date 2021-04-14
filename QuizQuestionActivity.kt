package com.example.Quiz

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuizQuestionActivity : AppCompatActivity() {

    private var mCurrentPositon: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList = Constants.getQuestions()
        setQuestion()
        tv_option_One.setOnClickListener(this)
        tv_option_Two.setOnClickListener(this)
        tv_option_Three.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    @SuppressLint(...value"setTextI18n")
    private fun setQuestion() {

        val question = mQuestionList!!.get(mCurrentPositon-1)
        defaulOptionsView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_submit.text="finish"
        }
        else{
            btn_submit.text="submit"
        }
        progressBar.progress = mCurrentPositon
        tv_progress.text = "$mCurrentPositon" + "/" + progressBar.max
        tv_question.text = question.question
        tv_Option_One.text = question.optionOne
        tv_Option_Two.text = question.optionTwo
        tv_Option_Three.text = question.optionThree
    }

    override fun OnClick(v: View){
        when(v.id){
            R.id.tv_option_one->{
                selectedOption(tv_option_one,selectedOptionNum:1)
            }
            R.id.tv_option_two->{
                selectedOption(tv_option_two,selectedOptionNum:2)
            }
            R.id.tv_option_three->{
                selectedOption(tv_option_three,selectedOptionNum:3)
            }

            R.id.btn_submit->{
                if(mSelectedOptionPosition == 0){
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }
                        else->{
                            Toast.makeText(
                                    context: this,
                            text:"vous avez bien terminer la partie",Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent( packageContext: this,MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    else{
                        val question = mQuestionlist?.get(mCurrentPosition-1)
                        if(question!!.correctOption != mSelectedOptionPosition){
                            answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                        }
                        answerView(question.correctOption,R.drawable.correct_option_border_bg)
                        if(mCurrentPosition == mQuestionList!!.size){
                            btn_submit.text ="finish"
                        }
                        else{
                            btn_submit.text = "Next Question"
                        }
                       run{
                           mSelectedOptionPosition=0
                       }
                    }
                }
            }
        }
    }
    private fun defaulOptionsView(){
        val options = ArrayList<TextView>()
        options.add(index 0,tv_option_one)
        options.add(index 1,tv_option_Two)
        options.add(index 2,tv_option_Three)
        for(option in options){
            option.setTextColor(Color.paseColor(colorstring:"#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    context: this,
                    R.drawable.default_option_border_bg
            )
    }

    }

    private fun selectedoptionView(tv: TextView, selectedOptionNum: Int){

        defaulOptionsView()
        mselectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parsColor(colorString:"#363A43"))
        tv.setTypeface(tv.typeface.BOLD)
        tv.background = ContextCompat.getDrawable(context: this,
        R.drawable.selected_option_border_bg)
    }
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1-> {
                tv_option_one.backgroud = ContextCompat.getDrawable(context: this,drawableView)
            }
            2-> {
                tv_option_Two.backgroud = ContextCompat.getDrawable(context: this,drawableView)
            }
            3-> {
                tv_option_Three.backgroud = ContextCompat.getDrawable(context: this,drawableView)
            }
        }
    }
}
