1. * download hibernate from http://hibernate.org/orm/releases/5.4/
   * add jars from lib/required in classpath
2. * download mysql connector jar from https://dev.mysql.com/downloads/connector/j/
   * add mysql jdbc driver in classpath if hibernate is going to work with mysql
3.
mysql> desc  EMPLOYEE;
+--------------+---------------+------+-----+---------+----------------+
| Field        | Type          | Null | Key | Default | Extra          |
+--------------+---------------+------+-----+---------+----------------+
| employee_id  | int(11)       | NO   | PRI | NULL    | auto_increment |
| firstname    | varchar(22)   | YES  |     | NULL    |                |
| lastname     | varchar(22)   | YES  |     | NULL    |                |
| salary       | decimal(10,2) | YES  |     | NULL    |                |
| address      | int(11)       | YES  |     | NULL    |                |
+--------------+---------------+------+-----+---------+----------------+
address is the foreign key

4.
mysql> desc ADDRESS;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| address_id | int(11)     | NO   | PRI | NULL    | auto_increment |
| street     | varchar(22) | YES  |     | NULL    |                |
| city       | varchar(22) | YES  |     | NULL    |                |
| state      | varchar(22) | YES  |     | NULL    |                |
| country    | varchar(22) | YES  |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+





