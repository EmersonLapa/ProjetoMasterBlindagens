package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.bean.OrdemDeServico;

public class OrdemDeServicoDAO {
    
    private Connection con = null;

    public OrdemDeServicoDAO() {
        con = ConnectionFactory .getConnection ();
        
    }
    
    public boolean save (OrdemDeServico ordemDeServico){
        
        String sql = "INSERT INTO ordemDeServico (os,dia,modelo) VALUES (?,?,?)";
        PreparedStatement stmt = null;  
        
        try { 
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,ordemDeServico.getOs());
            stmt.setInt(2,ordemDeServico.getDia());
            stmt.setString(3, ordemDeServico.getModelo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
            return true;
        } 
        catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
            return false;
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean update (OrdemDeServico ordemDeServico){
        
        String sql = "UPDATE ordemDeServico SET os = ?, dia = ?, modelo = ? WHERE os = ?";
        PreparedStatement stmt = null;  
        
        try { 
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,ordemDeServico.getOs());
            stmt.setInt(2,ordemDeServico.getDia());
            stmt.setString(3, ordemDeServico.getModelo());
            stmt.setInt(4, ordemDeServico.getOs());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso! ");
            return true;
        } 
        catch (SQLException ex) {
           
           JOptionPane.showMessageDialog(null, "Erro ao atualizar " +ex);
            return false;
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List <OrdemDeServicoDAO> listagem (){
        Connection con = ConnectionFactory .getConnection ();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <OrdemDeServicoDAO> carros = new ArrayList <>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM ordemdeservico");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                OrdemDeServico os = new OrdemDeServico();
                
                os.setOs(rs.getInt("os"));
                os.setDia(rs.getInt("dia"));
                os.setModelo(rs.getString("modelo"));
                os.add(carros);
            }
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(OrdemDeServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return carros;
    }
    
}
