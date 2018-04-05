/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gdoucet
 * Created: 22 mars 2018
 */

CREATE USER 'ydurand_festival_util'@'localhost' IDENTIFIED BY 'secret'; GRANT USAGE ON *.* TO 'ydurand_festival_util'@'localhost' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
GRANT ALL PRIVILEGES ON `ydurand_festival`.* TO 'ydurand_festival_util'@'localhost' WITH GRANT OPTION;