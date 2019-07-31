package TalentShow;

import java.util.Scanner;
import java.util.ArrayList;
import TalentShow.Team;

 class TalentShow{ 
	 public static void main(String args[]){ 	
		ArrayList<Team> lista = new ArrayList();		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Bem vindo ao Talent Show Points Administrator\n");
		System.out.println("Digite qual das opções você deseja:");
		System.out.println(" 1 - Adicionar  uma equipe\n 2 - Mostrar a classificação final\n ");
		while(int op = teclado.nextInt()){			
			if(op == 1)
			lista.add(createTeam());
			else if(op == 2) break;
			else System.out.println("Opção inválida");
		}
		if(lista == null){
			System.out.println("Lista nula");
			return;
		}
		List l = lista
		.stream()
		.sorted( (x, y) -> Comparator.compare(x.soma, y.soma) )
		.collect(Collectors.toList());
		for(int i=1; i <= l.length(); i++) {
			System.out.println(String.valueOf(i) + "º lugar: " + l.get(i-1).toString() + "\n");
			for(int j=0; j < l.get(i-1).part.length(); j++) System.out.println(l.get(i).name);
			System.out.println();
		}
						
	 }
	 
	 public Team createTeam(){
		Scanner teclado = new Scanner(System.in);
		String nome;
		ArrayList<String> part = new ArrayList<String>();
		ArrayList<Integer> react;
		System.out.println("Digite o nome do time: "):
		nome = teclado.nextLine();
		System.out.println("Digite o nome dos participantes. Caso acabe, insira uma linha em branco.");
		while(teclado.hasNext()) part.add(teclado.nextLine());
		System.out.println("Digite as medidas das reações. Caso acabe, insira uma linha em branco.");
		while(teclado.hasNext()){
			react.add(teclado.nextInt());
			teclado.nextLine();
		}
		return new Team(nome, part, react.stream().mapToInt(i->i).toArray());
		
	 }
}
