package TalentShow;

import java.util.*;
import java.util.stream.*;

class TalentShow{
  public static void main(String args[]){
   ArrayList<Team> lista = new ArrayList<Team>();
   Scanner teclado = new Scanner(System.in);
   System.out.println("Bem vindo ao Talent Show Points Administrator:");
   System.out.println("\nDigite qual das opções você deseja:");
   System.out.println(" 1 - Adicionar  uma equipe\n 2 - Mostrar a classificação final\n");
   for(String op = teclado.nextLine();; op = teclado.nextLine()) {
     if(op.equals("1")){
        lista.add(createTeam(teclado));
       }
     else if(op.equals("2")) {
        printWinner(lista);
        break;
     }else {
       System.out.println("[ERRO] Digite uma opção válida:");
     }
      System.out.println("\n 1 - Adicionar  uma equipe\n 2 - Mostrar a classificação final\n");
   }
   teclado.close();
   }
   public static Team createTeam(Scanner teclado){
     System.out.println("Digite o nome da equipe:");
     String nome = teclado.nextLine();
     System.out.println("Digite os nomes dos participantes e uma linha em branco quando tiver terminado:");
     ArrayList<String> part = new ArrayList<String>();
     for(String n = teclado.nextLine(); !n.isEmpty(); n = teclado.nextLine()){
       part.add(n);
     }
     int[] reactions = new int[4];
     for(int i = 0; i < 4; i++){
       System.out.print("Digite um valor (de 0 a 5) para " + Team.getPontos()[i] + ": ");
       if(teclado.hasNextInt()){
         int n = teclado.nextInt();
         teclado.nextLine();
         if(n < 0 || n > 5){
           System.out.println("A pontuação só pode receber um número entre 0 e 5");
           i--;
           continue;
         }
         reactions[i] = n;
       }
       else {
         System.out.println("[ERRO] Isso não é um número.");
         teclado.nextLine();
         i--;
       }
     }
     System.out.println("Time " + nome + " criado.");
     return new Team(nome, part, reactions);
   }
   public static void printWinner(List<Team> l){
     l = l
     .stream()
     .sorted( (x, y) -> -(x.getTotal() - y.getTotal()) )
     .collect(Collectors.toList());
     System.out.println("------------------");
     for(int i=0; i < l.size(); i++) {
       System.out.println(String.valueOf(i+1) + "º lugar: " + l.get(i)+"\n\nParticipantes:");
       for(int j=0; j < l.get(i).size(); j++) System.out.println(" -"+l.get(i).getParticipant(j));
       System.out.println("\nTotal: " + l.get(i).getTotal() + "\n");
       for(int j=0; j < l.get(i).length(); j++) System.out.println("Valor de " + Team.getPontos()[j] + ": " + String.valueOf(l.get(i).getPoint(j)));
       System.out.println("\n------------------\n");
     }
  }
}
class Team{
	int[] react;
	int soma;
	String nome;
	ArrayList<String> part;
	static final String[] pontos = {"Criatividade", "Reação do Público", "Figurino", "Qualidade"};
	public Team(String nome, ArrayList<String> part, int[] reactions){
		this.nome = nome;
		this.part = part;
		this.react = reactions;
		for(int i=0; i < reactions.length; i++) this.soma += reactions[i];
	}
	public String toString(){
		return this.nome;
	}
	public int size(){
		return this.part.size();
	}
	public int length(){
		return this.react.length;
	}
	public String getParticipant(int index){
		return part.get(index);
	}
	public int getPoint(int index){
		return this.react[index];
	}
	public int getTotal(){
		return this.soma;
	}
	public static String[] getPontos(){
		return pontos;
	}
}
