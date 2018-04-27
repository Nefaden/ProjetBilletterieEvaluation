package controleur;

/**
 * Liste des actions prises en charge par le contrôleur frontal
 * Règles de nommage pour ajouter une action :
 * - en majuscules
 * - le nom du contrôleur suivi d'un tiret bas et du nom de l'action pour ce contrôleur
 * @author ydurand
 * @v1.0
 */
public enum EnumAction {
    AUTHENTIFICATION_AFFICHER_MENU_PRINCIPAL,
    CONNEXION_AFFICHER_MENU_PRINCIPAL,
    MENU_CONNEXION_DISTANTE,
    CONNEXION_DISTANTE_QUITTER,
    MENU_REPRESENTATION_AFFICHER,
    REPRESENTATION_QUITTER,
    REPRESENTATION_VENTE,
    VENTES_QUITTER,
    MENU_QUITTER
}
