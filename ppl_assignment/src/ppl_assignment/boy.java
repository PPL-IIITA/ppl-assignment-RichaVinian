
package ppl_assignment;
/**
 * <h1>Boy class </h1>
 * <p>
 * It contains all the attributes of boy
 * @author RichaVinian
 */ 
public class boy {
    int attractiveness;
    int intelligence;
    int budget;
    String name;
    int att_req; //minimum attraction requirement of boy for the girl 
    char status; //c-committed , s- single
    int type;   //0-miser, 1-generous , 2-geek
    double happiness;
    boy(){
        status='s';
    }
   //gt is the array of couple gifts ...stores gifts corresponding to girls' index
    /**
     * gift_basket distributes all gifts and calculates the total cost and value
     * @param gt array of gift exchange details of couples
     * @param g  list details of girls
     * @param e  details of essential gifts
     * @param l  details of luxury gifts
     * @param u  details of utility gifts class
     * @param index index of partners corresponding to girls
     * @param n_l  number of luxury gifts
     */
    public void gift_basket(gift gt[],girl g[],gift_essential e[],gift_luxury l[],gift_utility u[],int index,int n_l){
        
        if(type == 0){
            int j=0;
            while(gt[index].gift_cost <= g[index].maintainance ){
                gt[index].arr_gifts[j]=e[j].price;
                gt[index].gift_cost += e[j].price;
                gt[index].gift_value += e[j].value;
                j++;
            }
        }
        if(type == 1){
            int j=0;
            while(gt[index].gift_cost <= budget ){
                if(gt[index].gift_cost+l[j].price > budget)
                    break;
                gt[index].arr_gifts[j]=l[j].price;
                gt[index].gift_cost += l[j].price;
                gt[index].gift_value += l[j].value;
                j++;
            }
            gt[index].gift_value_luxury=gt[index].gift_value;
        }
        if(type == 2){
            int j=0;
            while(gt[index].gift_cost <= g[index].maintainance ){
                gt[index].arr_gifts[j]=e[j].price;
                gt[index].gift_cost += e[j].price;
                gt[index].gift_value += e[j].value;
                j++;
            }
            for(int i=0;i<n_l;i++){
                if(budget-g[index].maintainance > l[i].price){
                    gt[index].arr_gifts[j]=l[i].price;
                    gt[index].gift_cost += l[i].price;
                    gt[index].gift_value += l[i].value;
                    gt[index].gift_value_luxury=l[i].value;
                    break;
                }
            }
                
        }
    }
}
