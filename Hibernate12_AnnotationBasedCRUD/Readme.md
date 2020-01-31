1. * download hibernate from http://hibernate.org/orm/releases/5.4/
   * add jars from lib/required in classpath
2. * download mysql connector jar from https://dev.mysql.com/downloads/connector/j/
   * add mysql jdbc driver in classpath if hibernate is going to work with mysql

3.   setup EMPLOYEE table with fields as given below:
mysql> desc EMPLOYEE;
+--------------+---------------+------+-----+---------+----------------+
| Field        | Type          | Null | Key | Default | Extra          |
+--------------+---------------+------+-----+---------+----------------+
| employee_id  | int(11)       | NO   | PRI | NULL    | auto_increment |
| firstname    | varchar(22)   | YES  |     | NULL    |                |
| lastname     | varchar(22)   | YES  |     | NULL    |                |
| salary       | decimal(10,2) | YES  |     | NULL    |                |
+--------------+---------------+------+-----+---------+----------------+

4. in hibernate.cfg.xml

     <mapping class="com.model.Employee"/>






