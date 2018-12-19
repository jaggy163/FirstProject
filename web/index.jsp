<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03.12.2018
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>JavaMail</title>
  </head>
  <body>
    <form action="MailServlet" method="POST">
      <table>
        <tr>
          <td>Send to:</td>
          <td><input type="text" name="to"/></td>
        </tr>
        <tr>
          <td>Subject:</td>
          <td><input type="text" name="subject"/></td>
        </tr>
      </table>
      <hr/>
      <textarea type="text" name="body" rows="5" cols="45">Message Text</textarea>
      <br/><br/>
      <input type="submit" value="Send Message">
    </form>
  </body>
</html>
