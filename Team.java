import java.util.*;
 //Compiler version JDK 1.8
class Team{
	int rdP; //Reação do público
	int qdA; //Qualidade da Apresentação
	int feC; //Figurino e Caracterização
	int pontuaçãoFinal;
	String nome;
	ArrayList<String> participantes = new ArrayList();
	Team(){
		Scanner teclado = new Scanner (System.in);
		System.out.println("Digite o nome da equipe:");
		this.nome = teclado.nextLine();
		String part = " ";
		for(int cont = 1;true;cont++){
			System.out.println("Digite o nome do " + Integer.toString(cont) + "° participante (digite 0 quando ja tiver acabado)");
			part = teclado.nextLine();
			if(part != "0")
				this.participantes.add(part);
			else
				break;
		}
		System.out.println("Digite os pontos da equipe de acordo com os critérios:");
		System.out.print("Reação do Público: ");
		this.rdP = teclado.nextInt();
		System.out.print("Qualidade da Apresentação: ");
		this.qdA = teclado.nextInt();
		System.out.print("Figurino e Caracterização: ");
		this.feC = teclado.nextInt();
		this.pontuaçãoFinal = this.rdP + this.qdA + this.feC;
		teclado.close();
		
	}
	
}
 class TalentShow{ 
	 public static void main(String args[]){ 	
		ArrayList<Team> lista = new ArrayList();
		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Bem vindo ao Talent Show Points Administrator:");
		int op;
		for(int cont = 0;op != 2;cont++) {
			System.out.println("\nDigite qual das opções você deseja:");
			System.out.println(" 1 - Adicionar  uma equipe\n 2 - Mostrar a classificação final\n ");
			op = teclado.nextInt();
			if(op == 1){
				Team team = new Team();
				lista.add(team);
			}else if(op == 2) {
				for(int i = 0;i<cont;i++) {
					for(int j = 0;j<cont;j++) {
						if(lista[i].pontuaçãoFinal < lista[j].pontuaçãoFinal) {
							Team tmp = lista[i];
							lista[i] = lista[j];
							lista[j] = tmp;
						}
					}
				}
				System.out.println("A colocação final ficou: ")
				for(int i = 0;i<cont;i++)
					System.out.println(" " + Integer.toString(i+1) + "º colocado : " + lista[i].nome + " com " + lista[i].pontuaçãoFinal + " pontos no total.")
			}else {
				System.out.println("[ERRO] Digite uma opção válida:");
				continue;
			}
				
		}
	 }
}
