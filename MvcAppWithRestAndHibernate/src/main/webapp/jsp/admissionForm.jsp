
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<title>
    admission form
</title>

<body>
    <h1> Student Admission Form</h1>
    <form:errors path="student.*" />
    <form action="http://localhost:8080/MvcAppWithRestAndHibernate/submitAdmissionForm.html" method="post">
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
            <td> <input type="submit" value="submit by clicking here"/></td>
        </tr>

</table>




</form>
</body>

</html>