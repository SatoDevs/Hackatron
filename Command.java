import java.util.Scanner;

public class Command {

	/*
	* Description de la classe
	*/

	/*
	* Attributs
	*/
	private String word1;
	private String word2;

	/*
	* Constructeurs
	*/
	public Command() {
		this.word1 = null;
		this.word2 = null;
	}

	public Command(String w1, String w2) {
		this.word1 = w1;
		this.word2 = w2;
	}

	public void input(Scanner sc) {
		System.out.print(Player.getPseudo() + "@ :");
		String[] mots = sc.nextLine().split(" ");
		if (mots.length > 1) {
		    this.setWord1(mots[0]); // set first word
		    this.setWord2(mots[1]); // set second word
		} else if (mots.length == 1) {
			this.setWord1(mots[0]); // set word
		}
	}

	/*
	* Méthodes
	*/
	public static void ls() {
		System.out.println("***********************************************************************");
		System.out.println("Contenu du serveur " + Player.getCurrentServ().getName() + ": ");
		for (int i = 0; i < Player.getCurrentServ().getContent().length; i++) {
			System.out.println(Player.getCurrentServ().getContent()[i]);
		}
	}

	public static void help() {
		System.out.println("**COMMAND LIST*********************************************************");
		System.out.println("ifconfig: affiche des informations sur l'état actuel du joueur");
		System.out.println("ls: affiche une liste des fichiers présents sur le serveur courant");
		System.out.println("backdoor: installe une backdoor sur le serveur courant pour y contourner la sécurité");
		System.out.println("download X: télécharge le fichier X sur du serveur courant");
		System.out.println("connect X: se connecte au serveur voisin X");
		System.out.println("bruteforce: affiche une partie du mot de passe d'un serveur");
		System.out.println("kill:");
		System.out.println("quit: ferme la session Hackatron");
	}

	public static void backdoor() {
		System.out.println("[================]100% Backdoor installée avec succès");
		Player.getCurrentServ().setbackdoor(true);
	}

	public static void bruteforce() {
		System.out.println("Placeholder bruteforce");
	}

	public static void ifconfig() {
		System.out.println("***********************************************************************");
		System.out.println("Actuellement connecté à :" + Player.getCurrentServ().getName());
		System.out.println("IP adress: " + Player.getCurrentServ().getIp()); //Placeholder, à changer
		System.out.println("Serveurs Connectés: ");
		Server[] voisins = Player.getCurrentServ().getVoisins();//affiche la liste des serveurs connectés au serveur courant
		for(int i = 0; i<voisins.length;i++) {
			System.out.println("-"+ voisins[i].getName());
		}
		System.out.println("Niveau du botnet : "+Player.getlvlplayer());
		System.out.println("***********************************************************************");
	}

	public static void connect(String word2) {
		System.out.println("Placeholder connect");
		System.out.println("Deuxieme mot: " + word2);
		Server[] voisins = Player.getCurrentServ().getVoisins();
		Player.setCurrentServ(voisins[Integer.valueOf(word2)-1]);
	}

	public static void map() {
		System.out.println("Ouverture de la fenetre du reseau...");
		Fenetre n = new Fenetre();
	}

	public static void download(int i) {
		String[] contenu = Player.getCurrentServ().getContent();
		System.out.println("Telechargement de :" + contenu[i-1]);
		if(contenu[i-1].equals("Sudoku.java")){
			System.out.println("Vous avez trouve le fichier, vous avez gagne. Bravo" + Player.getPseudo() + "!");
		}
	}

	public void kill(Server Serv)
	{
		Antivirus A = Serv.getAntivirus(); //récupère l'antivirus
		if (A != null){ //check si le serveur a effectivement un antivirus
			if(A.getlvl() <= Player.getlvlplayer()){
				A.killAvast(); //désactive l'antivirus
			}
			else {
				System.out.println("Vous ne pouvez pas desactiver cet antivirus");
			}
		}
		else {
			System.out.println("FATAL ERROR : Ce serveur n'a pas d'antivirus");
		}
	}

	/*
	* Getters & Setters
	*/
	public String getWord1() {
		return this.word1;
	}

	public String getWord2() {
		return this.word2;
	}

	public void setWord1(String s) {
		this.word1 = s;
	}

	public void setWord2(String s) {
		this.word2 = s;
	}

}
