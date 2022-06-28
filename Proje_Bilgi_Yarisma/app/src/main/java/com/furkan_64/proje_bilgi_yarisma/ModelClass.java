package com.furkan_64.proje_bilgi_yarisma;

public class ModelClass {
    String Question;
    String aA;
    String aB;
    String aC;
    String aD;
    String ans;

     public ModelClass(String question,String aA,String aB,String aC,String aD,String ans)
     {
         this.Question=question;
         this.aA=aA;
         this.aB=aB;
         this.aC=aC;
         this.aD=aD;
         this.ans=ans;
     }

     public String getQuestion() {return Question;}
     public void setQuestion(String question) {question=Question;}

    public String getaA() {return aA;}
    public void setaA(String aA) {this.aA=aA;}

    public String getaB() {return aB;}
    public void setaB(String aB) {this.aA=aB;}


    public String getaC() {return aC;}
    public void setaC(String aC) {this.aA=aC;}


    public String getaD() {return aD;}
    public void setaD(String aD) {this.aD=aD;}


    public String getAns() {return ans;}
    public void setAns(String ans) {this.ans=ans;}






}
