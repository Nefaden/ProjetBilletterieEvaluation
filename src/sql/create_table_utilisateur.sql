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
  `nomUtilisateur` varchar(40) NOT NULL,
  `motDePasse` varchar(40) NOT NULL
);

--
-- Contenu de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`idUtilisateur`, `nomUtilisateur`, `motDePasse`) VALUES
('1', 'ydurand', '1234'),
('2', 'mroux', '1234'),
('3', 'dgregory', '1234'),
('4', 'cgregory', '1234'),
('5', 'nbourgeois', '1234'),
('6', 'jpbeauvais', '1234');

--
-- Contrainte de la table `Utilisateur`
--

ALTER TABLE `Utilisateur`
ADD PRIMARY KEY (`idUtilisateur`);