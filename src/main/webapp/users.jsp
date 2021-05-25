<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
    <style>
        body{
            font-family: verdana;
        }

        table {
            width: 500px;

        }

        table, th, td {
            border: 1px solid black;
            padding: 2px;
        }

        th{
            background-color: #00439A;
            color : #FFFFFF;
        }

        tr.odd{
            background-color: #CFCFCF;
        }

        tr.even{
            background-color: #1076F5;
        }
    </style>
</head>
<body>
<h1>Add User Information</h1>

<s:form method="post" action="add">
    <table>
        <tr>
            <td><s:textfield key="label.firstname" name="user.firstName"/></td>
        </tr>
        <tr>
            <td><s:textfield key="label.lastname" name="user.lastName"/></td>
        </tr>
        <tr>
            <td><s:textfield key="label.age" name="user.age"/></td>
        </tr>
        <tr>
            <td><s:textfield key="label.gender" name="user.gender"/></td>
        </tr>
        <tr>
            <td>
                <s:submit key="label.add"></s:submit>
            </td>
        </tr>
    </table>
</s:form>

<h1>User Information</h1>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>
    <s:iterator value="users">
        <tr class="<s:if test="id%2==0">even</s:if><s:else>odd</s:else>">
            <td align="center"><s:property value="id"/></td>
            <td><s:property value="firstName"/></td>
            <td><s:property value="lastName"/></td>
            <td align="center"><s:property value="age"/></td>
            <td><s:if test="gender == 'M'">Male</s:if><s:else>Female</s:else></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
