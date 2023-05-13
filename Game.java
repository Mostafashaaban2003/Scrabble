import java.util.Scanner;

public class Game {
	
	// define some variables
	// why static ? to call this direct and static reduces memory consumption and makes the program faster
	
	// array of word and and score have 2 index because after every match we don't need this index so We destroyed it! and make new
	 static int score[] = new int[2];
	 static String word[] = new String[2];
	 static Scanner inp = new Scanner(System.in);
	 static int r;
	 static int win0;
	 static int win1;
	 
	 // if i did not specifes the size of the matrix compiler results runtime error
	 static String name[] = new String[8];
	 static String id[] = new String[8];
	 
	 static void info()
	 {
		 System.out.println("Enter names and ID\n");
			
			for (int i = 0; i < 8; i++)
			{
					System.out.print("\nPlayer "+ (i+1) + " name: ");
					 name[i] = inp.next();
					 
					 System.out.print("Player "+ (i+1) + " ID: ");
					 id[i] = inp.next();
				 
			}
	 }
	   
	   static void competitions(int loop)
		{
			// print matches (player1 vs player2)
			for(int i = 0; i < loop; i++) 
				System.out.println(name[i] + " VS " + name[++i] +"\n");
			
		}
	   
	// I pass two parameters to function to try to make the code less
	   static void Match(int loop1 , int loop2)
		{
		    
			// matches and record qualifiers
			for(int i = 0; i < loop1; i+=2)
			{
				
				 win0 = 0;
				 win1 = 0;
				 r = 1;
				System.out.println(name[i] + " VS " + name[i+1]);
				do
				{
					// if Tie it loops till any player wins
					System.out.println("Round " + r +"\n");
					System.out.print(name[i] + ": ");
					word[0] = inp.next();
					System.out.print(name[i+1] + ": ");
					word[1] = inp.next();
					score[0] = compute_score(word[0]);
				    score[1] = compute_score(word[1]);
				    if (score[0] > score[1]) 
				    {
				    	System.out.println(name[i] + " Win\n");
				    	win0++;
				    }
				    		
				    
				    else if(score[0] < score[1])
				    {
				    	System.out.println(name[i+1] + " Win\n");
				    	win1++;
				    }
				    	
				    	
				    else System.out.println("Tie");	
				    
				    // to get qualifiers
				    for(int j = 0 ; j < loop2 ; j++)
				    {
				    if(win0 == 2 && 2*j == i) // if player 1 win
				    {
				    	name[j]= name[i];
				    	System.out.println(name[j] + " qualified\n");
				    }
						
				    else if(win1 == 2 && 2*j == i) // if player 2 win
				    {
				    	name[j]= name[i+1];
					    System.out.println(name[j] + " qualified\n");
				    }
						
				    }
					r++;
				}while(!(win0 == 2  || win1 == 2));
			}
			
		}
	   static void winner()
	   {
		   // to get the winner
		   if(win0 ==2 )
				System.out.println(name[0] + " is the Winner Of the Game\n");
			if(win1 ==2 )
				System.out.println(name[1] + " is the Winner Of the Game\n");
	   }
	   static int compute_score(String word)
		{
		    // TODO: Compute and return score
		    // this array to make every character score
		    int POINTS[] = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		    int score = 0;
		    for (int j = 0; j < word.length(); j++)
		    {
		        if ((word.charAt(j)) >= 'a' && word.charAt(j) <= 'z') // if character is lowercase
		        {
		            score += POINTS[word.charAt(j) - 97];
		        }
		        else if ((word.charAt(j) >= 'A' && word.charAt(j) <= 'Z')) // if character is uppercase
		        {
		            score += POINTS[word.charAt(j) - 65];
		        }
		        else // if input isn't character
		        {
		            score = 0 + score;
		        }
		    }
		    return score;
		}

}
