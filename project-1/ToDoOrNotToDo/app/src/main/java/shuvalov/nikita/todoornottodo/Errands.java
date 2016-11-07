package shuvalov.nikita.todoornottodo;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */

public class Errands {
    public String mText;
    public boolean mChecked;
    public int imgPath;

    public Errands(String text){
        if(text.equals("")){
            mText = "Empty";
        }else{
            mText=text;
        }
    mChecked=false;}


    public String getText() {return mText;}

    public void setText(String text) {mText = text;}

    public void toggleChecked(){
        mChecked = !mChecked;
    }
    public boolean getCheckedStatus(){return mChecked;}

}
