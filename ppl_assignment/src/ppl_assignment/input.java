
package ppl_assignment;

import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.Math.exp;
import static java.lang.Math.log;
import java.util.Scanner;

/**
 *<h1>Input class</h1>
 * <p>
 * Takes input corresponding to girls,boys,gifts.Further assigns partners,finds happiness
 * of couples,compatibility of couples,sorts them.
 * @author RichaVinian
 * couple[] contains index of boyfriend corresponding to girl index
 * couple_happy[] contains happiness of couples
 * couple_compatible[] contains compatibility of couples
 */

public class input {
    public int couple[]={-1},arr1[],arr2[];
    public double couple_happy[]={-1};
    public double couple_compatible[]={-1};
    public int n_g,n_e,n_u;
    public int n_b,n_l;
    /**
     * "input" creates input files and finds boyfriends for girls 
     * @param g list of girls
     * @param b list of boys
     * @param args
     * n_g no. of girls
     * n_b no. of boys
     * n_e no. of essential gifts
     * n_l no. of luxury gifts
     * n_u no. of utility gifts
     * @throws java.io.IOException
     */ 
    public input(girl g[],boy b[],String args[])throws IOException{
        
        FileInputStream girls = new FileInputStream (args[0]);
        FileInputStream boys = new FileInputStream (args[1]);
      
        Scanner c1= new Scanner(girls);
        Scanner c2= new Scanner(boys);
     
        n_g=c1.nextInt();
        n_b=c2.nextInt();
       
        for(int i=0;i<n_g;i++){
            g[i]=new girl();
            g[i].name=c1.next();
            g[i].attractive=c1.nextInt();
            g[i].intelligence=c1.nextInt();
            g[i].maintainance=c1.nextInt();
            g[i].criteria=c1.nextInt();
            g[i].type=c1.nextInt();
        }
        
        for(int i=0;i<n_b;i++){
            b[i]=new boy();
            b[i].name=c2.next();
            b[i].attractiveness=c2.nextInt();
            b[i].budget=c2.nextInt();
            b[i].intelligence=c2.nextInt();
            b[i].att_req=c2.nextInt();
            b[i].type=c2.nextInt();
        } 
        
        for(int i=0;i<n_g;i++){
           int index=g[i].match_making(b, n_b); 
           couple[i]=index;
       }
       
    }
    /**
     * finds partner,calculates happiness,compatibility of couples
     * @param g list of girls
     * @param b list of boys
     * @param args
     * @param e list of essential gifts
     * @param l list of luxury gifts
     * @param u list of utility gifts
     * @param gt gifting details of couples
     * @throws IOException 
     */
    public input(girl g[],boy b[],String args[],gift_essential e[],gift_luxury l[],gift_utility u[],gift gt[])throws IOException{
        
        FileInputStream girls = new FileInputStream (args[0]);
        FileInputStream boys = new FileInputStream (args[1]);
        FileInputStream gifts_essential = new FileInputStream (args[2]);  //file
        FileInputStream gifts_luxury = new FileInputStream (args[3]);
        FileInputStream gifts_utility = new FileInputStream (args[4]);
        
        Scanner c1= new Scanner(girls);
        Scanner c2= new Scanner(boys);                          ///scansfromfile
        Scanner c3= new Scanner(gifts_essential);
        Scanner c4= new Scanner(gifts_luxury);
        Scanner c5= new Scanner(gifts_utility);
        
        n_g=c1.nextInt();
        n_b=c2.nextInt();                           //number of girls,boys,gifts 
        n_e=c3.nextInt();
        n_l=c4.nextInt();
        n_u=c5.nextInt();
    
        for(int i=0;i<n_g;i++){
            g[i]=new girl();
            g[i].name=c1.next();
            g[i].attractive=c1.nextInt();
            g[i].intelligence=c1.nextInt();
            g[i].maintainance=c1.nextInt();
            g[i].criteria=c1.nextInt();
            g[i].type=c1.nextInt();
        }
        
        for(int i=0;i<n_b;i++){
            b[i]=new boy();
            b[i].name=c2.next();
            b[i].attractiveness=c2.nextInt();
            b[i].budget=c2.nextInt();
            b[i].intelligence=c2.nextInt();
            b[i].att_req=c2.nextInt();
            b[i].type=c2.nextInt();
        }
        
        for(int i=0;i<n_e;i++){
            e[i]=new gift_essential();
            e[i].price=c3.nextInt();
            e[i].value=c3.nextInt();
        }
        
        for(int i=0;i<n_l;i++){
            l[i]=new gift_luxury();
            l[i].price=c4.nextInt();
            l[i].value=c4.nextInt();
            l[i].difficulty=c4.nextInt();
            l[i].luxury_rating=c4.nextInt();
        }
        for(int i=0;i<n_u;i++){
            u[i]=new gift_utility();
            u[i].price=c5.nextInt();
            u[i].value=c5.nextInt();
            
        }
        for(int i=0;i<n_g;i++){
           int index=g[i].match_making(b, n_b);         //matchmaking
           couple[i]=index;
        }
        for(int i=0;i<n_g;i++){
            if(couple[i]!=-1){
                b[couple[i]].gift_basket(gt,g,e,l,u,i,n_l); //creates gift basket
            }
        }
        for(int i=0;i<n_g;i++){
           if(couple[i]!=-1){
            if(g[i].type==0){                             //calculate happinness
                double temp=(log(gt[i].gift_cost - g[i].maintainance));
                g[i].happiness=  temp + 2*(gt[i].gift_value_luxury); 
            }
            
            if(g[i].type==1){
                g[i].happiness= (gt[i].gift_cost + gt[i].gift_value) - g[i].maintainance;
            }
            
            if(g[i].type==2){
                g[i].happiness= exp(gt[i].gift_cost - g[i].maintainance);
            }
            
            if(b[couple[i]].type==0){
                b[couple[i]].happiness= b[couple[i]].budget - gt[i].gift_cost;
            }
            if(b[couple[i]].type==1){
                b[couple[i]].happiness= g[i].happiness;
            }
            if(b[couple[i]].type==2){
                b[couple[i]].happiness= g[i].intelligence;
            }
            couple_happy[i]=  (g[i].happiness + b[couple[i]].happiness);
            couple_compatible[i]= (b[couple[i]].budget- g[i].maintainance )+ abs(b[couple[i]].attractiveness - g[i].attractive) + abs(b[couple[i]].intelligence-g[i].intelligence);
           }
        }
        
        
    }
    /**
     * sorts according to happiness of couples
     * @param n  
     */
    public void sort_happy(int n){
        double temp;
        int tem;
        for(int i=0;i<n;i++){
            arr1[i]=i;
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(couple_happy[i]<couple_happy[j]){
                    temp=couple_happy[i];
                    couple_happy[i]=couple_happy[j];
                    couple_happy[j]=temp;
                    
                    tem=arr1[i];
                    arr1[i]=arr1[j];
                    arr1[j]=tem;
                }
            }
        }
    }
    /**
     * sorts according to compatibility of couples
     * @param n 
     */
    public void sort_compatible(int n){
        double temp;
        int tem;
        for(int i=0;i<n;i++){
            arr2[i]=i;
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(couple_compatible[i]< couple_compatible[j]){
                    temp=couple_compatible[i];
                    couple_compatible[i]=couple_compatible[j];
                    couple_compatible[j]=temp;
                    
                    tem=arr2[i];
                    arr2[i]=arr2[j];
                    arr2[j]=tem;
                }
            }
        }
    }
}
