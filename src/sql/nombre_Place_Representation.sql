/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gcormier
 * Created: 14 déc. 2017
 */


alter table Representation
ADD nombre_Place_Representation

update Representation
set nombreplacerestante =
	(select capacite FROM Lieu
	WHERE Lieu.id = Representation.id_lieu);