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
		cmicList[0] = new ComicInfo("Action Comics","DC",'d',1,1,25382.46,4,"First appearance of Superman","action01.jpg");
		cmicList[1] = new ComicInfo("Action Comics","DC",'d',1,252,382.91,7,"First appearance of Supergirl","action252.jpg");
      
		
		cmicList[2] = new ComicInfo("Detective Comics","DC",'d',1,27,425382.82,3,"First appearance of Batman","detective27.jpg");
   cmicList[3] = new ComicInfo("Detective Comics","DC",'d',1,38,1282.84,2,"First appearance of Robin","detective38.jpg");

   cmicList[4] = new ComicInfo("Superman","DC",'d',2,75,2123.19,5,"Death of Superman","superman75.jpg");
cmicList[5] = new ComicInfo("The Dark Knight Returns","DC",'d',1,1,923.19,5,"Frank Miller's revival of the Batman","dk01.jpg");
cmicList[6] = new ComicInfo("Watchmen","DC",'d',1,1,2123.19,5,"<html>First appearance of <br />Alan Moore's iconic Watchmen</html>","watchmen01.jpg");

      cmicList[7] = new ComicInfo("Daredevil","Marvel",'m',1,158,2123.19,5,"First artwork by Frank Miller","daredevil158.jpg");


		cmicList[8] = new ComicInfo("Daredevil","Marvel",'m',1,181,2123.19,5,"Death of Elektra","daredevil181.jpg");
cmicList[9] = new ComicInfo("Hulk","Marvel",'m',1,181,723.19,5,"First appearance of Wolverine","hulk181.jpg");

		cmicList[10] = new ComicInfo("Spider-man","Marvel",'m',1,1,9423.19,5,"Second appearance of Spider-man","spiderman01.jpg");
   
   cmicList[11] = new ComicInfo("Spider-man","Marvel",'m',1,121,19423.19,5,"Death of Gwen Stacy","spiderman121.jpg");
cmicList[12] = new ComicInfo("Spider-man","Marvel",'m',1,129,19423.19,5,"First appearance of the Punisher","spiderman129.jpg");
cmicList[13] = new ComicInfo("Spider-man","Marvel",'m',1,298,19423.19,5,"First artwork by  Todd Macfarlane","spiderman298.jpg");

		cmicList[14] = new ComicInfo("X-Men","Marvel",'m',1,1,451.82,0,"First appearance of the X-Men","xmen01.jpg");
		cmicList[15] = new ComicInfo("X-Men","Marvel",'m',1,137,451.82,0,"Death of Phoenix","xmen137.jpg");
		
	  	cmicList[16] = new ComicInfo("Nexus","First",'o',1,21,28.53,11,"Final appearance of Noop","nexus21.jpg");
		cmicList[17] = new ComicInfo("Spawn","Image",'o',1,1,257.29,7,"<html>First appearance of <br />Todd Macfarlane's Spawn</html>","spawn01.jpg"); 

      cmicList[18] = new ComicInfo("Star Trek","Gold Key",'o',1,25,57.29,7,"First appearance of the Klingons","startrek25.jpg"); 
		 
  }


} 
