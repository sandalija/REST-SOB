<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database SQL Load</title>
    </head>
    <style>
        .error {
            color: red;
        }
        pre {
            color: green;
        }
    </style>
    <body>
        <h2>Database SQL Load</h2>
        <%
            /* How to customize:
             * 1. Update the database name on dbname.
             * 2. Create the list of tables, under tablenames[].
             * 3. Create the list of table definition, under tables[].
             * 4. Create the data into the above table, under data[]. 
             * 
             * If there is any problem, it will exit at the very first error.
             */
            String dbname = "homework1";
            String schema = "ROOT";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            /* this will generate database if not exist */
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbname, "root", "root");
            Statement stmt = con.createStatement();
            
            /* inserting data */
            /* you have to exclude the id autogenerated from the list of columns if you have use it. */
            String data[] = new String[]{
                "INSERT INTO " + schema + ".COMMENT VALUES (NEXT VALUE FOR COMMENT_GEN, 'Skeleton code')",
                "INSERT INTO " + schema + ".COMMENT VALUES (NEXT VALUE FOR COMMENT_GEN, 'for homework1')",
                "INSERT INTO " + schema + ".ROOM (ROOM_ID, LOCATION, ADDRESS, SIMPLE, EXTERIOR,  "
                    + "MOBLADA, PRICE, SEXE, MIN_EDAT, MAX_EDAT, FUMADOR, "
                    + "MASCOTES, DESCRIPTION, IMG) VALUES (NEXT VALUE FOR Room_Gen, "
                    + "'Tarragona', 'Placa', 0, 1,"
                    + "1, 200, 'DONA', 0, 99, 1, 1, 'HOLA', 'https://st.hzcdn.com/fimgs/36110e0a0f877044_0838-w144-h144-b0-p0--modern-living-room.jpg')", 
                "INSERT INTO " + schema + ".ROOM (ROOM_ID, LOCATION, ADDRESS, SIMPLE, EXTERIOR,  "
                    + "MOBLADA, PRICE, SEXE, MIN_EDAT, MAX_EDAT, FUMADOR, "
                    + "MASCOTES, DESCRIPTION) VALUES (NEXT VALUE FOR Room_Gen, "
                    + "'Tarragona', 'Placa', 1, 1,"
                    + "1, 600, 'DONA', 0, 99, 1, 1, 'HOLA')",
                "INSERT INTO " + schema + ".ROOM (ROOM_ID, LOCATION, ADDRESS, SIMPLE, EXTERIOR,  "
                    + "MOBLADA, PRICE, SEXE, MIN_EDAT, MAX_EDAT, FUMADOR, "
                    + "MASCOTES, DESCRIPTION) VALUES (NEXT VALUE FOR Room_Gen, "
                    + "'Tarragona', 'Placa', 1, 1,"
                    + "1, 600, 'DONA', 0, 99, 1, 1, 'HOLA')",
                "INSERT INTO " + schema + ".ROOM (ROOM_ID, LOCATION, ADDRESS, SIMPLE, EXTERIOR,  "
                    + "MOBLADA, PRICE, SEXE, MIN_EDAT, MAX_EDAT, FUMADOR, "
                    + "MASCOTES, DESCRIPTION) VALUES (NEXT VALUE FOR Room_Gen, "
                    + "'Reus', 'Avinguda', 1, 1,"
                    + "1, 168, 'Unisex', 20, 99, 0, 0, 'Apta per cadira de rodes')",
                "INSERT INTO " + schema + ".ROOM (ROOM_ID, LOCATION, ADDRESS, SIMPLE, EXTERIOR,  "
                    + "MOBLADA, PRICE, SEXE, MIN_EDAT, MAX_EDAT, FUMADOR, "
                    + "MASCOTES, DESCRIPTION) VALUES (NEXT VALUE FOR Room_Gen, "
                    + "'Tarragona', 'Placa', 1, 1,"
                    + "1, 200, 'UNISEX', 0, 99, 1, 1, 'Garage')",
                "INSERT INTO " + schema + ".ROOM (ROOM_ID, LOCATION, ADDRESS, SIMPLE, EXTERIOR,  "
                    + "MOBLADA, PRICE, SEXE, MIN_EDAT, MAX_EDAT, FUMADOR, "
                    + "MASCOTES, DESCRIPTION) VALUES (NEXT VALUE FOR Room_Gen, "
                    + "'Tarragona', 'Carrer', 1, 1,"
                    + "1, 98, 'UNISEX', 0, 99, 1, 1, 'Àtic de primera clase')",
                "INSERT INTO " + schema + ".ROOM (ROOM_ID, LOCATION, ADDRESS, SIMPLE, EXTERIOR,  "
                    + "MOBLADA, PRICE, SEXE, MIN_EDAT, MAX_EDAT, FUMADOR, "
                    + "MASCOTES, DESCRIPTION) VALUES (NEXT VALUE FOR Room_Gen, "
                    + "'Tarragona', 'Plaça', 1, 0,"
                    + "1, 72, 'HOME', 0, 50, 1, 1, 'Centrica')", 
                "INSERT INTO " + schema + ".TENANT (TENANT_ID, NAME, EMAIL, PHONE, "
                    + "EDAT, SEXE, MASCOTES, FUMADOR) VALUES (213, 'PEPE',"
                    + " 'mail@mail.com', '+34777666888', 50, 'HOME', 1, 0)",
                "INSERT INTO " + schema + ".TENANT (TENANT_ID, NAME, EMAIL, PHONE, "
                    + "EDAT, SEXE, MASCOTES, FUMADOR) VALUES (500, 'Susan',"
                    + " 'mail@mail.com', '+34777666888', 50, 'DONA', 1, 0)" ,
                "INSERT INTO " + schema + ".TENANT (TENANT_ID, NAME, EMAIL, PHONE, "
                    + "EDAT, SEXE, MASCOTES, FUMADOR) VALUES (1, 'Susana',"
                    + " 'mail2@mail.com', '+34777666888', 20, 'DONA', 0, 0)" ,
                "INSERT INTO " + schema + ".TENANT (TENANT_ID, NAME, EMAIL, PHONE, "
                    + "EDAT, SEXE, MASCOTES, FUMADOR) VALUES (151, 'PEPE',"
                    + " 'mail3@mail.com', '+34777666888', 55, 'HOME', 1, 0)" ,
                "INSERT INTO " + schema + ".TENANT (TENANT_ID, NAME, EMAIL, PHONE, "
                    + "EDAT, SEXE, MASCOTES, FUMADOR) VALUES (650, 'Karim',"
                    + " 'mail5@mail.com', '+34777666888', 32, 'HOME', 0, 0)" ,
                "INSERT INTO " + schema + ".TENANT (TENANT_ID, NAME, EMAIL, PHONE, "
                    + "EDAT, SEXE, MASCOTES, FUMADOR) VALUES (202, 'Mike',"
                    + " 'mail6@mail.com', '+34777666888', 19, 'HOME', 1, 1)" ,
                "INSERT INTO " + schema + ".USUARI (USUARI_ID, USERNAME, PASSWORD, " 
                       + "TENANT_ID) VALUES (1, 'sob', 'sob', 0)"
            };
            for (String datum : data) {
                if (stmt.executeUpdate(datum)<=0) {
                    out.println("<span class='error'>Error inserting data: " + datum + "</span>");
                    return;
                }
                out.println("<pre> -> " + datum + "<pre>");
            }
        %>
        <button onclick="window.location='<%=request.getSession().getServletContext().getContextPath()%>'">Go home</button>
    </body>
</html>
