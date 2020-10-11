
public class Judge {
	
	static String keyword[]= {"BEGIN","END","FOR","IF","THEN","ELSE"};
	static String outword[]= {"Begin","End","For","If","Then","Else"};
	public void GetKeyWord(String word) {
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<keyword.length;i++) {
			if(word.equals(keyword[i])){
				System.out.println(outword[i]);
				return ;
			}
		}
		stringBuffer.append("Ident(");
		stringBuffer.append(word);
		stringBuffer.append(")");
		System.out.println(stringBuffer.toString());
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
