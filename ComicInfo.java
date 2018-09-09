/*
   note:
	
	chComicPubType: 'd'  for DC Comics
	                'm'  for Marvel Comics
						 'o'  for Other 


 */
class ComicInfo
{

  private String strComicTitle;
  private String strComicPub;
  private char chComicPubType;
  private int intComicVol;
  private int intComicIssue;
  private double doubComicPrice;
  private int intComicStock;
  private String strComment;
  private String strCover;

  ComicInfo(String title, String pub, char cType, int vol, int issue, double price, int stk, String comment, String cover)
  {
  
    strComicTitle = title;
    strComicPub = pub;
    chComicPubType = cType;
    intComicVol = vol;
    intComicIssue = issue;
    doubComicPrice = price;
    intComicStock = stk;
    strComment = comment;
    strCover = cover;   

      
  }
  public void setStrComicTitle(String title)
  {
    strComicTitle =  title;
  }
  public void setStrComicPub(String publisher)
  {
    strComicPub = publisher;
  }
  public void setChComicPubType(char pubType)
  {
    chComicPubType = pubType;
  }
  public void setIntComicVol(int volume)
  {
    intComicVol = volume;
  }
  public void setIntComicIssue(int issue)
  {
    intComicIssue = issue;
  }
  public void setDoubComicPrice(double price)
  {
    doubComicPrice = price;
  }
  public void setIntComicStock(int stock)
  {
    intComicStock = stock;
  }
  public void setStrComicComment(String comment)
  {
    strComment = comment;
  }
  public void setStrComicCover(String cover)
  {
    strCover = cover;
  }
  public String getStrComicTitle()
  {
    return strComicTitle;
  }
  public String getStrDisplay()
  {
    String temp = strComicTitle + " Vol: " + intComicVol + " #. " + intComicIssue + " Pub: " + strComicPub;
    return temp;
  }
  public String getStrComicPub()
  {
    return strComicPub;
  }
  public char getChComicPubType()
  {
    return chComicPubType;
  }
  public int getIntComicVol()
  {
    return intComicVol;
  }
  public int getIntComicIssue()
  {
    return intComicIssue;
  }
  public double getDoubComicPrice()
  {
    return doubComicPrice;
  }
  public int getIntComicStock()
  {
    return intComicStock;
  }
  public String getStrComicComment()
  {
    return strComment;
  }
  public String getStrComicCover()
  {
    return strCover;
  }

  ////////////////////////////////////////////////
  //Finish this class by writing the various public set/get methods
  // for the above instance variables
  ////////////////////////////////////////////////

  
  
      
}

///////////////////////////////

class ComicList
{

  ComicInfo[] cmicList;
  
  
  public void createList()
  {
  
    cmicList = new ComicInfo[19];
    cmicList[0] = new ComicInfo("Action Comics","DC",'d',1,1,25382.46,4,"First appearance of Superman","src\\action01.jpg");
    cmicList[1] = new ComicInfo("Action Comics","DC",'d',1,252,382.91,7,"First appearance of Supergirl","src\\action252.jpg");
    cmicList[2] = new ComicInfo("Detective Comics","DC",'d',1,27,425382.82,3,"First appearance of Batman","src\\detective27.jpg");
    cmicList[3] = new ComicInfo("Detective Comics","DC",'d',1,38,1282.84,2,"First appearance of Robin","src\\detective38.jpg");
    cmicList[4] = new ComicInfo("Superman","DC",'d',2,75,2123.19,5,"Death of Superman","src\\superman75.jpg");
    cmicList[5] = new ComicInfo("The Dark Knight Returns","DC",'d',1,1,923.19,5,"Frank Miller's revival of the Batman","src\\dk01.jpg");
    cmicList[6] = new ComicInfo("Watchmen","DC",'d',1,1,2123.19,5,"<html>First appearance of <br />Alan Moore's iconic Watchmen</html>","src\\watchmen01.jpg");
    cmicList[7] = new ComicInfo("Daredevil","Marvel",'m',1,158,2123.19,5,"First artwork by Frank Miller","src\\daredevil158.jpg");
    cmicList[8] = new ComicInfo("Daredevil","Marvel",'m',1,181,2123.19,5,"Death of Elektra","src\\daredevil181.jpg");
    cmicList[9] = new ComicInfo("Hulk","Marvel",'m',1,181,723.19,5,"First appearance of Wolverine","src\\hulk181.jpg");
    cmicList[10] = new ComicInfo("Spider-man","Marvel",'m',1,1,9423.19,5,"Second appearance of Spider-man","src\\spiderman01.jpg");
    cmicList[11] = new ComicInfo("Spider-man","Marvel",'m',1,121,19423.19,5,"Death of Gwen Stacy","src\\spiderman121.jpg");
    cmicList[12] = new ComicInfo("Spider-man","Marvel",'m',1,129,19423.19,5,"First appearance of the Punisher","src\\spiderman129.jpg");
    cmicList[13] = new ComicInfo("Spider-man","Marvel",'m',1,298,19423.19,5,"First artwork by  Todd Macfarlane","src\\spiderman298.jpg");
    cmicList[14] = new ComicInfo("X-Men","Marvel",'m',1,1,451.82,0,"First appearance of the X-Men","src\\xmen01.jpg");
    cmicList[15] = new ComicInfo("X-Men","Marvel",'m',1,137,451.82,0,"Death of Phoenix","src\\xmen137.jpg");
    cmicList[16] = new ComicInfo("Nexus","First",'o',1,21,28.53,11,"Final appearance of Noop","src\\nexus21.jpg");
    cmicList[17] = new ComicInfo("Spawn","Image",'o',1,1,257.29,7,"<html>First appearance of <br />Todd Macfarlane's Spawn</html>","src\\spawn01.jpg"); 
    cmicList[18] = new ComicInfo("Star Trek","Gold Key",'o',1,25,57.29,7,"First appearance of the Klingons","src\\startrek25.jpg"); 
  
  
  }


} 
