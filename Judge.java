
import java.util.ArrayList;

public class Judge {
	
	public void GetKeyWord(String word) {
		char firstChar=word.charAt(0);
		String string="";
		switch (firstChar) {
			case 'B':
				if(word.equals("BEGIN")) {
					string="Begin";
				}
				break;
			case 'E':
				if(word.equals("END")) {
					string="End";
				}
				else if(word.equals("ELSE")) {
					string="Else";
				}
				break;
			case 'F':
				if(word.equals("FOR")) {
					string="For";
				}
				break;
			case 'I':
				if(word.equals("IF")) {
					string="If";
				}   
				break;
			case 'T':
				if(word.equals("THEN")) {
					string="Then";
				}
				break;
		}
		if(string!=null) {
			System.out.println(string);
		}
		else {
			System.out.println("Ident("+word+")");
		}
	}
	
	public static void printNum(ArrayList<Character> list,int start,int end) {
		StringBuffer sBuffer=new StringBuffer();
		for(int i=start;i<=end;i++) {
			sBuffer.append(list.get(i));
		}
		System.out.println("Int("+Integer.parseInt(sBuffer.toString())+")");
	}
	
	public boolean isoptSingle(char ch) {
		char optSingle[]= {':','+','*',',','(',')'};
		for(int i=0;i<optSingle.length;i++) {
			if(ch==optSingle[i]) {
				return true;
			}
		}
		return false;
	}
	
	public void printOpt(char ch) {
		String string="";
		switch(ch) {
			case ':':string="Colon";break;
			case '+':string="Plus";break;
			case '*':string="Star";break;
			case ',':string="Comma";break;
			case '(':string="LParenthesis";break;
			case ')':string="RParenthesis";break;
			default:break;
		}
		System.out.println(string);
	}
	public boolean isspace(char ch) {
		if(ch==' '||ch=='\t'||ch=='\n'||ch=='\r') {
			return true;
		}
		return false;
	}
}
