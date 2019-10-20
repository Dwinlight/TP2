package session2.td.agregation;

public interface Nat extends EtatNaturel<Nat>, hierarchie.SemiAnneauUnitaireEuclidien<Nat>, session1.td.FabriqueNaturels<Nat>{
	Nat creerNatAvecEtat(EtatNaturelPur etat);
	EtatNaturelPur etat();
}
