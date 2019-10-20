package session2.td.agregation;

import session1.td.FabriqueNaturels;

public interface EtatNaturelPur extends EtatNaturel<EtatNaturelPur>, FabriqueNaturels<EtatNaturelPur> {
	// Implémentations par défaut des fabriques
	// - Decimal -> Int
	// - Int -> Decimal
	// - Ind -> Int
	// Il reste à implémenter les fabriques par appel d'un constructeur 
	// - dans NombreDecimal : Decimal
	// - dans IntPositif : Int
	// - dans NaturelInductif : Int, Ind
	@Override default 
	public EtatNaturelPur creerZero() {
		return this.creerNatAvecValeur(0);
	}
	@Override default
	public EtatNaturelPur creerSuccesseur(EtatNaturelPur predecesseur) {
		return this.creerNatAvecValeur(predecesseur.val() + 1);
	}

	@Override default
	public EtatNaturelPur creerNatAvecValeur(int val) {
		return this.creerNatAvecRepresentation(Integer.toString(val));
	}
	
	@Override default
	public EtatNaturelPur creerNatAvecRepresentation(String repDecimale){
		return this.creerNatAvecValeur(Integer.parseInt(repDecimale));
	}
}
