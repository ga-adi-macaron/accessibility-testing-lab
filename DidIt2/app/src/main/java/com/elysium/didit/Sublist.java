package com.elysium.didit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay on 10/31/16.
 */

public class Sublist {

        private static Sublist sublist = null;
        private static List<ToDoList> toDoLists;
        private static String listOfItemsTitle;

        private Sublist() {
            toDoLists = new ArrayList<>();
        }

        public static Sublist getInstance() {
            if(sublist == null)
                sublist = new Sublist();
            return sublist;
        }

        public List<ToDoList> getToDoLists() {
            return toDoLists;
        }

        public void addToDoList(String title) {
            toDoLists.add(new ToDoList(title));
        }

        public void setToDoList(List<ToDoList> toDoLister) {
            toDoLists = toDoLister;
        }

        public void setListTtitle(String title) {
            listOfItemsTitle = title;
        }

        public String getListTitle() {
            return listOfItemsTitle;
        }
    }
