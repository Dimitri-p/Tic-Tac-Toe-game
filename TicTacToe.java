import java.util.Scanner;
import java.lang.Math;
public class TicTacToe
{  Scanner kbd = new Scanner(System.in);
   public int size;
   public String[] names = new String[2]; 
   public String[][] g = new String[1][1]; 
   public int row=0, col=0;
   public boolean p1 = true, p2 = false;
   String player = "";
   
   public TicTacToe(int size, String[] playersNames)
   {  int rand = (int)(Math.random() * 10)+1;
    if(rand >=5)
    {
        names[0] = playersNames[1];
        names[1]= playersNames[0];
    }
    else if(rand<5)
    {
         names[0] = playersNames[0];
        names[1]= playersNames[1];
    }
    //  System.out.println(rand);
      this.size = size;
      String[][] rg = new String[size][size];
      g = rg;
      initializeGrid();
   }

   private void initializeGrid()
   {
      for(int i=0; i<size; i++)
      {    
          for(int j=0; j<size; j++)
          {   
              g[i][j] = " - ";  
              System.out.print(" - ");
          }
          System.out.println();
      }
   }

   public void setPlayer()
   { 
      if(p1 == true)
      {
          player = names[0];
          System.out.print(player);
          p1 = false;
          p2 = true;
      }
      else if (p2 == true)
      {
          player = names[1];
          System.out.print(player);
          p2 = false;
          p1 = true;
      }
   }

   public void play()
   {        
          
          setPlayer();
          getPosition();
          boolean freeC = isOccupied();
          
          while(!freeC)
          {
              System.out.println("The cell you entered is not free. Please pick another");
              getPosition();
              freeC = isOccupied();
          }
          if( isOccupied())
          {     
              if(player.equals(names[0]))
              {
                  g[row][col] = " X ";
              }
              else if(player.equals(names[1]))
              {
                  g[row][col]= " O ";
              }
          }
          System.out.println(toString() );
          
          
      
      
   }
   public void getPosition()
   {  
      System.out.print(" enter row and colum: ");
     int ro = kbd.nextInt();
     int coltemp = kbd.nextInt();
      row = ro-1;
      col = coltemp-1;
      System.out.println();
      if(row >= size || col >= size || row<0 || col <0)
      {
         System.out.print("Please type a valid input: ");
          getPosition();
          /*System.out.print("Please type a valid input: ");
          ro = kbd.nextInt();
          coltemp = kbd.nextInt();
          row = ro-1;
          col = coltemp-1;*/
      }
     
   }

   public boolean isFull()
   {
      boolean full = false;
      int switch1 =0;
      for(int i=0; i<g.length; i++)
      {    
          for(int j=0; j<g[i].length; j++)
          {
              if(g[i][j].equals(" - "))
              {
                  full = false;
                  switch1 = 1;
              }
              else
              {
                  full = true;
              }
              
          }
      }
      if(switch1 == 1)
      {
          full = false;
      }
      if(full)
      {
          System.out.print("It’s a tie");
      }
      return full;
        
   }
   
   public boolean isOccupied() 
   {
      int a = row;
      int b = col;
     
      boolean freeCell = false;
      if(g[a][b].equals(" - "))
      {
          freeCell = true;
      }
      return freeCell;
      
   }

   public boolean winner()   
   {  int f = 0;
    String hah = "";
       int proove = 0;
      boolean win = false;
     int diapistosh = 0;
     boolean letsSee= false;
     
      if(size == 3)
      {
      for(int i=1; i<g.length-1; i++)
      {   
          if(g[i][0]==g[i-1][0] && g[i-1][0]==g[i+1][0] )
          {
              if( g[i][0].charAt(1) == '-')
                  {
                      win = false;
                  }
                  else
                  {   
                      proove =1;
                     win = true; 
                     //System.out.println("1");
                  }
          }
          for(int j=1; j<g[i].length-1; j++)
          {     //vertical win
              if(g[0][j]== g[0][j-1] && g[0][j-1]==g[0][j+1])
              {
                   if( g[0][j].charAt(1) == '-')
                  {
                      win = false;
                  }
                  else
                  {  //System.out.println("2");
                      proove =1;
                     win = true; 
                  }
              }
              if(g[i][j]==g[i-1][j] && g[i+1][j]==g[i-1][j])
              {   
                  if( g[i][j].charAt(1) == '-')
                  {
                      win = false;
                  }
                  else
                  {  //System.out.println("3");
                      proove =1;
                     win = true; 
                  }
              }
              // horizontal win
              else if(g[i][j]== g[i][j-1] && g[i][j-1]==g[i][j+1])
              {
                 if( g[i][j].charAt(1) == '-')
                  {
                      win = false;
                  }
                  else
                  { //System.out.println("4");
                     proove =1;
                     win = true; 
                     System.out.println("horizontal");
                  }
              }
              //diagonal
              else if(g[i][j]==g[i-1][j+1] && g[i-1][j+1]==g[i+1][j-1] )
              {
                 if( g[i][j].charAt(1) == '-')
                  {
                      win = false;
                  }
                  else
                  { 
                     proove =1;
                     win = true; 
                     //System.out.println("5");
                  }
              }
              else if(g[i][j]==g[i+1][j+1] && g[i+1][j+1].equals(g[i-1][j-1]) )
              {
                  if( g[i][j].charAt(1) == '-')
                  {
                      win = false;
                  }
                  else
                  {  //System.out.println("6");
                     proove =1;
                     win = true; 
                  }
              }
   
          }
      }
      
      for(int j=1; j<size-1; j++) //DEBUG
      {
          if(g[size-1][j]==g[size-1][j+1] && g[size-1][j+1]==g[size-1][j-1])
          {
              if( g[size-1][j].charAt(1) == '-')
                  {
                      win = false;
                  }
                  else
                  { // System.out.println("7");
                     proove =1;
                     win = true; 
                  }
          }
      }
      
      for(int i=1; i<size-1; i++)
      {
          if(g[i][size-1]==g[i+1][size-1] && g[i+1][size-1]==g[i-1][size-1])
          {
              if( g[i][size-1].charAt(1) == '-')
                  {
                      win = false;
                  }
                  else
                  {  //System.out.println("8");
                     proove =1;
                     win = true; 
                  }
          }
      }
      }
      
      else if(size>3)
      {      
            
            
         int tes4=0;
         for(int i=0; i<g.length-1; i++)
          {     hah =g[0][0];
              //for(int j=0; j<g[i].length-1; j++)
             // {   
                  if(hah==g[i+1][i+1])
                  {
                     
                      if( g[i+1][i+1].charAt(1) == '-')
                      {
                      win = false;
                      }
                      else if(g[i][i]!=g[i+1][i+1])
                      {   tes4=1;
                          f=0;
                      }
                      else if(hah==g[i+1][i+1]){
                         f = 111;
                         //System.out.println("9");
                  //    }
                      
                  }
                  else
                  {  
                      f=0;
                  }
              }
          }
         if(tes4 ==1)
          {
              win=false;
              f=0;
          }
          //left to downright 
          int tes3 =0;
          if(row+col==size-1)
          {
              String temleft = g[row][col];
             
              
              for(int i=1; i<g.length-1; i++)
             {
              for(int j=1; j<g[i].length-1; j++)
              {  
                  if(i+j==size-1)
                  {   //System.out.println("mpike mesa");
                      if( g[i][j].equals(" - "))
                      {
                      win = false;
                      }
                     else if( g[i][j].equals(g[i+1][j-1]) && g[i][j]== g[i-1][j+1])
                      { //System.out.println("10");
                          f=111;
                      }
                      else
                      { 
                          f=0;
                          tes3=1;
                      }
                  }
              }
            }
          
          }
          // na kanw delete
          if(tes3 ==1)
          {
              win=false;
              f=0;
          }
          //left down akuro canceled 
          /*if(row+col==size-1)
          {
              String temleft = g[row][col];
             
              
              for(int i=0; i<g.length; i++)
             {
              for(int j=0; j<g[i].length; j++)
              {  
                  if(i+j==size-1)
                  {   
                      if( temleft.equals(" - "))
                      {
                      win = false;
                      }
                     else if(g[i][j]==temleft)
                      { //System.out.println("10");
                          f=111;
                      }
                      else
                      { 
                          f=0;
                      }
                  }
                  
              }
            }
           
          }*/
          
           String t = g[row][col];
          //katheto *************************************************************** douleuei
         
          int tes = 0;
          for(int i=0; i<g.length; i++)
          {     hah = g[0][col];
             // for(int j=0; j<g[i].length; j++)
             // {
                  if(!hah.equals(g[i][col])){
                  letsSee = false;
                  tes =1;
                  }
                  else if(hah.equals(" - "))
                  {
                      letsSee = false;
                  }
                  else 
                  {
                     letsSee= true;
                  }
             // }
          }
          if(tes ==1)
          {
              letsSee = false;
          }
          
      //  ORIZONTIO******************************************************************************
      int tes2 = 0;
       for(int i=0; i<g.length; i++)
       {
           hah = g[row][0];
           if(!hah.equals(g[row][i]))
           {
               letsSee = false;
               tes2 = 1;
           }
           else if(hah.equals(" - "))
                  {
                      letsSee = false;
                  }
           else
           {
               letsSee = true;
           }
       }
       if(tes2 ==1)
          {
              letsSee = false;
          }
       
      System.out.print(letsSee);
      }
      if(letsSee == true)
      {
          win = true;
      }
      if(diapistosh == 1)
      {
          win = false;
      }
      if(f == 111)
      {
          win = true;
      }
     
      if (proove==1)
      {
          win = true;
      }
      
      if(win)
      {
         System.out.println(player + " is a winner"); 
      }
      
      return win;
   }
   
   @Override
   public String toString()
   {    
       String out = "";
       for(int i =0; i<g.length; i++)
       {
           for(int j=0; j<g[i].length; j++)
           { 
               out += g[i][j];
           }
           out += "\n";
       }
       return out;
   }
}