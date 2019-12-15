1. * download hibernate from http://hibernate.org/orm/releases/5.4/
   * add jars from lib/required in classpath
2. * download mysql connector jar from https://dev.mysql.com/downloads/connector/j/
   * add mysql jdbc driver in classpath if hibernate is going to work with mysql

ERROR and solution:
1. ERROR: Field 'employee_id' doesn't have a default value
solution:
primary key identifier employee_id should be set as auto_increment .

2.
ERROR:
Dec 09, 2019 10:28:35 PM org.hibernate.engine.loading.internal.LoadContexts cleanup
WARN: HHH000100: Fail-safe cleanup (collections) : org.hibernate.engine.loading.internal.CollectionLoadContext@1de9d54<rs=Result set representing update count of 3>
Dec 09, 2019 10:28:35 PM org.hibernate.engine.loading.internal.CollectionLoadContext cleanup
WARN: HHH000160: On CollectionLoadContext#cleanup, localLoadingCollectionKeys contained [1] entries

solution:
this kind of error occurs if foreign key is refrencing the row but  index or list-index column is null and hibernate try to do mapping for  list/map.
in case of NULL list-index value(related to <list> tag) ,replace index value to int values like 0,1,2 as they are index position in list.
in case of index column is NULL(related to <map> tag),either remove these rows or  replace it with Non-Null values.

3.
ERROR: Table 'testdb.hibernate_sequence' doesn't exist

solution:
set strategy to Identity in GeneratedValue annotation as given below instead of sequence or auto .

@GeneratedValue(strategy = GenerationType.IDENTITY)

