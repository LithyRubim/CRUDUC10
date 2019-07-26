package bancolivros;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CRUDLivros extends ConexaoLivros {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private String editora;
    private int edicao;
    private Date dataLancamento;
    private Connection conn;

    public CRUDLivros() throws SQLException {
        ConexaoLivros cl = new ConexaoLivros();
        
        this.setConexaoLivros(cl);
    }

    // Setters
    public void setConexaoLivros(ConexaoLivros cl) {
        this.conn = cl.ConexaoLivros;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    public void setEdicao(String edicao){
        this.edicao = Integer.parseInt(edicao);
    }
    
    public void setEditora(String editora){
        this.editora = editora;
    }
    
    public void setDataLancamento(String dataLancamento){
        this.dataLancamento = Date.valueOf(dataLancamento);
    }
    
    
    // Geters
    public int getId() {
        return id;
    }
    
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
    
    public int getEdicao(){
        return edicao;
    }
    
    public String getEditora(){
        return editora;
    }
    
    public Date getDataLancamento(){
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
            this.setId(rs.getInt("id"));
            this.setTitulo(rs.getString("titulo"));
            this.setAutor(rs.getString("autor"));
            this.setGenero(rs.getString("genero"));
           
            stmt.execute();
            stmt.close();
       }
    }
    
    
    //cadastrar dados
    public void cadastrar(String titulo,String autor, String genero, String dataLancamento, String editora, String edicao) throws SQLException{
        this.setTabela("livros");
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setGenero(genero);
        this.setEdicao(edicao);
        this.setEditora(editora);
        this.setDataLancamento(dataLancamento);
        //CRUDLivros crud = new CRUDLivros();
        
        String sql = "INSERT INTO " + this.getTabela() + " (titulo,autor,genero,editora,edicao,dataLancamento) " + " VALUES(?,?,?,?,?,?) ";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1,this.getTitulo());
            stmt.setString(2,this.getAutor());
            stmt.setString(3,this.getGenero());            
            stmt.setString(4,this.getEditora());
            stmt.setInt(5,this.getEdicao());
            stmt.setDate(6,this.getDataLancamento());
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