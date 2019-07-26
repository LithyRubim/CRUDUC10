package bancolivros;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CRUDLivros extends ConexaoLivros {
    private int id;
    private String titulo;
    private String autor;
    private String genero;

    public CRUDLivros() throws SQLException {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public Connection getConexaoLivros() {
        return ConexaoLivros;
    }
    //pesquisa
    public void pesquisa(String txt) throws SQLException {
       CRUDLivros crud = new CRUDLivros();
       String sql = "SELECT * FROM "+ this.tabela+" WHERE titulo LIKE ?";
       PreparedStatement stmt = crud.ConexaoLivros.prepareStatement(sql);
       stmt.setString(1,"%" + txt + "%");
       stmt.execute();
       stmt.close();
        
       ResultSet rs = stmt.getResultSet();
       while(rs.next()){
           this.setId(rs.getInt("idLivro"));
           this.setTitulo(rs.getString("titulo"));
           this.setAutor(rs.getString("autor"));
           this.setGenero(rs.getString("genero"));
           
           stmt.execute();
            stmt.close();
       }
    }
    //cadastrar dados
    public void cadastrar(String titulo,String autor, String genero) throws SQLException{
       this.setTitulo(titulo);
       this.setAutor(autor);
       this.setGenero(genero);
       CRUDLivros crud = new CRUDLivros();
       String sql = "INSERT INTO " + this.tabela + " (titulo,autor,genero) " + " VALUES(?,?,?) ";
       
        try (PreparedStatement stmt = crud.ConexaoLivros.prepareStatement(sql)) {
            stmt.setString(1,this.getTitulo());
            stmt.setString(2,this.getAutor());
            stmt.setString(3,this.getGenero());
                
            stmt.execute();
            stmt.close();
        }
    }
    //excluir dados
    public void excluir(int id) throws SQLException {
       CRUDLivros crud = new CRUDLivros();
       String sql = "DELETE FROM "+ this.tabela+" WHERE idContato = ?";
       PreparedStatement stmt = crud.ConexaoLivros.prepareStatement(sql);
       stmt.setInt(1,id);
       stmt.execute();
       stmt.close();
    }    
}