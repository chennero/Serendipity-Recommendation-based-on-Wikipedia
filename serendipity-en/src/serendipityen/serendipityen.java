package serendipityen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
/**
 * serendipity
 * @author chen
 */
public class serendipityen {

	public static void main(String[] args) {

        int stop=1;


		String temp;
        String parent,child;
        String addhobby;


		// TODO 自動生成されたメソッド・スタブ
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("The driver loaded successfully");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enwiki", "chen", "IpadCxy6");
			System.out.println("Successful database connection");
			String url="jdbc:postgresql://localhost:5432/chen";
            String user1="chen";
            String password = "IpadCxy6";
            Class.forName("org.postgresql.Driver");
            Connection conn1= DriverManager.getConnection(url, user1, password);
            //System.out.println("是否成功连接pg数据库"+conn1);
			while(stop==1) {
				int i=0;
				int j=0;
		        int n=0;
		        int d=0;
		        int m=0;
		        int r=0;
		        int l=600000;
		        int Nlength=0;
		        int max=0;


		       int h=0;
		       int hobbylength=0;
		       int bighobbylength=0;
			int[] Rlength=new int[255];
			String[] N=new String[255];
			String[] a=new String[255];

			String[][] SS=new String[256][l];
			String[] SS3=new String[l];
			String[][] M=new String[256][l];
			String[][] S=new String[256][l];
			String[][] R=new String[256][l];
			 String[] hobby=new String[l];
			 String[] bighobby=new String[l];
			 String[] A=new String[l];
			 String[] rlist=new String[255];
			Scanner userid=new Scanner(System.in);
			System.out.println("Please enter the userid");
			String user=userid.next();
			/*Statement Statement = conn.createStatement();
			String SQL="select * from interest where userid='"+user+"';";
			ResultSet ResultSet = Statement.executeQuery(SQL);
			if(!ResultSet.next()) {

			}*/
			 //String ks="";
			Scanner keyword=new Scanner(System.in);
			System.out.println("Please enter the selected keyword");
			String ks=keyword.next();
			//long long1 = System.currentTimeMillis();
			/*Statement statement0 = conn.createStatement();
			String sql0= "select distinct cl_to AS keyword FROM categorylinks "
					+ "where cl_to not like\"%記事%\"and cl_to not like\"%ページ%\" "
					+ "and cl_to not like\"%読みにくい%\"and cl_to not like \"%テンプレート%\" "
					+ "and cl_to not like\"%書きかけ%\"and cl_to not like \"%存命人物%\" "
					+ "and cl_to not like\"%項目%\"and cl_to not like \"%ウィキデータ%\" order by RAND() limit 1;";
			ResultSet resultSet0 = statement0.executeQuery(sql0);
			while(resultSet0.next()) {
		    ks=resultSet0.getString("keyword");
		    ks=new String(ks.getBytes("8859_1"), "UTF-8");
			System.out.println(ks);
			}
			resultSet0.close();
			statement0.close();*/


			Statement statement0 = conn.createStatement();
			//Statement statement0 = conn1.createStatement();
			String sql0="select keyword,count(keyword) as kc from interest "
					+ "where userid='"+user+"'group by keyword order by kc desc;";
			//String sql0= "select substr(title,0,position('(' in title))as keword from training,movies "
			//		+ "where training.movieid=movies.movieid and userid='118409' order by userid; ";
			ResultSet resultSet0 = statement0.executeQuery(sql0);
			while(resultSet0.next()) {
				//keyword = name.replace("'","\\'");
				bighobby[h]=resultSet0.getString("keyword");
				bighobby[h] = new String(bighobby[h].getBytes("8859_1"), "UTF-8").replace("'","\\'");
				//System.out.println(hobby[h]);
				bighobbylength++;
				h++;
			}
			//System.out.println(bighobbylength);
			if(bighobby[0]==null) {
				h=0;
			}
			resultSet0.close();
			statement0.close();
			h=0;i=0;
			Statement statement = conn.createStatement();
			while(i<bighobbylength){

			//Statement statement = conn1.createStatement();
			String sql =
					 "select distinct cl_to AS parent FROM page "
					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
					+ "WHERE page_title ='"+bighobby[i]+"'"

			        + "and cl_to not like \"%Use%\";";
			//String sql= "select substr(title,0,position('(' in title))as title from training,movies "
			//		+ "where training.movieid=movies.movieid and userid='118409' order by userid; ";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				//keyword = name.replace("'","\\'");
				hobby[h]=resultSet.getString("parent");
				hobby[h] = new String(hobby[h].getBytes("8859_1"), "UTF-8").replace("'","\\'");
				//System.out.println(hobby[h]);
				hobbylength++;
				h++;
			}
			//System.out.println(h);
			if(hobby[0]==null) {
				h=0;
			}
			i++;
			resultSet.close();
			}
			statement.close();

			Statement statement1 = conn.createStatement();
			String sql1 =
					 "select distinct cl_to AS parent FROM page "
					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
					+ "WHERE page_title ='"+ks+"'"

					 + "and cl_to not like \"%Use%\";";
			ResultSet resultSet1 = statement1.executeQuery(sql1);

            while(resultSet1.next()) {
                  N[i]=resultSet1.getString("parent");
            	N[i] = new String(N[i].getBytes("8859_1"), "UTF-8").replace("'","\\'");
            	//System.out.println(N[i]);
            	i++;
            	Nlength++;
            }
			resultSet1.close();
			statement1.close();
			/*Statement statement10 = conn.createStatement();
			String sql10 =
					 "select distinct page_title AS child FROM page "
					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
					+ "WHERE cl_to ='"+ks+"'"
							+ "and cl_to not like\"%記事%\"and cl_to not like\"%ページ%\""
							+ "and cl_to not like\"%読みにくい%\"and cl_to not like\"%テンプレート%\""
							+ "and cl_to not like\"%書きかけ%\"and cl_to not like\"%存命人物%\""
							+ "and cl_to not like\"%項目%\"and cl_to not like\"%ウィキデータ%\";";
			ResultSet resultSet10 = statement10.executeQuery(sql10);
			while(resultSet10.next()) {
                N[i]=resultSet10.getString("child");
          	N[i] = new String(N[i].getBytes("8859_1"), "UTF-8");
          	//System.out.println(N[i]);
          	i++;
          	Nlength++;
          }
			resultSet10.close();
			statement10.close();*/
			//if(hobby!=null) {


			Statement statement3 = conn.createStatement();
            i=0;j=0;r=0;

            while (i<Nlength) {


                String sql3 =
   					 "SELECT distinct page_title AS child FROM page "
   					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
   					+ "WHERE page_title!='"+ks+"'and cl_to ='"+N[i]+"';";

                ResultSet resultSet3 = statement3.executeQuery(sql3);
                //resultSet3.last();
                //int size=resultSet3.getRow();
                //resultSet3.first();
                //System.out.println(size);


                while(resultSet3.next()) {
                	SS[r][j] = resultSet3.getString("child");
                	SS[r][j] = new String(SS[r][j].getBytes("8859_1"), "UTF-8");

                	//System.out.println(S[r][j]);
                	j++;

                }

                j=0;
                if(SS[r][0]!=null) {
                    r++;
                    }
                    i++;
                resultSet3.close();
            }
            i=0;
            statement3.close();
            if(h!=0){
            	h=0;r=0;
            Statement statement2 = conn.createStatement();
            while(i<hobbylength) {
            	//System.out.println(hobbylength);
            String sql2 =
					 "SELECT distinct page_title AS child FROM page "
					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
					+ "WHERE cl_to ='"+hobby[i]+"';";
            ResultSet resultSet2 = statement2.executeQuery(sql2);

            while(resultSet2.next()) {


               M[h][n]=resultSet2.getString("child");
            	M[h][n] = new String(M[h][n].getBytes("8859_1"), "UTF-8");

            	n++;

            }
            //System.out.println(h);
            n=0;
            if(M[h][0]!=null) {
            h++;
            }
            i++;



            resultSet2.close();

            }

            statement2.close();
            /* i=0;
            Statement statement20 = conn.createStatement();
            while(i<hobbylength) {
            	//System.out.println(hobbylength);
            String sql20 =
					 "SELECT distinct page_title AS child FROM page "
					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
					+ "WHERE cl_to ='"+hobby[i]+"'and page_title not like\"%記事%\""
							+ "and page_title not like\"%ページ%\" and page_title not like\"%読みにくい%\""
							+ "and page_title not like\"%テンプレート%\"and page_title not like\"%書きかけ%\""
							+ "and page_title not like\"%存命人物%\";";
            ResultSet resultSet20 = statement20.executeQuery(sql20);
            while(resultSet20.next()) {


               M[h][n]=resultSet20.getString("child");
            	M[h][n] = new String(M[h][n].getBytes("8859_1"), "UTF-8");
            	//System.out.println(M[h][n]);
            	n++;

            }
            n=0;
            if(M[h][0]!=null) {
            h++;
            }
            i++;


            resultSet20.close();

            }

            statement20.close();*/
            //System.out.println(M[0][0]);
           // System.out.println(S[0][0]);
                i=0;j=0;n=0;h=0;
           while(M[h][0]!=null) {
            while(SS[i][0]!=null) {


            	   while(SS[i][j]!=null) {
                   while(M[h][n]!=null) {
                	   //System.out.println(M[h][n]);

        			if(SS[i][j].equals(M[h][n])) {
        				R[r][d]=M[h][n];

        				d++;
        			}
        			n++;
        		}
                   j++;
                   n=0;
               }
               if(R[r][0]!=null) {
            	r++;

               }
               i++;
           	d=0;
           	j=0;
            }
              if(R[r][0]!=null) {
            	r++;

               }
          h++;
          d=0;
          i=0;
            }




             r=0;d=0;
            if(R[r][d]==null) {
                 j=0;
            	Statement statement6 = conn.createStatement();
    			String sql6="select distinct recommend,count(recommend) as kc from mouseover "
    					+ "where keyword='"+ks+"'group by recommend order by kc desc;";
    			ResultSet resultSet6 = statement6.executeQuery(sql6);
    			if(resultSet6.next()) {
    				 a[j]=resultSet6.getString("recommend");
    				 j++;
    				while(resultSet6.next()) {
    					 a[j]=resultSet6.getString("recommend");
        				 j++;

    				}
    				resultSet6.close();
        			statement6.close();
    				System.out.println("Recommend Result：");

    				if(j<3) {
    	   				for(i=0;i<j;i++) {
    	   					rlist[i]=a[i];
    	   				}
    	   				rlist=elas(rlist);
    	   				for(i=0;i<j;i++) {

    	   					System.out.println(rlist[i]);

    	              	String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
    	                PreparedStatement ps = conn.prepareStatement(sql5);
    	                ps.executeUpdate();
    	                }
    	   				//System.out.println(set);
    	   				System.out.println("Collaborative Filtering");
    	   			}else {

    	   		 for(i=0;i<3;i++) {
    	   			 rlist[i]=a[i];
    	   		}
	   				rlist=elas(rlist);
	   				for(i=0;i<3;i++) {
    	   			System.out.println(rlist[i]);

    	             String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
    	             PreparedStatement ps = conn.prepareStatement(sql5);
    	             ps.executeUpdate();
    	              }
    	   		//System.out.println(set);
    	   		System.out.println("Collaborative Filtering");
    	   			}
    			}else {
    				/*for(i=0;i<r;i++) {
    		   			for(j=i+1;j<r;j++) {
    		        		if(SS[i]==SS[j]){
    		        			SS[j]=null;
    		        		}

    		        	}
    		   			}*/
    		   			Random random = new Random();
    		   			String[] hand=new String[l];
    		            j=0;

    		            for(i=0;SS[i][j]!=null;i++) {
    		            	for(j=0;SS[i][j]!=null;j++)

    		            		if(SS[i][j].equals(ks)==false) {
    		            		hand[r]=SS[i][j];
    		            		r++;
    		            		}


    		            }
    		   			System.out.println("Recommend Result:");

    		   			if(j<3) {
    		   				for(i=0;i<j;i++) {
    		   				rlist[i] = hand[random.nextInt(r)];
    		   				}
    		   				rlist=elas(rlist);
    		   				for(i=0;i<j;i++) {
    		              	  System.out.println(rlist[i]);

    		              	String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
    		                PreparedStatement ps = conn.prepareStatement(sql5);
    		                ps.executeUpdate();
    		                }
    		   				//System.out.println(set);
    		   				System.out.println("Random");
    		   			}else {

    		   		 for(i=0;i<3;i++) {
    		   			rlist[i] = hand[random.nextInt(r)];
    		   		}
 	   				rlist=elas(rlist);
 	   				for(i=0;i<3;i++) {
    		             System.out.println(rlist[i]);

    		             String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
    		             PreparedStatement ps = conn.prepareStatement(sql5);
    		             ps.executeUpdate();
    		              }
    		   		//System.out.println(set);
    		   		System.out.println("Random");
    			}
    			}

            }else {

            	while(R[r][0]!=null) {
                    while(R[r][d]!=null) {
                    	//System.out.println(R[r][d]);
                    	d++;
                    }
                    if(d>max) {
                    	max=d;
                    }
                    Rlength[r]=d;
                    r++;

                    d=0;
            	}

            	String[] x=new String[max*r+1];
            	d=0;
                for(i=0;i+1<r;i++) {
                    if(Rlength[i]>Rlength[i+1]) {
                    	while(R[i][d]!=null) {
                    	temp=R[i+1][d];
                    	R[i+1][d]=R[i][d];
                    	R[i][d]=temp;
                    	d++;
                    	}
                    }
                    d=0;
                }
                //冒泡排序，改成快速排序会不会更好
                r=0;d=0;m=0;

                while(R[r][0]!=null) {
                    while(R[r][d]!=null) {

                    	x[m]=R[r][d];
                    	m++;
                    	d++;
                    }
                    r++;
                    d=0;
            	}
                 j=0;
                // System.out.println(m);
                for(i=0;i<m;i++) {
                	//System.out.println(i);
                	//System.out.println(x[i]);
                	for(j=i+1;j<m;j++) {
                		//System.out.println(j);
                		//System.out.println(x[j]);
                		if(x[j]!=null) {
                		if(x[i]!=null) {
                		if(x[i].equals(x[j])){

                			x[j]=null;
                		}
                		}
                		}

                	}
                }


                j=0;

                for(i=0;i<m;i++) {


                	if(x[i]!=null) {
                		if(x[i].equals(ks)==false) {
                		rlist[j]=x[i];
                		j++;
                		}
                	}

                }
                rlist=elas(rlist);
                System.out.println("Recommend Result:");

                if(j<3) {
              for(i=0;i<j;i++) {

            	  System.out.println(rlist[i]);
            	  rlist[i]=rlist[i].replace("'","\\'");

            	  String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
                  PreparedStatement ps = conn.prepareStatement(sql5);
                  ps.executeUpdate();
              }
             // System.out.println(set);
              System.out.println("Intersect");
                }else {
                for(i=0;i<3;i++) {

               System.out.println(rlist[i]);
               rlist[i]=rlist[i].replace("'","\\'");
               String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
               PreparedStatement ps = conn.prepareStatement(sql5);
               ps.executeUpdate();
                }

                //long long2 = System.currentTimeMillis();
    			//System.out.println("実行時間:" + (long2 - long1) + "ms");
               // System.out.println(set);
                System.out.println("Intersect");
            }

            }
           }else {
        	   j=0;
        	   Statement statement6 = conn.createStatement();
   			String sql6="select distinct recommend,count(recommend) as kc from mouseover "
   					+ "where keyword='"+ks+"'group by recommend order by kc desc;";
   			ResultSet resultSet6 = statement6.executeQuery(sql6);
   			if(resultSet6.next()) {
   				a[j]=resultSet6.getString("recommend");
  				 j++;
   			while(resultSet6.next()) {
   				a[j]=resultSet6.getString("recommend");
   				 j++;

   				}
   			resultSet6.close();
			statement6.close();
			System.out.println("Recommend Result：");


				if(j<3) {
	   				for(i=0;i<j;i++) {
	   					rlist[i]=a[i];
	   				}
	   				rlist=elas(rlist);
	   				for(i=0;i<j;i++) {
	   					System.out.println(rlist[i]);

	              	String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
	                PreparedStatement ps = conn.prepareStatement(sql5);
	                ps.executeUpdate();
	                }
	   			// System.out.println(set);
	   			System.out.println("Collaborative Filtering");
	   			}else {

	   		 for(i=0;i<3;i++) {
	   			 rlist[i]=a[i];
	   		}
				rlist=elas(rlist);
				for(i=0;i<3;i++) {
	   			System.out.println(rlist[i]);

	             String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
	             PreparedStatement ps = conn.prepareStatement(sql5);
	             ps.executeUpdate();
	              }
	   		// System.out.println(set);
	   		System.out.println("Collaborative Filtering");
	   			}

   			}else {


            /*
          Statement statement6 = conn.createStatement();
            i=0;
int Nlength3=0;
            while (i<r) {
                parent = SS[i];


                String sql6 =
   					 "SELECT distinct page_title AS child FROM page "
   					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
   					+ "WHERE page_title!='"+ks+"'and cl_to ='"+parent+"'and page_title not like\"%記事%\""
   							+ "and page_title not like\"%ページ%\"and page_title not like\"%読みにくい%\"
   							and page_title not like\"%テンプレート%\"and page_title not like\"%書きかけ%\"
   							and page_title not like\"%存命人物%\";";

                ResultSet resultSet6 = statement6.executeQuery(sql6);


                while(resultSet6.next()) {


                		SS3[Nlength3]= resultSet6.getString("child");
                	SS3[Nlength3] = new String(SS3[Nlength3].getBytes("8859_1"), "UTF-8");


                	//System.out.println(S[i][j]);

                	Nlength3++;
                }

                    i++;
                resultSet6.close();
            }
            i=0;
            statement6.close();*/


   			/*for(i=0;i<r;i++) {
   			for(j=i+1;j<r;j++) {
        		if(SS[i]==SS[j]){
        			SS[j]=null;
        		}

        	}
   			}*/
            Random random = new Random();
   			String[] hand=new String[l];
            j=0;

            for(i=0;SS[i][j]!=null;i++) {
            	for(j=0;SS[i][j]!=null;j++) {

            		if(SS[i][j].equals(ks)==false) {
            		hand[r]=SS[i][j];
            		r++;
            		}
            	}

            }
   			System.out.println("Recommend Result:");

   			if(j<3) {
   				for(i=0;i<j;i++) {
   				rlist[i] = hand[random.nextInt(r)];
   				}
   				rlist=elas(rlist);
   				for(i=0;i<j;i++) {
              	  System.out.println(rlist[i]);

              	String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
                PreparedStatement ps = conn.prepareStatement(sql5);
                ps.executeUpdate();
                }
   				//System.out.println(set);
   				System.out.println("Random");
   			}else {

   		 for(i=0;i<3;i++) {
   			rlist[i] = hand[random.nextInt(r)];
   		}
			rlist=elas(rlist);
			for(i=0;i<3;i++) {
             System.out.println(rlist[i]);

             String sql5 ="insert into mouseover(keyword,recommend,time)values('"+ks+"','"+rlist[i]+"',now());";
             PreparedStatement ps = conn.prepareStatement(sql5);
             ps.executeUpdate();
              }
   		     //long long2 = System.currentTimeMillis();
		     //System.out.println("実行時間:" + (long2 - long1) + "ms");
   		//System.out.println(set);
   		System.out.println("Random");
			}

           }



			}
			Scanner select=new Scanner(System.in);
			System.out.println("Do you want to choose from the result(yes/no)");
			String st=select.next();
			if(st.equals("yes")) {
            Scanner selectkeyword=new Scanner(System.in);
			System.out.println("Please enter the keyword you want to choose");
			String sk=selectkeyword.next();
			/*Statement statement4 = conn.createStatement();
			String sql4 =
					 "select distinct cl_to AS parent FROM page "
					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
					+ "WHERE page_title ='"+sk+"';";
			ResultSet resultSet4 = statement4.executeQuery(sql4);
            i=0;Nlength=0;
           while(resultSet4.next()) {
                 A[i]=resultSet4.getString("parent");
           	A[i] = new String(A[i].getBytes("8859_1"), "UTF-8");
           	//System.out.println(N[i]);
           	i++;
           	Nlength++;
           }
			resultSet4.close();
			statement4.close();


			for(i=0;i<Nlength;i++) {
                addhobby=A[i];
                String sql5 ="insert into interest(userid,keyword,time)values('"+user+"','"+sk+"',now());";

                PreparedStatement ps = conn.prepareStatement(sql5);
                ps.executeUpdate();

			}*/


             String sql7 ="insert into interest(userid,keyword,time)values('"+user+"','"+sk+"',now());";

                PreparedStatement ps1 = conn.prepareStatement(sql7);
                ps1.executeUpdate();
			}
			}
            conn.close();
            System.out.println("Close the database");


		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Can't load the driver");
		}


	}
	public static String[] elas(String[] p)
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enwiki", "chen", "IpadCxy6");
		int i=0;String a="";
		int[] count=new int[255];
		Statement statement6 = conn.createStatement();
		while(i<3) {
			String sql6 =
					 "select count(distinct cl_to) AS count FROM page "
					+ "JOIN categorylinks ON categorylinks.cl_from=page.page_id "
					+ "WHERE page_title ='"+p[i]+"'and cl_to!='"+p[i]+"';";
			ResultSet resultSet6 = statement6.executeQuery(sql6);

           while(resultSet6.next()) {
                 count[i]=resultSet6.getInt("count");

           	//System.out.println(NN[i]);


           }
           if(i>0){
        	   if(count[i]>count[i-1]){
        	   a=p[i-1];
        	   p[i-1]=p[i];
        	   p[i]=a;
        	   }
        	   }
        	   if(i>1){
        	   if(count[i]>count[i-1]){
        	   a=p[i-1];
        	   p[i-1]=p[i];
        	   p[i]=a;
        	   }
        	   }

           i++;
			resultSet6.close();
		}
			statement6.close();
		}catch(Exception e){
			e.printStackTrace();

		}
	  return p;
	}
}



