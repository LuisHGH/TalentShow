class Team{
	int react[], soma;
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
