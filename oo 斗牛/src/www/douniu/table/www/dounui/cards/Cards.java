package www.douniu.table.www.dounui.cards;

import java.security.PublicKey;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cards {
    private String[] flower ={"·½¿é","Ã·»¨","ºìÌÒ","Ã·»¨"};
    private  String[] value = {"A" ,"2","3","4","5","6","7","8","9","10","J","Q","K"};
    private LinkedList<String> card= new LinkedList<>();

    public void xiPai()
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <13 ; j++) {
                card.add(flower[i]+value[j]);
            }
        }
        Collections.shuffle(card);
    }

    public String[] getFlower()
    {
        return this.flower;
    }

    public  String[] getValue()
    {
        return this.value;
    }

    public LinkedList<String> getCard()
    {
        return card;
    }

    public void setCard(LinkedList<String> card) {
        this.card = card;
    }
}
