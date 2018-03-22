/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gdoucet
 * Created: 22 mars 2018
 */

CREATE USER 'groupe_4_festival'@'%' IDENTIFIED WITH mysql_native_password AS '***';GRANT USAGE ON *.* TO 'groupe_4_festival'@'%' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;GRANT ALL PRIVILEGES ON `festival`.* TO 'groupe_4_festival'@'%';