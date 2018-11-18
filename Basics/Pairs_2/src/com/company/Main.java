package com.company;
import static java.lang.System.*;

class Pairs
{
    private int Length=0;
    private Integer[][] List;

    protected Pairs()
    {
        List=new Integer[2][10000];
    }

    protected boolean CheckPair(Integer x,Integer y)
    {
        for(int i=0;i<Length;i++)
        {
            int ok=0;
            if((List[0][i]).equals(x) | (List[1][i]).equals(x))ok++;
            if((List[0][i]).equals(y) | (List[1][i]).equals(y))ok++;

            if(ok>=2)return false;
        }

        return true;
    }

    protected void AddPair(Integer x,Integer y)
    {
        List[0][Length]=x;
        List[1][Length]=y;
        Length++;
    }
}

public class Main {

    public static void main(String[] args) {

        Pairs CurrentPair=new Pairs();
        Integer[] intArray={3,2,-3,-2,3,0};
        Integer n=6;
        Integer nPairs=0;
        Integer nullSum=0;
        int Combinari=0;


        for(Integer i=0, j=n-1;i<j;i++)
        {
            Combinari++;
            Integer sum=intArray[i]+intArray[j];
            out.print(i+" "+ j);

            if(sum.equals(nullSum)==true & CurrentPair.CheckPair(intArray[i],intArray[j]))
            {
                out.print(" "+intArray[i]+" "+intArray[j]);
                CurrentPair.AddPair(intArray[i],intArray[j]);
                nPairs++;
            }
            out.println();


            sum=i+1;
            if((sum).equals(j)==true){j--;i=-1;}
        }

        out.println(nPairs+" pairs"+"\n"+"Combinari: "+Combinari);
    }
}
