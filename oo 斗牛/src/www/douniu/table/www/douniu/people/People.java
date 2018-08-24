package www.douniu.table.www.douniu.people;


public class People{
    private String name;
    public int score ;
    public int xiazhu;
    public People(String name,int score , int xiazhu)
    {
        this.name = name;
        this.score = score;
        this.xiazhu = xiazhu;
    }


    public  int getXiazhu()
    {
        return xiazhu;
    }

    public  void setXiazhu(int xiazhu)
    {
        this.xiazhu = xiazhu;
    }

    public String getName() {
        return name;
    }

    public int getScore ()
    {
        return score;
    }
    public void setScore(int score) {

        this.score = score;
    }
}
