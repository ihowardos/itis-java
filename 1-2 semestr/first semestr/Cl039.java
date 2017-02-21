public class Cl039 {
    public static void main(String[] args) {
        int k=34, n=5, m=3, a, counter=0, counter2=0, counter3;
        int [][] p = new int[m][n];
        int []p1=new int[6];

        int [][]p2=new int[n*m][2];
        int [][]p3=new int[n*m][2];
        int [][]p4=new int[n*m][2];
        int [][]p5=new int[n*m][2];
        int [][]p6=new int[n*m][2];
        boolean stop=true;

        p[0][0]=2; p[0][1]=3; p[0][2]=4; p[0][3]=3; p[0][4]=4;
        p[1][0]=1; p[1][1]=4; p[1][2]=2; p[1][3]=3; p[1][4]=4;
        p[2][0]=3; p[2][1]=4; p[2][2]=5; p[2][3]=0; p[2][4]=3;

        //for (int i=0; i<n; i++)
            //p2[i][0]=p3[i][0]=p3[i][1]=p2[i][1]=0;


        for (int i=0; i<m; i++) {
            for (int j=0; j < n; j++) {
                System.out.print(p[i][j]);
            }
            System.out.println();
        }
//переписать для 0 в числе
        while (stop){
            a=k%10;//450
            p1[counter]=a;//p1[0]=4
            stop=(a!=0);
            counter++;
            k=k/10;
        }//p1=450000

        int [] p1r=new int[counter-1];
        int [] p1s=new int[counter-1];
        for (int i=counter-2; i>=0; i--){
            p1s[counter-2-i]=p1[i];//34
            p1r[i]=p1[i];//43
        }
        System.out.println();

        for (int aP1s : p1s) {System.out.print(aP1s);}
        System.out.println();

        for (int ap1:p1r) System.out.print(ap1);
        System.out.println();

        //search reverse horizontal
        counter3=0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if ((p[i][j]==p1r[counter2])&&(counter2<p1r.length)){
                    counter2++;
                }
                else counter2=0;

                if ((counter2==p1r.length)){
                    for (int z=0; z<p1r.length; z++){
                        p2[z+counter3][0]=i; p2[z+counter3][1]=j-p1r.length+z+1;
                    }
                    counter3+=counter2; counter2=0;
                }
            }
            counter2=0;
        }

        //search straight horizontal
        counter3=0;
        for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                if ((p[i][j]==p1s[counter2])&&(counter2<p1s.length)){
                    counter2++;
                }
                else counter2=0;

                if ((counter2==p1s.length)){
                    for (int z=0; z<p1s.length; z++){
                        p3[z+counter3][0]=i; p3[z+counter3][1]=j-p1s.length+z+1;
                    }
                    counter3+=counter2; counter2=0;
                }
            }
            counter2=0;
        }

        //search reverse vertical
        counter3=0;
        for (int j=0; j<n; j++){
            for (int i=0; i<m; i++){
                if ((p[i][j]==p1r[counter2])&&(counter2<p1r.length)){
                    counter2++;
                }
                else if ((p[i][j]!=p1r[counter2])&&(counter2>=1)) {counter2=0; i--;}
                else counter2=0;

                if ((counter2==p1r.length)){
                    for (int z=0; z<p1r.length; z++){
                        p4[z+counter3][0]=i-p1r.length+z+1; p4[z+counter3][1]=j;
                    }
                    counter3+=counter2; counter2=0;
                }
            }
            counter2=0;
        }

        //search straight vertical
        counter3=0;
        for (int j=0; j<n; j++){
            for (int i=0; i<m; i++){
                if ((p[i][j]==p1s[counter2])&&(counter2<p1s.length)){
                    counter2++;
                }
                else if ((p[i][j]!=p1s[counter2])&&(counter2>=1)) {counter2=0; i--;}
                else counter2=0;

                if ((counter2==p1s.length)){
                    for (int z=0; z<p1s.length; z++){
                        p5[z+counter3][0]=i-p1s.length+z+1; p5[z+counter3][1]=j;
                    }
                    counter3+=counter2; counter2=0;
                }
            }
            counter2=0;
        }

        //create matrix from diagonal elements
        /*int m1, n1;
        if (n>m){n1=n; m1=m;} else {n1=m; m1=n;}
        int [][] pnew1=new int [2*(n1-m1+1)][m1];
            for (int i=0; i<(n1-m1+1); i++){
                for (int j=0, z=0; j<m1; j++, z++){
                    pnew1[i][z]=p[j][j+i];
                    pnew1[2*(n1-m1+1)-i-1][z]=p[j][n1-1-j-i];
                }
            }*/

        int m1, n1; counter3=0;
        if (n>m){n1=n; m1=m;} else {n1=m; m1=n;}
        int [][] pnew1=new int [2*(n1-m1+1)][m1];
        for (int i=0; i<(n1-m1+1); i++){
            for (int j=0, z=0; j<m1; j++, z++){
               /////
                if ((p[j][j+i]==p1r[counter2])&&(counter2<p1r.length)){
                    counter2++;
                }
                else counter2=0;

                if ((counter2==p1r.length)){
                    for (int z1=0; z1<p1r.length; z1++){
                        p6[z1+counter3][0]=j-p1r.length+z1+1; p6[z1+counter3][1]=j+i-p1r.length+z1+1;
                    }
                    counter3+=counter2; counter2=0;
                }

                ////
                pnew1[i][z]=p[j][j+i];
                pnew1[2*(n1-m1+1)-i-1][z]=p[j][n1-1-j-i];
            }
            counter2=0;
        }



        System.out.println("PNEW1");
        for (int i=0; i<2*(n1-m1+1); i++) {
            for (int j=0; j<m1; j++) {
                System.out.print(pnew1[i][j]);
            }
            System.out.println();
        }
        System.out.println();




        System.out.println("reverse horizontal");
        stop=true;
        for (int i=1; i<n*m; i++) {
                if ((p2[i-1][0]==0)&&(p2[i-1][1]==0)&&(p2[i][0]==0)&&(p2[i][1]==0)) {
                    stop=false; break; }
                System.out.println(p2[i-1][0] + ":" + p2[i-1][1]);
            }

        if(stop){
            System.out.println(p2[p2.length-1][0] + ":" + p2[p2.length-1][1]);
        }

        System.out.println("straight horizontal");
        stop=true;
        for (int i=1; i<n*m; i++) {
            if ((p3[i-1][0]==0)&&(p3[i-1][1]==0)&&(p3[i][0]==0)&&(p3[i][1]==0)) {
                stop=false; break; }
            System.out.println(p3[i-1][0] + ":" + p3[i-1][1]);
        }

        if(stop){
            System.out.println(p3[p3.length-1][0] + ":" + p3[p3.length-1][1]);
        }

        System.out.println("reverse vertical");
        stop=true;
        for (int i=1; i<n*m; i++) {
            if ((p4[i-1][0]==0)&&(p4[i-1][1]==0)&&(p4[i][0]==0)&&(p4[i][1]==0)) {
                stop=false; break; }
            System.out.println(p4[i-1][0] + ":" + p4[i-1][1]);
        }

        if(stop){
            System.out.println(p4[p4.length-1][0] + ":" + p4[p4.length-1][1]);
        }

        System.out.println("straight vertical");
        stop=true;
        for (int i=1; i<n*m; i++) {
            if ((p5[i-1][0]==0)&&(p5[i-1][1]==0)&&(p5[i][0]==0)&&(p5[i][1]==0)) {
                stop=false; break; }
            System.out.println(p5[i-1][0] + ":" + p5[i-1][1]);
        }

        if(stop){
            System.out.println(p5[p5.length-1][0] + ":" + p5[p5.length-1][1]);
        }

        System.out.println("main diagonals reverse");
        stop=true;
        for (int i=1; i<n*m; i++) {
            if ((p6[i-1][0]==0)&&(p6[i-1][1]==0)&&(p6[i][0]==0)&&(p6[i][1]==0)) {
                stop=false; break; }
            System.out.println(p6[i-1][0] + ":" + p6[i-1][1]);
        }

        if(stop){
            System.out.println(p6[p6.length-1][0] + ":" + p6[p6.length-1][1]);
        }


        /*System.out.println("straight horizontal");
        for (int i=0; i<n*m; i++) {
            System.out.println(p3[i][0]+":"+p3[i][1]);
        }
        System.out.println("reverse vertical");
        for (int i=0; i<n*m; i++) {
            System.out.println(p4[i][0]+":"+p4[i][1]);
        }
        System.out.println("straight vertical");
        for (int i=0; i<n*m; i++) {
            System.out.println(p5[i][0]+":"+p5[i][1]);
        }*/
    }
}
