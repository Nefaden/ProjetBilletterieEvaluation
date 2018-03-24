/**
 * Author:  ydurand
 * Created: 23 mars 2018
 * v1.0
 */

/* Création de la table des utilisateurs pour se connecter à la base distante */

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `nomUtilisateur` varchar(40) NOT NULL,
  `motDePasse` varchar(40) NOT NULL
);

--
-- Contenu de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`idUtilisateur`, `nom`, `prenom`, `nomUtilisateur`, `motDePasse`) VALUES
('1', 'Durand', 'Yann', 'ydurand', '1234'),
('2', 'Roux', 'Maxime', 'mroux', '1234'),
('3', 'Doucet', 'Gregory', 'dgregory', '1234'),
('4', 'Cormier', 'Gregory', 'cgregory', '1234'),
('5', 'Bourgeois', 'Nicolas', 'nbourgeois', '1234'),
('6', 'Beauvais', 'Jean-Pierre', 'jpbeauvais', '1234');

--
-- Contrainte de la table `Utilisateur`
--

ALTER TABLE `Utilisateur`
ADD PRIMARY KEY (`idUtilisateur`);