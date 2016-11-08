10-18:

Initial concept thoughts - create a lightweight, intuitive to-do list app with a splsh screen, a ListVIew of recently edited notes (actionable), a sidebar settings menu (this is where access to the full list of notes will be), a contrast colored FAB with both short and long press actions, checkboxes to mark items as "done" and lists as "accomplished" and marked for deletion in 5 days. 

Item Features (by section):

       [B]To-Do List[/B] - List created with a recyclerView, LinearLayout
                
                FAB button (or regular button) to 'Add' and 'Remove' lists and listItems (one button for each)
                    ** these buttons both require onClickListeners in order to be actionable **
                        ## each onClickListener needs to be called in MAIN (I believe) ##
                        
                        ^^ repeat these steps for the main List Creation method (ie. FAB button w/ onClickListeners on each) ^^
                        
                [B]Singleton[/B] to store lists and listItems in memory, so they'll persist across sessions
                
                [B]LongPress[/B] action to activate the 'edit' (and maybe 'remove') option for each list and listItem
                
         
        [B] // Options that may be outside the scope of the project and time allowance (or made redundant in other instructions)[/B]
        
        Recently Edited Notes - the (1-5) most recent notes made. Actionable to edit or mark for deletion.
                    Sub section for notes that are due to be deleted.
        
        Sidebar Menu - Settings for push notification reminders, access to 'My Lists'(?), (NOT DOING THIS MOST LIKELY)
