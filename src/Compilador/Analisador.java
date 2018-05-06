package Compilador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Analisador {
    public String chave[]=new String [100];
    public String pr[]=new String [100];
    public String tipo[]=new String [100];
    public String retorno_erro;
    private boolean valuesSintatico = false;

    
    
    //////// ANALISADO LEXICO ////////
    
    
    
    public boolean lexico(String n) {
        boolean retorno = false;
        int i = 0;
        int j = 0;
        String vet[] = new String[100];
        String token = "";
        String nn="";
        n=n.replace("'","");
        
        try {
            ConexaoBD.conexaoLog("lexico", true, "Iniciando analise lexica");

            //Inicio da analise do codigo SQL
            while (i < n.length()) { //I = Numeros de caracteres
                nn=String.valueOf(n.charAt(i));
                if (n.charAt(i) == ' ') {
                    if (n.charAt(i - 1) != ',' && n.charAt(i - 1) != '(' && n.charAt(i - 1) != ')' ) {
                        if (!"".equals(token)) {    
                        vet[j] = token;
                            token = "";
                            j++;
                        }
                    }
                } else if (n.charAt(i) == ',' || n.charAt(i) == '(' || n.charAt(i) == ')' || n.charAt(i) == ';' || n.charAt(i) == '='  || "'".equals(nn)  ) {
                    if (!token.equals("")  || "'".equals(nn) ) {
                        vet[j] = token;
                        token = "";
                        j++;
                        if  (nn.equals("=") || !"".equals(nn)){
                            vet[j] = nn;
                            token = "";
                            j++;
                        }
                    }else if ( token.equals("")  || !"".equals(nn)){
                       
                            vet[j] = nn;
                            token = "";
                            j++;
                        
                    }else{
                    vet[j] = String.valueOf(n.charAt(i));
                    j++;
                    }
                } else {
                    token = token + n.charAt(i);
                }
                i++;
            }

            if (!token.equals("")) {
                vet[j] = token;
                j++;
                System.out.println("j" + j); //LOG////
            }
            j--;

            ConexaoBD.conexaoLog("lexico", true, "Palavras inseridas analisadas");

            for (i = 0; i <= j; i++) {

                ConexaoBD.conexaoLog("lexico", true, "Conectando ao banco para compara dados");
                ConexaoBD.conexaolec(vet[i], i, this.chave, this.pr, this.tipo);

            }

            retorno = true;

            ConexaoBD.conexaoLog("lexico", true, "Realizando comparacao com os dados do banco");
            ConexaoBD.conexaoLog("lexico", true, "Analisador lexico executado com sucesso");

            return (retorno);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;

    }

    
    
    //////// ANALISADO SINTATICO ////////
    
    
    
    public boolean sintatico(String n) {
        try {
            ConexaoBD.conexaoLog("sintatico", true, "Iniciando a analise sintatica");

            n=n.replace("'","");
            
            for (int u = 0; u < 100; u++) {
                if (pr[u] != null) {
                    if (pr[u].equals(";")) {
                        chave[u] = null;
                        pr[u] = null;
                        tipo[u] = null;
                    }
                }
            }

            ConexaoBD.conexaoLog("sintatico", true, "Identificando comando");
        } catch (SQLException ex) {
            Logger.getLogger(Analisador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return palavraInicial();
    }

    private boolean palavraInicial() {
        for (int u = 0; u<50; u++){
            System.out.println("|" + pr[u] + "|" + chave[u] + "|" + tipo[u] + "|");
        }
        
        
        boolean retorno = false;
        try {
            if (pr[0].equals("SELECT")) {
                ConexaoBD.conexaoLog("sintatico", true, "Executando a analise sintatica do SELECT");
                retorno = sintaticoSELECT(1);
            }
            if (pr[0].equals("INSERT")) {
                valuesSintatico = false;
                ConexaoBD.conexaoLog("sintatico", true, "Executando a analise sintatica do INSERT");
                retorno = sintaticoINSERT(1);
            }
            if (pr[0].equals("DELETE")) {
                ConexaoBD.conexaoLog("sintatico", true, "Executando a analise sintatica do DELETE");
                retorno = sintaticoDELETE(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Analisador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;

    }

    private boolean sintaticoSELECT(int ponteiro) {
        boolean retorno = false;

        try {

            if (pr[ponteiro].equals("*")) {
                retorno = sintaticoAsterisco(ponteiro + 1);
            }
            if (tipo[ponteiro].equals("id")) {
                retorno = sintaticoIdSELECT(ponteiro + 1);
            }
        } catch (java.lang.NullPointerException e) {
        }

        return retorno;
    }

    private boolean sintaticoINSERT(int ponteiro) {
        boolean retorno = false;

        try {
            if (pr[ponteiro].equals("INTO")) {
                if (tipo[ponteiro + 1].equals("id")) {
                    if (pr[ponteiro + 2].equals("(")) {
                        if (tipo[ponteiro + 3].equals("id")) {
                            retorno = sintaticoIdINSERT(ponteiro + 4);
                        }
                    }
                }
            }
        } catch (java.lang.NullPointerException e) {
        }

        return retorno;
    }

    private boolean sintaticoDELETE(int ponteiro) {
        boolean retorno = false;

        try {
            if (pr[ponteiro].equals("FROM")) {
                retorno = sintaticoFROM(ponteiro + 1);
            }
        } catch (java.lang.NullPointerException e) {
        }

        return retorno;
    }

    private boolean sintaticoAsterisco(int ponteiro) {
        boolean retorno = false;

        try {
            if (pr[ponteiro].equals("FROM")) {
                retorno = sintaticoFROM(ponteiro + 1);
            }
        } catch (java.lang.NullPointerException e) {
        }

        return retorno;
    }

    private boolean sintaticoIdSELECT(int ponteiro) {
        boolean retorno = false;

        try {
            System.out.println(ponteiro);
            if (pr[ponteiro].equals(",")) {
                if (tipo[ponteiro + 1].equals("id")) {
                    retorno = sintaticoIdSELECT(ponteiro + 2);
                }
            }
            if (pr[ponteiro].equals("FROM")) {
                retorno = sintaticoFROM(ponteiro + 1);
            }
        } catch (java.lang.NullPointerException e) {
        }

        return retorno;
    }

    private boolean sintaticoIdINSERT(int ponteiro) {
        boolean retorno = false;

        try {
            System.out.println(ponteiro);
            if (pr[ponteiro].equals(")")) {
                if (pr[ponteiro + 1] == null && valuesSintatico) {
                    return true;
                } else {
                    if (pr[ponteiro + 1].equals("VALUES")) {
                        valuesSintatico = true;
                        if (pr[ponteiro + 2].equals("(")) {
                            if (tipo[ponteiro + 3].equals("id")) {
                                retorno = sintaticoIdINSERT(ponteiro + 4);
                            }
                        }
                    }
                }
            }else if (pr[ponteiro+1].equals(",")) {
                if (tipo[ponteiro + 2].equals("id")) {
                    retorno = sintaticoIdINSERT(ponteiro + 2);
                }
            }
            
        } catch (java.lang.NullPointerException e) {
        }

        return retorno;
    }

    private boolean sintaticoFROM(int ponteiro) {
        boolean retorno = false;

        try {
            if (tipo[ponteiro].equals("id")) {
                if (pr[ponteiro + 1] == null) {
                    retorno = true;
                    System.out.println("Final da compilacao em id");
                } else if (pr[ponteiro + 1].equals("WHERE")) {
                    retorno = sintaticoWHERE(ponteiro + 2);
                }
            }
        } catch (java.lang.NullPointerException e) {
        }

        return retorno;
    }

    private boolean sintaticoWHERE(int ponteiro) {
        boolean retorno = false;

        try {
            if (tipo[ponteiro].equals("id")) {
                if ( pr[ponteiro + 1].equals("=") || pr[ponteiro + 1].equals("<") || pr[ponteiro + 1].equals(">") || pr[ponteiro + 1].equals("<>") || pr[ponteiro + 1].equals("LIKE")) {
                    if (tipo[ponteiro + 2].equals("id")) {
                        System.out.println("asd" + pr[ponteiro + 3]);
                        if (pr[ponteiro + 3] == null) {
                            System.out.println(ponteiro);
                            retorno = true;
                            System.out.println("Final da compila��o em WHERE ID = ID");
                        } else if (pr[ponteiro + 3].equals("AND")) {
                            System.out.println("passou aki AND");
                            retorno = sintaticoWHERE(ponteiro + 4);
                        } else if (pr[ponteiro + 3].equals("OR")) {
                            System.out.println("passou aki OR");
                            retorno = sintaticoWHERE(ponteiro + 4);
                        }
                    }
                }
            }
        } catch (java.lang.NullPointerException e) {
        }

        return retorno;
    }
    
    
    
    //////// ANALISADO SEMANTICO ////////   
    
    
     
    public String semantico(String n){
        String ret;
        ret="";
        ConexaoBD con = new ConexaoBD();
        try {
            ret=con.conexaosen(n);
        } catch (SQLException ex) {
            Logger.getLogger(Analisador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TelaPrincipal tela = new TelaPrincipal();
        tela.retorno_erro=ret;
        return (ret);
        
    }
    
}  
