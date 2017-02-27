package ppl_assignment;

/**
 * <h1>Girl class </h1>
 * <p>
 * It contains all the attributes of girls
 * @author RichaVinian
 */ 
public class girl {
    int attractive;
    int maintainance;
    int intelligence;
    String name;
    int criteria;// based on what criteia of boy girl wants to date:0-most attractive, 1- most rich , 2- most intelligent
    char status; //c-committed , s- single
    int type; // 0-choosy, 1-normal,2-desperate 
    double happiness;

    girl(){
       status='s'; 
    }
    /**
     * Forms the pair.
     * @param b list of boys
     * @param num number of boys
     * @return count index corresponding to girl partner
     */
    public int match_making(boy b[],int num){ //num is number of boys
       int max=0;
       int count=-1;
       
       if( criteria==0){
        for(int x=0;x<num;x++){
            
               if(b[x].attractiveness > max && b[x].status== 's' && b[x].budget > maintainance && attractive >= b[x].att_req){
                   max=b[x].attractiveness;
                   count=x;
               }
           }
       }
       
        if( criteria==1){
        for(int x=0;x<num;x++){
           
               if(b[x].budget > max && b[x].status== 's' && b[x].budget > maintainance && attractive >= b[x].att_req){
                   max=b[x].budget;
                   count=x;
               }
           }
       }
         if( criteria==2){
        for(int x=0;x<num;x++){
           
               if(b[x].intelligence > max && b[x].status== 's' && b[x].budget > maintainance && attractive >= b[x].att_req){
                   max=b[x].intelligence;
                   count=x;
               }
           }
       }
        if(count!=-1){
            status='c';
            b[count].status='c';
        }
        return count; //to store in boy's name corresponding to girl's index
    }
}
