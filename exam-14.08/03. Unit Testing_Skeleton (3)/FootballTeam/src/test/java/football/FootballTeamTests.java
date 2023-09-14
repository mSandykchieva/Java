package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    private FootballTeam ft;
    private Footballer footballer1;
    private Footballer footballer2;

    @Before
    public void setUp(){
        ft=new FootballTeam("Ravnec",4);
        footballer1=new Footballer("Magi");
        footballer2=new Footballer("Eva");
    }



    @Test(expected = NullPointerException.class)
    public void test_FootballTeamNull(){
        FootballTeam footballTeam = new FootballTeam(null,2);

    }

    @Test(expected = NullPointerException.class)
    public void test_FTEmpty(){
        FootballTeam footballTeam = new FootballTeam(" ",3);
    }

    @Test
    public void test_FT(){
        FootballTeam footballTeam = new FootballTeam("Magi",3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FTInvalidVP(){
        FootballTeam footballTeam = new FootballTeam("Krupnik",-1);
    }

    @Test
    public void test_getVacationPositions(){
        Assert.assertEquals(4,ft.getVacantPositions());

    }

    @Test
    public void test_getCount(){
        ft.addFootballer(footballer1);
        Assert.assertEquals(1,ft.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addFootballer(){
        FootballTeam ft2 = new FootballTeam("Burgas",1);
        ft2.addFootballer(footballer1);
        ft2.addFootballer(footballer2);
    }

    @Test
    public void test_removeFB(){
        ft.addFootballer(footballer1);
        ft.addFootballer(footballer2);
        ft.removeFootballer("Magi");
        Assert.assertEquals(1,ft.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeFB2(){
        ft.removeFootballer(null);
    }

    @Test
    public void test_footballerForSale(){
        ft.addFootballer(footballer1);
        ft.addFootballer(footballer2);

        Assert.assertEquals(footballer1.getName(),ft.footballerForSale("Magi").getName());
        Assert.assertTrue(!footballer1.isActive());
    }

    @Test (expected = IllegalArgumentException.class)
        public void test_footballerForSale2(){

        ft.addFootballer(footballer1);
        ft.addFootballer(footballer2);

        Footballer footballer = ft.footballerForSale("Vasko");
        }

        @Test
    public void test_getStatistics(){
        ft.addFootballer(footballer1);
        ft.addFootballer(footballer2);
        String expectedMessage = "The footballer Magi, Eva is in the team Ravnec.";
        Assert.assertEquals(expectedMessage,ft.getStatistics());
        }

}
