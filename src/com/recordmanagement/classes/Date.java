package com.recordmanagement.classes;
import java.text.DateFormat;

public class Date{
    public static void dcSetReadOnly(com.toedter.calendar.JDateChooser chooser){
        com.toedter.calendar.JTextFieldDateEditor editor = (com.toedter.calendar.JTextFieldDateEditor) chooser.getDateEditor();
        editor.setEditable(false);
    }
    
    public static String dcGetDate(com.toedter.calendar.JDateChooser chooser){
        java.util.Date date = chooser.getDate();
        return DateFormat.getDateInstance().format(date);
    }   
}