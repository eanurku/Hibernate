
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<title>
    admission form
</title>

<body>
    <h1> Student Admission Form</h1>
    <form:errors path="student.*" />
    <form action="http://localhost:8080/MvcAppWithRestAndHibernateIntegratedBySpringORM/submitAdmissionForm.html" method="post">
    <table>

        <tr>
            <td> Student name:</td>
             <td> <input type="text" name="studentName"/></td>
        </tr>

        <tr>
            <td> student contact no:</td>
            <td> <input type="text" name="studentContact"/> </td>
        </tr>
        <tr>
            <td> student dob:</td>
            <td> <input type="date" name="studentDob"/> </td>
        </tr>

        <tr>
            <td> student skills:</td>
             <td>
            <select name="studentSkills" multiple>
            <option value="java">java progg</option>
            <option value="cpp">c plus plus</option>
            <option value="php">php progg</option>
            <option value="c">c progg </option>
            </select>
            </td>
        </tr>

        <tr>
            <td>student address :</td>
            <td>country:</td> <td> <input type="text" name="studentAddress.country"/> </td>
            <td>state:</td> <td> <input type="text" name="studentAddress.state"/> </td>
            <td>city:</td> <td> <input type="text" name="studentAddress.city"/> </td>
            <td>pin:</td> <td> <input type="text" name="studentAddress.pin"/> </td>
        </tr>


        <tr>
            <td> <input type="submit" value="submit by clicking here"/></td>
        </tr>


</table>




</form>
</body>

</html>