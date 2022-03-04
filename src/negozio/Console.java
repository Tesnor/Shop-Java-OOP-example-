package negozio;
import java.io.*;
import java.text.*;
import java.util.*;

public class Console 
{
	static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
	
	public static Date leggiDate(String prompt){
		for(;;) {
			String line = leggiString(prompt);
			try {
				Date d = df.parse(line);
				return d;
			} catch (ParseException e) {
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends Enum<T>> T leggiEnum(String prompt, T[] type){
		for(;;) {
			StringBuilder sb = new StringBuilder(prompt);
			sb.append("( ");
			for(T v : type)
				sb.append(v).append(" ");
			sb.append(")");
			String line = leggiString(sb.toString());
/*			try {
				return Enum.valueOf((Class<T>)type[0].getClass(), line);
			} catch (IllegalArgumentException e) {
			}*/
			for(T v : type)
				if(line.equalsIgnoreCase(v.toString()))
					return v;
		}
	}

	public static String leggiString(String prompt)
	{
		String linea = "";
		
		try {
			System.out.println(prompt);
			InputStreamReader stream = new InputStreamReader(System.in);
			BufferedReader input= new BufferedReader(stream);

			linea = input.readLine();
	    } catch (IOException e) {
			System.out.println("errore");
			System.exit(0) ;
		}
		return linea;

	}
	
	
    public static int leggiInt(String prompt)
	{
		String linea = "";
        int numero = 0;
        for(;;) {
			try	{
				linea = leggiString(prompt);
				numero = Integer.parseInt (linea);
				break;
	     	} catch (NumberFormatException e) {
	       	}
        }        
		return numero;
	}
    
	
    public static double leggiDouble(String prompt)
	{
		String linea = "";
        double numero=0;
        for(;;) {
			try	{
				linea = leggiString(prompt);
				numero = Double.parseDouble (linea);
				break;
	     	} catch (NumberFormatException e) {
	       	}
        }        
		return numero;
	}
    public static <T> T leggiLista(String prompt, List<T> list) {
    	int i = 0;
    	for(T obj : list)
    		System.out.println(++i + " " + obj);
      prompt = prompt + " (0 per uscire)";
    	do {
    		i = leggiInt(prompt);
        if(i == 0)
          return null;
    	} while( (i < 1) || (i > list.size()));
    	return list.get(i - 1);
    }
    private static <T> void stampa(PrintStream ps, String prompt, ArrayList<T> list) {
    	ps.println(prompt);
    	for(T obj : list)
    		ps.println(obj);    	
    }
    public static <T> void stampa(String prompt, ArrayList<T> list) {
		stampa(System.out, prompt, list);
    }
    public static <T> void stampa(String nomeFile, String prompt, ArrayList<T> list) {
    	try(PrintStream ps = new PrintStream(nomeFile)) {
    		stampa(ps, prompt, list);
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}