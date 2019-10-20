package session2.td.agregation;

public abstract class NatDeleguantEtat implements Nat {
	private EtatNaturelPur etat;

	public NatDeleguantEtat(EtatNaturelPur etat) {
		this.etat = etat;
	}
	
	@Override
	public EtatNaturelPur etat(){
		return this.etat;
	}
	
	@Override
	public int val() {
		return this.etat.val();
	}
	@Override
	public boolean estNul() {
		return this.etat.estNul();
	}
	@Override
	public Nat predecesseur() {
		return this.creerNatAvecEtat(this.etat.predecesseur());
	}
	
	@Override
	public int chiffre(int i) {
		return this.etat.chiffre(i);
	}

	@Override
	public int taille() {
		return this.etat.taille();
	}

	
	@Override
	public Nat creerNatAvecValeur(int val) {
		return this.creerNatAvecEtat(this.etat().creerNatAvecValeur(val));
	}
	@Override
	public Nat creerZero() {
		return this.creerNatAvecEtat(this.etat().creerZero());
	}
	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return this.creerNatAvecEtat(this.etat().creerSuccesseur(predecesseur.etat()));
	}
	@Override 
	public Nat creerNatAvecRepresentation(String repDecimale){
		return this.creerNatAvecEtat(this.etat().creerNatAvecRepresentation(repDecimale));
	}
}
