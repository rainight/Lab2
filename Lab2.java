import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Lab2 {

	private static BufferedReader br = null;
	private static PrintWriter out = null;
	private static ArrayList<String[]> recordArr = new ArrayList<String[]>();

	public static void main(String [] args) {
		
		String line = "";
		String csvSplit = ",";
		
				
			try {
			    out = new PrintWriter(new PrintWriter("OutputDate.txt","UTF-8"));
				br = new BufferedReader(new FileReader("Date.csv"));
					
				while((line = br.readLine()) != null ) {
					
					String[] recCopyToBePushed = new String[5];
					String[] recordExtracted = line.split(csvSplit, 5);
					for(int x = 0; x < recordExtracted.length; x++){
						recCopyToBePushed[x] = recordExtracted[x];
					}				
					recordArr.add(recCopyToBePushed);				
				}
				
				for( int rows = 0; rows< recordArr.size(); rows++){
				
						out.printf("%10s%50s%20s%20s%55s",recordArr.get(rows)[0],recordArr.get(rows)[1],recordArr.get(rows)[2],recordArr.get(rows)[3],recordArr.get(rows)[4]);
					//format the output looks like a table
					out.println("");
				}
				
			} catch(FileNotFoundException fnfe ){
					fnfe.printStackTrace();
			} catch(IOException ie) {
					ie.printStackTrace();
			} finally {
				if(br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(out != null) {
					out.close();
				}
			}
			
			for(int i = 0; i < recordArr.size(); i++){
				
				System.out.print("PROCESSING LINE :\t");
				
				for(int j = 0; j< recordArr.get(i).length; j++){
					System.out.print(recordArr.get(i)[j] + "    ");	 
				}
				System.out.println("");
			}

		System.out.println("Files Proccessed And Converted!");	
	}
	
}