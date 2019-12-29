<html>

<body>
<h1>${headermsg}</h1>
admission form submitted successfully for student with details:

${student}

<table>
    <tr>
        <td>student id: ${returnId}</td>
    </tr>

    <tr>
        <td>${student.studentName}</td>
    </tr>

    <tr>
        <td>${student.studentContact}</td>
    </tr>

    <tr>
        <td>${student.studentDob}</td>
    </tr>

    <tr>
        <td>${student.studentSkills}</td>
    </tr>

    <tr>
        <td>${student.studentAddress.country}</td>
    </tr>
    <tr>
        <td>${student.studentAddress.state}</td>
    </tr>

    <tr>
        <td>${student.studentAddress.city}</td>
    </tr>

    <tr>
        <td>${student.studentAddress.pin}</td>
    </tr>

</table>


</body>
</html>

