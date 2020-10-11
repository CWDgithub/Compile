import java.io.BufferedReader;
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
		BufferedReader bufferedReader=new BufferedReader(fReader);
		String strLine=bufferedReader.readLine();
		while(strLine!=null) {
			for(int i=0;i<strLine.length();i++) {
				list.add(strLine.charAt(i));
			}
			strLine=bufferedReader.readLine();
		}
		bufferedReader.close();
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
					for(int j=i+1;j<list.size();j++) {
						if(Character.isDigit(list.get(j))) {
							continue;
						}
						else {
							Judge.printNum(list, i, j-1);
							i=j-1;
							break;
						}
					}
				}
				else if(Character.isLetter(list.get(i))) {
					StringBuffer sBuffer=new StringBuffer();
					for(int j=i;j<list.size();j++) {
						if(Character.isLetterOrDigit(list.get(j))){
							sBuffer.append(list.get(j));
						}
						else {
							i=j-1;
							break;
						}
					}
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