import java.util.*;
import static java.util.Collectors.*;
 //Compiler version JDK 1.8
class Team{
	int[] react;
	int soma;
	String nome;
	ArrayList<String> part;
	public Team(String nome, ArrayList<String> part, int[] reactions){
		this.nome = nome;
		this.part = part;
		this.react = reactions;
		for(int i=0; i < reactions.size; i++) this.soma += reactions[i];
	}
	public String toString(){
		return this.nome;
	}
}
 class TalentShow{
	 public static void main(String args[]){
		ArrayList<Team> lista = new ArrayList();
		Scanner teclado = new Scanner (System.in);
		System.out.println("Bem vindo ao Talent Show Points Administrator:");
		for(int cont = 0;op != 2;cont++) {
			System.out.println("\nDigite qual das opções você deseja:");
			System.out.println(" 1 - Adicionar  uma equipe\n 2 - Mostrar a classificação final\n ");
			int op = teclado.nextInt();
			teclado.nextLine();
			if(op == 1){
				System.out.println("Digite o nome da equipe:");
				//1
				String nome = teclado.nextLine();
				System.out.println("Digite os nomes dos participantes e 0 quando tiver terminado:")
				ArrayList<String> part;
				int[] reactions;
				//2
				for(String op = "";op != "0";){
					if (op != "0"){
						part.add(op);
						System.out.println("Digite o nome do próximo participante ou 0 se tiver terminado:");
					}
					else
						break;
				}
				//3 *1
				for(int cont = 0 ;cont < 4 ;cont++){
					System.out.print("Digite os pontos de ");
					if(cont == 0)
						System.out.println("Criatividade (de 0 a 5):");
					else if(cont == 1)
						System.out.println("Figurino (de 0 a 5):");
					else if(cont == 2)
						System.out.println("Reação do Público (de 0 a 5):");
					else if(cont == 3)
						System.out.println("Qualidade (de 0 a 5):");
					else
						break;
					reactions[cont] = teclado.nextInt();
					//*2
					teclado.nextLine();
					//4
					if(reactions[cont] < 0 || reactions[cont] > 5){
						System.out.println("ERRO!!! Opção inválida: (");
						if(cont == 0)
							System.out.println("Criatividade deve ser pontuada de 0 a 5):");
						else if(cont == 1)
							System.out.println("Figurino deve ser pontuada de 0 a 5):");
						else if(cont == 2)
							System.out.println("Reação do Público deve ser pontuada de 0 a 5):");
						else if(cont == 3)
							System.out.println("Qualidade deve ser pontuada de 0 a 5):");
					cont--;
					continue;
					}
				}
				//5
				Team team = new Team(nome,part,reactions);
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
