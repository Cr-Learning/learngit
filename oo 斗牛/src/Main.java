import www.douniu.table.Table;
import www.douniu.table.www.douniu.people.People;
import www.douniu.table.www.dounui.cards.Cards;

import java.util.Scanner;


public class Main{
    public String name ()
    {

        Scanner name2 = new Scanner(System.in);
        String name1 = name2.next();
        return name1;
    }
    public static void main(String[] args) {
        Table t  = new Table();
        Main p = new Main();
        int a = 1;
        int c = 1;
        int n;
        Scanner d = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        System.out.println("正在创建游戏 ，请稍等...");
        System.out.println("游戏创建成功!");
        System.out.println("请输入游戏人数：（3~8）人");
        n = b.nextInt();
        while (n<3 || n>8)
        {
            System.out.println("输入错误！   请重新输入（3~8）人");
            n = b.nextInt();
        }
        t.setN(n);
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第"+(i+1)+"个玩家的姓名：");
            t.addPeople( new People(p.name(),1000,0));
        }
//        People p1 =  new People("张三",1000,0);
//        People p2 =  new People("张四",1000,0);
//        People p3 =  new People("张五",1000,0);
//        People p4 =  new People("张六",1000,0);
//        People p5 =  new People("张七",1000,0);


//        t.addPeople(p1);
//        t.addPeople(p2);
//        t.addPeople(p3);
//        t.addPeople(p4);
//        t.addPeople(p5);


        while (a==1)
        {
            if (c==1)
            {
                t.robBanker();
                t.iniPlayerCard();
                t.bottom();
                t.faPai();
                t.showPlayerCard();
                t.surplus();
                System.out.println("是否继续游戏：\n" +"继续请按 1       退出请按 2 ");
                c = b.nextInt();
            }

            else if (c==2)
                break;
            else
            {
                System.out.println("输入错误，请重新输入： 1  or   2");
                c = b.nextInt();
            }
        }
    }
}
