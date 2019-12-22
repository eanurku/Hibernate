1. * download hibernate from http://hibernate.org/orm/releases/5.4/
   * add jars from lib/required in classpath
2. * download mysql connector jar from https://dev.mysql.com/downloads/connector/j/
   * add mysql jdbc driver in classpath if hibernate is going to work with mysql
3.
mysql> desc EMPLOYEE;
+--------------+---------------+------+-----+---------+----------------+
| Field        | Type          | Null | Key | Default | Extra          |
+--------------+---------------+------+-----+---------+----------------+
| employee_id  | int(11)       | NO   | PRI | NULL    | auto_increment |
| firstname    | varchar(22)   | YES  |     | NULL    |                |
| lastname     | varchar(22)   | YES  |     | NULL    |                |
| salary       | decimal(10,2) | YES  |     | NULL    |                |
+--------------+---------------+------+-----+---------+----------------+


4.
mysql> desc CERTIFICATE;
+------------------+-------------+------+-----+---------+----------------+
| Field            | Type        | Null | Key | Default | Extra          |
+------------------+-------------+------+-----+---------+----------------+
| certificate_id   | int(11)     | NO   | PRI | NULL    | auto_increment |
| certificate_name | varchar(22) | YES  |     | NULL    |                |
| certificate_type | varchar(22) | YES  |     | NULL    |                |
| employee_id      | int(11)     | YES  |     | NULL    |                |
+------------------+-------------+------+-----+---------+----------------+


5. in Employee class:

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")//forign key in certificate table
    private Set<Certificate> certificates;





