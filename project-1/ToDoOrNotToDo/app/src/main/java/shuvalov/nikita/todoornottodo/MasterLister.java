package shuvalov.nikita.todoornottodo;

import java.util.ArrayList;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */
public class MasterLister {
    private static ArrayList<ErrandsEncapsulator> mMasterList;
    private static MasterLister ourInstance = new MasterLister();

    public static MasterLister getInstance() {
        return ourInstance;
    }

    public static ArrayList<ErrandsEncapsulator> retriveToDoLists(){
      return mMasterList;
    }

    public static void removeToDoList(int position){
        mMasterList.remove(position);
    }
    public static void appendToDoList(ErrandsEncapsulator toDoList){
        mMasterList.add(toDoList);
    }

    private MasterLister() {
        mMasterList= new ArrayList<>();
    }
    public static ErrandsEncapsulator getErrEncapInPosition(int position){
        return mMasterList.get(position);
    }
    public static int getPositionErrEncapInMasterList(ErrandsEncapsulator errandsEncapsulator){
        return mMasterList.indexOf(errandsEncapsulator);
    }
    public static int debugSize(){return mMasterList.size();
    }
}
