use std::io;
static REACTION_TYPES: [&str;4] = ["Criativity", "Crowd's reaction", "Costumes", "Quality"];
fn main() {
    let mut vec: Vec<Team> = Vec::new();
    loop{
        println!("Welcome to the Talent Show Points Administrator:");
        println!("\nType which of the following options you desire:");
        let buffer = read_line(" 1 - Add a Team\n 2 - Show final results\n");   
        match buffer.as_str().trim(){
            "1" => Team::add_team(&mut vec),
            "2" => {
                Team::print_results(&mut vec);
                break;
            },
            &_ => println!("[ERROR] Type a valid option:")
        }
    }

}
fn read_line(string: &str,) -> String{
    println!("{}", string);
    let mut buffer = String::new();
    io::stdin()
        .read_line(&mut buffer)
        .expect("Failed to read line");
    buffer
}
struct Team{
   pub name: String,
   pub reactions: [i32; 4],
   pub sum: i32,
   pub participants: Vec<String>,
}
impl Team{
    fn add_team(vec: &mut Vec<Team>){
        let name = read_line("Type the team's name:");
        let mut participants: Vec<String> = Vec::new();
        println!("Type participants' names and a blank line when done");
        loop{
            let mut buffer = String::new();
            io::stdin()
                .read_line(&mut buffer)
                .expect("Failed to read participant's name!");
            if buffer.trim().is_empty() {
                break;
            } else{
                participants.push(buffer);
            }
        }
        let mut reactions = [0i32; 4];
        for i in 0..4{
            let mut buffer = String::new();
            println!("Type a value between 0 to 5 for {}:", REACTION_TYPES[i]);
            reactions[i] = loop{
                    io::stdin()    
                    .read_line(&mut buffer)
                    .expect("Failed to read value");
                match buffer.trim().parse::<i32>() {
                    Ok(num) => match num {
                        0..=5 => break num,
                        _ => {
                            println!("The score must be between 0 and 5, please try again:");
                            continue
                        },
                    }
                    Err(_) => {
                        println!("The score must be an unsigned integer, please try again:");
                        continue
                    },
                };
            };
        }
        println!("\nTeam {} created", name);
        let new_team = Team {
            name,
            participants,
            sum: reactions.iter().sum(),
            reactions,
        };
        vec.push(new_team);
    }
    fn print_placing(&self, i: usize){
        println!("{}º place: {}\n\nParticipants:", i + 1, self.name);
            for name in self.participants.iter(){
                println!("\t-{}", name);
            }
            println!("\nTotal: {}\n", self.sum);
            for (i, score) in self.reactions.iter().enumerate(){
                println!("{} value: {}", REACTION_TYPES[i], score);
            }
            println!("\n------------------\n");
    }
    fn print_results(vec: &mut Vec<Team>){
        vec.sort_by( |x, y|  y.sum.partial_cmp(&x.sum).unwrap() );
        println!("\n------------------");
        for (i, team ) in vec.iter().enumerate(){
            team.print_placing(i);
        }
    }
}