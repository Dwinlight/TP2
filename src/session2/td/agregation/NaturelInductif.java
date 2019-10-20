package session2.td.agregation;

public interface NaturelInductif extends EtatNaturelPur {
	
	
	@Override default
	public EtatNaturelPur creerZero() {
		return new ZeroInductif();
	}

	@Override default
	public EtatNaturelPur creerSuccesseur(EtatNaturelPur predecesseur) {
		return new SuccInductif(predecesseur);
	}
	
	@Override
	default EtatNaturelPur creerNatAvecValeur(int val) {
		if(val == 0)
			return this.creerZero();
		return this.creerSuccesseur(this.creerNatAvecValeur(val -1));
	}
}
