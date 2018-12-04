package com.example.lenovo.quizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    //DB version, table and database name
    private static final int DB_VERSION = 6;
    private static final String DB_NAME = "quizdb";
    private static final String DB_TABLE1 = "quiztable";
    private static final String DB_TABLE2 = "squiztable";
    private static final String DB_TABLE3 = "equiztable";

    //table column names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "optA";
    private static final String KEY_OPTB = "optB";
    private static final String KEY_OPTC = "optC";

    private SQLiteDatabase dbase;
    private int rowCount = 0;

    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE2);
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE3);
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE1, KEY_ID, KEY_QUES, KEY_ANSWER, KEY_OPTA, KEY_OPTB, KEY_OPTC);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);
        db.execSQL(sqlQuery);
        addQuestions();
        String sqlQuery2 = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE2, KEY_ID, KEY_QUES, KEY_ANSWER, KEY_OPTA, KEY_OPTB, KEY_OPTC);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery2);
        db.execSQL(sqlQuery2);
        addSQuestions();
        String sqlQuery3 = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE3, KEY_ID, KEY_QUES, KEY_ANSWER, KEY_OPTA, KEY_OPTB, KEY_OPTC);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery3);
        db.execSQL(sqlQuery3);
        addEQuestions();
    }

    private void addQuestions() {
        Question q1 = new Question("Which company is the largest manufacturer of network equipment ?", "HP", "IBM", "CISCO", "CISCO");
        this.addQuestionToDB(q1);
        Question q2 = new Question("Which of the following is NOT an operating system ?", "Linux", "BIOS", "DOS", "BIOS");
        this.addQuestionToDB(q2);
        Question q3 = new Question("Who is the founder of Apple Inc. ?", "Jose Thomas", "Bill Gates", "Steve Jobs", "Steve Jobs");
        this.addQuestionToDB(q3);
        Question q4 = new Question("Google and NASA have joined hands to identify which two new planets around distant stars?","Kepler 80g, Kepler 90i","Kepler 90g, Kepler 80i","Kepler 81g, Kepler 90i","Kepler 80g, Kepler 90i");
        this.addQuestionToDB(q4);
        Question q5 = new Question("Scientists have developed a new battery material based in _______ with charging speed 5 times faster than lithium-ion batteries.","Carbon","Graphene","Chromium","Graphene");
        this.addQuestionToDB(q5);
        Question q6 = new Question("Which asteroid is causing the Dec 15, 2017 Geminid meteor shower display?","3200 Helios","3200 Phobos","3200 Phaethon","3200 Phaethon");
        this.addQuestionToDB(q6);
        Question q7 = new Question("India was declared free from trachoma which is a ___________ infection of the eye.","Viral","Fungal","Bacterial","Bacterial");
        this.addQuestionToDB(q7);
        Question q8 = new Question("A new form of matter has been discovered named excitonium by whom?","Bert Halper","Bert Walper","Bert Kelper","Bert Halper");
        this.addQuestionToDB(q8);
        Question q9 = new Question("As per PRL Ahmedabad scientists, which type of storms can flow towards the earth and disturb the atmosphere?","Thermal","Solar","Wind","Solar");
        this.addQuestionToDB(q9);
        Question q10 = new Question("Researchers have discovered a way to make an artificial muscle for which organ?","Kidney","Heart","Liver","Heart");
        this.addQuestionToDB(q10);
        Question q11 = new Question("India has reduced new malaria cases by what percent?","55","25","75","75");
        this.addQuestionToDB(q11);
        Question q12 = new Question("The India Indian Space Research Organisation (ISRO) is set to launch first solar mission in 2019. What is it called?","SuryaNamaskar-L1","Aditya-L1","Surya-L1","Aditya-L1");
        this.addQuestionToDB(q12);
        Question q13 = new Question("China launched world's first fully electric cargo ship in Guangzhou. What type of battery does it use?","Lead acid","Lithium ion","Nickel metal hydride","Lithium ion");
        this.addQuestionToDB(q13);
        Question q14 = new Question("Which artificial protein is being said to block cancer cells and birth defects?","G Protein","C Protein","T Protein","G Protein");
        this.addQuestionToDB(q14);
        Question q15 = new Question("Which Indian nuclear capable land attack cruise missile was successfully tested with a strike range of 1000 km?","Agni","Nag","Nirbhay","Nirbhay");
        this.addQuestionToDB(q15);
        Question q16 = new Question("Which is the first bot to write horror stories developed by MIT Media Lab?","Shelley","Poe","Edgar","Shelley");
        this.addQuestionToDB(q16);
        Question q17 = new Question("Who invented washing machine?", "James King", "Alfred Vincor", "Christopher Marcossi", "James King");
        this.addQuestionToDB(q17);
        Question q18 = new Question("What is another name for visceral leishmaniasis?","TB","Kala azar","Dengue","Kala azar");
        this.addQuestionToDB(q18);
        Question q19 = new Question("Which planet was discovered by NASA's MAVEN to have a twisted magnetic tail?","Mars","Neptune","Saturn","Mars");
        this.addQuestionToDB(q19);
        Question q20 = new Question("India has declared 2010-2020 as the decade of _________.","Invention","Modernisation","Innovation","Innovation");
        this.addQuestionToDB(q20);

    }

    public void addQuestionToDB(Question q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, q.getQuestion());
        values.put(KEY_ANSWER,q.getAnswer());
        values.put(KEY_OPTA,q.getOptA());
        values.put(KEY_OPTB,q.getOptB());
        values.put(KEY_OPTC,q.getOptC());
        dbase.insert(DB_TABLE1, null, values);
    }

    public List <Question> getAllQuestions(){
        List <Question> questionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE1;
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));

                questionList.add(q);

            }while (cursor.moveToNext());
        }
        return questionList;
    }

    private void addSQuestions() {
        Question q1 = new Question("Who won the Football world Cup in 2014 ?", "Italy", "Argentina", "Germany", "Germany");
        this.addQuestionToDB2(q1);
        Question q2 = new Question("Who is the first cricketer to score an international double century in 50-over match ?", "Ricky Ponting", "Sachin Tendulkar", "Brian Lara", "Sachin Tendulkar");
        this.addQuestionToDB2(q2);
        Question q3 = new Question("Who won the Cricket World cup in 2011 ?", "Australia", "India", "England", "India");
        this.addQuestionToDB2(q3);
        Question q4 = new Question("Which was the 1st non Test playing country to beat India in an international match?","Canada","Sri Lanka","Zimbabwe","Sri Lanka");
        this.addQuestionToDB2(q4);
        Question q5 = new Question("Which county did Ravi Shastri play for?","Glamorgan","Leicestershire","Gloucestershire","Glamorgan");
        this.addQuestionToDB2(q5);
        Question q6 = new Question("Who was the first Indian to win the World Amateur Billiards title?","Geet Sethi","Wilson Joness","Michael Ferreira","Wilson Jones");
        this.addQuestionToDB2(q6);
        Question q7 = new Question("Who is the first Indian woman to win an Asian Games gold in 400m run?","K.Malleshwari","P.T.Usha","Kamaljit Sandhu","Kamaljit Sandhu");
        this.addQuestionToDB2(q7);
        Question q8 = new Question("Ricky Ponting is also known as what?","Punter","Ponter","The Rickster","Punter");
        this.addQuestionToDB2(q8);
        Question q9 = new Question("How long are professional Golf Tour players allotted per shot?","25 seconds","45 seconds","1 minute","45 seconds");
        this.addQuestionToDB2(q9);
        Question q10 = new Question("India won its first Olympic hockey gold in...?","1928","1932","1936","1928");
        this.addQuestionToDB2(q10);
        Question q11 = new Question("Who won the 1993 'King of the Ring'?","Owen Hart","Bret Hart","Edge","Bret Hart");
        this.addQuestionToDB2(q11);
        Question q12 = new Question("In which year did Milkha Singh win the first National title in the 400 m race?","1955","1956","1957","1957");
        this.addQuestionToDB2(q12);
        Question q13 = new Question("In which Indian state did the game of Polo originate?","Rajasthan","Manipur","Meghalaya","Manipur");
        this.addQuestionToDB2(q13);
        Question q14 = new Question("Who was the 1st ODI captain for India?","Ajit Wadekar","Bishen Singh Bedi","Nawab Pataudi","Ajit Wadekar");
        this.addQuestionToDB2(q14);
        Question q15 = new Question("The 'Dronacharya Award' is given to...?","Coaches","Umpires","Sports Editors","Coaches");
        this.addQuestionToDB2(q15);
        Question q16 = new Question("Which cricketer died on the field in Bangladesh while playing for Abahani Club?","M.L.Jaisimha","Subhash Gupte","Raman Lamba","Raman Lamba");
        this.addQuestionToDB2(q16);
        Question q17 = new Question("Which of the following is a Manipuri version of Hockey?", "Khong Kangjei", "Hiyang Tanaba", "Yubi Lakpi", "Khong Kangjei");
        this.addQuestionToDB2(q17);
        Question q18 = new Question("Where did the 1st ODI match was played in India?","Kolkata","Ahmedabad","Mumbai","Ahmedabad");
        this.addQuestionToDB2(q18);
        Question q19 = new Question("The Indian football team made its first appearance at Olympics in...?","1936","1948","1952","1948");
        this.addQuestionToDB2(q19);
        Question q20 = new Question("Who was the first captain of Indian Test team?","C K Nayudu","Vijay Hazare","Vijay Merchant","C K Nayudu");
        this.addQuestionToDB2(q20);

    }

    public void addQuestionToDB2(Question q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, q.getQuestion());
        values.put(KEY_ANSWER,q.getAnswer());
        values.put(KEY_OPTA,q.getOptA());
        values.put(KEY_OPTB,q.getOptB());
        values.put(KEY_OPTC,q.getOptC());
        dbase.insert(DB_TABLE2, null, values);
    }

    public List <Question> getAllSQuestions(){
        List <Question> squestionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE2;
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));

                squestionList.add(q);

            }while (cursor.moveToNext());
        }
        return squestionList;
    }

    private void addEQuestions() {
        Question q1 = new Question("What are John Abraham and Akshay Kumar's professions in Garam Masala?", "Reporter", "Lawyers", "Photographers", "Photographers ");
        this.addQuestionToDB3(q1);
        Question q2 = new Question("From where does Veeru propose to Basanti in Sholay?", "Top of a water tank", "Top of a roof", "Top of a hill", "Top of a water tank");
        this.addQuestionToDB3(q2);
        Question q3 = new Question("The catch-line 'American dream, Indian soul' was of the film...?", "American Desi", "Pardes", "Indian", "Pardes");
        this.addQuestionToDB3(q3);
        Question q4 = new Question("Aishwarya Rai was crowned Miss World in which year?","1994","1993","1995","1994");
        this.addQuestionToDB3(q4);
        Question q5 = new Question("The name of Kajol's character in Sohail Khan's Pyar Kiya Toh Darna Kya was...?","Muskan","Simran","Anjali","Muskan");
        this.addQuestionToDB3(q5);
        Question q6 = new Question("Lata Mangeshkar was awarded the Padma Bhushan in which year?","1989","1979","1969","1969");
        this.addQuestionToDB3(q6);
        Question q7 = new Question("The name of Saif Ali Khan's daughter is...?","Zara","Sara","Rhea","Sara");
        this.addQuestionToDB3(q7);
        Question q8 = new Question("Raveena Tandon won the National Award for her role in which film?","Ankhiyon Se Goli Maare","Shool","Daman","Daman");
        this.addQuestionToDB3(q8);
        Question q9 = new Question("The first film Alisha Chinai sang for was...?","Mr India ","Do Ankhen Barah Haath ","Tarzan","Tarzan");
        this.addQuestionToDB3(q9);
        Question q10 = new Question("Lata Mangeshkar made her debut in Hindi playback singing with the movie...?","Aap ke Sewa Main","Deewar","Barsaat","Aap ke Sewa Main");
        this.addQuestionToDB3(q10);
        Question q11 = new Question("Tabu's real name is...?","Taslim Khan","Tabassum Fatima Hashmi ","Tabakul","Tabassum Fatima Hashmi ");
        this.addQuestionToDB3(q11);
        Question q12 = new Question("Who played Mrs Khiladi in Mr And Mrs Khiladi?","Juhi Chawla","Karisma Kapoor","Manisha Koirala","Juhi Chawla");
        this.addQuestionToDB3(q12);
        Question q13 = new Question("Before Akshay Kumar became an actor, he worked as a...?","Reporter","Journalist","Waiter","Waiter");
        this.addQuestionToDB3(q13);
        Question q14 = new Question("What was the name of Madhuri Dixit's dog in Hum Aapke Hain Koun?","Tuffy","Tommy","Timmy","Tuffy");
        this.addQuestionToDB3(q14);
        Question q15 = new Question("Which was the first film in which Amitabh and Jaya Bachchan worked together?","Sholay","Guddi","Kabhi Khushi Kabhi Ghum","Guddi");
        this.addQuestionToDB3(q15);
        Question q16 = new Question("Which is India's first Colour film?","Kisan Kanya","Mother India","Alam Ara","Kisan Kanya");
        this.addQuestionToDB3(q16);
        Question q17 = new Question("Which was the first monochrome film to be fully converted into colour in 2004?", "Raja Harishchandra", "Mughal-e-Azam", "Naya Daur", "Mughal-e-Azam");
        this.addQuestionToDB3(q17);
        Question q18 = new Question("Which was the first Indian talkie movie to be released?","Ayodhya ka Raja","Raja Harishchandra","Alam Ara","Alam Ara");
        this.addQuestionToDB3(q18);
        Question q19 = new Question("Who is considered the 'Father of the Indian Films'?","Raj Kapoor","Prithviraj Kapoor","Dada Saheb Phalke","Dada Saheb Phalke");
        this.addQuestionToDB3(q19);
        Question q20 = new Question("Name Karan Johar's 2nd directorial film comprising of a cast of- Amitabh Bachhan, Jaya, Shahrukh, Hritik, Kareena, Kajol and Rani.","Kabhi Khushi Kabhi Ghum","Kuch Kuch hota hain","Hum Saath Saath hain","Kabhi Khushi Kabhi Ghum");
        this.addQuestionToDB3(q20);

    }

    public void addQuestionToDB3(Question q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, q.getQuestion());
        values.put(KEY_ANSWER,q.getAnswer());
        values.put(KEY_OPTA,q.getOptA());
        values.put(KEY_OPTB,q.getOptB());
        values.put(KEY_OPTC,q.getOptC());
        dbase.insert(DB_TABLE3, null, values);
    }

    public List <Question> getAllEQuestions(){
        List <Question> equestionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE3;
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));

                equestionList.add(q);

            }while (cursor.moveToNext());
        }
        return equestionList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE2);
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE3);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }
}
