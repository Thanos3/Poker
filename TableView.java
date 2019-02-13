public class TableView
{
  private Table t;
  
  public TableView(Table t3)
  {
    t = t3;
  }
  public int getPot()
  {
    return t.getPot();
  }
  public int getNumCardsExchanged(int seat)
  {
    return t.getPlayer(seat).getNumCardsExchanged(); 
  }
  public int getDealer()
  {
    return t.getDealer();
  }
  public int getBet(int seat)
  {
    return t.getPlayer(seat).getBet();
  }
  public int getStack(int seat)
  {
    return t.getPlayer(seat).getStack();
  }
  public boolean hasFolded(int seat)
  {
    return t.getPlayer(seat).hasFolded();
  }
  public boolean isEmpty(int seat)
  {
    return t.getPlayer(seat) == null;
  }
  
  public int getSize()
  {
    return t.getSize();
  }
  
  public String toString()
  {
    String s2 =("pot:  " + getPot() + "\n");
    for(int i = t.getSize() - 1; i >= 0; i--)
    {
      if(isEmpty(i) == false) 
      {
        if (i == getDealer())
          s2 += "D";
        else
          s2 += " ";
        if (i == t.getActiveSeat())
          s2 += "*";
        else
          s2 += " ";
        
        s2 += "Seat " + i + ":  ";
        if (t.showDown())
          s2 += t.getPlayer(i).toString();
        else
          s2 += t.getPlayer(i).publicToString();
        s2 += "\n";
      }
    }
    
    return s2; 
  }
  
  
  public int getCall() // this is the maximum bet currently in front of a player
  {
    return t.getCall();
  }
  
  //only returns hands that have been shown to table
  //returns copies of arrays, so original hands cannot be changed
  public Card[] getHand(int seat)
  {
    if (t.showDown() && !t.getPlayer(seat).hasFolded())
    {
      Card[] hand = t.getPlayer(seat).getHand();
      Card[] copy = new Card[hand.length];
      for (int i = 0; i < hand.length; i++)
        copy[i] = hand[i];
      return copy;
    }
    else
      return null;
  }
}
