package com.company;
import static java.lang.System.*;

class Pairs
{
    private int Length=0;
    private Integer[][] List;

    protected Pairs()
    {
        List=new Integer[3][10000];
    }

    protected boolean CheckPair(Integer x,Integer y,Integer z)
    {
        for(int i=0;i<Length;i++)
        {
            int ok=0;
            if((List[0][i]).equals(x) | (List[1][i]).equals(x) | (List[2][i]).equals(x))ok++;
            if((List[0][i]).equals(y) | (List[1][i]).equals(y) | (List[2][i]).equals(y))ok++;
            if((List[0][i]).equals(z) | (List[1][i]).equals(z) | (List[2][i]).equals(z))ok++;

            if(ok>=3)return false;
        }

        return true;
    }

    protected void AddPair(Integer x,Integer y,Integer z)
    {
        List[0][Length]=x;
        List[1][Length]=y;
        List[2][Length]=z;
        Length++;
    }
}

public class Main {



    public static void main(String[] args) {

        Pairs CurrentPairs=new Pairs();
        Integer[] intArray={3,-2,-1,-3,3,0,5,-6,5,-2,0,-2,-3};
        int Combinari=0;
        int n=intArray.length;
        int nPairs=0;
        Integer nullSum=0;


        for(int firstIndex=0, secondIndex=n-2, finalIndex=n-1;firstIndex<secondIndex;firstIndex++)
        {
            Integer sum=intArray[firstIndex]+intArray[secondIndex]+intArray[finalIndex];
            Combinari++;

            out.print(firstIndex+" "+ secondIndex+ " "+finalIndex +" ");

            if(sum.equals(nullSum) & CurrentPairs.CheckPair(intArray[firstIndex],intArray[secondIndex],intArray[finalIndex])) {
                CurrentPairs.AddPair(intArray[firstIndex], intArray[secondIndex], intArray[finalIndex]);
                out.print(intArray[firstIndex] + " " + intArray[secondIndex] + " " + intArray[finalIndex]);
                nPairs++;
            }

            out.println();

            sum=firstIndex+1;
            if((sum).equals(secondIndex)){secondIndex--;firstIndex=-1;}
            if(secondIndex==0){secondIndex=finalIndex-2;finalIndex--;}
        }


        out.println(nPairs+" pairs"+"\n"+"Numar Combinari: "+Combinari);
    }
}
