package bancolivros;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoLivros {
    protected String servidor;
    protected String banco;
    protected String url;
    protected String usuario;
    protected String senha;
    protected String tabela;
    
    Connection ConexaoLivros;

    public ConexaoLivros() throws SQLException {
        this.servidor = "localhost";
        this.banco = "biblioteca";
        this.url = "jdbc:mysql://" + servidor + "/" + banco;
        this.usuario = "root";
        this.senha = "";
        this.tabela = "livros";
        
        ConexaoLivros = (Connection) DriverManager.getConnection(url, usuario, senha);
    }
}