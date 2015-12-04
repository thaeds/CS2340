package sample;

/**
 * Created by Hyun on 2015-12-03.
 *
 * @author Hyun
 * @version 1.0
 */
public class Event {

    private int RANDOM_EVENT_CHANCE = 27;

    private int factor;
    private String[] detail;

    //List of random events and their detailed implementation
    String RANDOM_EVENT1 = "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS";
    String RANDOM_EVENT2 = "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";
    String RANDOM_EVENT3 = "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $";
    String RANDOM_EVENT4 = "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $";
    String RANDOM_EVENT5 = "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $";
    String RANDOM_EVENT6 = "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
    String RANDOM_EVENT7 = "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $";
    // EC Additional Random Events
    String RANDOM_EVENT8 = "FOOD VIRUS OCCURS AND HAPPENED TO SPOIL YOUR FOOD! ONLY QUART REMAINS CLEAR!";
    String RANDOM_EVENT9 = "PROTOSS UNIT CAME BY TO SHARE 15 ENERGY !!!";
    String RANDOM_EVENT10 = "TERRAN SUPPLY SHIP CONTAINING 8 FOOD JUST DROPPED";

    public Event () {
        factor = 0;
        detail = new String[10];
        setDetail();
    }

    /**
     * prepare arraylist of string to printout the event description
     */
    private void setDetail() {
        detail[0] = RANDOM_EVENT1;
        detail[1] = RANDOM_EVENT2;
        detail[2] = RANDOM_EVENT3;
        detail[3] = RANDOM_EVENT4;
        detail[4] = RANDOM_EVENT5;
        detail[5] = RANDOM_EVENT6;
        detail[6] = RANDOM_EVENT7;
        detail[7] = RANDOM_EVENT8;
        detail[8] = RANDOM_EVENT9;
        detail[9] = RANDOM_EVENT10;
    }

    /**
     * event detail is returned
     * @param d event selector
     * @return event detail
     */
    public String getDetail (int d) {
        if(d >= detail.length) {
            return "NO EVENT DETAIL No. " + d;
        } else {
            return detail[d];
        }
    }

    public int getChance() {
        return RANDOM_EVENT_CHANCE;
    }

    public void setFactor(int round) {
        if (round <= 3) {
            factor = 25;
        } else if (round <= 7) {
            factor = 50;
        } else if (round <= 11) {
            factor = 75;
        } else {
            factor = 100;
        }
    }

    public int getFactor() {
        return factor;
    }

}
