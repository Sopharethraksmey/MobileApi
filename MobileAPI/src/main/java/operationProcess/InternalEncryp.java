package operationProcess;

import java.util.ArrayList;

public class InternalEncryp {
	
	public static String EnCrypt(String strCryptThis) {		
		//strCryptThis="123456Aa@sitha";
		String g_Key="", varSessionID;
		int iKeyChar, iStringChar;
	    varSessionID = "Ratamahatta";	    
	    int g_keypos=0;
	    int i;
	    int iCryptChar;
	    String iCryptCharHex="";
	    String strEncrypted="";
	    
	    for(i=0; i<=strCryptThis.length(); i++) {
	    	g_Key = g_Key + varSessionID.substring(0,g_keypos);	    
	    	g_keypos=g_keypos+1;

	    	if (g_keypos>varSessionID.length()) {
	    		g_keypos=0;
	    	}
	    }
	    //System.out.println(g_Key); //ok
	    
	    char ch[] = g_Key.toCharArray(); 
	    char ch2[] = strCryptThis.toCharArray(); //System.out.println(ch2.length);
	   
	    
	    for(i=0;i<strCryptThis.length();i++) {
	    	iKeyChar = ch[i]; //System.out.println(iKeyChar);
	    	iStringChar = ch2[i]; //System.out.println(iStringChar);
	    	iCryptChar = iKeyChar ^ iStringChar; //System.out.println(iCryptChar);
	    	iCryptCharHex = Integer.toHexString(iCryptChar); //System.out.println(iCryptCharHex);
	    	
	    	if(iCryptCharHex.length()==1) {
	    		iCryptCharHex = "0" + iCryptCharHex; 
	    	}
	    	strEncrypted = strEncrypted + iCryptCharHex;
	    }	    
	    //System.out.println(strEncrypted);	 
	    return strEncrypted;
	}
	
	public static String ConvertCardsToXXXXCard(String cardid) {
		String headCard;
		String middleCard;
		String tailCard;
		String newMidcard="";
		if(cardid.length()==13) {
			//System.out.println(cardid);
			headCard=cardid.substring(0, 6);	//System.out.println("head="+headCard);
			middleCard=cardid.substring(6,10);	//System.out.println("mid="+middleCard);
			tailCard=cardid.substring(10,16);	//System.out.println("tail="+tailCard);
			if(middleCard.equals("0000")) {
				newMidcard="XXXX";				//System.out.println(newMidcard);
			}
			return headCard+newMidcard+tailCard;
		}else {
			System.out.println("wrong card number");
			//mylog.logDebug("<---Response Error = " + cardid);				
			return null;
		}
	}
	
	public static String ConvertCardsTo0000Card(String cardid) {
		String headCard;
		String middleCard;
		String tailCard;
		String newMidcard="";
		if(cardid.length()==16) {
			//System.out.println(cardid);
			headCard=cardid.substring(0, 6);	//System.out.println("head="+headCard);
			middleCard=cardid.substring(6,10);	//System.out.println("mid="+middleCard);
			tailCard=cardid.substring(10,16);	//System.out.println("tail="+tailCard);
			if(middleCard.equals("XXXX")) {
				newMidcard="0000";				//System.out.println(newMidcard);
			}
			return headCard+newMidcard+tailCard;
		}else {
			System.out.println("wrong card number");
			//mylog.logDebug("<---Response Error = " + cardid);				
			return null;
		}		
	}
	public static String ConvertCardsHeadMiddleToXCard(String cardid) {
		
		String headCard;
		String middleCard;
		String tailCard;
		
		//System.out.println(cardid);
		if(cardid.length()==16) {
			headCard=cardid.substring(0, 6);	//System.out.println("head="+headCard);
			headCard="XXXXXX";
			middleCard=cardid.substring(6,10);	//System.out.println("mid="+middleCard);
			middleCard="XXXX";
			tailCard=cardid.substring(10,16);	//System.out.println("tail="+tailCard);
			if(middleCard.equals("0000")) {
			//	newMidcard="XXXX";				//System.out.println(newMidcard);
			}
			return headCard+middleCard+tailCard;
		}else {
			//System.out.println("wrong card number");
			//mylog.logDebug("<---Response Error = " + cardid);			
			return cardid;
		}
	}
	
	public static int getMax(ArrayList<Integer> arList) {
		Integer max=0;
		//ArrayList<Object> arObj = new ArrayList<Object>();
		//System.out.println(arList.toString());
		for(int i=0;i<arList.size();i++) {
			if(arList.get(i)>max) {
				max=arList.get(i);
			}
		}		
		return max;
	}
}
