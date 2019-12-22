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
| address      | int(11)       | YES  |     | NULL    |                |
| street_name  | varchar(22)   | YES  |     | NULL    |                |
| city_name    | varchar(22)   | YES  |     | NULL    |                |
| country_name | varchar(22)   | YES  |     | NULL    |                |
+--------------+---------------+------+-----+---------+----------------+


4.primary key identifier should be set as auto_increment.

5.
        <component name="address" class="com.Address" >
            <property name="street" column="street_name" type="string"/>
            <property name="city" column="city_name" type="string"/>
            <property name="country" column="country_name" type="string"/>
        </component>





