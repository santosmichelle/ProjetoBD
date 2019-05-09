import model.Usuario;

public class Main {
	
	
	public static void main(String[] args) {
String v = "teste @preta test";

	String g = v.substring(v.indexOf("@"));

	int	t = (g.indexOf(" ")==0)?0:g.indexOf(" ");
	
	if (t == -1 ) {
		
		System.out.println(g.substring(0));
	}else {
		System.out.println(g.substring(0,t));
		
	}
	
	}
}
