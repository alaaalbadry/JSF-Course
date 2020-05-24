/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ALaa
 */
@ManagedBean(name="voteBean")
@SessionScoped
public class VoteBean implements Serializable{
    @ManagedProperty(value="#{listBean}")
    ListBean listBean;
    
    boolean voted;
    String choosen;

    public VoteBean() {
    }
    

    public ListBean getListBean() {
        return listBean;
    }

    public void setListBean(ListBean listBean) {
        System.out.println("inject manage ");
        this.listBean = listBean;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public String getChoosen() {
        return choosen;
    }

    public void setChoosen(String choosen) {
        this.choosen = choosen;
    }
    
    public String voteButtonBack(){
        System.out.println("ef : " + listBean);
        if(getChoosen() != null){
            listBean.incrementCategory(getChoosen());
            setVoted(true);
            return "results";
        }else{
            return "";
        }
    }
            
}
