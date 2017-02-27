/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_assignment;

import java.io.IOException;

/**
 *
 * @author hp
 */
public class q2_main {

    /**
     * <h1>This is the Main file of Question2</h1>
     * <p>
     * Prints k most happy couples and k most compatible couples 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int k= Integer.parseInt(args[5]);
        girl[] g= new girl[500];
        boy[] b = new boy[500];
        gift_essential[] e= new gift_essential[200];
        gift_luxury[] l=new gift_luxury[200];
        gift_utility[] u = new gift_utility[200];
        gift[] gt = new gift[500];
        input inp= new input(g,b,args,e,l,u,gt);
        
        inp.sort_happy(inp.n_g); //sort a/c happiness
        for(int i=0;i<k;i++){
            System.out.println(g[inp.arr1[i]].name + " " + b[inp.couple[inp.arr1[i]]].name);
            
        }
        
        inp.sort_compatible(inp.n_g);
        for(int i=0;i<k;i++){
            System.out.println(g[inp.arr2[i]].name + " " + b[inp.couple[inp.arr2[i]]].name);
            
        }
      
    }
    
}
