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
+------------------+-------------+------+-----+---------+----------------+


5. 
mysql> desc EMP_CERT;
+----------------+---------+------+-----+---------+-------+
| Field          | Type    | Null | Key | Default | Extra |
+----------------+---------+------+-----+---------+-------+
| employee_id    | int(11) | NO   | PRI | NULL    |       |
| certificate_id | int(11) | NO   | PRI | NULL    |       |
+----------------+---------+------+-----+---------+-------+
2 rows in set (0.29 sec)


6.
in Employee Class(owning side):
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EMP_CERT",
            joinColumns = { @JoinColumn(name = "employee_id")},
            inverseJoinColumns = { @JoinColumn(name = "certificate_id")}
    )
    private Set<Certificate> certificates;

in Certificate Class(Non-Owning side):
   
   @ManyToMany(mappedBy = "certificates",cascade = CascadeType.ALL)
    Set<Employee> employees;
   
    or
   
    @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "EMP_CERT",
                joinColumns = { @JoinColumn(name = "certificate_id")},
                inverseJoinColumns = { @JoinColumn(name = "employee_id")}
        )
        Set<Employee> employees;






