/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author ALaa
 */
//@Named("listBean")
@ManagedBean(name="listBean",eager = true)
@ApplicationScoped
public class ListBean implements Serializable{
   
    Category [] categoryList;

    public Category [] getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Category [] categoryList) {
        this.categoryList = categoryList;
    }

    public ListBean() {
        System.out.println("Init List Bean");
        this.categoryList = new Category [6];
        categoryList[0]=new Category("Clothing","Clothing",0);
        categoryList[1]=new Category("Decorating","Decorating",0);
        categoryList[2]=new Category("Garden","Garden",0);
        categoryList[3]=new Category("Homeware","Homeware",0);
        categoryList[4]=new Category("Incense and candeles","Incense and candeles",0);
        categoryList[5]=new Category("Toyes and Games","Toyes and Games",0);  
    }
    public void incrementCategory(String name){
        int count =0;
        for(int i=0;i<categoryList.length;i++){
            if(categoryList[i].getCategoryValue().equals(name)){
                 count = categoryList[i].getCategoryVotes();
                
                    categoryList[i].setCategoryVotes(++count);
            }
        }
    }
    
    
}
