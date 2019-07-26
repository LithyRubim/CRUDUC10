package bancolivros;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CRUDLivros extends ConexaoLivros {
    private String titulo;
    private String autor;
    private String genero;
    private String editora;
    private String dataLancamento;
    private Connection conn;

    public CRUDLivros() throws SQLException {
        
    }

    // Setters
    public void setConexaoLivros(ConexaoLivros cl) {
        this.conn = cl.ConexaoLivros;
    }
        
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setTabela(String tabela) {
        this.tabela = tabela;
    }
        
    public void setEditora(String editora){
        this.editora = editora;
    }
    
    public void setDataLancamento(String dataLancamento){
        this.dataLancamento = dataLancamento;
    }
    
    
    // Geters
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public String getServidor() {
        return servidor;
    }
    
    public String getBanco() {
        return banco;
    }

    public String getUrl() {
        return url;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public String getTabela() {
        return tabela;
    }
    
    public Connection getConexaoLivros() {
        return conn;
    }    
    
    public String getEditora(){
        return editora;
    }
    
    public String getDataLancamento(){
        return dataLancamento;
    }
    
    //pesquisa
    public void pesquisa(String txt) throws SQLException {
        CRUDLivros crud = new CRUDLivros();
        String sql = "SELECT * FROM "+ this.tabela+" WHERE titulo LIKE ?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1,"%" + txt + "%");
        stmt.execute();
        stmt.close();

        ResultSet rs = stmt.getResultSet();
        while(rs.next()){
            this.setTitulo(rs.getString("titulo"));
            this.setAutor(rs.getString("autor"));
            this.setGenero(rs.getString("genero"));
            stmt.execute();
            stmt.close();
       }
    }
    
    /*public List<Registros> listar() throws SQLException {
        CRUDLivros crud = new CRUDLivros();
        String sql = "SELECT * FROM "+ this.getTabela()+"";
        PreparedStatement stmt = crud.ConexaoLivros.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        ResultSet rs = stmt.getResultSet();
        return rs;
    }*/
    
    //cadastrar dados
    public void cadastrar(String titulo,String autor, String genero, String dataLancamento, String editora) throws SQLException{
        this.setTabela("livros");
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setGenero(genero);
        this.setEditora(editora);
        this.setDataLancamento(dataLancamento);
        
        //System.out.println(this.edicao);
        CRUDLivros crud = new CRUDLivros();
        
        String sql = "INSERT INTO " + this.getTabela() + " (titulo,autor,genero,editora,dataLancamento) " + " VALUES(?,?,?,?,?) ";
        
        try (PreparedStatement stmt = crud.ConexaoLivros.prepareStatement(sql)) {
            stmt.setString(1,this.getTitulo());
            stmt.setString(2,this.getAutor());
            stmt.setString(3,this.getGenero());            
            stmt.setString(4,this.getEditora());
            stmt.setString(5,this.getDataLancamento());            
            stmt.execute();
            stmt.close();
        }
    }
     
}