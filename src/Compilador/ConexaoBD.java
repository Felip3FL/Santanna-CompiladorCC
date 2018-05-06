package Compilador;

import java.sql.*;
import java.text.SimpleDateFormat;
import oracle.jdbc.pool.OracleDataSource;

class ConexaoBD {

    public static void conexaolec(String sql, int i,String chave[],String pr[],String tipo[]) throws SQLException {

        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
        ods.setUser("teste");
        ods.setPassword("teste");
        
        Connection conn = ods.getConnection();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();               
            rs = st.executeQuery("SELECT * FROM tbl_lexico WHERE PALAVRA_RESERVADA='" + sql + "'");

//while (rset.next ())
            rs.next();
            int x = rs.getRow();
//if (rset.absolute(1)){
            if (rs.getRow() != 0) {

                chave[i] = rs.getString("CHAVE");
                pr[i] = rs.getString("PALAVRA_RESERVADA");
                tipo[i] = rs.getString("TIPO");
            } else {
                pr[i] = sql;
                tipo[i] = "id";
            }

        } //Close the result set, statement, and the connection
        finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    public String conexaosen(String sql) throws SQLException {

System.out.println(sql);
String xxx;
int linha=1;
int i;
xxx="";
        OracleDataSource ods = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
// Create DataSource and connect to the local database
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
        ods.setUser("teste");
        ods.setPassword("teste");
        conn = ods.getConnection();

        Analisador analisador = new Analisador();
        try {
// Query the employee names
            System.out.println("Executou a query = " + sql);
            stmt = conn.createStatement();
//rset = stmt.executeQuery ("INSERT INTO teste VALUES('ANDRÉ PERRETTO','Rua Dr. Morais Dantas','Limão',1)");//("SELECT * FROM TESTE");
            rset = stmt.executeQuery(sql);

            rset.next();
            int x = rset.getRow();
                    
            
            if (rset.getRow() != 0) {
                //return(rset)
                //rset.findColumn(sql);

                
                if (sql.charAt(0) == 'S'){
                    
                
                    while(rset.next()==true){
                        linha=rset.getRow();
                    }
                    rset.close();
                    rset = stmt.executeQuery(sql);
                    rset.next();
                    //linha=rset.getFetchSize();

                    ResultSetMetaData rsmd = rset.getMetaData();  
                    int numColumns = rsmd.getColumnCount();  
                    int j;
                    j=1;
                    i=1;
                    for(j = 1; j <= numColumns; j++){ 
                        xxx=xxx + rsmd.getColumnName(j) + " | ";   
                    }

                    xxx=xxx + "\n";

                    for(i = 1; i <= linha; i++){
                        for(j = 1; j <= numColumns; j++){ 
                            xxx=xxx + rset.getString(j) + " | ";
                        }
                        rset.next();
                        xxx=xxx + "\n";
                    }
                    
                }else if (sql.charAt(0) == 'D'){
                    xxx="Registro deletado com sucesso.";
                }else{
                
                xxx="Registro inserido com sucesso.";
                }
                return(xxx);
        } //Close the result set, statement, and the connection
            
        }catch (Exception e) {
            
         xxx=e.toString();  
         return(xxx);
    }  
        finally {
            rset=stmt.getResultSet();
            if (rset != null) {
                rset.close();
            }else{
                
            }
            
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            
        }
       return(xxx);
    }
    
    public static void conexaoLog(String metodo, boolean acao, String descricao) throws SQLException {

        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
        ods.setUser("teste");
        ods.setPassword("teste");

        Connection conn = ods.getConnection();
        Statement st = null;
        ResultSet rs = null;

        java.util.Date data = new java.util.Date();
        SimpleDateFormat hora = new SimpleDateFormat("yyyy-MM-dd:HH.mm.ss");

        String mensagem;
        if (acao == true) {
            mensagem = "Sucesso";
        } else {
            mensagem = "Falha";
        }

        try {
            st = conn.createStatement();
            rs = st.executeQuery("INSERT INTO tbl_log VALUES ('" + hora.format(data) + "','" + metodo + "','" + mensagem + "','" + descricao + "')");
            rs.next();
            int x = rs.getRow();

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
}