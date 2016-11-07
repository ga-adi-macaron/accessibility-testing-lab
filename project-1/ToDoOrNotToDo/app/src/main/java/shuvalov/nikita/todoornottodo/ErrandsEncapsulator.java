package shuvalov.nikita.todoornottodo;

import java.util.ArrayList;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */

public class ErrandsEncapsulator {
    private String mTitle, mDescription;
    private ArrayList<Errands> mErrandList;

    public ErrandsEncapsulator(String title, String description){//ToDo: If I want user to initiate list with errands inside of it already, can add a list as Parameter.
        mTitle= title;
        if (title.equals("")){
            mTitle="Default";
        }
        else{
            mTitle=title;
        }
        if(description.equals("")){
            mDescription=mTitle;
        }else{
            mDescription=description;

        }
        mErrandList = new ArrayList<>();
        MasterLister.appendToDoList(this);
    }


    public void setTitle(String title) { //ToDo:Allow user to edit already made list names/descriptions.
        mTitle = title;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void appendErrand(Errands errand){
        mErrandList.add(errand);
    }

    public void removeErrandByPosition(int position){mErrandList.remove(position);}


    public ArrayList<Errands> getErrandsList(){
        return mErrandList;
    }

}
