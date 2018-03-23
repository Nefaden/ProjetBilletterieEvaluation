package controleur;

/**
 * Liste des actions prises en charge par le contrôleur frontal
 * Règles de nommage pour ajouter une action :
 * - en majuscules
 * - le nom du contrôleur suivi d'un tiret bas et du nom de l'action pour ce contrôleur
 * @author ydurand
 */
public enum EnumAction {
    CONNEXION_MENU_PRINCIPAL,
    MENU_REPRESENTATION_AFFICHER,
    REPRESENTATION_QUITTER,
    REPRESENTATION_DETAILS,
    REPRESENTATION_VENTES,
    VENTES_QUITTER,
    MENU_QUITTER
}
