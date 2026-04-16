package osvaldo.morales.company.demo.java8.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CreateSteamFile5 {
	
	public static void main(String[] args)
	   {
		Path path1 = Paths.get("C:\\Users\\Anzen Digital\\Desktop\\workspace\\DAO\\src\\stream\\english.txt");
		try(Stream<String> lineas = Files.lines(path1)){
			lineas.forEach(
					line->{
						System.out.println("line..");
						System.out.println(line);
					}
					);
	
		}catch (Exception e) {
			System.out.println("Exception:"+e);
		}
		
		
	   }

}
