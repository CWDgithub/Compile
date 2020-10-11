import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	static char optSingle[]= {':','+','*',',','(',')'};
	static String optDouble=":=";
	static String keyword[]= {"BEGIN","END","FOR","IF","THEN","ELSE"};
	
	public static ArrayList<Character> readFile(String filename) throws IOException{
		ArrayList<Character> list=new ArrayList<Character>();
		FileReader fReader=new FileReader(filename);
		int i=0;
		while((i=fReader.read())!=-1) {
			list.add((char)i);
		}
		fReader.close();
		return list;
	}
	
	public static void main(String[] args) {
		try {
			ArrayList<Character> list=Main.readFile(args[0]);
			Judge judge=new Judge();
			for(int i=0;i<list.size();i++) {
				if(judge.isspace(list.get(i))) {
					continue;
				}
				else if(Character.isDigit(list.get(i))) {
					StringBuffer stringBuffer=new StringBuffer();
					for(;i<list.size();i++) {
						if(Character.isDigit(list.get(i))) {
							stringBuffer.append(list.get(i));
						}
						else break;
					}
					i--;
					int num=Integer.parseInt(stringBuffer.toString());
					System.out.println("Int("+num+")");
				}
				else if(Character.isLetter(list.get(i))) {
					StringBuffer sBuffer=new StringBuffer();
					int j=0;
					for(j=i;j<list.size();j++) {
						if(Character.isLetterOrDigit(list.get(j))){
							sBuffer.append(list.get(j));
						}
						else {
							break;
						}
					}
					if(j==list.size()-1)
						i=j;
					else i=j-1;
					judge.GetKeyWord(sBuffer.toString());
				}
				else if(judge.isoptSingle(list.get(i))) {
					if(i<list.size()-1&&list.get(i)==':'&&list.get(i+1)=='=') {
						System.out.println("Assign");
						i=i+1;
					}
					else {
						judge.printOpt(list.get(i));
					}
				}
				else {
					System.out.println("Unknown");
					break;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}