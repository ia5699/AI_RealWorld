import java.util.*;
class tsp3
{
    public static void main (String args[])
    {
        int i,j,k,n;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of cities");
        n=sc.nextInt();
        char temp;
        char s,s2;
        double paths[]=new double [6];
        String way[]=new String [6];
        double a[][]=new double [n][n];
        char b[]=new char [n];
        int l=0;
        System.out.println("enter city names");
        for(i=0;i<n;i++)
            
        {   way[i]=" ";
            b[i]=sc.next().charAt(0);
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
               {
                   System.out.println("enter distance from "+b[i]+" to "+b[j]);
                   a[i][j]=sc.nextDouble();
                }
        }
        double path=0.0;
        int p=1;
        int p1=0,p2=0;
        for(i=0;i<n;i++)
        {
            System.out.print(b[i]+"-->");
            if( i!=n-1)
                path+=a[i][i+1];
            way[l]=way[l]+b[i]+"-->";
        }
        path+=a[n-1][0];
        System.out.print("a");
        way[l]=way[l]+'a';
        System.out.println();
        System.out.println("cost: "+path); 
        paths[l]=path;l++;
        path=0;
        while(p!=6)
        {
            for(i=1;i<n-1;i++)
            {
                temp=b[i];
                b[i]=b[i+1];
                b[i+1]=temp;
                p++;
                for(j=0;j<n;j++)
                   { 
                       System.out.print(b[j]+"-->");
                       way[l]=way[l]+b[i]+"-->";
                       s=b[j];
                       if(j<n-1)
                        s2=b[j+1];
                       else
                        s2=b[0];
                       
                       p1=(int)s;
                       p1-=97;
                       p2=(int)s2;
                       p2-=97;
                       path+=a[p1][p2];
                    }
                    
                    System.out.print("a");
                    System.out.println();
                    System.out.println("cost: "+path);
                    way[l]=way[l]+'a';
                    paths[l]=path;
                    l++;
                    path=0;
                
                    if(p==6)
                    break;
                
            }
        }
        double min;
        min=paths[0];
        int o=0;
        for(i=0;i<n;i++)
        {
            if(paths[i]<min)
                {
                    o=i;
                    min=paths[i];
                }
        }
        System.out.println();
        System.out.println("optimal path="+way[o]);
        System.out.println("optimal cost=" +min);
    }
}
    
   