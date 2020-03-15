public class Server {

	/**
	* Classe contenant le contenu et les methodes relatives aux serveurs du jeu
	*/

	/**
	* Attributs
	*@param name String nom du serveur
	*@param content tableau de String contenant les fichiers contenu dans le serveur
	*@param backdoored boolean
	*@param serveursVoisins tableau de serveurs auxquels est relie le serveur
	*@param IpAdress String ip du serveur
	*@param avast Antivirus du serveur
	*/
	private String name;
	private String[] content;
	private boolean backdoored;
	private Server[] serveursVoisins;
	private String IpAdress;
	private Antivirus Avast;

	/**
	* Constructeur de serveur sans antivirus
	*@param n String nom du serveur
	*@param c tableau de string contenu du serveur
	*/
	public Server(String n, String[] c) {
		this.name = n;
		this.backdoored = false;
		this.content = c;
		this.Avast = null;
		this.IpAdress = Generateur.AdressesIp();
	}

	/**
	* Constructeur de serveur avec antivirus
	*@param n String nom du serveur
	*@param c tableau de string contenu du serveur
	*@param nA String nom de l'antivirus
	*@param lvlA int niveau de l'antivirus
	*/
	public Server(String n, String[] c, String nA, int lvlA)
	{
		this.name = n;
		this.backdoored = false;
		this.content = c;
		this.Avast = new Antivirus(nA, lvlA);
		this.IpAdress = Generateur.AdressesIp();
	}

	/*
	* Getters & Setters
	*/
	public void setVoisins(Server[] voisins) {
		this.serveursVoisins = voisins;
	}

	public Server[] getVoisins() {
		return this.serveursVoisins;
	}

	public String[] getContent() {
		return content;
	}

	public void setContent(String[] content) {
		this.content = content;
	}

	public String getName() {
		return this.name;
	}

	public String getIp() {
		return this.IpAdress;
	}

	public void setbackdoor(boolean b)
	{
		this.backdoored = b;
	}

	public Antivirus getAntivirus()
	{
		return this.Avast;
	}

}
