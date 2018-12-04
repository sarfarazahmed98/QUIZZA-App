package com.example.lenovo.quizza;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    List<Question> questionList;
    int score = 0;
    int quid = 0;
    Intent intent;
    String sname;
    Question currentQuestion;

    TextView txtQuestion;
    RadioButton rda,rdb,rdc;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sname=getIntent().getStringExtra("name");

        DbHelper dbHelper = new DbHelper(this);
        questionList = dbHelper.getAllQuestions();
        Collections.shuffle(questionList);
        currentQuestion = questionList.get(quid);

        txtQuestion = (TextView)findViewById(R.id.question);
        rda = (RadioButton)findViewById(R.id.radio0);
        rdb = (RadioButton)findViewById(R.id.radio1);
        rdc = (RadioButton)findViewById(R.id.radio2);
        butNext = (Button)findViewById(R.id.button1);
        setQuestionView();

    }

    private void setQuestionView(){
        txtQuestion.setText(currentQuestion.getQuestion());
        rda.setText(currentQuestion.getOptA());
        rdb.setText(currentQuestion.getOptB());
        rdc.setText(currentQuestion.getOptC());
        quid++;
    }

    public void btClick(View view){
        RadioGroup grp = (RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
        if(currentQuestion.getAnswer().equals(answer.getText())){
            score++;
            Log.d("Score", "Your score: "+score);
        }
        if(quid==9){
            butNext.setText("SUBMIT");
            butNext.setBackgroundColor(Color.parseColor("#000066"));
        }
        if(quid<10 ){
            currentQuestion = questionList.get(quid);
            setQuestionView();
        }else{
            intent = new Intent(QuestionActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            intent.putExtra("name",sname);
            startActivity(intent);
            finish();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_quit) {
            intent = new Intent(QuestionActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            intent.putExtra("name",sname);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

