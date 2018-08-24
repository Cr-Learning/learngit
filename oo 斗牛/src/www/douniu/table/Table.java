package www.douniu.table;
import www.douniu.table.www.douniu.people.People;
import www.douniu.table.www.dounui.cards.Cards;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Table {
    int n;
    private final int PLAYER =5;
    private String banker;
    private  List<String>[] playerCard = new List[8];
    LinkedList<People> players =new LinkedList<>();
    Cards cards = new Cards();
    public void setN( int n )

    {
        this. n = n;
    }

    public void addPeople(People people)
    {

        players.add(people);
    }

    public void robBanker() {
        int p = 0;
        int a = 1;

        Scanner k= new Scanner(System.in);
        for (int i = 0; i < players.size(); i++)
        {
            System.out.println(players.get(i).getName()+"是否需要抢庄\n");
            System.out.println("1、要       2、不要");
            while (a == 1)
            {
                int t = k.nextInt();
                p=t;
                if (t ==1)
                {
                    banker = players.get(i).getName();
                    System.out.println("庄家是:"+banker);
                    break;
                }
                else if (t == 2)
                {
                    break;
                }
                else
                {
                    System.out.println("输入错误，请重新输入：");
                }

            }
            if (p ==1) break;
        }
    }

    public void iniPlayerCard()
    {
        for (int i = 0; i <players.size(); i++)
        {
            if (players.get(i) !=  null)
                playerCard[i] = new LinkedList<>();
        }
    }

    public  void faPai() {
        int k = 0;
        cards.xiPai();
        while (k < PLAYER) {
            int b = 0;
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName() .equals(banker) ) {
                    b = i;
                    break;
                }

            }
            for (int i = b; i < players.size(); i++) {

                playerCard[i].add(cards.getCard().get(0));
                cards.getCard().remove(0);
            }
            for (int i = 0; i < b; i++) {

                playerCard[i].add(cards.getCard().get(0));
                cards.getCard().remove(0);
            }
            k++;
        }
    }

    public void surplus()
    {
        System.out.println("下面是每个玩家剩余的钱：\n");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName()+":"+players.get(i).getScore()+"\n");
        }
    }

    public void  bottom()
    {
        int a =0;
        a=check();

        if(a ==1) {
            Scanner q = new Scanner(System.in);
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName() != banker) {
                    System.out.println(players.get(i).getName() + "请下注" + "(5-" + (players.get(i).getScore() / 3) + ")");
                    int b= q.nextInt();
                   while (b < 5 || b > players.get(i).getScore() / 3) {
                       if (b < 5) {
                           System.out.println("最低输入5元，请重新输入：");

                       } else if (b > players.get(i).getScore() / 3) {
                           System.out.println("对手是牛牛 是要翻3倍的哦，您没这么多钱了！\n请重新输入：");
                       }
                       b = q.nextInt();
                   }
                    players.get(i).setXiazhu(b);
                }
            }
        }
        else System.exit(0);
    }

    public void  showPlayerCard()
    {
        int[] playCow = new int[n];
        for (int i = 0; i <n; i++) {
            if (players.get(i) !=  null ) {
                if (players.get(i).getName().equals(banker) ){
                    System.out.println("庄家" + players.get(i).getName() + "的手牌:");
                } else {
                    System.out.println("玩家"+players.get(i).getName()+ "的手牌:");
                }
                for (String card :
                        playerCard[i]) {
                    System.out.print(card+"  ");
                }
                System.out.print("\n");
            }
            if (players.get(i).getName() == banker)
            {
                System.out.print("庄家"+players.get(i).getName()+"的牛是 :");
            }
            else {
                System.out.print("玩家"+players.get(i).getName()+"的牛是 ：");
            }

            playCow[i] = cow(playerCard[i]);
            if (playCow[i] == 10)
                System.out.println("牛牛\n");
            else if (playCow[i] == -1)
                System.out.println("没牛\n");
            else
                System.out.println("牛"+playCow[i]+"\n");
        }
        contrast(playCow);
    }

    public int  cow(List<String> b)
    { String[] pai = new String [PLAYER];
        int[] zpai = new int[PLAYER];
        int sum = -1;
        for (int i = 0; i < PLAYER; i++)
        {
            pai[i] = b.get(i);
            pai[i]=pai[i].substring(2,b.get(i).length());
        }
        for (int i = 0; i < PLAYER ; i++) {
            switch (pai[i])
            {
                case "A":zpai[i] = 1;
                    break;
                case "2":zpai[i] = 2;
                    break;
                case "3":zpai[i] = 3;
                    break;
                case "4":zpai[i] = 4;
                    break;
                case "5":zpai[i] = 5;
                    break;
                case "6":zpai[i] = 6;
                    break;
                case "7":zpai[i] = 7;
                    break;
                case "8":zpai[i] = 8;
                    break;
                case "9":zpai[i] = 9;
                    break;
                case "10":zpai[i] = 10;
                    break;
                case "J":zpai[i] = 10;
                    break;
                case "Q":zpai[i] = 10;
                    break;
                case "K":zpai[i] = 10;
                    break;


            }
        }
        for (int i = 0; i <3 ; i++) {
            for (int j = i+1; j <4 ; j++) {
                for (int k = j+1; k <5 ; k++) {
                    if ((zpai[i] + zpai[j] + zpai[k]) %10 ==0 )
                    {
                        for (int l = 0; l < PLAYER; l++){
                            if (l != i && l != j && l != k) {
                                for (int m = l + 1; m < PLAYER; m++) {
                                    if (m != i && m != j && m !=k) {
                                        sum = (zpai[l] + zpai[m]) % 10;
                                    }

                                }
                            }else continue;
                        }
                    } else continue;

                }

            }

        }

        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j <5 ; j++) {
                if ((zpai[i] + zpai[j]) %10 == 0)
                {
                    for (int k = 0; k < 4; k++) {
                        if (k != i && k != j)
                        {
                            for (int l = k+1; l <5 ; l++) {
                                if (l != j && l != i) {
                                    if ((zpai[k] + zpai [l])% 10 ==0)
                                    {
                                        for (int m = 0; m <PLAYER; m++) {
                                            if (m != i && m != j && m != k && m != l)
                                            {
                                                sum = zpai[m] % 10;
                                            }

                                        }
                                    }
                                } else continue;
                            }
                        }else
                            continue;
                    }
                }

            }
        }
        if (sum == 0)
            return  10;
        else return sum;

    }

    public void contrast(int[] a)
    {int ber = 0;
        for (int i = 0; i < n; i++) {
            if(players.get(i).getName() ==banker)
            {
                ber = i;
                break;
            }
        }
        for (int j = 0; j < ber ; j++) {
            if (a[j] < a[ber])
            {
                if(a[ber] > 7 && a[ber] < 10 )
                {
                    int p =0;
                    p = players.get(j).getXiazhu();
                    p *=2;
                    players.get(j).setScore((players.get(j).getScore()-p));
                    players.get(ber).setScore((players.get(j).getScore()+p));
                }
                else if (a[ber] == 10)
                {
                    int p =0;
                    p = players.get(j).getXiazhu() ;
                    p *=3;
                    players.get(j).setScore((players.get(j).getScore()-p));
                    players.get(ber).setScore((players.get(j).getScore()+p));
                }
                else
                {
                    int p =0;
                    p =  players.get(j).getXiazhu() ;
                    players.get(j).setScore((players.get(j).getScore()-p));
                    players.get(ber).setScore((players.get(j).getScore()+p));
                }
            }
            else if (a[j] > a[ber])
            {
                if(a[j] > 7 && a[j] < 10 )
                {
                    int p =0;
                    p = players.get(j).getXiazhu() ;
                    p *=2;
                    players.get(j).setScore((players.get(j).getScore()-p));
                    players.get(ber).setScore((players.get(j).getScore()+p));
                }
                else if (a[j] == 10)
                {
                    int p =0;
                    p =players.get(j).getXiazhu() ;
                    p *=3;
                    players.get(j).setScore((players.get(j).getScore()-p));
                    players.get(ber).setScore((players.get(j).getScore()+p));
                }
                else
                {
                    int p =0;
                    p =players.get(j).getXiazhu() ;
                    players.get(j).setScore((players.get(j).getScore()-p));
                    players.get(ber).setScore((players.get(j).getScore()+p));
                }
            }

        }
        for (int j = ber+1; j < n ; j++) {
            if (players.get(j)!= null) {
                if (a[j] < a[ber]) {
                    if (a[ber] > 7 && a[ber] < 10) {
                        int p = 0;
                        p = players.get(j).getXiazhu();
                        p *= 2;
                        players.get(j).setScore((players.get(j).getScore()-p));
                        players.get(ber).setScore((players.get(ber).getScore()+p));
                    } else if (a[ber] == 10) {
                        int p = 0;
                        p = players.get(j).getXiazhu();
                        p *= 3;
                        players.get(j).setScore((players.get(j).getScore()-p));
                        players.get(ber).setScore((players.get(ber).getScore()+p));
                    } else {
                        int p = 0;
                        p = players.get(j).getXiazhu();
                        players.get(j).setScore((players.get(j).getScore()-p));
                        players.get(ber).setScore((players.get(ber).getScore()+p));
                    }
                } else if (a[j] > a[ber]) {
                    if (a[j] > 7 && a[j] < 10) {
                        int p = 0;
                        p = players.get(j).getXiazhu();
                        p *= 2;
                        players.get(j).setScore((players.get(j).getScore()+p));
                        players.get(ber).setScore((players.get(ber).getScore()-p));
                    } else if (a[j] == 10) {
                        int p = 0;
                        p = players.get(j).getXiazhu();
                        p *= 3;
                        players.get(j).setScore((players.get(j).getScore()+p));
                        players.get(ber).setScore((players.get(ber).getScore()-p));
                    } else {
                        int p = 0;
                        p = players.get(j).getXiazhu();
                        players.get(j).setScore((players.get(j).getScore()+p));
                        players.get(ber).setScore((players.get(ber).getScore()-p));
                    }
                }

            }
        }
    }
    public int check() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() < 15) {
                System.out.println("玩家" + players.get(i).getName() + "已经没钱了,仅剩 ："+players.get(i).getScore());
                return 0;
            }
        }
        return 1;
    }

}
