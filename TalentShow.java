import java.util.*;
import static java.util.Collectors.*;
 //Compiler version JDK 1.8
 class TalentShow{ 
	 public static void main(String args[]){ 	
		ArrayList<Team> lista = new ArrayList();		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Bem vindo ao Talent Show Points Administrator:");
		for(int cont = 0;op != 2;cont++) {
			System.out.println("\nDigite qual das opções você deseja:");
			System.out.println(" 1 - Adicionar  uma equipe\n 2 - Mostrar a classificação final\n ");
			int op = teclado.nextInt();
			if(op == 1){
				Team team = new Team();
				lista.add(team);
			}else if(op == 2) {
				List l = lista
				.stream()
				.sorted( (x, y) -> Comparator.compare(x.soma, y.soma) )
				.collect(toList());
				for(int i=1; i <= l.length(); i++) {
					System.out.println(String.valueOf(i) + "º lugar: " + l.get(i-1).toString() + "\n");
					for(int j=0; j < l.get(i).length(); j++) System.out.println(l.get(i).name);
					System.out.println();
				}
			}else {
				System.out.println("[ERRO] Digite uma opção válida:");
				continue;
			}
				
		}
	 }
}
